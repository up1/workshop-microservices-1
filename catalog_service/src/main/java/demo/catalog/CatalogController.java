package demo.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/catalog/{id}")
    public Catalog getCatalog(@PathVariable final int id) {
        Catalog catalog = new Catalog();
        catalog.setId(id);

        // Get list of product from product service
        List<Object> products = restTemplate.getForObject(
                "http://product-service/products", List.class);
        catalog.setProducts(products);

        return catalog;
    }


}
