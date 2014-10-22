package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class FamilyStatus extends SoapObject {
    private java.lang.String _value_;

    /*public java.util.HashMap _table_;

    public java.lang.String _single;

    public java.lang.String _married;

    public java.lang.String _separated;

    public java.lang.String _divorced;

    public java.lang.String _pacs;

    public com.fortutech.tcheckit.ejb.sessions.FamilyStatus single;

    public com.fortutech.tcheckit.ejb.sessions.FamilyStatus married;

    public com.fortutech.tcheckit.ejb.sessions.FamilyStatus separated;

    public com.fortutech.tcheckit.ejb.sessions.FamilyStatus divorced;

    public com.fortutech.tcheckit.ejb.sessions.FamilyStatus pacs;*/

    public FamilyStatus() {
        super("", "");
    }
    public void set_value_(java.lang.String _value_) {
        this._value_ = _value_;
    }

    public java.lang.String get_value_() {
        return this._value_;
    }
/*
    public void set_table_(java.util.HashMap _table_) {
        this._table_ = _table_;
    }

    public java.util.HashMap get_table_(java.util.HashMap _table_) {
        return this._table_;
    }

    public void set_single(java.lang.String _single) {
        this._single = _single;
    }

    public java.lang.String get_single(java.lang.String _single) {
        return this._single;
    }

    public void set_married(java.lang.String _married) {
        this._married = _married;
    }

    public java.lang.String get_married(java.lang.String _married) {
        return this._married;
    }

    public void set_separated(java.lang.String _separated) {
        this._separated = _separated;
    }

    public java.lang.String get_separated(java.lang.String _separated) {
        return this._separated;
    }

    public void set_divorced(java.lang.String _divorced) {
        this._divorced = _divorced;
    }

    public java.lang.String get_divorced(java.lang.String _divorced) {
        return this._divorced;
    }

    public void set_pacs(java.lang.String _pacs) {
        this._pacs = _pacs;
    }

    public java.lang.String get_pacs(java.lang.String _pacs) {
        return this._pacs;
    }

    public void setSingle(com.fortutech.tcheckit.ejb.sessions.FamilyStatus single) {
        this.single = single;
    }

    public com.fortutech.tcheckit.ejb.sessions.FamilyStatus getSingle(com.fortutech.tcheckit.ejb.sessions.FamilyStatus single) {
        return this.single;
    }

    public void setMarried(com.fortutech.tcheckit.ejb.sessions.FamilyStatus married) {
        this.married = married;
    }

    public com.fortutech.tcheckit.ejb.sessions.FamilyStatus getMarried(com.fortutech.tcheckit.ejb.sessions.FamilyStatus married) {
        return this.married;
    }

    public void setSeparated(com.fortutech.tcheckit.ejb.sessions.FamilyStatus separated) {
        this.separated = separated;
    }

    public com.fortutech.tcheckit.ejb.sessions.FamilyStatus getSeparated(com.fortutech.tcheckit.ejb.sessions.FamilyStatus separated) {
        return this.separated;
    }

    public void setDivorced(com.fortutech.tcheckit.ejb.sessions.FamilyStatus divorced) {
        this.divorced = divorced;
    }

    public com.fortutech.tcheckit.ejb.sessions.FamilyStatus getDivorced(com.fortutech.tcheckit.ejb.sessions.FamilyStatus divorced) {
        return this.divorced;
    }

    public void setPacs(com.fortutech.tcheckit.ejb.sessions.FamilyStatus pacs) {
        this.pacs = pacs;
    }

    public com.fortutech.tcheckit.ejb.sessions.FamilyStatus getPacs(com.fortutech.tcheckit.ejb.sessions.FamilyStatus pacs) {
        return this.pacs;
    }
*/
    public int getPropertyCount() {
        return 1;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return _value_;
     /*   case 1: return _table_;
        case 2: return _single;
        case 3: return _married;
        case 4: return _separated;
        case 5: return _divorced;
        case 6: return _pacs;
        case 7: return single;
        case 8: return married;
        case 9: return separated;
        case 10: return divorced;
        case 11: return pacs;*/
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: _value_ = (java.lang.String) __obj; break;
      /*  case 1: _table_ = (java.util.HashMap) __obj; break;
        case 2: _single = (java.lang.String) __obj; break;
        case 3: _married = (java.lang.String) __obj; break;
        case 4: _separated = (java.lang.String) __obj; break;
        case 5: _divorced = (java.lang.String) __obj; break;
        case 6: _pacs = (java.lang.String) __obj; break;
        case 7: single = (com.fortutech.tcheckit.ejb.sessions.FamilyStatus) __obj; break;
        case 8: married = (com.fortutech.tcheckit.ejb.sessions.FamilyStatus) __obj; break;
        case 9: separated = (com.fortutech.tcheckit.ejb.sessions.FamilyStatus) __obj; break;
        case 10: divorced = (com.fortutech.tcheckit.ejb.sessions.FamilyStatus) __obj; break;
        case 11: pacs = (com.fortutech.tcheckit.ejb.sessions.FamilyStatus) __obj; break;*/
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "oneFlag";
            __info.type = java.lang.String.class; break;
    /*    case 1:
            __info.name = "_table_";
            __info.type = java.util.HashMap.class; break;
        case 2:
            __info.name = "_single";
            __info.type = java.lang.String.class; break;
        case 3:
            __info.name = "_married";
            __info.type = java.lang.String.class; break;
        case 4:
            __info.name = "_separated";
            __info.type = java.lang.String.class; break;
        case 5:
            __info.name = "_divorced";
            __info.type = java.lang.String.class; break;
        case 6:
            __info.name = "_pacs";
            __info.type = java.lang.String.class; break;
        case 7:
            __info.name = "single";
            __info.type = com.fortutech.tcheckit.ejb.sessions.FamilyStatus.class; break;
        case 8:
            __info.name = "married";
            __info.type = com.fortutech.tcheckit.ejb.sessions.FamilyStatus.class; break;
        case 9:
            __info.name = "separated";
            __info.type = com.fortutech.tcheckit.ejb.sessions.FamilyStatus.class; break;
        case 10:
            __info.name = "divorced";
            __info.type = com.fortutech.tcheckit.ejb.sessions.FamilyStatus.class; break;
        case 11:
            __info.name = "pacs";
            __info.type = com.fortutech.tcheckit.ejb.sessions.FamilyStatus.class; break;*/
        }
    }

}
