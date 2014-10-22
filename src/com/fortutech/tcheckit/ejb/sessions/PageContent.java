package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public final class PageContent extends com.fortutech.tcheckit.ejb.sessions.EntityMother implements
org.ksoap2.serialization.KvmSerializable {
    private java.lang.Long id;

    private com.fortutech.tcheckit.ejb.sessions.PageElement[] listPageElement;

    public PageContent() {
        super();
    }
    public PageContent(SoapObject so) {
        super(so);
        this.setId(SoapUtils.getSoapLong(so, "id"));
        this.setListPageElement(PageElement.parse(so,"listPageElement"));
        
    }
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setListPageElement(com.fortutech.tcheckit.ejb.sessions.PageElement[] listPageElement) {
        this.listPageElement = listPageElement;
    }

    public com.fortutech.tcheckit.ejb.sessions.PageElement[] getListPageElement() {
        return this.listPageElement;
    }

    public int getPropertyCount() {
        return 2;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return id;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: id = (java.lang.Long) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "id";
            __info.type = java.lang.Long.class; break;
        case 1:
            __info.name = "listPageElement";
        }
    }
	

}
