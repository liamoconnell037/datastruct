package refresher;
import java.text.DecimalFormat;
public class Main {

	public static void main(String[] args) {
		// Part 2
		GenericCoin coin = new GenericCoin();
		GenericCoin coin2 = new GenericCoin();
		int countCoin = 0, countCoin2 = 0;
		for(int i = 0; i < 50;i++) {
			coin.toss();
			coin2.toss();
			if(coin.getSideUp().equals("Heads"))
				countCoin++;
			if(coin2.getSideUp().equals("Heads"))
				countCoin2++;
		}
		System.out.println("Total number of heads: " + (countCoin + countCoin2));
		
		if(countCoin > countCoin2) 
			System.out.println("Coin 1 had higher head count with: " + countCoin);
		else if (countCoin2 > countCoin)
			System.out.println("Coin 2 had higher head count with: " + countCoin2);
		else
			System.out.println("Coins had even head count with: " + countCoin);
		
		//Part 5
		DecimalFormat df = new DecimalFormat("0.00"); // money format (always shows 2 decimal places)
		System.out.println("\n\n");
		
		Coin nickel = new Coin(0.05, "nickel");
		Coin dime = new Coin(0.1, "dime");
		Coin quarter = new Coin(0.25, "quarter");
		nickel.toss();
		dime.toss();
		quarter.toss();
		double total = 0;
		if(nickel.getSideUp().equals("Heads")) {
			total += nickel.getValue();
			System.out.println(nickel.getType() + " flipped heads.");
		}
		if(dime.getSideUp().equals("Heads")) {
			total += dime.getValue();
			System.out.println(dime.getType() + " flipped heads.");
		}
		if(quarter.getSideUp().equals("Heads")) {
			total += quarter.getValue();
			System.out.println(quarter.getType() + " flipped heads.");
		}
		System.out.println("Total: $" + df.format(total));
	}

}

/* Part 2:
 * Total number of heads: 50
 * Coin 1 had higher head count with: 27
*/

/* Part 5:
 * dime flipped heads.
 * Total: $0.10
*/