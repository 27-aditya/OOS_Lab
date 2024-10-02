public class Q5 {
    public static void main(String[] args) {
        Puppy p1 = new Puppy("Max", 1, "Golden Retriever", "Maxxy");
        p1.sound();
    }
}

class Animal{
    private String name;

    public Animal(String name){
        this.name = name;
    }

    public void sound(){
        System.out.println("Animal sound called");
        System.out.println("Name: " + name);
    }
}

class Mammal extends Animal{
    private int age;

    public Mammal(String name, int age){
        super(name);
        this.age = age;
    }

    public void sound(){
        super.sound();
        System.out.println("Mammal sound called");
        System.out.println("Age: " + age);
    }
}

class Dog extends Mammal{
    private String breed;
    public Dog(String name, int age, String breed){
        super(name, age);
        this.breed = breed;
    }

    public void sound(){
        super.sound();
        System.out.println("Dog sound called");
        System.out.println("Breed: " + breed);
    }
}

class Puppy extends Dog{
    private String nickName;

    public Puppy(String name, int age, String breed, String nickName){
        super(name, age, breed);
        this.nickName = nickName;
    }

    public void sound(){
        super.sound();
        System.out.println("Puppy class called");
        System.out.println("Nickname: " + nickName);
    }
}