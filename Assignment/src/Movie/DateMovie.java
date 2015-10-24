package Movie;

import java.io.Serializable;

import Cinema.Cinema;

public class DateMovie implements Serializable,Comparable<DateMovie>{
	private String statusMovie="";
	private int year=0,month=0,day=0,hour=0,minute=0;
	private Cinema cinema; 
	
	//all constructor
	public DateMovie(Cinema cinema,String statusMovie , int year , int month , int day , int hour , int minute){
		this.cinema = cinema;
		this.year = year;
		this.month = month;
		this.day = day ;
		this.hour = hour;
		this.minute = minute;
		this.statusMovie = statusMovie;
	}
	
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
	
	public DateMovie(int year,int month , int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	//end of constructor
	
	public String getTime(){	
		String time = year+"/"+month+"/"+day+" "+hour+":"+minute;
		return time;
	}
	
	public String getYearMonthDay(){
		String time = year+"/"+month+"/"+day;
		return time;
	}
	
	public String getStatus(){
		return statusMovie;
	}
	
	public String getStatusTimeMovie(){
		String timeStatus = year+"/"+month+"/"+day+" "+hour+":"+minute+"  "+statusMovie;
		return timeStatus;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public int getMonth(){
		return this.month;
	}
	
	public int getDay(){
		return this.day;
	}
	
	public int getHour(){
		return this.hour;
	}
	
	public int getMinute(){
		return this.minute;
	}
	
	public Cinema getCinema(){
		return cinema;
	}

	
	//set all the date attribute
	
	public void setStatus(String newStatus){
		this.statusMovie = newStatus;
	}

	
	public void setYear(int year){
		this.year = year;
	}
	
	public void setMonth(int month){
		this.month = month;
	}
	
	public void setDay(int day){
		this.day = day;
	}

	public void setHour(int hour){
		this.hour = hour;
	}
	
	public void setMinute(int miinute){
		this.minute = minute;
	}
	
	public void setCinema(Cinema cinema){
		this.cinema = cinema;
	}

	@Override
	public int compareTo(DateMovie o) {
		if(this.year > o.year ){
			return 1;
		}else if(this.year == o.year){
			if(this.month > o.month){
				return 1;
			}else if(this.month == o.month){
				long current = this.minute + this.hour*100 + this.day*10000;
				long compare = o.minute +o.hour*100 + o.day*10000;
				if(current  > compare ){
					return 1;
				}else if(current == compare) {
					return 0;
				}else{
					return -1;
				}
			}else{
				return -1;
			}
		}else{
			return -1;
		}
	}
	
	
	
}
