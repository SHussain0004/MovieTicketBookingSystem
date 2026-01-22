# Movie Ticket Booking System – Code Explanation

---

## File: `MovieBookingSystem.java`

### Imports

* `import java.util.*;`

  * Provides collections (`List`, `ArrayList`, `Arrays`) and input handling (`Scanner`).

---

## Class: `Movie`

### Purpose

Represents a movie entity with basic details.

### Data Members

* `id` : Unique movie identifier
* `title` : Movie name
* `duration` : Length of the movie in minutes

### Constructor

* Initializes movie attributes when an object is created.

### Methods

* `getId()` : Returns movie ID
* `getTitle()` : Returns movie title
* `getDuration()` : Returns movie duration

---

## Class: `Seat`

### Purpose

Represents an individual seat in a show.

### Data Members

* `seatNumber` : Unique seat number
* `booked` : Booking status of the seat

### Constructor

* Sets seat number and initializes booking status to false.

### Methods

* `getSeatNumber()` : Returns seat number
* `isBooked()` : Checks whether seat is booked
* `bookSeat()` : Marks seat as booked

---

## Class: `Show`

### Purpose

Represents a movie show at a specific time.

### Data Members

* `showId` : Unique show identifier
* `movie` : Movie associated with the show
* `time` : Show timing
* `seats` : List of seats for the show

### Constructor

* Assigns show details
* Creates seat objects based on total seat count

### Methods

* `getShowId()` : Returns show ID
* `getMovie()` : Returns associated movie
* `getTime()` : Returns show timing
* `getSeats()` : Returns seat list
* `getSeat(int seatNumber)` : Returns a specific seat object

---

## Class: `Booking`

### Purpose

Handles ticket booking for a selected show.

### Data Members

* `bookingId` : Unique booking identifier
* `show` : Show for which booking is made
* `bookedSeats` : List of booked seats

### Constructor

* Initializes booking with show reference

### Methods

* `addSeat(Seat seat)` : Books seat if available and adds to booking list
* `displayBooking()` : Displays booking details

---

## Class: `MovieBookingSystem` (Main Class)

### Purpose

Controls the execution flow of the application.

### Main Method Flow

1. Creates movie objects
2. Creates show objects linked to movies
3. Displays available shows
4. Accepts user-selected show ID
5. Displays available seats for selected show
6. Accepts number of seats to book
7. Books selected seats
8. Displays final booking details

---

## Relationships Used

* Show → Movie : Association
* Show → Seat : Composition
* Booking → Show : Aggregation

---

## Execution

* Compile: `javac MovieBookingSystem.java`
* Run: `java MovieBookingSystem`
