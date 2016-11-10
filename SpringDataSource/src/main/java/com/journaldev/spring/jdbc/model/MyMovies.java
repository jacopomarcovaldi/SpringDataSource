package com.journaldev.spring.jdbc.model;

import java.io.Serializable;
import java.util.Date;

public class MyMovies implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String imdb_link;
	private String cover_link;
	private Date insert_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImdb_link() {
		return imdb_link;
	}
	public void setImdb_link(String imdb_link) {
		this.imdb_link = imdb_link;
	}
	public String getCover_link() {
		return cover_link;
	}
	public void setCover_link(String cover_link) {
		this.cover_link = cover_link;
	}
	public Date getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}
	
}
