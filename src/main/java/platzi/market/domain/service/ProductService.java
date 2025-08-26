package platzi.market.domain.service;

import org.springframework.stereotype.Service;
import platzi.market.domain.mapper.Product;
import platzi.market.domain.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public List<Product> getScarseProducts(int quantity) {
        return productRepository.getScarseProducts(quantity).orElse(null);
    }

    public Product getProduct(int productId) {
        return productRepository.getProduct(productId).orElse(null);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {;
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }

}
