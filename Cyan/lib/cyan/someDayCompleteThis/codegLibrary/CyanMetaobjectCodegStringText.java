package meta.codegLibrary;


import java.awt.Frame;
import java.nio.charset.StandardCharsets;
import meta.AnnotationArgumentsKind;
import meta.CyanMetaobjectWithAtCodeg;
import meta.IAction_dsa;
import meta.ICodeg;
import meta.ICompiler_ded;
import meta.ICompiler_dsa;

public class CyanMetaobjectCodegStringText extends CyanMetaobjectWithAtCodeg implements ICodeg, IAction_dsa {

	private String newFirstParameter = null;

	@Override
	public String getNewFirstParameter() {
		return newFirstParameter;
	}

	public CyanMetaobjectCodegStringText() {
		super("stringText", AnnotationArgumentsKind.OneParameter);
	}

	@Override
	public StringBuffer dsa_codeToAdd(ICompiler_dsa compiler_dsa) {
		//String expression = "\"" + Lexer.escapeJavaString(new String(this.getMetaobjectAnnotation().getCodegInfo(), StandardCharsets.UTF_8)) + "\"";
		String expression = "\"" + new String(this.getMetaobjectAnnotation().getCodegInfo(), StandardCharsets.UTF_8) + "\"";
		return new StringBuffer(expression);
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
		/*
		 * inside a Codeg one can access the current prototype by calling
		 * this.getMetaobjectCall().getProgramUnit()
		 *
		 * the list of local variables visible at the point of declaration is
		 * given by this.getMetaobjectCall().getLocalVariableNameList()
		 */

		String firstParameter = (String) this.getMetaobjectAnnotation().getJavaParameterList().get(0);
		CodegStringTextGUI codegGUI = new CodegStringTextGUI(new Frame(), previousCodegFileText, firstParameter);
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
