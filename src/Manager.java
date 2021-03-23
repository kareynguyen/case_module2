import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Manager {
    static ArrayList<Movie> movies = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ProcessBooking processBooking = new ProcessBooking();
    static Scanner sc = new Scanner(System.in);

    public void addRoom() {
        System.out.println("Enter room name: ");
        String roomName = sc.nextLine();

        int rowCount;
        while (true) {
            try {
                System.out.println("Enter row: ");
                rowCount = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please try again! Use number only!");
            }
        }

        Room room = new Room(roomName);                                         // tao room moi
        room.createRows(10, rowCount);                                  // tao row trong room
        rooms.add(room);                                                        // them doi tuong room vao list
    }

    public void addMovie() {
        System.out.println("Enter name of Movie: ");
        String movieName = sc.nextLine();


        String regexDate = "[0-3]{1}[0-9]{1}(/|-)[0-1]{1}[0-9]{1}(/|-)2021";
        String showDate;
        do {
            System.out.println("Enter show date [DD-MM-YYYY]: ");
            showDate = sc.nextLine();
        } while (!Pattern.matches(regexDate, showDate));


        System.out.println("Select room by enter room's number:");
        for (int i = 0; i < rooms.size(); i++) {                                // hien thi danh sach rooms
            System.out.println((i + 1) + " " + rooms.get(i).getName());
        }

        int roomNo;
        while (true) {
            try {
                System.out.println("Enter room number: ");
                roomNo = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please try again! Use number only!");
            }
        }                                                       // nhap ma room muon chon
        Movie movie = new Movie(movieName, showDate, rooms.get(roomNo - 1));    // tao doi tuong movie moi de add vao danh sach movies
        movies.add(movie);
    }

    public void displayMovie() {
        for (int i = 0; i < movies.size(); i++) {
            int showNumber = i + 1;
            System.out.println("Show Number: " + showNumber);
            System.out.println("Movie name: " + movies.get(i).getMovieName());
            System.out.println("Show date: " + movies.get(i).getShowDate());
            System.out.println("\n");
        }
        System.out.println("End of Show List.\n");
    }

    public void makeBooking() {
        System.out.println("Enter customer's age: ");
        int age = Integer.parseInt(sc.nextLine());
        if (age < 16) {
            System.out.println("Under 16 are not allowed!");
            return;
        }

        String regexName = "^[a-zA-z]+";
        String name;
        do {
            System.out.println("Enter customer's name (use Alphabet): ");
            name = sc.nextLine();
        } while (!Pattern.matches(regexName, name));

        int customerId;
        while (true) {
            try {
                System.out.println("Enter customer's ID:  ");
                customerId = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please try again! Use number only!");
            }
        }
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == customerId) {
                System.out.println("ID is already existed!");
                return;
            }
        }

        Customer customer = new Customer(customerId, name, age);                // tao doi tuong customer moi de add vao danh sach customers
        customers.add(customer);

        for (int i = 0; i < movies.size(); i++) {                               // hien thi danh sach movies
            int showNo = i + 1;
            System.out.println("Show Number: " + showNo);
            System.out.println("Movie Name:   " + movies.get(i).getMovieName());
            System.out.println("Show Date:   " + movies.get(i).getShowDate());
            System.out.print("\n");
        }
        System.out.println("-------------------------");

        int showNumber;
        while (true) {
            try {
                System.out.println("Enter show number:  ");
                showNumber = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please try again! Use number only!");
            }
        }
        movies.get(showNumber - 1).getRoom().displaySeatPosition();             // hien thi danh sach ghe

        System.out.println();
        Booking booking = new Booking(customer, movies.get(showNumber - 1));    // tao doi tuong booking moi
        int selectedRow;
        while (true) {
            try {
                System.out.println("Enter row:  ");
                selectedRow = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please try again! Use number only!");
            }
        }

        int selectedSeat;
        while (true) {
            try {
                System.out.println("Enter seat:  ");
                selectedSeat = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please try again! Use number only!");
            }
        }

        if (booking.reservedSeat(selectedRow - 1, selectedSeat - 1)) {
            bookings.add(booking);                                                 // neu reservedSeat la true (reserve) thi them booking vao bookings list

            System.out.println("The seat is now reserved for you.");
            System.out.println();
            System.out.println("Your Bill");
            System.out.println("-------------------------");
            System.out.println("INFORMATION: ");
            System.out.println(booking.display());                                  // hien thi booking vua tao
            System.out.println("Total costs: " + booking.getCost() + " VND");
            System.out.println();
        } else {
            System.out.println("Sorry the seat is already reserved.");              // neu reservedSeat la false (status chua dinh nghia)
        }
    }

    public void cancelBooking() {
        int customerId;
        while (true) {
            try {
                System.out.println("Enter customer's ID:  ");
                customerId = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please try again! Use number only!");
            }
        }

        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                for (Booking booking : bookings) {
                    if (booking.getCustomer().getId() == customer.getId()) {
                        booking.unreservedSeat();
                        bookings.remove(booking);
                    }
                }
                System.out.println("Your reservation has been canceled!");
                return;
            }
        }
        System.out.println("ID not found");
        System.out.println();
    }

    public void checkBookingById() {
        int customerId;
        while (true) {
            try {
                System.out.println("Enter customer's ID:  ");
                customerId = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please try again! Use number only!");
            }
        }

        for(Booking booking : bookings){
            if(customerId == booking.getCustomer().getId()){
                System.out.println(booking.toString());
                return;
            }
        }System.out.println("ID not found");
    }

    public void writeBookingFile() {
        processBooking.write(bookings);
    }
}
