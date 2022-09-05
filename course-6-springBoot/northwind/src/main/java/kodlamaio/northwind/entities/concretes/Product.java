package kodlamaio.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity//VT tablosu oldugunu anlatmak icin kullaniyoruz
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id 1'er 1'er artirilacak demektir
    //strategy  -> vt bagli olarak degismektedir
    @Column(name = "product_id")
    private int id;
    /**
     * @Column(name = "category_id")
     * private int categoryId;
     * Category ManyToOne ve JoinColumn ile Category tablosuna baglanti kurduk
     * Artik category id'yi tutmamiza gerek kalmadi
     */
    @Column(name = "product_name")
    private String productName;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "units_in_stock")
    private short unitsInStock;
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;
    @ManyToOne
    @JoinColumn(name = "category_id") //Query'de joinColumn kismini yazmaliyiz
    private Category category;
}
