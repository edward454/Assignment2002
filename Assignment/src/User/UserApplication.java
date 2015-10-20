package User;

import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Cinema;
import Cineplex.Cineplex;
import Cineplex.CineplexDatabase;

public class UserApplication {
	
	private static CineplexDatabase userDatabase =  new CineplexDatabase();	
	private static ArrayList <Cineplex> listCineplex = userDatabase.ReadFromDatabase("CineplexDatabase.dat");
	private static Scanner sc = new Scanner(System.in);			
	private static ArrayList <Cinema> listCinema = null;
	private static Cineplex currentCineplex = new Cineplex();
	
	public static void main(String[] args) {			
		
		while(true){
			
			int option = requestInputListMovie(0);
			
			System.out.flush();
			
			switch(option){
				
				case 1:
					
					listMovies(false);					
					break;
					
				case 2:
					
					listMovies(true);
					break;
				
				case 3:
					ArrayList<String> searchResult = new ArrayList<String>();
					
					String searchMovie = "";
					
					System.out.println("Enter movie title: ");
					if(sc.hasNext()){
						
						System.out.flush();
						searchMovie = sc.next();
						System.out.flush();
						for (int i = 0; i < listCineplex.size(); i++){
							
							searchResult = searchCineplex(searchMovie, listCineplex.get(i));
							if (searchResult.size() == 0){
								
								System.out.println(listCineplex.get(i).getCineplexName() + ":  No movie to show. \n");
								
							}
							else{
								
								for(int j = 0; j < 200; i++){
									
									if (searchResult.get(j) != null)
										System.out.println(searchResult.get(j));
									else 
										break;
									
								}
								
							}
							
						}
						
					}
					
					break;
		
			}
			
		}
		
		
	}
	
	private static int requestInputListMovie(int type){
		
		switch(type){
		
			case 0: 
				System.out.println("Choose one option:\n"
						+ "1) List the movies available\n"
						+ "2) List the movies with details\n"
						+ "3) Search for movies\n");
				
				if (sc.hasNextInt()){
					
					int choice = sc.nextInt();
					
					while (choice >= 4){
						
						System.out.println("Invalid Option, choose again: ");
						choice = sc.nextInt();
					}
					
					return choice;
					
				}

			case 1:
				System.out.println("Choose cineplex:");
				
				for (int i = 0; i < listCineplex.size(); i++)
				{
					
					System.out.printf("%d) ", i + 1);
					System.out.println(listCineplex.get(i).getCineplexName());
					
				}
				
				if (sc.hasNextInt()){
					
					int choice = sc.nextInt();
					
					while (choice >= listCineplex.size() + 1){
						
						System.out.println("Invalid Option, choose again: ");
						choice = sc.nextInt();
					}
					
					return choice;
					
				}
				
			case 2:
				System.out.println("Choose cinema:");
				
				for (int i = 0; i < listCinema.size(); i++){
				
					System.out.printf("%d) ", i + 1);
					System.out.println(listCinema.get(i).getNameCinema());
				
				}
				if (sc.hasNextInt()){
					
					int choice = sc.nextInt();
					while (choice >= listCinema.size() + 1){
						
						System.out.println("Invalid Option, choose again: ");
						choice = sc.nextInt();
					}
					return choice;
					
				}
			
			default: return 0;
				
		}
		
	}
	
	
	private static void listMovies(boolean withDetails){
		
		int cineplexChoice = requestInputListMovie(1);						
		
		currentCineplex = listCineplex.get(cineplexChoice - 1);
		listCinema = currentCineplex.getListCinema();
	
		int cinemaChoice = requestInputListMovie(2);							
	
		int movieArraySize = listCinema.get(cinemaChoice - 1).getArrayMovie().size();
		if (movieArraySize != 0){
			
			for(int i = 0; i < movieArraySize; i++){
				if (!withDetails)
					System.out.println(listCinema.get(cinemaChoice - 1).getArrayMovie().get(i).getTitle());
				else
					System.out.println(listCinema.get(cinemaChoice - 1).getArrayMovie().get(i).printDescription());
				
			}
			System.out.println("");
			
		}
		else{
			
			System.out.println("No movie is available\n");						
			
		}
		
	}
	
	//this is not working
	private static ArrayList<String> searchCineplex(String title, Cineplex cineplex){
		
		ArrayList<String> result = new ArrayList<String>();
		
		cineplex = new Cineplex();
		
		listCinema = cineplex.getListCinema();
		
		for(int i = 0; i < listCinema.size(); i++){
			
			for(int j = 0; j < listCinema.get(i).getArrayMovie().size(); j++){
				
				if((listCinema.get(i).getArrayMovie().get(j).getTitle()).compareTo(title) == 0){
					
					result.add(cineplex.getCineplexName() + " "+ listCinema.get(i).getNameCinema() + title);
					System.out.println(result.get(0));
					System.out.println(result.size());
					
				}
				
			}
			
		}
		
		System.out.println(result.size());
		
		return result;
		
	}
}
