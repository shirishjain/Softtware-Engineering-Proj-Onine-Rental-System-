import java.util.*;

public class DB {
	static HashMap<String,String> userDB_pw = new HashMap<String,String>(); // maps username to password
	static HashMap<String,User> userDB = new HashMap<String,User>();	//maps username to user
	static HashMap<String,Location> ul_Db = new HashMap<String,Location>(); //user location database
	static HashMap<Integer,Product> pr_DB = new HashMap<Integer,Product>();	//maps productID to product
	static HashMap<String,String> user_type = new HashMap<String,String>();	//maps username to [owner,technician,hirer] type
	static HashMap<Integer,String> prusr_DB = new HashMap<Integer,String>();	//maps productID to it's user
	
	static void storeUser(){
		User u1 = new User();
		u1.setEmail("rohan@gmail.com");
		u1.setContact((int)12345);
		u1.setName("Rohan");
		u1.setUserName("rohan");
		u1.setPassword("password1");
		Location L1 = new Location();
		ArrayList<String> al = new ArrayList<String>();
		al.add("Surat");
		u1.setL(L1);
		userDB.put("rohan", u1);
		userDB_pw.put("rohan", "password1");
		ul_Db.put("rohan", L1);
		user_type.put("rohan", "Owner");
		
		User u2 = new User();
		u2.setEmail("mohan@gmail.com");
		u2.setContact((int)6789);
		u2.setName("Mohan");
		u2.setUserName("mohan");
		u2.setPassword("password2");
		Location L2 = new Location();
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("Baroda");
		u2.setL(L2);
		userDB.put("mohan", u2);
		userDB_pw.put("mohan", "password2");
		ul_Db.put("mohan", L2);
		user_type.put("mohan", "Hirer");
		
		User u3 = new User();
		u3.setEmail("sohan@gmail.com");
		u3.setContact((int)678559);
		u3.setName("Sohan");
		u3.setUserName("sohan");
		u3.setPassword("password3");
		Location L3 = new Location();
		ArrayList<String> al2 = new ArrayList<String>();
		al1.add("Baroda");
		u3.setL(L3);
		userDB.put("sohan", u3);
		userDB_pw.put("sohan", "password3");
		ul_Db.put("sohan", L3);
		user_type.put("sohan", "Technician");
		
		
		
	}
	
	static void storeProduct()
	{
	    Product p1 = new Product();
	    p1.setName("Red Ford Fiesta");
	    p1.setDescription("Sedan, Petrol, 2014 Model,  80,000 kms driven, Good Condition");
	    p1.setPrice(150000);
	    p1.setInsurance("Yes");
	    p1.setTypeOfProduct("Car");
	    p1.setAvailability("Yes");
	    p1.setRating(3);
	    p1.setDurationOfHire(20);
	    p1.setPhoto("MyFiesta.jpej");
	    p1.setProductID(1);
	    DB.pr_DB.put(1, p1);
	    
	    Product p2 = new Product();
	    p2.setName("Black Hyundai Verna");
	    p2.setDescription("Sedan, Diesel, 2015 Model,  95,000 kms driven, Good Condition");
	    p2.setPrice(450000);
	    p2.setInsurance("No");
	    p2.setTypeOfProduct("Car");
	    p2.setAvailability("Yes");
	    p2.setRating(4);
	    p2.setDurationOfHire(30);
	    p2.setPhoto("MyVerna.jpej");
	    p2.setProductID(2);
	    DB.pr_DB.put(2, p2);
	    
	    Product p3 = new Product();
	    p3.setName("Flat 23");
	    p3.setDescription("3 BHK Flat, Well Furnished, Porshe Locality, Well maintained");
	    p3.setPrice(100000);
	    p3.setInsurance("No");
	    p3.setTypeOfProduct("House");
	    p3.setAvailability("Yes");
	    p3.setRating(4);
	    p3.setDurationOfHire(60);
	    p3.setPhoto("MyHouse.jpej");
	    p3.setProductID(3);
	    DB.pr_DB.put(3, p3);
	    
	    Product p4 = new Product();
	    p3.setName("Bungalow");
	    p3.setDescription("Spacious, 4 bedroom, 2 bathroom apartment in Lakeview, close to nightlife with private backyard");
	    p3.setPrice(135000);
	    p3.setInsurance("Yes");
	    p3.setTypeOfProduct("House");
	    p3.setAvailability("Yes");
	    p3.setRating(5);
	    p3.setDurationOfHire(90);
	    p3.setPhoto("MyBungalow.jpej");
	    p3.setProductID(4);
	    DB.pr_DB.put(4, p4);
	    
	    Product p5 = new Product();
	    p3.setName("Cello Oasis Four Seater Centre Table");
	    p3.setDescription("Product Dimensions: Length (31 inches), Width (17 inches), Height (17 inches)\n" + 
	    		"Color: Ice Brown, Style: Contemporary\n" + "Material: Polypropylene material makes the table light weight and rigid, corrosion resistant");
	    p3.setPrice(800);
	    p3.setInsurance("No");
	    p3.setTypeOfProduct("Furniture");
	    p3.setAvailability("Yes");
	    p3.setRating(3);
	    p3.setDurationOfHire(60);
	    p3.setPhoto("MyTable.jpej");
	    p3.setProductID(5);
	    DB.pr_DB.put(5, p5);
	    
	    Product p6 = new Product();
	    p3.setName("Spacewood Joy King Size Bed (Woodpore Finish, Natural Wenge)");
	    p3.setDescription("Primary Material: Engineered Wood\r\n" + 
	    		"Color: Natural Wenge, Finish: Woodpore, Style: Modern\r\n" + 
	    		"Bed Size: King, Recommended mattress size- 60x78 inches");
	    p3.setPrice(9000);
	    p3.setInsurance("No");
	    p3.setTypeOfProduct("Furniture");
	    p3.setAvailability("Yes");
	    p3.setRating(4);
	    p3.setDurationOfHire(80);
	    p3.setPhoto("MyBed.jpej");
	    p3.setProductID(6);
	    DB.pr_DB.put(6, p6);
	    
	    Product p7 = new Product();
	    p3.setName("Milky White Hyundai Creata");
	    p3.setDescription("SUV, Diesel, 2016 Model,  20,000 kms driven,Good Mileage of about 18, Well Maintained");
	    p3.setPrice(550000);
	    p3.setInsurance("Yes");
	    p3.setTypeOfProduct("Car");
	    p3.setAvailability("Yes");
	    p3.setRating(4);
	    p3.setDurationOfHire(120);
	    p3.setPhoto("MyCreta.jpej");
	    p3.setProductID(7);
	    DB.pr_DB.put(7, p7);
	    
	    
	    
	    
	    
	    
	}

	
}
