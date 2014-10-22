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

public class questionUniqueChoice implements KvmSerializable {
    
    public VectorchoiceQuestion listChoice;
    public boolean descriptionQuestion;
    public long id;
    public boolean idSpecified;
    public product oneProduct;
    public String oneTitle;
    public int position;
    public String dateCreated;
    public boolean dateCreatedSpecified;
    public String dateDeleted;
    public boolean dateDeletedSpecified;
    public String dateUpdated;
    public boolean dateUpdatedSpecified;
    public flag oneFlag;
    public boolean oneFlagSpecified;
    
    public questionUniqueChoice(){}
    
    public questionUniqueChoice(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("listChoice"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("listChoice");
            listChoice = new VectorchoiceQuestion(j);
        }
        if (soapObject.hasProperty("descriptionQuestion"))
        {
            Object obj = soapObject.getProperty("descriptionQuestion");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                descriptionQuestion = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                descriptionQuestion = (Boolean) obj;
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
        if (soapObject.hasProperty("oneProduct"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("oneProduct");
            oneProduct =  new product (j);
            
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
        if (soapObject.hasProperty("position"))
        {
            Object obj = soapObject.getProperty("position");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                position = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                position = (Integer) obj;
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
                return listChoice;
            case 1:
                return descriptionQuestion;
            case 2:
                return id;
            case 3:
                return idSpecified;
            case 4:
                return oneProduct;
            case 5:
                return oneTitle;
            case 6:
                return position;
            case 7:
                return dateCreated;
            case 8:
                return dateCreatedSpecified;
            case 9:
                return dateDeleted;
            case 10:
                return dateDeletedSpecified;
            case 11:
                return dateUpdated;
            case 12:
                return dateUpdatedSpecified;
            case 13:
                return oneFlag.toString();
            case 14:
                return oneFlagSpecified;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 15;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.VECTOR_CLASS;
                info.name = "listChoice";
                break;
            case 1:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "descriptionQuestion";
                break;
            case 2:
                info.type = Long.class;
                info.name = "id";
                break;
            case 3:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "idSpecified";
                break;
            case 4:
                info.type = product.class;
                info.name = "oneProduct";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "oneTitle";
                break;
            case 6:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "position";
                break;
            case 7:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateCreated";
                break;
            case 8:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateCreatedSpecified";
                break;
            case 9:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateDeleted";
                break;
            case 10:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateDeletedSpecified";
                break;
            case 11:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateUpdated";
                break;
            case 12:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateUpdatedSpecified";
                break;
            case 13:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "oneFlag";
                break;
            case 14:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "oneFlagSpecified";
                break;
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
