package CafeApp;

public class CafeApp {
    public static void main(String[] args) {

        Cafe cafe = new Cafe(50, 200, 50);
        MenuHandler menu = new MenuHandler();
        InputHandler handler = new InputHandler(menu, cafe);


        cafe.addDrink(new Drink("Tea", 45000));
        cafe.addDrink(new Drink("Milk", 38000));
        cafe.addDrink(new Drink("Coffee", 99990));
        cafe.addDrink(new Drink("Shake", 81000));
        cafe.addDrink(new Drink("Watermelon juice", 16000));
        cafe.addDrink(new Drink("Water", 12000));
        handler.run();
    }
}
