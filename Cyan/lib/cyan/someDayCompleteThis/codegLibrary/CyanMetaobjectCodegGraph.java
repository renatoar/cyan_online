package meta.codegLibrary;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import meta.AnnotationArgumentsKind;
import meta.CyanMetaobjectWithAtCodeg;
import meta.IAction_dsa;
import meta.ICodeg;
import meta.ICompiler_ded;
import meta.ICompiler_dsa;

public class CyanMetaobjectCodegGraph extends CyanMetaobjectWithAtCodeg implements ICodeg, IAction_dsa  {

	private String newFirstParameter = null;

	@Override
	public String getNewFirstParameter() {
		return newFirstParameter;
	}


	public CyanMetaobjectCodegGraph() {
		super("graph", AnnotationArgumentsKind.OneParameter);

	}

	@Override
	public StringBuffer dsa_codeToAdd(ICompiler_dsa compiler_dsa) {

		String sCode = new String(this.getMetaobjectAnnotation().getCodegInfo(), StandardCharsets.UTF_8);
		String[] code = sCode.split("\n");
		StringBuffer codeAdd = null;
		if (code.length > 1) {
			GraphModel graph = new GraphModel(code[0]);
			Boolean directed = code[1].equals("true");
			graph.setDirected(directed);

			codeAdd = graph.getGraphData();
		}
		return codeAdd;
	}

	@Override
	public String getPackageOfType() {
		return "cyan.lang";
	}

	@Override
	public String getPrototypeOfType() {
       return "Tuple<directed,Boolean,vertices,Array<String>,edges,Array<Tuple<String,String,String>>>";
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

        Locale.setDefault(new Locale("en","US"));
		String firstParameter = (String) this.getMetaobjectAnnotation().getJavaParameterList().get(0);
		GraphControllerDraw codegGUI = new GraphControllerDraw(previousCodegFileText, firstParameter);
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
