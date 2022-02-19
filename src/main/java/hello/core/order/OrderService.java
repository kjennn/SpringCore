package hello.core.order;

public interface OrderService {
    Order createOrder(Long memerId, String itemName, int itemPrice);
}
