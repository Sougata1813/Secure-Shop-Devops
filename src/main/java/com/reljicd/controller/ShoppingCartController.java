package com.reljicd.service.impl;

import com.reljicd.model.Product;
import com.reljicd.model.ShoppingCart;
import com.reljicd.repository.ProductRepository;
import com.reljicd.repository.ShoppingCartRepository;
import com.reljicd.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository cartRepository;
    private final ProductRepository productRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ShoppingCart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProducts(Set<Product> products) {
        for (Product product : products) {
            productRepository.save(product);
        }
    }
}
