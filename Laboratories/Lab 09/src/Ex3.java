import java.util.concurrent.atomic.AtomicInteger;
import java.util.LinkedList;
import java.util.List;

class Pizza {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    private final int id;
    private final int numberOfIngredients;

    public Pizza(int numberOfIngredients) {
        this.id = idGenerator.incrementAndGet();
        this.numberOfIngredients = numberOfIngredients;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }
}

class Kitchen {
    private final List<Pizza> pizzas = new LinkedList<>();

    //private final Object lock = new Object();

    public synchronized void addPizza(Pizza pizza) {
        pizzas.add(pizza);
        System.out.println("Pizza nr " + pizza.getId() + " was added with " + pizza.getNumberOfIngredients() + " ingredients.");
        notifyAll();
    }
    /*
    public void addPizza(Pizza pizza) {
        synchronized (lock) {
            pizzas.add(pizza);
            System.out.println("Pizza nr " + pizza.getId() + " was added with " + pizza.getNumberOfIngredients() + " ingredients.");
            lock.notifyAll();
        }
    }
    */

    public synchronized Pizza removePizza() {
        while (pizzas.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        Pizza pizza = pizzas.remove(0);
        System.out.println("Pizza nr " + pizza.getId() + " was removed.");
        System.out.println("-----------------------------");
        return pizza;
    }
    /*
    public Pizza removePizza() {
        synchronized (lock) {
            while (pizzas.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            Pizza pizza = pizzas.remove(0);
            System.out.println("Pizza nr " + pizza.getId() + " was removed.");
            return pizza;
        }
    }
    */
}

class Cook extends Thread {
    private final Kitchen kitchen;

    public Cook(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                int ingredients = 3 + (int) (Math.random() * 5);
                Pizza pizza = new Pizza(ingredients);
                kitchen.addPizza(pizza);
                int sleepTime = 5 + ingredients * 2;
                System.out.println("Sleeping for " + sleepTime + " milliseconds.");
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Waiter extends Thread {
    private final Kitchen kitchen;

    public Waiter(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Pizza pizza = kitchen.removePizza();
                if (pizza != null) {
                    Thread.sleep(10);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Ex3 {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        for (int i = 0; i < 3; i++) {
            new Cook(kitchen).start();
        }

        for (int i = 0; i < 4; i++) {
            new Waiter(kitchen).start();
        }
    }
}

/*
    Which is the shared resource?
    The shared resource is the Kitchen and the pizzas

    What methods are synchronized?
    The methods that are synchronized are addPizza and removePizza

    How can you ensure that Pizzas have unique ids?
    We can ensure that Pizzas have unique ids by using an AtomicInteger

    Try using synchronized blocks instead of synchronized methods.
    The synchronized blocks are commented out in the code
*/