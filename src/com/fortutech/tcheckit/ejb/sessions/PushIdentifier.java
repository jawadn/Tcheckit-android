package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class PushIdentifier extends SoapObject {
    private java.lang.Long id;

    private com.fortutech.tcheckit.ejb.sessions.MobileApplication oneMobileApplication;

    private com.fortutech.tcheckit.ejb.sessions.PushProvider onePushProvider;

    private com.fortutech.tcheckit.ejb.sessions.UserAccount oneUserAccount;

    private java.lang.String token;

    public PushIdentifier() {
        super("", "");
    }
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId(java.lang.Long id) {
        return this.id;
    }

    public void setOneMobileApplication(com.fortutech.tcheckit.ejb.sessions.MobileApplication oneMobileApplication) {
        this.oneMobileApplication = oneMobileApplication;
    }

    public com.fortutech.tcheckit.ejb.sessions.MobileApplication getOneMobileApplication(com.fortutech.tcheckit.ejb.sessions.MobileApplication oneMobileApplication) {
        return this.oneMobileApplication;
    }

    public void setOnePushProvider(com.fortutech.tcheckit.ejb.sessions.PushProvider onePushProvider) {
        this.onePushProvider = onePushProvider;
    }

    public com.fortutech.tcheckit.ejb.sessions.PushProvider getOnePushProvider(com.fortutech.tcheckit.ejb.sessions.PushProvider onePushProvider) {
        return this.onePushProvider;
    }

    public void setOneUserAccount(com.fortutech.tcheckit.ejb.sessions.UserAccount oneUserAccount) {
        this.oneUserAccount = oneUserAccount;
    }

    public com.fortutech.tcheckit.ejb.sessions.UserAccount getOneUserAccount(com.fortutech.tcheckit.ejb.sessions.UserAccount oneUserAccount) {
        return this.oneUserAccount;
    }

    public void setToken(java.lang.String token) {
        this.token = token;
    }

    public java.lang.String getToken(java.lang.String token) {
        return this.token;
    }

    public int getPropertyCount() {
        return 5;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return id;
        case 1: return oneMobileApplication;
        case 2: return onePushProvider;
        case 3: return oneUserAccount;
        case 4: return token;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: id = (java.lang.Long) __obj; break;
        case 1: oneMobileApplication = (com.fortutech.tcheckit.ejb.sessions.MobileApplication) __obj; break;
        case 2: onePushProvider = (com.fortutech.tcheckit.ejb.sessions.PushProvider) __obj; break;
        case 3: oneUserAccount = (com.fortutech.tcheckit.ejb.sessions.UserAccount) __obj; break;
        case 4: token = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "id";
            __info.type = java.lang.Long.class; break;
        case 1:
            __info.name = "oneMobileApplication";
            __info.type = com.fortutech.tcheckit.ejb.sessions.MobileApplication.class; break;
        case 2:
            __info.name = "onePushProvider";
            __info.type = com.fortutech.tcheckit.ejb.sessions.PushProvider.class; break;
        case 3:
            __info.name = "oneUserAccount";
            __info.type = com.fortutech.tcheckit.ejb.sessions.UserAccount.class; break;
        case 4:
            __info.name = "token";
            __info.type = java.lang.String.class; break;
        }
    }

}
