package farfetch.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import farfetch.model.Toogle;
import farfetch.service.ToogleService;

@RestController
public class FarfetchController {

	final static Logger LOG = Logger.getLogger(FarfetchController.class);

	@Autowired
	ToogleService toogleService;

	public void setToogleService(ToogleService toogleService) {
		this.toogleService = toogleService;
	}

	@RequestMapping("/getToogle")
	public Toogle getToogle(@RequestParam(value = "id") String id) {
		LOG.debug("Starting getToogle");
		return toogleService.getToogle(id);
	}

	@RequestMapping("/getTooglesById")
	public List<Toogle> getTooglesById(@RequestParam(value = "id") String id) {
		LOG.debug("Starting getTooglesById");
		return toogleService.getToogles(id);
	}

	@RequestMapping("/getToogleByAdmin")
	public Toogle getToogleByAdmin(@RequestParam(value = "id") String id, @RequestParam(value = "admin") String admin) {
		LOG.debug("Starting getToogleByAdmin");
		return toogleService.getTooglePerAdmin(id, admin);
	}

	@RequestMapping("/createToogle")
	public Toogle createToogle(@RequestParam(value = "id") String id, @RequestParam(value = "enable") boolean enable) {
		return toogleService.createToogle(id, enable);
	}

	@RequestMapping("/createToogleAdmin")
	public Toogle createToogleAdmin(@RequestParam(value = "id") String id, @RequestParam(value = "enable") boolean enable,
			@RequestParam(value = "admin") String admin) {

		return toogleService.createToogle(id, enable, admin);
	}

}
