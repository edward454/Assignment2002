package Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Movie implements Serializable{
	
	private String title = "";
	private String duration="";
	private String ratingPG;
	private double rating = 0; 			//control by user not staff
	private double price = 0;
	private String genre = "";
	private String director = "";
	private ArrayList<String> castList = new ArrayList<String>();
	private String synopsis = "";
	private ArrayList<DateMovie> scheduleMovie = new ArrayList<DateMovie>();
	
	public Movie(String title, String duration , String ratingPG , String genre,
			DateMovie datemovie,double price,String director,ArrayList<String> listCast,String synopsis){
		this.title = title;
		this.duration = duration;
		this.ratingPG = ratingPG;
		this.genre = genre;
		this.price = price;
		scheduleMovie.add(datemovie);
		this.director = director;
		this.synopsis = synopsis;
		this.castList = listCast;
	}
	
	//getter and setter for director 
	public void setDirector(String director){
		this.director = director;
	}
	
	public String getDirector(){
		return director;
	}
	
	//getter and setter for synopsis
	
	public void setSynopsis(String synopsis){
		this.synopsis = synopsis;
	}
	
	public String getSynopsis(){
		return synopsis;
	}
	
	
	//getter and setter for cast
	
	public void setCastList(ArrayList<String> castList){
		this.castList =  castList;
	}
	
	public ArrayList<String> getCastList(){	
		return castList;
	}
	
	//add cast to the castList
	
	public void addCastToCastList(String cast){
		castList.add(cast);
	}
	
	public void RemoveCastFromCastList(int index){
		castList.remove(index);
	}
	
	//getter and setter for title
	public void setTitle(String title){
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
		this.scheduleMovie.add(datemovie);
	}
	
	
	
	//getter and setter for the rating of parental guidance
	public void setRatingPG(String ratingPG){
		this.ratingPG = ratingPG;
	}
	
	public String getRatingPG(){
		return ratingPG;
	}
	
	//getter and setter for price
	public void setPrice(double price){
		this.price = price;
	}
	
	public double getPrice(){
		return price;
	}
	
	//getting array of dateMovie
	public ArrayList<DateMovie> getArrayListOfDateMovie(){
		return scheduleMovie;
	}
	
	/* printting function */
	///////////////////////////////////////////////////////////////////
	
	public void getListDateStatusMovie(){
		//to display the schedule first we are going to sorted the schedule first 
		//sorting using insertion sort
		
		for(int i = 1 ; i < scheduleMovie.size() ; i++){
			for(int j = i ; j > 0 ; j--){
				DateMovie buffer;
				if(scheduleMovie.get(j).compareTo(scheduleMovie.get(j-1)) == -1){
					buffer = scheduleMovie.get(j);
					scheduleMovie.set(j, scheduleMovie.get(j-1));
					scheduleMovie.set(j-1,buffer);
				}else{
					break;
				}
			}
		}
		for(int i = 0 ; i < scheduleMovie.size() ;i++){
			String statusTime = scheduleMovie.get(i).getStatusTimeMovie();
			System.out.printf("%d) %s",i+1,statusTime);
		}
	}
	

	public String printDescription(){
		String movieDescription = "Title Movie: "+this.title+"\n"
								   +"Duration: "+this.duration+ "\n"
								   +"RatingPG: "+this.ratingPG+"\n"
								   +"Genre: "+this.genre+"\n"
								   +"Price: "+this.price+"\n"
								   +"Schedule Movie: \n\n";
		String listTime = "";
		//to display the schedule first we are going to sorted the schedule first 
		//sorting using insertion sort
		for(int i = 1 ; i < scheduleMovie.size() ; i++){
			for(int j = i ; j > 0 ; j--){
				DateMovie buffer;
				if(scheduleMovie.get(j).compareTo(scheduleMovie.get(j-1)) == -1){
					buffer = scheduleMovie.get(j);
					scheduleMovie.set(j, scheduleMovie.get(j-1));
					scheduleMovie.set(j-1,buffer);
				}else{
					break;
				}
			}
		}
		
		for(int i = 0 ; i < scheduleMovie.size() ; i++){
			if(i >= 1){
				DateMovie current = scheduleMovie.get(i);
				DateMovie before = scheduleMovie.get(i-1);
				if(!((current.getYear() == before.getYear()) && (current.getMonth() == before.getMonth()) 
						&& (current.getDay() == before.getDay()))){
					String bannerDate = "----------"+current.getYearMonthDay()+"----------\n";
					listTime+=bannerDate;
				}
			}else{
				String bannerDate = "----------"+scheduleMovie.get(0).getYearMonthDay()+"----------\n";
				listTime+=bannerDate;
			}
			listTime += scheduleMovie.get(i).getStatusTimeMovie()+"\n";
		}
		
		movieDescription+=listTime;
		return movieDescription;
	}
	
	public String printFullDescription(){
		String movieDescription = "Title Movie: "+this.title+"\n"
						   +"Duration: "+this.duration+ "\n"
						   +"RatingPG: "+this.ratingPG+"\n"
						   +"Genre: "+this.genre+"\n"
						   +"Price: "+this.price+"\n"
						   +"Schedule Movie: \n\n";
		String listTime = "";
		//to display the schedule first we are going to sorted the schedule first 
		//sorting using insertion sort
		for(int i = 1 ; i < scheduleMovie.size() ; i++){
			for(int j = i ; j > 0 ; j--){
				DateMovie buffer;
				if(scheduleMovie.get(j).compareTo(scheduleMovie.get(j-1)) == -1){
					buffer = scheduleMovie.get(j);
					scheduleMovie.set(j, scheduleMovie.get(j-1));
					scheduleMovie.set(j-1,buffer);
				}else{
					break;
				}
			}
			}
		
			for(int i = 0 ; i < scheduleMovie.size() ; i++){
				if(i >= 1){
					DateMovie current = scheduleMovie.get(i);
					DateMovie before = scheduleMovie.get(i-1);
				if(!((current.getYear() == before.getYear()) && (current.getMonth() == before.getMonth()) 
						&& (current.getDay() == before.getDay()))){
						String bannerDate = "----------"+current.getYearMonthDay()+"----------\n";
						listTime+=bannerDate;
				}
				}else{
					String bannerDate = "----------"+scheduleMovie.get(0).getYearMonthDay()+"----------\n";
					listTime+=bannerDate;
				}
				listTime += scheduleMovie.get(i).getStatusTimeMovie()+"\n";
			}
		
			movieDescription+=listTime;
			movieDescription+="\nRating: "+this.rating+"\n";
		
		return movieDescription;
	}

	//////////////////////////////////
}
