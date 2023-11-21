package stone.payments.challenge.api.adapters.dto;

import stone.payments.challenge.api.core.domain.Product;

public record ProductDTO(
        Long id,
        String title,
        Integer price,
        String zipcode,
        String seller,
        String thumbnailHd,
        String date
) {
    public ProductDTO(Product product) {
        this(product.getId(), product.getTitle(), product.getPrice(), product.getZipcode(), product.getSeller(),
                product.getThumbnailHd(), product.getDate());
    }
}
