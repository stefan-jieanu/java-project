import java.util.Calendar;

class RentDate {

    public Calendar first;
    public Calendar second;
    public boolean free = true;
    public Renter renter = null;

    public RentDate(Calendar _first, Calendar _second) {
        first = _first;
        second = _second;
    }
}