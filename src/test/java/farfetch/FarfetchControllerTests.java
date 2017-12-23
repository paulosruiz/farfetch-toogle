package farfetch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import farfetch.dao.ToogleRepository;
import farfetch.model.Toogle;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FarfetchControllerTests {

	@Autowired
	ToogleRepository repository;

	Toogle toogleOne, toogleTwo;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void createToogle() throws Exception {
		this.mockMvc.perform(get("/toogle/createToogle").param("id", "ToogleTestBlue").param("enable", "true"))
				.andDo(print()).andExpect(status().isOk());

		List<Toogle> toogleOne = repository.findById("ToogleTestBlue");
		assertNotNull(toogleOne);
		repository.delete(toogleOne);
	}

	@Test
	public void createToogleAdmin() throws Exception {

		this.mockMvc.perform(get("/toogle/createToogleAdmin").param("id", "ToogleTestRed").param("enable", "false")
				.param("admin", "ABC")).andDo(print()).andExpect(status().isOk());

		Toogle toogleTwo = repository.findByIdAndAdminAndAdminOnly("ToogleTestRed", "ABC", true);
		assertNotNull(toogleTwo);
		repository.delete(toogleTwo);

	}

}
