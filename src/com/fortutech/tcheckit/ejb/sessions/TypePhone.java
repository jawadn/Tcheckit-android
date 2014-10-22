package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class TypePhone extends SoapObject {
    private java.lang.String _value_;

    public java.util.HashMap _table_;

    public java.lang.String _android;

    public java.lang.String _iphone;

    public java.lang.String _autre;

    public com.fortutech.tcheckit.ejb.sessions.TypePhone android;

    public com.fortutech.tcheckit.ejb.sessions.TypePhone iphone;

    public com.fortutech.tcheckit.ejb.sessions.TypePhone autre;

    public TypePhone() {
        super("", "");
    }
    public void set_value_(java.lang.String _value_) {
        this._value_ = _value_;
    }

    public java.lang.String get_value_(java.lang.String _value_) {
        return this._value_;
    }

    public void set_table_(java.util.HashMap _table_) {
        this._table_ = _table_;
    }

    public java.util.HashMap get_table_(java.util.HashMap _table_) {
        return this._table_;
    }

    public void set_android(java.lang.String _android) {
        this._android = _android;
    }

    public java.lang.String get_android(java.lang.String _android) {
        return this._android;
    }

    public void set_iphone(java.lang.String _iphone) {
        this._iphone = _iphone;
    }

    public java.lang.String get_iphone(java.lang.String _iphone) {
        return this._iphone;
    }

    public void set_autre(java.lang.String _autre) {
        this._autre = _autre;
    }

    public java.lang.String get_autre(java.lang.String _autre) {
        return this._autre;
    }

    public void setAndroid(com.fortutech.tcheckit.ejb.sessions.TypePhone android) {
        this.android = android;
    }

    public com.fortutech.tcheckit.ejb.sessions.TypePhone getAndroid(com.fortutech.tcheckit.ejb.sessions.TypePhone android) {
        return this.android;
    }

    public void setIphone(com.fortutech.tcheckit.ejb.sessions.TypePhone iphone) {
        this.iphone = iphone;
    }

    public com.fortutech.tcheckit.ejb.sessions.TypePhone getIphone(com.fortutech.tcheckit.ejb.sessions.TypePhone iphone) {
        return this.iphone;
    }

    public void setAutre(com.fortutech.tcheckit.ejb.sessions.TypePhone autre) {
        this.autre = autre;
    }

    public com.fortutech.tcheckit.ejb.sessions.TypePhone getAutre(com.fortutech.tcheckit.ejb.sessions.TypePhone autre) {
        return this.autre;
    }

    public int getPropertyCount() {
        return 6;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return _value_;
        case 1: return _table_;
        case 2: return _android;
        case 3: return _iphone;
        case 4: return _autre;
        case 5: return android;
        case 6: return iphone;
        case 7: return autre;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: _value_ = (java.lang.String) __obj; break;
        case 1: _table_ = (java.util.HashMap) __obj; break;
        case 2: _android = (java.lang.String) __obj; break;
        case 3: _iphone = (java.lang.String) __obj; break;
        case 4: _autre = (java.lang.String) __obj; break;
        case 5: android = (com.fortutech.tcheckit.ejb.sessions.TypePhone) __obj; break;
        case 6: iphone = (com.fortutech.tcheckit.ejb.sessions.TypePhone) __obj; break;
        case 7: autre = (com.fortutech.tcheckit.ejb.sessions.TypePhone) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "_value_";
            __info.type = java.lang.String.class; break;
        case 1:
            __info.name = "_table_";
            __info.type = java.util.HashMap.class; break;
        case 2:
            __info.name = "_android";
            __info.type = java.lang.String.class; break;
        case 3:
            __info.name = "_iphone";
            __info.type = java.lang.String.class; break;
        case 4:
            __info.name = "_autre";
            __info.type = java.lang.String.class; break;
        case 5:
            __info.name = "android";
            __info.type = com.fortutech.tcheckit.ejb.sessions.TypePhone.class; break;
        case 6:
            __info.name = "iphone";
            __info.type = com.fortutech.tcheckit.ejb.sessions.TypePhone.class; break;
        case 7:
            __info.name = "autre";
            __info.type = com.fortutech.tcheckit.ejb.sessions.TypePhone.class; break;
        }
    }

}
