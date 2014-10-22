package com.tcheckit.vo;

import android.content.Context;
import android.content.SharedPreferences;

import com.fortutech.tcheckit.ejb.sessions.Consumer;
import com.fortutech.tcheckit.ejb.sessions.Mission;
import com.fortutech.tcheckit.ejb.sessions.Sign;

public class DataSession {

	private static DataSession ds = null;

	public static DataSession getInstance() {
		if (ds == null) {
			ds = new DataSession();
		}
		return ds;
	}

	private Consumer consumer;
	private Consumer facebookConsumer;

	public Consumer getFacebookConsumer() {
		return facebookConsumer;
	}

	public void setFacebookConsumer(Consumer facebookConsumer) {
		this.facebookConsumer = facebookConsumer;
	}

	private Mission[] missions;
	private QuestionContainer[] questionContainer;
	private Mission mission;
	private Sign sign;
	private String facebookid;

	public String getFacebookid() {
		return facebookid;
	}

	public void setFacebookid(String facebookid) {
		this.facebookid = facebookid;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Sign getSign() {
		return sign;
	}

	public void setSign(Sign sign) {
		this.sign = sign;
	}

	public void reset(Context c) {
		this.setConsumer(null);
		this.missions = null;
		this.mission = null;
		this.sign = null;
		SharedPreferences prefs = c.getSharedPreferences("tcheckit", 0);
		SharedPreferences.Editor editor = prefs.edit();
		editor.remove("FacebookId");
		editor.remove("LoginMail");
		editor.remove("MdpMail");
		editor.commit();
	}

	public Mission[] getMissions() {
		return missions;
	}

	public void setMissions(Mission[] missions) {
		this.missions = missions;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Mission getMissionPosition(int position) {
		for (Mission mission : this.missions) {
			if (mission.getListSign() != null && mission.getListSign().length > position) {
				return mission;
			} else {
				position -= mission.getListSign().length;
			}
		}
		return null;
	}

	public Sign getSignPosition(int position) {
		for (Mission mission : this.missions) {
			if (mission.getListSign() != null && mission.getListSign().length > position) {
				return mission.getListSign()[position];
			} else {
				position -= mission.getListSign().length;
			}
		}
		return null;
	}

	public QuestionContainer[] getQuestionContainer() {
		return questionContainer;
	}

	public void setQuestionContainer(QuestionContainer[] questionContainer) {
		this.questionContainer = questionContainer;
	}

	public void addQuestionContainer(QuestionContainer qc) {
		QuestionContainer[] liste = new QuestionContainer[this.questionContainer.length + 1];
		System.arraycopy(this.questionContainer, 0, liste, 0, this.questionContainer.length);
		liste[this.questionContainer.length] = qc;
		this.questionContainer = liste;
	}

	public Integer getPerimetre(Context context) {
		SharedPreferences prefs = context.getSharedPreferences("tcheckit", 0);
		Integer perimetre = prefs.getInt("perimetre", 5000000);
		return perimetre;
	}

}
