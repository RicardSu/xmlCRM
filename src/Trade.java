
public class Trade {
	private String id;          //订单号
	private String name;            //交易方
	private String product;       //交易产品
	private int num;        //交易方数量
	private double singleprice;           //单个销售价
	private double Totalprice;           //总共销售价
	private double Profit;         //获得利润
	public Trade(String id, String name, String product, int num, double singleprice,
			double Totalprice, double Profit) {
		this.id = id;
		this.name = name;
		this.product = product;
		this.num = num;
		this.singleprice =singleprice;
		this.Totalprice = Totalprice;
		this.Profit = Profit;
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
	public String getPro() {
		return product;
	}
	public void setPro(String product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getSingle() {
		return singleprice;
	}
	public void setSingle(double singleprice) {
		this.singleprice = singleprice;
	}
	public double getTotal() {
		return Totalprice;
	}
	public void setTotal(double Totalprice) {
		this.Totalprice = Totalprice;
	}
	public double getProfit() {
		return Profit;
	}
	public void setProfit(double Profit) {
		this.Profit = Profit;
	}
}
