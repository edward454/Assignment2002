package User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Cinema;
import Cineplex.Cineplex;
import Cineplex.CineplexDatabase;
import Movie.DateMovie;
import Movie.Movie;

public class UserApplication implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static final int MAIN_MENU = 0;
	private static final int CINEPLEX_INTERFACE = 1;
	private static final int MOVIE_INTERFACE = 2;
	private static final int BOOKING_MAIN_INTERFACE = 3;
	private static final int RATING_INTERFACE = 4;
	private static final int SELECT_TIMING_INTERFACE = 5;
	
	private static CineplexDatabase userDatabase =  new CineplexDatabase();	
	private static ArrayList <Cineplex> cineplexList = userDatabase.readFromDatabase("CineplexDatabase.dat");
	private static Scanner sc = new Scanner(System.in);		
	private static ArrayList <Movie> movieList = new ArrayList<Movie>();
	private static Customer customer;
	private static ArrayList<DateMovie> movieScheduleList = new ArrayList<DateMovie>();
	
	public static void main(String[] args) {			
		
		boolean carryOn = true;
		
		while(carryOn){
			
			int option = requestInput(MAIN_MENU);
			
			System.out.flush();
			
			switch(option){
				
				case 1:
					
					listMovies(false, 0);					
					break;
					
				case 2:
					
					listMovies(true, 0);
					break;
				
				case 3:
					ArrayList<String> searchResult = new ArrayList<String>();
					
					String searchMovie = "";
					
					System.out.println("Enter movie title: ");
					
					sc.nextLine();
					searchMovie = sc.nextLine();
					System.out.flush();
					for (int i = 0; i < cineplexList.size(); i++){
						
						searchResult = searchCineplex(searchMovie, cineplexList.get(i));
						if (searchResult.size() == 0){
							
							System.out.println(cineplexList.get(i).getCineplexName() + ":  No movie to show. \n");
							
						}
						else{
							
							for(int j = 0; j < searchResult.size(); j++){
								
								System.out.println(searchResult.get(j));
								
							}
							
						}
						System.out.println("");
						
					}
					
					break;
					
				case 4:	
					int cineplexChoice = 0;
					//requestInput(BOOKING_MAIN_INTERFACE);
					//if (customer.confirmCustomerInfo())
						cineplexChoice = requestInput(CINEPLEX_INTERFACE);
						
					movieList = cineplexList.get(cineplexChoice - 1).getMovieList();
					
					int movieChoice = requestInput(MOVIE_INTERFACE);
					
					movieScheduleList = movieList.get(movieChoice - 1).getArrayListOfDateMovie();
					
					int timingChoice = requestInput(SELECT_TIMING_INTERFACE);			
					
					
					
							
					break;
					
				case 5:
					
					
					
				case 6:
					System.exit(0);
					

			}
			
		}		
		
	}	
	private static int requestInput(int userInterface){
		
		switch(userInterface){
		
			case MAIN_MENU: 
				System.out.println("Choose one option:\n"
						+ "1) List the movies available\n"
						+ "2) List the movies with details\n"
						+ "3) Search for movies\n"
						+ "4) Book ticket\n"
						+ "5) Rate a movie\n"
						+ "6) Exit\n");
										
				if (sc.hasNextInt()){
					
					int choice = sc.nextInt();
					
					while (choice >= 7){
						
						System.out.println("Invalid Option, choose again: ");
						choice = sc.nextInt();
					}
					
					return choice;
					
				}

			case CINEPLEX_INTERFACE:
				System.out.println("Choose cineplex:");
				
				for (int i = 0; i < cineplexList.size(); i++)
				{
					
					System.out.printf("%d) ", i + 1);
					System.out.println(cineplexList.get(i).getCineplexName());
					
				}
				
				if (sc.hasNextInt()){
					
					int choice = sc.nextInt();
					
					while (choice >= cineplexList.size() + 1){
						
						System.out.println("Invalid Option, choose again: ");
						choice = sc.nextInt();
					}
					
					return choice;
					
				}
				
			case MOVIE_INTERFACE:
				System.out.println("Choose movie:");
				
				for (int i = 0; i < movieList.size(); i++){
				
					System.out.printf("%d) ", i + 1);
					System.out.println(movieList.get(i).getTitle());
				
				}
				if (sc.hasNextInt()){
					
					int choice = sc.nextInt();
					while (choice >= movieList.size() + 1){
						
						System.out.println("Invalid Option, choose again: ");
						choice = sc.nextInt();
					}
					return choice;
					
				}
				
			case BOOKING_MAIN_INTERFACE:
				String customerEmailAdd;
				int customerPhoneNumber;
				System.out.println("Please enter your name: ");
				String customerName = sc.next();				
				System.out.println("Please enter your phone number: ");
				do {
					
					customerPhoneNumber = sc.nextInt();
					
					if(customerPhoneNumber / 10000000 == 8 
							|| customerPhoneNumber / 10000000 == 9)
						break;
					
					else System.out.println("Invalid phone number, enter again: ");;
					
				} while (true);
				System.out.println("Please enter your e-mail address: ");
				do{					
					
					customerEmailAdd = sc.next();
					
					if(validateEmailAdd(customerEmailAdd) == false)						
						System.out.println("Invalid email address, enter again: ");						
					
					else break;
					
				}while (true);
				customer = new Customer(customerName, customerPhoneNumber, customerEmailAdd);
				return 0;
				
			case RATING_INTERFACE:
				System.out.println("Select movie from list below to rate: ");
				listMovies(false, 0);
				System.out.print("Your selection: ");
				
				
				return 0;
				
			case SELECT_TIMING_INTERFACE:
				System.out.println("Choose timing:");
				
				for (int i = 0; i < movieScheduleList.size(); i++){
				
					System.out.printf("%d) ", i + 1);
					System.out.println(movieScheduleList.get(i).getTime());
				
				}
				if (sc.hasNextInt()){
					
					int choice = sc.nextInt();
					while (choice >= movieScheduleList.size() + 1){
						
						System.out.println("Invalid Option, choose again: ");
						choice = sc.nextInt();
					}
					return choice;
					
				}
				
			default: return 0;
				
		}
		
	}
	
	private static void listMovies(boolean withDetails, int cineplex){
		
		if (cineplex == 0) {
			
			for (int i = 0; i < cineplexList.size(); i++) {
				
				System.out.println(cineplexList.get(i).getCineplexName() + ":");

				cineplexList.get(i).listMovie(withDetails);

				System.out.println();

			} 
			
		} else {
				
			cineplexList.get(cineplex - 1).listMovie(withDetails);
			
			System.out.println();
			
		}
		
	}
	
	private static ArrayList<String> searchCineplex(String title, Cineplex cineplex){
		
		ArrayList<String> result = new ArrayList<String>();
		
		movieList = cineplex.getMovieList();
		
		for(int i = 0; i < movieList.size(); i++){
			Movie curMovie = new Movie();
			curMovie = movieList.get(i);
			if((curMovie.getTitle().toLowerCase()).equals(title.toLowerCase())){
				
				result.add(cineplex.getCineplexName() + ":  " 
						+ "\n" + curMovie.getTitle() 
						+ "\nPrice: " + Double.toString(curMovie.getPrice())
						+ "\nDuration: " + curMovie.getDuration());
				
			}
			
		}
		
		return result;
		
	}
	
	private static boolean validateEmailAdd(String email){
		
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
		
	}
	
}
