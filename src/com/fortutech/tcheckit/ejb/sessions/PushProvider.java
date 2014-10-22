package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class PushProvider extends SoapObject {
    private java.lang.String _value_;

    public java.util.HashMap _table_;

    public java.lang.String _gcm;

    public java.lang.String _apns;

    public com.fortutech.tcheckit.ejb.sessions.PushProvider gcm;

    public com.fortutech.tcheckit.ejb.sessions.PushProvider apns;

    public PushProvider() {
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

    public void set_gcm(java.lang.String _gcm) {
        this._gcm = _gcm;
    }

    public java.lang.String get_gcm(java.lang.String _gcm) {
        return this._gcm;
    }

    public void set_apns(java.lang.String _apns) {
        this._apns = _apns;
    }

    public java.lang.String get_apns(java.lang.String _apns) {
        return this._apns;
    }

    public void setGcm(com.fortutech.tcheckit.ejb.sessions.PushProvider gcm) {
        this.gcm = gcm;
    }

    public com.fortutech.tcheckit.ejb.sessions.PushProvider getGcm(com.fortutech.tcheckit.ejb.sessions.PushProvider gcm) {
        return this.gcm;
    }

    public void setApns(com.fortutech.tcheckit.ejb.sessions.PushProvider apns) {
        this.apns = apns;
    }

    public com.fortutech.tcheckit.ejb.sessions.PushProvider getApns(com.fortutech.tcheckit.ejb.sessions.PushProvider apns) {
        return this.apns;
    }

    public int getPropertyCount() {
        return 4;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return _value_;
        case 1: return _table_;
        case 2: return _gcm;
        case 3: return _apns;
        case 4: return gcm;
        case 5: return apns;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: _value_ = (java.lang.String) __obj; break;
        case 1: _table_ = (java.util.HashMap) __obj; break;
        case 2: _gcm = (java.lang.String) __obj; break;
        case 3: _apns = (java.lang.String) __obj; break;
        case 4: gcm = (com.fortutech.tcheckit.ejb.sessions.PushProvider) __obj; break;
        case 5: apns = (com.fortutech.tcheckit.ejb.sessions.PushProvider) __obj; break;
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
            __info.name = "_gcm";
            __info.type = java.lang.String.class; break;
        case 3:
            __info.name = "_apns";
            __info.type = java.lang.String.class; break;
        case 4:
            __info.name = "gcm";
            __info.type = com.fortutech.tcheckit.ejb.sessions.PushProvider.class; break;
        case 5:
            __info.name = "apns";
            __info.type = com.fortutech.tcheckit.ejb.sessions.PushProvider.class; break;
        }
    }

}
