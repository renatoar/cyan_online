package cyan.lang;
import cyanruntime.*;



import java.util.*;


@SuppressWarnings( { "unused", "cast", "hiding" } )
public final class _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT extends _Any
  implements  _Iterable_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT {

	private static final long serialVersionUID = -6386882417611234136L;
    static { 
        try {

          _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT.prototype = new _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT();
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
        public ArrayList<_Tuple_LT_GP_CyInt_GP_CyInt_GT> array = new ArrayList<_Tuple_LT_GP_CyInt_GP_CyInt_GT>();
        public _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT( _Tuple_LT_GP_CyInt_GP_CyInt_GT []anArray ) {
            array = new ArrayList<_Tuple_LT_GP_CyInt_GP_CyInt_GT>();
            for (int i = 0; i < anArray.length; ++i) {
                array.add(anArray[i]);
            }
        }
    

    public     _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT() {

        
            array = new ArrayList<_Tuple_LT_GP_CyInt_GP_CyInt_GT>();
        
        } 

    public     _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT(CyInt _intSizeArray)  {

        
            array = new ArrayList<_Tuple_LT_GP_CyInt_GP_CyInt_GT>(_intSizeArray.n);
        
        } 

    public _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _new() {
         
            return new _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT();         
        } 

    public _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT  _new_1( CyInt _p0 )  {
         
            return new _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT(_p0);
        
        } 

    public @Override CyBoolean  _equal_equal(Object _other) {
        CyBoolean tmp788 = CyBoolean.cyFalse;

        CyBoolean _ret;
        _ret = tmp788;
            {
            if ( _other instanceof _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT ) { 
                _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _another = (_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT ) _other;
                CyInt tmp790 = _another._size();
                CyBoolean tmp789 = _size()._exclamation_equal( tmp790);
                if ( tmp789.b ) {
                    CyBoolean tmp791 = CyBoolean.cyFalse;

                    return tmp791;
                }
                // end of if

                CyInt _i;
                _i = CyInt.zero;
                    {
                    _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem;
                    _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp792 = _another._iterator();
                    while ( tmp792._hasNext().b ) { 
                        _elem = tmp792._next();
                        _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp793;
                        tmp793 = this._at_1(_i);
                        CyBoolean tmp794 = tmp793._exclamation_equal( _elem);
                        if ( tmp794.b ) {
                            CyBoolean tmp795 = CyBoolean.cyFalse;

                            return tmp795;
                        }
                        // end of if
                        _i = _i._succ();
                    }
                }
                CyBoolean tmp796 = CyBoolean.cyTrue;

                return tmp796;
            }
        }
        CyBoolean tmp797 = CyBoolean.cyFalse;

        return tmp797;
        } 

    public @Override CyBoolean  _exclamation_equal(Object _other) {
        CyBoolean tmp799 = this._equal_equal( _other);
        CyBoolean tmp798 = tmp799._exclamation();

        return tmp798;
        } 

    public _Nil  _add_1( _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem )  {
        
            array.add(_elem);
                

        return _Nil.prototype;
        } 

    public _Nil  _replace_2( CyInt _i, _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem )  {
        
            
             try {
                 array.add(_i.n, _elem);
             } 
             catch ( IndexOutOfBoundsException  e ) {
                 throw new ExceptionContainer__( new _ExceptionIndexOutOfBounds(_i));
             }            
            
                

        return _Nil.prototype;
        } 

    public _Nil  _addAll_1( _Iterable_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _list )  {
            {
            _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem;
            _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp800 = _list._iterator();
            while ( tmp800._hasNext().b ) { 
                _elem = tmp800._next();
                _Nil tmp801 = this._add_1( _elem);
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

    public _Tuple_LT_GP_CyInt_GP_CyInt_GT  _at_1( CyInt _index )  {
        
             try {
                return array.get(_index.n);
             } 
             catch ( IndexOutOfBoundsException  e ) {
                 throw new ExceptionContainer__( new _ExceptionIndexOutOfBounds(_index));
             }
                
        } 

    public _Nil  _at_1_put_1( CyInt _index, _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem )  {
        
             try {
                 array.set(_index.n, _elem);
             } 
             catch ( IndexOutOfBoundsException  e ) {
                 throw new ExceptionContainer__( new _ExceptionIndexOutOfBounds(_index));
             }            
                

        return _Nil.prototype;
        } 

    public _Tuple_LT_GP_CyInt_GP_CyInt_GT _last() {
        CyInt tmp803 = _size()._minus( CyInt.one);
        _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp802 = this._at_1( tmp803);

        return tmp802;
        } 

    public _Tuple_LT_GP_CyInt_GP_CyInt_GT _head() {
        _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp804 = this._at_1( CyInt.zero);

        return tmp804;
        } 

    public _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _tail() {
        CyBoolean tmp806 = _size()._equal_equal( CyInt.zero);
        CyBoolean tmp805;
        if ( ! tmp806.b ) { 
            CyBoolean tmp807 = _size()._equal_equal( CyInt.one);
            tmp805 = new CyBoolean(tmp807.b );
        }
        else {
            tmp805 = new CyBoolean(true);
        }
        if ( tmp805.b ) {
            _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp808 = new _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT( );
            return tmp808;
        }
        else {
            CyInt tmp810 = _size()._minus( CyInt.one);
            _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp809 = new _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT( tmp810);
            _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _newArray;
            _newArray = tmp809;
                {
                CyInt _n;
                _Interval_LT_GP_CyInt_GT tmp811 = CyInt.one._dot_dot_lessThan( _size());
                _Iterator_LT_GP_CyInt_GT tmp812 = tmp811._iterator();
                while ( tmp812._hasNext().b ) { 
                    _n = tmp812._next();
                    _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp814 = this._at_1( _n);
                    _Nil tmp813 = _newArray._add_1( tmp814);
                }
            }

            return _newArray;
        }
        // end of if
        } 

    public _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT  _slice_1( _Interval_LT_GP_CyInt_GT _interval )  {
        CyInt tmp816 = _interval._size();
        _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp815 = new _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT( tmp816);
        Ref<_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT> _newArray22 = new Ref<_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT>();
        _newArray22.elem = tmp815;
        _Fun__0____ tmp818 = new _Fun__0____(this, _newArray22);
        _Nil tmp817 = _interval._foreach_1( tmp818);

        return _newArray22.elem;
        } 

    public _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT  _concat_1( _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _other )  {
        _Fun__1____ tmp820 = new _Fun__1____(this);
        _Nil tmp819 = _other._foreach_1( tmp820);

        return this;
        } 

    public CyInt _size() {
        
            return new CyInt(array.size());
                
        } 

    public @Override _Nil  _foreach_1( _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT _b )  {
        _Interval_LT_GP_CyInt_GT tmp821 = CyInt.zero._dot_dot_lessThan( _size());
        _Fun__2____ tmp823 = new _Fun__2____(this, _b);
        _Nil tmp822 = tmp821._foreach_1( tmp823);
        return _Nil.prototype;
        } 

    public _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT  _filter_1( _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP_CyBoolean_GT _f )  {
        _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp824 = new _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT();

        _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _other;
        _other = tmp824;
        _Fun__3____ tmp826 = new _Fun__3____(this, _f, _other);
        _Nil tmp825 = this._foreach_1( tmp826);

        return _other;
        } 

    public _Nil  _filter_1_foreach_1( _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP_CyBoolean_GT _f, _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT _b )  {
        _Fun__4____ tmp828 = new _Fun__4____(this, _f, _b);
        _Nil tmp827 = this._foreach_1( tmp828);
        return _Nil.prototype;
        } 

    public _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT  _map_1( _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _f )  {
        _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp829 = new _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT( );
        _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _mapped;
        _mapped = tmp829;
            {
            _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem;
            _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp830 = this._iterator();
            while ( tmp830._hasNext().b ) { 
                _elem = tmp830._next();
                _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp832 = _f._eval_1( _elem);
                _Nil tmp831 = _mapped._add_1( tmp832);
            }
        }

        return _mapped;
        } 

    public _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT  _verticalBar_greaterThan(_Function_LT_GP__Array_LT_GP__Tuple_LT_G_1922597558182182915_115 _f) {
        _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp833 = _f._eval_1( this);

        return tmp833;
        } 

    public @Override _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _iterator() {
        _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp834 = new _ArrayIterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT( this);
        return tmp834;
        } 

    public CyBoolean  _contains_1( _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem )  {
            {
            _Tuple_LT_GP_CyInt_GP_CyInt_GT _other;
            _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp835 = this._iterator();
            while ( tmp835._hasNext().b ) { 
                _other = tmp835._next();
                CyBoolean tmp836 = _other._equal_equal( _elem);
                if ( tmp836.b ) {
                    CyBoolean tmp837 = CyBoolean.cyTrue;

                    return tmp837;
                }
                // end of if
            }
        }
        CyBoolean tmp838 = CyBoolean.cyFalse;

        return tmp838;
        } 

    public CyBoolean  _notContains_1( _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem )  {
        CyBoolean tmp840 = this._contains_1( _elem);
        CyBoolean tmp839 = tmp840._exclamation();
        return tmp839;
        } 

    public CyBoolean  _containsArray_1( _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _other )  {

        CyInt _count;
        _count = CyInt.zero;
            {
            _Tuple_LT_GP_CyInt_GP_CyInt_GT _otherElem;
            _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp841 = _other._iterator();
            while ( tmp841._hasNext().b ) { 
                _otherElem = tmp841._next();
                    {
                    _Tuple_LT_GP_CyInt_GP_CyInt_GT _selfElem;
                    _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp842 = this._iterator();
                    while ( tmp842._hasNext().b ) { 
                        _selfElem = tmp842._next();
                        CyBoolean tmp843 = _otherElem._equal_equal( _selfElem);
                        if ( tmp843.b ) {
                            _count = _count._succ();
                            break;
                        }
                        // end of if
                    }
                }
            }
        }
        CyInt tmp845 = _other._size();
        CyBoolean tmp844 = _count._equal_equal( tmp845);

        return tmp844;
        } 

    public CyInt  _indexOf_1( _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem )  {

        CyInt _index;
        _index = CyInt.zero;
            {
            _Tuple_LT_GP_CyInt_GP_CyInt_GT _other;
            _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp846 = this._iterator();
            while ( tmp846._hasNext().b ) { 
                _other = tmp846._next();
                CyBoolean tmp847 = _other._equal_equal( _elem);
                if ( tmp847.b ) {

                    return _index;
                }
                // end of if
                _index = _index._succ();
            }
        }
        CyInt tmp848 = CyInt.one._minus();

        return tmp848;
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _prototype() {
         return prototype;
        
        } 

    public @Override CyInt _hashCode() {

        CyInt _hash;
        _hash = CyInt.zero;
            {
            _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem;
            _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp849 = this._iterator();
            while ( tmp849._hasNext().b ) { 
                _elem = tmp849._next();
                /* hash = hash + elem ?hashCode */
                java.lang.reflect.Method tmp852 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_hashCode", 0);
                if ( tmp852 == null ) { tmp852 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "hashCode", 0); }
                Object tmp853 = null;
                if ( tmp852 != null ) { 
                    try {
                        tmp852.setAccessible(true);
                        tmp853 = tmp852.invoke(_elem);
                    }
                    catch ( java.lang.reflect.InvocationTargetException tmp854 ) {
                    	Throwable t__ = tmp854.getCause();
                    	if ( t__ instanceof ExceptionContainer__ ) {
                        	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                    	}
                    	else
                    		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                    }
                    catch (IllegalAccessException | IllegalArgumentException tmp854) {
                            throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("hashCode") ) );
                    }
                }
                else { 
                    //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                    java.lang.reflect.Method tmp855 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_doesNotUnderstand_2", 2);
                    if ( tmp855 == null ) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                    }
                    try {
                        _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                        _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                        arrayArrayParam._add_1( arrayParam );
                        tmp855.setAccessible(true);
                        tmp853 = tmp855.invoke(_elem, new CyString("hashCode"), arrayArrayParam);
                    }
                    catch ( java.lang.reflect.InvocationTargetException tmp856 ) {
                    	Throwable t__ = tmp856.getCause();
                    	if ( t__ instanceof ExceptionContainer__ ) {
                        	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                    	}
                    	else
                    		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                    }
                    catch (IllegalAccessException | IllegalArgumentException tmp856) {
                            throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("_hashCode") ) );
                    }
                }
                CyInt tmp857;
                if ( tmp853 instanceof CyInt ) 
                    tmp857 = (CyInt ) tmp853;
                else
                    throw new ExceptionContainer__(new _ExceptionCast( new CyString("Cannot cast expression 'elem ?hashCode' to 'cyan.lang.Int' in line 272 of file Array(Tuple(Int,Int)).cyan") ) );
                CyInt tmp850 = _hash._plus( tmp857);
                _hash = tmp850;
            }
        }

        return _hash;
        } 

    public @Override CyString  _asString_1( CyInt _ident )  {

        CyString _s;
        _s = (new CyString(""));
            {
            CyInt _i;
            _Interval_LT_GP_CyInt_GT tmp858 = CyInt.one._dot_dot( _ident);
            _Iterator_LT_GP_CyInt_GT tmp859 = tmp858._iterator();
            while ( tmp859._hasNext().b ) { 
                _i = tmp859._next();
                /* s = s ++ " " */
                CyString tmp860 = _s._plus_plus( (new CyString(" ")));
                _s = tmp860;
            }
        }
        /* s = s ++ "[ " */
        CyString tmp861 = _s._plus_plus( (new CyString("[ ")));
        _s = tmp861;

        CyInt _size2;
        _size2 = _size();
            {
            _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem;
            _Iterator_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT tmp862 = this._iterator();
            while ( tmp862._hasNext().b ) { 
                _elem = tmp862._next();
                /* s = s ++ elem ?asStringQuoteIfString */
                java.lang.reflect.Method tmp865 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_asStringQuoteIfString", 0);
                if ( tmp865 == null ) { tmp865 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "asStringQuoteIfString", 0); }
                Object tmp866 = null;
                if ( tmp865 != null ) { 
                    try {
                        tmp865.setAccessible(true);
                        tmp866 = tmp865.invoke(_elem);
                    }
                    catch ( java.lang.reflect.InvocationTargetException tmp867 ) {
                    	Throwable t__ = tmp867.getCause();
                    	if ( t__ instanceof ExceptionContainer__ ) {
                        	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                    	}
                    	else
                    		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                    }
                    catch (IllegalAccessException | IllegalArgumentException tmp867) {
                            throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("asStringQuoteIfString") ) );
                    }
                }
                else { 
                    //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                    java.lang.reflect.Method tmp868 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_doesNotUnderstand_2", 2);
                    if ( tmp868 == null ) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                    }
                    try {
                        _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                        _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                        arrayArrayParam._add_1( arrayParam );
                        tmp868.setAccessible(true);
                        tmp866 = tmp868.invoke(_elem, new CyString("asStringQuoteIfString"), arrayArrayParam);
                    }
                    catch ( java.lang.reflect.InvocationTargetException tmp869 ) {
                    	Throwable t__ = tmp869.getCause();
                    	if ( t__ instanceof ExceptionContainer__ ) {
                        	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                    	}
                    	else
                    		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                    }
                    catch (IllegalAccessException | IllegalArgumentException tmp869) {
                            throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("_asStringQuoteIfString") ) );
                    }
                }
                _Any tmp870;
                if ( tmp866 instanceof _Any ) 
                    tmp870 = (_Any ) tmp866;
                else
                    throw new ExceptionContainer__(new _ExceptionCast( new CyString("Cannot cast expression 'elem ?asStringQuoteIfString' to 'cyan.lang.Any' in line 283 of file Array(Tuple(Int,Int)).cyan") ) );
                CyString tmp863 = _s._plus_plus( tmp870);
                _s = tmp863;
                _size2 = _size2._minus( new CyInt(1) );
                CyBoolean tmp871 = _size2._greaterThan( CyInt.zero);
                if ( tmp871.b ) {
                    /* s = s ++ ", " */
                    CyString tmp872 = _s._plus_plus( (new CyString(", ")));
                    _s = tmp872;
                }
                // end of if
            }
        }
        /* s = s ++ " ]" */
        CyString tmp873 = _s._plus_plus( (new CyString(" ]")));
        _s = tmp873;

        return _s;
        } 

    public _Nil  _apply_1( CyString _message )  {
        _Fun__5____ tmp875 = new _Fun__5____(this, _message);
        _Nil tmp874 = this._foreach_1( tmp875);
        return _Nil.prototype;
        } 

    public Object  _apply_1_select_1( CyString _message, CyString _slot )  {
        String tmp877 =  CyanRuntime.getJavaNameOfUnaryMethod(((CyString ) _slot).s);
        _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp878;
        tmp878 = this._at_1(CyInt.zero);
        java.lang.reflect.Method tmp879 = CyanRuntime.getJavaMethodByName(tmp878.getClass(), tmp877, 0);
        if ( tmp879 == null ) { tmp879 = CyanRuntime.getJavaMethodByName(tmp878.getClass(), "_slot", 0); }
        Object tmp880 = null;
        if ( tmp879 != null ) { 
            try {
                tmp879.setAccessible(true);
                tmp880 = tmp879.invoke(tmp878);
            }
            catch ( java.lang.reflect.InvocationTargetException tmp881 ) {
            	Throwable t__ = tmp881.getCause();
            	if ( t__ instanceof ExceptionContainer__ ) {
                	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
            	}
            	else
            		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
            }
            catch (IllegalAccessException | IllegalArgumentException tmp881) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(_slot ) );
            }
        }
        else { 
            //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
            java.lang.reflect.Method tmp882 = CyanRuntime.getJavaMethodByName(tmp878.getClass(), "_doesNotUnderstand_2", 2);
            if ( tmp882 == null ) {
                throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
            }
            try {
                _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                arrayArrayParam._add_1( arrayParam );
                tmp882.setAccessible(true);
                tmp880 = tmp882.invoke(tmp878, _slot, arrayArrayParam);
            }
            catch ( java.lang.reflect.InvocationTargetException tmp883 ) {
            	Throwable t__ = tmp883.getCause();
            	if ( t__ instanceof ExceptionContainer__ ) {
                	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
            	}
            	else
            		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
            }
            catch (IllegalAccessException | IllegalArgumentException tmp883) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp877) ) );
            }
        }

        Object _sum;
        _sum = tmp880;

        CyInt _i;
        _i = CyInt.one;
        while ( true ) { 
            CyBoolean tmp884 = _i._lessThan( _size());
            if ( !tmp884.b ) break;
            _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp885;
            tmp885 = this._at_1(_i);

            _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem;
            _elem = tmp885;
            /* sum = sum `message: (elem `slot) */
            String tmp888 =  CyanRuntime.getJavaNameOfUnaryMethod(((CyString ) _slot).s);
            java.lang.reflect.Method tmp889 = CyanRuntime.getJavaMethodByName(_elem.getClass(), tmp888, 0);
            if ( tmp889 == null ) { tmp889 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_slot", 0); }
            Object tmp890 = null;
            if ( tmp889 != null ) { 
                try {
                    tmp889.setAccessible(true);
                    tmp890 = tmp889.invoke(_elem);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp891 ) {
                	Throwable t__ = tmp891.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp891) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(_slot ) );
                }
            }
            else { 
                //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                java.lang.reflect.Method tmp892 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_doesNotUnderstand_2", 2);
                if ( tmp892 == null ) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                }
                try {
                    _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                    _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                    arrayArrayParam._add_1( arrayParam );
                    tmp892.setAccessible(true);
                    tmp890 = tmp892.invoke(_elem, _slot, arrayArrayParam);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp893 ) {
                	Throwable t__ = tmp893.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp893) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp888) ) );
                }
            }
            String tmp894 = "";
            tmp894 += ((CyString ) _message).s;
            char tmp895 = tmp894.charAt(0);
            if ( (tmp895 == '_' || Character.isAlphabetic(tmp895) ) && !tmp894.endsWith(":") ) { tmp894 += ":"; }
            String tmp896 =  CyanRuntime.getJavaNameOfMethod(new String[] { ((CyString ) _message).s }, new int[] {1} );
            java.lang.reflect.Method tmp897 = null;
            if ( tmp896 != null ) {
                tmp897 = CyanRuntime.getJavaMethodByName(_sum.getClass(), tmp896, 1);
            }
            Object tmp898 = null;
            if ( tmp897 != null ) { 
                try {
                    tmp897.setAccessible(true);
                    tmp898 = tmp897.invoke(_sum, tmp890);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp899 ) {
                	Throwable t__ = tmp899.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp899) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp894) ) );
                }
            }
            else { 
                //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                java.lang.reflect.Method tmp900 = CyanRuntime.getJavaMethodByName(_sum.getClass(), "_doesNotUnderstand_2", 2);
                if ( tmp900 == null ) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                }
                try {
                    _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                    _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                    arrayParam._add_1(tmp890);
                    arrayArrayParam._add_1( arrayParam );
                    tmp900.setAccessible(true);
                    tmp898 = tmp900.invoke(_sum, new CyString(tmp894), arrayArrayParam);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp901 ) {
                	Throwable t__ = tmp901.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp901) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp896) ) );
                }
            }
            _sum = tmp898;
            _i = _i._succ();
        }

        return _sum;
        } 

    public Object  _dot_plus(CyString _message) {
        _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp902;
        tmp902 = this._at_1(CyInt.zero);

        Ref<_Tuple_LT_GP_CyInt_GP_CyInt_GT> _sum = new Ref<_Tuple_LT_GP_CyInt_GP_CyInt_GT>();
        _sum.elem = tmp902;
        _Interval_LT_GP_CyInt_GT tmp903 = CyInt.one._dot_dot_lessThan( _size());
        _Fun__6____ tmp905 = new _Fun__6____(this, _message, _sum);
        _Nil tmp904 = tmp903._foreach_1( tmp905);

        return _sum.elem;
        } 

    public _Nil  _dot_mult(CyString _message) {
        _Nil tmp906 = this._apply_1( _message);
        return _Nil.prototype;
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _clone() {
        
        try {
            return (_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT ) this.clone(); 
        } catch (CloneNotSupportedException e) { }
        return null;
        
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp907 = new _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        return tmp907;
        } 

    public @Override _Array_LT_GP__Any_GT _getAnnotListNameDoesNotCollide____() {
        _Array_LT_GP__Any_GT tmp908 = new _Array_LT_GP__Any_GT();

        return tmp908;
        } 

    public @Override _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _getSlotFeatureListNameDoesNotCollide____() {
        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT tmp909 = new _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT();

        _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT _slotFeatureList__name__does__not__collide____;
        _slotFeatureList__name__does__not__collide____ = tmp909;

        return _slotFeatureList__name__does__not__collide____;
        } 
    public static _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT prototype;
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
        new CyString("eval: Tuple<Int,Int>"),
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
        new CyString("eval: Tuple<Int,Int>"),
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
        new CyString("eval: Tuple<Int,Int>"),
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
        new CyString("eval: Tuple<Int,Int>"),
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
        new CyString("add: Tuple<Int,Int>"),
        new CyString("replace: Int, Tuple<Int,Int>"),
        new CyString("addAll: Iterable<Tuple<Int,Int>>"),
        new CyString("clear"),
        new CyString("isEmpty"),
        new CyString("remove: Int"),
        new CyString("at: Int"),
        new CyString("at: Int put: Tuple<Int,Int>"),
        new CyString("last"),
        new CyString("head"),
        new CyString("tail"),
        new CyString("slice: Interval<Int>"),
        new CyString("concat: Array<Tuple<Int,Int>>"),
        new CyString("size"),
        new CyString("foreach: Function<Tuple<Int,Int>,Nil>"),
        new CyString("filter: Function<Tuple<Int,Int>,Boolean>"),
        new CyString("filter: Function<Tuple<Int,Int>,Boolean> foreach: Function<Tuple<Int,Int>,Nil>"),
        new CyString("map: Function<Tuple<Int,Int>,Tuple<Int,Int>>"),
        new CyString("|> Function<Array<Tuple<Int,Int>>,Array<Tuple<Int,Int>>>"),
        new CyString("iterator"),
        new CyString("contains: Tuple<Int,Int>"),
        new CyString("notContains: Tuple<Int,Int>"),
        new CyString("containsArray: Array<Tuple<Int,Int>>"),
        new CyString("indexOf: Tuple<Int,Int>"),
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
        private         cyan.lang._Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____;
        private         Ref<cyan.lang._Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT> _newArray22;
        public _Fun__0____() { }

        public         _Fun__0____(_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, Ref<_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT> _newArray22)  {

            
        this._self____ = _self____;
        this._newArray22 = _newArray22;
        
            } 

        public _Fun__0____  _new_2( _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, Ref<_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT> _newArray22 )  {
             
            return new _Fun__0____(_self____, _newArray22);
        
            } 

        public @Override _Nil  _eval_1( CyInt _i )  {
            _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp911 = _self____._at_1( _i);
            _Nil tmp910 = _newArray22.elem._add_1( tmp911);
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
private class _Fun__1____ extends cyan.lang._Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT
 {

	private static final long serialVersionUID = 279144571410163665L;
        public _Fun__1____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____;
        public _Fun__1____() { }

        public         _Fun__1____(_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____)  {

            
        this._self____ = _self____;
        
            } 

        public _Fun__1____  _new_1( _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____ )  {
             
            return new _Fun__1____(_self____);
        
            } 

        public @Override _Nil  _eval_1( _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem )  {
            _Nil tmp912 = _self____._add_1( _elem);
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
        s = s + "super(cyan.lang.Function<Tuple<Int,Int>,Nil>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
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
        return _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT.prototype;
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
        private         cyan.lang._Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____;
        private         cyan.lang._Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT _b;
        public _Fun__2____() { }

        public         _Fun__2____(_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT _b)  {

            
        this._self____ = _self____;
        this._b = _b;
        
            } 

        public _Fun__2____  _new_2( _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT _b )  {
             
            return new _Fun__2____(_self____, _b);
        
            } 

        public @Override _Nil  _eval_1( CyInt _i )  {
            _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp914 = _self____._at_1( _i);
            _Nil tmp913 = _b._eval_1( tmp914);
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
private class _Fun__3____ extends cyan.lang._Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT
 {

	private static final long serialVersionUID = -7392324740483831445L;
        public _Fun__3____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____;
        private         cyan.lang._Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP_CyBoolean_GT _f;
        private         cyan.lang._Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _other;
        public _Fun__3____() { }

        public         _Fun__3____(_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP_CyBoolean_GT _f, _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _other)  {

            
        this._self____ = _self____;
        this._f = _f;
        this._other = _other;
        
            } 

        public _Fun__3____  _new_3( _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP_CyBoolean_GT _f, _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _other )  {
             
            return new _Fun__3____(_self____, _f, _other);
        
            } 

        public @Override _Nil  _eval_1( _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem )  {
            CyBoolean tmp915 = _f._eval_1( _elem);
            if ( tmp915.b ) {
                _Nil tmp916 = _other._add_1( _elem);
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
        s = s + "super(cyan.lang.Function<Tuple<Int,Int>,Nil>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
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
        return _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT.prototype;
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
private class _Fun__4____ extends cyan.lang._Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT
 {

	private static final long serialVersionUID = 2995669229409517888L;
        public _Fun__4____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____;
        private         cyan.lang._Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP_CyBoolean_GT _f;
        private         cyan.lang._Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT _b;
        public _Fun__4____() { }

        public         _Fun__4____(_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP_CyBoolean_GT _f, _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT _b)  {

            
        this._self____ = _self____;
        this._f = _f;
        this._b = _b;
        
            } 

        public _Fun__4____  _new_3( _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP_CyBoolean_GT _f, _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT _b )  {
             
            return new _Fun__4____(_self____, _f, _b);
        
            } 

        public @Override _Nil  _eval_1( _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem )  {
            CyBoolean tmp917 = _f._eval_1( _elem);
            if ( tmp917.b ) {
                _Nil tmp918 = _b._eval_1( _elem);
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
        s = s + "super(cyan.lang.Function<Tuple<Int,Int>,Nil>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
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
        return _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT.prototype;
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
private class _Fun__5____ extends cyan.lang._Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT
 {

	private static final long serialVersionUID = -1577122236011089459L;
        public _Fun__5____(NonExistingJavaClass doNotExit) {
            super();
        }
        private         cyan.lang._Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____;
        private         cyan.lang.CyString _message;
        public _Fun__5____() { }

        public         _Fun__5____(_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, CyString _message)  {

            
        this._self____ = _self____;
        this._message = _message;
        
            } 

        public _Fun__5____  _new_2( _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, CyString _message )  {
             
            return new _Fun__5____(_self____, _message);
        
            } 

        public @Override _Nil  _eval_1( _Tuple_LT_GP_CyInt_GP_CyInt_GT _elem )  {
            String tmp920 =  CyanRuntime.getJavaNameOfUnaryMethod(((CyString ) _message).s);
            java.lang.reflect.Method tmp921 = CyanRuntime.getJavaMethodByName(_elem.getClass(), tmp920, 0);
            if ( tmp921 == null ) { tmp921 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_message", 0); }
            Object tmp922 = null;
            if ( tmp921 != null ) { 
                try {
                    tmp921.setAccessible(true);
                    tmp922 = tmp921.invoke(_elem);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp923 ) {
                	Throwable t__ = tmp923.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp923) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(_message ) );
                }
            }
            else { 
                //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                java.lang.reflect.Method tmp924 = CyanRuntime.getJavaMethodByName(_elem.getClass(), "_doesNotUnderstand_2", 2);
                if ( tmp924 == null ) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                }
                try {
                    _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                    _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                    arrayArrayParam._add_1( arrayParam );
                    tmp924.setAccessible(true);
                    tmp922 = tmp924.invoke(_elem, _message, arrayArrayParam);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp925 ) {
                	Throwable t__ = tmp925.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp925) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp920) ) );
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
        s = s + "super(cyan.lang.Function<Tuple<Int,Int>,Nil>):"  + super.asStringThisOnly( ident + _Any.defaultIdentNumber__ );
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
        return _Function_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GP__Nil_GT.prototype;
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
        private         cyan.lang._Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____;
        private         cyan.lang.CyString _message;
        private         Ref<cyan.lang._Tuple_LT_GP_CyInt_GP_CyInt_GT> _sum;
        public _Fun__6____() { }

        public         _Fun__6____(_Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, CyString _message, Ref<_Tuple_LT_GP_CyInt_GP_CyInt_GT> _sum)  {

            
        this._self____ = _self____;
        this._message = _message;
        this._sum = _sum;
        
            } 

        public _Fun__6____  _new_3( _Array_LT_GP__Tuple_LT_GP_CyInt_GP_CyInt_GT_GT _self____, CyString _message, Ref<_Tuple_LT_GP_CyInt_GP_CyInt_GT> _sum )  {
             
            return new _Fun__6____(_self____, _message, _sum);
        
            } 

        public @Override _Nil  _eval_1( CyInt _i )  {
            /* sum = sum `message: self__[i] */
            _Tuple_LT_GP_CyInt_GP_CyInt_GT tmp927;
            tmp927 = _self____._at_1(_i);
            String tmp928 = "";
            tmp928 += ((CyString ) _message).s;
            char tmp929 = tmp928.charAt(0);
            if ( (tmp929 == '_' || Character.isAlphabetic(tmp929) ) && !tmp928.endsWith(":") ) { tmp928 += ":"; }
            String tmp930 =  CyanRuntime.getJavaNameOfMethod(new String[] { ((CyString ) _message).s }, new int[] {1} );
            java.lang.reflect.Method tmp931 = null;
            if ( tmp930 != null ) {
                tmp931 = CyanRuntime.getJavaMethodByName(_sum.elem.getClass(), tmp930, 1);
            }
            Object tmp932 = null;
            if ( tmp931 != null ) { 
                try {
                    tmp931.setAccessible(true);
                    tmp932 = tmp931.invoke(_sum.elem, tmp927);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp933 ) {
                	Throwable t__ = tmp933.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp933) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp928) ) );
                }
            }
            else { 
                //	func doesNotUnderstand: (String methodName, Array<Array<Dyn>> args)
                java.lang.reflect.Method tmp934 = CyanRuntime.getJavaMethodByName(_sum.elem.getClass(), "_doesNotUnderstand_2", 2);
                if ( tmp934 == null ) {
                    throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString("doesNotUnderstand") ) );
                }
                try {
                    _Array_LT_GP__Array_LT_GP_Object_GT_GT arrayArrayParam = new _Array_LT_GP__Array_LT_GP_Object_GT_GT();
                    _Array_LT_GP_Object_GT arrayParam = new _Array_LT_GP_Object_GT();
                    arrayParam._add_1(tmp927);
                    arrayArrayParam._add_1( arrayParam );
                    tmp934.setAccessible(true);
                    tmp932 = tmp934.invoke(_sum.elem, new CyString(tmp928), arrayArrayParam);
                }
                catch ( java.lang.reflect.InvocationTargetException tmp935 ) {
                	Throwable t__ = tmp935.getCause();
                	if ( t__ instanceof ExceptionContainer__ ) {
                    	throw new ExceptionContainer__( ((ExceptionContainer__) t__).elem );
                	}
                	else
                		throw new ExceptionContainer__( new _ExceptionJavaException(t__));
                }
                catch (IllegalAccessException | IllegalArgumentException tmp935) {
                        throw new ExceptionContainer__( new _ExceptionDoesNotUnderstand(new CyString(tmp930) ) );
                }
            }
            if ( tmp932 instanceof _Tuple_LT_GP_CyInt_GP_CyInt_GT ) {
                _sum.elem = (_Tuple_LT_GP_CyInt_GP_CyInt_GT ) tmp932;
            }
            else {
                throw new ExceptionContainer__(new _ExceptionCast( new CyString("Cannot cast expression 'sum `message: self__[i]' to 'cyan.lang.Tuple<Int,Int>' in line 616 of file Array(Tuple(Int,Int)).cyan") ) );
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
        String s =  "Array<Tuple<Int,Int>> {\n";
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
    static final String prototypeName = "Array<Tuple<Int,Int>>";
    @Override     public String getPrototypeName() { return prototypeName; }
    protected boolean isInterface() { return false; }

    @Override public _Array_LT_GP__Tuple_LT_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getFeatureList() { return featureList; }
    @Override public _Array_LT_GP__Tuple_LT_GP__slotName_GP_CyString_GP__key_GP_CyString_GP__value_GP__Any_GT_GT getSlotFeatureList() { return slotFeatureList; }
    @Override public _Array_LT_GP__Any_GT getAnnotList() { return annotList; }
    static {
    }

}
