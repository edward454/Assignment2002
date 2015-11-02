package Movie;

public class RatedMovie extends Movie{
	
	private String movieTitle;	
	private double rating;
	
	public RatedMovie(){	
		
		super();
		this.movieTitle = super.getTitle();
		
	}
	
	public void setRating(double rating){
		
		this.rating = rating;
		
	}
	
	public double getRating(){
		
		return rating;
		
	}
	
	public String getTitle(){
		
		return movieTitle;
		
	}
	
}
