package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.ForumService;
import ru.job4j.forum.service.Service;

@Controller
public class RegControl {
    private Service service;

    public RegControl(ForumService service) {
        this.service = service;
    }

    @PostMapping("/reg")
    public String reqSave(@ModelAttribute User user, Model model) {
        if (service.containsUser(user)) {
            model.addAttribute("error", "Имя данного пользователя занято");
            return reqPage();
        }
        service.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reqPage() {
        return "user/reg";
    }
}
