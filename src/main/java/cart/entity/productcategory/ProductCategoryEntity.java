package cart.entity.productcategory;

import java.util.Objects;

public final class ProductCategoryEntity {

    private final Long id;
    private final Long productId;
    private final Long categoryId;

    public ProductCategoryEntity(final Long productId, final Long categoryId) {
        this(null, productId, categoryId);
    }

    public ProductCategoryEntity(final Long id, final Long productId, final Long categoryId) {
        this.id = id;
        this.productId = productId;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ProductCategoryEntity that = (ProductCategoryEntity) o;
        return Objects.equals(productId, that.productId) && Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, categoryId);
    }
}
