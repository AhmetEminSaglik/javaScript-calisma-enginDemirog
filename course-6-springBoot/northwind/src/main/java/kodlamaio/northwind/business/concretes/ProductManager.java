package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class ProductManager implements ProductService {

    //@Autowired //birden fazla service olusturulursa burasi sorun cikarir o yuzden constructor'a ekledik
    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(productDao.findAll(), "All Data listed"); //asagidaki gibi olmali ama boyle de calisiyor
        //return new SuccessDataResult<List<Product>>(productDao.findAll(),"All Data listed");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC,"productName");
        //Sort sort = Sort.by(Sort.Direction.ASC,"category.categoryName");
        return new SuccessDataResult<>(productDao.findAll(sort), " Successfull");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult(productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new SuccessResult("Data is added : data id : " + product.getId());
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<>(productDao.getByProductName(productName), "Data retrieved");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        //business codes
        return new SuccessDataResult<>(productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data retrieved");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "All Datas retrieved");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<>(productDao.getByCategory_CategoryIdIn(categories), "All Datas retrieved");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<>(productDao.getByProductNameContains(productName), "All Datas retrieved");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<>(productDao.getByProductNameStartsWith(productName), "All Datas retrieved");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(productDao.getByNameAndCategory_CategoryId(productName, categoryId), "All Datas retrieved");
    }
}
