package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class PageElementType extends SoapObject implements
org.ksoap2.serialization.KvmSerializable {
    private java.lang.String _value_;

   /* public java.util.HashMap _table_;

    public java.lang.String _text;

    public java.lang.String _media;

    public com.fortutech.tcheckit.ejb.sessions.PageElementType text;

    public com.fortutech.tcheckit.ejb.sessions.PageElementType media;*/

    public PageElementType() {
        super("", "");
    }
    public PageElementType(String value) {
		super();
		if (value != null && "text".equals(value)) {
			this.set_value_("text");
		} else if (value != null && "media".equals(value)) {
			this.set_value_("media");
		} else {
			this.set_value_("text");
		}
		
	}
	public void set_value_(java.lang.String _value_) {
        this._value_ = _value_;
    }

    public java.lang.String get_value_() {
        return this._value_;
    }

   /* public void set_table_(java.util.HashMap _table_) {
        this._table_ = _table_;
    }

    public java.util.HashMap get_table_(java.util.HashMap _table_) {
        return this._table_;
    }

    public void set_text(java.lang.String _text) {
        this._text = _text;
    }

    public java.lang.String get_text(java.lang.String _text) {
        return this._text;
    }

    public void set_media(java.lang.String _media) {
        this._media = _media;
    }

    public java.lang.String get_media(java.lang.String _media) {
        return this._media;
    }

    public void setText(com.fortutech.tcheckit.ejb.sessions.PageElementType text) {
        this.text = text;
    }

    public com.fortutech.tcheckit.ejb.sessions.PageElementType getText(com.fortutech.tcheckit.ejb.sessions.PageElementType text) {
        return this.text;
    }

    public void setMedia(com.fortutech.tcheckit.ejb.sessions.PageElementType media) {
        this.media = media;
    }

    public com.fortutech.tcheckit.ejb.sessions.PageElementType getMedia(com.fortutech.tcheckit.ejb.sessions.PageElementType media) {
        return this.media;
    }
*/
    public int getPropertyCount() {
        return 1;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return _value_;
       /* case 1: return _table_;
        case 2: return _text;
        case 3: return _media;
        case 4: return text;
        case 5: return media;*/
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: _value_ = (java.lang.String) __obj; break;
       /* case 1: _table_ = (java.util.HashMap) __obj; break;
        case 2: _text = (java.lang.String) __obj; break;
        case 3: _media = (java.lang.String) __obj; break;
        case 4: text = (com.fortutech.tcheckit.ejb.sessions.PageElementType) __obj; break;
        case 5: media = (com.fortutech.tcheckit.ejb.sessions.PageElementType) __obj; break;*/
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "_value_";
            __info.type = java.lang.String.class; break;
        case 1:
            __info.name = "_table_";
            __info.type = java.util.HashMap.class; break;
        case 2:
            __info.name = "_text";
            __info.type = java.lang.String.class; break;
        case 3:
            __info.name = "_media";
            __info.type = java.lang.String.class; break;
        case 4:
            __info.name = "text";
            __info.type = com.fortutech.tcheckit.ejb.sessions.PageElementType.class; break;
        case 5:
            __info.name = "media";
            __info.type = com.fortutech.tcheckit.ejb.sessions.PageElementType.class; break;
        }
    }

}
