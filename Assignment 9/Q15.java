import java.util.*;
import java.util.stream.Collectors;

public class Q15 {
    public static void main(String[] args) {
        Fruit apple = new Fruit("Apple", 2.5);
        Fruit banana = new Fruit("Banana", 1.2);
        Fruit orange = new Fruit("Orange", 1.5);

        List<Customer> customers = Arrays.asList(
            new Customer("Aditya", Arrays.asList(apple, banana)),
            new Customer("Mukund", Arrays.asList(apple, orange)),
            new Customer("Chandrashekhar", Arrays.asList(banana, orange, apple))
        );

        Map<String, Double> totalSales = customers.stream()
            .flatMap(customer -> customer.getPurchasedFruits().stream())
            .collect(Collectors.groupingBy(
                Fruit::getName,
                Collectors.summingDouble(Fruit::getPrice)
            ));

        totalSales.forEach((fruitName, total) -> {
            System.out.println(fruitName + ": $" + total);
        });
    }
}

class Fruit {
     String name;
     double price;

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Customer {
     String name;
     List<Fruit> purchasedFruits;

    public Customer(String name, List<Fruit> purchasedFruits) {
        this.name = name;
        this.purchasedFruits = purchasedFruits;
    }

    public List<Fruit> getPurchasedFruits() {
        return purchasedFruits;
    }
}


