package StoreManagment;

public abstract class Product {
    public String name ;
    public int id ;
    public int price;

    int getPrice(){
        return price;
    }
    String getName(){
      return name;
    }
    int getId(){
        return id;
    }
}



