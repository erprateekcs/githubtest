package com.prateek.firstmservice.moviecatalogservice.resources;

public class CatalogItem {

	public CatalogItem(String muveename, String muveedesc, int rating) {
		super();
		Muveename = muveename;
		Muveedesc = muveedesc;
		this.rating = rating;
	}
	private String Muveename;
	private String Muveedesc;
	private int  rating;
	public String getMuveename() {
		return Muveename;
	}
	public void setMuveename(String muveename) {
		Muveename = muveename;
	}
	public String getMuveedesc() {
		return Muveedesc;
	}
	public void setMuveedesc(String muveedesc) {
		Muveedesc = muveedesc;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
}
