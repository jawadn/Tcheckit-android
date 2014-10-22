package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class ResponseQuestionUniqueChoice extends SoapObject {
    private com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion oneChoice;

    public ResponseQuestionUniqueChoice() {
        super("", "");
    }
    public void setOneChoice(com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion oneChoice) {
        this.oneChoice = oneChoice;
    }

    public com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion getOneChoice(com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion oneChoice) {
        return this.oneChoice;
    }

    public int getPropertyCount() {
        return 1;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return oneChoice;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: oneChoice = (com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "oneChoice";
            __info.type = com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion.class; break;
        }
    }

}
