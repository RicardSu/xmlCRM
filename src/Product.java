
public class Product {
	private String id;           //编号
	private String name;        //名称
	private String specification;     //规格
	private int stock;           //库存
	private double singleprice;       //单个销售额
	private double purchaseprice;        //进货价
	private double currentsale;       //目前销售额
	public Product(String id, String name, String specification, int stock, double singleprice,
			double purchaseprice, double currentsale) {
		this.id = id;
		this.name = name;
		this.specification = specification;
		this.stock = stock;
		this.singleprice = singleprice;
		this.purchaseprice = purchaseprice;
		this.currentsale = currentsale;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpe() {
		return specification;
	}
	public void setSpe(String specification) {
		this.specification = specification;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getSingle() {
		return singleprice;
	}
	public void setSingle(double singleprice) {
		this.singleprice = singleprice;
	}
	public double getPurchase() {
		return purchaseprice;
	}
	public void setPurchase(double purchaseprice) {
		this.purchaseprice = purchaseprice;
	}
	public double getCurrent() {
		return currentsale;
	}
	public void setCurrent(double currentsale) {
		this.currentsale = currentsale;
	}
}
