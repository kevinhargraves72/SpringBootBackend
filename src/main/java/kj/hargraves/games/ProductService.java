package kj.hargraves.games;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product> allProducts() { return productRepository.findAll(); }

    public Optional<Product> singleProduct(String name) { return productRepository.findProductByName(name); }

    public Optional<Product> singleProductById(String id) { return productRepository.findProductById(id); }

    public Optional<Product> saveProduct(Product product)
    {
        productRepository.save(product);

        return productRepository.findProductById(product.getId());
    }
    public Optional<Product> updateProduct(Product product, String id)
    {
        /*mongoTemplate.update(Product.class)
                .matching(Criteria.where("id").is(id))
                .apply(new Update().set("name", product.getName()))
                .first();
        mongoTemplate.update(Product.class)
                .matching(Criteria.where("id").is(id))
                .apply(new Update().set("price" , product.getPrice()))
                .first();
        mongoTemplate.update(Product.class)
                .matching(Criteria.where("id").is(id))
                .apply(new Update().set("image", product.getImage()))
                .first();
         */
        product.setId(id);
        productRepository.save(product);

        return productRepository.findProductById(id);
    }

    public String deleteProduct(String id)
    {
        productRepository.deleteProductById(id);

        return "Deleted Successfully";
    }

}
