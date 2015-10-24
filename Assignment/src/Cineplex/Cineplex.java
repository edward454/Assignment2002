package Cineplex;

import java.io.Serializable;
import java.util.ArrayList;

import Cinema.Cinema;
import Movie.DateMovie;
import Movie.Movie;

//Each of cineplex will have a list of cinema

public class Cineplex implements Serializable{
	
	private String nameCineplex="";
	private int sizeCinema = 0;
	private ArrayList<Cinema> listCinema = new ArrayList<Cinema>();
	public ArrayList<DateMovie> holidayList = new ArrayList<DateMovie>();
	private ArrayList<Movie> listMovie = new ArrayList<Movie>();

	//constructor
	
	public Cineplex(){
		
	}
	
	public Cineplex(String nameCineplex){
		this.nameCineplex = nameCineplex;
	}
	
	//end of constructor
	
	
	//add and remove  movie 
	public void AddMovie(Movie movie){
		listMovie.add(movie);
	}
	
	public ArrayList<Movie> getListMovie(){
		return listMovie;
	}
	
	public Movie getMovie(int index){
		return listMovie.get(index);
	}
	
	public void RemoveMovie(Movie movie){
		listMovie.remove(movie);
	}
	//end of add and remove movie
	
	
	
	public String getCineplexName(){
		return nameCineplex;
	}
	
	public ArrayList<Cinema> getListCinema(){
		return listCinema;
	}
	
	
	public void addCinema(Cinema cinema){
		listCinema.add(cinema);
	}
	
	public Cinema getCinema(int index){
		return listCinema.get(index);
	}
	
	public void RemoveCinema(Cinema cinema){
		for(int i = 0 ; i < listCinema.size() ; i++){
			if(listCinema.get(i).equals(cinema)) {
				listCinema.remove(i);
				break;
			}
		}
	}
	
	
	
}
