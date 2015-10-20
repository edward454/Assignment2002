package Staff;


import java.io.Serializable;

public class Staff implements Serializable{
	
	private String username = "Staff";
	private String password = "1234";
	
	public Staff(){
		
	}
	
	public Staff(String username, String password){
		this.username = username;
		this.password = password;
		
	}
	
	public String getUsername(){
		return username;
	}
	
	public void SetUsername(String newUsername){
		this.username = newUsername;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String newPassword){
		this.password = newPassword;
	}
	
	public boolean EqualsStaff(Object o){
		if(o instanceof Staff){
			Staff newStaff = (Staff) o;
			return (newStaff.getUsername().equals(this.username)) && (newStaff.getPassword().equals(this.password));
		}
		return false;
	}
	
}
