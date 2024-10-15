package bags;

public class Coin extends GenericCoin {
	private double value;
	private String type;
	
	public Coin() {
		super();
		value = 0;
		type = "useless";
	}
	
	public Coin(double value, String type) {
		super();
		this.value = value;
		this.type = type;
	}
	
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public double getValue() {return value;}
	public void setValue(double value) {this.value = value;}
	
	public boolean equals(Coin other) {
		if(this.getType().equals(other.getType()))
			return true;
		return false;
	}
	public String toString() {
		return getType() + " ($" + getValue() + ") : " + getSideUp();
	}
}
