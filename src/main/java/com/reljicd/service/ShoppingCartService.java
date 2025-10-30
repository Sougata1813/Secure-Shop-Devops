package com.reljicd.service.impl;

import com.reljicd.model.Product;
import com.reljicd.model.ShoppingCart;
import com.reljicd.repository.ProductRepository;
import com.reljicd.repository.ShoppingCartRepository;
import com.reljicd.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ShoppingCart getCart() {
        return shoppingCartRepository.findAll().iterator().hasNext()
                ? shoppingCartRepository.findAll().iterator().next()
                : shoppingCartRepository.save(new ShoppingCart());
    }

    @Override
    public void addProduct(Long productId) {
        ShoppingCart cart = getCart();
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isPresent()) {
            Set<Product> products = cart.getProducts();
            if (products == null) {
                products = new HashSet<>();
            }
            products.add(productOpt.get());
            cart.setProducts(products);
            shoppingCartRepository.save(cart);
        }
    }

    @Override
    public void removeProduct(Long productId) {
        ShoppingCart cart = getCart();
        if (cart.getProducts() != null) {
            cart.getProducts().removeIf(p -> p.getId().equals(productId));
            shoppingCartRepository.save(cart);
        }
    }

    @Override
    public void clearCart() {
        ShoppingCart cart = getCart();
        cart.setProducts(new HashSet<>());
        shoppingCartRepository.save(cart);
    }
}
