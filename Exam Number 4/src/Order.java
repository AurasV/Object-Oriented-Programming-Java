import java.util.List;

public class Order implements Comparable<Order>{
    private int orderId;
    private List<product> products;
    private float totalSum;
    private final long timestamp;

    public Order(int orderId, List<product> products, float totalSum, long timestamp) {
        this.orderId = orderId;
        this.products = products;
        this.totalSum = totalSum;
        this.timestamp = timestamp;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<product> getProducts() {
        return products;
    }

    public void setProducts(List<product> products) {
        this.products = products;
    }

    public float getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(float totalSum) {
        this.totalSum = totalSum;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String toString() {
        return "Order(orderId=" + orderId + ", products=" + products + ", totalSum=" + totalSum + ", timestamp=" + timestamp + ")";
    }

    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.orderId, o.orderId);
    }
}
