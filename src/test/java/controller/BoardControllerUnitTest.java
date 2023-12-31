package controller;

import jupiter.hello.spring4.controller.IndexController;
import jupiter.hello.spring4.controller.MemberController;
import jupiter.hello.spring4.model.Member;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/servlet-context.xml",
        "classpath:spring/root-context.xml"})
@WebAppConfiguration()
public class BoardControllerUnitTest {
    @Autowired
    WebApplicationContext wctx;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.wctx).build();
    }

    @Test
    public void joinTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get("/board/list")
                        .param("cpg","1"))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(mvcResult.getModelAndView());
    }
    @Test
    public void viewTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                        get("/board/view")
                                .param("bno","1"))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(mvcResult.getModelAndView());
    }
    @Test
    @Transactional
    public void writeokTest() throws  Exception{
                mockMvc.perform(post("/board/write")
                .param("title","abc123")
                .param("userid","테스트")
                .param("contents","테스트"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/board/list"));
                //.andExpect(view().name("redirect:/board/list"));

    }

}