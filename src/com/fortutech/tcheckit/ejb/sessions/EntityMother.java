package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public class EntityMother extends SoapObject implements org.ksoap2.serialization.KvmSerializable{
    private java.util.Calendar dateCreated;

    private java.util.Calendar dateDeleted;

    private java.util.Calendar dateUpdated;

    private com.fortutech.tcheckit.ejb.sessions.Flag oneFlag;

    public EntityMother() {
        super("", "");
    }
    public EntityMother(SoapObject so) {
        super("", "");
        this.setDateCreated(SoapUtils.getSoapCalendar(so,"dateCreated"));
        this.setDateDeleted(SoapUtils.getSoapCalendar(so,"dateDeleted"));
        this.setDateUpdated(SoapUtils.getSoapCalendar(so,"dateUpdated"));
        this.setOneFlag(new Flag(SoapUtils.getSoapString(so, "oneFlag")));
    }
    public void setDateCreated(java.util.Calendar dateCreated) {
        this.dateCreated = dateCreated;
    }

    public java.util.Calendar getDateCreated() {
        return this.dateCreated;
    }

    public void setDateDeleted(java.util.Calendar dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    public java.util.Calendar getDateDeleted() {
        return this.dateDeleted;
    }

    public void setDateUpdated(java.util.Calendar dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public java.util.Calendar getDateUpdated() {
        return this.dateUpdated;
    }

    public void setOneFlag(com.fortutech.tcheckit.ejb.sessions.Flag oneFlag) {
        this.oneFlag = oneFlag;
    }

    public com.fortutech.tcheckit.ejb.sessions.Flag getOneFlag() {
        return this.oneFlag;
    }

    public int getPropertyCount() {
        return 2;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return dateUpdated  != null ? dateUpdated : "";
        case 1: return oneFlag != null ? oneFlag.get_value_() : "";
        case 2: return dateCreated != null ? dateCreated : "";
        case 3: return dateDeleted != null ? dateDeleted : "";
       
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: dateUpdated = (java.util.Calendar) __obj; break;
        case 1: oneFlag = (com.fortutech.tcheckit.ejb.sessions.Flag) __obj; break;
        case 2: dateCreated = (java.util.Calendar) __obj; break;
        case 3: dateDeleted = (java.util.Calendar) __obj; break;
        
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "dateUpdated";
            __info.type = dateUpdated != null ? java.util.Calendar.class : java.lang.String.class; break;
        case 1:
            __info.name = "oneFlag";
            __info.type = java.lang.String.class; break;
        case 2:
            __info.name = "dateCreated";
            __info.type = dateCreated != null ? java.util.Calendar.class : java.lang.String.class; break;
        case 3:
            __info.name = "dateDeleted";
            __info.type = dateDeleted != null ? java.util.Calendar.class : java.lang.String.class; break;
        
        }
    }

}
