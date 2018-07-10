import java.util.*;
import ClientUI.*;
import ServerUI.*;

public class Main {

	static void drawLine(){
		System.out.println("*----------------------------*----------------------------*");		
	}
	
	static String usr_type;	//Type of User
	static String usr_name;	//username of user
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DB.storeUser();
		DB.storeProduct();		
		System.out.println("WELCOME TO RENTAL SYSTEMS");
		drawLine();
		boolean input_valid = true;
		
		while(input_valid) {
			System.out.println("To login enter 1");
			System.out.println("To sign Up enter 2");				
			System.out.println("Enter a choice");
			int choice = sc.nextInt();
			sc.nextLine();	//to collect \n character		
			switch(choice){
			case 1:
				System.out.println("Enter username : ");			
				String userName = sc.next();
				System.out.println("Enter password : ");
				String pw = sc.next();
				while(!User.login(userName, pw)){
					System.out.println("Enter username : ");				
					userName = sc.next();
					System.out.println("Enter password : ");
					pw = sc.next();
				}
				Main.usr_name = userName;
				
				input_valid = false;
				break;
			case 2:
				System.out.println("Create Your account as Owner,Hirer,Technician");
				System.out.println("Enter account type : ");
				usr_type  = sc.next(); 			
				System.out.println("Enter name ");
				String name = sc.next();
				System.out.println("Enter address ");
				String ad = sc.next();
				System.out.println("Enter username ");
				String un = sc.next();
				System.out.println("Enter contact ");
				long c = sc.nextLong();
				sc.nextLine(); 	//to collect \n character
				System.out.println("Enter email ");
				String email = sc.next();
				System.out.println("Enter password ");
				String pw1 = sc.next();
				User.signUp(name, ad, un, c, email, pw1,usr_type);
				usr_name = un;
				input_valid = false;				
				break;
			default:
				System.out.println("Input choice is invalid");
				input_valid = true;
			}
		}
		if(usr_type.equals("Hirer")) {
			int choice = 1;
			System.out.println("User : "+usr_name);
			while(choice != 0) {
				System.out.println("To exit application enter 0 ");
				System.out.println("To get Products List enter 1 ");
				System.out.println("To get Products according to a type enter 2");
				System.out.println("To enter a chat with Owner enter 3");				
				Main.drawLine();
				choice = sc.nextInt();
				sc.nextLine();	//To store \n character
				switch(choice) {
				case 1:
					System.out.println("Products List");
					Product.getProducts();
				case 2: 
					System.out.println("Enter type");
					String pr_choice_type = sc.next();
					System.out.println("To sort products according to price enter 1");
					System.out.println("To sort products according to rating enter 2");
					int srt_atr_choice = sc.nextInt();
					if(srt_atr_choice == 1) {
						Product.getProductsSortedPrice(pr_choice_type);
					}else {
						Product.getProductsSortedRating(pr_choice_type);
					}
					break;
				case 3:
					ServerUI.StartServer.callServer();
					ClientUI.ClientLogin.callClient();
					ClientUI.ClientLogin.callClient();	
				case 0:
					return ;
				default :
					System.out.println("You enterd an invalid input");			
				}	
			}
		}else if(usr_type.equals("Owner")) {
			Owner O = new Owner();
			O.setUserName(usr_name);
			System.out.println("User : "+usr_name);
			int choice = 1;
			while(choice != 0) {
				System.out.println("To exit application enter 0 ");
				System.out.println("To get Inventory List enter 1 ");
				System.out.println("To add product in Inventory List enter 2 ");
				System.out.println("To chat with other user enter 3 ");
				Main.drawLine();
				choice = sc.nextInt();
				sc.nextLine();
				if(choice == 1) {
					O.getInventoryList();			
				}else if(choice ==2) {
					System.out.println("Enter product name : ");
					String pr_name = sc.next();
					System.out.println("Enter product description : ");
					String pr_des = sc.nextLine();
					System.out.println("Enter product price : ");
					int pr_price = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter product type : ");
					String pr_type = sc.next();
					System.out.println("Enter image : ");
					String pr_img = sc.next();
					System.out.println("Enter insurance cover : ");
					String pr_insr = sc.next();
					Product p = Product.addProduct(pr_name, pr_des, pr_type, pr_price, pr_img, pr_insr);
					DB.prusr_DB.put(Product.ID-1, O.getUserName());
					O.updateInventoryList(p);				
				}else if(choice == 3) {
					ServerUI.StartServer.callServer();
					ClientUI.ClientLogin.callClient();
					ClientUI.ClientLogin.callClient();
				}else {
					return;
				}
			}
		}else {
			Technician T = new Technician();
			T.setUserName(usr_name);
			System.out.println("User : "+usr_name);
			System.out.println();
			int choice = 1;
			while(choice != 0) {
				System.out.println("To exit application enter 0");
				System.out.println("To chat with hirer enter 1 ");
				System.out.println("To view skill set enter 2 ");
				choice = sc.nextInt();
				if(choice == 1) {
					ServerUI.StartServer.callServer();
					ClientUI.ClientLogin.callClient();
					ClientUI.ClientLogin.callClient();
				}else if(choice == 2) {
					T.viewSkillSet();
				}else {
					return;
				}
			}
		}
				
		
		drawLine();
		System.out.println("END");
	}

}

