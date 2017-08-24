package StorageSystem;
public class Storage {
	private Product product[] = new Product[50];
	private int count = 0; //目前儲存的資料筆數
	
	public Storage() {};
	
	//目前儲存的資料筆數
	public void add(String no, String name, int price, String unit, int stock, String maker) {
		Product newProduct = new Product (no,name,price,unit,stock,maker);
		this.product[this.count++] = newProduct;
		//將新物件的位址存入陣列中
	}
	
	public void exportProdcut (String no, int num) {
		int i = findProduct(no);
		product[i].cutStock(no,num);
	}
	
	public void importProduct (String no, int num) {
		int i = findProduct(no);
		product[i].addStock(no,num);
	}
	
	public int findProduct (String no) {
		for (int i = 0; i < count; i++) {
			if (this.product[i].getProductNo().equals(no)) {
				return i;
			}
		}
		return -1;
	}
	public int findStock (String no) {
		for (int i = 0; i < count; i++) {
			if (this.product[i].getProductNo().equals(no)) {
				return this.product[i].getStock(no);
			}
		}
		return 0;
	}
	
	
	public void print() {
		for (int i = 0; i < count; i++) {
			this.product[i].print();
			System.out.println("");
		}
	}



}
