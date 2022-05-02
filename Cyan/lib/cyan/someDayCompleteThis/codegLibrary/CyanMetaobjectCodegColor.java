package meta.codegLibrary;

import java.awt.Frame;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import ast.CyanMetaobjectAnnotation;
import ast.CyanMetaobjectWithAtAnnotation;
import meta.AnnotationArgumentsKind;
import meta.CyanMetaobjectWithAtCodeg;
import meta.IAction_dsa;
import meta.ICodeg;
import meta.ICompiler_ded;
import meta.ICompiler_dsa;
import meta.Tuple4;

public class CyanMetaobjectCodegColor extends CyanMetaobjectWithAtCodeg implements ICodeg, IAction_dsa  {

	private String newFirstParameter = null;

	@Override
	public String getNewFirstParameter() {
		return newFirstParameter;
	}


	public CyanMetaobjectCodegColor() {
		super("color", AnnotationArgumentsKind.OneParameter);

	}

	@Override
	public StringBuffer dsa_codeToAdd(ICompiler_dsa compiler_dsa) {
		String codeAdd = new String(this.getMetaobjectAnnotation().getCodegInfo(), StandardCharsets.UTF_8);
		//System.err.println("CodeAdd CodegColor: "+codeAdd);
		return new StringBuffer(codeAdd);
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
		//final Display display = new Display ();
		//final Shell shell = new Shell (display, SWT.DIALOG_TRIM);


		//String hoverData = "Hello";
		//new HoverHelpDialog( new Shell() , hoverData).open();

		//shell.setSize(400, 200);
		//shell.open ();
		//while (!shell.isDisposed ())
		//{
		//while (!display.readAndDispatch())
		//		display.sleep();
		//}
		//display.dispose ();

		//byte[] userInput = new CodegColorGUI(new Frame() ,previousUserInput).getColor();


        Locale.setDefault(new Locale("en","US"));
		String firstParameter = (String) this.getMetaobjectAnnotation().getJavaParameterList().get(0);
		CodegColorGUI codegGUI = new CodegColorGUI(new Frame(), previousCodegFileText, firstParameter);
		codegGUI.setLocale(new Locale("en", "US"));
		codegGUI.setVisible(true);
		byte[] userInput = codegGUI.getUserInput();
		if ( ! codegGUI.getLabel().equals(firstParameter) ) {
		    newFirstParameter = codegGUI.getLabel();
		}

//		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//		CodegColorDialog dialog = new CodegColorDialog(shell);
//		dialog.create();
//		if (dialog.open() == Window.OK) {
//			System.out.println("Closed");
//		}

		codegGUI = null;
		return userInput;

	}

	public ArrayList<Tuple4<Integer, Integer, Integer, Integer>> getColorList(CyanMetaobjectAnnotation metaobjectAnnotation1) {
		String strColor = this.getMetaobjectAnnotation().getCodegInfo().toString();
		/*
		 * convert strColor to int color, put it in colorNumber
		 *
		 */
		int colorNumber = 0;
		try {
			colorNumber = Integer.parseInt(strColor);
		} catch (NumberFormatException e) {
			return null;
		}
		int column = metaobjectAnnotation1.getFirstSymbol().getColumnNumber();
		int columnLeftPar = column + 1 + this.getName().length() + 1;
		CyanMetaobjectWithAtAnnotation annotation = (CyanMetaobjectWithAtAnnotation ) metaobjectAnnotation1;
		String red = (String ) annotation.getJavaParameterList().get(0);

		ArrayList<Tuple4<Integer, Integer, Integer, Integer>> array = new ArrayList<>();
		Tuple4<Integer, Integer, Integer, Integer> t = new Tuple4<>(colorNumber, 1, columnLeftPar, red.length());
		array.add(t);

		return array;

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
