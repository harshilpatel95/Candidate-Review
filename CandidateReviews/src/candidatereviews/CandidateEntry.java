package candidatereviews;

import java.util.ArrayList;
import java.util.List;

public class CandidateEntry {
	Integer id;
	String name;
	String specialty;
	String presentation;
	List<Feedback> feedback;

	String rating;

	public CandidateEntry() {

	}

	public CandidateEntry(Integer id, String name, String specialty, String rating, String presentation) {
		this.id = id;
		this.name = name;
		this.specialty = specialty;
		this.presentation = presentation;
		this.rating = rating;
		feedback = new ArrayList<Feedback>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}