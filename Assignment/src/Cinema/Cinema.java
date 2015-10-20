package Cinema;

import java.io.Serializable;
import java.util.ArrayList;

import Movie.Movie;

public class Cinema implements Serializable{
	
	private String nameCinema = "";
	private ArrayList<Movie> listMovie = new ArrayList<Movie>();
	
	public Cinema(String nameCinema){
		this.nameCinema = nameCinema;
	}
	
	public void AddListOfMovie(Movie movie){
		if(movie == null){
			System.out.println("Sorry your movie is null");
			return ;
		}
		listMovie.add(movie);
	}
	
	public void RemoveListOfMovie(Movie movie){
		for(int i = 0 ; i < listMovie.size() ; i++){
			if(listMovie.get(i).equals(movie)){
				listMovie.remove(i);
				break;
			}
		}
	}
	
	public ArrayList<Movie> getArrayMovie(){
		return listMovie;
	}
	
	public Movie getMovieWithIndex(int index){
		return listMovie.get(index);
	}
	
	public String getNameCinema(){
		return this.nameCinema;
	}
	
	
}
