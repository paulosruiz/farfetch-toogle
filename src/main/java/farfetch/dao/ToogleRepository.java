package farfetch.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import farfetch.model.Toogle;

public interface ToogleRepository extends MongoRepository<Toogle, String> {

	public Toogle findByIdAndAdminAndAdminOnly(String id, String admin,boolean adminOnly);
	
	public List<Toogle> findById(String id);

}