package farfetch.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import farfetch.controller.FarfetchController;
import farfetch.dao.ToogleRepository;
import farfetch.model.Toogle;

@Service
public class ToogleServiceImpl implements ToogleService {

	final static Logger LOG = Logger.getLogger(ToogleServiceImpl.class);

	@Autowired
	private ToogleRepository repository;

	/**
	 * Create a new Toogle by Id and value
	 * 
	 * @param id
	 * @param value
	 * @return
	 */

	@Override
	public Toogle createToogle(String id, boolean value) {
		Toogle newToogle = null;
		try {
			if (id != null && !id.isEmpty()) {

				newToogle = new Toogle(id, value);
				repository.save(newToogle);
			}
		} catch (Exception e) {
			LOG.error("Error during createToogle", e);
		}
		return newToogle;
	}

	/**
	 * Create a new Toogle by Id, value and admin
	 * 
	 * @param id
	 * @param value
	 * @param admin
	 * @param adminOnly
	 * @return
	 */

	@Override
	public Toogle createToogle(String id, boolean value, String admin) {
		Toogle newToogle = null;

		try {
			if (id != null && !id.isEmpty() && admin != null && !admin.isEmpty()) {
				newToogle = new Toogle(id, value, admin, true);
				repository.save(newToogle);

			}
		} catch (Exception e) {
			LOG.error("Error during createToogle", e);
		}
		return newToogle;

	}

	/**
	 * Get Toogles by Id and name True parameter is setting the AdminOnly field
	 * 
	 * @param id
	 * @param admin
	 * @return
	 */

	@Override
	public Toogle getTooglePerAdmin(String id, String admin) {
		Toogle toogle = null;
		try {
			if (id != null && !id.isEmpty() && admin != null && !admin.isEmpty()) {
				return repository.findByIdAndAdminAndAdminOnly(id, admin, true);
			}
		} catch (Exception e) {
			LOG.error("Error during getTooglePerAdmin", e);
		}
		return toogle;
	}

	/**
	 * Get Toogles by Id
	 * 
	 * @param id
	 * @return
	 */

	@Override
	public List<Toogle> getToogles(String id) {
		try {
			if (id != null && !id.isEmpty()) {
				return repository.findById(id);
			}
		} catch (Exception e) {
			LOG.error("Error during getToogles", e);
		}
		return null;
	}

	/**
	 * Get Toogle by Id
	 */
	@Override
	public Toogle getToogle(String id) {
		Toogle toogle = null;
		try {
			if (id != null && !id.isEmpty()) {
				return repository.findByIdAndAdminAndAdminOnly(id, null, false);
			}
		} catch (Exception e) {
			LOG.error("Error during getToogles", e);
		}
		return null;
	}
}
