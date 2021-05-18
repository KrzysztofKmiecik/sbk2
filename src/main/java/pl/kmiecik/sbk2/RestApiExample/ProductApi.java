package pl.kmiecik.sbk2.RestApiExample;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductApi {
    //RequestParam
   /* @GetMapping
    public String getProducts(@RequestParam String name, @RequestParam(required = false,defaultValue = "") String surname) {
        return "Hello "+ name +" "+ surname;
    }*/
//PathVariable
    /*@GetMapping("/{name}")
    public String getProducts(@PathVariable String name) {
        return "Hello "+ name ;
    }*/
//RequestHeader
   /* @GetMapping
    public String getProducts(@RequestHeader String name) {
        return "Hello "+ name ;
    }*/
//RequestBody
    @GetMapping
    public String getProducts(@RequestBody String name) {
        return "Hello "+ name ;
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
