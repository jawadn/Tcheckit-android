package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public final class UserAccount extends EntityMother  implements org.ksoap2.serialization.KvmSerializable{
	
		
    private java.lang.Long id;

    private java.lang.String login;

    private com.fortutech.tcheckit.ejb.sessions.Brand oneBrand;

    private com.fortutech.tcheckit.ejb.sessions.Person onePerson;

    private java.lang.String password;

    public UserAccount() {
        super();
    }
    /**
     * Add by KBA
     */
    public UserAccount(SoapObject so) {
        super(so);
        this.setId(SoapUtils.getSoapLong(so, "id"));
        this.setLogin(SoapUtils.getSoapString(so, "login"));
        this.setPassword(SoapUtils.getSoapString(so, "password"));
        
        Consumer person = new Consumer((SoapObject) so.getProperty("onePerson"));
        this.setOnePerson(person);
        
    }
    
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setLogin(java.lang.String login) {
        this.login = login;
    }

    public java.lang.String getLogin() {
        return this.login;
    }

    public void setOneBrand(com.fortutech.tcheckit.ejb.sessions.Brand oneBrand) {
        this.oneBrand = oneBrand;
    }

    public com.fortutech.tcheckit.ejb.sessions.Brand getOneBrand(com.fortutech.tcheckit.ejb.sessions.Brand oneBrand) {
        return this.oneBrand;
    }

    public void setOnePerson(com.fortutech.tcheckit.ejb.sessions.Person onePerson) {
        this.onePerson = onePerson;
    }

    public com.fortutech.tcheckit.ejb.sessions.Person getOnePerson() {
        return this.onePerson;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public java.lang.String getPassword() {
        return this.password;
    }

    public int getPropertyCount() {
        return 5;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return id;
        case 1: return login;
        case 2: return oneBrand;
        case 3: return onePerson;
        case 4: return password;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: id = (java.lang.Long) __obj; break;
        case 1: login = (java.lang.String) __obj; break;
        case 2: oneBrand = (com.fortutech.tcheckit.ejb.sessions.Brand) __obj; break;
        case 3: onePerson = (com.fortutech.tcheckit.ejb.sessions.Person) __obj; break;
        case 4: password = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "id";
            __info.type = java.lang.Long.class; break;
        case 1:
            __info.name = "login";
            __info.type = java.lang.String.class; break;
        case 2:
            __info.name = "oneBrand";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Brand.class; break;
        case 3:
            __info.name = "onePerson";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Person.class; break;
        case 4:
            __info.name = "password";
            __info.type = java.lang.String.class; break;
        }
    }

}
