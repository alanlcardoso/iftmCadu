package br.com.iftm.extensao.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	private static final String URL = "/atividade/1";

	@Before
	public void init() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testaId() throws Exception {
		this.mvc.perform(get(URL)).andExpect(status().isOk())
				.andExpect(jsonPath("nome", is("Visita Tecnica GDG 2018")));
	}

	@Test
	public void testaNotFound() throws Exception {
		this.mvc.perform(get("/atividade/10")).andExpect(status().isNotFound());
	}
}
