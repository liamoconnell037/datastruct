import java.util.ArrayList;

public class RealEstateList implements RealEstateListInterface {
	private ArrayList<HousingList> list = new ArrayList<>();
	
	public void add(HousingList house) {
		list.add(house);
	}
	public RealEstateList(ArrayList<HousingList> given) {
		list = given;
	}
	
	public void add(int index, HousingList house) {
		list.add(index, house);
	}

	public HousingList remove(int index) {
		return list.remove(index);
	}

	public HousingList viewHouse(int lotNum) {
		for(HousingList house : list) {
			if(house.getLotNumber() == lotNum)
				return house;
		}
		return null;
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
	
}
