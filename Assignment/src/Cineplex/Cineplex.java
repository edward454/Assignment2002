package Cineplex;

import java.io.Serializable;
import java.util.ArrayList;

import Cinema.Cinema;

//Each of cineplex will have a list of cinema

public class Cineplex implements Serializable{
	
	private String nameCineplex="";
	private int sizeCinema = 0;
	private ArrayList<Cinema> listCinema = new ArrayList<Cinema>();
	
	public Cineplex(String nameCineplex){
		this.nameCineplex = nameCineplex;
	}
	
	public Cineplex(){
		
	}
	
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
