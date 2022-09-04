package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    /**
     Bunu gorurnce Projeyi taramaya basliyor ve product Service'i kim implement ediyorsa onun instanceni olusturuyor
     Bu projecede ProductServici'i ProductManager implement ettigi icin ProductManaeger'in instance olusturuluyor.*/
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    private ProductService productService;

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
//        return new DataResult<Product>(productService.getAll(), true,"All Products retrived");
        return productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }
   /* @PostMapping("/add")
    public Result add(Product product) {
        return new Result(true,"Urun eklendi");
    }*/
}
