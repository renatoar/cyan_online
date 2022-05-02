package cyan.lang;
import cyanruntime.*;



@SuppressWarnings( { "unused", "cast", "hiding" } )
public class _Function_LT_GP_graph_p_Edge_GT extends _Any
 {

	private static final long serialVersionUID = 9079925582042614272L;
    static { 
        try {

          _Function_LT_GP_graph_p_Edge_GT.prototype = new _Function_LT_GP_graph_p_Edge_GT();
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

    public     _Function_LT_GP_graph_p_Edge_GT() {

        } 

    public @Override _Function_LT_GP_graph_p_Edge_GT _prototype() {
         return prototype;
        
        } 

    public graph._Edge _eval(){
        throw new ExceptionContainer__(new _ExceptionCannotCallAbstractMethod());
}

    public _Function_LT_GP_graph_p_Edge_GT  _verticalBar_greaterThan(_Function_LT_GP_graph_p_Edge_GP_graph_p_Edge_GT _f) {
        _Fun__0____ tmp1005 = new _Fun__0____(this, _f);

        return tmp1005;
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp1006 = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        return tmp1006;
        } 

    public @Override _Array_LT_GP__Any_GT _getAnnotListNameDoesNotCollide____() {
        _Array_LT_GP__Any_GT tmp1007 = new _Array_LT_GP__Any_GT();

        return tmp1007;
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getSlotFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp1008 = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _slotFeatureList__name__does__not__collide____;
        _slotFeatureList__name__does__not__collide____ = tmp1008;

        return _slotFeatureList__name__does__not__collide____;
        } 
    public static _Function_LT_GP_graph_p_Edge_GT prototype;
    private static _Fun__0____ prototypeFun_0__;

    static final String []fieldListFun_0__ = {  };
    static final String []fieldTypeListFun_0__ = {  };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureListFun_0__ = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotListFun_0__ = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureListFun_0__ = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameListFun_0__ = { 
        new CyString("eval"),
        new CyString("clone"),
        new CyString("prototype")
        };


    static final String []fieldList = {  };
    static final String []fieldTypeList = {  };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureList = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotList = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureList = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameList = { 
        new CyString("prototype"),
        new CyString("eval"),
        new CyString("|> Function<graph.Edge,graph.Edge>"),
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
    
    @SuppressWarnings( { "unused", "cast", "hiding" } )
private class _Fun__0____ extends cyan.lang._Function_LT_GP_graph_p_Edge_GT
 {

	private static final long serialVersionUID = 8886654447734910976L;
        public _Fun__0____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Function_LT_GP_graph_p_Edge_GT _self____;
        private         cyan.lang._Function_LT_GP_graph_p_Edge_GP_graph_p_Edge_GT _f;
        public _Fun__0____() { }

        public         _Fun__0____(_Function_LT_GP_graph_p_Edge_GT _self____, _Function_LT_GP_graph_p_Edge_GP_graph_p_Edge_GT _f)  {

            
        this._self____ = _self____;
        this._f = _f;
        
            } 

        public _Fun__0____  _new_2( _Function_LT_GP_graph_p_Edge_GT _self____, _Function_LT_GP_graph_p_Edge_GP_graph_p_Edge_GT _f )  {
             
            return new _Fun__0____(_self____, _f);
        
            } 

        public @Override graph._Edge _eval() {
            graph._Edge tmp1010 = _self____._eval();
            graph._Edge tmp1009 = _f._eval_1( tmp1010);

            return tmp1009;
            } 

        public @Override _Fun__0____ _clone() {
            
        try {
            return (_Fun__0____ ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
            } 

        public @Override _Fun__0____ _prototype() {
             return prototypeFun_0__;
        
            } 
    public String []getFieldTypeList() { 
        return fieldTypeListFun_0__;
    }
    public String []getFieldList() { 
        return fieldListFun_0__;
    }
    public String asString(int ident) {
        String s =  "Fun_0__ {\n";
        s = s + "super(cyan.lang.Function<graph.Edge>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        s = s + getWhiteSpaces(ident) + "self__: " + _self____._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "f: " + _f._asString().s + "\n";
        return s;
    } 
    protected _Any parent() {
        return _Function_LT_GP_graph_p_Edge_GT.prototype;
    }
    protected CyString prototypePackage() {
        return new CyString( "cyan.lang" );
    }
    static final String prototypeName = "Fun_0__";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureListFun_0__; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureListFun_0__; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotListFun_0__; }

}

    public String []getFieldTypeList() { 
        return fieldTypeList;
    }
    public String []getFieldList() { 
        return fieldList;
    }
    public String asString(int ident) {
        String s =  "Function<graph.Edge> {\n";
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
        return new CyString( "cyan.lang" );
    }
    static final String prototypeName = "Function<graph.Edge>";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureList; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureList; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotList; }
    static {
    }

}
