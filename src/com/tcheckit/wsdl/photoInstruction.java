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

public class photoInstruction implements KvmSerializable {
    
    public long id;
    public boolean idSpecified;
    public Vectormedia listPhotoExamples;
    public String oneTitle;
    public String dateCreated;
    public boolean dateCreatedSpecified;
    public String dateDeleted;
    public boolean dateDeletedSpecified;
    public String dateUpdated;
    public boolean dateUpdatedSpecified;
    public flag oneFlag;
    public boolean oneFlagSpecified;
    
    public photoInstruction(){}
    
    public photoInstruction(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
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
        if (soapObject.hasProperty("listPhotoExamples"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("listPhotoExamples");
            listPhotoExamples = new Vectormedia(j);
        }
        if (soapObject.hasProperty("oneTitle"))
        {
            Object obj = soapObject.getProperty("oneTitle");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                oneTitle = j.toString();
            }else if (obj!= null && obj instanceof String){
                oneTitle = (String) obj;
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
                return id;
            case 1:
                return idSpecified;
            case 2:
                return listPhotoExamples;
            case 3:
                return oneTitle;
            case 4:
                return dateCreated;
            case 5:
                return dateCreatedSpecified;
            case 6:
                return dateDeleted;
            case 7:
                return dateDeletedSpecified;
            case 8:
                return dateUpdated;
            case 9:
                return dateUpdatedSpecified;
            case 10:
                return oneFlag.toString();
            case 11:
                return oneFlagSpecified;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 12;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = Long.class;
                info.name = "id";
                break;
            case 1:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "idSpecified";
                break;
            case 2:
                info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "listPhotoExamples";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "oneTitle";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateCreated";
                break;
            case 5:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateCreatedSpecified";
                break;
            case 6:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateDeleted";
                break;
            case 7:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateDeletedSpecified";
                break;
            case 8:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateUpdated";
                break;
            case 9:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateUpdatedSpecified";
                break;
            case 10:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "oneFlag";
                break;
            case 11:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "oneFlagSpecified";
                break;
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
