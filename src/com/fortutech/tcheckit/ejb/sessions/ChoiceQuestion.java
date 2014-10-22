package com.fortutech.tcheckit.ejb.sessions;

import java.util.ArrayList;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public final class ChoiceQuestion extends com.fortutech.tcheckit.ejb.sessions.EntityMother implements org.ksoap2.serialization.KvmSerializable {
	private java.lang.String color;

	private java.lang.Long id;

	private java.lang.String oneTitle;

	private int position;

	public ChoiceQuestion() {
		super();
	}

	public ChoiceQuestion(SoapObject so) {
		super(so);
		this.setColor(SoapUtils.getSoapString(so, "color"));
		this.setId(SoapUtils.getSoapLong(so, "id"));
		this.setOneTitle(SoapUtils.getSoapString(so, "oneTitle"));
		this.setPosition(SoapUtils.getSoapInteger(so, "position"));
	}

	public static ChoiceQuestion[] parse(SoapObject so, String name) {
		ArrayList<ChoiceQuestion> list = new ArrayList<ChoiceQuestion>();
		for (int i = 0; i < so.getPropertyCount(); i++) {
			if (so.getProperty(i) != null && so.getProperty(i).getClass().equals(SoapObject.class)) {
				PropertyInfo pi = new PropertyInfo();
				so.getPropertyInfo(i, pi);

				if (name.equals(pi.getName())) {
					SoapObject obj = (SoapObject) so.getProperty(i);
					list.add(new ChoiceQuestion(obj));
				}
			}
		}

		return list.toArray(new ChoiceQuestion[list.size()]);
	}

	public void setColor(java.lang.String color) {
		this.color = color;
	}

	public java.lang.String getColor() {
		return this.color;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setOneTitle(java.lang.String oneTitle) {
		this.oneTitle = oneTitle;
	}

	public java.lang.String getOneTitle() {
		return this.oneTitle;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return this.position;
	}

	public int getPropertyCount() {
		return 4;
	}

	public Object getProperty(int __index) {
		switch (__index) {
		case 0:
			return color;
		case 1:
			return id;
		case 2:
			return oneTitle;
		case 3:
			return new Integer(position);
		}
		return null;
	}

	public void setProperty(int __index, Object __obj) {
		switch (__index) {
		case 0:
			color = (java.lang.String) __obj;
			break;
		case 1:
			id = (java.lang.Long) __obj;
			break;
		case 2:
			oneTitle = (java.lang.String) __obj;
			break;
		case 3:
			position = Integer.parseInt(__obj.toString());
			break;
		}
	}

	public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
		switch (__index) {
		case 0:
			__info.name = "color";
			__info.type = java.lang.String.class;
			break;
		case 1:
			__info.name = "id";
			__info.type = java.lang.Long.class;
			break;
		case 2:
			__info.name = "oneTitle";
			__info.type = java.lang.String.class;
			break;
		case 3:
			__info.name = "position";
			__info.type = Integer.class;
			break;
		}
	}

}
