package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class Civility extends SoapObject {
    private java.lang.String _value_;

    public java.util.HashMap _table_;

    public static java.lang.String _Mademoiselle = "Mademoiselle";

    public static java.lang.String _Madame = "Madame";

    public static java.lang.String _Monsieur ="Monsieur";

    public com.fortutech.tcheckit.ejb.sessions.Civility Mademoiselle;

    public com.fortutech.tcheckit.ejb.sessions.Civility Madame;

    public com.fortutech.tcheckit.ejb.sessions.Civility Monsieur;

    public Civility() {
        super("", "");
    }
    public Civility(String s) {
        super("", "");
        this.set_value_(s);
    }
    public void set_value_(java.lang.String _value_) {
        this._value_ = _value_;
    }

    public java.lang.String get_value_() {
        return this._value_;
    }

    public void set_table_(java.util.HashMap _table_) {
        this._table_ = _table_;
    }

    public java.util.HashMap get_table_(java.util.HashMap _table_) {
        return this._table_;
    }

    public void set_Mademoiselle(java.lang.String _Mademoiselle) {
        this._Mademoiselle = _Mademoiselle;
    }

    public java.lang.String get_Mademoiselle(java.lang.String _Mademoiselle) {
        return this._Mademoiselle;
    }

    public void set_Madame(java.lang.String _Madame) {
        this._Madame = _Madame;
    }

    public java.lang.String get_Madame(java.lang.String _Madame) {
        return this._Madame;
    }

    public void set_Monsieur(java.lang.String _Monsieur) {
        this._Monsieur = _Monsieur;
    }

    public java.lang.String get_Monsieur(java.lang.String _Monsieur) {
        return this._Monsieur;
    }

    public void setMademoiselle(com.fortutech.tcheckit.ejb.sessions.Civility Mademoiselle) {
        this.Mademoiselle = Mademoiselle;
    }

    public com.fortutech.tcheckit.ejb.sessions.Civility getMademoiselle(com.fortutech.tcheckit.ejb.sessions.Civility Mademoiselle) {
        return this.Mademoiselle;
    }

    public void setMadame(com.fortutech.tcheckit.ejb.sessions.Civility Madame) {
        this.Madame = Madame;
    }

    public com.fortutech.tcheckit.ejb.sessions.Civility getMadame(com.fortutech.tcheckit.ejb.sessions.Civility Madame) {
        return this.Madame;
    }

    public void setMonsieur(com.fortutech.tcheckit.ejb.sessions.Civility Monsieur) {
        this.Monsieur = Monsieur;
    }

    public com.fortutech.tcheckit.ejb.sessions.Civility getMonsieur(com.fortutech.tcheckit.ejb.sessions.Civility Monsieur) {
        return this.Monsieur;
    }

    public int getPropertyCount() {
        return 6;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return _value_;
        case 1: return _table_;
        case 2: return _Mademoiselle;
        case 3: return _Madame;
        case 4: return _Monsieur;
        case 5: return Mademoiselle;
        case 6: return Madame;
        case 7: return Monsieur;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: _value_ = (java.lang.String) __obj; break;
        case 1: _table_ = (java.util.HashMap) __obj; break;
        case 2: _Mademoiselle = (java.lang.String) __obj; break;
        case 3: _Madame = (java.lang.String) __obj; break;
        case 4: _Monsieur = (java.lang.String) __obj; break;
        case 5: Mademoiselle = (com.fortutech.tcheckit.ejb.sessions.Civility) __obj; break;
        case 6: Madame = (com.fortutech.tcheckit.ejb.sessions.Civility) __obj; break;
        case 7: Monsieur = (com.fortutech.tcheckit.ejb.sessions.Civility) __obj; break;
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
            __info.name = "_Mademoiselle";
            __info.type = java.lang.String.class; break;
        case 3:
            __info.name = "_Madame";
            __info.type = java.lang.String.class; break;
        case 4:
            __info.name = "_Monsieur";
            __info.type = java.lang.String.class; break;
        case 5:
            __info.name = "Mademoiselle";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Civility.class; break;
        case 6:
            __info.name = "Madame";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Civility.class; break;
        case 7:
            __info.name = "Monsieur";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Civility.class; break;
        }
    }

}
