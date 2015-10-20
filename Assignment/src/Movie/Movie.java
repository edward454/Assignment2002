package Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Movie implements Serializable{
	private String title = "";
	private String duration;
	private String RatingPG;
	private double rating = 0; 			//control by user not staff
	private String genre = "";			
	private ArrayList<DateMovie> ScheduleMovie = new ArrayList<DateMovie>();
	private DateMovie datemovie ;
	
	public Movie(String title, String duration , String ratingPG , String genre ,DateMovie datemovie){
		this.title = title;
		this.duration = duration;
		this.RatingPG = ratingPG;
		this.genre = genre;
		ScheduleMovie.add(datemovie);
	}
	
	//just for quick test i make the simple constructor 
	public Movie(String title){
		this.title = title;
	}
	
	
	//getter and setter for title
	public void SetTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	//getter and setter for duration
	
	public void setDuration(String duration){
		this.duration = duration;
	}
	
	public String getDuration(){
		return duration;
	}
	
	//getter and setter for rating 
	
	public void setRating(double rating){
		this.rating= rating;
	}
	
	public double getRating(){
		return rating;
	}
	
	
	//getter and setter for genre
	
	public void setGenre(String genre){
		this.genre = genre;
	}
	
	public String getGenre(){
		return genre;
	}
	
	//getter and setter for date
	
	public void setTimeStatus(DateMovie datemovie){
		this.ScheduleMovie.add(datemovie);
	}
	
	
	public void getListDateStatusMovie(){
		for(int i = 0 ; i < ScheduleMovie.size() ;i++){
			String statusTime = ScheduleMovie.get(i).getStatusTimeMovie();
			System.out.printf("%d) %s",i+1,statusTime);
		}
	}
	
	public ArrayList<DateMovie> getArrayListOfDateMovie(){
		return ScheduleMovie;
	}
	
	

	public String printDescription(){
		String movieDescription = "Name Movie: "+this.title+"\n"
								   +"Duration: "+this.duration+ "\n"
								   +"Rating: "+this.RatingPG+"\n"
								   +"Genre: "+this.genre+"\n";
		String listTime = "";
		for(int i = 0 ; i < ScheduleMovie.size() ; i++){
			listTime += ScheduleMovie.get(i).getStatusTimeMovie()+"\n";
		}
		movieDescription+=listTime;
		movieDescription+="This movie Rating is "+this.rating+"\n";
		
		return movieDescription;
	}
	
	//getter and setter for the rating of parental guidance
	public void setRatingPG(String ratingpg){
		this.RatingPG = ratingpg;
	}
	
	public String getRatingPG(){
		return RatingPG;
	}
	
}
