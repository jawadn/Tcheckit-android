package com.fortutech.tcheckit.ejb.sessions;

import java.util.ArrayList;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import com.tcheckit.utils.SoapUtils;

public final class PhotoInstruction extends
		com.fortutech.tcheckit.ejb.sessions.EntityMother implements
		org.ksoap2.serialization.KvmSerializable {
	private java.lang.Long id;

	private com.fortutech.tcheckit.ejb.sessions.Media[] listPhotoExamples;

	private java.lang.String oneTitle;

	public PhotoInstruction() {
		super();
	}

	public PhotoInstruction(SoapObject so) {
		super(so);
		this.setId(SoapUtils.getSoapLong(so, "id"));
		this.setListPhotoExamples(Media.parse(so, "listPhotoExamples"));
		this.setOneFlag(new Flag(SoapUtils.getSoapString(so, "oneFlag")));
		this.setOneTitle(SoapUtils.getSoapString(so, "oneTitle"));
	}

	public static PhotoInstruction[] parse(SoapObject so, String name) {
		ArrayList<PhotoInstruction> list = new ArrayList<PhotoInstruction>();
		// java.util.Vector<SoapObject> so2 = (java.util.Vector<SoapObject>)
		// SoapUtils.getSoapObjects(so, name);
		if (so != null) {
			for (int i = 0; i < so.getPropertyCount(); i++) {
				if (so.getProperty(i) != null && so.getProperty(i).getClass().equals(SoapObject.class) ){
					PropertyInfo pi = new PropertyInfo();
					so.getPropertyInfo(i, pi);
					if (pi.getName().equals(name)) { 
				
					PhotoInstruction ms = new PhotoInstruction((SoapObject)so.getProperty (i));
					list.add(ms);
					}
				}
			}
		}
		return list.toArray(new PhotoInstruction[list.size()]);
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId(java.lang.Long id) {
		return this.id;
	}

	public void setListPhotoExamples(
			com.fortutech.tcheckit.ejb.sessions.Media[] listPhotoExamples) {
		this.listPhotoExamples = listPhotoExamples;
	}

	public com.fortutech.tcheckit.ejb.sessions.Media[] getListPhotoExamples(
			) {
		return this.listPhotoExamples;
	}

	public void setOneTitle(java.lang.String oneTitle) {
		this.oneTitle = oneTitle;
	}

	public java.lang.String getOneTitle() {
		return this.oneTitle;
	}

	public int getPropertyCount() {
		return 3;
	}

	public Object getProperty(int __index) {
		switch (__index) {
		case 0:
			return id;
		case 2:
			return oneTitle;
		}
		return null;
	}

	public void setProperty(int __index, Object __obj) {
		switch (__index) {
		case 0:
			id = (java.lang.Long) __obj;
			break;
		case 2:
			oneTitle = (java.lang.String) __obj;
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
			__info.name = "listPhotoExamples";
		case 2:
			__info.name = "oneTitle";
			__info.type = java.lang.String.class;
			break;
		}
	}

}
