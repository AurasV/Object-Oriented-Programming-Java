import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Order_main {
    public static void main(String[] args) {
        List<product> products = List.of(
            new product(1, "product1", 1.0f, 1),
            new product(2, "product2", 2.0f, 2)
        );
        Order order = new Order(1, products, 0, 234);
        Order order1 = new Order(2, products, 0, System.currentTimeMillis());
        Order order2 = new Order(1, products, 0, 234);
        LinkedList<Order> orders = new LinkedList<>();
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        System.out.println("--------------------------------------------------------");
        System.out.println("LinkedList");
        System.out.println(orders);
        HashSet<Order> orderSet = new HashSet<>();
        orderSet.add(order);
        orderSet.add(order1);
        orderSet.add(order2);
        orderSet.add(order2);
        System.out.println("--------------------------------------------------------");
        System.out.println("HashSet");
        System.out.println(orderSet);
        TreeSet<Order> orderTreeSet = new TreeSet<>();
        orderTreeSet.add(order);
        orderTreeSet.add(order1);
        orderTreeSet.add(order2);
        System.out.println("--------------------------------------------------------");
        System.out.println("TreeSet");
        System.out.println(orderTreeSet);
    }
}
