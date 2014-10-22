package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public final class Address extends com.fortutech.tcheckit.ejb.sessions.EntityMother  implements org.ksoap2.serialization.KvmSerializable  {
    private java.lang.String city = "";

    private java.lang.String country= "";

    private java.lang.Float latitude;

    private java.lang.Float longitude;

    private java.lang.String postalCode= "";

    private java.lang.String region = "";

    private java.lang.String street = "";

    private java.lang.String street2 = "";

    public Address() {
        super();
    }
    public Address(SoapObject so) {
        super(so);
        this.setCity(SoapUtils.getSoapString(so,"city"));
        this.setCountry(SoapUtils.getSoapString(so,"country"));
        this.setLatitude(SoapUtils.getSoapFloat(so,"latitude"));
        this.setLongitude(SoapUtils.getSoapFloat(so,"longitude"));
        this.setOneFlag(new Flag(SoapUtils.getSoapString(so, "oneFlag")));
        this.setPostalCode(SoapUtils.getSoapString(so,"postalCode"));
        this.setRegion(SoapUtils.getSoapString(so,"region"));
        this.setStreet(SoapUtils.getSoapString(so,"street"));
        this.setStreet2(SoapUtils.getSoapString(so,"street2"));
    }
    public void setCity(java.lang.String city) {
        this.city = city;
    }

    public java.lang.String getCity() {
        return this.city;
    }

    public void setCountry(java.lang.String country) {
        this.country = country;
    }

    public java.lang.String getCountry() {
        return this.country;
    }

    public void setLatitude(java.lang.Float latitude) {
        this.latitude = latitude;
    }

    public java.lang.Float getLatitude() {
        return this.latitude;
    }

    public void setLongitude(java.lang.Float longitude) {
        this.longitude = longitude;
    }

    public java.lang.Float getLongitude() {
        return this.longitude;
    }

    public void setPostalCode(java.lang.String postalCode) {
        this.postalCode = postalCode;
    }

    public java.lang.String getPostalCode() {
        return this.postalCode;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setStreet(java.lang.String street) {
        this.street = street;
    }

    public java.lang.String getStreet() {
        return this.street;
    }

    public void setStreet2(java.lang.String street2) {
        this.street2 = street2;
    }

    public java.lang.String getStreet2() {
        return this.street2;
    }

    public int getPropertyCount() {
        return 8;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return city != null ? city : "";
        case 1: return country != null ? country : "";
        case 2: return latitude != null ? latitude : "";
        case 3: return longitude != null ? longitude : "";
        case 4: return postalCode != null ? postalCode : "";
        case 5: return region != null ? region : "";
        case 6: return street != null ? street : "";
        case 7: return street2 != null ? street2 : "";
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: city = (java.lang.String) __obj; break;
        case 1: country = (java.lang.String) __obj; break;
        case 2: latitude = (java.lang.Float) __obj; break;
        case 3: longitude = (java.lang.Float) __obj; break;
        case 4: postalCode = (java.lang.String) __obj; break;
        case 5: region = (java.lang.String) __obj; break;
        case 6: street = (java.lang.String) __obj; break;
        case 7: street2 = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "city";
            __info.type = java.lang.String.class; break;
        case 1:
            __info.name = "country";
            __info.type = java.lang.String.class; break;
        case 2:
            __info.name = "latitude";
            __info.type = java.lang.Float.class; break;
        case 3:
            __info.name = "longitude";
            __info.type = java.lang.Float.class; break;
        case 4:
            __info.name = "postalCode";
            __info.type = java.lang.String.class; break;
        case 5:
            __info.name = "region";
            __info.type = java.lang.String.class; break;
        case 6:
            __info.name = "street";
            __info.type = java.lang.String.class; break;
        case 7:
            __info.name = "street2";
            __info.type = java.lang.String.class; break;
        }
    }

}
