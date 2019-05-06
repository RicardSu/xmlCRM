
public class Client {
	private String id;      //编号
	private String name;      //姓名
	private String sex;    //性别
	private int age;        //年龄
	private double singleprice;         //产品单个出售价
	private double sale;            //总共销售额
	private double profit;        //所获得利润
	public Client(String id, String name, String sex, int age, double singleprice,
			double sale, double profit) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.singleprice = singleprice;
		this.sale = sale;
		this.profit= profit;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getPrice() {
		return singleprice;
	}
	public void setPrice(double singleprice) {
		this.singleprice = singleprice;
	}
	public double getSale() {
		return sale;
	}
	public void setSale(double sale) {
		this.sale = sale;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
}
