package WorkshopApp;
public class Main {
    public static void main(String[] args) {
        WorkshopApp app = new WorkshopApp();

        Workshop w1 = new Workshop(1, "Java Basics", 3);
        Workshop w2 = new Workshop(2, "OOP Advanced", 2);

        app.addWorkshop(w1);
        app.addWorkshop(w2);

        app.register(1, "Ali");
        app.register(1, "Sara");
        app.register(1, "Nima");
        app.register(1, "Mina"); // لیست انتظار

        app.status(1);
        app.cancel(123456); // شماره فرضی
    }
}