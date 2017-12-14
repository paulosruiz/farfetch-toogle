package farfetch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import farfetch.model.Toogle;

@Service
public interface ToogleService {
	/**
	 * Create a new Toogle by Id and value
	 * 
	 * @param id
	 * @param value
	 * @return
	 */
	public Toogle createToogle(String id, boolean value);

	/**
	 * Create a new Toogle by Id, value and admin
	 * 
	 * @param id
	 * @param value
	 * @param admin
	 * @param adminOnly
	 * @return
	 */
	public Toogle createToogle(String id, boolean value, String admin);

	/**
	 * Get Toogles by Id and name True parameter is setting the AdminOnly field
	 * 
	 * @param id
	 * @param admin
	 * @return
	 */
	public Toogle getToogle(String id, String admin);

	/**
	 * Get Toogle
	 * 
	 * @param id
	 * @return
	 */
	public List<Toogle> getToogles(String id);
}
