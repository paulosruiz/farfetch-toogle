package farfetch.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Toogle {

	/**
	 * Toogle key
	 */
	@Id
	private String key;

	/**
	 * Toogle Name
	 */
	private String id;

	/**
	 * Toogle Version
	 */
	@JsonIgnore
	private String admin;

	/**
	 * Toogle value
	 */
	private boolean enable;

	/**
	 * adminOnly is a DB property should not be sent in the response
	 */
	@JsonIgnore
	private boolean adminOnly;

	public Toogle() {
		
	}
	
	public Toogle(String id, boolean enable) {
		this.key = id;
		this.id = id;
		this.enable = enable;
	}

	public Toogle(String id, boolean enable, String admin, boolean adminOnly) {
		this.key = id+admin;
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
