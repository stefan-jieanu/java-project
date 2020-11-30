import java.util.*;

class Renter {

    private ArrayList<String> renterPlaces = new ArrayList<String>();
    private String name;

    public Renter(String _name) {
        name = _name;
    }

    public void RentPlace(String _rentedPlaceInfo) {
        renterPlaces.add(_rentedPlaceInfo);
    }

    public void PrintRentedPlaces() {
        for (String s : renterPlaces) {
            System.out.println(s);
        }
    }

    public String GetName() {
        return name;
    }
}