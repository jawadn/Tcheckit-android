package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class Flag extends SoapObject implements
		org.ksoap2.serialization.KvmSerializable {
	private java.lang.String _value_;

	/*public java.util.HashMap _table_;

	public java.lang.String _activated = "activated";

	public java.lang.String _deleted = "deleted";

	public java.lang.String _unactivated = "unactivated";

	public com.fortutech.tcheckit.ejb.sessions.Flag activated;

	public com.fortutech.tcheckit.ejb.sessions.Flag deleted;

	public com.fortutech.tcheckit.ejb.sessions.Flag unactivated;*/

	public Flag() {
		super("", "");
	}

	public Flag(String value) {
		super();
		if (value != null && "unactivated".equals(value)) {
			this.set_value_("unactivated");
		} else if (value != null && "deleted".equals(value)) {
			this.set_value_("deleted");
		} else {
			this.set_value_("activated");
		}
	}

	public void set_value_(java.lang.String _value_) {
		this._value_ = _value_;
	}

	public java.lang.String get_value_() {
		return this._value_;
	}
/*
	public void set_table_(java.util.HashMap _table_) {
		this._table_ = _table_;
	}

	public java.util.HashMap get_table_(java.util.HashMap _table_) {
		return this._table_;
	}

	public void set_activated(java.lang.String _activated) {
		this._activated = _activated;
	}

	public java.lang.String get_activated(java.lang.String _activated) {
		return this._activated;
	}

	public void set_deleted(java.lang.String _deleted) {
		this._deleted = _deleted;
	}

	public java.lang.String get_deleted(java.lang.String _deleted) {
		return this._deleted;
	}

	public void set_unactivated(java.lang.String _unactivated) {
		this._unactivated = _unactivated;
	}

	public java.lang.String get_unactivated(java.lang.String _unactivated) {
		return this._unactivated;
	}

	public void setActivated(com.fortutech.tcheckit.ejb.sessions.Flag activated) {
		this.activated = activated;
	}

	public com.fortutech.tcheckit.ejb.sessions.Flag getActivated(
			com.fortutech.tcheckit.ejb.sessions.Flag activated) {
		return this.activated;
	}

	public void setDeleted(com.fortutech.tcheckit.ejb.sessions.Flag deleted) {
		this.deleted = deleted;
	}

	public com.fortutech.tcheckit.ejb.sessions.Flag getDeleted(
			com.fortutech.tcheckit.ejb.sessions.Flag deleted) {
		return this.deleted;
	}

	public void setUnactivated(
			com.fortutech.tcheckit.ejb.sessions.Flag unactivated) {
		this.unactivated = unactivated;
	}

	public com.fortutech.tcheckit.ejb.sessions.Flag getUnactivated(
			com.fortutech.tcheckit.ejb.sessions.Flag unactivated) {
		return this.unactivated;
	}
*/
	public int getPropertyCount() {
		return 1;
	}

	public Object getProperty(int __index) {
		switch (__index) {
		case 0:
			return _value_;
		/*case 1:
			return _table_;
		case 2:
			return _activated;
		case 3:
			return _deleted;
		case 4:
			return _unactivated;
		case 5:
			return activated;
		case 6:
			return deleted;
		case 7:
			return unactivated;*/
		}
		return null;
	}

	public void setProperty(int __index, Object __obj) {
		switch (__index) {
		case 0:
			_value_ = (java.lang.String) __obj;
			break;
	/*	case 1:
			_table_ = (java.util.HashMap) __obj;
			break;
		case 2:
			_activated = (java.lang.String) __obj;
			break;
		case 3:
			_deleted = (java.lang.String) __obj;
			break;
		case 4:
			_unactivated = (java.lang.String) __obj;
			break;
		case 5:
			activated = (com.fortutech.tcheckit.ejb.sessions.Flag) __obj;
			break;
		case 6:
			deleted = (com.fortutech.tcheckit.ejb.sessions.Flag) __obj;
			break;
		case 7:
			unactivated = (com.fortutech.tcheckit.ejb.sessions.Flag) __obj;
			break;*/
		}
	}

	public void getPropertyInfo(int __index, Hashtable __table,
			PropertyInfo __info) {
		switch (__index) {
		case 0:
			__info.name = "_value_";
			__info.type = java.lang.String.class;
			break;
		case 1:
			__info.name = "_table_";
			__info.type = java.util.HashMap.class;
			break;
		case 2:
			__info.name = "_activated";
			__info.type = java.lang.String.class;
			break;
		case 3:
			__info.name = "_deleted";
			__info.type = java.lang.String.class;
			break;
		case 4:
			__info.name = "_unactivated";
			__info.type = java.lang.String.class;
			break;
		case 5:
			__info.name = "activated";
			__info.type = com.fortutech.tcheckit.ejb.sessions.Flag.class;
			break;
		case 6:
			__info.name = "deleted";
			__info.type = com.fortutech.tcheckit.ejb.sessions.Flag.class;
			break;
		case 7:
			__info.name = "unactivated";
			__info.type = com.fortutech.tcheckit.ejb.sessions.Flag.class;
			break;
		}
	}

}
