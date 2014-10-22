package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public final class PageElementText extends PageElement implements
org.ksoap2.serialization.KvmSerializable  {
    private java.lang.String content;

    private java.lang.String title;

    public PageElementText() {
        super();
    }
    public PageElementText(SoapObject so) {
        super(so);
        this.setContent(SoapUtils.getSoapString(so,"content"));
        this.setTitle(SoapUtils.getSoapString(so,"title"));
    }
    public void setContent(java.lang.String content) {
        this.content = content;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public int getPropertyCount() {
        return 2;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return content;
        case 1: return title;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: content = (java.lang.String) __obj; break;
        case 1: title = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "content";
            __info.type = java.lang.String.class; break;
        case 1:
            __info.name = "title";
            __info.type = java.lang.String.class; break;
        }
    }

}
