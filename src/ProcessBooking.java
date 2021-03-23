import java.io.*;
import java.util.ArrayList;

public class ProcessBooking {
    public void write(ArrayList<Booking> bookings) {
        try {
            FileWriter writer = new FileWriter("Bookinglist.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i < bookings.size(); i++) {
                bufferedWriter.write(bookings.get(i).toString());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
