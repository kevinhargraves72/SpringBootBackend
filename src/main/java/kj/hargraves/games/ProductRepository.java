package kj.hargraves.games;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {

    Optional<Product> findProductByName(String name);

    Optional<Product> findProductById(String id);

    void deleteProductById(String id);
}
