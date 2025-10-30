package com.reljicd.controller;

import com.reljicd.model.Product;
import com.reljicd.model.ShoppingCart;
import com.reljicd.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("cart", shoppingCartService.getCart());
        return "cart"; // returns cart.html or cart.jsp
    }

    @PostMapping("/add/{productId}")
    public String addProduct(@PathVariable Long productId) {
        shoppingCartService.addProduct(productId);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{productId}")
    public String removeProduct(@PathVariable Long productId) {
        shoppingCartService.removeProduct(productId);
        return "redirect:/cart";
    }

    @PostMapping("/clear")
    public String clearCart() {
        shoppingCartService.clearCart();
        return "redirect:/cart";
    }
}
