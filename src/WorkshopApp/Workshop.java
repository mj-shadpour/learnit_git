package WorkshopApp;

import java.util.ArrayList;

class Workshop {
    int id;
    String title;
    String date;
    int capacity;
    double price;

    ArrayList<Registration> attendees = new ArrayList<>();
    ArrayList<String> waitlist = new ArrayList<>();

    public Workshop(int id, String title, String date, int capacity, double price) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.capacity = capacity;
        this.price = price;
    }

    public Workshop(int id, String title, int capacity) {
        this(id, title, "TBD", capacity, 0);
    }

    public Workshop(Workshop other) {
        this.id = other.id;
        this.title = other.title;
        this.date = other.date;
        this.capacity = other.capacity;
        this.price = other.price;
        for (Registration r : other.attendees) this.attendees.add(new Registration(r));
        this.waitlist = new ArrayList<>(other.waitlist);
    }

    boolean hasSeat() {
        return attendees.size() < capacity;
    }

    int enrolledCount() {
        return attendees.size();
    }

    double revenue() {
        return attendees.size() * price;
    }

    void printRoster() {
        System.out.println("Attendees:");
        for (Registration r : attendees) System.out.println(r);
        System.out.println("Waitlist:");
        for (String w : waitlist) System.out.println(w);
    }
}

