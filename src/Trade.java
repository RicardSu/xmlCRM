
public class Trade {
	private String id;          //������
	private String name;            //���׷�
	private String product;       //���ײ�Ʒ
	private int num;        //���׷�����
	private double singleprice;           //�������ۼ�
	private double Totalprice;           //�ܹ����ۼ�
	private double Profit;         //�������
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
