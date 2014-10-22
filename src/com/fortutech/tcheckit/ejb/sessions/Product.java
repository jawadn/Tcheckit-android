package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public final class Product extends com.fortutech.tcheckit.ejb.sessions.EntityMother  implements org.ksoap2.serialization.KvmSerializable {
    private java.lang.Long id;

    private java.lang.String name;

    private int position;

    public Product() {
        super();
    }
    
    public Product(SoapObject so) {
        super(so);
        this.setId(SoapUtils.getSoapLong(so, "id"));
        this.setName(SoapUtils.getSoapString(so, "name"));
        this.setOneFlag(new Flag(SoapUtils.getSoapString(so, "oneFlag")));
        this.setPosition(SoapUtils.getSoapInteger(so, "position"));
    }
    
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId(java.lang.Long id) {
        return this.id;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getName(java.lang.String name) {
        return this.name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition(int position) {
        return this.position;
    }

    public int getPropertyCount() {
        return 3;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return id;
        case 1: return name;
        case 2: return new Integer(position);
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: id = (java.lang.Long) __obj; break;
        case 1: name = (java.lang.String) __obj; break;
        case 2: position = Integer.parseInt(__obj.toString()); break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "id";
            __info.type = java.lang.Long.class; break;
        case 1:
            __info.name = "name";
            __info.type = java.lang.String.class; break;
        case 2:
            __info.name = "position";
            __info.type = Integer.class; break;
        }
    }

}
