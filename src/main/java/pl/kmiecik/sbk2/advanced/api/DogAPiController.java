package pl.kmiecik.sbk2.advanced.api;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogAPiController {


    private List<Dog> dogList;

    public DogAPiController() {
        this.dogList = new ArrayList<>();

        dogList.add(new Dog("Azor", "kundel"));
        dogList.add(new Dog("Burek", "doberman"));
        dogList.add(new Dog("Czarek", "husky"));

    }

    @GetMapping
    public List<Dog> getDogs(@RequestHeader int amount) {
        return dogList.subList(0, amount);
    }


    @PostMapping
    public void addDog(@RequestBody Dog dog) {
        dogList.add(dog);
    }

}
