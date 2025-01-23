package eu.mithril.invoice.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(
            Model model,
            @RequestParam("username") String username
    ) {
        model.addAttribute("username", username);
        model.addAttribute("currentDate", LocalDateTime.now());
        return "index.html";
    }
}
