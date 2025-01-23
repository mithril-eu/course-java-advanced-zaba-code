package eu.mithril.invoice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
