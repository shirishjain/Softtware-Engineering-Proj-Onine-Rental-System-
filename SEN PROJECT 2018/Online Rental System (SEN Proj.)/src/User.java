import java.util.*;

public class User {	
	private String name;	
	private int rating;	//On a scale of 1 to 5
	private String userName;	
	private long contact;	//stores mobile number
	private String email;
	private String password;
	private Location l;
	private int id = 0;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}	
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public Location getL() {
		return l;
	}
	public void setL(Location l) {
		this.l = l;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	static boolean login(String userName,String password){
		if(DB.userDB_pw.containsKey(userName)){
			if(DB.userDB_pw.get(userName).equals(password)){
				System.out.println("Login Successful");
				System.out.println("You have logged in as "+DB.user_type.get(userName));
				Main.usr_type =  DB.user_type.get(userName);
				return true;
			}else{
				System.out.println("Login Unsuccessful");
				System.out.println("Check if password is correct");
				return false;
			}
		}else{
			System.out.println("Login Unsuccessful");
			System.out.println("Check if username is correct");
			return false;
		}
	}
	
	static boolean signUp(String na,String ad,String uN,long c,String em,String pw,String type){
		User u = new User();
		if(DB.userDB_pw.containsKey(uN)){
			System.out.println("Given username is already taken. Please select another one");
			return false;
		}
		u.setName(na);
		u.setUserName(uN);
		u.setContact(c);
		u.setRating(0);
		u.setEmail(em);
		u.setPassword(pw);
		Location lu = new Location();
		if(DB.userDB.containsKey(u.userName)){
			User u1 = DB.userDB.get(u.userName);
			ArrayList<String> addr = u1.getL().getAddress();
			addr.add(ad);
			lu.setAddress(addr);
		}else{
			ArrayList<String> addr = new ArrayList<String>();
			addr.add(ad);
			lu.setAddress(addr);
		}
		u.setL(lu);
		System.out.println("Account successfully created as "+type);
		DB.ul_Db.put(u.userName, lu);
		DB.userDB.put(u.userName, u);
		DB.userDB_pw.put(u.userName, pw);
		DB.user_type.put(u.userName, type);
		return true;		
	}
	
	
	
}
