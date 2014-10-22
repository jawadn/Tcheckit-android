package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class MobileApplication extends SoapObject {
    private java.lang.Long id;

    private java.lang.String iphoneApnsCert;

    private java.lang.String name;

    private java.lang.String passwordApnsCert;

    public MobileApplication() {
        super("", "");
    }
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId(java.lang.Long id) {
        return this.id;
    }

    public void setIphoneApnsCert(java.lang.String iphoneApnsCert) {
        this.iphoneApnsCert = iphoneApnsCert;
    }

    public java.lang.String getIphoneApnsCert(java.lang.String iphoneApnsCert) {
        return this.iphoneApnsCert;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getName(java.lang.String name) {
        return this.name;
    }

    public void setPasswordApnsCert(java.lang.String passwordApnsCert) {
        this.passwordApnsCert = passwordApnsCert;
    }

    public java.lang.String getPasswordApnsCert(java.lang.String passwordApnsCert) {
        return this.passwordApnsCert;
    }

    public int getPropertyCount() {
        return 4;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return id;
        case 1: return iphoneApnsCert;
        case 2: return name;
        case 3: return passwordApnsCert;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: id = (java.lang.Long) __obj; break;
        case 1: iphoneApnsCert = (java.lang.String) __obj; break;
        case 2: name = (java.lang.String) __obj; break;
        case 3: passwordApnsCert = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "id";
            __info.type = java.lang.Long.class; break;
        case 1:
            __info.name = "iphoneApnsCert";
            __info.type = java.lang.String.class; break;
        case 2:
            __info.name = "name";
            __info.type = java.lang.String.class; break;
        case 3:
            __info.name = "passwordApnsCert";
            __info.type = java.lang.String.class; break;
        }
    }

}
