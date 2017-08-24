package StorageSystem;
/*
 假設描述商品（Product）的屬性為：
 商品編號（Product No.，字串）
 商品名稱（Product Name，字串）
 單價（Price，整數）
 單位（Unit，字串）
 庫存量（Stock，整數）
 製造商（Maker，字串）
 */
public class Product {
	public final static String UNIT_KG = "公斤";
	public final static String UNIT_LITRE = "公升";
	public final static String UNIT_PRIECE = "個";
	public final static String UNIT_SET = "台";
	private String productNo = "000";		//編號為001到099
	private String productName = "000";
	private int ProductPrice = 0;
	private String ProductUnit = "000";
	private int ProductStock = 0;
	private String ProductMaker = "000";

	
	
	//初始化建構子
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
