package FileManagementSystem;

public abstract class FileEntity {
	
	protected CDirectory parent;
	protected String name;
	
	public FileEntity (String name) {
		this.name = name;
	}
	
	abstract public String getName();
	
	public CDirectory getParent() {
		return parent;
	}
	
	public void setParent (CDirectory parent) {
		this.parent = parent;
	}
	
	public String getPath() {
		return recurGetPath(parent) + "\\" + getName();
	}
	
	private String recurGetPath(CDirectory parent) {
		if (parent == null)
			return "";
		return recurGetPath(parent.getParent()) + "\\" + parent.getName();
	}
	
}
