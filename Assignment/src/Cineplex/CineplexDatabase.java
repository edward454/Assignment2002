package Cineplex;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import Cinema.Cinema;
import Interface.Database;
import Movie.DateMovie;
import Movie.Movie;

//Basically this class will make the database for Cineplex Class and read it 
//configure the initial database value from the Main method

public class CineplexDatabase implements Database{

	private static Cineplex cathay;
	private static Cineplex filmgarde;
	private static Cineplex ShawTheatres;
	
	public static void main(String args[]){
		StartCineplex();
	}
	
	private static void StartCineplex(){
		//Change code in here to configure the database 
		//automatically configure 3 Cineplex
		ArrayList<Cineplex> listCineplex = new ArrayList<Cineplex>();
		cathay = new Cineplex("Cathay Cineplex");
		filmgarde = new Cineplex("Filmgarde");
		ShawTheatres = new Cineplex("Shaw Theatres");
		
		
		/*first cineplex*/
		////////////////////////////////////////////////////////////////////////////////////////////
		listCineplex.add(cathay);
		//add three cinema to the cathay cineplex
		
		Cinema CathayFirst = new Cinema("AMK Hub");
		Cinema CathaySecond = new Cinema("JEM");
		//Cinema CathayThird = new Cinema("West Mall");
		listCineplex.get(0).addCinema(CathayFirst);
		listCineplex.get(0).addCinema(CathaySecond);
		//listCineplex.get(0).addCinema(CathayThird);
		//add first movie to the cathay cineplex
		
		DateMovie everestDate1 = new DateMovie("Not Shown",2015, 10, 12, 13, 30);
		DateMovie everestDate2 = new DateMovie("Not Shown",2015, 10, 12, 15, 30);
		DateMovie everestDate3 = new DateMovie("Not Shown",2015, 10, 14, 12, 11);
		
		Movie Everest = new Movie("Everest","122 mins","PG13","Action",everestDate1);
		Everest.setTimeStatus(everestDate2);
		Everest.setTimeStatus(everestDate3);
		
		//add second movie to the cathay cineplex 
		listCineplex.get(0).getCinema(0).AddListOfMovie(Everest);
		
		DateMovie PayTheGhostDate1 = new DateMovie("Not Shown",2015, 10, 12, 13, 35);
		DateMovie PayTheGhostDate2 = new DateMovie("Not Shown",2015, 10, 12, 15, 20);
		DateMovie PayTheGhostDate3 = new DateMovie("Not Shown",2015, 10, 12, 17, 40);
		
		Movie PayTheGhost = new Movie("Pay the Ghost","94 mins","PG13s","Action",PayTheGhostDate1);
		Everest.setTimeStatus(PayTheGhostDate2);
		Everest.setTimeStatus(PayTheGhostDate3);
		
		listCineplex.get(0).getCinema(0).AddListOfMovie(PayTheGhost);
		//add first movie to the AMK Hub

		DateMovie everestDate11 = new DateMovie("Not Shown",2015, 10, 10, 12, 30);
		DateMovie everestDate21 = new DateMovie("Not Shown",2015, 10, 12, 13, 30);
		DateMovie everestDate31 = new DateMovie("Not Shown",2015, 10, 14, 15, 30);
		
		Movie Everest1 = new Movie("Everest","122 mins","PG13","Action",everestDate11);
		Everest.setTimeStatus(everestDate21);
		Everest.setTimeStatus(everestDate31);
		
		//add second movie to the AMK Hub
		listCineplex.get(0).getCinema(1).AddListOfMovie(Everest1);
		
		DateMovie PayTheGhostDate11 = new DateMovie("Not Shown",2015, 10, 12, 10, 35);
		DateMovie PayTheGhostDate21 = new DateMovie("Not Shown",2015, 10, 12, 13, 20);
		DateMovie PayTheGhostDate31 = new DateMovie("Not Shown",2015, 10, 12, 11, 40);
		
		Movie PayTheGhost1 = new Movie("Pay the Ghost","94 mins","PG13","Action",PayTheGhostDate11);
		Everest.setTimeStatus(PayTheGhostDate21);
		Everest.setTimeStatus(PayTheGhostDate31);

		listCineplex.get(0).getCinema(1).AddListOfMovie(PayTheGhost1);
		
		/*second cineplex*/
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		listCineplex.add(filmgarde);
		//Add Cinema can through system later
		
		Cinema filmGardeFirst = new Cinema("Leisure park kallang");
		Cinema filmGardeSecond = new Cinema("Bugis");
		
		listCineplex.get(1).addCinema(filmGardeFirst);
		listCineplex.get(1).addCinema(filmGardeSecond);
		
		/*third cineplex*/
		////////////////////////////////////////////////////////////////////////////////////////////////
		
		listCineplex.add(ShawTheatres);
		//add Cinema can through system later
		
		Cinema ShawTheatresFirst = new Cinema("Century");
		Cinema ShawTheatresSecond = new Cinema("JCube");
		
		listCineplex.get(2).addCinema(ShawTheatresFirst);
		listCineplex.get(2).addCinema(ShawTheatresSecond);
		
		
		
		
		//insert all the information inside the Cineplex Data
		
		
		CineplexDatabase cDatabase =  new CineplexDatabase();
		System.out.println("size: "+listCineplex.size());
		cDatabase.WriteToDatabase("CineplexDatabase.dat", listCineplex);
		
		ArrayList<Cineplex> listCineolex = cDatabase.ReadFromDatabase("CineplexDatabase.dat");
	
	}
	
	@Override
	public void WriteToDatabase(String filename, ArrayList list) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try{
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			ObjectOutputStream os = new ObjectOutputStream(bos);
			os.writeObject(list);
			os.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public ArrayList<Cineplex> ReadFromDatabase(String filename) {
		ArrayList returnedList = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try{
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			returnedList = (ArrayList)ois.readObject();
			ois.close();
		}catch(IOException e){
			
		} catch (ClassNotFoundException e) {
			
		}
		return returnedList;
	}
	

	
	/*
	 * No need to see this
	 * 
	 * 
	 public void ConfigureCineplexForStaff(){
		Scanner scan = new Scanner(System.in);
		int choiceCineplex =  0;
		//we are using 3 cineplex from Singapore 
		//Cathay Cineplex
		//Filmgarde
		//Century Cineplex
		
		System.out.println("\n Please Choose the cineplex to configure:");
		System.out.println("1)Cathay Cineplex");
		System.out.println("2)Filmgarde");
		System.out.println("3)Century Cineplex");
		choiceCineplex = scan.nextInt();
		switch(choiceCineplex){
		case 1:
			System.out.println("Start Configuring Cathay Cineplex");
			if(cathay != null) currentCineplex = cathay;
			break;
		case 2:
			System.out.println("Start Configuring Filmgarde");
			if(filmgarde != null) currentCineplex = filmgarde;
			break;
		case 3:
			System.out.println("Start Configuring Century Cineplex");
			if(century != null) currentCineplex = century;
			
			break;
		default:try{
			throw new ChoiceException("Please choose another cineplex");
		}catch(ChoiceException e){
		
		}
		}
	}
	public void ConfiguringCinema(){
		System.out.println("Configuring cinema from "+this.nameCineplex);
		for(int i = 1; i <= currentCineplex.listCinema.size() ; i++){
			System.out.printf("%d) %s \n",i,listCinema.get(i-1).nameCinema);
		}
		System.out.println("please choose one Cinema to configure\n");
		Scanner scan = new Scanner(System.in);
		int indexCinema = scan.nextInt();
		ConfiguringMovie(indexCinema-1);
		
	}
	
	private void ConfiguringMovie(int pos){
		currentCinema = listCinema.get(pos);
		System.out.println("Configuring movie from "+currentCinema.nameCinema);
		for(int i = 0 ; i < currentCinema.getArrayMovie().size() ; i++){
			System.out.printf("%d) %s",i+1,currentCinema.getArrayMovie().get(i).nameMovie);
		}
		System.out.println("Please choose one Movie to configure");
		Scanner scan = new Scanner(System.in);
		int choiceMovie = scan.nextInt();
		currentMovie = currentCinema.getArrayMovie().get(choiceMovie);
	}
	*/


}
