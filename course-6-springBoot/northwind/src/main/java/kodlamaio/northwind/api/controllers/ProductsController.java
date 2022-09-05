package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
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
    public Result add(@RequestBody Product product) { // body degerlerini gonderecek
        return productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product>
    getByProductName(@RequestParam String productName) {// parametre olarak gonderecek
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product>
    getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        return productService.getAll(pageNo - 1, pageSize);
    }

    @GetMapping("getAllSorted")
    public DataResult<List<Product>> getAllSorted() {
        return productService.getAllSorted();
    }

   /* @PostMapping("/add")
    public Result add(Product product) {
        return new Result(true,"Urun eklendi");
    }*/
}
