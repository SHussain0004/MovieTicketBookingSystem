import java.util.*;

class Movie {
    private int id;
    private String title;
    private int duration;

    public Movie(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getDuration() { return duration; }
}

class Seat {
    private int seatNumber;
    private boolean booked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.booked = false;
    }

    public int getSeatNumber() { return seatNumber; }
    public boolean isBooked() { return booked; }

    public void bookSeat() {
        this.booked = true;
    }
}

class Show {
    private int showId;
    private Movie movie;
    private String time;
    private List<Seat> seats;

    public Show(int showId, Movie movie, String time, int totalSeats) {
        this.showId = showId;
        this.movie = movie;
        this.time = time;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public int getShowId() { return showId; }
    public Movie getMovie() { return movie; }
    public String getTime() { return time; }
    public List<Seat> getSeats() { return seats; }

    public Seat getSeat(int seatNumber) {
        return seats.get(seatNumber - 1);
    }
}

class Booking {
    private int bookingId;
    private Show show;
    private List<Seat> bookedSeats;

    public Booking(int bookingId, Show show) {
        this.bookingId = bookingId;
        this.show = show;
        this.bookedSeats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        if (!seat.isBooked()) {
            seat.bookSeat();
            bookedSeats.add(seat);
        }
    }

    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Movie: " + show.getMovie().getTitle());
        System.out.println("Show Time: " + show.getTime());
        System.out.print("Seats Booked: ");
        for (Seat s : bookedSeats) {
            System.out.print(s.getSeatNumber() + " ");
        }
        System.out.println();
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Movie m1 = new Movie(1, "Inception", 148);
        Movie m2 = new Movie(2, "Interstellar", 169);

        Show s1 = new Show(101, m1, "10:00 AM", 10);
        Show s2 = new Show(102, m2, "2:00 PM", 10);

        List<Show> shows = Arrays.asList(s1, s2);

        System.out.println("Available Shows:");
        for (Show s : shows) {
            System.out.println(s.getShowId() + " - " + s.getMovie().getTitle() + " at " + s.getTime());
        }

        System.out.print("Enter Show ID: ");
        int showId = sc.nextInt();

        Show selectedShow = null;
        for (Show s : shows) {
            if (s.getShowId() == showId) {
                selectedShow = s;
                break;
            }
        }

        if (selectedShow == null) {
            System.out.println("Invalid Show ID");
            return;
        }

        System.out.println("Available Seats:");
        for (Seat seat : selectedShow.getSeats()) {
            if (!seat.isBooked()) {
                System.out.print(seat.getSeatNumber() + " ");
            }
        }
        System.out.println();

        Booking booking = new Booking(1, selectedShow);

        System.out.print("How many seats to book? ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter seat number: ");
            int seatNo = sc.nextInt();
            booking.addSeat(selectedShow.getSeat(seatNo));
        }

        booking.displayBooking();
        sc.close();
    }
}
