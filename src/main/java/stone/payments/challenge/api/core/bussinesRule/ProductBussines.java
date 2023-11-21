package stone.payments.challenge.api.core.bussinesRule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import stone.payments.challenge.api.adapters.dto.ProductDTO;
import stone.payments.challenge.api.core.domain.Product;
import stone.payments.challenge.api.infrastructure.exception.ProductAlreadyRegisteresException;
import stone.payments.challenge.api.infrastructure.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductBussines {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) throws ProductAlreadyRegisteresException {

        if (productRepository.findByTitle(product.getTitle()).isPresent()) {
            throw new ProductAlreadyRegisteresException(product.getTitle());
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }
}
