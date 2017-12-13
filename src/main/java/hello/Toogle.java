package hello;

public class Toogle {

	private String id;
	private boolean enable;
	private String admin;
	private boolean adminOnly;

	public Toogle(String id, boolean enable2) {
		super();
		this.id = id;
		this.enable = enable2;
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

	public void setOwner(String owner) {
		this.admin = owner;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public void setAdminOnly(boolean adminOnly) {
		this.adminOnly = adminOnly;
	}
}
