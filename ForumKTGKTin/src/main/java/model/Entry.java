package model;

import java.util.Calendar;

public abstract class Entry {
	private String title;
	private String content;
	private Calendar createdTime;
	private User creator;

	public Entry(String title, String content, User creator) {
		this.title = title;
		this.content = content;
		this.creator = creator;
		createdTime = Calendar.getInstance();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Calendar getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
}
