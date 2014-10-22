package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public final class Brand extends com.fortutech.tcheckit.ejb.sessions.Company  implements org.ksoap2.serialization.KvmSerializable {
    private java.lang.String accountNumber;

    private java.lang.String bankName;

    private java.lang.String bicCode;

    private java.lang.String ibanCode;

    private java.lang.String legalPrecision;

    private java.lang.String officeCode;

    private com.fortutech.tcheckit.ejb.sessions.PaymentMethod paymentMethodClient;

    private java.lang.String rib;

    private java.lang.String windowCode;

    public Brand() {
        super();
    }
    public Brand(SoapObject so) {
        super(so);
        this.setAccountNumber(SoapUtils.getSoapString(so, "accountNumber"));
        this.setBankName(SoapUtils.getSoapString(so, "bankName"));
        this.setBicCode(SoapUtils.getSoapString(so, "bicCode"));
        this.setIbanCode(SoapUtils.getSoapString(so, "ibanCode"));
        this.setLegalPrecision(SoapUtils.getSoapString(so, "legalPrecision"));
        this.setOfficeCode(SoapUtils.getSoapString(so, "officeCode"));        
        this.setPaymentMethodClient(new PaymentMethod(SoapUtils.getSoapString(so, "paymentMethodClient")));
        this.setRib(SoapUtils.getSoapString(so, "rib"));
        this.setWindowCode(SoapUtils.getSoapString(so, "windowCode"));
        
    }
    public void setAccountNumber(java.lang.String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public java.lang.String getAccountNumber(java.lang.String accountNumber) {
        return this.accountNumber;
    }

    public void setBankName(java.lang.String bankName) {
        this.bankName = bankName;
    }

    public java.lang.String getBankName(java.lang.String bankName) {
        return this.bankName;
    }

    public void setBicCode(java.lang.String bicCode) {
        this.bicCode = bicCode;
    }

    public java.lang.String getBicCode(java.lang.String bicCode) {
        return this.bicCode;
    }

    public void setIbanCode(java.lang.String ibanCode) {
        this.ibanCode = ibanCode;
    }

    public java.lang.String getIbanCode(java.lang.String ibanCode) {
        return this.ibanCode;
    }

    public void setLegalPrecision(java.lang.String legalPrecision) {
        this.legalPrecision = legalPrecision;
    }

    public java.lang.String getLegalPrecision(java.lang.String legalPrecision) {
        return this.legalPrecision;
    }

    public void setOfficeCode(java.lang.String officeCode) {
        this.officeCode = officeCode;
    }

    public java.lang.String getOfficeCode(java.lang.String officeCode) {
        return this.officeCode;
    }

    public void setPaymentMethodClient(com.fortutech.tcheckit.ejb.sessions.PaymentMethod paymentMethodClient) {
        this.paymentMethodClient = paymentMethodClient;
    }

    public com.fortutech.tcheckit.ejb.sessions.PaymentMethod getPaymentMethodClient(com.fortutech.tcheckit.ejb.sessions.PaymentMethod paymentMethodClient) {
        return this.paymentMethodClient;
    }

    public void setRib(java.lang.String rib) {
        this.rib = rib;
    }

    public java.lang.String getRib(java.lang.String rib) {
        return this.rib;
    }

    public void setWindowCode(java.lang.String windowCode) {
        this.windowCode = windowCode;
    }

    public java.lang.String getWindowCode(java.lang.String windowCode) {
        return this.windowCode;
    }

    public int getPropertyCount() {
        return 9;
    }

    public Object getProperty(int __index) {
        switch(__index)  {
        case 0: return accountNumber;
        case 1: return bankName;
        case 2: return bicCode;
        case 3: return ibanCode;
        case 4: return legalPrecision;
        case 5: return officeCode;
        case 6: return paymentMethodClient;
        case 7: return rib;
        case 8: return windowCode;
        }
        return null;
    }

    public void setProperty(int __index, Object __obj) {
        switch(__index)  {
        case 0: accountNumber = (java.lang.String) __obj; break;
        case 1: bankName = (java.lang.String) __obj; break;
        case 2: bicCode = (java.lang.String) __obj; break;
        case 3: ibanCode = (java.lang.String) __obj; break;
        case 4: legalPrecision = (java.lang.String) __obj; break;
        case 5: officeCode = (java.lang.String) __obj; break;
        case 6: paymentMethodClient = (com.fortutech.tcheckit.ejb.sessions.PaymentMethod) __obj; break;
        case 7: rib = (java.lang.String) __obj; break;
        case 8: windowCode = (java.lang.String) __obj; break;
        }
    }

    public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
        switch(__index)  {
        case 0:
            __info.name = "accountNumber";
            __info.type = java.lang.String.class; break;
        case 1:
            __info.name = "bankName";
            __info.type = java.lang.String.class; break;
        case 2:
            __info.name = "bicCode";
            __info.type = java.lang.String.class; break;
        case 3:
            __info.name = "ibanCode";
            __info.type = java.lang.String.class; break;
        case 4:
            __info.name = "legalPrecision";
            __info.type = java.lang.String.class; break;
        case 5:
            __info.name = "officeCode";
            __info.type = java.lang.String.class; break;
        case 6:
            __info.name = "paymentMethodClient";
            __info.type = com.fortutech.tcheckit.ejb.sessions.PaymentMethod.class; break;
        case 7:
            __info.name = "rib";
            __info.type = java.lang.String.class; break;
        case 8:
            __info.name = "windowCode";
            __info.type = java.lang.String.class; break;
        }
    }

}
