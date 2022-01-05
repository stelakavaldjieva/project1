package bg.startit.spring.project1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;


@SpringBootTest
@AutoConfigureMockMvc
@TestExecutionListeners({WithSecurityContextTestExecutionListener.class})
//@WebMvcTest
public class Project1ApplicationTests extends AbstractTestNGSpringContextTests
{
  @Autowired
  private MockMvc mvc;

  @Test
  public void given_authorized_access_When_getting_book_Then_status_authorized() throws Exception
  {
    mvc.perform(get("/api/v1/books/{book_id}", 1))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(roles = "LIBRARIAN")
  public void given_librarian_access_When_getting_book_Then_status_ok() throws Exception
  {
    mvc.perform(get("/api/v1/books/{book_id}", 1))
//        .with(user("admin@startit.bg"))
        .andDo(print())
        .andExpect(status().isOk());
  }
}
