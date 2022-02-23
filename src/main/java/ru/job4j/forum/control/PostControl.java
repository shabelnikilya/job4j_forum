package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.ForumService;
import ru.job4j.forum.service.Service;


@Controller
public class PostControl {
    private final Service service;

    public PostControl(ForumService service) {
        this.service = service;
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model) {
        model.addAttribute("post", service.findPostById(id));
        return "post/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Post post, @RequestParam Integer id) {
        post.setId(id);
        service.addPost(post);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create() {
        return "post/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        post.setUser(service.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        service.addPost(post);
        return "redirect:/";
    }
}
