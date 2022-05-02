package cyan.lang;
import cyanruntime.*;



import java.util.*;


@SuppressWarnings( { "unused", "cast", "hiding" } )
public final class _Array_LT_GP_graph_p_Edge_GT extends _Any
  implements  _Iterable_LT_GP_graph_p_Edge_GT {

	private static final long serialVersionUID = -7817466247317547085L;
    static { 
        try {

          _Array_LT_GP_graph_p_Edge_GT.prototype = new _Array_LT_GP_graph_p_Edge_GT();
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
    
           // very inefficient, I know that
        public ArrayList<graph._Edge> array = new ArrayList<graph._Edge>();
        public _Array_LT_GP_graph_p_Edge_GT( graph._Edge []anArray ) {
            array = new ArrayList<graph._Edge>();
            for (int i = 0; i < anArray.length; ++i) {
                array.add(anArray[i]);
            }
        }
    

    public     _Array_LT_GP_graph_p_Edge_GT() {

        
            array = new ArrayList<graph._Edge>();
        
        } 

    public     _Array_LT_GP_graph_p_Edge_GT(CyInt _intSizeArray)  {

        
            array = new ArrayList<graph._Edge>(_intSizeArray.n);
        
        } 

    public _Array_LT_GP_graph_p_Edge_GT _new() {
         
            return new _Array_LT_GP_graph_p_Edge_GT();         
        } 

    public _Array_LT_GP_graph_p_Edge_GT  _new_1( CyInt _p0 )  {
         
            return new _Array_LT_GP_graph_p_Edge_GT(_p0);
        
        } 

    public @Override CyBoolean  _equal_equal(Object _other) {
        CyBoolean tmp571 = CyBoolean.cyFalse;

        CyBoolean _ret;
        _ret = tmp571;
            {
            if ( _other instanceof _Array_LT_GP_graph_p_Edge_GT ) { 
                _Array_LT_GP_graph_p_Edge_GT _another = (_Array_LT_GP_graph_p_Edge_GT ) _other;
                CyInt tmp573 = _another._size();
                CyBoolean tmp572 = _size()._exclamation_equal( tmp573);
                if ( tmp572.b ) {
                    CyBoolean tmp574 = CyBoolean.cyFalse;

                    return tmp574;
                }
                // end of if

                CyInt _i;
                _i = CyInt.zero;
                    {
                    graph._Edge _elem;
                    _Iterator_LT_GP_graph_p_Edge_GT tmp575 = _another._iterator();
                    while ( tmp575._hasNext().b ) { 
                        _elem = tmp575._next();
                        graph._Edge tmp576;
                        tmp576 = this._at_1(_i);
                        CyBoolean tmp577 = tmp576._exclamation_equal( _elem);
                        if ( tmp577.b ) {
                            CyBoolean tmp578 = CyBoolean.cyFalse;

                            return tmp578;
                        }
                        // end of if
                        _i = _i._succ();
                    }
                }
                CyBoolean tmp579 = CyBoolean.cyTrue;

                return tmp579;
            }
        }
        CyBoolean tmp580 = CyBoolean.cyFalse;

        return tmp580;
        } 

    public @Override CyBoolean  _exclamation_equal(Object _other) {
        CyBoolean tmp582 = this._equal_equal( _other);
        CyBoolean tmp581 = tmp582._exclamation();

        return tmp581;
        } 

    public _Nil  _add_1( graph._Edge _elem )  {
        
            array.add(_elem);
                

        return _Nil.prototype;
        } 

    public _Nil  _replace_2( CyInt _i, graph._Edge _elem )  {
        
            
             try {
                 array.add(_i.n, _elem);
             } 
             catch ( IndexOutOfBoundsException  e ) {
                 throw new ExceptionContainer__( new _ExceptionIndexOutOfBounds(_i));
             }            
            
                

        return _Nil.prototype;
        } 

    public _Nil  _addAll_1( _Iterable_LT_GP_graph_p_Edge_GT _list )  {
            {
            graph._Edge _elem;
            _Iterator_LT_GP_graph_p_Edge_GT tmp583 = _list._iterator();
            while ( tmp583._hasNext().b ) { 
                _elem = tmp583._next();
                _Nil tmp584 = this._add_1( _elem);
            }
        }
        return _Nil.prototype;
        } 

    public _Nil _clear() {
        
            array.clear();
                

        return _Nil.prototype;
        } 

    public CyBoolean _isEmpty() {
        
             return new CyBoolean(array.isEmpty());
                 
        } 

    public _Nil  _remove_1( CyInt _i )  {
        
             try {
                array.remove(_i.n);
             } 
             catch ( IndexOutOfBoundsException  e ) {
                 throw new ExceptionContainer__( new _ExceptionIndexOutOfBounds(_i));
             }
                

        return _Nil.prototype;
        } 

    public graph._Edge  _at_1( CyInt _index )  {
        
             try {
                return array.get(_index.n);
             } 
             catch ( IndexOutOfBoundsException  e ) {
                 throw new ExceptionContainer__( new _ExceptionIndexOutOfBounds(_index));
             }
                
        } 

    public _Nil  _at_1_put_1( CyInt _index, graph._Edge _elem )  {
        
             try {
                 array.set(_index.n, _elem);
             } 
             catch ( IndexOutOfBoundsException  e ) {
                 throw new ExceptionContainer__( new _ExceptionIndexOutOfBounds(_index));
             }            
                

        return _Nil.prototype;
        } 

    public graph._Edge _last() {
        CyInt tmp586 = _size()._minus( CyInt.one);
        graph._Edge tmp585 = this._at_1( tmp586);

        return tmp585;
        } 

    public graph._Edge _head() {
        graph._Edge tmp587 = this._at_1( CyInt.zero);

        return tmp587;
        } 

    public _Array_LT_GP_graph_p_Edge_GT _tail() {
        CyBoolean tmp589 = _size()._equal_equal( CyInt.zero);
        CyBoolean tmp588;
        if ( ! tmp589.b ) { 
            CyBoolean tmp590 = _size()._equal_equal( CyInt.one);
            tmp588 = new CyBoolean(tmp590.b );
        }
        else {
            tmp588 = new CyBoolean(true);
        }
        if ( tmp588.b ) {
            _Array_LT_GP_graph_p_Edge_GT tmp591 = new _Array_LT_GP_graph_p_Edge_GT( );
            return tmp591;
        }
        else {
            CyInt tmp593 = _size()._minus( CyInt.one);
            _Array_LT_GP_graph_p_Edge_GT tmp592 = new _Array_LT_GP_graph_p_Edge_GT( tmp593);
            _Array_LT_GP_graph_p_Edge_GT _newArray;
            _newArray = tmp592;
                {
                CyInt _n;
                _Interval_LT_GP_CyInt_GT tmp594 = CyInt.one._dot_dot_lessThan( _size());
                _Iterator_LT_GP_CyInt_GT tmp595 = tmp594._iterator();
                while ( tmp595._hasNext().b ) { 
                    _n = tmp595._next();
                    graph._Edge tmp597 = this._at_1( _n);
                    _Nil tmp596 = _newArray._add_1( tmp597);
                }
            }

            return _newArray;
        }
        // end of if
        } 

    public _Array_LT_GP_graph_p_Edge_GT  _slice_1( _Interval_LT_GP_CyInt_GT _interval )  {
        CyInt tmp599 = _interval._size();
        _Array_LT_GP_graph_p_Edge_GT tmp598 = new _Array_LT_GP_graph_p_Edge_GT( tmp599);
        Ref<_Array_LT_GP_graph_p_Edge_GT> _newArray22 = new Ref<_Array_LT_GP_graph_p_Edge_GT>();
        _newArray22.elem = tmp598;
        _Fun__0____ tmp601 = new _Fun__0____(this, _newArray22);
        _Nil tmp600 = _interval._foreach_1( tmp601);

        return _newArray22.elem;
        } 

    public _Array_LT_GP_graph_p_Edge_GT  _concat_1( _Array_LT_GP_graph_p_Edge_GT _other )  {
        _Fun__1____ tmp603 = new _Fun__1____(this);
        _Nil tmp602 = _other._foreach_1( tmp603);

        return this;
        } 

    public CyInt _size() {
        
            return new CyInt(array.size());
                
        } 

    public @Override _Nil  _foreach_1( _Function_LT_GP_graph_p_Edge_GP__Nil_GT _b )  {
        _Interval_LT_GP_CyInt_GT tmp604 = CyInt.zero._dot_dot_lessThan( _size());
        _Fun__2____ tmp606 = new _Fun__2____(this, _b);
        _Nil tmp605 = tmp604._foreach_1( tmp606);
        return _Nil.prototype;
        } 

    public _Array_LT_GP_graph_p_Edge_GT  _filter_1( _Function_LT_GP_graph_p_Edge_GP_CyBoolean_GT _f )  {
        _Array_LT_GP_graph_p_Edge_GT tmp607 = new _Array_LT_GP_graph_p_Edge_GT();

        _Array_LT_GP_graph_p_Edge_GT _other;
        _other = tmp607;
        _Fun__3____ tmp609 = new _Fun__3____(this, _f, _other);
        _Nil tmp608 = this._foreach_1( tmp609);

        return _other;
        } 

    public _Nil  _filter_1_foreach_1( _Function_LT_GP_graph_p_Edge_GP_CyBoolean_GT _f, _Function_LT_GP_graph_p_Edge_GP__Nil_GT _b )  {
        _Fun__4____ tmp611 = new _Fun__4____(this, _f, _b);
        _Nil tmp610 = this._foreach_1( tmp611);
        return _Nil.prototype;
        } 

    public _Array_LT_GP_graph_p_Edge_GT  _map_1( _Function_LT_GP_graph_p_Edge_GP_graph_p_Edge_GT _f )  {
        _Array_LT_GP_graph_p_Edge_GT tmp612 = new _Array_LT_GP_graph_p_Edge_GT( );
        _Array_LT_GP_graph_p_Edge_GT _mapped;
        _mapped = tmp612;
            {
            graph._Edge _elem;
            _Iterator_LT_GP_graph_p_Edge_GT tmp613 = this._iterator();
            while ( tmp613._hasNext().b ) { 
                _elem = tmp613._next();
                graph._Edge tmp615 = _f._eval_1( _elem);
                _Nil tmp614 = _mapped._add_1( tmp615);
            }
        }

        return _mapped;
        } 

    public _Array_LT_GP_graph_p_Edge_GT  _verticalBar_greaterThan(_Function_LT_GP__Array_LT_GP_graph_p_Edge_GT_GP__Array_LT_GP_graph_p_Edge_GT_GT _f) {
        _Array_LT_GP_graph_p_Edge_GT tmp616 = _f._eval_1( this);

        return tmp616;
        } 

    public @Override _Iterator_LT_GP_graph_p_Edge_GT _iterator() {
        _ArrayIterator_LT_GP_graph_p_Edge_GT tmp617 = new _ArrayIterator_LT_GP_graph_p_Edge_GT( this);
        return tmp617;
        } 

    public CyBoolean  _contains_1( graph._Edge _elem )  {
            {
            graph._Edge _other;
            _Iterator_LT_GP_graph_p_Edge_GT tmp618 = this._iterator();
            while ( tmp618._hasNext().b ) { 
                _other = tmp618._next();
                CyBoolean tmp619 = _other._equal_equal( _elem);
                if ( tmp619.b ) {
                    CyBoolean tmp620 = CyBoolean.cyTrue;

                    return tmp620;
                }
                // end of if
            }
        }
        CyBoolean tmp621 = CyBoolean.cyFalse;

        return tmp621;
        } 

    public CyBoolean  _notContains_1( graph._Edge _elem )  {
        CyBoolean tmp623 = this._contains_1( _elem);
        CyBoolean tmp622 = tmp623._exclamation();
        return tmp622;
        } 

    public CyBoolean  _containsArray_1( _Array_LT_GP_graph_p_Edge_GT _other )  {

        CyInt _count;
        _count = CyInt.zero;
            {
            graph._Edge _otherElem;
            _Iterator_LT_GP_graph_p_Edge_GT tmp624 = _other._iterator();
            while ( tmp624._hasNext().b ) { 
                _otherElem = tmp624._next();
                    {
                    graph._Edge _selfElem;
                    _Iterator_LT_GP_graph_p_Edge_GT tmp625 = this._iterator();
                    while ( tmp625._hasNext().b ) { 
                        _selfElem = tmp625._next();
                        CyBoolean tmp626 = _otherElem._equal_equal( _selfElem);
                        if ( tmp626.b ) {
                            _count = _count._succ();
                            break;
                        }
                        // end of if
                    }
                }
            }
        }
        CyInt tmp628 = _other._size();
        CyBoolean tmp627 = _count._equal_equal( tmp628);

        return tmp627;
        } 

    public CyInt  _indexOf_1( graph._Edge _elem )  {

        CyInt _index;
        _index = CyInt.zero;
            {
            graph._Edge _other;
            _Iterator_LT_GP_graph_p_Edge_GT tmp629 = this._iterator();
            while ( tmp629._hasNext().b ) { 
                _other = tmp629._next();
                CyBoolean tmp630 = _other._equal_equal( _elem);
                if ( tmp630.b ) {

                    return _index;
                }
                // end of if
                _index = _index._succ();
            }
        }
        CyInt tmp631 = CyInt.one._minus();

        return tmp631;
        } 

    public @Override _Array_LT_GP_graph_p_Edge_GT _prototype() {
         return prototype;
        
        } 

    public @Override CyInt _hashCode() {

        CyInt _hash;
        _hash = CyInt.zero;
            {
            graph._Edge _elem;
            _Iterator_LT_GP_graph_p_Edge_GT tmp632 = this._iterator();
            while ( tmp632._hasNext().b ) { 
                _elem = tmp632._next();
                /* hash = hash + elem ?hashCode */
                java.lang.reflect.Method tmp635 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_hashCode", 0);
                if ( tmp635 == null ) { tmp635 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "hashCode", 0); }
                Object tmp636 = null;
                if ( tmp635 != null ) { 
                    try {
                        tmp635.setAccessible(true);
                        tmp636 = tmp635.invoke(_elem);
                    }
                    catch ( java.lang.reflect.InvocationTargetException tmp637 ) {
                    	Throwable t__ = tmp637.getCause();
                    	if ( t__ instanceof ExceptionContainer__ ) {
                        	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                    	}
                    	else
                    		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                    }
                    catch (IllegalAccessException | IllegalArgumentException tmp637) {
                            throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("hashCode") ) );
                    }
                }
                else { 
                    //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                    java.lang.reflect.Method tmp638 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_doesNotUnderstand_2", 2);
                    if ( tmp638 == null ) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                    }
                    try {
                        _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                        _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                        arrayArrayParam._add_1( arrayParam );
                        tmp638.setAccessible(true);
                        tmp636 = tmp638.invoke(_elem, new CyString("hashCode"), arrayArrayParam);
                    }
                    catch ( java.lang.reflect.InvocationTargetException tmp639 ) {
                    	Throwable t__ = tmp639.getCause();
                    	if ( t__ instanceof ExceptionContainer__ ) {
                        	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                    	}
                    	else
                    		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                    }
                    catch (IllegalAccessException | IllegalArgumentException tmp639) {
                            throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("_hashCode") ) );
                    }
                }
                CyInt tmp640;
                if ( tmp636 instanceof CyInt ) 
                    tmp640 = (CyInt ) tmp636;
                else
                    throw new ExceptionContainer__(new _ExceptionCast( new CyString("Cannot cast expression 'elem ?hashCode' to 'cyan.lang.Int' in line 272 of file Array(graph.Edge).cyan") ) );
                CyInt tmp633 = _hash._plus( tmp640);
                _hash = tmp633;
            }
        }

        return _hash;
        } 

    public @Override CyString  _asString_1( CyInt _ident )  {

        CyString _s;
        _s = (new CyString(""));
            {
            CyInt _i;
            _Interval_LT_GP_CyInt_GT tmp641 = CyInt.one._dot_dot( _ident);
            _Iterator_LT_GP_CyInt_GT tmp642 = tmp641._iterator();
            while ( tmp642._hasNext().b ) { 
                _i = tmp642._next();
                /* s = s ++ " " */
                CyString tmp643 = _s._plus_plus( (new CyString(" ")));
                _s = tmp643;
            }
        }
        /* s = s ++ "[ " */
        CyString tmp644 = _s._plus_plus( (new CyString("[ ")));
        _s = tmp644;

        CyInt _size2;
        _size2 = _size();
            {
            graph._Edge _elem;
            _Iterator_LT_GP_graph_p_Edge_GT tmp645 = this._iterator();
            while ( tmp645._hasNext().b ) { 
                _elem = tmp645._next();
                /* s = s ++ elem ?asStringQuoteIfString */
                java.lang.reflect.Method tmp648 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_asStringQuoteIfString", 0);
                if ( tmp648 == null ) { tmp648 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "asStringQuoteIfString", 0); }
                Object tmp649 = null;
                if ( tmp648 != null ) { 
                    try {
                        tmp648.setAccessible(true);
                        tmp649 = tmp648.invoke(_elem);
                    }
                    catch ( java.lang.reflect.InvocationTargetException tmp650 ) {
                    	Throwable t__ = tmp650.getCause();
                    	if ( t__ instanceof ExceptionContainer__ ) {
                        	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                    	}
                    	else
                    		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                    }
                    catch (IllegalAccessException | IllegalArgumentException tmp650) {
                            throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("asStringQuoteIfString") ) );
                    }
                }
                else { 
                    //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                    java.lang.reflect.Method tmp651 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_doesNotUnderstand_2", 2);
                    if ( tmp651 == null ) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                    }
                    try {
                        _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                        _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                        arrayArrayParam._add_1( arrayParam );
                        tmp651.setAccessible(true);
                        tmp649 = tmp651.invoke(_elem, new CyString("asStringQuoteIfString"), arrayArrayParam);
                    }
                    catch ( java.lang.reflect.InvocationTargetException tmp652 ) {
                    	Throwable t__ = tmp652.getCause();
                    	if ( t__ instanceof ExceptionContainer__ ) {
                        	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                    	}
                    	else
                    		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                    }
                    catch (IllegalAccessException | IllegalArgumentException tmp652) {
                            throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("_asStringQuoteIfString") ) );
                    }
                }
                _Any tmp653;
                if ( tmp649 instanceof _Any ) 
                    tmp653 = (_Any ) tmp649;
                else
                    throw new ExceptionContainer__(new _ExceptionCast( new CyString("Cannot cast expression 'elem ?asStringQuoteIfString' to 'cyan.lang.Any' in line 283 of file Array(graph.Edge).cyan") ) );
                CyString tmp646 = _s._plus_plus( tmp653);
                _s = tmp646;
                _size2 = _size2._minus( new CyInt(1) );
                CyBoolean tmp654 = _size2._greaterThan( CyInt.zero);
                if ( tmp654.b ) {
                    /* s = s ++ ", " */
                    CyString tmp655 = _s._plus_plus( (new CyString(", ")));
                    _s = tmp655;
                }
                // end of if
            }
        }
        /* s = s ++ " ]" */
        CyString tmp656 = _s._plus_plus( (new CyString(" ]")));
        _s = tmp656;

        return _s;
        } 

    public _Nil  _apply_1( CyString _message )  {
        _Fun__5____ tmp658 = new _Fun__5____(this, _message);
        _Nil tmp657 = this._foreach_1( tmp658);
        return _Nil.prototype;
        } 

    public Object  _apply_1_select_1( CyString _message, CyString _slot )  {
        String tmp660 =  CyanRuntime.getJavaNameOfUnaryMethod(((CyString ) _slot).s);
        graph._Edge tmp661;
        tmp661 = this._at_1(CyInt.zero);
        java.lang.reflect.Method tmp662 = CyanRuntime.getJavaMethodByName(tmp661.getClass(), tmp660, 0);
        if ( tmp662 == null ) { tmp662 = CyanRuntime.getJavaMethodByName(tmp661.getClass(), "_slot", 0); }
        Object tmp663 = null;
        if ( tmp662 != null ) { 
            try {
                tmp662.setAccessible(true);
                tmp663 = tmp662.invoke(tmp661);
            }
            catch ( java.lang.reflect.InvocationTargetException tmp664 ) {
            	Throwable t__ = tmp664.getCause();
            	if ( t__ instanceof ExceptionContainer__ ) {
                	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
            	}
            	else
            		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
            }
            catch (IllegalAccessException | IllegalArgumentException tmp664) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(_slot ) );
            }
        }
        else { 
            //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
            java.lang.reflect.Method tmp665 = CyanRuntime.getJavaMethodByName(tmp661.getClass(), "_doesNotUnderstand_2", 2);
            if ( tmp665 == null ) {
                throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
            }
            try {
                _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                arrayArrayParam._add_1( arrayParam );
                tmp665.setAccessible(true);
                tmp663 = tmp665.invoke(tmp661, _slot, arrayArrayParam);
            }
            catch ( java.lang.reflect.InvocationTargetException tmp666 ) {
            	Throwable t__ = tmp666.getCause();
            	if ( t__ instanceof ExceptionContainer__ ) {
                	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
            	}
            	else
            		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
            }
            catch (IllegalAccessException | IllegalArgumentException tmp666) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp660) ) );
            }
        }

        Object _sum;
        _sum = tmp663;

        CyInt _i;
        _i = CyInt.one;
        while ( true ) { 
            CyBoolean tmp667 = _i._lessThan( _size());
            if ( !tmp667.b ) break;
            graph._Edge tmp668;
            tmp668 = this._at_1(_i);

            graph._Edge _elem;
            _elem = tmp668;
            /* sum = sum `message: (elem `slot) */
            String tmp671 =  CyanRuntime.getJavaNameOfUnaryMethod(((CyString ) _slot).s);
            java.lang.reflect.Method tmp672 = CyanRuntime.getJavaMethodByName(_elem.getClass(), tmp671, 0);
            if ( tmp672 == null ) { tmp672 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_slot", 0); }
            Object tmp673 = null;
            if ( tmp672 != null ) { 
                try {
                    tmp672.setAccessible(true);
                    tmp673 = tmp672.invoke(_elem);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp674 ) {
                	Throwable t__ = tmp674.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp674) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(_slot ) );
                }
            }
            else { 
                //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                java.lang.reflect.Method tmp675 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_doesNotUnderstand_2", 2);
                if ( tmp675 == null ) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                }
                try {
                    _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                    _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                    arrayArrayParam._add_1( arrayParam );
                    tmp675.setAccessible(true);
                    tmp673 = tmp675.invoke(_elem, _slot, arrayArrayParam);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp676 ) {
                	Throwable t__ = tmp676.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp676) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp671) ) );
                }
            }
            String tmp677 = "";
            tmp677 += ((CyString ) _message).s;
            char tmp678 = tmp677.charAt(0);
            if ( (tmp678 == '_' || Character.isAlphabetic(tmp678) ) && !tmp677.endsWith(":") ) { tmp677 += ":"; }
            String tmp679 =  CyanRuntime.getJavaNameOfMethod(new String[] { ((CyString ) _message).s }, new int[] {1} );
            java.lang.reflect.Method tmp680 = null;
            if ( tmp679 != null ) {
                tmp680 = CyanRuntime.getJavaMethodByName(_sum.getClass(), tmp679, 1);
            }
            Object tmp681 = null;
            if ( tmp680 != null ) { 
                try {
                    tmp680.setAccessible(true);
                    tmp681 = tmp680.invoke(_sum, tmp673);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp682 ) {
                	Throwable t__ = tmp682.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp682) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp677) ) );
                }
            }
            else { 
                //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                java.lang.reflect.Method tmp683 = CyanRuntime.getJavaMethodByName(_sum.getClass(), "_doesNotUnderstand_2", 2);
                if ( tmp683 == null ) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                }
                try {
                    _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                    _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                    arrayParam._add_1(tmp673);
                    arrayArrayParam._add_1( arrayParam );
                    tmp683.setAccessible(true);
                    tmp681 = tmp683.invoke(_sum, new CyString(tmp677), arrayArrayParam);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp684 ) {
                	Throwable t__ = tmp684.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp684) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp679) ) );
                }
            }
            _sum = tmp681;
            _i = _i._succ();
        }

        return _sum;
        } 

    public Object  _dot_plus(CyString _message) {
        graph._Edge tmp685;
        tmp685 = this._at_1(CyInt.zero);

        Ref<graph._Edge> _sum = new Ref<graph._Edge>();
        _sum.elem = tmp685;
        _Interval_LT_GP_CyInt_GT tmp686 = CyInt.one._dot_dot_lessThan( _size());
        _Fun__6____ tmp688 = new _Fun__6____(this, _message, _sum);
        _Nil tmp687 = tmp686._foreach_1( tmp688);

        return _sum.elem;
        } 

    public _Nil  _dot_mult(CyString _message) {
        _Nil tmp689 = this._apply_1( _message);
        return _Nil.prototype;
        } 

    public @Override _Array_LT_GP_graph_p_Edge_GT _clone() {
        
        try {
            return (_Array_LT_GP_graph_p_Edge_GT ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp690 = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        return tmp690;
        } 

    public @Override _Array_LT_GP__Any_GT _getAnnotListNameDoesNotCollide____() {
        _Array_LT_GP__Any_GT tmp691 = new _Array_LT_GP__Any_GT();

        return tmp691;
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getSlotFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp692 = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _slotFeatureList__name__does__not__collide____;
        _slotFeatureList__name__does__not__collide____ = tmp692;

        return _slotFeatureList__name__does__not__collide____;
        } 
    public static _Array_LT_GP_graph_p_Edge_GT prototype;
    private static _Fun__0____ prototypeFun_0__;

    static final String []fieldListFun_0__ = {  };
    static final String []fieldTypeListFun_0__ = {  };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureListFun_0__ = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotListFun_0__ = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureListFun_0__ = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameListFun_0__ = { 
        new CyString("eval: Int"),
        new CyString("clone"),
        new CyString("prototype")
        };

    private static _Fun__1____ prototypeFun_1__;

    static final String []fieldListFun_1__ = {  };
    static final String []fieldTypeListFun_1__ = {  };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureListFun_1__ = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotListFun_1__ = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureListFun_1__ = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameListFun_1__ = { 
        new CyString("eval: graph.Edge"),
        new CyString("clone"),
        new CyString("prototype")
        };

    private static _Fun__2____ prototypeFun_2__;

    static final String []fieldListFun_2__ = {  };
    static final String []fieldTypeListFun_2__ = {  };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureListFun_2__ = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotListFun_2__ = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureListFun_2__ = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameListFun_2__ = { 
        new CyString("eval: Int"),
        new CyString("clone"),
        new CyString("prototype")
        };

    private static _Fun__3____ prototypeFun_3__;

    static final String []fieldListFun_3__ = {  };
    static final String []fieldTypeListFun_3__ = {  };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureListFun_3__ = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotListFun_3__ = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureListFun_3__ = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameListFun_3__ = { 
        new CyString("eval: graph.Edge"),
        new CyString("clone"),
        new CyString("prototype")
        };

    private static _Fun__4____ prototypeFun_4__;

    static final String []fieldListFun_4__ = {  };
    static final String []fieldTypeListFun_4__ = {  };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureListFun_4__ = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotListFun_4__ = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureListFun_4__ = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameListFun_4__ = { 
        new CyString("eval: graph.Edge"),
        new CyString("clone"),
        new CyString("prototype")
        };

    private static _Fun__5____ prototypeFun_5__;

    static final String []fieldListFun_5__ = {  };
    static final String []fieldTypeListFun_5__ = {  };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureListFun_5__ = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotListFun_5__ = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureListFun_5__ = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameListFun_5__ = { 
        new CyString("eval: graph.Edge"),
        new CyString("clone"),
        new CyString("prototype")
        };

    private static _Fun__6____ prototypeFun_6__;

    static final String []fieldListFun_6__ = {  };
    static final String []fieldTypeListFun_6__ = {  };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureListFun_6__ = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotListFun_6__ = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureListFun_6__ = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameListFun_6__ = { 
        new CyString("eval: Int"),
        new CyString("clone"),
        new CyString("prototype")
        };


    static final String []fieldList = {  };
    static final String []fieldTypeList = {  };
    public static _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT featureList = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    public static _Array_LT_GP__Any_GT annotList = new _Array_LT_GP__Any_GT();

    static final _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT slotFeatureList = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();
    static CyString []methodNameList = { 
        new CyString("== Dyn"),
        new CyString("!= Dyn"),
        new CyString("add: graph.Edge"),
        new CyString("replace: Int, graph.Edge"),
        new CyString("addAll: Iterable<graph.Edge>"),
        new CyString("clear"),
        new CyString("isEmpty"),
        new CyString("remove: Int"),
        new CyString("at: Int"),
        new CyString("at: Int put: graph.Edge"),
        new CyString("last"),
        new CyString("head"),
        new CyString("tail"),
        new CyString("slice: Interval<Int>"),
        new CyString("concat: Array<graph.Edge>"),
        new CyString("size"),
        new CyString("foreach: Function<graph.Edge,Nil>"),
        new CyString("filter: Function<graph.Edge,Boolean>"),
        new CyString("filter: Function<graph.Edge,Boolean> foreach: Function<graph.Edge,Nil>"),
        new CyString("map: Function<graph.Edge,graph.Edge>"),
        new CyString("|> Function<Array<graph.Edge>,Array<graph.Edge>>"),
        new CyString("iterator"),
        new CyString("contains: graph.Edge"),
        new CyString("notContains: graph.Edge"),
        new CyString("containsArray: Array<graph.Edge>"),
        new CyString("indexOf: graph.Edge"),
        new CyString("prototype"),
        new CyString("hashCode"),
        new CyString("asString: Int"),
        new CyString("apply: String"),
        new CyString("apply: String select: String"),
        new CyString(".+ String"),
        new CyString(".* String"),
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
    
    @SuppressWarnings( { "unused", "cast", "hiding" } )
private class _Fun__0____ extends cyan.lang._Function_LT_GP_CyInt_GP__Nil_GT
 {

	private static final long serialVersionUID = 8886654447734910976L;
        public _Fun__0____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Array_LT_GP_graph_p_Edge_GT _self____;
        private         Ref<cyan.lang._Array_LT_GP_graph_p_Edge_GT> _newArray22;
        public _Fun__0____() { }

        public         _Fun__0____(_Array_LT_GP_graph_p_Edge_GT _self____, Ref<_Array_LT_GP_graph_p_Edge_GT> _newArray22)  {

            
        this._self____ = _self____;
        this._newArray22 = _newArray22;
        
            } 

        public _Fun__0____  _new_2( _Array_LT_GP_graph_p_Edge_GT _self____, Ref<_Array_LT_GP_graph_p_Edge_GT> _newArray22 )  {
             
            return new _Fun__0____(_self____, _newArray22);
        
            } 

        public @Override _Nil  _eval_1( CyInt _i )  {
            graph._Edge tmp694 = _self____._at_1( _i);
            _Nil tmp693 = _newArray22.elem._add_1( tmp694);
            return _Nil.prototype;
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
        s = s + "super(cyan.lang.Function<Int,Nil>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        s = s + getWhiteSpaces(ident) + "self__: " + _self____._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "newArray22: " + _newArray22.elem._asString().s + "\n";
        return s;
    } 
    protected _Any parent() {
        return _Function_LT_GP_CyInt_GP__Nil_GT.prototype;
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

    
    @SuppressWarnings( { "unused", "cast", "hiding" } )
private class _Fun__1____ extends cyan.lang._Function_LT_GP_graph_p_Edge_GP__Nil_GT
 {

	private static final long serialVersionUID = 279144571410163665L;
        public _Fun__1____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Array_LT_GP_graph_p_Edge_GT _self____;
        public _Fun__1____() { }

        public         _Fun__1____(_Array_LT_GP_graph_p_Edge_GT _self____)  {

            
        this._self____ = _self____;
        
            } 

        public _Fun__1____  _new_1( _Array_LT_GP_graph_p_Edge_GT _self____ )  {
             
            return new _Fun__1____(_self____);
        
            } 

        public @Override _Nil  _eval_1( graph._Edge _elem )  {
            _Nil tmp695 = _self____._add_1( _elem);
            return _Nil.prototype;
            } 

        public @Override _Fun__1____ _clone() {
            
        try {
            return (_Fun__1____ ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
            } 

        public @Override _Fun__1____ _prototype() {
             return prototypeFun_1__;
        
            } 
    public String []getFieldTypeList() { 
        return fieldTypeListFun_1__;
    }
    public String []getFieldList() { 
        return fieldListFun_1__;
    }
    public String asString(int ident) {
        String s =  "Fun_1__ {\n";
        s = s + "super(cyan.lang.Function<graph.Edge,Nil>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        s = s + getWhiteSpaces(ident) + "self__: " + _self____._asString().s + "\n";
        return s;
    } 
    protected _Any parent() {
        return _Function_LT_GP_graph_p_Edge_GP__Nil_GT.prototype;
    }
    protected CyString prototypePackage() {
        return new CyString( "cyan.lang" );
    }
    static final String prototypeName = "Fun_1__";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureListFun_1__; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureListFun_1__; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotListFun_1__; }

}

    
    @SuppressWarnings( { "unused", "cast", "hiding" } )
private class _Fun__2____ extends cyan.lang._Function_LT_GP_CyInt_GP__Nil_GT
 {

	private static final long serialVersionUID = -573592701003332792L;
        public _Fun__2____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Array_LT_GP_graph_p_Edge_GT _self____;
        private         cyan.lang._Function_LT_GP_graph_p_Edge_GP__Nil_GT _b;
        public _Fun__2____() { }

        public         _Fun__2____(_Array_LT_GP_graph_p_Edge_GT _self____, _Function_LT_GP_graph_p_Edge_GP__Nil_GT _b)  {

            
        this._self____ = _self____;
        this._b = _b;
        
            } 

        public _Fun__2____  _new_2( _Array_LT_GP_graph_p_Edge_GT _self____, _Function_LT_GP_graph_p_Edge_GP__Nil_GT _b )  {
             
            return new _Fun__2____(_self____, _b);
        
            } 

        public @Override _Nil  _eval_1( CyInt _i )  {
            graph._Edge tmp697 = _self____._at_1( _i);
            _Nil tmp696 = _b._eval_1( tmp697);
            return _Nil.prototype;
            } 

        public @Override _Fun__2____ _clone() {
            
        try {
            return (_Fun__2____ ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
            } 

        public @Override _Fun__2____ _prototype() {
             return prototypeFun_2__;
        
            } 
    public String []getFieldTypeList() { 
        return fieldTypeListFun_2__;
    }
    public String []getFieldList() { 
        return fieldListFun_2__;
    }
    public String asString(int ident) {
        String s =  "Fun_2__ {\n";
        s = s + "super(cyan.lang.Function<Int,Nil>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        s = s + getWhiteSpaces(ident) + "self__: " + _self____._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "b: " + _b._asString().s + "\n";
        return s;
    } 
    protected _Any parent() {
        return _Function_LT_GP_CyInt_GP__Nil_GT.prototype;
    }
    protected CyString prototypePackage() {
        return new CyString( "cyan.lang" );
    }
    static final String prototypeName = "Fun_2__";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureListFun_2__; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureListFun_2__; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotListFun_2__; }

}

    
    @SuppressWarnings( { "unused", "cast", "hiding" } )
private class _Fun__3____ extends cyan.lang._Function_LT_GP_graph_p_Edge_GP__Nil_GT
 {

	private static final long serialVersionUID = -7392324740483831445L;
        public _Fun__3____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Array_LT_GP_graph_p_Edge_GT _self____;
        private         cyan.lang._Function_LT_GP_graph_p_Edge_GP_CyBoolean_GT _f;
        private         cyan.lang._Array_LT_GP_graph_p_Edge_GT _other;
        public _Fun__3____() { }

        public         _Fun__3____(_Array_LT_GP_graph_p_Edge_GT _self____, _Function_LT_GP_graph_p_Edge_GP_CyBoolean_GT _f, _Array_LT_GP_graph_p_Edge_GT _other)  {

            
        this._self____ = _self____;
        this._f = _f;
        this._other = _other;
        
            } 

        public _Fun__3____  _new_3( _Array_LT_GP_graph_p_Edge_GT _self____, _Function_LT_GP_graph_p_Edge_GP_CyBoolean_GT _f, _Array_LT_GP_graph_p_Edge_GT _other )  {
             
            return new _Fun__3____(_self____, _f, _other);
        
            } 

        public @Override _Nil  _eval_1( graph._Edge _elem )  {
            CyBoolean tmp698 = _f._eval_1( _elem);
            if ( tmp698.b ) {
                _Nil tmp699 = _other._add_1( _elem);
            }
            // end of if
            return _Nil.prototype;
            } 

        public @Override _Fun__3____ _clone() {
            
        try {
            return (_Fun__3____ ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
            } 

        public @Override _Fun__3____ _prototype() {
             return prototypeFun_3__;
        
            } 
    public String []getFieldTypeList() { 
        return fieldTypeListFun_3__;
    }
    public String []getFieldList() { 
        return fieldListFun_3__;
    }
    public String asString(int ident) {
        String s =  "Fun_3__ {\n";
        s = s + "super(cyan.lang.Function<graph.Edge,Nil>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        s = s + getWhiteSpaces(ident) + "self__: " + _self____._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "f: " + _f._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "other: " + _other._asString().s + "\n";
        return s;
    } 
    protected _Any parent() {
        return _Function_LT_GP_graph_p_Edge_GP__Nil_GT.prototype;
    }
    protected CyString prototypePackage() {
        return new CyString( "cyan.lang" );
    }
    static final String prototypeName = "Fun_3__";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureListFun_3__; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureListFun_3__; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotListFun_3__; }

}

    
    @SuppressWarnings( { "unused", "cast", "hiding" } )
private class _Fun__4____ extends cyan.lang._Function_LT_GP_graph_p_Edge_GP__Nil_GT
 {

	private static final long serialVersionUID = 2995669229409517888L;
        public _Fun__4____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Array_LT_GP_graph_p_Edge_GT _self____;
        private         cyan.lang._Function_LT_GP_graph_p_Edge_GP_CyBoolean_GT _f;
        private         cyan.lang._Function_LT_GP_graph_p_Edge_GP__Nil_GT _b;
        public _Fun__4____() { }

        public         _Fun__4____(_Array_LT_GP_graph_p_Edge_GT _self____, _Function_LT_GP_graph_p_Edge_GP_CyBoolean_GT _f, _Function_LT_GP_graph_p_Edge_GP__Nil_GT _b)  {

            
        this._self____ = _self____;
        this._f = _f;
        this._b = _b;
        
            } 

        public _Fun__4____  _new_3( _Array_LT_GP_graph_p_Edge_GT _self____, _Function_LT_GP_graph_p_Edge_GP_CyBoolean_GT _f, _Function_LT_GP_graph_p_Edge_GP__Nil_GT _b )  {
             
            return new _Fun__4____(_self____, _f, _b);
        
            } 

        public @Override _Nil  _eval_1( graph._Edge _elem )  {
            CyBoolean tmp700 = _f._eval_1( _elem);
            if ( tmp700.b ) {
                _Nil tmp701 = _b._eval_1( _elem);
            }
            // end of if
            return _Nil.prototype;
            } 

        public @Override _Fun__4____ _clone() {
            
        try {
            return (_Fun__4____ ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
            } 

        public @Override _Fun__4____ _prototype() {
             return prototypeFun_4__;
        
            } 
    public String []getFieldTypeList() { 
        return fieldTypeListFun_4__;
    }
    public String []getFieldList() { 
        return fieldListFun_4__;
    }
    public String asString(int ident) {
        String s =  "Fun_4__ {\n";
        s = s + "super(cyan.lang.Function<graph.Edge,Nil>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        s = s + getWhiteSpaces(ident) + "self__: " + _self____._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "f: " + _f._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "b: " + _b._asString().s + "\n";
        return s;
    } 
    protected _Any parent() {
        return _Function_LT_GP_graph_p_Edge_GP__Nil_GT.prototype;
    }
    protected CyString prototypePackage() {
        return new CyString( "cyan.lang" );
    }
    static final String prototypeName = "Fun_4__";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureListFun_4__; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureListFun_4__; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotListFun_4__; }

}

    
    @SuppressWarnings( { "unused", "cast", "hiding" } )
private class _Fun__5____ extends cyan.lang._Function_LT_GP_graph_p_Edge_GP__Nil_GT
 {

	private static final long serialVersionUID = -1577122236011089459L;
        public _Fun__5____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Array_LT_GP_graph_p_Edge_GT _self____;
        private         cyan.lang.CyString _message;
        public _Fun__5____() { }

        public         _Fun__5____(_Array_LT_GP_graph_p_Edge_GT _self____, CyString _message)  {

            
        this._self____ = _self____;
        this._message = _message;
        
            } 

        public _Fun__5____  _new_2( _Array_LT_GP_graph_p_Edge_GT _self____, CyString _message )  {
             
            return new _Fun__5____(_self____, _message);
        
            } 

        public @Override _Nil  _eval_1( graph._Edge _elem )  {
            String tmp703 =  CyanRuntime.getJavaNameOfUnaryMethod(((CyString ) _message).s);
            java.lang.reflect.Method tmp704 = CyanRuntime.getJavaMethodByName(_elem.getClass(), tmp703, 0);
            if ( tmp704 == null ) { tmp704 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_message", 0); }
            Object tmp705 = null;
            if ( tmp704 != null ) { 
                try {
                    tmp704.setAccessible(true);
                    tmp705 = tmp704.invoke(_elem);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp706 ) {
                	Throwable t__ = tmp706.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp706) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(_message ) );
                }
            }
            else { 
                //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                java.lang.reflect.Method tmp707 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_doesNotUnderstand_2", 2);
                if ( tmp707 == null ) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                }
                try {
                    _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                    _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                    arrayArrayParam._add_1( arrayParam );
                    tmp707.setAccessible(true);
                    tmp705 = tmp707.invoke(_elem, _message, arrayArrayParam);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp708 ) {
                	Throwable t__ = tmp708.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp708) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp703) ) );
                }
            }
            return _Nil.prototype;
            } 

        public @Override _Fun__5____ _clone() {
            
        try {
            return (_Fun__5____ ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
            } 

        public @Override _Fun__5____ _prototype() {
             return prototypeFun_5__;
        
            } 
    public String []getFieldTypeList() { 
        return fieldTypeListFun_5__;
    }
    public String []getFieldList() { 
        return fieldListFun_5__;
    }
    public String asString(int ident) {
        String s =  "Fun_5__ {\n";
        s = s + "super(cyan.lang.Function<graph.Edge,Nil>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        s = s + getWhiteSpaces(ident) + "self__: " + _self____._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "message: " + _message._asString().s + "\n";
        return s;
    } 
    protected _Any parent() {
        return _Function_LT_GP_graph_p_Edge_GP__Nil_GT.prototype;
    }
    protected CyString prototypePackage() {
        return new CyString( "cyan.lang" );
    }
    static final String prototypeName = "Fun_5__";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureListFun_5__; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureListFun_5__; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotListFun_5__; }

}

    
    @SuppressWarnings( { "unused", "cast", "hiding" } )
private class _Fun__6____ extends cyan.lang._Function_LT_GP_CyInt_GP__Nil_GT
 {

	private static final long serialVersionUID = 2062021639695196696L;
        public _Fun__6____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Array_LT_GP_graph_p_Edge_GT _self____;
        private         cyan.lang.CyString _message;
        private         Ref<graph._Edge> _sum;
        public _Fun__6____() { }

        public         _Fun__6____(_Array_LT_GP_graph_p_Edge_GT _self____, CyString _message, Ref<graph._Edge> _sum)  {

            
        this._self____ = _self____;
        this._message = _message;
        this._sum = _sum;
        
            } 

        public _Fun__6____  _new_3( _Array_LT_GP_graph_p_Edge_GT _self____, CyString _message, Ref<graph._Edge> _sum )  {
             
            return new _Fun__6____(_self____, _message, _sum);
        
            } 

        public @Override _Nil  _eval_1( CyInt _i )  {
            /* sum = sum `message: self__[i] */
            graph._Edge tmp710;
            tmp710 = _self____._at_1(_i);
            String tmp711 = "";
            tmp711 += ((CyString ) _message).s;
            char tmp712 = tmp711.charAt(0);
            if ( (tmp712 == '_' || Character.isAlphabetic(tmp712) ) && !tmp711.endsWith(":") ) { tmp711 += ":"; }
            String tmp713 =  CyanRuntime.getJavaNameOfMethod(new String[] { ((CyString ) _message).s }, new int[] {1} );
            java.lang.reflect.Method tmp714 = null;
            if ( tmp713 != null ) {
                tmp714 = CyanRuntime.getJavaMethodByName(_sum.elem.getClass(), tmp713, 1);
            }
            Object tmp715 = null;
            if ( tmp714 != null ) { 
                try {
                    tmp714.setAccessible(true);
                    tmp715 = tmp714.invoke(_sum.elem, tmp710);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp716 ) {
                	Throwable t__ = tmp716.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp716) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp711) ) );
                }
            }
            else { 
                //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                java.lang.reflect.Method tmp717 = CyanRuntime.getJavaMethodByName(_sum.elem.getClass(), "_doesNotUnderstand_2", 2);
                if ( tmp717 == null ) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                }
                try {
                    _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                    _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                    arrayParam._add_1(tmp710);
                    arrayArrayParam._add_1( arrayParam );
                    tmp717.setAccessible(true);
                    tmp715 = tmp717.invoke(_sum.elem, new CyString(tmp711), arrayArrayParam);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp718 ) {
                	Throwable t__ = tmp718.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp718) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp713) ) );
                }
            }
            if ( tmp715 instanceof graph._Edge ) {
                _sum.elem = (graph._Edge ) tmp715;
            }
            else {
                throw new ExceptionContainer__(new _ExceptionCast( new CyString("Cannot cast expression 'sum `message: self__[i]' to 'graph.Edge' in line 616 of file Array(graph.Edge).cyan") ) );
            }
            return _Nil.prototype;
            } 

        public @Override _Fun__6____ _clone() {
            
        try {
            return (_Fun__6____ ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
            } 

        public @Override _Fun__6____ _prototype() {
             return prototypeFun_6__;
        
            } 
    public String []getFieldTypeList() { 
        return fieldTypeListFun_6__;
    }
    public String []getFieldList() { 
        return fieldListFun_6__;
    }
    public String asString(int ident) {
        String s =  "Fun_6__ {\n";
        s = s + "super(cyan.lang.Function<Int,Nil>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
        s = s + asStringThisOnly( ident + _Any.defaultIdentNumber__);

        s = s + getWhiteSpaces(ident) + "}\n";
        return s;
    } 
    @Override 
    protected String asStringThisOnly(int ident) {
        String s = getWhiteSpaces(ident);
        s = s + getWhiteSpaces(ident) + "self__: " + _self____._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "message: " + _message._asString().s + "\n";
        s = s + getWhiteSpaces(ident) + "sum: " + _sum.elem._asString().s + "\n";
        return s;
    } 
    protected _Any parent() {
        return _Function_LT_GP_CyInt_GP__Nil_GT.prototype;
    }
    protected CyString prototypePackage() {
        return new CyString( "cyan.lang" );
    }
    static final String prototypeName = "Fun_6__";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureListFun_6__; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureListFun_6__; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotListFun_6__; }

}

    public String []getFieldTypeList() { 
        return fieldTypeList;
    }
    public String []getFieldList() { 
        return fieldList;
    }
    public String asString(int ident) {
        String s =  "Array<graph.Edge> {\n";
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
    static final String prototypeName = "Array<graph.Edge>";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureList; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureList; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotList; }
    static {
    }

}
