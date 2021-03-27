package application;

public class ManagementCompany {

	
	private String name;
	private String taxID;
	private Property[] properties;
	private double mgmFee;
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	private int indexA; 

	public ManagementCompany() {
		plot = new Plot();
		name = "";
		taxID = "";
		mgmFee =0;
		indexA = 0;
	}
public ManagementCompany(java.lang.String name, java.lang.String taxID,double mgmFee,int x,int y,int width,int depth) {
		
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(x,y, width, depth);
		indexA=0;
  }

 public ManagementCompany(ManagementCompany otherCompany) {
	 
	 
		this.name =otherCompany.name;
		this.taxID=otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		properties = new Property[MAX_PROPERTY];
		indexA=0;
 }
 public int getMAX_PROPERTY() {
	 
	 
	 return MAX_PROPERTY;
 }
 
 public double managmentT(){
	 
	 double total = (this.totalRent() * mgmFee)/100;
	 return total;
 }
 public int addProperty(Property property) {
	 if (property == null) {
		 
		 return -2;
	 }	 
	  if (indexA >= MAX_PROPERTY) {
		  
		  return -1;
	  }
	  if (this.plot.encompasses(property.getPlot())) {
		  
		  return -3;
	  }
	  
	  for (int i =0; i < indexA; i++ ) {
	  if (property.getPlot().overlaps(properties[i].getPlot())) {
		  return -4;
	  }
	  
	  }
	 if (indexA < MAX_PROPERTY) {
		 
		 properties[indexA] = property;
		 
		 indexA++;
	 }
	 return indexA-1;
 }
 public int addProperty(String name,String city,double rent,String owner) {
	
	  Property pr = new Property(name, city, rent, owner);
	 
	  if (indexA >= MAX_PROPERTY) {
		  
		  return -1;
	  }
	  if (this.plot.encompasses(pr.getPlot())) {
		  
		  return -3;
	  }
	  
	  for (int i =0; i < indexA; i++ ) {
	  if (pr.getPlot().overlaps(properties[i].getPlot())) {
		  return -4;
	  }
	  
	 }
		 if (indexA < MAX_PROPERTY) {
			 
			 properties[indexA] = pr;
			 
			 indexA++;
		 }
		 return indexA-1;
	 }
 
 public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth) {
	 
	  Property pr = new Property(name, city, rent, owner, x, y, width, depth);
		 
	  if (indexA >= MAX_PROPERTY) {
		  
		  return -1;
	  }
	  if (this.plot.encompasses(pr.getPlot())) {
		  
		  return -3;
	  }
	  
	  if (indexA > 0) {
	  
	  for (int i =0; i < indexA; i++ ) {
	  if (pr.getPlot().overlaps(properties[i].getPlot())) {
		  return -4;
	  }
	  
	 }
	  }
		 if (indexA < MAX_PROPERTY) {
			 properties[indexA]= pr;
		 }
		 return indexA-1;
	 }
	 
 public double totalRent() {
	int totalRent =0;
	 for (int i =0; i<properties.length; i++) {
		 
		 totalRent += properties[i].getRentAmount();
	 }
	 return totalRent;
 }
 public double maxRentProp() {
	 
	 double max = 0;
	 
	 for(int i = 0; i<properties.length; i++ ) {
		 
		 if (properties[i].getRentAmount() > max) {
			 
			 max = properties[i].getRentAmount();
		 }
	 }
	 
	 return max;
 }

 private int maxRentPropertyIndex() {
	 
 int max = 0;
	 
	 for(int i = 0; i<properties.length; i++ ) {
		 
		 if (properties[i].getRentAmount() > max) {
			 
			 max =i;
		 }
	 }
	 
	 return max;
 }
 
 private java.lang.String displayPropertyAtIndex(int i){
	String pr= ""; 
	
	 for(int x = 0; x<properties.length; x++ ) {
		 
		 if (x == i) {
			 
			 pr = properties[x].toString();
		 }
	 }
	 return pr;
 }
 
	
 public java.lang.String toString(){
	 
		String pr= ""; 
		
	 for(int x = 0; x<properties.length; x++ ) {
		 
          pr += properties[x].toString();
		 }
	 
	 return "List of properties for" + name +", taxID " + taxID
			 + "/n/n-------------------------------------------"+ 
	pr + "/n/n----------------------------------------/n/n"
	+String.format ("total managment Fee: %.1f" ,this.managmentT());
	
	 
 }

public Plot getPlot() {
	return plot;
}
public String getName() {
	return name;
}

}
