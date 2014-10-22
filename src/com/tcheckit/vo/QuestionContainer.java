package com.tcheckit.vo;

import java.util.ArrayList;

import android.view.View;
import android.widget.CheckBox;

public class QuestionContainer {
	private Long idConsumer;
	private Long idMission;
	private Long idQuestion;
	private Long idSign;
	private View view = null;
	private Long idChoice = null;
	private String imagePath = null;
	private ArrayList<CheckBox> listeChoices = null;

	public ArrayList<CheckBox> getListeChoices() {
		return listeChoices;
	}

	public void setListeChoices(ArrayList<CheckBox> listeChoices) {
		this.listeChoices = listeChoices;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public QuestionContainer(Long idConsumer, Long idMission, Long idQuestion, Long idSign, View view) {
		this.idConsumer = idConsumer;
		this.idMission = idMission;
		this.idQuestion = idQuestion;
		this.idSign = idSign;
		this.view = view;

	}

	public QuestionContainer(Long idConsumer, Long idMission, Long idQuestion, Long idSign, Long idChoice, View view) {
		this.idConsumer = idConsumer;
		this.idMission = idMission;
		this.idQuestion = idQuestion;
		this.idSign = idSign;
		this.idChoice = idChoice;
		this.view = view;

	}

	public Long getIdChoice() {
		return idChoice;
	}

	public void setIdChoice(Long idChoice) {
		this.idChoice = idChoice;
	}

	public QuestionContainer(Long idConsumer, Long idMission, Long idQuestion, Long idSign, String imgPath) {
		this.idConsumer = idConsumer;
		this.idMission = idMission;
		this.idQuestion = idQuestion;
		this.idSign = idSign;
		this.view = null;
		this.imagePath = imgPath;

	}

	public long getIdConsumer() {
		return idConsumer;
	}

	public void setIdConsumer(Long idConsumer) {
		this.idConsumer = idConsumer;
	}

	public long getIdMission() {
		return idMission;
	}

	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}

	public long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public long getIdSign() {
		return idSign;
	}

	public void setIdSign(Long idSign) {
		this.idSign = idSign;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}
}
