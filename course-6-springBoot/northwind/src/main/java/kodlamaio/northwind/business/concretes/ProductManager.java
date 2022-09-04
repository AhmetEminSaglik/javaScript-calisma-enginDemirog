package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return new SuccessDataResult<>(productDao.findAll(),"All Data listed"); //asagidaki gibi olmali ama boyle de calisiyor
        //return new SuccessDataResult<List<Product>>(productDao.findAll(),"All Data listed");
    }
    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new SuccessResult("Data is added : data id : "+product.getId());
    }
}
