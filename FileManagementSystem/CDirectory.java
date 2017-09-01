package FileManagementSystem;
import java.util.Arrays;

public class CDirectory extends FileEntity{
	private FileEntity[] list; //�x�s�F���U���ؿ����P�ɮ�
	
	private int itemCount;
	//�H�W�ϥΤF�h��������
	
	//�غc�l,super(name)���]�w�~�Ӧ�FileEntity���غc�l
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
	
	//�j�M�Y�Ӷ��ئW�٬O�_���o�Ӹ�Ƨ����ɮשΥؿ�
	public int find (String key) {
		for (int i = 0; i < itemCount; i++) {		//�`�Ƿj�M�k
			if (list[i].getName().equals(key))
				return i;
		}
		return -1;
	}
	
	public CDirectory getDirectory(String key) {
		int index = find (key);
		if (index == -1)
			return null;
		if (list[index] instanceof CDirectory) 		//�P�_�Ӫ���O�_��CDirectory
			return (CDirectory) list[index];	//����쪺�ܦ^�Ǫ���
		else 
			return null;
	}
	
	public String ls() {
		String str = "";
		int dC = 0, fC = 0;
		for (int i = 0; i < itemCount; i++) {
			if (list[i] instanceof CDirectory ) {	//�ؿ�������
				 str += ("[" + list[i].getName() + "]" + "\n");
				 dC ++;
			}
			else if (list[i] instanceof CFile) {		//�ɮת���
				str += (list[i].getName() + "\n");
				fC ++;
			}
		}
		if (str.equals(""))
			return "file/directory not found";
		str += "\n" + dC + " directories " + fC + " files\r\n";
		return str;
	}
	
	//�λ��j��X���]�t����r���ɮ׶��ءAtmp�N����ݪ���Ƨ��Akeyword������r
	//�^�Ǭ��ŦX�����ظ��|�A�����δ���Ÿ��j��
	public String[] search(CDirectory tmp, String keyword) {
		String[] str = new String [10];		//���G�}�C
		int count = 0;
		for (int i = 0; i < tmp.itemCount; i++) {	//�v�@�j�M�ۤv���U�����جݬݦ��L�ŦX
			
			if (tmp.list[i].getName().contains(keyword)) {		//�I�s�r�ꪺcontains
				if (count >= str.length)
					str = Arrays.copyOf(str, str.length * 2);
				str[count++] = tmp.list[i].getPath();			//���ŦX���K�[�J���G�}�C��
			}
			
			String[] others = {};
			if (tmp.list[i] instanceof CDirectory) {			//�p�G�����جO��Ƨ��A�n�A�����U��
				if (((CDirectory)tmp.list[i]).itemCount > 0)		//�䤤�����حӼƤj��s
					others = search((CDirectory)tmp.list[i],keyword);	//�λ��j���覡�������
			}
			
			for (int k = 0; k < others.length;k++) {
				if (count + others.length >= str.length);
					str = Arrays.copyOf(str, count + others.length);
				str[count++] = others[k];
			}
		}
		str = Arrays.copyOf(str,count);
		return str ;			//�^�ǵ��G�r��
	}
}


