package stone.payments.challenge.api.adapters.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stone.payments.challenge.api.adapters.dto.ProductDTO;
import stone.payments.challenge.api.core.bussinesRule.ProductBussines;
import stone.payments.challenge.api.core.domain.Product;
import stone.payments.challenge.api.infrastructure.exception.ProductAlreadyRegisteresException;

@RequestMapping
@RestController
@SecurityRequirement(name = "bearer-key")

public class ProductController {

    @Autowired
    private ProductBussines productBussines;

    @PostMapping("/starstore/products")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid ProductDTO data) throws ProductAlreadyRegisteresException {

        Product newProduct = new Product(data);
        var product = productBussines.createProduct(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/starstore/products")
    public ResponseEntity getAll(){
        var allProducts = productBussines.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }
}
