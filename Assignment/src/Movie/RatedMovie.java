package Movie;

import java.util.ArrayList;

import Interface.Database;

public class RatedMovie extends Movie implements Database{
	
	private String movieTitle;	
	private double rating;
	private boolean isRated = false;
	
	public RatedMovie(double rating, String movieTitle){	
		
		super(movieTitle);
		this.movieTitle = movieTitle;		
		if(isRated()){
			countAverageRating(rating);
		}
		else
			this.rating = rating;
		isRated = true;
	}	

	
	public double getRating(){
		
		return rating;
		
	}
	
	public String getTitle(){
		
		return movieTitle;
		
	}
	
	public boolean isRated(){
		
		return isRated;
		
	}
	
	private double countAverageRating(double rating){
		
		return (this.rating + rating) / 2;
		
	}


	@Override
	public void writeToDatabase(String filename, ArrayList<Object> list) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ArrayList readFromDatabase(String filename) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
