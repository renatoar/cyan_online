package meta.cyanLang;

import meta.AnnotationArgumentsKind;
import meta.AttachedDeclarationKind;
import meta.CyanMetaobjectAtAnnot;
import meta.ICheckDeclaration_afterSemAn;
import meta.ICheckOverride_afterSemAn;
import meta.ICompiler_semAn;
import meta.Token;
import meta.WrFieldDec;
import meta.WrMethodDec;
import meta.WrPrototype;

public class CyanMetaobjectAccessOnlySharedFields extends CyanMetaobjectAtAnnot
			implements ICheckDeclaration_afterSemAn, ICheckOverride_afterSemAn {

	public CyanMetaobjectAccessOnlySharedFields() {
		super("accessOnlySharedFields", AnnotationArgumentsKind.ZeroParameters,
				new AttachedDeclarationKind[] { AttachedDeclarationKind.METHOD_DEC },
				Token.PUBLIC );
	}


	@Override
	public void afterSemAn_checkDeclaration(ICompiler_semAn compiler) {
		if ( compiler.getEnv().getCurrentPrototype().isInterface() ) {
			compiler.error(this.annotation.getFirstSymbol(),
					"This metaobject cannot be attached to a method of an interface");
		}
		final WrMethodDec method = (WrMethodDec ) this.getAttachedDeclaration();
		checkAccessFieldsSelfLeak(compiler, method);
	}


	/**
	   @param compiler
	   @param method
	 */
	private void checkAccessFieldsSelfLeak(ICompiler_semAn compiler,
			final WrMethodDec method) {
		if ( method.getAccessedFieldSet() != null ) {
			String all = "";
			boolean first = true;
			for ( WrFieldDec field : method.getAccessedFieldSet() ) {
				if ( ! field.isShared() ) {
					if ( !first ) { all += ", "; }
					all += field.getName();
					first = false;
				}
			}
			if ( all.length() != 0 ) {
				WrMethodDec superMethod = (WrMethodDec ) this.getAttachedDeclaration();
				WrPrototype superProto = superMethod.getDeclaringObject();
				String protoName = superProto.getFullName();
				WrPrototype subProto = method.getDeclaringObject();
				if ( superProto != subProto ) {
					this.addError(method.getFirstSymbol(compiler.getEnv()),
							"Annotation '" + this.getName() + "' is attached to method with the same name in the superprototype '" +
							superProto.getFullName() + "'. "
									+ "Therefore this method should not access any non-shared field. It accesses the following fields: " + all);
				}
				else {
					this.addError("Annotation '" + this.getName() + "' is attached to this method. "
									+ "Therefore, it should not access any non-shared field. It accesses the following fields: " + all);
				}
			}
		}
		if ( method.getSelfLeak(compiler.getEnv()) ) {
			this.addError(method.getFirstSymbol(compiler.getEnv()), "Annotation '" + this.getName() +
					"' is attached to this method. Therefore it cannot use "
					+ "'self' fields and methods or pass 'self' as parameter");
		}
	}


	@Override
	public void afterSemAn_checkOverride(ICompiler_semAn compiler,
			WrMethodDec method) {
		checkAccessFieldsSelfLeak(compiler, method);
	}


}

