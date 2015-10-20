package Interface;

import java.util.ArrayList;


public interface Database {

	public abstract void WriteToDatabase(String filename,ArrayList<Object> list);
	public abstract ArrayList ReadFromDatabase(String filename);
	
}
