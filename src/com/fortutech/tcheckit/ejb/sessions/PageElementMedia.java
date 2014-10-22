package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public final class PageElementMedia extends PageElement implements
org.ksoap2.serialization.KvmSerializable {
    private com.fortutech.tcheckit.ejb.sessions.Media oneMedia;

    
    public PageElementMedia() {
        super();
    }
    public PageElementMedia(SoapObject so) {
        super(so);
        this.setOneMedia(new Media(SoapUtils.getSoapObject(so, "oneMedia")));
    }
    public PageElementMedia(Media m) {
        super();
        this.oneMedia = m;
    }
    public void setOneMedia(com.fortutech.tcheckit.ejb.sessions.Media oneMedia) {
        this.oneMedia = oneMedia;
    }

    public com.fortutech.tcheckit.ejb.sessions.Media getOneMedia() {
        return this.oneMedia;
    }

    public int getPropertyCount() {
        return 1;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return oneMedia;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: oneMedia = (com.fortutech.tcheckit.ejb.sessions.Media) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "oneMedia";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Media.class; break;
        }
    }

}
