package CafeApp;

import java.util.List;

class MenuHandler {
    String[] firstMenu;
    String[] clientMenu;
    String[] adminMenu;

    public MenuHandler() {
        this.firstMenu = new String[] {"Signup", "Login Client", "Login Admin", "Exit"};
        this.clientMenu = new String[] {"Order drink", "Cancel order", "Log out"};
        this.adminMenu = new String[] {"Show clients & orders", "Back"};
    }

    public void printFirstMenu() {
        for (int i = 0; i < firstMenu.length; i++) {
            System.out.println((i+1) + ". " + firstMenu[i]);
        }
    }

    public void printClientMenu() {
        for (int i = 0; i < clientMenu.length; i++) {
            System.out.println((i+1) + ". " + clientMenu[i]);
        }
    }

    public void printAdminMenu() {
        for (int i = 0; i < adminMenu.length; i++) {
            System.out.println((i+1) + ". " + adminMenu[i]);
        }
    }


    public void printClients(Cafe targetCafe) {
        List<Client> clients = targetCafe.getClients();
        for (Client c : clients) {
            if (c.getOrders().isEmpty()) continue;
            System.out.println(c.name + " \u2013 " + c.id + ":");
            List<String> names = c.getOrders().toNameList();

            System.out.print("[");
            for (int i = 0; i < names.size(); i++) {
                System.out.print(names.get(i));
                if (i < names.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
        System.out.println("Back");
    }

    public void printAllOrders() {

    }

    public void printClientAllOrders(String clientId) {

    }
}
