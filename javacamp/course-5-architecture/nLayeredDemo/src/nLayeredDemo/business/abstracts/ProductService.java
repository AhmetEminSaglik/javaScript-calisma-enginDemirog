package nLayeredDemo.business.abstracts;

import nLayeredDemo.entities.concretes.Product;

import java.util.List;

public interface ProductService { // service herhangi bir sinifin interface'i

    void add(Product product);
    List<Product> getAll();
}
