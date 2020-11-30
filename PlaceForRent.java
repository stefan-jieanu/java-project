import java.util.*;

class PlaceForRent {
    enum Category {
        SHARED_ROOM,
        PRIVATE_ROOM,
        WHOLE_ROOM
    }

    private Category cat;
    private String city;
    private String address;
    private int pricePerDay;
    private int numberOfBeds;
    private boolean privateBedroom;
    private boolean providedToiletries;
    private boolean smokingAllowed;

    private ArrayList<RentDate> avalibleRentDates = new ArrayList<RentDate>();

    public PlaceForRent(Category _cat, String _city, String _address, int _pricePerDay, int _numberOfBeds, boolean _privateBedroom, boolean _providedToiletries, boolean _smokingAllowed) {
        cat = _cat;
        city = _city;
        address = _address;
        pricePerDay = _pricePerDay;
        numberOfBeds = _numberOfBeds;
        privateBedroom = _privateBedroom;
        providedToiletries = _providedToiletries;
        smokingAllowed = _smokingAllowed;
    }

    public boolean AddRentDate(Calendar _start, Calendar _end)
    {
        // If there is no other date in the calendar, then add the date
        if (avalibleRentDates.isEmpty()) {
            avalibleRentDates.add(new RentDate(_start, _end));

            // Sort the dates so that they are added in order
            SortRentDates();

            return true;
        }
        
        // Check that the date doesn't coincide with another date
        // Check if the date added fits before the first one
        if (avalibleRentDates.get(0).first.compareTo(_start) > 0 && avalibleRentDates.get(0).first.compareTo(_end) > 0) {
            // If the time period is before the first one
            // add it to the list
            avalibleRentDates.add(new RentDate(_start, _end));

            // Sort the dates so that they are added in order
            SortRentDates();

            return true;
        } 

        // If there is more than one rent date, check for avalible time slots
        if (avalibleRentDates.size() > 1) {
            RentDate prevRentDate;
            for (int i = 0; i < avalibleRentDates.size() - 1; i++) {
                prevRentDate = avalibleRentDates.get(i);
    
                if (prevRentDate.second.compareTo(_start) < 0 && avalibleRentDates.get(i+1).first.compareTo(_end) > 0) {
                    // The time period is avalible so we add it to the list
                    avalibleRentDates.add(new RentDate(_start, _end));

                    // Sort the dates so that they are added in order
                    SortRentDates();

                    return true;
                } 
            }
        }

        // Check that it doesn't overlap with the rent date
        RentDate lastRentDate = avalibleRentDates.get(avalibleRentDates.size() - 1);
        if (lastRentDate.second.compareTo(_start) < 0) {
            avalibleRentDates.add(new RentDate(_start, _end));

            // Sort the dates so that they are added in order
            SortRentDates();

            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return cat + ", " + city + ", " + address + ", " + numberOfBeds + " beds, " + 
            privateBedroom + ", " + providedToiletries + ", " + smokingAllowed;
    }

    public void PrintRentDates() {
        for (RentDate date : avalibleRentDates) {
            System.out.println(date.first.get(Calendar.DAY_OF_MONTH) + "." + date.first.get(Calendar.MONTH) + "." + date.first.get(Calendar.YEAR) 
                + " - " + date.second.get(Calendar.DAY_OF_MONTH) + "." + date.second.get(Calendar.MONTH) + "." + date.second.get(Calendar.YEAR));
        }
    }

    public void RentRoom(RentDate _rentDate, Renter renter) {
        _rentDate.free = false;
        _rentDate.renter = renter;
    }

    // Getters
    public Category GetCategory() { return cat; }
    public String GetCity() { return city; }
    public String GetAddress() { return address; }
    public int GetNumberOfBeds() { return numberOfBeds; }
    public boolean GetPrivateBedroom() { return privateBedroom; }
    public boolean GetProvidedToiletries() { return providedToiletries; }
    public boolean GetSmokingAllowed() { return smokingAllowed; }

    // public void SetCity(String _city) { city = _city }
    // public void SetAddress(String _address) { address = _address }

    private void SortRentDates() {
        avalibleRentDates.sort((RentDate d1, RentDate d2) -> 
            d1.first.compareTo(d2.first));
    }
}