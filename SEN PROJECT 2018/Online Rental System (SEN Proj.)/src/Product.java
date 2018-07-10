import java.util.*;

public class Product {
	protected String name,description;
	protected int price;
	protected String Insurance;
	protected String typeOfProduct;
	protected String availability;
	protected int rating;
	protected int durationOfHire;
    static int ID = 4;
    protected int productID;
    protected String photo;
	
	static void viewProductDetails(int id){
	    Product pro = new Product();
	    pro = DB.pr_DB.get(id);
		System.out.println("Product Name: "+ pro.name);
		System.out.println("Product Description : "+ pro.description);
		System.out.println("Price: "+ pro.price);
		System.out.println("Category: "+ pro.typeOfProduct);
		System.out.println("Insuranced Cover: "+ pro.Insurance);
		System.out.println("Availability : "+ pro.availability);
		System.out.println("Status: "+ pro.availability);
		System.out.println("Photos: "+ pro.photo);
		System.out.println();
	}
	
	static Product addProduct(String name, String des,String category,int price,String pic,String insr){ 
	    //only owner calls this class, also set availability while calling this  class.
        Product p = new Product();	
	    p.name = name;
	    p.description = des;
	    p.typeOfProduct = category;
	    p.price = price;
	    p.Insurance = insr;
	    p.productID = ID++;
	    p.setAvailability("Yes");
	    p.uploadPhoto(pic);
	    DB.pr_DB.put(ID-1,p);
	    return p;
	}
	
	
	void updatePrice(int price)
	{
	    this.price = price;
	}
    void uploadPhoto(String x)
    {
        this.photo = x;
    }
    
     
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInsurance() {
		return Insurance;
	}

	public void setInsurance(String insurance) {
		Insurance = insurance;
	}

	public String getTypeOfProduct() {
		return typeOfProduct;
	}

	public void setTypeOfProduct(String typeOfProduct) {
		this.typeOfProduct = typeOfProduct;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getDurationOfHire() {
		return durationOfHire;
	}

	public void setDurationOfHire(int durationOfHire) {
		this.durationOfHire = durationOfHire;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	static void getProducts(){
    	Set<Integer> prid_set = DB.pr_DB.keySet();
    	System.out.println("size "+prid_set.size());
    	for(int i : prid_set){
    		Product p = DB.pr_DB.get(i);    		
    		System.out.println("Product name : "+p.name);
    		System.out.println("Product ID : "+p.productID);
    		System.out.println("Product type : "+p.typeOfProduct);
    		System.out.println("Product Price : "+p.price);
    		System.out.println("Product's duration of hire : "+p.durationOfHire);
    		System.out.println("Product's insurance "+p.Insurance);
    		System.out.println("Product's availability : "+p.availability);
    		System.out.println("Product's rating : "+p.rating);
    		System.out.println("Product description : "+p.description);
    		System.out.println();
    	}    	
    }
    
    static void getProductsSortedPrice(String type){
    	Set<Integer> prid_set = DB.pr_DB.keySet();
    	ArrayList<Product> pr = new ArrayList<Product>();    	
    	for(int i : prid_set){
    		Product p = DB.pr_DB.get(i);
    		if(type.equals(p.typeOfProduct)){
    			pr.add(p);
    		}
    	}
    	Collections.sort(pr,new Comparator<Product>(){
    		public int compare(Product p1,Product p2){
    			return p1.price - p2.price;
    		}
    	});
    	System.out.println(type+" Products sorted according to Price : ");
    	for(int i=0;i<pr.size();i++){
    		Product p = pr.get(i);
    		System.out.println("Product name : "+p.name);
    		System.out.println("Product price : "+p.price);
    		System.out.println("Poduct ID : "+p.productID);    
    		Main.drawLine();
    	}
    }
    
    static void getProductsSortedRating(String type){
    	Set<Integer> prid_set = DB.pr_DB.keySet();
    	ArrayList<Product> pr = new ArrayList<Product>();    	
    	for(int i : prid_set){
    		Product p = DB.pr_DB.get(i);
    		if(type.equals(p.typeOfProduct)){
    			pr.add(p);
    		}
    	}
    	Collections.sort(pr,new Comparator<Product>(){
    		public int compare(Product p1,Product p2){
    			return p2.rating - p1.rating;
    		}
    	});
    	System.out.println(type+" Products sorted according to Rating : ");
    	for(int i=0;i<pr.size();i++){
    		Product p = pr.get(i);
    		System.out.println("Product name : "+p.name);
    		System.out.println("Product rating : "+p.rating);
    		System.out.println("Product ID : "+p.productID);
    		Main.drawLine();
    	}
    }
}
