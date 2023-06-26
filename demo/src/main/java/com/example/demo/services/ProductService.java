package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) throws ChangeSetPersister.NotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) throws ChangeSetPersister.NotFoundException {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setProductType(product.getProductType());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setInDate(product.getInDate());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) throws ChangeSetPersister.NotFoundException {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
