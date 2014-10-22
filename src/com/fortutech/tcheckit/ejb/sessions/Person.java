package com.fortutech.tcheckit.ejb.sessions;

import java.util.Date;
import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public class Person extends EntityMother implements org.ksoap2.serialization.KvmSerializable {
	
	private static final long serialVersionUID = 1L;
	
	private java.util.Calendar birthday;

	private java.lang.String birthplace;

	private com.fortutech.tcheckit.ejb.sessions.Civility civility;

	private java.lang.String email;

	private com.fortutech.tcheckit.ejb.sessions.FamilyStatus familyStatus;

	private java.lang.String firstName;

	private java.lang.String homePhone;

	private java.lang.Long id;

	private java.lang.String mobilePhone;

	private java.lang.String name;

	private java.lang.String nationality;

	private com.fortutech.tcheckit.ejb.sessions.Address oneAddress;

	public Person() {
		super();
	}

	public Person(UserAccount ua) {
		super();
		this.setId(ua.getId());
	}

	public Person(SoapObject so) {
		super(so);
		/*
		 * consumer{dateUpdated=2014-01-19T19:42:57+01:00; oneFlag=activated;
		 * birthday=1978-11-17T00:00:00+01:00; civility=Monsieur;
		 * email=karim.bakir@gmail.com; familyStatus=single; firstName=Bakir;
		 * homePhone=0663520055; id=133; mobilePhone=0695274012; name=Karim;
		 * oneAddress=anyType{city=BRY SUR MARNE; country=France;
		 * latitude=48.8529; longitude=2.3391; postalCode=94360; street=181 bd
		 * pasteur; street2=anyType{}; }; balancecash=0.0; numberMissions=6;
		 * onePseudo=klykoo; oneUUID=e281892cbbb8093abebc032fc3e0d58de0aea6fa;
		 * points=0; totalcash=0.0; waitcash=8.0; waitpoints=0; } Flag flag =
		 * new Flag(); flag.set_value_(SoapUtils.getSoapString(so, "oneFlag"));
		 * this.setOneFlag(flag);
		 */

		this.setBirthday(SoapUtils.getSoapCalendar(so, "birthday"));

		Civility civ = new Civility();
		civ.set_value_(SoapUtils.getSoapString(so, "civility"));
		this.setCivility(civ);

		this.setEmail(SoapUtils.getSoapString(so, "email"));

		FamilyStatus status = new FamilyStatus();
		status.set_value_(SoapUtils.getSoapString(so, "familyStatus"));
		this.setFamilyStatus(status);

		this.setFirstName(SoapUtils.getSoapString(so, "firstName"));

		this.setHomePhone(SoapUtils.getSoapString(so, "homePhone"));
		this.setId(SoapUtils.getSoapLong(so, "id"));
		this.setMobilePhone(SoapUtils.getSoapString(so, "mobilePhone"));
		this.setName(SoapUtils.getSoapString(so, "name"));
		// Address oneAddress = new Address(so);
		this.setOneAddress(new Address(SoapUtils.getSoapObject(so, "oneAddress")));
	}

	public void setBirthday(java.util.Calendar birthday) {
		this.birthday = birthday;
	}

	public java.util.Calendar getBirthday() {
		return this.birthday;
	}

	public void setBirthplace(java.lang.String birthplace) {
		this.birthplace = birthplace;
	}

	public java.lang.String getBirthplace() {
		return this.birthplace;
	}

	public void setCivility(com.fortutech.tcheckit.ejb.sessions.Civility civility) {
		this.civility = civility;
	}

	public com.fortutech.tcheckit.ejb.sessions.Civility getCivility() {
		return this.civility;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getEmail() {
		return this.email;
	}

	public void setFamilyStatus(com.fortutech.tcheckit.ejb.sessions.FamilyStatus familyStatus) {
		this.familyStatus = familyStatus;
	}

	public com.fortutech.tcheckit.ejb.sessions.FamilyStatus getFamilyStatus() {
		return this.familyStatus;
	}

	public void setFirstName(java.lang.String firstName) {
		this.firstName = firstName;
	}

	public java.lang.String getFirstName() {
		return this.firstName;
	}

	public void setHomePhone(java.lang.String homePhone) {
		this.homePhone = homePhone;
	}

	public java.lang.String getHomePhone() {
		return this.homePhone;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setMobilePhone(java.lang.String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public java.lang.String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setNationality(java.lang.String nationality) {
		this.nationality = nationality;
	}

	public java.lang.String getNationality() {
		return this.nationality;
	}

	public void setOneAddress(com.fortutech.tcheckit.ejb.sessions.Address oneAddress) {
		this.oneAddress = oneAddress;
	}

	public com.fortutech.tcheckit.ejb.sessions.Address getOneAddress() {
		return this.oneAddress;
	}

	public int getPropertyCount() {
		return super.getPropertyCount() + 12;
	}

	public Object getProperty(int __index) {
		if (__index < super.getPropertyCount()) {
			return super.getProperty(__index);
		}
		switch (__index - super.getPropertyCount()) {
		case 0:
			return birthday != null ? birthday : new Date(1900,01,01);
		case 1:
			return birthplace != null ? birthplace : "";
		case 2:
			return civility != null ? civility.get_value_() : "";
		case 3:
			return email != null ? email : "";
		case 4:
			return familyStatus != null ? familyStatus.get_value_() : "";
		case 5:
			return firstName != null ? firstName : "";
		case 6:
			return homePhone != null ? homePhone : "";
		case 7:
			return id != null ? id : "";
		case 8:
			return mobilePhone != null ? mobilePhone : "";
		case 9:
			return name != null ? name : "";
		case 10:
			return nationality != null ? nationality : "";
		case 11:
			return oneAddress != null ? oneAddress : "";
		}
		return null;
	}

	public void setProperty(int __index, Object __obj) {
		switch (__index) {
		case 0:
			birthday = (java.util.Calendar) __obj;
			break;
		case 1:
			birthplace = (java.lang.String) __obj;
			break;
		case 2:
			civility = (com.fortutech.tcheckit.ejb.sessions.Civility) __obj;
			break;
		case 3:
			email = (java.lang.String) __obj;
			break;
		case 4:
			familyStatus = (com.fortutech.tcheckit.ejb.sessions.FamilyStatus) __obj;
			break;
		case 5:
			firstName = (java.lang.String) __obj;
			break;
		case 6:
			homePhone = (java.lang.String) __obj;
			break;
		case 7:
			id = (java.lang.Long) __obj;
			break;
		case 8:
			mobilePhone = (java.lang.String) __obj;
			break;
		case 9:
			name = (java.lang.String) __obj;
			break;
		case 10:
			nationality = (java.lang.String) __obj;
			break;
		case 11:
			oneAddress = (com.fortutech.tcheckit.ejb.sessions.Address) __obj;
			break;
		}
	}

	public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
		if (__index < super.getPropertyCount()) {
			super.getPropertyInfo(__index, __table, __info);
		} else {
			switch (__index - super.getPropertyCount()) {
			case 0:
				__info.name = "birthday";
				if (this.birthday != null) {
					__info.type = java.util.Calendar.class;
				} else {
					__info.type = java.lang.String.class;
				}
				break;
			case 1:
				__info.name = "birthplace";
				__info.type = java.lang.String.class;
				break;
			case 2:
				__info.name = "civility";
				__info.type = java.lang.String.class;
				break;
			case 3:
				__info.name = "email";
				__info.type = java.lang.String.class;
				break;
			case 4:
				__info.name = "familyStatus";
				__info.type = java.lang.String.class;
				break;
			case 5:
				__info.name = "firstName";
				__info.type = java.lang.String.class;
				break;
			case 6:
				__info.name = "homePhone";
				__info.type = java.lang.String.class;
				break;
			case 7:
				__info.name = "id";
				__info.type = java.lang.Long.class;
				break;
			case 8:
				__info.name = "mobilePhone";
				__info.type = java.lang.String.class;
				break;
			case 9:
				__info.name = "name";
				__info.type = java.lang.String.class;
				break;
			case 10:
				__info.name = "nationality";
				__info.type = java.lang.String.class;
				break;
			case 11:
				__info.name = "oneAddress";
				__info.type = com.fortutech.tcheckit.ejb.sessions.Address.class;
				break;
			}
		}
	}

}
