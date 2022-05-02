package main;
import cyanruntime.*;

import cyan.lang.*;
import graph.*;


@SuppressWarnings( { "unused", "cast", "hiding" } )
public final class _Program extends _Any
 {

	private static final long serialVersionUID = -3424597554829409059L;
    static { 
        try {

          _Program.prototype = new _Program();
        }
        catch ( ExceptionInInitializerError e ) {
            System.out.println("Probably this prototype is referenced indirectly in a method called " + 
"in its 'init' method. This " + 
"happens in this example:\n" + 
"    object InitError\n" + 
"        func init { \n" + 
"            MakeError accessInitError;\n" + 
"        }\n" + 
"    end\n" + 
"Method 'accessInitError' is just\n" + 
"    func accessInitError { \n" + 
"        InitError prototypeName println; \n" + 
"    }\n" + 
"Then InitError is referenced before the 'init' " + 
"method has built the object that represents the " + 
"prototype"); 
       }

    }

    public     _Program() {

        } 

    public main._Program _new() {
         
            return new _Program();        
        } 

    public _Nil _run() {
        graph._Graph tmp550 = new graph._Graph( );
        graph._Graph _g;
        _g = tmp550;
        _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp553 = new _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT( new CyInt(4) );
        _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp554 = new _Tuple_LT_GP_CyInt_GP_CyInt_GT(CyInt.one, (new CyInt( (int ) 4)));
        tmp553._add_1( tmp554);
        _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp555 = new _Tuple_LT_GP_CyInt_GP_CyInt_GT((new CyInt( (int ) 3)), CyInt.one);
        tmp553._add_1( tmp555);
        _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp556 = new _Tuple_LT_GP_CyInt_GP_CyInt_GT(CyInt.one, CyInt.two);
        tmp553._add_1( tmp556);
        _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp557 = new _Tuple_LT_GP_CyInt_GP_CyInt_GT(CyInt.two, (new CyInt( (int ) 4)));
        tmp553._add_1( tmp557);
        _Tuple_LT_GP__Any_GP__Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT_GT tmp552 = new _Tuple_LT_GP__Any_GP__Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT_GT(_Any.prototype, tmp553);
        _Nil tmp551 = _g._addEdges_1( tmp552);
        _Nil tmp558 = _g._println();
        CyString tmp560 = _g._asString();
        CyBoolean tmp561 = tmp560._equal_equal( (new CyString("{ (1, 4), (3, 1), (1, 2), (2, 4) }")));
        CyBoolean tmp559 = tmp561._exclamation();
        if ( tmp559.b ) {
            _Nil tmp562 = (new CyString("Assert failed in line 14 of prototype 'main.Program'"))._println();
            _Nil tmp563 = (new CyString("Assert expression: 'g asString == \"{ (1, 4), (3, 1), (1, 2), (2, 4) }\"'"))._println();
        }
        // end of if
        graph._Edge tmp565 = new graph._Edge( CyInt.one, (new CyInt( (int ) 3)));        _Nil tmp564 = _g._add_1( tmp565);
        CyString tmp567 = (new CyString("'g' == "))._plus_plus( _g);
        _Nil tmp566 = _Out.prototype._println_1( tmp567);
        return _Nil.prototype;
        } 

    public @Override main._Program _prototype() {
         return prototype;
        
        } 

    public @Override main._Program _clone() {
        
        try {
            return (_Program ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp568 = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        return tmp568;
        } 

    public @Override _Array_LT_GP__Any_GT _getAnnotListNameDoesNotCollide____() {
        _Array_LT_GP__Any_GT tmp569 = new _Array_LT_GP__Any_GT();

        return tmp569;
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getSlotFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp570 = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _slotFeatureList__name__does__not__collide____;
        _slotFeatureList__name__does__not__collide____ = tmp570;

        return _slotFeatureList__name__does__not__collide____;
        } 
    public static _Program prototype;

    static final String []fieldList = {  };
    static final String []fieldTypeList = {  };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureList = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotList = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureList = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameList = { 
        new CyString("run"),
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
        String s =  "Program {\n";
        s = s + "super(Any):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        return s;
    } 
    protected _Any parent() {
        return _Any.prototype;
    }
    protected CyString prototypePackage() {
        return new CyString( "main" );
    }
    static final String prototypeName = "Program";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureList; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureList; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotList; }
    static {
    }

}
