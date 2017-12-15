package farfetch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import farfetch.dao.ToogleRepository;
import farfetch.model.Toogle;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToogleRepositoryTests {

	@Autowired
	ToogleRepository repository;

	Toogle toogleOne, toogleTwo;

	@Before
	public void setUp() {

		//repository.deleteAll();
		toogleOne = repository.save(new Toogle("ToogleRepositoryTestsBlue", false));
		toogleTwo = repository.save(new Toogle("ToogleRepositoryTestsRed", false, "ABC", true));
	}

	@Test
	public void findsById() {

		List<Toogle> result = repository.findById("ToogleRepositoryTestsBlue");
		
		 assertThat(result).hasSize(1).extracting("id").contains("ToogleRepositoryTestsBlue");
	}

	@Test
	public void findsByExample() {

		Toogle result = (Toogle) repository.findByIdAndAdminAndAdminOnly("ToogleRepositoryTestsRed", "ABC", true);
		assertNotNull(result);

		// assertThat(result).extracting("id").contains("ToogleTestRed");
	}

	@After
	public void UndoSetUp() {

		repository.delete(toogleOne);
		repository.delete(toogleTwo);
	
	}
}
