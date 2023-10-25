package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class HelloController {
    @RequestMapping
    public String getHello() {
        return "privet";
    }

    @RequestMapping("/salam")
    public String getSalam(@RequestParam("name") String name, Model model) {
     String s="Salam"+name;
        model.addAttribute("name",s);
      //  System.out.println("Hello "+name);
        return "salam";
    }
}
//    @RequestMapping("/privet")
//    public String getPrivet(){
//        return "privet";
//    }
//}
