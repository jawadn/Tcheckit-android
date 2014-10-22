package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public class Company extends com.fortutech.tcheckit.ejb.sessions.EntityMother
		implements org.ksoap2.serialization.KvmSerializable {
	private java.lang.String amountOfCapital;

	private java.lang.String codeAPE;

	private java.util.Calendar dateBirth;

	private java.lang.String denomination;

	private java.lang.String description;

	private java.lang.String email;

	private java.lang.String fax;

	private java.lang.Long id;

	private java.lang.String identificationNumber;

	private com.fortutech.tcheckit.ejb.sessions.CompanyMapCompanyDenominationEntry[] mapCompanyDenomination;

	private java.lang.String name;

	private com.fortutech.tcheckit.ejb.sessions.Address oneAddress;

	private com.fortutech.tcheckit.ejb.sessions.Media onePhoto;

	private java.lang.String phone;

	private java.lang.String siretNumber;

	private java.lang.String socialReason;

	private java.lang.String TVANumber;

	private java.lang.String urlWebsite;

	public Company() {
		super();
	}

	public Company(SoapObject so) {
		super(so);

		this.setAmountOfCapital(amountOfCapital);
		this.setCodeAPE(codeAPE);
		this.setDateBirth(dateBirth);
		this.setDenomination(denomination);
		this.setDescription(SoapUtils.getSoapString(so, "description"));
		this.setEmail(email);
		this.setFax(fax);
		this.setId(id);
		this.setIdentificationNumber(identificationNumber);
		// this.setMapCompanyDenomination(new Shop((SoapObject)
		// so.getProperty("mapCompanyDenomination")));
		this.setName(name);
		try {
			this.setOneAddress(new Address((SoapObject) so
					.getProperty("oneAddress")));
		} catch (RuntimeException ru) {

		}
		try {
			this.setOnePhoto(new Media((SoapObject) so.getProperty("onePhoto")));
		} catch (RuntimeException ru) {

		}
		this.setPhone(phone);
		this.setSiretNumber(siretNumber);
		this.setSocialReason(socialReason);
		this.setTVANumber(TVANumber);
		this.setUrlWebsite(urlWebsite);
	}

	public void setAmountOfCapital(java.lang.String amountOfCapital) {
		this.amountOfCapital = amountOfCapital;
	}

	public java.lang.String getAmountOfCapital(java.lang.String amountOfCapital) {
		return this.amountOfCapital;
	}

	public void setCodeAPE(java.lang.String codeAPE) {
		this.codeAPE = codeAPE;
	}

	public java.lang.String getCodeAPE(java.lang.String codeAPE) {
		return this.codeAPE;
	}

	public void setDateBirth(java.util.Calendar dateBirth) {
		this.dateBirth = dateBirth;
	}

	public java.util.Calendar getDateBirth(java.util.Calendar dateBirth) {
		return this.dateBirth;
	}

	public void setDenomination(java.lang.String denomination) {
		this.denomination = denomination;
	}

	public java.lang.String getDenomination(java.lang.String denomination) {
		return this.denomination;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.lang.String getDescription(java.lang.String description) {
		return this.description;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getEmail(java.lang.String email) {
		return this.email;
	}

	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}

	public java.lang.String getFax(java.lang.String fax) {
		return this.fax;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId(java.lang.Long id) {
		return this.id;
	}

	public void setIdentificationNumber(java.lang.String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public java.lang.String getIdentificationNumber(
			java.lang.String identificationNumber) {
		return this.identificationNumber;
	}

	public void setMapCompanyDenomination(
			com.fortutech.tcheckit.ejb.sessions.CompanyMapCompanyDenominationEntry[] mapCompanyDenomination) {
		this.mapCompanyDenomination = mapCompanyDenomination;
	}

	public com.fortutech.tcheckit.ejb.sessions.CompanyMapCompanyDenominationEntry[] getMapCompanyDenomination(
			com.fortutech.tcheckit.ejb.sessions.CompanyMapCompanyDenominationEntry[] mapCompanyDenomination) {
		return this.mapCompanyDenomination;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName(java.lang.String name) {
		return this.name;
	}

	public void setOneAddress(
			com.fortutech.tcheckit.ejb.sessions.Address oneAddress) {
		this.oneAddress = oneAddress;
	}

	public com.fortutech.tcheckit.ejb.sessions.Address getOneAddress(
			com.fortutech.tcheckit.ejb.sessions.Address oneAddress) {
		return this.oneAddress;
	}

	public void setOnePhoto(com.fortutech.tcheckit.ejb.sessions.Media onePhoto) {
		this.onePhoto = onePhoto;
	}

	public com.fortutech.tcheckit.ejb.sessions.Media getOnePhoto(
			) {
		return this.onePhoto;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.String getPhone(java.lang.String phone) {
		return this.phone;
	}

	public void setSiretNumber(java.lang.String siretNumber) {
		this.siretNumber = siretNumber;
	}

	public java.lang.String getSiretNumber(java.lang.String siretNumber) {
		return this.siretNumber;
	}

	public void setSocialReason(java.lang.String socialReason) {
		this.socialReason = socialReason;
	}

	public java.lang.String getSocialReason(java.lang.String socialReason) {
		return this.socialReason;
	}

	public void setTVANumber(java.lang.String TVANumber) {
		this.TVANumber = TVANumber;
	}

	public java.lang.String getTVANumber(java.lang.String TVANumber) {
		return this.TVANumber;
	}

	public void setUrlWebsite(java.lang.String urlWebsite) {
		this.urlWebsite = urlWebsite;
	}

	public java.lang.String getUrlWebsite(java.lang.String urlWebsite) {
		return this.urlWebsite;
	}

	public int getPropertyCount() {
		return 18;
	}

	public Object getProperty(int __index) {
		switch (__index) {
		case 0:
			return amountOfCapital;
		case 1:
			return codeAPE;
		case 2:
			return dateBirth;
		case 3:
			return denomination;
		case 4:
			return description;
		case 5:
			return email;
		case 6:
			return fax;
		case 7:
			return id;
		case 8:
			return identificationNumber;
		case 10:
			return name;
		case 11:
			return oneAddress;
		case 12:
			return onePhoto;
		case 13:
			return phone;
		case 14:
			return siretNumber;
		case 15:
			return socialReason;
		case 16:
			return TVANumber;
		case 17:
			return urlWebsite;
		}
		return null;
	}

	public void setProperty(int __index, Object __obj) {
		switch (__index) {
		case 0:
			amountOfCapital = (java.lang.String) __obj;
			break;
		case 1:
			codeAPE = (java.lang.String) __obj;
			break;
		case 2:
			dateBirth = (java.util.Calendar) __obj;
			break;
		case 3:
			denomination = (java.lang.String) __obj;
			break;
		case 4:
			description = (java.lang.String) __obj;
			break;
		case 5:
			email = (java.lang.String) __obj;
			break;
		case 6:
			fax = (java.lang.String) __obj;
			break;
		case 7:
			id = (java.lang.Long) __obj;
			break;
		case 8:
			identificationNumber = (java.lang.String) __obj;
			break;
		case 10:
			name = (java.lang.String) __obj;
			break;
		case 11:
			oneAddress = (com.fortutech.tcheckit.ejb.sessions.Address) __obj;
			break;
		case 12:
			onePhoto = (com.fortutech.tcheckit.ejb.sessions.Media) __obj;
			break;
		case 13:
			phone = (java.lang.String) __obj;
			break;
		case 14:
			siretNumber = (java.lang.String) __obj;
			break;
		case 15:
			socialReason = (java.lang.String) __obj;
			break;
		case 16:
			TVANumber = (java.lang.String) __obj;
			break;
		case 17:
			urlWebsite = (java.lang.String) __obj;
			break;
		}
	}

	public void getPropertyInfo(int __index, Hashtable __table,
			PropertyInfo __info) {
		switch (__index) {
		case 0:
			__info.name = "amountOfCapital";
			__info.type = java.lang.String.class;
			break;
		case 1:
			__info.name = "codeAPE";
			__info.type = java.lang.String.class;
			break;
		case 2:
			__info.name = "dateBirth";
			__info.type = java.util.Calendar.class;
			break;
		case 3:
			__info.name = "denomination";
			__info.type = java.lang.String.class;
			break;
		case 4:
			__info.name = "description";
			__info.type = java.lang.String.class;
			break;
		case 5:
			__info.name = "email";
			__info.type = java.lang.String.class;
			break;
		case 6:
			__info.name = "fax";
			__info.type = java.lang.String.class;
			break;
		case 7:
			__info.name = "id";
			__info.type = java.lang.Long.class;
			break;
		case 8:
			__info.name = "identificationNumber";
			__info.type = java.lang.String.class;
			break;
		case 9:
			__info.name = "mapCompanyDenomination";
		case 10:
			__info.name = "name";
			__info.type = java.lang.String.class;
			break;
		case 11:
			__info.name = "oneAddress";
			__info.type = com.fortutech.tcheckit.ejb.sessions.Address.class;
			break;
		case 12:
			__info.name = "onePhoto";
			__info.type = com.fortutech.tcheckit.ejb.sessions.Media.class;
			break;
		case 13:
			__info.name = "phone";
			__info.type = java.lang.String.class;
			break;
		case 14:
			__info.name = "siretNumber";
			__info.type = java.lang.String.class;
			break;
		case 15:
			__info.name = "socialReason";
			__info.type = java.lang.String.class;
			break;
		case 16:
			__info.name = "TVANumber";
			__info.type = java.lang.String.class;
			break;
		case 17:
			__info.name = "urlWebsite";
			__info.type = java.lang.String.class;
			break;
		}
	}

}
