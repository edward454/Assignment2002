package Movie;
import java.util.Date;

public class Ticket{
	private double price;
	private String seatno;
	private Date time = new Date();
	private Movie mov;
	
	public Ticket(double price){
		this.price = price;
	}
	
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
	
	public void setTime(Date time){
		this.time = time;
	}
	
	public Date getTime(){
		return time;
	}
	
	
}