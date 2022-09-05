package kodlamaio.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"})
/** product category'e giriyor ve catogory'de product listesi olusuyor. Boylece sonsuz dongu olusuyor.
 * Bu sonsuz donguyu kirmak icin bunu ekledik JsonIgnoreProperties anotationu ekledik */
public class Category {
    @Id
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @OneToMany(mappedBy = "category")// categori tablosuyla iliskilendirilmis demektir
    // ana tabloda 1 tane, diger tabloda 1den cok olabilir.
    // product listesinde 1den fazla ayni category olabilir demek
    private List<Product> products;

}
