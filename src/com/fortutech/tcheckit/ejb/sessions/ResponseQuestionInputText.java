package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class ResponseQuestionInputText extends SoapObject {
    private java.lang.String oneAnswer;

    public ResponseQuestionInputText() {
        super("", "");
    }
    public void setOneAnswer(java.lang.String oneAnswer) {
        this.oneAnswer = oneAnswer;
    }

    public java.lang.String getOneAnswer(java.lang.String oneAnswer) {
        return this.oneAnswer;
    }

    public int getPropertyCount() {
        return 1;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return oneAnswer;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: oneAnswer = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "oneAnswer";
            __info.type = java.lang.String.class; break;
        }
    }

}
