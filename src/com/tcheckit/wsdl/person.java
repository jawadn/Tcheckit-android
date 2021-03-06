package com.tcheckit.wsdl;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.5
//
// Date Of Creation: 2/21/2014 7:29:15 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//
import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import com.tcheckit.wsdl.WS_Enums.civility;
import com.tcheckit.wsdl.WS_Enums.familyStatus;
import com.tcheckit.wsdl.WS_Enums.flag;

public class person implements KvmSerializable {
    
    public String birthday;
    public boolean birthdaySpecified;
    public String birthplace;
    public civility civility;
    public boolean civilitySpecified;
    public String email;
    public familyStatus familyStatus;
    public boolean familyStatusSpecified;
    public String firstName;
    public String homePhone;
    public long id;
    public boolean idSpecified;
    public String mobilePhone;
    public String name;
    public String nationality;
    public address oneAddress;
    public String dateCreated;
    public boolean dateCreatedSpecified;
    public String dateDeleted;
    public boolean dateDeletedSpecified;
    public String dateUpdated;
    public boolean dateUpdatedSpecified;
    public flag oneFlag;
    public boolean oneFlagSpecified;
    
    public person(){}
    
    public person(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("birthday"))
        {
            Object obj = soapObject.getProperty("birthday");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                birthday = j.toString();
            }else if (obj!= null && obj instanceof String){
                birthday = (String) obj;
            }
        }
        if (soapObject.hasProperty("birthdaySpecified"))
        {
            Object obj = soapObject.getProperty("birthdaySpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                birthdaySpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                birthdaySpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("birthplace"))
        {
            Object obj = soapObject.getProperty("birthplace");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                birthplace = j.toString();
            }else if (obj!= null && obj instanceof String){
                birthplace = (String) obj;
            }
        }
        if (soapObject.hasProperty("civility"))
        {
            Object obj = soapObject.getProperty("civility");
            if (obj!= null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive)obj;
                civility = civility.fromString(j.toString());
            }
        }
        if (soapObject.hasProperty("civilitySpecified"))
        {
            Object obj = soapObject.getProperty("civilitySpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                civilitySpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                civilitySpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("email"))
        {
            Object obj = soapObject.getProperty("email");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                email = j.toString();
            }else if (obj!= null && obj instanceof String){
                email = (String) obj;
            }
        }
        if (soapObject.hasProperty("familyStatus"))
        {
            Object obj = soapObject.getProperty("familyStatus");
            if (obj!= null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive)obj;
                familyStatus = familyStatus.fromString(j.toString());
            }
        }
        if (soapObject.hasProperty("familyStatusSpecified"))
        {
            Object obj = soapObject.getProperty("familyStatusSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                familyStatusSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                familyStatusSpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("firstName"))
        {
            Object obj = soapObject.getProperty("firstName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                firstName = j.toString();
            }else if (obj!= null && obj instanceof String){
                firstName = (String) obj;
            }
        }
        if (soapObject.hasProperty("homePhone"))
        {
            Object obj = soapObject.getProperty("homePhone");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                homePhone = j.toString();
            }else if (obj!= null && obj instanceof String){
                homePhone = (String) obj;
            }
        }
        if (soapObject.hasProperty("id"))
        {
            Object obj = soapObject.getProperty("id");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                id = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                id = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("idSpecified"))
        {
            Object obj = soapObject.getProperty("idSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                idSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                idSpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("mobilePhone"))
        {
            Object obj = soapObject.getProperty("mobilePhone");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                mobilePhone = j.toString();
            }else if (obj!= null && obj instanceof String){
                mobilePhone = (String) obj;
            }
        }
        if (soapObject.hasProperty("name"))
        {
            Object obj = soapObject.getProperty("name");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                name = j.toString();
            }else if (obj!= null && obj instanceof String){
                name = (String) obj;
            }
        }
        if (soapObject.hasProperty("nationality"))
        {
            Object obj = soapObject.getProperty("nationality");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                nationality = j.toString();
            }else if (obj!= null && obj instanceof String){
                nationality = (String) obj;
            }
        }
        if (soapObject.hasProperty("oneAddress"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("oneAddress");
            oneAddress =  new address (j);
            
        }
        if (soapObject.hasProperty("dateCreated"))
        {
            Object obj = soapObject.getProperty("dateCreated");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                dateCreated = j.toString();
            }else if (obj!= null && obj instanceof String){
                dateCreated = (String) obj;
            }
        }
        if (soapObject.hasProperty("dateCreatedSpecified"))
        {
            Object obj = soapObject.getProperty("dateCreatedSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                dateCreatedSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                dateCreatedSpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("dateDeleted"))
        {
            Object obj = soapObject.getProperty("dateDeleted");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                dateDeleted = j.toString();
            }else if (obj!= null && obj instanceof String){
                dateDeleted = (String) obj;
            }
        }
        if (soapObject.hasProperty("dateDeletedSpecified"))
        {
            Object obj = soapObject.getProperty("dateDeletedSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                dateDeletedSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                dateDeletedSpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("dateUpdated"))
        {
            Object obj = soapObject.getProperty("dateUpdated");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                dateUpdated = j.toString();
            }else if (obj!= null && obj instanceof String){
                dateUpdated = (String) obj;
            }
        }
        if (soapObject.hasProperty("dateUpdatedSpecified"))
        {
            Object obj = soapObject.getProperty("dateUpdatedSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                dateUpdatedSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                dateUpdatedSpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("oneFlag"))
        {
            Object obj = soapObject.getProperty("oneFlag");
            if (obj!= null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive)obj;
                oneFlag = flag.fromString(j.toString());
            }
        }
        if (soapObject.hasProperty("oneFlagSpecified"))
        {
            Object obj = soapObject.getProperty("oneFlagSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                oneFlagSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                oneFlagSpecified = (Boolean) obj;
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
            case 0:
                return birthday;
            case 1:
                return birthdaySpecified;
            case 2:
                return birthplace;
            case 3:
                return civility.toString();
            case 4:
                return civilitySpecified;
            case 5:
                return email;
            case 6:
                return familyStatus.toString();
            case 7:
                return familyStatusSpecified;
            case 8:
                return firstName;
            case 9:
                return homePhone;
            case 10:
                return id;
            case 11:
                return idSpecified;
            case 12:
                return mobilePhone;
            case 13:
                return name;
            case 14:
                return nationality;
            case 15:
                return oneAddress;
            case 16:
                return dateCreated;
            case 17:
                return dateCreatedSpecified;
            case 18:
                return dateDeleted;
            case 19:
                return dateDeletedSpecified;
            case 20:
                return dateUpdated;
            case 21:
                return dateUpdatedSpecified;
            case 22:
                return oneFlag.toString();
            case 23:
                return oneFlagSpecified;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 24;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "birthday";
                break;
            case 1:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "birthdaySpecified";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "birthplace";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "civility";
                break;
            case 4:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "civilitySpecified";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "email";
                break;
            case 6:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "familyStatus";
                break;
            case 7:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "familyStatusSpecified";
                break;
            case 8:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "firstName";
                break;
            case 9:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "homePhone";
                break;
            case 10:
                info.type = Long.class;
                info.name = "id";
                break;
            case 11:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "idSpecified";
                break;
            case 12:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "mobilePhone";
                break;
            case 13:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "name";
                break;
            case 14:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nationality";
                break;
            case 15:
                info.type = address.class;
                info.name = "oneAddress";
                break;
            case 16:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateCreated";
                break;
            case 17:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateCreatedSpecified";
                break;
            case 18:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateDeleted";
                break;
            case 19:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateDeletedSpecified";
                break;
            case 20:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateUpdated";
                break;
            case 21:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateUpdatedSpecified";
                break;
            case 22:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "oneFlag";
                break;
            case 23:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "oneFlagSpecified";
                break;
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
