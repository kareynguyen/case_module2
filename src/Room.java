import java.util.*;

public class Room {
    private String name;
    private int rowCount;
    private ArrayList<Row> rows = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void createRows(int seatCount, int rowCount) {
        for (int i = 1; i <= rowCount; i++) {
            Row row = new Row(seatCount, i);
            rows.add(row);
        }
    }

    public void displaySeatPosition() {
        System.out.println();
        int maxSeatsInRow = 0;
        for (Row row : getRows()) {
            if (row.getSeats().size() > maxSeatsInRow) {
                maxSeatsInRow = row.getSeats().size();          // lay ra so luong ghe max
            }
        }

        System.out.print("   |");

        for (int i = 1; i <= maxSeatsInRow; i++) {
            System.out.print(" " + i);
        }

        System.out.print("\n");
        System.out.print("----");

        for (int i = 1; i <= maxSeatsInRow; i++) {
            if (i > 9) {
                System.out.print("---");
            }
            else {
                System.out.print("--");
            }
        }
        System.out.print("\n");

        for (Row row : rows) {
            if (row.getRowNumber() > 9) {
                System.out.print(row.getRowNumber() + " | ");
            } else {
                System.out.print(row.getRowNumber() + "  | ");
            }
            for (Seat seat : row.getSeats()) {
                if (seat.getStatus()) {
                    System.out.print("X ");
                } else {
                    System.out.print(seat.getSeatNumber() + " ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    @Override
    public String toString() {
        return "Room name: " + name + "\n";
    }
}