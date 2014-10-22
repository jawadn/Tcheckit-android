package com.fortutech.tcheckit.ejb.sessions;

import java.util.Hashtable;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public class Consumer extends Person implements
		org.ksoap2.serialization.KvmSerializable {
	
	private static final long serialVersionUID = 1L;
	
	private java.lang.String accountNumber;

	private java.lang.Double balancecash = 0.0;

	private java.lang.Integer bankCode = 0;

	private java.lang.String bicId;

	private java.lang.Integer guichetCode = 0;

	private java.lang.String ibanId;

	private java.lang.Integer numberMissions = 0;

	private com.fortutech.tcheckit.ejb.sessions.Media onePhoto;

	private java.lang.String onePseudo;

	private java.lang.String oneTypePhone;

	private java.lang.String oneUUID;

	private java.lang.String paypalMail;

	private java.lang.Integer points = 0;

	private java.lang.Integer ribKey = 0;

	private java.lang.Double totalcash = 0.0;

	private java.lang.Double waitcash = 0.0;

	private java.lang.Integer waitpoints = 0;

	public Consumer() {
		super();
	}

	public Consumer(SoapObject so) {
		super(so);
		this.setAccountNumber(SoapUtils.getSoapString(so, "accountNumber"));
		this.setBalancecash(SoapUtils.getSoapDouble(so, "balancecash"));
		this.setBankCode(SoapUtils.getSoapInteger(so, "bankCode"));
		this.setBicId(SoapUtils.getSoapString(so, "bicId"));
		this.setGuichetCode(SoapUtils.getSoapInteger(so, "guichetCode"));
		this.setIbanId(SoapUtils.getSoapString(so, "ibanId"));
		this.setNumberMissions(SoapUtils.getSoapInteger(so, "numberMissions"));
		if (Media.parse(so, "onePhoto") != null
				&& Media.parse(so, "onePhoto").length > 0) {
			this.setOnePhoto(Media.parse(so, "onePhoto")[0]);
		}
		this.setOnePseudo(SoapUtils.getSoapString(so, "onePseudo"));
		this.setOneTypePhone(SoapUtils.getSoapString(so, "oneTypePhone"));
		this.setOneUUID(SoapUtils.getSoapString(so, "oneUUID"));
		this.setPaypalMail(SoapUtils.getSoapString(so, "paypalMail"));
		this.setPoints(SoapUtils.getSoapInteger(so, "points"));
		this.setRibKey(SoapUtils.getSoapInteger(so, "ribKey"));
		this.setPoints(SoapUtils.getSoapInteger(so, "points"));
		this.setRibKey(SoapUtils.getSoapInteger(so, "ribKey"));
		this.setTotalcash(SoapUtils.getSoapDouble(so, "totalcash"));
		this.setWaitcash(SoapUtils.getSoapDouble(so, "waitcash"));
		this.setWaitpoints(SoapUtils.getSoapInteger(so, "waitpoints"));

	}

	public Consumer(Person p) {
		super(p);
		/*
		 * this.setAccountNumber(accountNumber);
		 * this.setBalancecash(balancecash);; this.setBankCode(bankCode);
		 * this.setBicId(bicId);
		 */
		this.setBirthday(p.getBirthday());
		this.setBirthplace(p.getBirthplace());
		this.setCivility(p.getCivility());
		this.setEmail(p.getEmail());
		this.setFamilyStatus(p.getFamilyStatus());
		this.setFirstName(p.getFirstName());
		// this.setGuichetCode(guichetCode);
		this.setHomePhone(p.getHomePhone());
		// /this.setIbanId(ibanId);
		this.setId(p.getId());
		this.setMobilePhone(p.getMobilePhone());
		this.setName(p.getName());
		this.setNationality(p.getNationality());
		// this.setNumberMissions(numberMissions);
		this.setOneAddress(p.getOneAddress());
		this.setOneFlag(p.getOneFlag());

		/*
		 * this.setOnePhoto(onePhoto); this.setOnePseudo(onePseudo);
		 * this.setOneUUID(oneUUID); this.setPaypalMail(paypalMail);
		 * this.setPoints(points); this.setRibKey(ribKey);
		 * this.setTotalcash(totalcash); this.setWaitcash(waitcash);
		 * this.setWaitpoints(waitpoints);
		 */

	}

	public void setAccountNumber(java.lang.String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public java.lang.String getAccountNumber() {
		return this.accountNumber;
	}

	public void setBalancecash(java.lang.Double balancecash) {
		this.balancecash = balancecash;
	}

	public java.lang.Double getBalancecash() {
		return this.balancecash;
	}

	public void setBankCode(java.lang.Integer bankCode) {
		this.bankCode = bankCode;
	}

	public java.lang.Integer getBankCode() {
		return this.bankCode;
	}

	public void setBicId(java.lang.String bicId) {
		this.bicId = bicId;
	}

	public java.lang.String getBicId() {
		return this.bicId;
	}

	public void setGuichetCode(java.lang.Integer guichetCode) {
		this.guichetCode = guichetCode;
	}

	public java.lang.Integer getGuichetCode() {
		return this.guichetCode;
	}

	public void setIbanId(java.lang.String ibanId) {
		this.ibanId = ibanId;
	}

	public java.lang.String getIbanId() {
		return this.ibanId;
	}

	public void setNumberMissions(java.lang.Integer numberMissions) {
		this.numberMissions = numberMissions;
	}

	public java.lang.Integer getNumberMissions() {
		return this.numberMissions;
	}

	public void setOnePhoto(com.fortutech.tcheckit.ejb.sessions.Media onePhoto) {
		this.onePhoto = onePhoto;
	}

	public com.fortutech.tcheckit.ejb.sessions.Media getOnePhoto() {
		return this.onePhoto;
	}

	public void setOnePseudo(java.lang.String onePseudo) {
		this.onePseudo = onePseudo;
	}

	public java.lang.String getOnePseudo() {
		return this.onePseudo;
	}

	public void setOneTypePhone(java.lang.String oneTypePhone) {
		this.oneTypePhone = oneTypePhone;
	}

	public java.lang.String getOneTypePhone() {
		return this.oneTypePhone;
	}

	public void setOneUUID(java.lang.String oneUUID) {
		this.oneUUID = oneUUID;
	}

	public java.lang.String getOneUUID() {
		return this.oneUUID;
	}

	public void setPaypalMail(java.lang.String paypalMail) {
		this.paypalMail = paypalMail;
	}

	public java.lang.String getPaypalMail() {
		return this.paypalMail;
	}

	public void setPoints(java.lang.Integer points) {
		this.points = points;
	}

	public java.lang.Integer getPoints() {
		return this.points;
	}

	public void setRibKey(java.lang.Integer ribKey) {
		this.ribKey = ribKey;
	}

	public java.lang.Integer getRibKey() {
		return this.ribKey;
	}

	public void setTotalcash(java.lang.Double totalcash) {
		this.totalcash = totalcash;
	}

	public java.lang.Double getTotalcash() {
		return this.totalcash;
	}

	public void setWaitcash(java.lang.Double waitcash) {
		this.waitcash = waitcash;
	}

	public java.lang.Double getWaitcash() {
		return this.waitcash;
	}

	public void setWaitpoints(java.lang.Integer waitpoints) {
		this.waitpoints = waitpoints;
	}

	public java.lang.Integer getWaitpoints() {
		return this.waitpoints;
	}

	public int getPropertyCount() {
		return super.getPropertyCount() + 17;
	}

	public Object getProperty(int __index) {
		if (__index < super.getPropertyCount()) {
			return super.getProperty(__index);
		} else {
			switch (__index - super.getPropertyCount()) {
			case 0:
				return accountNumber != null ? accountNumber : "";
			case 1:
				return bankCode != null ? bankCode : "";
			case 2:
				return bicId != null ? bicId : "";
			case 3:
				return guichetCode != null ? guichetCode : "";
			case 4:
				return ibanId != null ? ibanId : "";
			case 5:
				return onePhoto != null ? onePhoto : "";
			case 6:
				return onePseudo != null ? onePseudo : "";
			case 7:
				return oneTypePhone != null ? oneTypePhone : "";
			case 8:
				return oneUUID != null ? oneUUID : "";
			case 9:
				return paypalMail != null ? paypalMail : "";
			case 10:
				return ribKey != null ? ribKey : "";
			case 11:
				return balancecash != null ? balancecash : "";
			case 12:
				return numberMissions != null ? numberMissions : "";
			case 13:
				return points != null ? points : "";
			case 14:
				return totalcash != null ? totalcash : "";
			case 15:
				return waitcash != null ? waitcash : "";
			case 16:
				return waitpoints != null ? waitpoints : "";
			}
		}
		return null;
	}

	public void setProperty(int __index, Object __obj) {

		switch (__index) {
		case 0:
			accountNumber = (java.lang.String) __obj;
			break;
		case 1:
			bankCode = (java.lang.Integer) __obj;
			break;
		case 2:
			bicId = (java.lang.String) __obj;
			break;
		case 3:
			guichetCode = (java.lang.Integer) __obj;
			break;
		case 4:
			ibanId = (java.lang.String) __obj;
			break;
		case 5:
			onePhoto = (com.fortutech.tcheckit.ejb.sessions.Media) __obj;
			break;
		case 6:
			onePseudo = (java.lang.String) __obj;
			break;
		case 7:
			oneTypePhone = (java.lang.String) __obj;
			break;
		case 8:
			oneUUID = (java.lang.String) __obj;
			break;
		case 9:
			paypalMail = (java.lang.String) __obj;
			break;
		case 10:
			ribKey = (java.lang.Integer) __obj;
			break;
		case 11:
			balancecash = (java.lang.Double) __obj;
			break;
		case 12:
			numberMissions = (java.lang.Integer) __obj;
			break;
		case 13:
			points = (java.lang.Integer) __obj;
			break;
		case 14:
			totalcash = (java.lang.Double) __obj;
			break;
		case 15:
			waitcash = (java.lang.Double) __obj;
			break;
		case 16:
			waitpoints = (java.lang.Integer) __obj;
			break;
		}
	}

	public void getPropertyInfo(int __index, Hashtable __table,
			PropertyInfo __info) {
		if (__index < super.getPropertyCount()) {
			super.getPropertyInfo(__index, __table, __info);
		} else {
			switch (__index - super.getPropertyCount()) {
			case 0:
				__info.name = "accountNumber";
				__info.type = accountNumber != null ? java.lang.String.class
						: java.lang.String.class;
				break;
			case 1:
				__info.name = "bankCode";
				__info.type = bankCode != null ? java.lang.Integer.class
						: java.lang.String.class;
				break;
			case 2:
				__info.name = "bicId";
				__info.type = bicId != null ? java.lang.String.class
						: java.lang.String.class;
				break;
			case 3:
				__info.name = "guichetCode";
				__info.type = guichetCode != null ? java.lang.Integer.class
						: java.lang.String.class;
				break;
			case 4:
				__info.name = "ibanId";
				__info.type = ibanId != null ? java.lang.String.class
						: java.lang.String.class;
				break;
			case 5:
				__info.name = "onePhoto";
				__info.type = onePhoto != null ? com.fortutech.tcheckit.ejb.sessions.Media.class
						: java.lang.String.class;
				break;
			case 6:
				__info.name = "onePseudo";
				__info.type = onePseudo != null ? java.lang.String.class
						: java.lang.String.class;
				break;
			case 7:
				__info.name = "oneTypePhone";
				__info.type = oneTypePhone != null ? java.lang.String.class
						: java.lang.String.class;
				break;
			case 8:
				__info.name = "oneUUID";
				__info.type = oneUUID != null ? java.lang.String.class
						: java.lang.String.class;
				break;
			case 9:
				__info.name = "paypalMail";
				__info.type = paypalMail != null ? java.lang.String.class
						: java.lang.String.class;
				break;
			case 10:
				__info.name = "ribKey";
				__info.type = ribKey != null ? java.lang.Integer.class
						: java.lang.String.class;
				break;
			case 11:
				__info.name = "balancecash";
				__info.type = balancecash != null ? java.lang.Double.class
						: java.lang.String.class;
				break;
			case 12:
				__info.name = "numberMissions";
				__info.type = numberMissions != null ? java.lang.Integer.class
						: java.lang.String.class;
				break;
			case 13:
				__info.name = "points";
				__info.type = points != null ? java.lang.Integer.class
						: java.lang.String.class;
				break;
			case 14:
				__info.name = "totalcash";
				__info.type = totalcash != null ? java.lang.Double.class
						: java.lang.String.class;
				break;
			case 15:
				__info.name = "waitcash";
				__info.type = waitcash != null ? java.lang.Double.class
						: java.lang.String.class;
				break;
			case 16:
				__info.name = "waitpoints";
				__info.type = waitpoints != null ? java.lang.Integer.class
						: java.lang.String.class;
				break;
			}
		}
	}

}
