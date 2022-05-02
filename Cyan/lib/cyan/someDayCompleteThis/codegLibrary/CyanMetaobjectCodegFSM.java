package meta.codegLibrary;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import meta.AnnotationArgumentsKind;
import meta.CyanMetaobjectWithAtCodeg;
import meta.IAction_dsa;
import meta.ICodeg;
import meta.ICompiler_ded;
import meta.ICompiler_dsa;

public class CyanMetaobjectCodegFSM extends CyanMetaobjectWithAtCodeg implements ICodeg, IAction_dsa  {

	private String newFirstParameter = null;

	@Override
	public String getNewFirstParameter() {
		return newFirstParameter;
	}


	public CyanMetaobjectCodegFSM() {
		super("fsm", AnnotationArgumentsKind.OneParameter);

	}

	@Override
	public StringBuffer dsa_codeToAdd(ICompiler_dsa compiler_dsa) {
		byte[] code = this.getMetaobjectAnnotation().getCodegInfo();

		StringBuffer codeAdd = null;

		if (code == null)
			return null;

		try {
			FSMData data = (FSMData) deserialize(code);
			if (data != null)
				codeAdd = data.getStrFSMData();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}

		return codeAdd;
	}

	@Override
	public String getPackageOfType() {
		return "cyan.lang";
	}

	@Override
	public String getPrototypeOfType() {
		return "Tuple<initialState,String,finalStates,Array<String>,states,Array<String>,transitions,Array<Tuple<String,String,String>>>";
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
		FSMData data = null;
		try {
			data = (FSMData) deserialize(previousCodegFileText);
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}


		if (data == null)
			data = new FSMData();

		data.clearMethods();

        Locale.setDefault(new Locale("en","US"));
		String firstParameter = (String) this.getMetaobjectAnnotation().getJavaParameterList().get(0);
		FSMControllerDraw codegGUI = new FSMControllerDraw(data, firstParameter);

		if ( ! codegGUI.getLabel().equals(firstParameter) ) {
		    newFirstParameter = codegGUI.getLabel();
		}

		data = codegGUI.getFSMData();

		byte[] userInput = null;;

		try {
			userInput = serialize(data);
		} catch (IOException e) {
			e.printStackTrace();
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

	public static byte[] serialize(Object obj) throws IOException {

		if (obj == null)
			return null;

	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
	    os.writeObject(obj);
	    return out.toByteArray();
	}

	public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {

		if (data == null)
			return null;

		ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is = new ObjectInputStream(in);
	    return is.readObject();
	}


}