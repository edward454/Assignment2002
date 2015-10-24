package Cinema;

import java.io.Serializable;
import java.util.ArrayList;

import Movie.Movie;
import Movie.Ticket;

public class Cinema implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	private String cinemaName = "";
	private String type = ""; 
	private ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	private CinemaSeat[][] seat = new CinemaSeat[10][10];
	private int emptySeatLeft;
	private String teaterType;
	
	public static void main(String[] args) {
		Cinema cinema = new Cinema("");
		//debug to get the class type		
		//Cinema cin = new Cinema("anything");		
		//System.out.println(cin.getSeatArrangement());
		
	}
	
	public Cinema(String cinemaName , String teaterType){
		this.cinemaName = cinemaName;
		this.teaterType = teaterType;
		
	}

	
	public Cinema(String cinemaName){
		this.cinemaName = cinemaName;
		emptySeatLeft = 100;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				
				seat[i][j] = new CinemaSeat(i + 1, j + 1, false);
				
			}		
			
		}			
				
	}
	
	//getter and setter for cinemaName
	
	public void setCinemaName(String cinemaName){
		this.cinemaName = cinemaName;
	}
	
	public String getCinemaName(){
		
		return this.cinemaName;
		
	}
		
	
	public String getSeatArrangement(){
		
		String result = "";
		int row = 0;
		int column = 0;
		
		result += "\t\t    ____________________________ \n"
				+ "\t\t   |           Screen           |\n"
				+ "\t\t   |____________________________|\n";
		
		result += "\n    ___________________________________________________________\n";
				
		for (row = 0; row < 10; row++){			
			result += seat[row][column].getRow();
			
			for (int j = 0; j < 10; j++){
				
				if (seat[row][j].isOccupied())
					result += "  |  X";					
				else 
					result += "  |   ";
				
				
			}
			result += "  |";
			result += "\n   |_____|_____|_____|_____|_____|_____|_____|_____|_____|_____|\n";
			
		}
		
		result += "\n "
				+ "     1"
				+ "     2"
				+ "     3"
				+ "     4"
				+ "     5"
				+ "     6"
				+ "     7"
				+ "     8"
				+ "     9"
				+ "     10";
		
		return result;
		
	}
	
	
		
}