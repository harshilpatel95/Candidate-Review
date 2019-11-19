package candidatereviews;

import java.util.Date;

public class Feedback {
	Integer rate;
	String name1;
	String comment;
	Date date;
	Integer owner_id;

	public Integer getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}

	public Feedback(Integer rate, String name1, String comment, Date date) {

		this.name1 = name1;
		this.comment = comment;
		this.date = date;
		this.rate = rate;
		this.owner_id = owner_id;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
