package com.piercarlo.fishstore.RESTAPI.product;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.piercarlo.fishstore.RESTAPI.RestapiApplicationTests;

public class ProductControllerTest extends RestapiApplicationTests {

	
	private MockMvc mockMvc;
	
	@Autowired
	private ProductController productController;
		
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}
	
	@Test
	public void testGETIndexProductController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/products")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGETProductByIdProductController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/products/" + 1)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testPOSTNewProductProductController() throws Exception {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(new Product(30,"testePOST",30));
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
				.contentType(
                        MediaType.APPLICATION_JSON).content(
                                json.getBytes())
				).andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void testPUTUpdateProductController() throws Exception {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Product product = new Product(500,"testePUT",30);
		String json = ow.writeValueAsString(product);
		this.mockMvc.perform(MockMvcRequestBuilders.put("/api/products/" + 1)
		.contentType(
                MediaType.APPLICATION_JSON).content(
                        json.getBytes())
		).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testDELETEProductByIdProductController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/products/" + 500)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
