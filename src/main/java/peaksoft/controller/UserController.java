package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private List<User> userList=new ArrayList<>();
    @GetMapping("add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users/save";
    }
    @PostMapping("/save")
public String saveUser(@ModelAttribute ("user")User user) {
        userList.add(user);
        return "redirect:find-all";

    }
    @GetMapping("find-all")
            public String getAllUser(Model model1){
        model1.addAttribute("userlist",userList);
        return "/users/get-all";

        }
}
