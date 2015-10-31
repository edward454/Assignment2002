package Cineplex;

import java.io.Serializable;
import java.util.ArrayList;

import Cinema.Cinema;
import Movie.DateMovie;
import Movie.Movie;

//Each of cineplex will have a list of cinema

public class Cineplex implements Serializable{
	
	private String cineplexName="";
	private int cinemaSize = 0;
	private ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
	public ArrayList<DateMovie> holidayList = new ArrayList<DateMovie>();
	private ArrayList<Movie> movieList = new ArrayList<Movie>();

	//constructor
	
	public Cineplex(){
		
	}
	
	public Cineplex(String cineplexName){
		this.cineplexName = cineplexName;
	}
	
	//end of constructor
	
	
	//add and remove  movie 
	public void addMovie(Movie movie){
		movieList.add(movie);
	}
	
	public ArrayList<Movie> getMovieList(){
		return movieList;
	}
	
	public Movie getMovie(int index){
		return movieList.get(index);
	}
	
	public void removeMovie(Movie movie){
		movieList.remove(movie);
	}
	//end of add and remove movie
	
	
	
	public String getCineplexName(){
		return cineplexName;
	}
	
	public ArrayList<Cinema> getCinemaList(){
		return cinemaList;
	}
	
	
	public void addCinema(Cinema cinema){
		cinemaList.add(cinema);
	}
	
	public Cinema getCinema(int index){
		return cinemaList.get(index);
	}
	
	public void RemoveCinema(Cinema cinema){
		for(int i = 0 ; i < cinemaList.size() ; i++){
			if(cinemaList.get(i).equals(cinema)) {
				cinemaList.remove(i);
				break;
			}
		}
	}
	
	public void listMovie(boolean withDetails){
		
		if(movieList.size() == 0) return;
		
		if (withDetails){
			
			for (int i = 0; i < movieList.size(); i++){
				
				System.out.println(movieList.get(i).printDescription());
				
			}
			
		}
		else{
			
			for (int i = 0; i < movieList.size(); i++){
				
				System.out.printf("%d) ", i + 1);
				System.out.println(movieList.get(i).getTitle());
				
			}
			
		}	
		
	}
	
}
