package br.com.conductor.controller;


import br.com.conductor.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginService service;

    private MockHttpServletRequestBuilder mockHttpServletRequestBuilder;

    private  static final String URL_GET_LOGIN = "/login";

    @Test
    public void testLoginStatus200Ok() throws Exception {
        this.mockHttpServletRequestBuilder = get(URL_GET_LOGIN);

        mockMvc.perform(this.mockHttpServletRequestBuilder
                        .param("password", "AbTp9!fok")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
