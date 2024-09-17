import java.util.ArrayList;
public class Client {
	private static RealEstateList houses;
	
	public static void main(String[] args) {
		createList();
		System.out.println("\t\tReal Estate Listings");
		//TODO: MENU!!!! WOOO!
	}
	
	private static void createList() {
		ArrayList<HousingList> list = new ArrayList<>();
		list.add(new HousingList(12345, new Name("Ada", "Lovelace"), 300000, 30000, 4));
		list.add(new HousingList(67890, new Name("Charles", "Babbage"), 250000, 1250, 2));
		list.add(new HousingList(23456, new Name("Grace", "Hopper"), 325000, 2300, 3));
		list.add(new HousingList(34567, new Name("Alan", "Turing"), 455000, 3250, 5));
		list.add(new HousingList(45678, new Name("Steve", "Wozniak"), 285000, 1500, 3));
		list.add(new HousingList(56789, new Name("Katherine", "Johnson"), 425900, 2800, 4));		
		list.add(new HousingList(34342, new Name("Laam", "O'Dconenl"), 500000, 4000, 3));
		list.add(new HousingList(323232, new Name("Something", "Cool"), 1024232, 1000, 1));
		list.add(new HousingList(111111, new Name("BABJGSFJKS", "fsdkf;kldsjfas;of udshiqjaujhflkds"), 12032, 3000, 2));
		list.add(new HousingList(00012, new Name("Another", "Name"), 90000, 2500, 3));
		houses = new RealEstateList(list);
	}
}
