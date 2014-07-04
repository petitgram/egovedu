package sample.di.dataaccess;

import org.springframework.stereotype.Component;

import sample.di.business.domain.Product;
import sample.di.business.service.ProductDao;

@Component
public class ProductDaoImpl implements ProductDao {
    // Dao이지만 간단히 하고자 RDB에는 액세스하지 않는다.
    public Product getProduct(String name) {
        // Dao답게 제품명과 가격을 가진 Product를 검색한 것처럼 반환한다.
        return new Product(name, 100);
    }
}
