package application;

public class Property {

	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	
	public Property() {
	
		
		rentAmount = 0;
		city = "";
		owner = "";
		propertyName= "";
	    plot = new Plot();
}
	
	public Property (Property p) {
		
	this.city = p.city;
	this.owner = p.owner;
	this.propertyName = p.propertyName;
	this.rentAmount = p.rentAmount;
	this.plot=p.plot;
	}
	
	public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner) {
		//Constructor, Parameterized constructor with no Plot information (uses default Plot where x,y are set to 0, width and depth set to 1)
		 
	       plot = new Plot();
		   this.propertyName = propertyName;
		   this.city = city; 
		   this. rentAmount =rentAmount;
		   this.owner =  owner;
	}
	
	public Property(java.lang.String propertyName, java.lang.String city, double rentAmount, java.lang.String owner, int x, int y, int width, int depth ) {
		
		this.propertyName = propertyName;
		this.city =city; 
		this.rentAmount =rentAmount;
		this.owner =  owner;
	    plot = new Plot(x, y, width, depth);
	}
	public java.lang.String getPropertyName(){
		return propertyName;
	}
	public void setPropertyName(java.lang.String propertyName) {
		this.propertyName= propertyName;
	}
	public java.lang.String getCity(){
		return city;
	}
	
	public Plot setPlot(int x, int y, int width, int depth) {
	
		plot = new Plot(x, y, width, depth);
		return plot; 
		
	}
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
    
	public java.lang.String getOwner(){
		return owner;
	}
	public void setOwner(java.lang.String owner) {
		this.owner = owner;
	}
	public java.lang.String toString(){
		
		return "property name: " + propertyName
		+ "\nLocated in: " + city
		+"\nBelonging to: " + owner 
		+"\nRent Amount: " +  rentAmount;
	}
	public Plot getPlot() {
		return plot;
	}
}
