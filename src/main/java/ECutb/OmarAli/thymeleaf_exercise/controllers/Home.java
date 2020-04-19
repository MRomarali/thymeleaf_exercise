package ECutb.OmarAli.thymeleaf_exercise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    List<String> save = new ArrayList<>();
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
    @PostMapping("contact")
    public String contact(@RequestParam(name = "name")String input){
        save.add(input);
        return "redirect:/contact-list";
    }
    @GetMapping("contact-list")
    public String contactList(Model model){
        model.addAttribute("strings", save);
        return "contact";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    int temperature;

    @RequestMapping("/fever")
    public String fever(){
        return "fever";
    }
    @PostMapping("fever")
    public String tempController(@RequestParam(name = "temperature") Integer temperature) {
        if (temperature < 35) {
            return "notFever";
        } else if (temperature > 35 && temperature < 38) {
            return "normal";

        } else if (temperature >= 38) {
            return "gotFever";
        }

    return "fever";
    }
}
