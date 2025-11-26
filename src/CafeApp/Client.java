package CafeApp;

class Client {
    String name;
    String id;
    DrinkLinkedList orders;

    public Client(String name, String id) {
        this.name = name;
        this.id = id;
        this.orders = new DrinkLinkedList();
    }


    public void orderDrink(Drink newOrder) {
        this.orders.add(newOrder);
    }


    public boolean cancelOrder(int index) {
        Drink removed = this.orders.removeAt(index);
        return removed != null;
    }

    public DrinkLinkedList getOrders() {
        return this.orders;
    }
}
