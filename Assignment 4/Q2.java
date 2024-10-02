import java.util.ArrayList;
import java.util.List;  
import java.util.stream.Collectors;

public class Q2 {
    public static void main(String[] args) {
        HierarchicalManager<Entity> hierarchicalManager = new HierarchicalManager<>(); 

        Employee employee1 = new Employee("John Doe");
        Manager manager1 = new Manager("Jane Smith");
        Employee employee2 = new Employee("Alice Johnson");

        hierarchicalManager.addEntity(employee1);
        hierarchicalManager.addEntity(manager1);
        hierarchicalManager.addEntity(employee2);

        System.out.println("Hierarchy:");
        hierarchicalManager.printHierarchy();

        System.out.println("\nAll Entities:");
        for (Entity entity : hierarchicalManager.getAllEntities()) {
            entity.displayEntity();
        }

        System.out.println("\nManagers:");
        for (Manager manager : hierarchicalManager.getEntitiesByType(Manager.class)) {
            manager.displayEntity();
        }

        hierarchicalManager.removeEntity(employee1);
        System.out.println("\nHierarchy after removal:");
        hierarchicalManager.printHierarchy();
    }
}

class Entity {
    String name;

    public Entity(String name) {
        this.name = name;
    }

    public void displayEntity() {
        System.out.println("Name: " + name);
    }
}

class Employee extends Entity {
    public Employee(String name) {
        super(name);
    }

    @Override
    public void displayEntity() {
        System.out.println("Employee name: " + name);
    }
}

class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void displayEntity() {
        System.out.println("Manager name: " + name);
    }
}

class HierarchicalManager<T extends Entity> { 
    private List<T> entities;  

    public HierarchicalManager() { 
        this.entities = new ArrayList<>();
    }

    public void addEntity(T entity) {
        entities.add(entity);
    }

    public void removeEntity(T entity) {
        entities.remove(entity);
    }

    public List<T> getAllEntities() {
        return new ArrayList<>(entities);
    }

    public List<T> getEntitiesByType(Class<? extends T> type) {
        List<T> result = new ArrayList<>();
        for (T entity : entities) {
            if (type.isInstance(entity)) {
                result.add(entity);
            }
        }
        return result;
    }

    public void printHierarchy() {
        for (T entity : entities) {
            entity.displayEntity();
            System.out.println("------");
        }
    }
}
