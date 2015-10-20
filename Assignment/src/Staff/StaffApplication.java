package Staff;

import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Cinema;
import Cineplex.Cineplex;
import Cineplex.CineplexDatabase;
import Movie.DateMovie;
import Movie.Movie;

//Basically this class will enable staff to configure database of Cineplex and database of User
//updatedd 
//already can save the data in database 
//need to fix bugs
//when inserted number that was not in the option 
//need to add see list of movie function

public class StaffApplication {
	
	private static Cineplex currentCineplex = null;
	private static Cinema currentCinema = null;
	private static Movie currentMovie = null;
	private static ArrayList<Cineplex> cineplexList;
	private static CineplexDatabase cDatabase;
	
	public static void main(String args[]){
		//declare all the object 
		Scanner scan = new Scanner(System.in);
		String username=null,password= null;
		Staff inputStaff= null;
		ArrayList getList = null;	
		boolean staffStatus = false;
		int choiceFunction = 0;
		DatabaseStaff dbStaff = new DatabaseStaff();
		
		//scan the staff username and password
		System.out.println("Username: ");
		username = scan.nextLine();
		System.out.println("Password: ");
		password = scan.nextLine();
		inputStaff = new Staff(username,password);
		//processing database
		System.out.println("Check Database");
		System.out.println("process.....\n");
		getList =  dbStaff.ReadFromDatabase("staff.dat");
		for(int i = 0 ; i < getList.size() ; i++){
			Staff printStaff = (Staff)getList.get(i);
			if(printStaff.EqualsStaff(inputStaff)){
				staffStatus = true;
				break;
			}
		}
		
		if(staffStatus){
			System.out.println("welcome Staff\n");
			ViewCinemaFromDatabase();
		}else{
			System.out.println("Sorry your username and password is not match with our database");
		}
	}
	
	private static void ViewCinemaFromDatabase(){
		cDatabase = new CineplexDatabase();
		cineplexList = new ArrayList<Cineplex>();
		cineplexList = cDatabase.ReadFromDatabase("CineplexDatabase.dat");
		for(int i = 0 ;i < cineplexList.size() ; i++){
			System.out.println("List of Cineplex");
			System.out.printf("%d) %s",i+1,cineplexList.get(i).getCineplexName());
		}
		System.out.println("\n\nPlease choose one Cineplex to configure or type -1 to quit");
		Scanner scan = new Scanner(System.in);
		int choices = scan.nextInt();
		if(choices == -1){
			System.out.println("Quit from the configuring process");
			return ;
		}
		currentCineplex = cineplexList.get(choices-1);
		Configuring();
	}
	
	private static void Configuring(){
		//get the list of Cinema from the cineplex
		System.out.println("List Cinema of "+currentCineplex.getCineplexName()+"............");
		for(int i = 0 ; i < currentCineplex.getListCinema().size() ; i++){
			System.out.printf("%d) %s\n",i+1,currentCineplex.getListCinema().get(i).getNameCinema());
		}
		System.out.println("\nPlease choose one cinema to configure\n");
		Scanner scan = new Scanner(System.in);
		currentCinema = currentCineplex.getListCinema().get(scan.nextInt()-1);
		
		//get the movie to configure
		//give option to add movie or update the movie
		while(true){
			System.out.println("Choose the option here: ");
			System.out.println("1) Add Movie");
			System.out.println("2) Update the movie List");
			System.out.println("3) See the movie list of "+currentCinema.getNameCinema());
			System.out.println("4) Quit and choose another cinema or cineplex to configure");
			int OptionMovie = scan.nextInt();
		if(OptionMovie == 1){
			//get the description of the movie from user
			String title,duration,genre,status,ratingPG;
			DateMovie dateMovie;
			
			int year,month,day,hour,minute;
			scan.nextLine();
			System.out.println("insert the title of new movie");
			title = scan.nextLine();
			System.out.println("insert the duration of new movie");
			duration = scan.nextLine();
			System.out.println("insert the genre of the new movie");
			genre = scan.nextLine();
			System.out.println("insert the RatingPG");
			ratingPG = scan.nextLine();
			System.out.println("insert the date with format");
			System.out.println("YY MM DD HH mm");
			year = scan.nextInt();
			month = scan.nextInt();
			day = scan.nextInt();
			hour = scan.nextInt();
			minute = scan.nextInt();
			scan.nextLine();
			System.out.println("insert the status of the movie on that time");
			status = scan.nextLine();
			dateMovie = new DateMovie(status,year, month, day, hour, minute);
			Movie movie = new Movie(title, duration, ratingPG, genre, dateMovie);
			currentCinema.AddListOfMovie(movie);
			System.out.println("Changes has been saved to our system\n");
		}else if(OptionMovie == 2){
		
			System.out.println("List of Movie from \n"+currentCinema.getNameCinema());
			for(int i = 0 ; i < currentCinema.getArrayMovie().size() ; i++){
				System.out.printf("%d) %s\n",i+1,currentCinema.getArrayMovie().get(i).printDescription());
			}
			if(currentCinema.getArrayMovie().size() != 0 ){
				System.out.println("\nplease choose one movie to configure");
				Movie chooseMovie = currentCinema.getMovieWithIndex(scan.nextInt()-1);
				//later need to add the Date attribute so it will detect current time and the time when you put the object
				System.out.println("What description you want to configure");
				System.out.println("1) title");
				System.out.println("2) duration");
				System.out.println("3) ratingPG");
				System.out.println("4) Genre");
				System.out.println("5) date and status");
				
				int MovieConfigurationDescription = scan.nextInt();
				System.out.flush();
				switch(MovieConfigurationDescription){
					case 1:
						System.out.println("insert the new title");
						String newTitle = scan.nextLine();
						chooseMovie.SetTitle(newTitle);
						break;
					case 2:
						System.out.flush();
						System.out.println("insert the new duration");
						String newDuration = scan.nextLine();
						chooseMovie.setDuration(newDuration);
						break;
					case 3:
						System.out.flush();
						System.out.println("Set the new RatingPG");
						String newRatingPG = scan.nextLine();
						chooseMovie.setRatingPG(newRatingPG);
						break;
					case 4:
						System.out.flush();
						System.out.println("Set the new Genre of the movie");
						String newGenre = scan.nextLine();
						chooseMovie.setGenre(newGenre);
						break;
					case 5:
						//getting the list of date on the currentMovie
						System.out.flush();
						System.out.println("Please choose one option");
						System.out.println("1) Add another date");
						System.out.println("2) editing the existing date");
						int addDate = scan.nextInt();
						if(addDate == 1){
							System.out.println("insert the new date with format");
							System.out.println("YY MM DD HH mm");
							int year = scan.nextInt();
							int month = scan.nextInt();
							int day = scan.nextInt();
							int hour = scan.nextInt();
							int minute = scan.nextInt();
							DateMovie datemovie = new DateMovie(year, month, day, hour, minute);
							System.out.println("Please add status to this new Date"+datemovie.getTime());
							String newStatus = scan.nextLine();
							datemovie.setStatus(newStatus);
							System.out.println("\nYour change has been saved to our system\n");
						}else if(addDate == 2){
							System.out.println("Schedule "+chooseMovie.getTitle()+" :");
							chooseMovie.getListDateStatusMovie();
							System.out.println("\n");
							ArrayList<DateMovie> listMovie = chooseMovie.getArrayListOfDateMovie();
							System.out.println("Please choose which date you want to configure");
							int indexListMovie = scan.nextInt();
							DateMovie currentDate = listMovie.get(indexListMovie-1);
							System.out.println("\nPlease choose which one you want to configure");
							System.out.println("1) Time");
							System.out.println("2) status");
							int timestatus = scan.nextInt();
							if(timestatus == 1){
								System.out.println("Please choose which part of date you want to edit");
								System.out.println("1) Year");
								System.out.println("2) Month");
								System.out.println("3) Day");
								System.out.println("4) Hour");
								System.out.println("5) Minute");
								System.out.println("6) Status");
								int DateEditPart = scan.nextInt();
								switch(DateEditPart){
								case 1:
									
									break;
								case 2:
									break;
								case 3:
									break;
								case 4:
									break;
								case 5:
									break;
								case 6:
									break;
								}
								
							}else if(timestatus == 2){
								System.out.println("insert the new Status");
								scan.nextLine();
								String newStatus = scan.nextLine();
								currentDate.setStatus(newStatus);
							}else{
								System.out.println("Sorry your choice is ont in the system");
								return ;
							}
						}
						
					}
					System.out.println("Changes has been saved to our system\n");
				}else{
					System.out.println("\nDont have any movie on the list, please add at least one of the movie to the cinema");
				}
		}else if(OptionMovie == 3){
			//see the movie List
			if(currentCinema.getArrayMovie().size() != 0 ){
				for(int i = 0; i < currentCinema.getArrayMovie().size() ; i++){
					System.out.println(currentCinema.getArrayMovie().get(i).printDescription());
				}
			}else{
				System.out.println("There has no movie in the "+currentCinema.getNameCinema());
			}
			System.out.println("\n");
		}
		else{
			System.out.println("\n1) quit");
			System.out.println("2) configure another cineplex");
			System.out.println("3) configure another cinema in "+currentCineplex.getCineplexName());
			System.out.println("Please choose the above options");
			int Quit  = scan.nextInt();
			if(Quit == 1){
				return;
			}else if(Quit ==2){
				ViewCinemaFromDatabase();
			}else if(Quit == 3){
				Configuring();
			}else{
				System.out.println("Sorry your choices is not listed in our system");
				System.out.println("Quit process\n");
				return ;
			}
		}
		cDatabase.WriteToDatabase("CineplexDatabase.dat",cineplexList);
		
		}
	
	}
	
	
}
