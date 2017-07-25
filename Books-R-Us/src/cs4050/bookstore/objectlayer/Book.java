package cs4050.bookstore.objectlayer;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private int ISBN = 0;
	private String title = null;
	private String author = null;
	private String publisher = null;
	private String genre = null; 
	private int year = 0;
	private double price = 0;
	private int stock = 0;
	private int sold = 0;
	private int hold = 0;
	private String imgurl = null;
	private int minimum = 5;
	
	public Book() {}
	
	public Book(int i, String t, String a, String p, String g, int y, double f, int r, int s, String img, int m){
		ISBN = i;
		title = t;
		author = a;
		publisher = p;
		genre = g;
		year = y;
		price = f;
		stock = r;
		sold = s;
		imgurl = img;
		minimum = m;
	}
	
	public Book(int i, String t, String a, String p, String g, int y, double f, int r, int s, String img){
		ISBN = i;
		title = t;
		author = a;
		publisher = p;
		genre = g;
		year = y;
		price = f;
		stock = r;
		sold = s;
		imgurl = img;
	}
	
	public Book(int i, String t, String a, String p, int y, int r, double f, String img){
		ISBN = i;
		title = t;
		author = a;
		publisher = p;
		year = y;
		stock = r;
		price = f;
		imgurl = img;
	}
	
	public Book(int i, String t, String a, String p, int y, double f, String img){
		ISBN = i;
		title = t;
		author = a;
		publisher = p;
		year = y;
		price = f;
		imgurl = img;
	}
	
	public Book(int i, String t, String a, String p, String g, int y, double f){
		ISBN = i;
		title = t;
		author = a;
		publisher = p;
		genre = g;
		year = y;
		price = f;
	}
	
	
	public int getISBN(){
		return ISBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getHold() {
		return hold;
	}
	public void setHold(int hold) {
		this.hold = hold;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getGenre(){
		return genre;
	}
	public void setMinimum(int m){
		this.minimum = m;
	}
	public int getMinimum(){
		return minimum;
	}
}//Book
