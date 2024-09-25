package main;

public class HistoryList {

	String ID;
    String email;
    String date;
    
    
    
	public HistoryList(String iD, String email, String date) {
		super();
		ID = iD;
		this.email = email;
		this.date = date;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    
    
	
}
