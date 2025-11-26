package CafeApp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

class InputHandler {
    MenuHandler menu;
    Cafe cafe;
    Client currentClient;
    Scanner sc;

    public InputHandler(MenuHandler menu, Cafe cafe) {
        this.menu = menu;
        this.cafe = cafe;
        this.currentClient = null;
        this.sc = new Scanner(System.in);
    }


    public void registerClient(String raw) {
        // raw expected like: "ShalqamZadeh, client"
        String[] parts = raw.split(",");
        if (parts.length < 2) {
            System.out.println("Invalid input. Use format: Name, role");
            return;
        }
        String name = parts[0].trim();
        String role = parts[1].trim().toLowerCase();
        String id = cafe.generateId();
        if (role.equals("admin")) {
            Client admin = new Client(name, id);
            cafe.addAdmin(admin);
            System.out.println("Welcome " + name + " Jaan!");
            System.out.println("Your id is: " + id);
        } else {
            Client client = new Client(name, id);
            cafe.addClient(client);
            System.out.println("Welcome " + name + " Jaan!");
            System.out.println("Your id is: " + id);
        }
    }

    public void signInClient(String id) {
        Client c = cafe.getClient(id);
        if (c == null) {
            System.out.println("Client not found.");
            return;
        }
        this.currentClient = c;

        boolean stay = true;
        while (stay) {
            menu.printClientMenu();
            String line = safeReadLine();
            int choice = parseInt(line, -1);
            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    cancelOrder();
                    break;
                case 3:
                    stay = false;
                    currentClient = null;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void signInAdmin(String id) {

        boolean found = false;
        for (Client a : cafe.admins) {
            if (a == null) continue;
            if (a.id.equals(id)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Admin not found.");
            return;
        }
        boolean stay = true;
        while (stay) {
            menu.printAdminMenu();
            String line = safeReadLine();
            int choice = parseInt(line, -1);
            switch (choice) {
                case 1:
                    menu.printClients(cafe);
                    break;
                case 2:
                    stay = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void addOrder() {
        if (currentClient == null) {
            System.out.println("No client signed in.");
            return;
        }

        for (int i = 0; i < cafe.getDrinksCount(); i++) {
            Drink d = cafe.getDrinkByIndex(i+1);
            System.out.println((i+1) + ". " + d.toString());
        }
        System.out.println((cafe.getDrinksCount()+1) + ". Back");

        String line = safeReadLine();
        int choice = parseInt(line, -1);
        if (choice == cafe.getDrinksCount() + 1) {
            // back
            return;
        }
        Drink selected = cafe.getDrinkByIndex(choice);
        if (selected == null) {
            System.out.println("Invalid choice.");
            return;
        }

        currentClient.orderDrink(new Drink(selected.name, selected.price));
        System.out.println("Order added.");
    }


    public void cancelOrder() {
        if (currentClient == null) {
            System.out.println("No client signed in.");
            return;
        }
        if (currentClient.getOrders().isEmpty()) {
            System.out.println("No active orders.");
            return;
        }

        DrinkLinkedList list = currentClient.getOrders();
        for (int i = 0; i < list.size(); i++) {
            Drink d = list.getAt(i);
            System.out.println((i+1) + ". " + d.toString());
        }
        System.out.println((list.size() + 1) + ". Back");

        String line = safeReadLine();
        int choice = parseInt(line, -1);
        if (choice == list.size() + 1) return;
        if (choice < 1 || choice > list.size()) {
            System.out.println("Invalid choice.");
            return;
        }
        boolean ok = currentClient.cancelOrder(choice - 1);
        if (ok) System.out.println("Order cancelled.");
        else System.out.println("Cancellation failed.");
    }

    public void showToMenu(String[] targetMenu) {
        for (int i = 0; i < targetMenu.length; i++) {
            System.out.println((i+1) + ". " + targetMenu[i]);
        }
    }

    public void showClientsList() {
        List<Client> clients = cafe.getClients();
        for (Client c : clients) {
            System.out.println(c.name + " - " + c.id);
        }
    }

    public void run() {
        boolean running = true;
        while (running) {
            menu.printFirstMenu();
            String line = safeReadLine();
            int choice = parseInt(line, -1);
            switch (choice) {
                case 1:
                    System.out.println("Enter your name and role:");
                    String raw = safeReadLine();
                    registerClient(raw);
                    break;
                case 2:
                    System.out.println("Enter your ID:");
                    String cid = safeReadLine();
                    signInClient(cid);
                    break;
                case 3:
                    System.out.println("Enter your ID:");
                    String aid = safeReadLine();
                    signInAdmin(aid);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        System.out.println("Exiting...");
    }

    private int parseInt(String s, int def) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return def;
        }
    }

    private String safeReadLine() {
        String line = "";
        try {
            line = sc.nextLine();
        } catch (NoSuchElementException e) {
            // EOF
        }
        return line;
    }
}
