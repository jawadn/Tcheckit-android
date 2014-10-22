package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class AnswerStatusEnum extends SoapObject {
    private java.lang.String _value_;

    public java.util.HashMap _table_;

    public java.lang.String _submit;

    public java.lang.String _validated;

    public java.lang.String _refused;

    public com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum submit;

    public com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum validated;

    public com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum refused;

    public AnswerStatusEnum() {
        super("", "");
    }
    public void set_value_(java.lang.String _value_) {
        this._value_ = _value_;
    }

    public java.lang.String get_value_(java.lang.String _value_) {
        return this._value_;
    }

    public void set_table_(java.util.HashMap _table_) {
        this._table_ = _table_;
    }

    public java.util.HashMap get_table_(java.util.HashMap _table_) {
        return this._table_;
    }

    public void set_submit(java.lang.String _submit) {
        this._submit = _submit;
    }

    public java.lang.String get_submit(java.lang.String _submit) {
        return this._submit;
    }

    public void set_validated(java.lang.String _validated) {
        this._validated = _validated;
    }

    public java.lang.String get_validated(java.lang.String _validated) {
        return this._validated;
    }

    public void set_refused(java.lang.String _refused) {
        this._refused = _refused;
    }

    public java.lang.String get_refused(java.lang.String _refused) {
        return this._refused;
    }

    public void setSubmit(com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum submit) {
        this.submit = submit;
    }

    public com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum getSubmit(com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum submit) {
        return this.submit;
    }

    public void setValidated(com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum validated) {
        this.validated = validated;
    }

    public com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum getValidated(com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum validated) {
        return this.validated;
    }

    public void setRefused(com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum refused) {
        this.refused = refused;
    }

    public com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum getRefused(com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum refused) {
        return this.refused;
    }

    public int getPropertyCount() {
        return 6;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return _value_;
        case 1: return _table_;
        case 2: return _submit;
        case 3: return _validated;
        case 4: return _refused;
        case 5: return submit;
        case 6: return validated;
        case 7: return refused;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: _value_ = (java.lang.String) __obj; break;
        case 1: _table_ = (java.util.HashMap) __obj; break;
        case 2: _submit = (java.lang.String) __obj; break;
        case 3: _validated = (java.lang.String) __obj; break;
        case 4: _refused = (java.lang.String) __obj; break;
        case 5: submit = (com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum) __obj; break;
        case 6: validated = (com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum) __obj; break;
        case 7: refused = (com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "_value_";
            __info.type = java.lang.String.class; break;
        case 1:
            __info.name = "_table_";
            __info.type = java.util.HashMap.class; break;
        case 2:
            __info.name = "_submit";
            __info.type = java.lang.String.class; break;
        case 3:
            __info.name = "_validated";
            __info.type = java.lang.String.class; break;
        case 4:
            __info.name = "_refused";
            __info.type = java.lang.String.class; break;
        case 5:
            __info.name = "submit";
            __info.type = com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum.class; break;
        case 6:
            __info.name = "validated";
            __info.type = com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum.class; break;
        case 7:
            __info.name = "refused";
            __info.type = com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum.class; break;
        }
    }

}
