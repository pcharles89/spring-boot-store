package com.paul.store.services;

import com.paul.store.entities.Address;
import com.paul.store.entities.Category;
import com.paul.store.entities.Product;
import com.paul.store.entities.User;
import com.paul.store.repositories.AddressRepository;
import com.paul.store.repositories.CategoryRepository;
import com.paul.store.repositories.ProductRepository;
import com.paul.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public UserService(AddressRepository addressRepository, UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public void fetchAddress(){
        var address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated(){
        User user = new User();
        user.setName("example1");
        user.setEmail("example@example.com");
        user.setPassword("password");

        var address = Address.builder()
                .street("street")
                .city("city")
                .state("state")
                .zip("zip")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated(){
        var user = userRepository.findById(3L).orElseThrow();
        var address = user.getAddresses().get(0);
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void manageProducts() {
        Category category = categoryRepository
                .findByName("Category 1")
                .orElseGet(() -> categoryRepository.save(new Category("Category 1")));

        Product product = Product.builder()
                .name("Product 1")
                .description("description 1")
                .price(BigDecimal.valueOf(10.99))
                .category(category)
                .build();

        productRepository.save(product);
    }

    public void fetchProducts(){
        var products = productRepository.findByCategory(new Category((byte) 1));
        products.forEach(p -> System.out.println(p.getId() + " - " + p.getName()));
    }

    public void fetchUser(){
        User user = userRepository.findByEmail("paul@gmail.com").orElseThrow();
        System.out.println(user);
    }

    @Transactional
    public void fetchUsers(){
        var users = userRepository.findAllWithAddresses();
        users.forEach(u ->{
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }

    public void fetchProductsByCritera(){
       var products = productRepository.findProductsByCriteria(null, BigDecimal.valueOf(1), BigDecimal.valueOf(10));
       products.forEach(System.out::println);
    }
}
