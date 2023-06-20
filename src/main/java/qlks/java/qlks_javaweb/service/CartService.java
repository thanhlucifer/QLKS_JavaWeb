package qlks.java.qlks_javaweb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import qlks.java.qlks_javaweb.model.CartItem;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class CartService {
    private List<CartItem> cartItems = new ArrayList<>();
    public List<CartItem> getCartItems() {
        return cartItems;
    }
    public void clearCart() {
        cartItems.clear();
    }

    public void addToCart(qlks.java.qlks_javaweb.model.Service service) {

        CartItem findCart = cartItems.stream()
                .filter(item -> item.getId().equals(service.getId()))
                .findFirst().orElse(null);
        if(findCart != null)
        {
            findCart.setQuantity(findCart.getQuantity()+1);
        }
        else
        {
            System.out.print("case item = null");
            findCart = new CartItem();
            findCart.setQuantity(1);

            findCart.setId(service.getId());
            findCart.setName(service.getName());
            findCart.setPrice(service.getPrice());

            cartItems.add(findCart);
        }
    }
    public void updateCartItem(Long id, int quantity) {
        CartItem findCart = cartItems.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
        if(findCart != null)
        {
            findCart.setQuantity(quantity);
        }
    }
    public void removeFromCart(Long id) {
        cartItems.removeIf(cartItem -> cartItem.getId().equals(id));
    }
}
