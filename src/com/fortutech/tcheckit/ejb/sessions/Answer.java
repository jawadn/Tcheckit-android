package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class Answer extends SoapObject {
    private java.lang.Long id;

    private java.lang.Float latitude;

    private com.fortutech.tcheckit.ejb.sessions.Media[] listPhotos;

    private com.fortutech.tcheckit.ejb.sessions.ResponseQuestion[] listResponse;

    private java.lang.Float longitude;

    private com.fortutech.tcheckit.ejb.sessions.Consumer oneConsumer;

    private com.fortutech.tcheckit.ejb.sessions.Mission oneMission;

    private java.lang.String oneRefusedComment;

    private com.fortutech.tcheckit.ejb.sessions.Sign oneSign;

    private com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum oneStatus;

    public Answer() {
        super("", "");
    }
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId(java.lang.Long id) {
        return this.id;
    }

    public void setLatitude(java.lang.Float latitude) {
        this.latitude = latitude;
    }

    public java.lang.Float getLatitude(java.lang.Float latitude) {
        return this.latitude;
    }

    public void setListPhotos(com.fortutech.tcheckit.ejb.sessions.Media[] listPhotos) {
        this.listPhotos = listPhotos;
    }

    public com.fortutech.tcheckit.ejb.sessions.Media[] getListPhotos(com.fortutech.tcheckit.ejb.sessions.Media[] listPhotos) {
        return this.listPhotos;
    }

    public void setListResponse(com.fortutech.tcheckit.ejb.sessions.ResponseQuestion[] listResponse) {
        this.listResponse = listResponse;
    }

    public com.fortutech.tcheckit.ejb.sessions.ResponseQuestion[] getListResponse(com.fortutech.tcheckit.ejb.sessions.ResponseQuestion[] listResponse) {
        return this.listResponse;
    }

    public void setLongitude(java.lang.Float longitude) {
        this.longitude = longitude;
    }

    public java.lang.Float getLongitude(java.lang.Float longitude) {
        return this.longitude;
    }

    public void setOneConsumer(com.fortutech.tcheckit.ejb.sessions.Consumer oneConsumer) {
        this.oneConsumer = oneConsumer;
    }

    public com.fortutech.tcheckit.ejb.sessions.Consumer getOneConsumer(com.fortutech.tcheckit.ejb.sessions.Consumer oneConsumer) {
        return this.oneConsumer;
    }

    public void setOneMission(com.fortutech.tcheckit.ejb.sessions.Mission oneMission) {
        this.oneMission = oneMission;
    }

    public com.fortutech.tcheckit.ejb.sessions.Mission getOneMission(com.fortutech.tcheckit.ejb.sessions.Mission oneMission) {
        return this.oneMission;
    }

    public void setOneRefusedComment(java.lang.String oneRefusedComment) {
        this.oneRefusedComment = oneRefusedComment;
    }

    public java.lang.String getOneRefusedComment(java.lang.String oneRefusedComment) {
        return this.oneRefusedComment;
    }

    public void setOneSign(com.fortutech.tcheckit.ejb.sessions.Sign oneSign) {
        this.oneSign = oneSign;
    }

    public com.fortutech.tcheckit.ejb.sessions.Sign getOneSign(com.fortutech.tcheckit.ejb.sessions.Sign oneSign) {
        return this.oneSign;
    }

    public void setOneStatus(com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum oneStatus) {
        this.oneStatus = oneStatus;
    }

    public com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum getOneStatus(com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum oneStatus) {
        return this.oneStatus;
    }

    public int getPropertyCount() {
        return 10;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return id;
        case 1: return latitude;
        case 4: return longitude;
        case 5: return oneConsumer;
        case 6: return oneMission;
        case 7: return oneRefusedComment;
        case 8: return oneSign;
        case 9: return oneStatus;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: id = (java.lang.Long) __obj; break;
        case 1: latitude = (java.lang.Float) __obj; break;
        case 4: longitude = (java.lang.Float) __obj; break;
        case 5: oneConsumer = (com.fortutech.tcheckit.ejb.sessions.Consumer) __obj; break;
        case 6: oneMission = (com.fortutech.tcheckit.ejb.sessions.Mission) __obj; break;
        case 7: oneRefusedComment = (java.lang.String) __obj; break;
        case 8: oneSign = (com.fortutech.tcheckit.ejb.sessions.Sign) __obj; break;
        case 9: oneStatus = (com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "id";
            __info.type = java.lang.Long.class; break;
        case 1:
            __info.name = "latitude";
            __info.type = java.lang.Float.class; break;
        case 2:
            __info.name = "listPhotos";
        case 3:
            __info.name = "listResponse";
        case 4:
            __info.name = "longitude";
            __info.type = java.lang.Float.class; break;
        case 5:
            __info.name = "oneConsumer";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Consumer.class; break;
        case 6:
            __info.name = "oneMission";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Mission.class; break;
        case 7:
            __info.name = "oneRefusedComment";
            __info.type = java.lang.String.class; break;
        case 8:
            __info.name = "oneSign";
            __info.type = com.fortutech.tcheckit.ejb.sessions.Sign.class; break;
        case 9:
            __info.name = "oneStatus";
            __info.type = com.fortutech.tcheckit.ejb.sessions.AnswerStatusEnum.class; break;
        }
    }

}
