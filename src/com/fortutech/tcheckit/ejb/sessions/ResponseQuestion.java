package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class ResponseQuestion extends SoapObject {
    private com.fortutech.tcheckit.ejb.sessions.Answer answer;

    private java.lang.Long id;

    private com.fortutech.tcheckit.ejb.sessions.Question oneQuestion;

    public ResponseQuestion() {
        super("", "");
    }
    public void setAnswer(com.fortutech.tcheckit.ejb.sessions.Answer answer) {
        this.answer = answer;
    }

    public com.fortutech.tcheckit.ejb.sessions.Answer getAnswer(com.fortutech.tcheckit.ejb.sessions.Answer answer) {
        return this.answer;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId(java.lang.Long id) {
        return this.id;
    }

    public void setOneQuestion(com.fortutech.tcheckit.ejb.sessions.Question oneQuestion) {
        this.oneQuestion = oneQuestion;
    }

    public com.fortutech.tcheckit.ejb.sessions.Question getOneQuestion(com.fortutech.tcheckit.ejb.sessions.Question oneQuestion) {
        return this.oneQuestion;
    }

    public int getPropertyCount() {
        return 3;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return answer;
        case 1: return id;
        case 2: return oneQuestion;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: answer = (com.fortutech.tcheckit.ejb.sessions.Answer) __obj; break;
        case 1: id = (java.lang.Long) __obj; break;
        case 2: oneQuestion = (com.fortutech.tcheckit.ejb.sessions.Question) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "answer";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Answer.class; break;
        case 1:
            __info.name = "id";
            __info.type = java.lang.Long.class; break;
        case 2:
            __info.name = "oneQuestion";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Question.class; break;
        }
    }

}
