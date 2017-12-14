package farfetch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import farfetch.model.Toogle;
import farfetch.service.ToogleService;

@RestController
public class FarfetchController {

	@Autowired
	ToogleService toogleService;

	@RequestMapping("/getToogle")
	public List<Toogle> getToogle(@RequestParam(value = "id", defaultValue = "isBlue") String id) {
		return toogleService.getToogles(id);
	}

	@RequestMapping("/getToogleByAdmin")
	public Toogle getToogle(@RequestParam(value = "id") String id, @RequestParam(value = "admin") String admin) {
		return toogleService.getToogle(id, admin);
	}

	@RequestMapping("/createToogle")
	public Toogle create(@RequestParam(value = "id") String id, @RequestParam(value = "enable") boolean enable) {
		return toogleService.createToogle(id, enable);

	}

	@RequestMapping("/createToogleByOwner")
	public Toogle create(@RequestParam(value = "id") String id, @RequestParam(value = "value") boolean enable,
			@RequestParam(value = "admin") String admin) {
		return new Toogle(id, enable, admin, true);
	}

}
