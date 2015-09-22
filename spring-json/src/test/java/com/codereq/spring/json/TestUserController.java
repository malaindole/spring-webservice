package com.codereq.spring.json;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
	@ContextConfiguration("file:src/main/resources/application-context.xml"),
	@ContextConfiguration("file:src/main/webapp/WEB-INF/user-ws-servlet.xml")
})

public class TestUserController {

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
	
	@Test
	public void test() throws Exception {
		Assert.assertNotNull(mockMvc);
		User user = createUser();
		MvcResult mvcResult = mockMvc.perform((post("/user/").content(toJSON(user)))
				.contentType(MediaType.parseMediaType("application/json"))
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk()).andReturn();
		String res = mvcResult.getResponse().getContentAsString();
		User ob = new ObjectMapper().readValue(res, User.class);
		Assert.assertNotNull("user id cannot be null", ob.getUserId());
	}

	private User createUser() {
		User user = new User();
		user.setEmail("ts@te.com");
		user.setName("gs");
		return user;
	}
	
	public byte[] toJSON(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(object);
    }
}
