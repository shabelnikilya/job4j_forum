package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final Service service;
    private final PasswordEncoder encoder;

    public RegControl(ForumService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @PostMapping("/reg")
    public String reqSave(@ModelAttribute User user, Model model) {
        if (service.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Имя данного пользователя занято");
            return reqPage();
        }
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(service.findByAuthority("ROLE_USER"));
        service.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reqPage() {
        return "user/reg";
    }
}
