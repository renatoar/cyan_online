package meta.codegLibrary;


import java.awt.Frame;
import meta.AnnotationArgumentsKind;
import meta.CyanMetaobjectWithAtCodeg;
import meta.IAction_dsa;
import meta.ICodeg;
import meta.ICompiler_ded;
import meta.ICompiler_dsa;

public class CyanMetaobjectCodegCommand extends CyanMetaobjectWithAtCodeg implements ICodeg, IAction_dsa {

	private String newFirstParameter = null;

	@Override
	public String getNewFirstParameter() {
		return newFirstParameter;
	}

	public CyanMetaobjectCodegCommand() {
		super("cmd", AnnotationArgumentsKind.OneParameter);
	}

	@Override
	public StringBuffer dsa_codeToAdd(ICompiler_dsa compiler_dsa) {
		return null;
	}


	@Override
	public byte[] getUserInput(ICompiler_ded compiler_ded, byte[] previousCodegFileText) {

		String firstParameter = (String) this.getMetaobjectAnnotation().getJavaParameterList().get(0);
		CodegCommandGUI codegGUI = new CodegCommandGUI(new Frame(), previousCodegFileText, firstParameter);
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
		return false;
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
