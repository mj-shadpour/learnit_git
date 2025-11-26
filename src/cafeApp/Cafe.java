package CafeApp;

import java.util.ArrayList;
import java.util.List;

class Cafe {
    Client[] admins;
    Client[] clients;
    Drink[] drinks;

    private int adminsCount;
    private int clientsCount;
    private int drinksCount;

    private int nextId;

    public Cafe(int maxAdmins, int maxClients, int maxDrinks) {
        this.admins = new Client[maxAdmins];
        this.clients = new Client[maxClients];
        this.drinks = new Drink[maxDrinks];
        this.adminsCount = 0;
        this.clientsCount = 0;
        this.drinksCount = 0;
        this.nextId = 1;
    }


    public String generateId() {
        int id = nextId;
        nextId++;
        return String.valueOf(id);
    }

    public void addClient(Client newClient) {
        if (clientsCount >= clients.length) {
            System.out.println("Clients storage full.");
            return;
        }
        clients[clientsCount++] = newClient;
    }

    public void addAdmin(Client newAdmin) {
        if (adminsCount >= admins.length) {
            System.out.println("Admins storage full.");
            return;
        }
        admins[adminsCount++] = newAdmin;
    }

    public void removeClient(Client targetClient) {
        for (int i = 0; i < clientsCount; i++) {
            if (clients[i] != null && clients[i].id.equals(targetClient.id)) {
                // shift left
                for (int j = i; j < clientsCount - 1; j++) clients[j] = clients[j + 1];
                clients[clientsCount - 1] = null;
                clientsCount--;
                return;
            }
        }
    }

    public void addDrink(Drink d) {
        if (drinksCount >= drinks.length) {
            System.out.println("Drinks storage full.");
            return;
        }
        drinks[drinksCount++] = d;
    }

    public void showCafeMenu() {
        for (int i = 0; i < drinksCount; i++) {
            System.out.println(drinks[i].toString());
        }
    }

    public Client getClient(String clientId) {
        for (int i = 0; i < clientsCount; i++) {
            if (clients[i].id.equals(clientId)) return clients[i];
        }
        return null;
    }


    public List<Client> getClients() {
        List<Client> out = new ArrayList<>();
        for (int i = 0; i < clientsCount; i++) if (clients[i] != null) out.add(clients[i]);
        return out;
    }


    public Drink getDrinkByIndex(int index1Based) {
        int idx = index1Based - 1;
        if (idx < 0 || idx >= drinksCount) return null;
        return drinks[idx];
    }

    public int getDrinksCount() { return drinksCount; }
}
