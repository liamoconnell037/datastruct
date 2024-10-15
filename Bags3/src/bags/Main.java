package bags;

public class Main {
	
	public static<T> void printArray(T[] array) {
		System.out.print("{\n");
		for(int i = 0; i < array.length;i++) {
			System.out.println(array[i] + ", ");
		}
		System.out.println("}");
	}
	
	public static void main(String[] args) {
		//test the methods
		Coin quarter = new Coin(0.25, "quarter");
		Coin dime = new Coin(0.1, "dime");
		Coin nickel = new Coin(0.05, "nickel");
		Coin penny = new Coin(0.01, "penny");
		ResizableArrayBag<Coin> bag = new ResizableArrayBag<>();
		bag.add(new Coin());
		System.out.println(bag.getCurrentSize());
		bag.add(quarter);
		System.out.println(bag.remove());
		bag.add(dime);
		bag.add(dime);
		System.out.println(bag.remove(dime));
		System.out.println(bag.contains(dime));
		printArray((Object[])bag.toArray());
		
		System.out.println("\n\n\nDone testing functions");
		final int size = (int)(Math.random() * 10) + 5;
		ResizableArrayBag<Coin> coinBag = new ResizableArrayBag<>(size);
		for(int i = 0; i < size;i++) {
			switch ((int)(Math.random()*4)+1) {
			case 1 : {
				coinBag.add(penny);
				break;
			}
			case 2 : {
				coinBag.add(dime);
				break;
			}
			case 3 : {
				coinBag.add(nickel);
				break;
				}
			case 4 : {
				coinBag.add(quarter);
				break;
			}
			}
		}
		printArray((Object[])coinBag.toArray());
		System.out.println("Coin is being put back into bag after pull.");
		for(int i = 0; i < 5;i++) {
			System.out.println("Test #" + (i+1));
			double product = 1.0;
			for(int j = 0; j < 3;j++) {
				Coin target = new Coin();
				switch ((int)(Math.random()*4)+1) {
				case 1 : {
					target = penny;
					break;
				}
				case 2 : {
					target = nickel;
					break;
				}
				case 3 : {
					target = dime;
					break;
				}
				case 4 : {
					target = quarter;
					break;
				}
				}
				System.out.println("Target coin: " + target);
				product *= (double)(coinBag.getFrequencyOf(target)) / (double)(coinBag.getCurrentSize());
				System.out.println("Chance: " + product);
			}
			System.out.println("\n\n");
		}
		
	}

}

/*
 * 1
quarter ($0.25) : Heads
true
true
{
useless ($0.0) : Tails, 
dime ($0.1) : Tails, 
}



Done testing functions
{
penny ($0.01) : Tails, 
nickel ($0.05) : Heads, 
penny ($0.01) : Tails, 
penny ($0.01) : Tails, 
penny ($0.01) : Tails, 
nickel ($0.05) : Heads, 
quarter ($0.25) : Heads, 
quarter ($0.25) : Heads, 
penny ($0.01) : Tails, 
dime ($0.1) : Tails, 
}
Coin is being put back into bag after pull.
Test #1
Target coin: penny ($0.01) : Tails
Chance: 0.5
Target coin: penny ($0.01) : Tails
Chance: 0.25
Target coin: penny ($0.01) : Tails
Chance: 0.125



Test #2
Target coin: penny ($0.01) : Tails
Chance: 0.5
Target coin: quarter ($0.25) : Heads
Chance: 0.1
Target coin: quarter ($0.25) : Heads
Chance: 0.020000000000000004



Test #3
Target coin: nickel ($0.05) : Heads
Chance: 0.2
Target coin: dime ($0.1) : Tails
Chance: 0.020000000000000004
Target coin: nickel ($0.05) : Heads
Chance: 0.004000000000000001



Test #4
Target coin: nickel ($0.05) : Heads
Chance: 0.2
Target coin: quarter ($0.25) : Heads
Chance: 0.04000000000000001
Target coin: quarter ($0.25) : Heads
Chance: 0.008000000000000002



Test #5
Target coin: quarter ($0.25) : Heads
Chance: 0.2
Target coin: nickel ($0.05) : Heads
Chance: 0.04000000000000001
Target coin: penny ($0.01) : Tails
Chance: 0.020000000000000004
*/

