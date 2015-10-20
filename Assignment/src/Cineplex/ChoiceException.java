package Cineplex;

public class ChoiceException extends Exception{
	
	public ChoiceException(){
		super("Please choose another choices");
	}
	
	public ChoiceException(String message){
		super(message);
	}
	
}
