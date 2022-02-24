package ru.job4j.forum.control;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.ForumService;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class ControlTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ForumService service;

    @Test
    @WithMockUser
    public void testPostControlWhenSaveOnePost() throws Exception {
        this.mockMvc.perform(post("/save")
                        .param("id", "1")
                        .param("name", "Куплю ладу-грант. Дорого.")
                        .param("description", "В городе Москва"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(service).addPost(argument.capture());
        assertThat(argument.getValue().getId(), is(1));
        assertThat(argument.getValue().getName(), is("Куплю ладу-грант. Дорого."));
        assertThat(argument.getValue().getDescription(), is("В городе Москва"));
    }

    @Test
    @WithMockUser
    public void testPostControlWhenOneSavePostAndUpdatePostDescription() throws Exception {
        this.mockMvc.perform(post("/save")
                        .param("id", "1")
                        .param("name", "Куплю ладу-грант. Дорого.")
                        .param("description", "В городе Москва"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        this.mockMvc.perform(post("/update")
                        .param("id", "1")
                        .param("name", "Куплю ладу-грант. Дорого.")
                        .param("description", "В городе Санкт-Петербург"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(service, Mockito.times(2)).addPost(argument.capture());
        assertThat(argument.getAllValues().get(0).getDescription(), is("В городе Москва"));
        assertThat(argument.getAllValues().get(1).getDescription(), is("В городе Санкт-Петербург"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/index"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @WithMockUser
    public void testLogin() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("user/login"));
    }

    @Test
    @WithMockUser
    public void testLoginWithErrorIncorrectNameOrPassword() throws Exception {
        this.mockMvc.perform(get("/login").param("error", "true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("errorMessage", "Username or Password is incorrect!"))
                .andExpect(view().name("user/login"));
    }

    @Test
    @WithMockUser
    public void testLoginWithLogout() throws Exception {
        this.mockMvc.perform(get("/login").param("logout", "true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("errorMessage", "You have been successfully logged out!"))
                .andExpect(view().name("user/login"));
    }

    @Test
    @WithMockUser
    public void testEditPostWhenParamEqualsTwoAndEqualsPost() throws Exception {
        this.mockMvc.perform(get("/edit").param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/edit"));
    }

    @Test
    @WithMockUser
    public void testPostControlCreate() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/create"));
    }

    @Test
    @WithMockUser
    public void testReqControl() throws Exception {
        this.mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("user/reg"));
    }
}