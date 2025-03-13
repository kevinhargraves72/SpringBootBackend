package kj.hargraves.games;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private  ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.allProducts(), HttpStatus.OK);
    }

    /*@GetMapping("/{name}")
    public  ResponseEntity<Optional<Product>> getSingleProduct(@PathVariable String name){
        return new ResponseEntity<Optional<Product>>(productService.singleProduct(name), HttpStatus.OK);
    }*/

    @GetMapping("/{id}")
    public  ResponseEntity<Optional<Product>> getSingleProductById(@PathVariable String id){
        return new ResponseEntity<Optional<Product>>(productService.singleProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Optional<Product>> addProduct(@RequestBody Product product){
        return new ResponseEntity<Optional<Product>>(productService.saveProduct(product), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public  ResponseEntity<Optional<Product>> patchProduct(@RequestBody Product product, @PathVariable String id){
        return  new ResponseEntity<Optional<Product>>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        return  new ResponseEntity<String>(productService.deleteProduct(id), HttpStatus.OK);
    }

}
//TODO:
//Make get single product by ID
//Possibly make get all products with name

//Post mapping to create a product
//Delete mapping to delete a product

//Patch mapping to update a product, probably need to use the mongotemplate thing