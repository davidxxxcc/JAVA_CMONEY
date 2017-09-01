package FileManagementSystem;
import java.util.Arrays;

public class CDirectory extends FileEntity{
	private FileEntity[] list; //儲存了底下的目錄夾與檔案
	
	private int itemCount;
	//以上使用了多型的概念
	
	//建構子,super(name)為設定繼承自FileEntity的建構子
	public CDirectory (String name) {
		super(name);
		list = new FileEntity[10];
		itemCount = 0;
	}
	
	public CDirectory (String name, CDirectory parentEntity) {
		super(name);
		list = new FileEntity[10];
		setParent(parentEntity);
		itemCount = 0;
	}
	
	public int getItemCount() {
		return itemCount;
	}
	
	@Override public String getName() {
		return name;
	}
	
	public void addFileEntity(FileEntity entity) {
		if (itemCount >= list.length)
			list = Arrays.copyOf(list,itemCount * 2);
		list[itemCount++] = entity;
	}
	
	//搜尋某個項目名稱是否為這個資料夾的檔案或目錄
	public int find (String key) {
		for (int i = 0; i < itemCount; i++) {		//循序搜尋法
			if (list[i].getName().equals(key))
				return i;
		}
		return -1;
	}
	
	public CDirectory getDirectory(String key) {
		int index = find (key);
		if (index == -1)
			return null;
		if (list[index] instanceof CDirectory) 		//判斷該物件是否為CDirectory
			return (CDirectory) list[index];	//有找到的話回傳物件
		else 
			return null;
	}
	
	public String ls() {
		String str = "";
		int dC = 0, fC = 0;
		for (int i = 0; i < itemCount; i++) {
			if (list[i] instanceof CDirectory ) {	//目錄夾物件
				 str += ("[" + list[i].getName() + "]" + "\n");
				 dC ++;
			}
			else if (list[i] instanceof CFile) {		//檔案物件
				str += (list[i].getName() + "\n");
				fC ++;
			}
		}
		if (str.equals(""))
			return "file/directory not found";
		str += "\n" + dC + " directories " + fC + " files\r\n";
		return str;
	}
	
	//用遞迴找出有包含關鍵字的檔案項目，tmp代表所屬的資料夾，keyword為關鍵字
	//回傳為符合的項目路徑，中間用換行符號隔閡
	public String[] search(CDirectory tmp, String keyword) {
		String[] str = new String [10];		//結果陣列
		int count = 0;
		for (int i = 0; i < tmp.itemCount; i++) {	//逐一搜尋自己底下的項目看看有無符合
			
			if (tmp.list[i].getName().contains(keyword)) {		//呼叫字串的contains
				if (count >= str.length)
					str = Arrays.copyOf(str, str.length * 2);
				str[count++] = tmp.list[i].getPath();			//有符合的便加入結果陣列中
			}
			
			String[] others = {};
			if (tmp.list[i] instanceof CDirectory) {			//如果有項目是資料夾，要再往底下找
				if (((CDirectory)tmp.list[i]).itemCount > 0)		//其中的項目個數大於零
					others = search((CDirectory)tmp.list[i],keyword);	//用遞迴的方式讓其執行
			}
			
			for (int k = 0; k < others.length;k++) {
				if (count + others.length >= str.length);
					str = Arrays.copyOf(str, count + others.length);
				str[count++] = others[k];
			}
		}
		str = Arrays.copyOf(str,count);
		return str ;			//回傳結果字串
	}
}


