package meta.codegLibrary;

import java.awt.Frame;
import java.io.ByteArrayInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import meta.CyanMetaobjectLiteralString;
import meta.ICodeg;
import meta.ICompilerAction_dpa;
import meta.ICompiler_ded;
import meta.ICompiler_dsa;
import meta.IParseWithoutCyanCompiler_dpa;
import meta.MetaHelper;
import meta.WrEnv;
import nu.xom.Builder;
import nu.xom.ParsingException;

public class CyanMetaobjectLiteralStringXML extends CyanMetaobjectLiteralString
implements ICodeg, IParseWithoutCyanCompiler_dpa  {

	public CyanMetaobjectLiteralStringXML() {
		super(new String[] { "xml", "XML" });
	}

	@Override
	public void dpa_parse(ICompilerAction_dpa compilerAction, String code) {

		try {
			nu.xom.Builder parser = new Builder();
			InputStream targetStream = new ByteArrayInputStream(code.getBytes());
			PrintStream oldErr = System.err;

			try (PrintStream newErr = new PrintStream(new  FilterOutputStream(oldErr)     {
				@Override
				public void write(byte[] b, int off, int len) throws IOException { }
			})
					) {
				System.setErr( newErr );

			}
			catch ( Throwable e ) {

			}
			parser.build(targetStream); // .getRootElement().getAttribute(0).getLocalName();

			System.setErr(oldErr);
		}
		catch (ParsingException ex) {
			compilerAction.error(ex.getLineNumber() + this.getMetaobjectAnnotation().getFirstSymbol().getLineNumber() - 1,
					ex.getColumnNumber(), ex.getMessage());
		}
		catch (IOException ex) {
			this.addError("Error when analyzing a XML string");
		}

		StringBuffer s = new StringBuffer();
		int i = 1;
		char ch = code.charAt(0);
		int codeSize = code.length();
		while ( (Character.isSpaceChar( (int) ch) || ch == '\r' || ch == '\n') && i < codeSize ) {
			ch = code.charAt(i);
			++i;
		}
		s.append(code.substring(i-1));
		i = s.length() - 1;
		ch = s.charAt(i);
		while ( (Character.isSpaceChar( (int) ch) || ch == '\r' || ch == '\n') && i >= 0) {
			s.deleteCharAt(i);
			--i;
			ch = s.charAt(i);
		}



		String tmpVar = MetaHelper.nextIdentifier();
		String tmpVarIS = MetaHelper.nextIdentifier();
		String tmpVarStr = MetaHelper.nextIdentifier();
		codeToGenerate = new StringBuffer( " { let " + tmpVar + " = Builder();\r\n"
				+ "    let java.lang.String " + tmpVarStr + " = \"\"\"" + s + "\"\"\";\r\n"
				+ "    var InputStream " + tmpVarIS + " = ByteArrayInputStream(" + tmpVarStr + " getBytes); "
				+ "    ^" + tmpVar + " build: " + tmpVarIS + ";\r\n"
						+  " } eval ")  ;
	}

	@Override
	public StringBuffer dsa_codeToAdd(ICompiler_dsa compiler_dsa) {
		WrEnv env = compiler_dsa.getEnv();
		boolean ok = true;
		String []importList = { "java.io.InputStream", "java.io.ByteArrayInputStream", "java.io.FilterOutputStream",
				"java.io.PrintStream", "nu.xom.Builder", "nu.xom.Document", "nu.xom.ParsingException"
				};
		for ( String anImport : importList ) {
			if ( ! env.wasJavaClassImported(anImport) ) {
				ok = false;
				break;
			}
		}

		if ( ! ok ) {
			String s = "";
			int size = importList.length;
			for ( String anImport : importList ) {
				s += anImport;
				if ( --size > 0 ) { s += ", "; }
				if ( size == 1 ) { s += "and, "; }
			}
			this.addError("Metaobject literal string '" + this.getName() +
					"' demands that the Java classes " + s + " are imported "
					+ "in the current source code");
			return null;
		}

		compiler_dsa.createNewGenericPrototype(this.getMetaobjectAnnotation().getFirstSymbol(),
				env.getCurrentCompilationUnit(), env.getCurrentProgramUnit(),
				MetaHelper.cyanLanguagePackageName + ".Function<nu.xom.Document>",
		            "Error caused by method dsa_codeToAdd of metaobject '" +
		            		this.getMetaobjectAnnotation().getCyanMetaobject().getName() + "'. "
		            );
		return this.codeToGenerate;
	}

	@Override
	public String getPackageOfType() {
		return "nu.xom";
	}
	@Override
	public String getPrototypeOfType() {
		return "Document";
	}

	@Override
	public byte[] getUserInput(ICompiler_ded compiler_ded, byte[] previousCodegFileText) {
		code = "";
		CodegLiteralStringXMLGUI codegGUI = new CodegLiteralStringXMLGUI(new Frame(), previousCodegFileText, null);
		byte[] userInput = codegGUI.getUserInput();
		code = new String(userInput);

		codegGUI = null;
		return null;
	}


	@Override
	public boolean demandsLabel() {
		return false;
	}

	/**
	 * the text that should replace the Codeg annotation, including the attached DSL
	 */
	@Override
	public String newCodegAnnotation() {
		return code + "xml";
	}

	@Override
	public int getStartOffset() {
		return this.getMetaobjectAnnotation().getFirstSymbol().getOffset();
	}

	@Override
	public int getEndOffset() {
		return this.getMetaobjectAnnotation().getLastSymbol().getOffset();
	}

	/**
	 * code to be generated
	 */
	private StringBuffer codeToGenerate;
	private String code;



}

