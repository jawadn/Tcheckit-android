package com.fortutech.tcheckit.ejb.sessions;

import java.util.ArrayList;
import java.util.Hashtable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.tcheckit.utils.SoapUtils;

public class Question extends com.fortutech.tcheckit.ejb.sessions.EntityMother implements org.ksoap2.serialization.KvmSerializable {
	private boolean descriptionQuestion;

	private java.lang.Long id;

	private com.fortutech.tcheckit.ejb.sessions.Product oneProduct;

	private java.lang.String oneTitle;

	private int position;

	public Question() {
		super();
	}

	public Question(SoapObject so) {
		super(so);
		this.setDescriptionQuestion(SoapUtils.getSoapBoolean(so, "descriptionQuestion"));
		this.setId(SoapUtils.getSoapLong(so, "id"));
		this.setOneFlag(new Flag(SoapUtils.getSoapString(so, "oneFlag")));
		this.setOneProduct(new Product(SoapUtils.getSoapObject(so, "oneProduct")));
		this.setOneTitle(SoapUtils.getSoapString(so, "oneTitle"));
		this.setPosition(SoapUtils.getSoapInteger(so, "position"));

	}

	public static Question[] parse(SoapObject so, String name) {
		ArrayList<Question> list = new ArrayList<Question>();
		// java.util.Vector<SoapObject> so2 = (java.util.Vector<SoapObject>)
		// SoapUtils.getSoapObjects(so, name);
		if (so != null) {
			for (int i = 0; i < so.getPropertyCount(); i++) {
				if (so.getProperty(i) != null && so.getProperty(i).getClass().equals(SoapObject.class)) {
					PropertyInfo pi = new PropertyInfo();
					so.getPropertyInfo(i, pi);
					if (pi.getName().equals(name)) {

						SoapObject questionGenerique = (SoapObject) so.getProperty(i);
						if (questionGenerique.getName().equals("questionUniqueChoice")) {
							QuestionUniqueChoice ms = new QuestionUniqueChoice(questionGenerique);
							list.add(ms);
						} else if (questionGenerique.getName().equals("questionMultipleChoice")) {
							QuestionMultipleChoice ms = new QuestionMultipleChoice(questionGenerique);
							list.add(ms);
						} else if (questionGenerique.getName().equals("questionInputNumber")) {
							QuestionInputNumber ms = new QuestionInputNumber(questionGenerique);
							list.add(ms);
						} else if (questionGenerique.getName().equals("questionInputText")) {
							QuestionInputText ms = new QuestionInputText(questionGenerique);
							list.add(ms);
						}

					}
				}
			}
		}
		return list.toArray(new Question[list.size()]);
	}

	public void setDescriptionQuestion(boolean descriptionQuestion) {
		this.descriptionQuestion = descriptionQuestion;
	}

	public boolean getDescriptionQuestion() {
		return this.descriptionQuestion;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setOneProduct(com.fortutech.tcheckit.ejb.sessions.Product oneProduct) {
		this.oneProduct = oneProduct;
	}

	public com.fortutech.tcheckit.ejb.sessions.Product getOneProduct() {
		return this.oneProduct;
	}

	public void setOneTitle(java.lang.String oneTitle) {
		this.oneTitle = oneTitle;
	}

	public java.lang.String getOneTitle() {
		return this.oneTitle;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return this.position;
	}

	public int getPropertyCount() {
		return 5;
	}

	public Object getProperty(int __index) {
		switch (__index) {
		case 0:
			return new Boolean(descriptionQuestion);
		case 1:
			return id;
		case 2:
			return oneProduct;
		case 3:
			return oneTitle;
		case 4:
			return new Integer(position);
		}
		return null;
	}

	public void setProperty(int __index, Object __obj) {
		switch (__index) {
		case 0:
			descriptionQuestion = "true".equals(__obj.toString());
			break;
		case 1:
			id = (java.lang.Long) __obj;
			break;
		case 2:
			oneProduct = (com.fortutech.tcheckit.ejb.sessions.Product) __obj;
			break;
		case 3:
			oneTitle = (java.lang.String) __obj;
			break;
		case 4:
			position = Integer.parseInt(__obj.toString());
			break;
		}
	}

	public void getPropertyInfo(int __index, Hashtable __table, PropertyInfo __info) {
		switch (__index) {
		case 0:
			__info.name = "descriptionQuestion";
			__info.type = Boolean.class;
			break;
		case 1:
			__info.name = "id";
			__info.type = java.lang.Long.class;
			break;
		case 2:
			__info.name = "oneProduct";
			__info.type = com.fortutech.tcheckit.ejb.sessions.Product.class;
			break;
		case 3:
			__info.name = "oneTitle";
			__info.type = java.lang.String.class;
			break;
		case 4:
			__info.name = "position";
			__info.type = Integer.class;
			break;
		}
	}

}
