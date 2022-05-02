package graph;
import cyanruntime.*;

import cyan.lang.*;


@SuppressWarnings( { "unused", "cast", "hiding" } )
public final class _Graph extends _Any
 {

	private static final long serialVersionUID = 7781715984750064015L;
    static { 
        try {

          _Graph.prototype = new _Graph();
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
    private     cyan.lang.CyInt _numVertices;
    private     cyan.lang._Array_LT_GP_graph_p_Edge_GT _edgeArray;

    public     _Graph() {

    this._numVertices = CyInt.zero;
    _Array_LT_GP_graph_p_Edge_GT tmp505 = new _Array_LT_GP_graph_p_Edge_GT( );
    this._edgeArray = tmp505;

        } 

    public     _Graph(CyInt _numVertices, _Array_LT_GP_graph_p_Edge_GT _edgeArray)  {

    this._numVertices = CyInt.zero;
    _Array_LT_GP_graph_p_Edge_GT tmp505 = new _Array_LT_GP_graph_p_Edge_GT( );
    this._edgeArray = tmp505;

        /* self.numVertices = numVertices */
        this._numVertices = _numVertices;
        /* self.edgeArray = edgeArray */
        this._edgeArray = _edgeArray;
        } 

    public graph._Graph _new() {
         
            return new _Graph();         
        } 

    public graph._Graph  _new_2( CyInt _p0, _Array_LT_GP_graph_p_Edge_GT _p1 )  {
         
            return new _Graph(_p0, _p1);
        
        } 

    public _Nil  _addEdges_1( _Tuple_LT_GP__Any_GP__Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT_GT _t )  {
            {
            _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem;
            _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp506 = _t._f2();
            _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp507 = tmp506._iterator();
            while ( tmp507._hasNext().b ) { 
                _elem = tmp507._next();
                CyInt tmp508 = _elem._f1();

                CyInt _v1;
                _v1 = tmp508;
                CyInt tmp509 = _elem._f2();

                CyInt _v2;
                _v2 = tmp509;
                CyBoolean tmp510 = _v1._greaterThan( _numVertices);
                if ( tmp510.b ) {
                    /* numVertices = v1 */
                    _numVertices = _v1;
                }
                // end of if
                CyBoolean tmp511 = _v2._greaterThan( _numVertices);
                if ( tmp511.b ) {
                    /* numVertices = v2 */
                    _numVertices = _v2;
                }
                // end of if
                graph._Edge tmp513 = new graph._Edge( _v1, _v2);                _Nil tmp512 = _edgeArray._add_1( tmp513);
            }
        }
        return _Nil.prototype;
        } 

    public _Nil  _add_1( graph._Edge _edge )  {
        CyInt tmp514 = _edge._getFrom();

        CyInt _v1;
        _v1 = tmp514;
        CyInt tmp515 = _edge._getTo();

        CyInt _v2;
        _v2 = tmp515;
        CyBoolean tmp516 = _v1._greaterThan( _numVertices);
        if ( tmp516.b ) {
            /* numVertices = v1 */
            _numVertices = _v1;
        }
        // end of if
        CyBoolean tmp517 = _v2._greaterThan( _numVertices);
        if ( tmp517.b ) {
            /* numVertices = v2 */
            _numVertices = _v2;
        }
        // end of if
        _Nil tmp518 = _edgeArray._add_1( _edge);
        return _Nil.prototype;
        } 

    public _Array_LT_GP_graph_p_Edge_GT  _out_1( CyInt _vertex )  {
        _Array_LT_GP_graph_p_Edge_GT tmp519 = new _Array_LT_GP_graph_p_Edge_GT( );
        _Array_LT_GP_graph_p_Edge_GT _r;
        _r = tmp519;
            {
            graph._Edge _e;
            _Iterator_LT_GP_graph_p_Edge_GT tmp520 = _edgeArray._iterator();
            while ( tmp520._hasNext().b ) { 
                _e = tmp520._next();
                CyInt tmp521 = _e._getFrom();
                CyBoolean tmp522 = tmp521._equal_equal( _vertex);
                if ( tmp522.b ) {
                    _Nil tmp523 = _r._add_1( _e);
                }
                // end of if
            }
        }

        return _r;
        } 

    public _Array_LT_GP_graph_p_Edge_GT  _in_1( CyInt _vertex )  {
        _Array_LT_GP_graph_p_Edge_GT tmp524 = new _Array_LT_GP_graph_p_Edge_GT( );
        _Array_LT_GP_graph_p_Edge_GT _r;
        _r = tmp524;
            {
            graph._Edge _e;
            _Iterator_LT_GP_graph_p_Edge_GT tmp525 = _edgeArray._iterator();
            while ( tmp525._hasNext().b ) { 
                _e = tmp525._next();
                CyInt tmp526 = _e._getTo();
                CyBoolean tmp527 = tmp526._equal_equal( _vertex);
                if ( tmp527.b ) {
                    _Nil tmp528 = _r._add_1( _e);
                }
                // end of if
            }
        }

        return _r;
        } 

    public @Override CyString _asString() {

        CyString _s;
        _s = (new CyString("{ "));
        CyInt tmp529 = _edgeArray._size();

        CyInt _count;
        _count = tmp529;
            {
            graph._Edge _elem;
            _Iterator_LT_GP_graph_p_Edge_GT tmp530 = _edgeArray._iterator();
            while ( tmp530._hasNext().b ) { 
                _elem = tmp530._next();
                /* s = s ++ "(" ++ elem getFrom ++ ", " ++ elem getTo ++ ")" */
                CyString tmp531 = _s._plus_plus( (new CyString("(")));
                CyInt tmp533 = _elem._getFrom();
                CyString tmp532 = tmp531._plus_plus( tmp533);
                CyString tmp534 = tmp532._plus_plus( (new CyString(", ")));
                CyInt tmp536 = _elem._getTo();
                CyString tmp535 = tmp534._plus_plus( tmp536);
                CyString tmp537 = tmp535._plus_plus( (new CyString(")")));
                _s = tmp537;
                _count = _count._minus( new CyInt(1) );
                CyBoolean tmp538 = _count._greaterThan( CyInt.zero);
                if ( tmp538.b ) {
                    /* s = s ++ ", " */
                    CyString tmp539 = _s._plus_plus( (new CyString(", ")));
                    _s = tmp539;
                }
                // end of if
            }
        }
        /* s = s ++ " }" */
        CyString tmp540 = _s._plus_plus( (new CyString(" }")));
        _s = tmp540;

        return _s;
        } 

    public @Override graph._Graph _prototype() {
         return prototype;
        
        } 

    public CyInt _getNumVertices() {
        return _numVertices;
        } 

    public _Nil  _setNumVertices_1( CyInt _other )  {
        /* self.numVertices = other */
        this._numVertices = _other;
        return _Nil.prototype;
        } 

    public _Array_LT_GP_graph_p_Edge_GT _getEdgeArray() {
        return _edgeArray;
        } 

    public _Nil  _setEdgeArray_1( _Array_LT_GP_graph_p_Edge_GT _other )  {
        /* self.edgeArray = other */
        this._edgeArray = _other;
        return _Nil.prototype;
        } 

    public @Override graph._Graph _clone() {
        
        try {
            return (_Graph ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp541 = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        return tmp541;
        } 

    public @Override _Array_LT_GP__Any_GT _getAnnotListNameDoesNotCollide____() {
        _Array_LT_GP__Any_GT tmp542 = new _Array_LT_GP__Any_GT();

        return tmp542;
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getSlotFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp543 = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _slotFeatureList__name__does__not__collide____;
        _slotFeatureList__name__does__not__collide____ = tmp543;
        _Any tmp546 = _Any.prototype._toAny_1( (new CyString("f1")));
        _Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT tmp545 = new _Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT((new CyString("numVertices")), (new CyString("annot")), tmp546);
        _Nil tmp544 = _slotFeatureList__name__does__not__collide____._add_1( tmp545);
        _Any tmp549 = _Any.prototype._toAny_1( (new CyString("f2")));
        _Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT tmp548 = new _Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT((new CyString("edgeArray")), (new CyString("annot")), tmp549);
        _Nil tmp547 = _slotFeatureList__name__does__not__collide____._add_1( tmp548);

        return _slotFeatureList__name__does__not__collide____;
        } 
    public static _Graph prototype;

    static final String []fieldList = { "numVertices", "edgeArray" };
    static final String []fieldTypeList = { "cyan.lang.Int", "cyan.lang.Array<graph.Edge>" };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureList = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotList = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureList = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameList = { 
        new CyString("addEdges: Tuple<Any,Array<Tuple<Int,Int>>>"),
        new CyString("add: graph.Edge"),
        new CyString("out: Int"),
        new CyString("in: Int"),
        new CyString("asString"),
        new CyString("prototype"),
        new CyString("getNumVertices"),
        new CyString("setNumVertices: Int"),
        new CyString("getEdgeArray"),
        new CyString("setEdgeArray: Array<graph.Edge>"),
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
        String s =  "Graph {\n";
        s = s + "super(Any):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        s = s + getWhiteSpaces(ident) + "numVertices: " + _numVertices._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "edgeArray: " + _edgeArray._asString().s + "\n";
        return s;
    } 
    protected _Any parent() {
        return _Any.prototype;
    }
    protected CyString prototypePackage() {
        return new CyString( "graph" );
    }
    static final String prototypeName = "Graph";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureList; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureList; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotList; }
    static {
    }

}
