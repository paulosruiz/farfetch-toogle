package farfetch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import farfetch.model.Toogle;

@RestController
public class FarfetchController {

	@RequestMapping("/getToogle")
	public Toogle getToogle(@RequestParam(value = "name", defaultValue = "isBlue") String name) {
		return new Toogle("isBlue", false);
	}

	@RequestMapping("/createToogle")
	public Toogle create(@RequestParam(value = "id") String id, @RequestParam(value = "enable") boolean enable) {
		System.out.println("entrou no create");

		System.out.println(id);
		System.out.println(enable);
		return new Toogle(id, enable);
	}

	@RequestMapping("/createToogleByOwner")
	public Toogle create(@RequestParam(value = "id") String id, @RequestParam(value = "value") boolean enable,

			@RequestParam(value = "admin") String admin) {
		return new Toogle(id, enable, admin, true);
	}

}
