public class Movie {
    private String movieName;
    private String showDate;
    private Room room;

    public Movie(String movieName, String showDate, Room room) {
        this.movieName = movieName;
        this.showDate = showDate;
        this.room = room;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getShowDate() {
        return showDate;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "MOVIE\n" +
                "Movie name: " + movieName + '\n' +
                "Show date: " + showDate + '\n' +
                getRoom().toString();
    }
}