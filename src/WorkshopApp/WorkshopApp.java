package WorkshopApp;

import java.util.ArrayList;

class WorkshopApp {
    ArrayList<Workshop> workshops = new ArrayList<>();
    ArrayList<Registration> registrations = new ArrayList<>();

    void addWorkshop(Workshop w) {
        for (Workshop x : workshops) {
            if (x.id == w.id) {
                System.out.println("Duplicate workshop ID.");
                return;
            }
        }
        workshops.add(w);
        System.out.println("Workshop added successfully.");
    }

    Workshop find(int id) {
        for (Workshop w : workshops) if (w.id == id) return w;
        return null;
    }

    int register(int workshopId, String name) {
        Workshop w = find(workshopId);
        if (w == null) {
            System.out.println("Workshop not found.");
            return -1;
        }

        if (w.hasSeat()) {
            int conf = (int)(Math.random() * 900000) + 100000;
            Registration r = new Registration(conf, workshopId, name);
            w.attendees.add(r);
            registrations.add(r);
            System.out.println("Registered successfully! Confirmation number: " + conf);
            return conf;
        } else {
            w.waitlist.add(name);
            System.out.println("Added to waitlist.");
            return -1;
        }
    }

    boolean cancel(int confirmationNumber) {
        Registration target = null;
        for (Registration r : registrations) {
            if (r.confirmationNumber == confirmationNumber) {
                target = r;
                break;
            }
        }

        if (target == null) {
            System.out.println("No registration found.");
            return false;
        }

        Workshop w = find(target.workshopId);
        if (w != null) w.attendees.removeIf(r -> r.confirmationNumber == confirmationNumber);
        registrations.removeIf(r -> r.confirmationNumber == confirmationNumber);

        if (!w.waitlist.isEmpty()) {
            String next = w.waitlist.remove(0);
            int newConf = (int)(Math.random() * 900000) + 100000;
            Registration nr = new Registration(newConf, w.id, next);
            w.attendees.add(nr);
            registrations.add(nr);
            System.out.println("Registered from waitlist! Confirmation number: " + newConf);
        }

        return true;
    }

    void status(int workshopId) {
        Workshop w = find(workshopId);
        if (w == null) {
            System.out.println("Workshop not found.");
            return;
        }

        System.out.println("Workshop #" + w.id + " - " + w.title);
        System.out.println("Date: " + w.date);
        System.out.println("Capacity: " + w.capacity);
        System.out.println("Enrolled: " + w.enrolledCount());
        System.out.println("Waitlist: " + w.waitlist.size());
        System.out.println("Revenue: " + w.revenue());
    }
}