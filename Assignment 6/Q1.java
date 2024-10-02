import java.util.*;

public class Q1{
    public static void main(String[] args) {
        EcommmerceApplication E = new EcommmerceApplication();
        
        System.out.println("Total Order: " + E.calculateTotalPrice(12, 5));
        System.out.println("Discounted Order: " + E.calculateTotalPrice(E.calculateTotalPrice(5, 10), 10));

        ArrayList<Integer> q = new ArrayList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        ArrayList<Integer> p = new ArrayList<>();
        p.add(12);
        p.add(25);
        p.add(35);

        System.out.println("Total order: " + E.calculateTotalPrice(q, p));
    }
}

class EcommmerceApplication{
    public EcommmerceApplication(){

    }
    
    public int calculateTotalPrice(int quantity, int price){
        return quantity*price;
    }

    public int calculateTotalPrice(ArrayList<Integer>quantity, ArrayList<Integer>prices){
        int total = 0;

        for(int i = 0; i < quantity.size(); i++){
            total += quantity.get(i)*prices.get(i);
        }

        return total;
    }

    public int calculateTotalPrice(int orderPrice, double discount){
        return (int) (orderPrice - (orderPrice*discount)/100);
    }
}