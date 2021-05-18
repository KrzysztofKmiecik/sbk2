package pl.kmiecik.sbk2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductApi {

    @GetMapping
    public String getProducts() {
        return "Hello from GET";
    }

    @PostMapping
    public String addProduct() {
        return "Hello from POST";
    }

    @PutMapping
    public String updateProduct() {
        return "Hello from PUT";
    }

    @DeleteMapping
    public String removeProduct() {
        return "Hello from delete";
    }
}
