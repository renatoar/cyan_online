package meta.codegLibrary;


import java.awt.Frame;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import meta.AnnotationArgumentsKind;
import meta.CyanMetaobjectWithAtCodeg;
import meta.FileError;
import meta.IAction_dsa;
import meta.ICodeg;
import meta.ICommunicateInPrototype_afti_dsa_afsa;
import meta.ICompiler_ded;
import meta.ICompiler_dsa;
import meta.Tuple2;
import meta.WrCyanMetaobjectWithAtAnnotation;

public class CyanMetaobjectCodegSound extends CyanMetaobjectWithAtCodeg implements ICodeg, IAction_dsa, ICommunicateInPrototype_afti_dsa_afsa   {

	private String newFirstParameter = null;

	@Override
	public String getNewFirstParameter() {
		return newFirstParameter;
	}

	public CyanMetaobjectCodegSound() {
		super("sound", AnnotationArgumentsKind.OneParameter);
	}

	@Override
	public StringBuffer dsa_codeToAdd(ICompiler_dsa compiler_dsa) {
		byte[] byteList = this.getMetaobjectAnnotation().getCodegInfo();
		//String s = "\"" + Lexer.escapeJavaString(new String(byteList)) + "\"" ;
		String s = "\"" + new String(byteList) + "\"" ;
		return new StringBuffer( s );
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

		WrCyanMetaobjectWithAtAnnotation moAnnotation = this.getMetaobjectAnnotation();
		ArrayList<Object> javaParamList = moAnnotation.getJavaParameterList();
		String fileName1;
		/*
		 * the file name will be either noname.wav, if there is no parameter,
		 * or the first argument to the codeg call with extension 'wav'.
		 * Currently codegs must have at least one argument. That will soon change.
		 */
		if ( javaParamList.size() == 0 ) {
			/*
			 * of course, in this case the GUI should tell the user that something went wrong
			 */
			return null;
		}
		else {
			//fileName1 = compiler_ded.pathDataFilePackage(moAnnotation.getPackagePrototypeOfAnnotation() + "_" + ( (String ) javaParamList.get(0) ) + ".wav", moAnnotation.getPackageOfAnnotation()) ;
			fileName1 = ( (String ) javaParamList.get(0) ) + ".wav" ;
		}

		/**
		 * André, here you should call the routine to record the sound
		 */

		//BytesStreamsAndFiles bsf = new BytesStreamsAndFiles();
		//byte[] previousSound = bsf.read(fileName1);
		//CodegSoundGUI soundGUI = new CodegSoundGUI(new Frame(), previousSound);

//		new Frame(), previousCodegFileText, firstParameter);
//		codegGUI.setVisible(true);
//		byte[] userInput = codegGUI.getUserInput();
//		if ( ! codegGUI.getLabel().equals(firstParameter) ) {
//		    newFirstParameter = codegGUI.getLabel();
//		}
//		return userInput;

		String firstParameter = (String) this.getMetaobjectAnnotation().getJavaParameterList().get(0);
		Tuple2<FileError, byte[]> previousCodegSound = compiler_ded.readBinaryDataFileFromPackage(new String(previousCodegFileText, StandardCharsets.UTF_8), moAnnotation.getPackageOfAnnotation());
		CodegSoundGUI codegGUI = new CodegSoundGUI(new Frame(), previousCodegSound.f2, firstParameter);
		codegGUI.setVisible(true);
		byte[] data = codegGUI.getUserInput();
		if ( ! codegGUI.getLabel().equals(firstParameter) ) {
		    newFirstParameter = codegGUI.getLabel();
		}

		/*
		 * save 'data' to fileName1, which is a file in the data section of package
		 * moCall.getPackageOfCall(). This is the package in which the codeg call is.
		 */
		//compiler_ded.saveBinaryDataFileToPackage( data, fileName1, moCall.getPackageOfCall() );
		compiler_ded.saveBinaryDataFileToPackage(data, fileName1, moAnnotation.getPackageOfAnnotation());
		//bsf.write(data, fileName1);
		moAnnotation.setCodegInfo( compiler_ded.pathDataFilePackage(fileName1, moAnnotation.getPackageOfAnnotation()).getBytes() );
		/*
		 * the file name in which the sound is put is the codeg information
		 */

		codegGUI = null;
		return fileName1.getBytes();


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
