package cyan.lang;
import cyanruntime.*;



@SuppressWarnings( { "unused", "cast", "hiding" } )
public final class _Tuple_LT_GP_CyInt_GP_CyInt_GT extends _Any
 {

	private static final long serialVersionUID = 4218356077607657528L;
    static { 
          _Tuple_LT_GP_CyInt_GP_CyInt_GT.prototype = new _Tuple_LT_GP_CyInt_GP_CyInt_GT(new NonExistingJavaClass());
          _Tuple_LT_GP_CyInt_GP_CyInt_GT.prototype.initPrototype();
    }
    public _Tuple_LT_GP_CyInt_GP_CyInt_GT(NonExistingJavaClass doNotExit) {
        super();
    }
    public void initPrototype() {
        this.___f1 = CyInt.zero;this.___f2 = CyInt.zero;
    }
    private     cyan.lang.CyInt ___f1;
    private     cyan.lang.CyInt ___f2;
    public _Tuple_LT_GP_CyInt_GP_CyInt_GT() { }

    public     _Tuple_LT_GP_CyInt_GP_CyInt_GT(CyInt _g1, CyInt _g2)  {

        /* _f1 = g1 */
        ___f1 = _g1;
        /* _f2 = g2 */
        ___f2 = _g2;
        } 

    public _Tuple_LT_GP_CyInt_GP_CyInt_GT  _new_2( CyInt _p0, CyInt _p1 )  {
         
            return new _Tuple_LT_GP_CyInt_GP_CyInt_GT(_p0, _p1);
        
        } 

    public @Override _Tuple_LT_GP_CyInt_GP_CyInt_GT _prototype() {
         return prototype;
        
        } 

    public _Tuple_LT_GP_CyInt_GP_CyInt_GT  _f1_1_f2_1( CyInt _g1, CyInt _g2 )  {
        _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp754 = new _Tuple_LT_GP_CyInt_GP_CyInt_GT( _g1, _g2);
        return tmp754;
        } 

    public CyInt _f1() {
        return ___f1;
        } 

    public _Nil  _f1_1( CyInt _other )  {
        /* _f1 = other */
        ___f1 = _other;
        return _Nil.prototype;
        } 

    public CyInt _f2() {
        return ___f2;
        } 

    public _Nil  _f2_1( CyInt _other )  {
        /* _f2 = other */
        ___f2 = _other;
        return _Nil.prototype;
        } 

    public @Override CyBoolean  _equal_equal(Object _other) {
        _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp756 = _Tuple_LT_GP_CyInt_GP_CyInt_GT.prototype;
        java.lang.reflect.Method tmp757 = null;
        if ( "_isA_1" != null ) {
            tmp757 = CyanRuntime.getJavaMethodByName(_other.getClass(), "_isA_1", 1);
            if ( tmp757 == null ) { tmp757 = CyanRuntime.getJavaMethodByName(_other.getClass(), "isA", 1); }
        }
        Object tmp758 = null;
        if ( tmp757 != null ) { 
            try {
                tmp757.setAccessible(true);
                tmp758 = tmp757.invoke(_other, tmp756);
            }
            catch ( java.lang.reflect.InvocationTargetException tmp759 ) {
            	Throwable t__ = tmp759.getCause();
            	if ( t__ instanceof ExceptionContainer__ ) {
                	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
            	}
            	else
            		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
            }
            catch (IllegalAccessException | IllegalArgumentException tmp759) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("isA:") ) );
            }
        }
        else { 
            //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
            java.lang.reflect.Method tmp760 = CyanRuntime.getJavaMethodByName(_other.getClass(), "_doesNotUnderstand_2", 2);
            if ( tmp760 == null ) {
                throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
            }
            try {
                _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                arrayParam._add_1(tmp756);
                arrayArrayParam._add_1( arrayParam );
                tmp760.setAccessible(true);
                tmp758 = tmp760.invoke(_other, new CyString("isA:"), arrayArrayParam);
            }
            catch ( java.lang.reflect.InvocationTargetException tmp761 ) {
            	Throwable t__ = tmp761.getCause();
            	if ( t__ instanceof ExceptionContainer__ ) {
                	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
            	}
            	else
            		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
            }
            catch (IllegalAccessException | IllegalArgumentException tmp761) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("_isA_1") ) );
            }
        }
        if ( !(tmp758 instanceof CyBoolean) ) {
            throw new ExceptionContainer__(new _ExceptionCast( new CyString("Cannot cast expression 'other isA: Tuple<Int, Int>' to 'cyan.lang.Boolean' in line 31 of file Tuple(Int,Int).cyan") ) );
        }
        if ( ((CyBoolean ) tmp758).b ) {
            _Tuple_LT_GP_CyInt_GP_CyInt_GT _another;
                         _another = (_Tuple_LT_GP_CyInt_GP_CyInt_GT ) _other;
            
            CyInt tmp763 = _another._f1();
            CyBoolean tmp762 = _f1()._exclamation_equal( tmp763);
            if ( tmp762.b ) {
                CyBoolean tmp764 = CyBoolean.cyFalse;

                return tmp764;
            }
            // end of if
            CyInt tmp766 = _another._f2();
            CyBoolean tmp765 = _f2()._exclamation_equal( tmp766);
            if ( tmp765.b ) {
                CyBoolean tmp767 = CyBoolean.cyFalse;

                return tmp767;
            }
            // end of if
            CyBoolean tmp768 = CyBoolean.cyTrue;

            return tmp768;
        }
        else {
            CyBoolean tmp769 = CyBoolean.cyFalse;

            return tmp769;
        }
        // end of if
        } 

    public @Override CyInt _hashCode() {
        CyInt tmp770 = _f1()._hashCode();
        CyInt tmp772 = _f2()._hashCode();
        CyInt tmp771 = tmp770._plus( tmp772);
        return tmp771;
        } 

    public @Override CyString _asString() {
        CyString tmp774 = _f1()._asStringQuoteIfString();
        CyString tmp773 = (new CyString("[. f1 = "))._plus_plus( tmp774);
        CyString tmp775 = tmp773._plus_plus( (new CyString(", f2 = ")));
        CyString tmp777 = _f2()._asStringQuoteIfString();
        CyString tmp776 = tmp775._plus_plus( tmp777);
        CyString tmp778 = tmp776._plus_plus( (new CyString(" .]")));

        return tmp778;
        } 

    public @Override _Tuple_LT_GP_CyInt_GP_CyInt_GT _clone() {
        
        try {
            return (_Tuple_LT_GP_CyInt_GP_CyInt_GT ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp779 = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        return tmp779;
        } 

    public @Override _Array_LT_GP__Any_GT _getAnnotListNameDoesNotCollide____() {
        _Array_LT_GP__Any_GT tmp780 = new _Array_LT_GP__Any_GT();

        return tmp780;
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getSlotFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp781 = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _slotFeatureList__name__does__not__collide____;
        _slotFeatureList__name__does__not__collide____ = tmp781;
        _Any tmp784 = _Any.prototype._toAny_1( (new CyString("f1")));
        _Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT tmp783 = new _Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT((new CyString("_f1")), (new CyString("annot")), tmp784);
        _Nil tmp782 = _slotFeatureList__name__does__not__collide____._add_1( tmp783);
        _Any tmp787 = _Any.prototype._toAny_1( (new CyString("f2")));
        _Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT tmp786 = new _Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT((new CyString("_f2")), (new CyString("annot")), tmp787);
        _Nil tmp785 = _slotFeatureList__name__does__not__collide____._add_1( tmp786);

        return _slotFeatureList__name__does__not__collide____;
        } 
    public static _Tuple_LT_GP_CyInt_GP_CyInt_GT prototype;

    static final String []fieldList = { "_f1", "_f2" };
    static final String []fieldTypeList = { "cyan.lang.Int", "cyan.lang.Int" };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureList = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotList = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureList = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameList = { 
        new CyString("prototype"),
        new CyString("f1: Int f2: Int"),
        new CyString("f1"),
        new CyString("f1: Int"),
        new CyString("f2"),
        new CyString("f2: Int"),
        new CyString("== Dyn"),
        new CyString("hashCode"),
        new CyString("asString"),
        new CyString("clone"),
        new CyString("getFeatureListNameDoesNotCollide__"),
        new CyString("getAnnotListNameDoesNotCollide__"),
        new CyString("getSlotFeatureListNameDoesNotCollide__")
        };
    @Override protected CyString [] getMethodNameList2() { return methodNameList; }
    @Override protected String [] getFieldList2() { return fieldList; }

    private CyBoolean _eq_1_super__( Object p0 ) { return super._eq_1( p0 ); }
    private CyBoolean _neq_1_super__( Object p0 ) { return super._neq_1( p0 ); }
    private _Any _prototype_super__() { return super._prototype(); }
    private CyString _prototypeName_super__() { return super._prototypeName(); }
    private _Any _prototypeParent_super__() { return super._prototypeParent(); }
    private CyString _prototypePackageName_super__() { return super._prototypePackageName(); }
    private CyBoolean _isInterface_super__() { return super._isInterface(); }
    private CyBoolean _isA_1_super__( _Any p0 ) { return super._isA_1( p0 ); }
    private CyBoolean _notIsA_1_super__( _Any p0 ) { return super._notIsA_1( p0 ); }
    private Object _throw_1_super__( _CyException p0 ) { return super._throw_1( p0 ); }
    private _Any _clone_super__() { return super._clone(); }
    private CyString _plus_plus_super__(_Any _other) { return super._plus_plus(_other); }
    private CyString _asString_super__() { return super._asString(); }
    private CyString _asString_1_super__( CyInt p0 ) { return super._asString_1( p0 ); }
    private CyString _asStringThisOnly_1_super__( CyInt p0 ) { return super._asStringThisOnly_1( p0 ); }
    private CyString _asStringQuoteIfString_super__() { return super._asStringQuoteIfString(); }
    private CyBoolean _equal_equal_super__(Object _other) { return super._equal_equal(_other); }
    private CyBoolean _equal_equal_equal_super__(Object _other) { return super._equal_equal_equal(_other); }
    private CyBoolean _exclamation_equal_equal_super__(Object _other) { return super._exclamation_equal_equal(_other); }
    private CyBoolean _exclamation_equal_super__(Object _other) { return super._exclamation_equal(_other); }
    private CyBoolean _isCase_1_super__( _Any p0 ) { return super._isCase_1( p0 ); }
    private _Nil _assertxx_1_super__( CyBoolean p0 ) { return super._assertxx_1( p0 ); }
    private _Nil _assertxx_2_super__( CyBoolean p0, CyString p1 ) { return super._assertxx_2( p0, p1 ); }
    private _Nil _print_super__() { return super._print(); }
    private _Nil _println_super__() { return super._println(); }
    private _Nil _printspc_super__() { return super._printspc(); }
    private _Nil _printc_super__() { return super._printc(); }
    private _Any _toAny_1_super__( Object p0 ) { return super._toAny_1( p0 ); }
    private _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _featureList_super__() { return super._featureList(); }
    private _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _featureList_1_super__( CyString p0 ) { return super._featureList_1( p0 ); }
    private _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _slotFeatureList_super__() { return super._slotFeatureList(); }
    private _Array_LT_GP__Any_GT _annotList_super__() { return super._annotList(); }
    private _Array_LT_GP__Any_GT _annotList_1_super__( CyString p0 ) { return super._annotList_1( p0 ); }
    private Object _doesNotUnderstand_2_super__( CyString p0, _Array_LT_GP__Array_LT_GP_Object_GT_GT p1 ) { return super._doesNotUnderstand_2( p0, p1 ); }
    private _Any _functionForMethod_1_super__( CyString p0 ) { return super._functionForMethod_1( p0 ); }
    private _Any _functionForMethodWithSelf_1_super__( CyString p0 ) { return super._functionForMethodWithSelf_1( p0 ); }
    private CyInt _hashCode_super__() { return super._hashCode(); }
    private _Array_LT_GP_CyString_GT _getMethodNameList_super__() { return super._getMethodNameList(); }
    private _Array_LT_GP_CyString_GT _getFieldNameList_super__() { return super._getFieldNameList(); }
    private _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getFeatureListNameDoesNotCollide_____super__() { return super._getFeatureListNameDoesNotCollide____(); }
    private _Array_LT_GP__Any_GT _getAnnotListNameDoesNotCollide_____super__() { return super._getAnnotListNameDoesNotCollide____(); }
    private _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getSlotFeatureListNameDoesNotCollide_____super__() { return super._getSlotFeatureListNameDoesNotCollide____(); }
    public String []getFieldTypeList() { 
        return fieldTypeList;
    }
    public String []getFieldList() { 
        return fieldList;
    }
    public String asString(int ident) {
        String s =  "Tuple<Int,Int> {\n";
        s = s + "super(Any):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        s = s + getWhiteSpaces(ident) + "_f1: " + ___f1._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "_f2: " + ___f2._asString().s + "\n";
        return s;
    } 
    protected _Any parent() {
        return _Any.prototype;
    }
    protected CyString prototypePackage() {
        return new CyString( "cyan.lang" );
    }
    static final String prototypeName = "Tuple<Int,Int>";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureList; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureList; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotList; }
    static {
    }

}
