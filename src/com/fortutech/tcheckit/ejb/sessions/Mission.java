package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public  class Mission extends com.fortutech.tcheckit.ejb.sessions.EntityMother  implements org.ksoap2.serialization.KvmSerializable {
    private java.lang.Long id;

    private com.fortutech.tcheckit.ejb.sessions.PhotoInstruction[] listPhotoInstruction;

    private com.fortutech.tcheckit.ejb.sessions.Media[] listPhotosProducts;

    private com.fortutech.tcheckit.ejb.sessions.Question[] listQuestions;

    private com.fortutech.tcheckit.ejb.sessions.Sign[] listSign;

    private com.fortutech.tcheckit.ejb.sessions.Brand oneBrand;

    private java.lang.String oneDescription;

    private java.lang.String oneMoreText;

    private com.fortutech.tcheckit.ejb.sessions.PageContent onePageContentMain;

    private java.lang.Float onePrice;

    private java.lang.String oneTitle;
    
    private int distance = 0;

    public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Mission() {
        super();
    }
    
	public Mission(Mission mi) {
        this.distance = mi.distance;
        this.id = mi.id;
        this.listPhotoInstruction = mi.listPhotoInstruction;
        this.listPhotosProducts = mi.listPhotosProducts;
        this.listQuestions = mi.listQuestions;
        this.listSign = mi.listSign;
        this.oneBrand = mi.oneBrand;
        this.oneDescription = mi.oneDescription;
        this.oneMoreText = mi.oneMoreText;
        this.onePageContentMain = mi.onePageContentMain;
        this.onePrice = mi.onePrice;
        this.oneTitle = mi.oneTitle;        
	}
    public Mission(SoapObject so) {
        super(so);
             
        this.setId(SoapUtils.getSoapLong(so,"id"));
        this.setListPhotoInstruction(PhotoInstruction.parse(so,"listPhotoInstruction"));
        this.setListPhotosProducts(Media.parse(so,"listPhotosProducts"));
        this.setListQuestions(Question.parse(so, "listQuestions"));
        this.setListSign(Sign.parse(so, "listSign"));
        this.setOneBrand(new Brand(SoapUtils.getSoapObject(so, "oneBrand")));
        this.setOneDescription(SoapUtils.getSoapString(so,"oneDescription"));
        this.setOneFlag(new Flag(SoapUtils.getSoapString(so,"oneFlag")));
        this.setOneMoreText(SoapUtils.getSoapString(so,"oneMoreText"));
        this.setOnePageContentMain(new PageContent(SoapUtils.getSoapObject(so, "onePageContentMain")));
        this.setOnePrice(SoapUtils.getSoapFloat(so,"onePrice"));
        this.setOneTitle(SoapUtils.getSoapString(so,"oneTitle"));
      
      
        
     
    }
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setListPhotoInstruction(com.fortutech.tcheckit.ejb.sessions.PhotoInstruction[] listPhotoInstruction) {
        this.listPhotoInstruction = listPhotoInstruction;
    }

    public com.fortutech.tcheckit.ejb.sessions.PhotoInstruction[] getListPhotoInstruction() {
        return this.listPhotoInstruction;
    }

    public void setListPhotosProducts(com.fortutech.tcheckit.ejb.sessions.Media[] listPhotosProducts) {
        this.listPhotosProducts = listPhotosProducts;
    }

    public com.fortutech.tcheckit.ejb.sessions.Media[] getListPhotosProducts() {
        return this.listPhotosProducts;
    }

    public void setListQuestions(com.fortutech.tcheckit.ejb.sessions.Question[] listQuestions) {
        this.listQuestions = listQuestions;
    }

    public com.fortutech.tcheckit.ejb.sessions.Question[] getListQuestions() {
        return this.listQuestions;
    }

    public void setListSign(com.fortutech.tcheckit.ejb.sessions.Sign[] listSign) {
        this.listSign = listSign;
    }

    public com.fortutech.tcheckit.ejb.sessions.Sign[] getListSign() {
        return this.listSign;
    }

    public void setOneBrand(com.fortutech.tcheckit.ejb.sessions.Brand oneBrand) {
        this.oneBrand = oneBrand;
    }

    public com.fortutech.tcheckit.ejb.sessions.Brand getOneBrand() {
        return this.oneBrand;
    }

    public void setOneDescription(java.lang.String oneDescription) {
        this.oneDescription = oneDescription;
    }

    public java.lang.String getOneDescription() {
        return this.oneDescription;
    }

    public void setOneMoreText(java.lang.String oneMoreText) {
        this.oneMoreText = oneMoreText;
    }

    public java.lang.String getOneMoreText() {
        return this.oneMoreText;
    }

    public void setOnePageContentMain(com.fortutech.tcheckit.ejb.sessions.PageContent onePageContentMain) {
        this.onePageContentMain = onePageContentMain;
    }

    public com.fortutech.tcheckit.ejb.sessions.PageContent getOnePageContentMain() {
        return this.onePageContentMain;
    }

    public void setOnePrice(java.lang.Float onePrice) {
        this.onePrice = onePrice;
    }

    public java.lang.Float getOnePrice() {
        return this.onePrice;
    }

    public void setOneTitle(java.lang.String oneTitle) {
        this.oneTitle = oneTitle;
    }

    public java.lang.String getOneTitle() {
        return this.oneTitle;
    }

    public int getPropertyCount() {
        return 11;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return id;
        case 5: return oneBrand;
        case 6: return oneDescription;
        case 7: return oneMoreText;
        case 8: return onePageContentMain;
        case 9: return onePrice;
        case 10: return oneTitle;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: id = (java.lang.Long) __obj; break;
        case 5: oneBrand = (com.fortutech.tcheckit.ejb.sessions.Brand) __obj; break;
        case 6: oneDescription = (java.lang.String) __obj; break;
        case 7: oneMoreText = (java.lang.String) __obj; break;
        case 8: onePageContentMain = (com.fortutech.tcheckit.ejb.sessions.PageContent) __obj; break;
        case 9: onePrice = (java.lang.Float) __obj; break;
        case 10: oneTitle = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "id";
            __info.type = java.lang.Long.class; break;
        case 1:
            __info.name = "listPhotoInstruction";
        case 2:
            __info.name = "listPhotosProducts";
        case 3:
            __info.name = "listQuestions";
        case 4:
            __info.name = "listSign";
        case 5:
            __info.name = "oneBrand";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Brand.class; break;
        case 6:
            __info.name = "oneDescription";
            __info.type = java.lang.String.class; break;
        case 7:
            __info.name = "oneMoreText";
            __info.type = java.lang.String.class; break;
        case 8:
            __info.name = "onePageContentMain";
            __info.type = com.fortutech.tcheckit.ejb.sessions.PageContent.class; break;
        case 9:
            __info.name = "onePrice";
            __info.type = java.lang.Float.class; break;
        case 10:
            __info.name = "oneTitle";
            __info.type = java.lang.String.class; break;
        }
    }

}
