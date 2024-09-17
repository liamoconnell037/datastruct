
public class HousingList {
	private int lotNumber;
	private Name owner;
	private double price;
	private int sqFt;
	private int numBedrooms;
	
	public int getLotNumber() {return lotNumber;}
	public void setLotNumber(int lotNumber) {this.lotNumber = lotNumber;}
	public Name getOwner() {return owner;}
	public void setOwner(Name owner) {this.owner = owner;}
	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}
	public int getSqFt() {
		return sqFt;
	}
	public void setSqFt(int sqFt) {
		this.sqFt = sqFt;
	}
	public int getNumBedrooms() {
		return numBedrooms;
	}
	public void setNumBedrooms(int numBedrooms) {
		this.numBedrooms = numBedrooms;
	}
	
	public HousingList(int lotNumber, Name owner, double price, int sqFt, int numBedrooms) {
		this.lotNumber = lotNumber;
		this.owner = owner;
		this.price = price;
		this.sqFt = sqFt;
		this.numBedrooms = numBedrooms;
	}
	
	public String toString() {
		return "Lot #" + lotNumber + " owned by " + owner.toString() + " listed at $" + price + " with " + sqFt + " squared feet and " + numBedrooms + " number of bedrooms.";
	}
}
