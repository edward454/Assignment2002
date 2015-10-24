package User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Cinema;
import Cineplex.Cineplex;
import Cineplex.CineplexDatabase;



public class UserApplication implements Serializable{
	
	private static final int MAIN_MENU = 0;
	private static final int CINEPLEX_INTERFACE = 1;
	private static final int BOOKING_INTERFACE = 3;
	
	private static CineplexDatabase userDatabase =  new CineplexDatabase();	
	private static ArrayList <Cineplex> listCineplex = userDatabase.ReadFromDatabase("CineplexDatabase.dat");
	private static Scanner sc = new Scanner(System.in);			
	private static ArrayList <Cinema> listCinema = new ArrayList<Cinema>();
	private static Cineplex currentCineplex = new Cineplex();
	private static Customer customer;
	
	public static void main(String[] args) {			
		
		boolean carryOn = true;
		
		while(carryOn){
			
			int option = requestInput(MAIN_MENU);
			
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
					
					sc.nextLine();
					searchMovie = sc.nextLine();
					System.out.flush();
					for (int i = 0; i < listCineplex.size(); i++){
						
						searchResult = searchCineplex(searchMovie, listCineplex.get(i));
						if (searchResult.size() == 0){
							
							System.out.println(listCineplex.get(i).getCineplexName() + ":  No movie to show. \n");
							
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
					int choice = 0;
					requestInput(BOOKING_INTERFACE);
					if (customer.confirmCustomerInfo())
						choice = requestInput(CINEPLEX_INTERFACE);
					
					switch(choice){
						case 1: 
							
					
					}
					
					
				case 6:
					carryOn = false;
					break;

			}
			
		}
		
		System.out.println("Exiting... thank you for visiting.");
		
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
				
			case BOOKING_INTERFACE:
				String customerEmailAdd;
				System.out.println("Please enter your name: ");
				String customerName = sc.next();				
				System.out.println("Please enter your phone number: ");
				int customerPhoneNumber = sc.nextInt();
				System.out.println("Please enter your e-mail address: ");
				do{					
					
					customerEmailAdd = sc.next();
					
					if(validateEmailAdd(customerEmailAdd) == false)						
						System.out.println("Invalid email address, enter again: ");						
					
					else
						break;
					
				}while (true);
				customer = new Customer(customerName, customerPhoneNumber, customerEmailAdd);
				return 0;
					
			default: return 0;
				
		}
		
	}
	
	private static void listMovies(boolean withDetails){
		
		int cineplexChoice = requestInput(CINEPLEX_INTERFACE);	
		
		for(int i = 0; i < listCineplex.size(); i++){
			System.out.println("I am here 1");
//			currentCineplex = listCineplex.get(i);
			System.out.println(listCineplex.get(i).getCineplexName());
			System.out.println("I am here 2");
			listCinema.add(listCineplex.get(i).getCinema(i));
		}
		System.out.println("I am here 3");
//		int cinemaChoice = requestInput(2);							
		int movieArraySize = 0;
		for (int i = 0; i < listCinema.size(); i++){
			movieArraySize += listCinema.get(i).getArrayMovie().size();
		}
		
		System.out.println(movieArraySize);
		try{
			if (movieArraySize != 0){
				
				for(int i = 0; i < listCinema.size(); i++){
					for (int j = 0; j < movieArraySize; j++){
						if (!withDetails){
							System.out.printf("%d) ", i + 1);
							System.out.println(listCinema.get(i).getArrayMovie().get(j).getTitle());
						}
						else{
							System.out.printf("%d) ", i + 1);
							System.out.println(listCinema.get(i).getArrayMovie().get(j).printDescription());
						}
					}
					
				}
				System.out.println("");
				
			}
			else{
				
				System.out.println("No movie is available\n");						
				
			}
		}catch (Exception e){
			
		}
		
	}
	
	private static ArrayList<String> searchCineplex(String title, Cineplex cineplex){
		
		ArrayList<String> result = new ArrayList<String>();
		
		listCinema = cineplex.getListCinema();
		
		for(int i = 0; i < listCinema.size(); i++){
			
			for(int j = 0; j < listCinema.get(i).getArrayMovie().size(); j++){
				
				if((listCinema.get(i).getArrayMovie().get(j).getTitle()).compareTo(title) == 0){
					
					result.add(cineplex.getCineplexName() + ":  " + listCinema.get(i).getNameCinema() + "\t" + title);
					
				}
				
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