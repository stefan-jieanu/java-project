class Main {
    public static void main(String[] args) {
        if (args.length < 0) {
            PrintIncorrectArgs();
        } else if (args[0] != "new" || args[0] != "load") {
            PrintIncorrectArgs();
        } else {
            if (args[0] == "new") {
                AirBNB airbnb = new AirBNB("");
            } else if (args[0] == "load") {
                AirBNB airbnb = new AirBNB("load");
            }
        }
    }

    public static void PrintIncorrectArgs() {
        System.out.println("Please enter a correct argument");
        System.out.println("'new' for a new empty app");
        System.out.println("'load' to load data");
    }
}