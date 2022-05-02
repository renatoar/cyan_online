package meta.codegLibrary;


import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import meta.AnnotationArgumentsKind;
import meta.CyanMetaobjectWithAtCodeg;
import meta.IAction_dsa;
import meta.ICodeg;
import meta.ICompiler_ded;
import meta.ICompiler_dsa;
import meta.lexer.MetaLexer;

public class CyanMetaobjectCodegLatex extends CyanMetaobjectWithAtCodeg implements ICodeg, IAction_dsa {

	private String newFirstParameter = null;

	@Override
	public String getNewFirstParameter() {
		return newFirstParameter;
	}

	public CyanMetaobjectCodegLatex() {
		super("latex", AnnotationArgumentsKind.OneParameter);
	}

	@Override
	public StringBuffer dsa_codeToAdd(ICompiler_dsa compiler_dsa) {
		String filePath = new String(this.getMetaobjectAnnotation().getCodegInfo(), StandardCharsets.UTF_8);
		String codeAdd = "";
		try {
			FileReader arq = new FileReader(filePath);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();
			if (linha != null)
				codeAdd += linha + "\n";

			while (linha != null) {
				linha = lerArq.readLine();
				if (linha != null) {
					codeAdd += linha + "\n";
				}
			}

			arq.close();
		} catch (IOException e) {

		}
		codeAdd = "\"" + MetaLexer.escapeJavaString(toCyanCode(codeAdd)) + "\"";
		return new StringBuffer(codeAdd);
	}

	private String toCyanCode(String expression) {
		expression = expression.replace("\\\\", ";");
		expression = expression.replace("\\sin", "Math sin:");
		expression = expression.replace("\\cos", "Math cos:");
		expression = expression.replace("\\sqrt", "Math sqrt:");

		return expression;
	}

	@Override
	public String getPackageOfType() {
		return "cyan.lang";
	}

	@Override
	public String getPrototypeOfType() {
		return "Int";
	}

	@Override
	public byte[] getUserInput(ICompiler_ded compiler_ded, byte[] previousCodegFileText) {
		/*
		 * inside a Codeg one can access the current prototype by calling
		 * this.getMetaobjectCall().getProgramUnit()
		 *
		 * the list of local variables visible at the point of declaration is
		 * given by this.getMetaobjectCall().getLocalVariableNameList()
		 */

		String firstParameter = (String) this.getMetaobjectAnnotation().getJavaParameterList().get(0);
		CodegLatexGUI codegGUI = new CodegLatexGUI(new Frame(), previousCodegFileText, firstParameter);
		codegGUI.setVisible(true);
		byte[] userInput = codegGUI.getUserInput();
		if ( ! codegGUI.getLabel().equals(firstParameter) ) {
		    newFirstParameter = codegGUI.getLabel();
		}
		codegGUI = null;
		return userInput;

	}

	@Override
	public boolean isExpression() {
		return true;
	}

	@Override
	public String newCodegAnnotation() {
		if ( getNewFirstParameter() == null ) {
			return null;
		}
		else {
			return this.getMetaobjectAnnotation().newAnnotationText(getNewFirstParameter());
		}
	}


}
