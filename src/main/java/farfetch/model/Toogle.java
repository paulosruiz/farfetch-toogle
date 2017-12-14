package farfetch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;

import com.fasterxml.jackson.annotation.JsonIgnore;

@CompoundIndexes({
    @CompoundIndex(name = "toogleIndex",
                   unique = true,
                   def = "{'id' : 1, 'admin' : 1}")
})
public class Toogle {

	public Long key;

	/**
	 * Toogle Name
	 */
	@Id
	private String id;

	/**
	 * Toogle value
	 */
	private boolean enable;

	/**
	 * Toogle Version
	 */
	private String admin;

	/**
	 * adminOnly is a DB property should not be sent in the response
	 */
	@JsonIgnore
	private boolean adminOnly;

	public Toogle(String id, boolean enable) {
		super();
		this.id = id;
		this.enable = enable;
	}

	public Toogle(String id, boolean enable, String admin, boolean adminOnly) {
		super();
		this.id = id;
		this.enable = enable;
		this.admin = admin;
		this.adminOnly = adminOnly;
	}

	public String getId() {
		return id;
	}

	public String getAdmin() {
		return admin;
	}

	public boolean getEnable() {
		return enable;
	}

	public boolean getAdminOnly() {
		return adminOnly;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public void setAdminOnly(boolean adminOnly) {
		this.adminOnly = adminOnly;
	}
}
