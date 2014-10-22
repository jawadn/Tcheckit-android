package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public final class PaymentMethod extends SoapObject implements
		org.ksoap2.serialization.KvmSerializable {
	private java.lang.String _value_;

	public java.util.HashMap _table_;

	public java.lang.String _paypal = "paypal";

	public java.lang.String _transfer = "transfer";

	public com.fortutech.tcheckit.ejb.sessions.PaymentMethod paypal;

	public com.fortutech.tcheckit.ejb.sessions.PaymentMethod transfer;

	public PaymentMethod() {
		super();
	}

	public PaymentMethod(String so) {
        if (this._paypal.equals(so)) {
        this.set_value_(this._paypal);
        } else {
        	this.set_value_(this._transfer);
        }
    }

	public void set_value_(java.lang.String _value_) {
		this._value_ = _value_;
	}

	public java.lang.String get_value_(java.lang.String _value_) {
		return this._value_;
	}

	public void set_table_(java.util.HashMap _table_) {
		this._table_ = _table_;
	}

	public java.util.HashMap get_table_(java.util.HashMap _table_) {
		return this._table_;
	}

	public void set_paypal(java.lang.String _paypal) {
		this._paypal = _paypal;
	}

	public java.lang.String get_paypal(java.lang.String _paypal) {
		return this._paypal;
	}

	public void set_transfer(java.lang.String _transfer) {
		this._transfer = _transfer;
	}

	public java.lang.String get_transfer(java.lang.String _transfer) {
		return this._transfer;
	}

	public void setPaypal(
			com.fortutech.tcheckit.ejb.sessions.PaymentMethod paypal) {
		this.paypal = paypal;
	}

	public com.fortutech.tcheckit.ejb.sessions.PaymentMethod getPaypal(
			com.fortutech.tcheckit.ejb.sessions.PaymentMethod paypal) {
		return this.paypal;
	}

	public void setTransfer(
			com.fortutech.tcheckit.ejb.sessions.PaymentMethod transfer) {
		this.transfer = transfer;
	}

	public com.fortutech.tcheckit.ejb.sessions.PaymentMethod getTransfer(
			com.fortutech.tcheckit.ejb.sessions.PaymentMethod transfer) {
		return this.transfer;
	}

	public int getPropertyCount() {
		return 4;
	}

	public Object getProperty(int __index) {
		switch (__index) {
		case 0:
			return _value_;
		case 1:
			return _table_;
		case 2:
			return _paypal;
		case 3:
			return _transfer;
		case 4:
			return paypal;
		case 5:
			return transfer;
		}
		return null;
	}

	public void setProperty(int __index, Object __obj) {
		switch (__index) {
		case 0:
			_value_ = (java.lang.String) __obj;
			break;
		case 1:
			_table_ = (java.util.HashMap) __obj;
			break;
		case 2:
			_paypal = (java.lang.String) __obj;
			break;
		case 3:
			_transfer = (java.lang.String) __obj;
			break;
		case 4:
			paypal = (com.fortutech.tcheckit.ejb.sessions.PaymentMethod) __obj;
			break;
		case 5:
			transfer = (com.fortutech.tcheckit.ejb.sessions.PaymentMethod) __obj;
			break;
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
			__info.name = "_paypal";
			__info.type = java.lang.String.class;
			break;
		case 3:
			__info.name = "_transfer";
			__info.type = java.lang.String.class;
			break;
		case 4:
			__info.name = "paypal";
			__info.type = com.fortutech.tcheckit.ejb.sessions.PaymentMethod.class;
			break;
		case 5:
			__info.name = "transfer";
			__info.type = com.fortutech.tcheckit.ejb.sessions.PaymentMethod.class;
			break;
		}
	}

}
