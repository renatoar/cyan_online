package cyan.lang;
import cyanruntime.*;



@SuppressWarnings( { "unused", "cast", "hiding" } )
public class _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT extends _Any
  implements  _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT {

	private static final long serialVersionUID = -485577440237757952L;
    static { 
          _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT.prototype = new _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT(new NonExistingJavaClass());
          _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT.prototype.initPrototype();
    }
    public _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT(NonExistingJavaClass doNotExit) {
        super();
    }
    public void initPrototype() {
        this._s = _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT.prototype;this._index = CyInt.zero;
    }
    private     cyan.lang._Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _s;
    private     cyan.lang.CyInt _index;
    public _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT() { }

    public     _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT(_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _s)  {

        /* self.s = s */
        this._s = _s;
        /* index = 0 */
        _index = CyInt.zero;
        } 

    public _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT  _new_1( _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _p0 )  {
         
            return new _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT(_p0);
        
        } 

    public @Override CyBoolean _hasNext() {
        CyInt tmp1052 = _s._size();
        CyBoolean tmp1051 = _index._lessThan( tmp1052);

        return tmp1051;
        } 

    public @Override _Tuple_LT_GP_CyInt_GP_CyInt_GT _next() {
        CyInt tmp1054 = _s._size();
        CyBoolean tmp1053 = _index._lessThan( tmp1054);
        if ( tmp1053.b ) {
            _index = _index._succ();
            _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp1055;
            CyInt tmp1056 = _index._minus( CyInt.one);
            tmp1055 = _s._at_1(tmp1056);

            return tmp1055;
        }
        else {
            Object tmp1057 = this._throw_1( _ExceptionIterator.prototype);
            return null;
        }
        // end of if
        } 

    public @Override _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _prototype() {
         return prototype;
        
        } 

    public @Override _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _clone() {
        
        try {
            return (_ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp1058 = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        return tmp1058;
        } 

    public @Override _Array_LT_GP__Any_GT _getAnnotListNameDoesNotCollide____() {
        _Array_LT_GP__Any_GT tmp1059 = new _Array_LT_GP__Any_GT();

        return tmp1059;
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getSlotFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp1060 = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _slotFeatureList__name__does__not__collide____;
        _slotFeatureList__name__does__not__collide____ = tmp1060;

        return _slotFeatureList__name__does__not__collide____;
        } 
    public static _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT prototype;

    static final String []fieldList = { "s", "index" };
    static final String []fieldTypeList = { "cyan.lang.Array<Tuple<Int,Int>>", "cyan.lang.Int" };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureList = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotList = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureList = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameList = { 
        new CyString("hasNext"),
        new CyString("next"),
        new CyString("prototype"),
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
        String s =  "ArrayIterator<Tuple<Int,Int>> {\n";
        s = s + "super(Any):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        s = s + getWhiteSpaces(ident) + "s: " + _s._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "index: " + _index._asString().s + "\n";
        return s;
    } 
    protected _Any parent() {
        return _Any.prototype;
    }
    protected CyString prototypePackage() {
        return new CyString( "cyan.lang" );
    }
    static final String prototypeName = "ArrayIterator<Tuple<Int,Int>>";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureList; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureList; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotList; }
    static {
    }

}
