import java.util.ArrayList;

public class RealEstateList implements RealEstateListInterface {
	private ArrayList<HousingList> list = new ArrayList<>();
	
	public boolean add(HousingList house) {
		if(getIndex(house.getLotNumber()) != -1) return false;
		list.add(house);
		return true;
	}
	public RealEstateList(ArrayList<HousingList> given) {
		list = given;
	}
	
	public boolean add(int index, HousingList house) {
		if(getIndex(house.getLotNumber()) != -1) return false; 
		list.add(index, house);
		return true;
	}

	public HousingList remove(int index) {
		return list.remove(index);
	}
	
	public HousingList get(int index) {
		return list.get(index);
	}
	// gets index from lot number
	public int getIndex(int lotNum) {
		for(int i = 0; i < list.size();i++) {
			if(list.get(i).getLotNumber() == lotNum)
				return i;
		}
		return -1;
	}

	public ArrayList<HousingList> getHousesInRange(double low, double high) {
		ArrayList<HousingList> houses = new ArrayList<>();
		for(HousingList house : list) {
			if(low <= house.getPrice() && high >= house.getPrice())
				houses.add(house);
		}
		return houses;
	}

	public ArrayList<HousingList> getCurrentListings() {
		return list;
	}
	
	public String toString() {
		String s = "";
		for(HousingList o : list) {
			s += o.toString() + "\n\n";
		}
		return s;
	}
	
}
