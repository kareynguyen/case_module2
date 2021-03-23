import java.util.*;

public class Row {
    private ArrayList<Seat> seats = new ArrayList<>();
    private int rowNumber;
    private int seatCount;

    public Row(int seatCount, int rowNumber) {
        this.rowNumber = rowNumber;
        this.seatCount = seatCount;
        createSeats(this.seatCount);
    }

    public void createSeats(int seatCount) {
        for (int i = 1; i <= seatCount; i++) {
            Seat seat = new Seat(false, i);
            seats.add(seat);
        }
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }
}