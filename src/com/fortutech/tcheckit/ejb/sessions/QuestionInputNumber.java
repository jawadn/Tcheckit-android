package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public final class QuestionInputNumber extends Question {
    private java.lang.String unavailabilityLabel;

    public QuestionInputNumber() {
        super();
        
    }
    
    public QuestionInputNumber(SoapObject so) {
        super(so);
        this.setUnavailabilityLabel(SoapUtils.getSoapString(so, "unavailabilityLabel"));
    }
    public void setUnavailabilityLabel(java.lang.String unavailabilityLabel) {
        this.unavailabilityLabel = unavailabilityLabel;
    }

    public java.lang.String getUnavailabilityLabel(java.lang.String unavailabilityLabel) {
        return this.unavailabilityLabel;
    }

    public int getPropertyCount() {
        return 1;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return unavailabilityLabel;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: unavailabilityLabel = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "unavailabilityLabel";
            __info.type = java.lang.String.class; break;
        }
    }

}
