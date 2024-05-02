package com.shivaprasad.wishlist;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc
class WishlistApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertNotNull(mockMvc);
	}

	@Test
	void homePageViewTest() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/");

		mockMvc.perform(request)
					.andExpect(status().is2xxSuccessful())
					.andExpect(view().name("select"));
	}

	@Test
	void formPageViewTest() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/form?id=123");

		mockMvc.perform(request)
					.andExpect(status().is2xxSuccessful())
					.andExpect(view().name("form"))
					.andExpect(model().attributeExists("wishlist"));
	}

	@Test
	void viewDataTest() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/viewdata");

		mockMvc.perform(request)
					.andExpect(status().is2xxSuccessful())
					.andExpect(view().name("viewdata"))
					.andExpect(model().attributeExists("items"));
	}
}
