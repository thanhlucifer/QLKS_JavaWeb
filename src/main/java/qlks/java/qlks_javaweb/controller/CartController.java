package qlks.java.qlks_javaweb.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import qlks.java.qlks_javaweb.model.CartItem;
import qlks.java.qlks_javaweb.model.Service;
import qlks.java.qlks_javaweb.service.CartService;
import qlks.java.qlks_javaweb.service.ServiceService;

import org.springframework.web.bind.annotation.*;



import java.util.List;

@Controller
@RequestMapping("/user/cart")
public class CartController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private CartService cartService;
    @GetMapping("")
    public String getCartItems(Model model) {
        List<CartItem> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems", cartItems);
// Calculate the total price
        long totalPrice = cartItems.stream()
                .mapToLong(cartItem -> (cartItem.getPrice() * cartItem.getQuantity()))
                .sum();
        model.addAttribute("totalPrice", totalPrice);
// Calculate cart count
        model.addAttribute("cartCount", cartItems.size());
        return "user/index";
    }

    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long id) {
        Service service = serviceService.get(id);
        if (service != null) {
            cartService.addToCart(service);
        }
        return "redirect:/user/cart";
    }

    @PostMapping("/update")
    public String updateCartItem(@RequestParam("id") Long id,
                                 @RequestParam("quantity") int quantity) {
        cartService.updateCartItem(id, quantity);
        return "redirect:/user/cart";
    }
    @PostMapping("/remove/{id}")
    public String removeFromCart(@PathVariable("id") Long id) {
        cartService.removeFromCart(id);
        return "redirect:/user/cart";
    }
}
