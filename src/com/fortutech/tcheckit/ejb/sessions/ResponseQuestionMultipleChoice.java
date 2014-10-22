package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class ResponseQuestionMultipleChoice extends SoapObject {
    private com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion[] listChoice;

    public ResponseQuestionMultipleChoice() {
        super("", "");
    }
    public void setListChoice(com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion[] listChoice) {
        this.listChoice = listChoice;
    }

    public com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion[] getListChoice(com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion[] listChoice) {
        return this.listChoice;
    }

    public int getPropertyCount() {
        return 1;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "listChoice";
        }
    }

}
