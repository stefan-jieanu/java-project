import java.util.*;

class Homeowner {

    private ArrayList<PlaceForRent> placesForRent = new ArrayList<PlaceForRent>();
    private String name;

    public Homeowner(String _name) {
        name = _name;

        placesForRent.add(new PlaceForRent(PlaceForRent.Category.SHARED_ROOM, "Timisoara", "Langa Mall", 25, 2, true, true, false));

        AddRentDateForPlace(placesForRent.get(0), 2020, 12, 30, 5);

        placesForRent.get(0).PrintRentDates();

        System.out.println(placesForRent.get(0));
    }

    public void AddRentDateForPlace(PlaceForRent _place, int _year, int _month, int _day, int _rentDays) {
        Calendar startDate = Calendar.getInstance();

        startDate.setLenient(false);
        try {
            // If the date is valid
            startDate.set(_year, _month - 1, _day);
            Calendar endDate = (Calendar)startDate.clone();
            endDate.add(Calendar.DATE, _rentDays);
            
            if (_place.AddRentDate(startDate, endDate)) {
                // IF the time period is free
                System.out.println("Date added");
            } else {
                // If the time period is not free
                System.out.println("Time period is not avalible");
            }
        } catch (Exception e) {
            System.out.println("Invalid date");
        }
    }

    public String GetName() {
        return name;
    }
}
