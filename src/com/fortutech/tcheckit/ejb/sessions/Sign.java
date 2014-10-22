package com.fortutech.tcheckit.ejb.sessions;

import java.util.ArrayList;
import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public final class Sign extends
		com.fortutech.tcheckit.ejb.sessions.EntityMother implements
		org.ksoap2.serialization.KvmSerializable {
	private com.fortutech.tcheckit.ejb.sessions.Address address;

	private java.lang.Long id;

	private java.lang.String name;

	private com.fortutech.tcheckit.ejb.sessions.Shop oneShop;

	public Sign() {
		super();
	}

	public Sign(SoapObject so) {
		super(so);
		this.setAddress(new Address((SoapObject) so.getProperty("address")));
		this.setId(SoapUtils.getSoapLong(so, "id"));
		this.setName(SoapUtils.getSoapString(so, "name"));		
		this.setOneShop(new Shop((SoapObject) so.getProperty("oneShop")));
	}

	public static Sign[] parse(SoapObject so, String name) {
		ArrayList<Sign> list = new ArrayList<Sign>();
		for (int i = 0; i < so.getPropertyCount(); i++) {
			if (so.getProperty(i) != null
					&& so.getProperty(i).getClass().equals(SoapObject.class)) {
				PropertyInfo pi = new PropertyInfo();
				so.getPropertyInfo(i, pi);

				if (name.equals(pi.getName())) {
					SoapObject obj = (SoapObject) so.getProperty(i);
					list.add(new Sign(obj));
				}
			}
		}

		return list.toArray(new Sign[list.size()]);
	}

	public void setAddress(com.fortutech.tcheckit.ejb.sessions.Address address) {
		this.address = address;
	}

	
	public com.fortutech.tcheckit.ejb.sessions.Address getAddress() {
		return this.address;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	
	public java.lang.Long getId() {
		return this.id;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	@Override
	public java.lang.String getName() {
		return this.name;
	}

	public void setOneShop(com.fortutech.tcheckit.ejb.sessions.Shop oneShop) {
		this.oneShop = oneShop;
	}

	public com.fortutech.tcheckit.ejb.sessions.Shop getOneShop(
			com.fortutech.tcheckit.ejb.sessions.Shop oneShop) {
		return this.oneShop;
	}

	public int getPropertyCount() {
		return 4;
	}

	public Object getProperty(int __index) {
		switch (__index) {
		case 0:
			return address;
		case 1:
			return id;
		case 2:
			return name;
		case 3:
			return oneShop;
		}
		return null;
	}

	public void setProperty(int __index, Object __obj) {
		switch (__index) {
		case 0:
			address = (com.fortutech.tcheckit.ejb.sessions.Address) __obj;
			break;
		case 1:
			id = (java.lang.Long) __obj;
			break;
		case 2:
			name = (java.lang.String) __obj;
			break;
		case 3:
			oneShop = (com.fortutech.tcheckit.ejb.sessions.Shop) __obj;
			break;
		}
	}

	public void getPropertyInfo(int __index, Hashtable __table,
			PropertyInfo __info) {
		switch (__index) {
		case 0:
			__info.name = "address";
			__info.type = com.fortutech.tcheckit.ejb.sessions.Address.class;
			break;
		case 1:
			__info.name = "id";
			__info.type = java.lang.Long.class;
			break;
		case 2:
			__info.name = "name";
			__info.type = java.lang.String.class;
			break;
		case 3:
			__info.name = "oneShop";
			__info.type = com.fortutech.tcheckit.ejb.sessions.Shop.class;
			break;
		}
	}

}
