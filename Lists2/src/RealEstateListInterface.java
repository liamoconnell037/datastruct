import java.util.ArrayList;
public interface RealEstateListInterface {
	public void add(HousingList house);
	public HousingList remove(int index);
	
	//searches for the house with the given lot number
	public HousingList viewHouse(int lotNum);
	
	//searches for houses in the given money range
	public ArrayList<HousingList> getHousesInRange(double low, double high);
	
	public ArrayList<HousingList> getCurrentListings();
}
