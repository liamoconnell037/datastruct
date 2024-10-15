package bags;

public class GenericCoin implements CoinInterface { //only difference from part 1 & 3 is 'implements CoinInterface'
	private String sideUp;
	
	public GenericCoin() {toss();}
	public GenericCoin(String side) {sideUp = side;}
	
	public void toss() {
		if(Math.random()< 0.5)
			sideUp = "Heads";
		else
			sideUp = "Tails";
	}
	
	public String getSideUp() {return sideUp;}
	public String toString() {return sideUp;}
}
