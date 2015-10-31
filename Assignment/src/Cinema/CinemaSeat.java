package Cinema;

import java.io.Serializable;

public class CinemaSeat implements Serializable {

	private int row, column;
	private boolean occupied;	
	private int customerId;		
	
	public CinemaSeat(int row, int column){
		
		this.row = row;
		this.column = column;
		
	}
	
	public CinemaSeat(int row, int column, boolean occupied){
		
		this.row = row;
		this.column = column;
		this.occupied = occupied;
		
	}
	
	
	public boolean isOccupied(){
		
		return occupied;
		
	}	
	
	public String getSeatId(){
		
		return this.getRow() + Integer.toString(column);
		
	}
	
	public char getRow(){
		
		switch (row){
		
			case 1: 
				return 'A';
			case 2: 
				return 'B';
			case 3: 
				return 'C';
			case 4: 
				return 'D';
			case 5: 
				return 'E';
			case 6: 
				return 'F';
			case 7: 
				return 'G';
			case 8: 
				return 'H';
			case 9: 
				return 'I';
			case 10: 
				return 'J';
			default:
				return ' ';
		
		}		
		
	}
	
	public int getColumn(){
		
		return column;
		
	}
	
	public void freeSeat(){
		
		occupied = false;
		
	}
	
	public void setOccupied (boolean occupied){
		
		this.occupied = occupied;
		
	}
	
}
