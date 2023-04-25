package cart.dao;

import static org.assertj.core.api.Assertions.assertThat;

import cart.entity.product.ProductEntity;
import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

@JdbcTest
class ProductDaoTest {

    @Autowired
    private DataSource dataSource;

    private ProductDao productDao;

    @BeforeEach
    void setUp() {
        productDao = new ProductDao(dataSource);
    }

    @Test
    @DisplayName("상품을 DB에 저장한다.")
    void save() {
        //given
        final ProductEntity productEntity = new ProductEntity(
            null,
            "다즐",
            "스플릿.com",
            10000000,
            "다즐짱"
        );

        //when
        final Long savedProductId = productDao.save(productEntity);

        //then
        assertThat(savedProductId).isNotNull();
    }

    @Test
    @DisplayName("모든 상품을 조회한다.")
    void findAll() {
        //given
        final ProductEntity firstProductEntity = new ProductEntity(
            null,
            "다즐",
            "스플릿.com",
            10000000,
            "다즐짱"
        );
        final ProductEntity secondProductEntity = new ProductEntity(
            null,
            "다즐",
            "스플릿.com",
            10000000,
            "다즐짱"
        );

        //when
        final Long savedFirstProductId = productDao.save(firstProductEntity);
        final Long savedSecondProductId = productDao.save(secondProductEntity);

        //then
        assertThat(productDao.findAll()).hasSize(2);
        assertThat(productDao.findAll()).map(ProductEntity::getId)
            .containsExactly(savedFirstProductId, savedSecondProductId);
    }
}