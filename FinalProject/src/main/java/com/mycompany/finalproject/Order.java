import java.util.Random;

public class Order {

    private int id;
    private OrderState state;
    private Random random = new Random();

    public Order() {
        this.id = random.nextInt();
        state = OrderState.NEW;
    }

    public int getId() {
        return id;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
}
