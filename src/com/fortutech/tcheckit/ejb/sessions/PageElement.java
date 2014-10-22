package com.fortutech.tcheckit.ejb.sessions;

import java.util.ArrayList;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public class PageElement extends
		com.fortutech.tcheckit.ejb.sessions.EntityMother implements
		org.ksoap2.serialization.KvmSerializable {
	private java.lang.Long id;

	private com.fortutech.tcheckit.ejb.sessions.PageElementType onePageElementType;

	private java.lang.Integer position;

	public PageElement() {
		super();
	}

	public PageElement(SoapObject so) {		
		super(so);
		this.setPosition(SoapUtils.getSoapInteger(so, "position"));
		this.setOnePageElementType(new PageElementType(SoapUtils.getSoapString(so, "onePageElementType")));
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setOnePageElementType(
			com.fortutech.tcheckit.ejb.sessions.PageElementType onePageElementType) {
		this.onePageElementType = onePageElementType;
	}

	public com.fortutech.tcheckit.ejb.sessions.PageElementType getOnePageElementType() {
		return this.onePageElementType;
	}

	public void setPosition(java.lang.Integer position) {
		this.position = position;
	}

	public java.lang.Integer getPosition() {
		return this.position;
	}

	public int getPropertyCount() {
		return 3;
	}

	public Object getProperty(int __index) {
		switch (__index) {
		case 0:
			return id;
		case 1:
			return onePageElementType;
		case 2:
			return position;
		}
		return null;
	}

	public void setProperty(int __index, Object __obj) {
		switch (__index) {
		case 0:
			id = (java.lang.Long) __obj;
			break;
		case 1:
			onePageElementType = (com.fortutech.tcheckit.ejb.sessions.PageElementType) __obj;
			break;
		case 2:
			position = (java.lang.Integer) __obj;
			break;
		}
	}

	public void getPropertyInfo(int __index, Hashtable __table,
			PropertyInfo __info) {
		switch (__index) {
		case 0:
			__info.name = "id";
			__info.type = java.lang.Long.class;
			break;
		case 1:
			__info.name = "onePageElementType";
			__info.type = com.fortutech.tcheckit.ejb.sessions.PageElementType.class;
			break;
		case 2:
			__info.name = "position";
			__info.type = java.lang.Integer.class;
			break;
		}
	}

	public static PageElement[] parse(SoapObject so, String name) {
		ArrayList<PageElement> list = new ArrayList<PageElement>();
		if (so != null) {
			for (int i = 0; i < so.getPropertyCount(); i++) {
				if (so.getProperty(i) != null
						&& so.getProperty(i).getClass()
								.equals(SoapObject.class)) {
					PropertyInfo pi = new PropertyInfo();
					so.getPropertyInfo(i, pi);
					if (pi.getName().equals(name)) {
						PageElement pe = null;
						if (((SoapObject)so.getProperty(i)).getName().equals("pageElementText")) {
							pe = new PageElementText(
									(SoapObject) so.getProperty(i));
						} else if (((SoapObject)so.getProperty(i)).getName().equals("pageElementMedia")) {
							pe = new PageElementMedia(
									(SoapObject) so.getProperty(i));
						}
						if (pe != null) {
							list.add(pe);
						}
					}
				}
			}
		}
		return list.toArray(new PageElement[list.size()]);
	}

}
