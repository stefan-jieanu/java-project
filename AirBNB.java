import java.util.*;

class AirBNB  {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Renter> renters = new ArrayList<Renter>();
    private ArrayList<Homeowner> homeowners = new ArrayList<Homeowner>();


    // This represents the type of user using the application 
    // and thus the interacations the user can have with the application
    // 0 - airbnb admin
    // 1 - homeowner
    // 2 - renter
    private int userType;

    public AirBNB(String loadFilePath) {
        if (!loadFilePath.isEmpty())
            LoadDataFromFile();

        SelectUserType();

        if (userType == 0) {
            // If the user is an airbnb admin
            SelectAdminAction();
        } else if (userType == 1) {
            // If the user is a homeowner
            Homeowner owner = SelectHomeowner();
            SelectHomeownerAction(owner);
        } else if (userType == 2) {
            // If the user is a renter
            Renter renter = SelectRenter();
            SelectRenterAction(renter);
        }
    }

    private void LoadDataFromFile() {
        System.out.println("loading");
    }

    private void SelectUserType() {
        System.out.println("Select the user type");
        System.out.println("0 - airbnb admin");
        System.out.println("1 - homeowner");
        System.out.println("2 - renter");

        // Input validation
        userType = GetValidInput(3);
    }

    private void SelectAdminAction() {
        // The actions an admin can do:
        // 0 - add a homeowner
        // 1 - add a renter
        System.out.println("Select an action: ");
        System.out.println("0 - " + "add a homeowner");
        System.out.println("1 - " + "add a renter");
        System.out.println("2 - " + "show all homeowners");
        System.out.println("3 - " + "show all renters");

        int option = GetValidInput(4);
        switch (option) {
            case 0: {
                // Add a new homeowner
                System.out.print("\nHomeowner name: ");
                String name = scanner.nextLine();
                Homeowner owner = new Homeowner(name);
                homeowners.add(owner);
                break;
            }
            case 1: {
                // Add a new renter
                System.out.print("\nRenter name: ");
                String name = scanner.nextLine();
                Renter renter = new Renter(name);
                renters.add(renter);
                break; 
            }
            case 2: {
                for (Homeowner owner : homeowners) 
                    System.out.println(owner.GetName());
                break;
            }
            case 3: {
                for (Renter renter : renters)
                    System.out.println(renter.GetName());
                break;
            }
            default:
                break;
        }
    }

    private void SelectHomeownerAction(Homeowner _owner) {
        // 
    }

    private void SelectRenterAction(Renter _renter) {

    }

    private Homeowner SelectHomeowner() {
        System.out.println("Who are you?");
        for (Homeowner owner : homeowners) {
            System.out.println("0 - " + owner.GetName());
        }

        int owner = GetValidInput(homeowners.size());
        return homeowners.get(owner);
    }

    private Renter SelectRenter() {
        System.out.println("Who are you?");
        for (Renter r : renters) {
            System.out.println("0 - " + r.GetName());
        }

        int r = GetValidInput(renters.size());
        return renters.get(r);
    }

    // Methods for input validation
    private int GetValidInput(int maxOptions) {
        int option = scanner.nextInt();
        while (option < 0 || option > maxOptions) {
            System.out.println("Please select a valid option");
            option = scanner.nextInt();
        }
        return option;
    }
}