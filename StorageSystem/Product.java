package StorageSystem;
/*
 ���]�y�z�ӫ~�]Product�^���ݩʬ��G
 �ӫ~�s���]Product No.�A�r��^
 �ӫ~�W�١]Product Name�A�r��^
 ����]Price�A��ơ^
 ���]Unit�A�r��^
 �w�s�q�]Stock�A��ơ^
 �s�y�ӡ]Maker�A�r��^
 */
public class Product {
	public final static String UNIT_KG = "����";
	public final static String UNIT_LITRE = "����";
	public final static String UNIT_PRIECE = "��";
	public final static String UNIT_SET = "�x";
	private String productNo = "000";		//�s����001��099
	private String productName = "000";
	private int ProductPrice = 0;
	private String ProductUnit = "000";
	private int ProductStock = 0;
	private String ProductMaker = "000";

	
	
	//��l�ƫغc�l
	public Product (String no, String name, int price, String unit, int stock, String maker) {
		setData(no, name, price, unit, stock, maker);
	}
	public String getProductNo () {
		return this.productNo;
	}
	
	public void addStock(String productNo,int num) {
		this.ProductStock += num;
	}
	public void cutStock(String productNo,int num) {
		this.ProductStock -= num;
	}
	public void setData(String no, String name, int price, String unit, int stock, String maker) {
		if (Product.isValid(no, name, price, unit, stock, maker)) {
			productNo = no;
			productName = name;
			ProductPrice = price;
			ProductUnit = unit;
			ProductStock = stock;
			ProductMaker = maker;
		}
	}
	
	public static boolean isValid(String no, String name, int price, String unit, int stock, String maker) {
		if (price < 0)
			return false;
		if (stock < 0)
			return false;
		return true;
	}
	
	public void print() {
		System.out.printf("%10s\t%12s\t%5d\t%5s\t%5d\t%5s",this.productNo,this.productName,this.ProductPrice,this.ProductUnit,this.ProductStock,this.ProductMaker);
	}


	public int getStock(String no) {
		return this.ProductStock;

	}
	
	
}
