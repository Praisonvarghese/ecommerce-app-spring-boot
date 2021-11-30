package com.techiemaster.ecommerce.controller;

import com.techiemaster.ecommerce.dto.ProdcutResponse;
import com.techiemaster.ecommerce.model.Product;
import com.techiemaster.ecommerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    static List<Product> products=null;

    @GetMapping("/getAllProducts")
    public ProdcutResponse getProductList() {
        List<Product> productList = productRepository.findAll();
        return new ProdcutResponse(10, productList);
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productRepository.findById(id).get();
    }

    @GetMapping("/getProducts/{category}")
    public List<Product> getProduct(@PathVariable("category") String category) {
        return (List<Product>) productRepository.findByCategory(category);
    }

    @PostConstruct
    private void insertDataToDb() {
         products = Arrays.asList(
                new Product(1, "Samsung Galaxy M12 (Blue,4GB RAM, 64GB Storage) 6000 mAh with 8nm Processor | True 48 MP Quad Camera | 90Hz Refresh Rate", "Mobile", 700, 5, "/assets/img/product07.png", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Totam placeat expedita quidem exercitationem excepturi ratione quam, perferendis adipisci officia sit tempore non sunt odio quae","/assets/img/product06.png;/assets/img/product07.png"),
                new Product(2, "LG Gram 17 Ultra-Light 11th Gen Intel Core i5 17 inches Business Laptop ", "Laptop", 25000, 10, "/assets/img/product01.png", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Totam placeat expedita quidem exercitationem excepturi ratione quam, perferendis adipisci officia sit tempore non sunt odio quae",null),
                new Product(3, "ASUS Core i3 10th Gen - (4 GB + 32 GB Optane/512 GB SSD/Windows 10 Home) X515JA-EJ372TS Thin and Light Laptop ", "Laptop", 18500, 0, "/assets/img/product03.png", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Totam placeat expedita quidem exercitationem excepturi ratione quam, perferendis adipisci officia sit tempore non sunt odio quae",null),
                new Product(4, "boAt BassHeads 900 Wired Headset  (Carbon Black, On the Ear)", "HeadPhone", 75000, 5, "/assets/img/product05.png", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Totam placeat expedita quidem exercitationem excepturi ratione quam, perferendis adipisci officia sit tempore non sunt odio quae",null),
                new Product(5, "ASUS VivoBook 15 (2020), 39.6 cm HD, Dual Core Intel Celeron N4020, Thin and Light Laptop", "Laptop", 850, 5, "/assets/img/product06.png", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Totam placeat expedita quidem exercitationem excepturi ratione quam, perferendis adipisci officia sit tempore non sunt odio quae","/assets/img/product06.png;/assets/img/product07.png;/assets/img/product03.png"),
                new Product(6, "Jabra Evolve2 65 Link380c UC Headphone (Black)", "HeadPhone", 750, 5, "/assets/img/shop03.png", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Totam placeat expedita quidem exercitationem excepturi ratione quam, perferendis adipisci officia sit tempore non sunt odio quae",null),
                new Product(7, "Xiaomi 11 Lite NE 5G (Jazz Blue 6GB RAM 128 GB Storage) | Slimmest (6.81mm) ", "Mobile", 25000, 0, "/assets/img/product07.png", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Totam placeat expedita quidem exercitationem excepturi ratione quam, perferendis adipisci officia sit tempore non sunt odio quae",null),
                new Product(8, "realme Pad 4 GB RAM 64 GB ROM 10.4 inch with Wi-Fi+4G Tablet (Gold)", "Tablet", 25000, 1, "/assets/img/product04.png", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Totam placeat expedita quidem exercitationem excepturi ratione quam, perferendis adipisci officia sit tempore non sunt odio quae",null)
        );
        productRepository.saveAll(products);
    }


    public static List<Product> getProducts() {
        return products;
    }


}
