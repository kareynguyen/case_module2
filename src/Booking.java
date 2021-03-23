public class Booking {
    private int cost;
    private Customer customer;
    private Movie movie;
    private int rowNumber;
    private int seatNumber;

    public Booking(Customer costumer, Movie movie) {
        this.customer = costumer;
        this.movie = movie;
    }

    public int getCost() {
            return cost += 70000;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean reservedSeat(int selectedRow, int selectedSeat) {
        if (movie.getRoom().getRows().get(selectedRow).getSeats().get(selectedSeat).getStatus()) {      // neu la status chua dinh nghia
            return false;                                                                               // thi tra ve false
        } else {
            movie.getRoom().getRows().get(selectedRow).getSeats().get(selectedSeat).reserve();          // nguoc lai thi la reserve, set so row va so seat
            setRowNumber(selectedRow);                                                                  // tra ve true;
            setSeatNumber(selectedSeat);
            return true;
        }
    }

    public boolean unreservedSeat() {
        movie.getRoom().getRows().get(rowNumber).getSeats().get(seatNumber).unreserved();
        return true;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "BOOKING\n" +
                customer +"\n" +
                movie +
                "Row number: " + (rowNumber+1) + "\n" +
                "Seat number: " + (seatNumber+1)+ "\n" +
                "Price: " + cost + "VND\n\n";

    }

    public String display() {
        return "BOOKING\n" +
                customer +"\n" +
                movie +
                "Row number: " + (rowNumber+1) + "\n" +
                "Seat number: " + (seatNumber+1)+ "\n";

    }
}
