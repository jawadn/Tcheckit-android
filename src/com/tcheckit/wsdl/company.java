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

import com.tcheckit.wsdl.WS_Enums.flag;

public class company implements KvmSerializable {
    
    public String amountOfCapital;
    public String codeAPE;
    public String dateBirth;
    public boolean dateBirthSpecified;
    public String denomination;
    public String description;
    public String email;
    public String fax;
    public long id;
    public boolean idSpecified;
    public String identificationNumber;
    public VectorcompanyEntry mapCompanyDenomination;
    public String name;
    public address oneAddress;
    public media onePhoto;
    public String phone;
    public String siretNumber;
    public String socialReason;
    public String tVANumber;
    public String urlWebsite;
    public String dateCreated;
    public boolean dateCreatedSpecified;
    public String dateDeleted;
    public boolean dateDeletedSpecified;
    public String dateUpdated;
    public boolean dateUpdatedSpecified;
    public flag oneFlag;
    public boolean oneFlagSpecified;
    
    public company(){}
    
    public company(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("amountOfCapital"))
        {
            Object obj = soapObject.getProperty("amountOfCapital");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                amountOfCapital = j.toString();
            }else if (obj!= null && obj instanceof String){
                amountOfCapital = (String) obj;
            }
        }
        if (soapObject.hasProperty("codeAPE"))
        {
            Object obj = soapObject.getProperty("codeAPE");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                codeAPE = j.toString();
            }else if (obj!= null && obj instanceof String){
                codeAPE = (String) obj;
            }
        }
        if (soapObject.hasProperty("dateBirth"))
        {
            Object obj = soapObject.getProperty("dateBirth");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                dateBirth = j.toString();
            }else if (obj!= null && obj instanceof String){
                dateBirth = (String) obj;
            }
        }
        if (soapObject.hasProperty("dateBirthSpecified"))
        {
            Object obj = soapObject.getProperty("dateBirthSpecified");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                dateBirthSpecified = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                dateBirthSpecified = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("denomination"))
        {
            Object obj = soapObject.getProperty("denomination");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                denomination = j.toString();
            }else if (obj!= null && obj instanceof String){
                denomination = (String) obj;
            }
        }
        if (soapObject.hasProperty("description"))
        {
            Object obj = soapObject.getProperty("description");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                description = j.toString();
            }else if (obj!= null && obj instanceof String){
                description = (String) obj;
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
        if (soapObject.hasProperty("fax"))
        {
            Object obj = soapObject.getProperty("fax");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                fax = j.toString();
            }else if (obj!= null && obj instanceof String){
                fax = (String) obj;
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
        if (soapObject.hasProperty("identificationNumber"))
        {
            Object obj = soapObject.getProperty("identificationNumber");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                identificationNumber = j.toString();
            }else if (obj!= null && obj instanceof String){
                identificationNumber = (String) obj;
            }
        }
        if (soapObject.hasProperty("mapCompanyDenomination"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("mapCompanyDenomination");
            mapCompanyDenomination = new VectorcompanyEntry(j);
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
        if (soapObject.hasProperty("oneAddress"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("oneAddress");
            oneAddress =  new address (j);
            
        }
        if (soapObject.hasProperty("onePhoto"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("onePhoto");
            onePhoto =  new media (j);
            
        }
        if (soapObject.hasProperty("phone"))
        {
            Object obj = soapObject.getProperty("phone");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                phone = j.toString();
            }else if (obj!= null && obj instanceof String){
                phone = (String) obj;
            }
        }
        if (soapObject.hasProperty("siretNumber"))
        {
            Object obj = soapObject.getProperty("siretNumber");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                siretNumber = j.toString();
            }else if (obj!= null && obj instanceof String){
                siretNumber = (String) obj;
            }
        }
        if (soapObject.hasProperty("socialReason"))
        {
            Object obj = soapObject.getProperty("socialReason");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                socialReason = j.toString();
            }else if (obj!= null && obj instanceof String){
                socialReason = (String) obj;
            }
        }
        if (soapObject.hasProperty("TVANumber"))
        {
            Object obj = soapObject.getProperty("TVANumber");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                tVANumber = j.toString();
            }else if (obj!= null && obj instanceof String){
                tVANumber = (String) obj;
            }
        }
        if (soapObject.hasProperty("urlWebsite"))
        {
            Object obj = soapObject.getProperty("urlWebsite");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                urlWebsite = j.toString();
            }else if (obj!= null && obj instanceof String){
                urlWebsite = (String) obj;
            }
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
                return amountOfCapital;
            case 1:
                return codeAPE;
            case 2:
                return dateBirth;
            case 3:
                return dateBirthSpecified;
            case 4:
                return denomination;
            case 5:
                return description;
            case 6:
                return email;
            case 7:
                return fax;
            case 8:
                return id;
            case 9:
                return idSpecified;
            case 10:
                return identificationNumber;
            case 11:
                return mapCompanyDenomination;
            case 12:
                return name;
            case 13:
                return oneAddress;
            case 14:
                return onePhoto;
            case 15:
                return phone;
            case 16:
                return siretNumber;
            case 17:
                return socialReason;
            case 18:
                return tVANumber;
            case 19:
                return urlWebsite;
            case 20:
                return dateCreated;
            case 21:
                return dateCreatedSpecified;
            case 22:
                return dateDeleted;
            case 23:
                return dateDeletedSpecified;
            case 24:
                return dateUpdated;
            case 25:
                return dateUpdatedSpecified;
            case 26:
                return oneFlag.toString();
            case 27:
                return oneFlagSpecified;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 28;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "amountOfCapital";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "codeAPE";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateBirth";
                break;
            case 3:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateBirthSpecified";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "denomination";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "description";
                break;
            case 6:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "email";
                break;
            case 7:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "fax";
                break;
            case 8:
                info.type = Long.class;
                info.name = "id";
                break;
            case 9:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "idSpecified";
                break;
            case 10:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "identificationNumber";
                break;
            case 11:
                info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "mapCompanyDenomination";
                break;
            case 12:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "name";
                break;
            case 13:
                info.type = address.class;
                info.name = "oneAddress";
                break;
            case 14:
                info.type = media.class;
                info.name = "onePhoto";
                break;
            case 15:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "phone";
                break;
            case 16:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "siretNumber";
                break;
            case 17:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "socialReason";
                break;
            case 18:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "TVANumber";
                break;
            case 19:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "urlWebsite";
                break;
            case 20:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateCreated";
                break;
            case 21:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateCreatedSpecified";
                break;
            case 22:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateDeleted";
                break;
            case 23:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateDeletedSpecified";
                break;
            case 24:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateUpdated";
                break;
            case 25:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateUpdatedSpecified";
                break;
            case 26:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "oneFlag";
                break;
            case 27:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "oneFlagSpecified";
                break;
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}