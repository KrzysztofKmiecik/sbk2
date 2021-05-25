package pl.kmiecik.sbk2.clientHttp;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
/**

https://github.com/public-apis/public-apis
*/

@Controller
public class restTemp {

    public restTemp() {
        RestTemplate restTemplate=new RestTemplate();

        Cat[] cats= restTemplate.getForObject(
                "https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=2",
                Cat[].class);

        for(Cat cat:cats){
            System.out.println(cat.getText());
        }


    }
}
