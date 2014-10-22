package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class CompanyMapCompanyDenominationEntry extends SoapObject {
    private java.lang.String key;

    private java.lang.String value;

    public CompanyMapCompanyDenominationEntry() {
        super("", "");
    }
    public void setKey(java.lang.String key) {
        this.key = key;
    }

    public java.lang.String getKey(java.lang.String key) {
        return this.key;
    }

    public void setValue(java.lang.String value) {
        this.value = value;
    }

    public java.lang.String getValue(java.lang.String value) {
        return this.value;
    }

    public int getPropertyCount() {
        return 2;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return key;
        case 1: return value;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: key = (java.lang.String) __obj; break;
        case 1: value = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "key";
            __info.type = java.lang.String.class; break;
        case 1:
            __info.name = "value";
            __info.type = java.lang.String.class; break;
        }
    }

}
