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

public class responseQuestionInputText implements KvmSerializable {
    
    public String oneAnswer;
    public answer answer;
    public long id;
    public boolean idSpecified;
    public question oneQuestion;
    public String dateCreated;
    public boolean dateCreatedSpecified;
    public String dateDeleted;
    public boolean dateDeletedSpecified;
    public String dateUpdated;
    public boolean dateUpdatedSpecified;
    public flag oneFlag;
    public boolean oneFlagSpecified;
    
    public responseQuestionInputText(){}
    
    public responseQuestionInputText(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("oneAnswer"))
        {
            Object obj = soapObject.getProperty("oneAnswer");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                oneAnswer = j.toString();
            }else if (obj!= null && obj instanceof String){
                oneAnswer = (String) obj;
            }
        }
        if (soapObject.hasProperty("answer"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("answer");
            answer =  new answer (j);
            
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
        if (soapObject.hasProperty("oneQuestion"))
        {
            SoapObject j = (SoapObject)soapObject.getProperty("oneQuestion");
            oneQuestion =  new question (j);
            
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
                return oneAnswer;
            case 1:
                return answer;
            case 2:
                return id;
            case 3:
                return idSpecified;
            case 4:
                return oneQuestion;
            case 5:
                return dateCreated;
            case 6:
                return dateCreatedSpecified;
            case 7:
                return dateDeleted;
            case 8:
                return dateDeletedSpecified;
            case 9:
                return dateUpdated;
            case 10:
                return dateUpdatedSpecified;
            case 11:
                return oneFlag.toString();
            case 12:
                return oneFlagSpecified;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 13;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "oneAnswer";
                break;
            case 1:
                info.type = answer.class;
                info.name = "answer";
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
                info.type = question.class;
                info.name = "oneQuestion";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateCreated";
                break;
            case 6:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateCreatedSpecified";
                break;
            case 7:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateDeleted";
                break;
            case 8:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateDeletedSpecified";
                break;
            case 9:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "dateUpdated";
                break;
            case 10:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "dateUpdatedSpecified";
                break;
            case 11:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "oneFlag";
                break;
            case 12:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "oneFlagSpecified";
                break;
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
