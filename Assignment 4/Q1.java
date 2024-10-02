import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        Inventory<Electronics> electronicsInventory = new Inventory<>();

        Electronics laptop = new Electronics("Laptop", 24);
        Electronics smartphone = new Electronics("Smartphone", 12);

        electronicsInventory.addProduct(laptop);
        electronicsInventory.addProduct(smartphone);

        System.out.println("Electronics Inventory:");
        electronicsInventory.listProducts();

        Inventory<Clothing> clothingInventory = new Inventory<>();

        Clothing tshirt = new Clothing("T-Shirt", "L");
        Clothing jeans = new Clothing("Jeans", "M");

        clothingInventory.addProduct(tshirt);
        clothingInventory.addProduct(jeans);

        System.out.println("\nClothing Inventory:");
        clothingInventory.listProducts();

        electronicsInventory.removeProduct(laptop);

        System.out.println("\nElectronics Inventory after removal:");
        electronicsInventory.listProducts();
    }    
}

class Product{
    String name;

    public Product(String name){
        this.name = name;
    }

    public void displayProduct(){
        System.out.println("Name: " + name);
    }
}

class Electronics extends Product{
    int warrantyPeriod;

    public Electronics(String name, int warrantyPeriod){
        super(name);
        this.warrantyPeriod = warrantyPeriod;
    }

    public void displayElectronics(){
        super.displayProduct();
        System.out.println("Warranty: " + warrantyPeriod);
    }
}

class Clothing extends Product{
    String size;

    public Clothing(String name, String size){
        super(name);
        this.size = size;
    }

    public void displayClothing(){
        super.displayProduct();
        System.out.println("Size: " + size);
    }
}

class Inventory<T extends Product>{
    private ArrayList<T> products;

    public Inventory(){
        this.products = new ArrayList<>();
    }

    public void addProduct(T product){
        products.add(product);
    }

    public void removeProduct(T product){
        products.remove(product);
    }

    public void listProducts(){
        for(T product : products){
            product.displayProduct();
        }
    }
} 
