package com.fortutech.tcheckit.ejb.sessions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalDate;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.xmlpull.v1.XmlPullParserException;

import android.location.Location;
import android.util.Log;

import com.tcheckit.utils.HttpTransportSE;
import com.tcheckit.utils.MarshalCalendar;
import com.tcheckit.utils.MarshalDouble;
import com.tcheckit.utils.MarshalGregorianCalendar;
import com.tcheckit.utils.MarshalInteger;
import com.tcheckit.utils.MarshalLong;
import com.tcheckit.utils.MissionUtils;
import com.tcheckit.utils.SoapUtils;

public final class TcheckitMobileBean {
	public void sendResponseQuestionInputNumber(long arg0, long arg1, java.lang.Double arg2, long arg3, long arg4) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "sendResponseQuestionInputNumber");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1 + "");
		_client.addProperty("arg2", arg2);
		_client.addProperty("arg3", arg3 + "");
		_client.addProperty("arg4", arg4 + "");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		_envelope.bodyOut = _client;

		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/sendResponseQuestionInputNumber", _envelope);
	}

	public void sendResponseQuestionInputText(long arg0, long arg1, java.lang.String arg2, long arg3, long arg4) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "sendResponseQuestionInputText");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1 + "");
		_client.addProperty("arg2", arg2);
		_client.addProperty("arg3", arg3 + "");
		_client.addProperty("arg4", arg4 + "");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		_envelope.bodyOut = _client;

		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/sendResponseQuestionInputText", _envelope);
	}

	public void sendResponseQuestionMultipleChoice(long idMission, long idConsumer, java.lang.String listIdChoice, long idQuestion, long idSign) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "sendResponseQuestionMultipleChoice");
		_client.addProperty("arg0", idMission + "");
		_client.addProperty("arg1", idConsumer + "");
		_client.addProperty("arg2", listIdChoice);
		_client.addProperty("arg3", idQuestion + "");
		_client.addProperty("arg4", idSign + "");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/sendResponseQuestionMultipleChoice", _envelope);
	}

	public void sendResponseQuestionUniqueChoice(long arg0, long arg1, long arg2, long arg3, long arg4) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "sendResponseQuestionUniqueChoice");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1 + "");
		_client.addProperty("arg2", arg2 + "");
		_client.addProperty("arg3", arg3 + "");
		_client.addProperty("arg4", arg4 + "");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/sendResponseQuestionUniqueChoice", _envelope);
	}

	public void getListChoiceQuestion(com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion arg0) throws Exception {
		SoapObject _client = new SoapObject("", "getListChoiceQuestion");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public java.util.Calendar getLastAnswerForMissionAndSign(long arg0, long arg1, com.fortutech.tcheckit.ejb.sessions.Consumer arg2) throws Exception {
		SoapObject _client = new SoapObject("", "getLastAnswerForMissionAndSign");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1 + "");
		_client.addProperty("arg2", arg2);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		/*
		 * int _len = _ret.getPropertyCount(); java.util.Calendar _returned =
		 * new java.util.Calendar(); for (int _i = 0; _i < _len; _i++) {
		 * _returned.setProperty(_i, _ret.getProperty(_i)); } return _returned;
		 */
		return (java.util.Calendar) _ret.getProperty(0);
	}

	public void sendVerificationCode(java.lang.String arg0, long arg1) throws Exception {
		SoapObject _client = new SoapObject("", "sendVerificationCode");
		_client.addProperty("arg0", arg0);
		_client.addProperty("arg1", arg1 + "");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public com.fortutech.tcheckit.ejb.sessions.UserAccount getUserAccountByLoginByPassword(java.lang.String arg0, java.lang.String arg1) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "getUserAccountByLoginByPassword");
		_client.addProperty("arg0", arg0);
		_client.addProperty("arg1", arg1);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/getUserAccountByLoginByPassword", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		com.fortutech.tcheckit.ejb.sessions.UserAccount _returned = null;
		if (_ret != null) {

			_returned = new com.fortutech.tcheckit.ejb.sessions.UserAccount(_ret);
			/*
			 * for (int _i = 0; _i < _len; _i++) { _returned.setProperty(_i,
			 * _ret.getProperty(_i)); }
			 */}

		return _returned;
	}

	public void updateLocalisationConsumer(long arg0, java.lang.Double arg1, java.lang.Double arg2) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "updateLocalisationConsumer");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1);
		_client.addProperty("arg2", arg2);

		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(_envelope);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/updateLocalisationConsumer", _envelope);
	}

	public com.fortutech.tcheckit.ejb.sessions.Consumer editConsumer(com.fortutech.tcheckit.ejb.sessions.Consumer arg0) throws Exception {
		try {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "editConsumer");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		//_envelope.addMapping("http://sessions.ejb.tcheckit.fortutech.com/consumer", "Consumer", Consumer.class);
		_envelope.bodyOut = _client;

		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		//_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/editConsumer", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		int _len = _ret.getPropertyCount();
		com.fortutech.tcheckit.ejb.sessions.Consumer _returned = new com.fortutech.tcheckit.ejb.sessions.Consumer(_ret);
		/*
		 * for (int _i = 0; _i < _len; _i++) { _returned.setProperty(_i,
		 * _ret.getProperty(_i)); }
		 */
		return _returned;
		}catch (Exception e) {
			Log.v("error", e.getMessage());
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	
	public boolean editConsumerJson(String fbConsumerJson) throws Exception {
		try {
			SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "editConsumerJSON");
			_client.addProperty("arg0", fbConsumerJson);
			SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			
			_envelope.implicitTypes = true;
			_envelope.dotNet = false;
			//_envelope.addMapping("http://sessions.ejb.tcheckit.fortutech.com/consumer", "Consumer", Consumer.class);
			_envelope.bodyOut = _client;
	
			HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
			//_ht.getServiceConnection().setRequestProperty("Connection", "close");
			_ht.call("http://sessions.ejb.tcheckit.fortutech.com/editConsumerJSON", _envelope);
			
			//SoapObject soapObj = (SoapObject) _envelope.getResponse();
			
			return Boolean.parseBoolean(((SoapPrimitive) _envelope.getResponse()).getValue().toString());
			/*
			 * for (int _i = 0; _i < _len; _i++) { _returned.setProperty(_i,
			 * _ret.getProperty(_i)); }
			 */
			
		}catch (Exception e) {
			Log.v("error", e.getMessage());
			e.printStackTrace();
		}
		return true;
	}

	public void addPushIdentifier(com.fortutech.tcheckit.ejb.sessions.PushIdentifier arg0) throws Exception {
		SoapObject _client = new SoapObject("", "addPushIdentifier");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public com.fortutech.tcheckit.ejb.sessions.ResponseQuestionInputText addResponseQuestionInputText(long arg0, com.fortutech.tcheckit.ejb.sessions.Consumer arg1,
			com.fortutech.tcheckit.ejb.sessions.ResponseQuestionInputText arg2, long arg3, com.fortutech.tcheckit.ejb.sessions.Sign arg4) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "addResponseQuestionInputText");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1);
		_client.addProperty("arg2", arg2);
		_client.addProperty("arg3", arg3 + "");
		_client.addProperty("arg4", arg4);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		int _len = _ret.getPropertyCount();
		com.fortutech.tcheckit.ejb.sessions.ResponseQuestionInputText _returned = new com.fortutech.tcheckit.ejb.sessions.ResponseQuestionInputText();
		for (int _i = 0; _i < _len; _i++) {
			_returned.setProperty(_i, _ret.getProperty(_i));
		}
		return _returned;
	}

	public java.lang.String getRandomString(int arg0) throws Exception {
		SoapObject _client = new SoapObject("", "getRandomString");
		_client.addProperty("arg0", arg0 + "");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
		return (java.lang.String) _envelope.getResponse();
	}

	public void uploadImages(java.lang.String arg0, long arg1, long arg2, long arg3) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "uploadImages");
		_client.addProperty("arg0", arg0);
		_client.addProperty("arg1", arg1 + "");
		_client.addProperty("arg2", arg2 + "");
		_client.addProperty("arg3", arg3 + "");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/uploadImages", _envelope);
	}

	public void getListReponseQuestionInputText(com.fortutech.tcheckit.ejb.sessions.ResponseQuestionInputText arg0) throws Exception {
		SoapObject _client = new SoapObject("", "getListReponseQuestionInputText");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public boolean paiementPossible(long arg0) throws Exception {
		SoapObject _client = new SoapObject("", "paiementPossible");
		_client.addProperty("arg0", arg0 + "");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
		return _envelope.getResponse().toString().equals("true");
	}

	public void addPushIdentifierToUserAccount(long arg0, com.fortutech.tcheckit.ejb.sessions.PushIdentifier arg1) throws Exception {
		SoapObject _client = new SoapObject("", "addPushIdentifierToUserAccount");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public void getListQuestionUniqueChoice(com.fortutech.tcheckit.ejb.sessions.QuestionUniqueChoice arg0) throws Exception {
		SoapObject _client = new SoapObject("", "getListQuestionUniqueChoice");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public com.fortutech.tcheckit.ejb.sessions.ResponseQuestionMultipleChoice addResponseQuestionMultipleChoice(long arg0, com.fortutech.tcheckit.ejb.sessions.Consumer arg1,
			com.fortutech.tcheckit.ejb.sessions.ResponseQuestionMultipleChoice arg2, long arg3, com.fortutech.tcheckit.ejb.sessions.Sign arg4) throws Exception {
		SoapObject _client = new SoapObject("", "addResponseQuestionMultipleChoice");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1);
		_client.addProperty("arg2", arg2);
		_client.addProperty("arg3", arg3 + "");
		_client.addProperty("arg4", arg4);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		int _len = _ret.getPropertyCount();
		com.fortutech.tcheckit.ejb.sessions.ResponseQuestionMultipleChoice _returned = new com.fortutech.tcheckit.ejb.sessions.ResponseQuestionMultipleChoice();
		for (int _i = 0; _i < _len; _i++) {
			_returned.setProperty(_i, _ret.getProperty(_i));
		}
		return _returned;
	}

	public com.fortutech.tcheckit.ejb.sessions.Mission[] getListMissionByConsumer(com.fortutech.tcheckit.ejb.sessions.Consumer arg0) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "getListMissionByConsumer");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		new MarshalFloat().register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());

		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/getListMissionByConsumer", _envelope);
		// TODO
		ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission> result = new ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission>();

		if (_envelope.getResponse() != null) {
			if (_envelope.getResponse().getClass().equals(SoapObject.class)) {
				SoapObject _ret = (SoapObject) _envelope.getResponse();
				Mission ms = new Mission(_ret);
				result.add(ms);
			} else {
				java.util.Vector<SoapObject> _ret = (java.util.Vector<SoapObject>) _envelope.getResponse();

				for (SoapObject cs : _ret) {
					Mission ms = new Mission(cs);
					result.add(ms);
					if (result.size() > 10) {
						break;
					}
				}

			}
		}
		return result.toArray(new com.fortutech.tcheckit.ejb.sessions.Mission[result.size()]);
	}

	public void getListReponseQuestionInputNumber(com.fortutech.tcheckit.ejb.sessions.ResponseQuestionInputNumber arg0) throws Exception {
		SoapObject _client = new SoapObject("", "getListReponseQuestionInputNumber");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public com.fortutech.tcheckit.ejb.sessions.Mission[] getListMissionByDistance(java.lang.Double arg0, java.lang.Double arg1, java.lang.Integer arg2) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "getListMissionByDistance");
		_client.addProperty("arg0", arg0);
		_client.addProperty("arg1", arg1);
		_client.addProperty("arg2", arg2);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		new MarshalFloat().register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/getListMissionByDistance", _envelope);
		ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission> result = new ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission>();

		if (_envelope.getResponse() != null) {
			if (_envelope.getResponse().getClass().equals(SoapObject.class)) {
				SoapObject _ret = (SoapObject) _envelope.getResponse();
				Mission ms = new Mission(_ret);
				result.add(ms);
			} else {
				java.util.Vector<SoapObject> _ret = (java.util.Vector<SoapObject>) _envelope.getResponse();

				for (SoapObject cs : _ret) {
					Mission ms = new Mission(cs);
					result.add(ms);
				}

			}
		}
		Location loc1 = new Location("");
		loc1.setLatitude(arg0);
		loc1.setLongitude(arg1);
		return MissionUtils.sort(result, loc1);
	}

	public com.fortutech.tcheckit.ejb.sessions.ResponseQuestionUniqueChoice addResponseQuestionUniqueChoice(long arg0, com.fortutech.tcheckit.ejb.sessions.Consumer arg1,
			com.fortutech.tcheckit.ejb.sessions.ResponseQuestionUniqueChoice arg2, long arg3, com.fortutech.tcheckit.ejb.sessions.Sign arg4) throws Exception {
		SoapObject _client = new SoapObject("", "addResponseQuestionUniqueChoice");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1);
		_client.addProperty("arg2", arg2);
		_client.addProperty("arg3", arg3 + "");
		_client.addProperty("arg4", arg4);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		int _len = _ret.getPropertyCount();
		com.fortutech.tcheckit.ejb.sessions.ResponseQuestionUniqueChoice _returned = new com.fortutech.tcheckit.ejb.sessions.ResponseQuestionUniqueChoice();
		for (int _i = 0; _i < _len; _i++) {
			_returned.setProperty(_i, _ret.getProperty(_i));
		}
		return _returned;
	}

	public com.fortutech.tcheckit.ejb.sessions.UserAccount getUserAccountByLogin(java.lang.String arg0) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "getUserAccountByLogin");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("\"http://sessions.ejb.tcheckit.fortutech.com/getUserAccountByLogin\"", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		int _len = _ret.getPropertyCount();
		com.fortutech.tcheckit.ejb.sessions.UserAccount _returned = new com.fortutech.tcheckit.ejb.sessions.UserAccount(_ret);
		/*
		 * for (int _i = 3; _i < _len; _i++) { _returned.setProperty(_i,
		 * ((SoapObject)_ret.getProperty(5)).getProperty(0)); }
		 */

		return _returned;
	}

	public void getPageElementMedia(com.fortutech.tcheckit.ejb.sessions.PageElementMedia arg0) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "getPageElementMedia");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/getPageElementMedia", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
	}

	public boolean reinitializationPasswordWithEmail(java.lang.String arg0) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "reinitializationPasswordWithEmail");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/reinitializationPasswordWithEmail", _envelope);
		return _envelope.getResponse().toString().equals("true");
	}

	public void getPageElementText(com.fortutech.tcheckit.ejb.sessions.PageElementText arg0) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "getPageElementText");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/", _envelope);
	}

	public ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission> getListMission(java.lang.String arg0) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "getListMission");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		new MarshalFloat().register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/getListMission", _envelope);
		// TODO
		return null;
	}

	public com.fortutech.tcheckit.ejb.sessions.Mission[] getListMissions() throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "getListMissions");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/getListMissions", _envelope);
		ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission> result = new ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission>();
		if (_envelope.getResponse() != null) {
			if (_envelope.getResponse().getClass().equals(SoapObject.class)) {
				SoapObject _ret = (SoapObject) _envelope.getResponse();
				Mission ms = new Mission(_ret);
				result.add(ms);
			} else {
				java.util.Vector<SoapObject> _ret = (java.util.Vector<SoapObject>) _envelope.getResponse();

				for (SoapObject cs : _ret) {
					Mission ms = new Mission(cs);
					result.add(ms);
				}

			}
		}

		return result.toArray(new Mission[result.size()]);

	}

	public com.fortutech.tcheckit.ejb.sessions.Mission[] getListMissionByConsumerByDistance(com.fortutech.tcheckit.ejb.sessions.Consumer arg0, java.lang.Double arg1,
			java.lang.Double arg2, java.lang.Integer arg3) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "getListMissionByConsumerByDistance");
		_client.addProperty("arg0", arg0);
		_client.addProperty("arg1", arg1);
		_client.addProperty("arg2", arg2);
		_client.addProperty("arg3", arg3);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		new MarshalFloat().register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		/*
		 * MarshalConsumer mc = new MarshalConsumer(); mc.register(_envelope);
		 */
		_envelope.addMapping("http://sessions.ejb.tcheckit.fortutech.com/consumer", "Consumer", Consumer.class);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		ArrayList<HeaderProperty> headerPropertyArrayList = new ArrayList<HeaderProperty>();
		headerPropertyArrayList.add(new HeaderProperty("Connection", "close"));
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/getListMissionByConsumerByDistance", _envelope, headerPropertyArrayList);
		ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission> result = new ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission>();

		if (_envelope.getResponse() != null) {
			if (_envelope.getResponse().getClass().equals(SoapObject.class)) {
				SoapObject _ret = (SoapObject) _envelope.getResponse();
				Mission ms = new Mission(_ret);
				result.add(ms);
			} else {
				java.util.Vector<SoapObject> _ret = (java.util.Vector<SoapObject>) _envelope.getResponse();

				for (SoapObject cs : _ret) {
					Mission ms = new Mission(cs);
					result.add(ms);
				}

			}
		}
		Location loc1 = new Location("");
		loc1.setLatitude(arg1);
		loc1.setLongitude(arg2);
		return MissionUtils.sort(result, loc1);

	}

	public com.fortutech.tcheckit.ejb.sessions.Mission[] getListMissionByDistanceByConsumer(java.lang.Double arg0, java.lang.Double arg1, java.lang.Integer arg2,
			java.lang.Long arg3) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "getListMissionByDistanceByConsumer");
		_client.addProperty("arg0", arg0);
		_client.addProperty("arg1", arg1);
		_client.addProperty("arg2", arg2);
		_client.addProperty("arg3", arg3);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		new MarshalFloat().register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		/*
		 * MarshalConsumer mc = new MarshalConsumer(); mc.register(_envelope);
		 */
		_envelope.addMapping("http://sessions.ejb.tcheckit.fortutech.com/consumer", "Consumer", Consumer.class);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/getListMissionByDistanceByConsumer", _envelope);
		ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission> result = new ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission>();

		if (_envelope.getResponse() != null) {
			if (_envelope.getResponse().getClass().equals(SoapObject.class)) {
				SoapObject _ret = (SoapObject) _envelope.getResponse();
				Mission ms = new Mission(_ret);
				result.add(ms);
			} else {
				java.util.Vector<SoapObject> _ret = (java.util.Vector<SoapObject>) _envelope.getResponse();

				for (SoapObject cs : _ret) {
					Mission ms = new Mission(cs);
					result.add(ms);
				}

			}
		}
		Location loc1 = new Location("");
		loc1.setLatitude(arg0);
		loc1.setLongitude(arg1);
		Mission[] sortedMissions = MissionUtils.sort(result, loc1);
		return Arrays.copyOfRange(sortedMissions, 0, 300);
	}

	public ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission> missionAvailable(long arg0, long arg1) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "missionAvailable");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1 + "");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalLong md = new MarshalLong();
		md.register(_envelope);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/missionAvailable", _envelope);
		java.util.Vector<SoapObject> _ret = (java.util.Vector<SoapObject>) _envelope.getResponse();
		ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission> result = new ArrayList<com.fortutech.tcheckit.ejb.sessions.Mission>();
		if (_ret != null) {
			for (SoapObject cs : _ret) {
				Mission ms = new Mission(cs);
				result.add(ms);
			}
		}
		return result;
	}

	public boolean missionAvailableForConsumer(java.lang.Long arg0, java.lang.Long arg1, java.lang.Long arg2) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "missionAvailableForConsumer");
		_client.addProperty("arg0", arg0);
		_client.addProperty("arg1", arg1);
		_client.addProperty("arg2", arg2);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		new MarshalLong().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/missionAvailableForConsumer", _envelope);

		return Boolean.parseBoolean(((SoapPrimitive) _envelope.getResponse()).getValue().toString());

	}

	public com.fortutech.tcheckit.ejb.sessions.Consumer getUserFacebookByLogin(java.lang.String arg0) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "getUserFacebookByLogin");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.implicitTypes = true;
		_envelope.bodyOut = _client;
		_envelope.dotNet = false;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());

		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/getUserFacebookByLogin", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		com.fortutech.tcheckit.ejb.sessions.Consumer _returned = new com.fortutech.tcheckit.ejb.sessions.Consumer(SoapUtils.getSoapObject(_ret, "onePerson"));

		/*
		 * for (int _i = 0; _i < _len; _i++) { _returned.setProperty(_i,
		 * _ret.getProperty(_i)); }
		 */
		return _returned;
	}

	public void getListReponseQuestionUniqueChoice(com.fortutech.tcheckit.ejb.sessions.ResponseQuestionUniqueChoice arg0) throws Exception {
		SoapObject _client = new SoapObject("", "getListReponseQuestionUniqueChoice");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public com.fortutech.tcheckit.ejb.sessions.UserAccount createConsumerAccount(java.lang.String arg0, java.lang.String arg1) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "createConsumerAccount");
		_client.addProperty("arg0", arg0);
		_client.addProperty("arg1", arg1);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/createConsumerAccount", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		if (_ret != null) {
			com.fortutech.tcheckit.ejb.sessions.UserAccount _returned = new com.fortutech.tcheckit.ejb.sessions.UserAccount(_ret);
			return _returned;
		}
		/*
		 * for (int _i = 0; _i < _len; _i++) { _returned.setProperty(_i,
		 * _ret.getProperty(_i)); }
		 */
		return null;
	}

	public void requestPaiement(com.fortutech.tcheckit.ejb.sessions.Consumer arg0) throws Exception {
		SoapObject _client = new SoapObject("", "requestPaiement");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public void getListQuestionInputText(com.fortutech.tcheckit.ejb.sessions.QuestionInputText arg0) throws Exception {
		SoapObject _client = new SoapObject("", "getListQuestionInputText");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public void getListQuestionMultipleChoice(com.fortutech.tcheckit.ejb.sessions.QuestionMultipleChoice arg0) throws Exception {
		SoapObject _client = new SoapObject("", "getListQuestionMultipleChoice");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public boolean askVirement(long arg0) throws Exception {
		SoapObject _client = new SoapObject("", "askVirement");
		_client.addProperty("arg0", arg0 + "");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
		return _envelope.getResponse().toString().equals("true");
	}

	public com.fortutech.tcheckit.ejb.sessions.UserAccount editUserAccount(com.fortutech.tcheckit.ejb.sessions.UserAccount arg0) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "editUserAccount");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;

		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		//_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/editUserAccount", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		int _len = _ret.getPropertyCount();
		com.fortutech.tcheckit.ejb.sessions.UserAccount _returned = new com.fortutech.tcheckit.ejb.sessions.UserAccount();
		/*
		 * for (int _i = 0; _i < _len; _i++) { _returned.setProperty(_i,
		 * _ret.getProperty(_i)); }
		 */
		return _returned;
	}

	public com.fortutech.tcheckit.ejb.sessions.ResponseQuestionInputNumber addResponseQuestionInputNumber(long arg0, com.fortutech.tcheckit.ejb.sessions.Consumer arg1,
			com.fortutech.tcheckit.ejb.sessions.ResponseQuestionInputNumber arg2, long arg3, com.fortutech.tcheckit.ejb.sessions.Sign arg4) throws Exception {
		SoapObject _client = new SoapObject("", "addResponseQuestionInputNumber");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1);
		_client.addProperty("arg2", arg2);
		_client.addProperty("arg3", arg3 + "");
		_client.addProperty("arg4", arg4);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		int _len = _ret.getPropertyCount();
		com.fortutech.tcheckit.ejb.sessions.ResponseQuestionInputNumber _returned = new com.fortutech.tcheckit.ejb.sessions.ResponseQuestionInputNumber();
		for (int _i = 0; _i < _len; _i++) {
			_returned.setProperty(_i, _ret.getProperty(_i));
		}
		return _returned;
	}

	public boolean requestPaiementReturn(com.fortutech.tcheckit.ejb.sessions.Consumer arg0) throws Exception {
		SoapObject _client = new SoapObject("", "requestPaiementReturn");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
		return _envelope.getResponse().toString().equals("true");
	}

	public void getListResponseQuestion(com.fortutech.tcheckit.ejb.sessions.ResponseQuestion arg0) throws Exception {
		SoapObject _client = new SoapObject("", "getListResponseQuestion");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public void getListReponseQuestionMultipleChoice(com.fortutech.tcheckit.ejb.sessions.ResponseQuestionMultipleChoice arg0) throws Exception {
		SoapObject _client = new SoapObject("", "getListReponseQuestionMultipleChoice");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public boolean uploadListImage(java.lang.String arg0, long arg1, com.fortutech.tcheckit.ejb.sessions.Consumer arg2, com.fortutech.tcheckit.ejb.sessions.Sign arg3)
			throws Exception {
		SoapObject _client = new SoapObject("", "uploadListImage");
		_client.addProperty("arg0", arg0);
		_client.addProperty("arg1", arg1 + "");
		_client.addProperty("arg2", arg2);
		_client.addProperty("arg3", arg3);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
		return _envelope.getResponse().toString().equals("true");
	}

	public float distFrom(float arg0, float arg1, float arg2, float arg3) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "distFrom");
		_client.addProperty("arg0", arg0 + "");
		_client.addProperty("arg1", arg1 + "");
		_client.addProperty("arg2", arg2 + "");
		_client.addProperty("arg3", arg3 + "");
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
		return Float.parseFloat(_envelope.getResponse().toString());
	}

	public com.fortutech.tcheckit.ejb.sessions.Consumer editPhotoProfileUser(com.fortutech.tcheckit.ejb.sessions.Consumer arg0, java.lang.String arg1) throws Exception {
		SoapObject _client = new SoapObject("", "editPhotoProfileUser");
		_client.addProperty("arg0", arg0);
		_client.addProperty("arg1", arg1);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
		SoapObject _ret = (SoapObject) _envelope.getResponse();
		int _len = _ret.getPropertyCount();
		com.fortutech.tcheckit.ejb.sessions.Consumer _returned = new com.fortutech.tcheckit.ejb.sessions.Consumer();
		for (int _i = 0; _i < _len; _i++) {
			_returned.setProperty(_i, _ret.getProperty(_i));
		}
		return _returned;
	}

	public void getListQuestionInputNumber(com.fortutech.tcheckit.ejb.sessions.QuestionInputNumber arg0) throws Exception {
		SoapObject _client = new SoapObject("", "getListQuestionInputNumber");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.call("", _envelope);
	}

	public boolean askPaiement(com.fortutech.tcheckit.ejb.sessions.Consumer arg0) throws Exception {
		SoapObject _client = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "askPaiement");
		_client.addProperty("arg0", arg0);
		SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(_envelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(_envelope);
		MarshalLong ml = new MarshalLong();
		ml.register(_envelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(_envelope);
		new MarshalDate().register(_envelope);
		new MarshalCalendar().register(_envelope);
		new MarshalGregorianCalendar().register(_envelope);
		_envelope.implicitTypes = true;
		_envelope.dotNet = false;
		_envelope.bodyOut = _client;
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/askPaiement", _envelope);
		return _envelope.getResponse().toString().equals("true");
	}
	
	public void sendCompleteMissionResponse(long missionId, long consumerId, long signId, java.lang.String jsonResponse) throws IOException, XmlPullParserException{
		
		SoapObject soapClientObject = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "saveResponse");
		soapClientObject.addProperty("arg0", missionId + "");
		soapClientObject.addProperty("arg1", consumerId + "");
		soapClientObject.addProperty("arg2", signId + "");
		soapClientObject.addProperty("arg3", jsonResponse);
		soapClientObject.addProperty("arg4", "android");
		
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		MarshalDouble md = new MarshalDouble();
		md.register(soapEnvelope);
		MarshalInteger mi = new MarshalInteger();
		mi.register(soapEnvelope);
		MarshalLong ml = new MarshalLong();
		ml.register(soapEnvelope);
		MarshalFloat mf = new MarshalFloat();
		mf.register(soapEnvelope);
		
		new MarshalDate().register(soapEnvelope);
		new MarshalCalendar().register(soapEnvelope);
		new MarshalGregorianCalendar().register(soapEnvelope);
		
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = false;
		soapEnvelope.bodyOut = soapClientObject;
		
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/saveResponse", soapEnvelope);
	}
	
	public void sendGcmRegisterRequest(String gcmJson) throws HttpResponseException, IOException, XmlPullParserException{
		
		SoapObject soapClient = new SoapObject("http://sessions.ejb.tcheckit.fortutech.com/", "registerPushIdentifier");
		soapClient.addProperty("arg0", gcmJson + "");
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.implicitTypes = true;
		envelope.dotNet = false;
		envelope.bodyOut = soapClient;
		
		HttpTransportSE _ht = new HttpTransportSE(Configuration.getWsUrl());
		_ht.getServiceConnection().setRequestProperty("Connection", "close");
		_ht.call("http://sessions.ejb.tcheckit.fortutech.com/registerPushIdentifier", envelope);
		
		
		
	}
}
