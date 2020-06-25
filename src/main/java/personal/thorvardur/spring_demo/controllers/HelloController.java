package personal.thorvardur.spring_demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class HelloController {

    @GetMapping("/")
    public RedirectView index(){
        return new RedirectView("/swagger-ui.html");
    }

    /**
     * A hello-world action.
     * @return A simple string.
     */
    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }
}
