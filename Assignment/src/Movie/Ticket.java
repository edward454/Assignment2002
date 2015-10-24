package Movie;
import java.util.Date;

public class Ticket{
	private double price;
	private String seatno;
	private DateMovie datemovie;
	private String movieName;
	
	public Ticket(String movieName, String seatno , DateMovie datemovie,double price){
		this.movieName = movieName;
		this.seatno = seatno;
		this.datemovie = datemovie;
		this.price = price;
	}
	
	
	//ticket price will be dynamically change based on the movie that was shown 
	public void setPrice(double price){
		this.price = price;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setSeatNo(String seatno){
		this.seatno = seatno;
	}
	
	public String getSeatNo(){
		return seatno;
	}
	
	public void setDateMovie(DateMovie date){
		
	}
	
	public DateMovie getDateMovie(){
		return this.datemovie; 
	}
	
	public void setMovieTitle(String titleMovie){
		this.movieName = titleMovie;
	}
	
	public String getTitleMovie(){
		return movieName;
	}

	
}