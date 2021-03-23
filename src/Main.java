import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Manager manager = new Manager();
    public static void main(String[] args) {
        while (true){
            try{
                int option;
                do {
                    menu();
                    option = Integer.parseInt(sc.nextLine());
                    switch (option){
                        case 1:
                            System.out.println("ADD ROOM Selected");
                            System.out.println("-------------------------\n");
                            manager.addRoom();
                            break;
                        case 2:
                            System.out.println("ADD MOVIE Selected");
                            System.out.println("-------------------------");
                            manager.addMovie();
                            break;
                        case 3:
                            System.out.println("DISPLAY SHOWS Selected");
                            System.out.println("-------------------------\n");
                            manager.displayMovie();
                            break;
                        case 4:
                            System.out.println("MAKE BOOKING Selected");
                            System.out.println("-------------------------\n");
                            manager.makeBooking();
                            break;
                        case 5:
                            System.out.println("CANCEL BOOKING Selected");
                            System.out.println("-------------------------\n");
                            manager.cancelBooking();
                            break;
                        case 6:
                            System.out.println("CHECK BOOKING Selected");
                            System.out.println("-------------------------\n");
                            manager.checkBookingById();
                            break;
                        case 7:
                            System.out.println("PRINT BOOKING Selected");
                            System.out.println("-------------------------\n");
                            manager.writeBookingFile();
                            break;
                        case 8:
                            System.exit(0);
                            break;
                    }
                } while (option != 8);
            }catch (Exception e){
                e.getMessage();
            }
        }
    }

    public static void menu() {
        System.out.println("----------------------------------------");
        System.out.println("WELCOME TO BETA CINEMA BOOKING SYSTEM!!!");
        System.out.println("----------------------------------------\n");
        System.out.println("1. Add Room");
        System.out.println("2. Add Movie");
        System.out.println("3. Display Shows");
        System.out.println("4. Make Booking");
        System.out.println("5. Cancel Booking");
        System.out.println("6. Check Booking");
        System.out.println("7. Print Booking");
        System.out.println("8. Exit\n");
        System.out.print("Enter your option: ");
    }
}