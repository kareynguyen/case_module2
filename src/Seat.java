public class Seat {
    private boolean isReserved;
    private int seatNumber;

    public Seat(boolean isReserved, int seatNumber) {
        this.isReserved = isReserved;
        this.seatNumber = seatNumber;
    }

    public boolean getStatus() {
        return isReserved;
    }

    public void reserve() {
        isReserved = true;
    }

    public void unreserved() {
        isReserved = false;
    }
    public int getSeatNumber() {
        return this.seatNumber;
    }
}