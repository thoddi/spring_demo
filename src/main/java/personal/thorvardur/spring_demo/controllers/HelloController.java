package personal.thorvardur.spring_demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     * A hello-world action.
     * @return A simple string.
     */
    @GetMapping("/hello")
    public String index(){
        return "Hello world";
    }
}
