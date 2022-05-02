package meta.codegLibrary;

import java.awt.Frame;
import java.util.ArrayList;
import meta.AnnotationArgumentsKind;
import meta.CyanMetaobject;
import meta.CyanMetaobjectWithAtCodeg;
import meta.DirectoryKindPPP;
import meta.IAbstractCyanCompiler;
import meta.IAction_dsa;
import meta.ICodeg;
import meta.ICompiler_ded;
import meta.ICompiler_dsa;
import meta.WrCyanMetaobjectWithAtAnnotation;

public class CyanMetaobjectCodegCyan extends CyanMetaobjectWithAtCodeg implements ICodeg, IAction_dsa {

	private String newFirstParameter = null;

	public CyanMetaobjectCodegCyan() {
		super("cyan", AnnotationArgumentsKind.OneOrMoreParameters);
	}

	@Override
	public String getNewFirstParameter() {
		return newFirstParameter;
	}

	@Override
	public StringBuffer dsa_codeToAdd(ICompiler_dsa compiler_dsa) {
		ArrayList<Object> javaParamList = this.getMetaobjectAnnotation().getJavaParameterList();
		if ( javaParamList.size() > 1 ) {
			StringBuffer sb = new StringBuffer();
			//if ( ! fillVarNameList(javaParamList) ) { return null; }
			for(int i = 1; i < javaParamList.size(); ++i) {
				Object obj = javaParamList.get(i);
				String varName = CyanMetaobject.removeQuotes((String ) obj);
				if ( compiler_dsa.searchLocalVariable(varName) == null ) {
					this.addError("Variable '" + varName + "' was not found");
					return null;
				}

				WrCyanMetaobjectWithAtAnnotation annotation = this.getMetaobjectAnnotation();
				final String filename = compiler_dsa.escapeString(getFilenameVar(compiler_dsa, varName, annotation));

				sb.append("    ContainerForSerialize saveVariable: " + varName + ", \"" + filename + "\";\n");
				//sb.append("(SerializeContainer new: " + varName + ") save: " + filename + ";\n");

				// SerializeContainer new:
				/*
				 *

				 */
			}
			return sb;
		}
		return null;

	}


	@Override
	public String getPackageOfType() {
		return "cyan.lang";
	}

	@Override
	public String getPrototypeOfType() {
		return "String";
	}

	@Override
	public byte[] getUserInput(ICompiler_ded compiler_ded, byte[] previousCodegFileText) {

		String firstParameter = (String) this.getMetaobjectAnnotation().getJavaParameterList().get(0);
		WrCyanMetaobjectWithAtAnnotation annot = this.getMetaobjectAnnotation();
		CodegCyanGUI codegGUI = new CodegCyanGUI(new Frame(), previousCodegFileText, firstParameter, compiler_ded, annot);
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

	@Override
	public int getStartOffset() {
		return 0;
	}

	@Override
	public int getEndOffset() {
		return 0;
	}

	private static String getFilenameVar(IAbstractCyanCompiler compiler, String varName,
			WrCyanMetaobjectWithAtAnnotation annotation) {
		return compiler.getPathFileHiddenDirectory(
				annotation.getPrototypeOfAnnotation(),
				annotation.getPackageOfAnnotation(),
				DirectoryKindPPP.TMP) +  "keepValue_" + varName + ".txt";
	}

}
