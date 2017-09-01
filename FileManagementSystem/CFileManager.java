package FileManagementSystem;

public class CFileManager {
	
	CDirectory curDir = null;
	public CFileManager() {
		curDir = new CDirectory("root");
	}
	
	public CDirectory getCurrentDir() {
		return this.curDir;
	}
	
	public boolean mkdir (String dirName) {
		if (curDir == null)
			return false;
		if (curDir.getDirectory(dirName) == null) {		//���s�b�~�i�s�W
			curDir.addFileEntity(new CDirectory(dirName,this.curDir));
			return true;
		}
		return false;
	}
	
	public boolean touch (String fileName) {
		if (curDir == null)
			return false;
		if (curDir.getDirectory(fileName) == null) {
			curDir.addFileEntity(new CFile(fileName,this.curDir));
			return true;
		}
		return false;
	}
	
	public boolean cd(String dirName) {
		if (curDir == null)
			return false;
		CDirectory nextDir = curDir.getDirectory(dirName);		//�s�b�~�i�i�J
		if (nextDir != null) {
			this.curDir = nextDir;
			return true;
		}
		return false;
	}
	
	public boolean cdBack () {
		if (curDir.getParent() == null)
			return false;
		this.curDir = curDir.getParent();
		return true;
	}
	
	public String ls() {
		if (curDir == null)
			return "";
		return curDir.ls();
	}
	
	public String[] search(String keyword) {
		if (curDir == null)
			return null;
		return curDir.search(curDir,keyword);
	}

}
