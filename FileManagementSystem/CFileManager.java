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
		if (curDir.getDirectory(dirName) == null) {		//不存在才可新增
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
		CDirectory nextDir = curDir.getDirectory(dirName);		//存在才可進入
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
