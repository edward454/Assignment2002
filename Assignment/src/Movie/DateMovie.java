package Movie;

import java.io.Serializable;

public class DateMovie implements Serializable{
	private String statusMovie;
	private int year,month,day,hour,minute;
	
	public DateMovie(int year,int month,int day,int hour , int minute){
		this.year = year;
		this.month= month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}
	
	public DateMovie(String statusMovie,int year,int month,int day,int hour , int minute){
		this.statusMovie = statusMovie;
		this.year = year;
		this.month= month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}
	
	public String getTime(){	
		String time = year+"/"+month+"/"+day+" "+hour+":"+minute;
		return time;
	}
	
	public String getStatus(){
		return statusMovie;
	}
	
	public String getStatusTimeMovie(){
		String timeStatus = year+"/"+month+"/"+day+" "+hour+":"+minute+"  "+statusMovie;
		return timeStatus;
	}
	
	public void setStatus(String newStatus){
		this.statusMovie = newStatus;
	}
	
	
	//set all the date attribute
	
	public void setYear(int year){
		this.year = year;
	}
	
	public void setMonth(int month){
		this.month = month;
	}
	
	public void setDay(int day){
		this.day = day;
	}

	
}
