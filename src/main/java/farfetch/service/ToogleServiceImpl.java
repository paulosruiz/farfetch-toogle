package farfetch.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import farfetch.dao.ToogleRepository;
import farfetch.model.Toogle;

@Service
public class ToogleServiceImpl implements ToogleService{
	
	@Autowired
	private ToogleRepository repository;

	/**
	 * Create a new Toogle by Id and value
	 * 
	 * @param id
	 * @param value
	 * @return
	 */
	public Toogle createToogle(String id, boolean value) {
		Toogle newToogle = null;
		if (id != null && !id.isEmpty()) {
			newToogle = new Toogle(id, value);
			repository.save(newToogle);

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
	public Toogle createToogle(String id, boolean value, String admin) {
		Toogle newToogle = null;
		if (id != null && !id.isEmpty() && admin != null && !admin.isEmpty()) {
			newToogle = new Toogle(id, value, admin, true);
			repository.save(newToogle);

		}
		return newToogle;

	}

	/**
	 * Get Toogles by Id and name
	 *  True parameter is setting the AdminOnly field
	 * @param id
	 * @param admin
	 * @return
	 */
	public Toogle getToogle(String id, String admin) {
		if (id != null && !id.isEmpty() && admin != null && !admin.isEmpty()) {
			return repository.findByIdAndAdminAndAdminOnly(id, admin, true);
		}
		return null;
	}

	/**
	 * Get Toogle
	 * 
	 * @param id
	 * @return
	 */
	public List<Toogle> getToogles(String id) {
		if (id != null && !id.isEmpty()) {
			return repository.findById(id);
		}
		return null;
	}
}
