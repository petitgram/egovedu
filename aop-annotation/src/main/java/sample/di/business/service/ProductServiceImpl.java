package sample.di.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.di.business.domain.Product;

@Component("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public Product getProduct() {
        // 그럴듯하게 검색 조건을 집어넣는다
		return productDao.getProduct("상품명");
    }
}