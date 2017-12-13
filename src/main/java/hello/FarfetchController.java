package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarfetchController {

	@RequestMapping("/greeting")
	public Toogle greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Toogle("1", false);
	}

	@RequestMapping("/create")
	public Toogle create(@RequestParam(value = "id") String id, @RequestParam(value = "enable") boolean enable) {
		System.out.println("entrou no create");
		
		System.out.println(id);
		System.out.println(enable);
		return new Toogle(id, enable);
	}

	@RequestMapping("/createSpecific")
	public Toogle create(@RequestParam(value = "id") String id, @RequestParam(value = "value") boolean enable,

			@RequestParam(value = "admin") String admin) {
		return new Toogle(id, enable, admin, true);
	}

}
