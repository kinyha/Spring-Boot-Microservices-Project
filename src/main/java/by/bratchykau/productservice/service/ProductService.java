package by.bratchykau.productservice.service;

import by.bratchykau.productservice.dto.ProductRequest;
import by.bratchykau.productservice.model.Product;
import by.bratchykau.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        //log.info("Product " + product.getId() + " is saved");
        log.info("Product {} is saved", product.getId());
    }
}
