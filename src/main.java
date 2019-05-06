import java.util.Scanner;

public class main {
	public static void main(String[] args) {	
		CliManager cliManager = new CliManager();
		TradeManager recordManager =new TradeManager();
		ProManager proManager =new ProManager();
		Scanner scanner = new Scanner(System.in);
	
		
		while(true) {
			System.out.println("             CRM           ");
			System.out.print("客户管理模块--------------1  ");
			System.out.println("产品管理模块------------2");
			System.out.print("销售记录管理模块----------3  ");
			System.out.println("退出系统---------------0");
			int option =scanner.nextInt();
			switch(option) {
			case 0:                                  
				System.exit(0);
				break;
			case 1:
				int a = 1;       //为了退出而做的准备
				do{
					System.out.println("客户管理系统");
					System.out.print("增加一个客户信息--------------1  ");
					System.out.println("查看所有客户信息------------2");
					System.out.print("根据客户编号查看信息----------3  ");
					System.out.println("根据客户编号修改信息----------4");
					System.out.print("根据客户编号删除客户----------5  ");
					System.out.println("返回上一级-------------------0");
					int opType = scanner.nextInt();
					switch(opType){
					case 0:                       //退出系统
						a = 0;
						break;
					case 1:                      //添加一个客户
						System.out.println("输入要加入的客户信息（以逗号隔开）：编号 姓名 性别 年龄  单个售价  总售额  利润");
						String s = scanner.next();
						String[] info = s.split(",");
						if(info.length != 7){
							System.out.println("输入信息有误");
							break;
						}
					
						Client cli = new Client(info[0], info[1], info[2], Integer.parseInt(info[3]), 
								Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]));
						cliManager.addCli(cli);
						DataBaseOperation.DeleteCliData();
						DataBaseOperation.InsertCliData();
						break;
					case 2:                     //查看所有客户信息
						cliManager.showAllCli();
						DataBaseOperation.DeleteCliData();
						DataBaseOperation.InsertCliData();
						break;
					case 3:                      //根据客户编号查看信息
						System.out.println("请输入客户编号");
						String id = scanner.next();
						cliManager.getOneCliById(id);
					break;
					case 4:                                //根客户编号修改信息
						System.out.println("请输入客户编号");
						String id2 = scanner.next();
						System.out.println("请输入需要修改的内容");
						String key = scanner.next();
						if(!("name".equals(key) || "sex".equals(key) || "age".equals(key) || "singleprice".equals(key) || "sale".equals(key) || "profit".equals(key))){
							System.out.println("输入信息有误");
							break;
						}
						System.out.println("请输入修改后的内容");
						String value = scanner.next();
						cliManager.modifyCli(id2, key, value);
						DataBaseOperation.DeleteCliData();
						DataBaseOperation.InsertCliData();
						break;
					case 5:                              //根据客户编号删除信息
						System.out.println("请输入客户编号");
						String id3 = scanner.next();
						cliManager.delCliById(id3);
						DataBaseOperation.DeleteCliData();
						DataBaseOperation.InsertCliData();
						break;
					default:
						System.out.println("请输入正确的客户编号");
						break;				
						}
					}while(a!=0);
				   break;
				
			case 2:
				int b = 1;           //如a相同作用
				do{
					System.out.println("产品管理模块");
					System.out.print("增加一个产品信息---------------1  ");
					System.out.println("查看所有产品信息-------------2");
					System.out.print("根据产品编号查看信息-----------3  ");
					System.out.println("根据产品编号修改信息----------4");
					System.out.print("根据产品编号删除产品-----------5  ");
					System.out.println("返回上一级-------------------0");
					int opType = scanner.nextInt();
					switch(opType){
					case 0:               //退出系统
						b = 0;
						break;
					case 1:                 //添加一个产品
						System.out.println("输入需加入的产品信息（逗号隔开）：编号 名称 规格 库存  单个售价 进货价 销售额");
						String s = scanner.next();
						String[] info = s.split(",");
						if(info.length != 7){
							System.out.println("输入信息有误");
							break;
						}
						Product pro = new Product(info[0], info[1], info[2], Integer.parseInt(info[3]), 
								Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]));
						proManager.addProduct(pro);
						DataBaseOperation.DeleteProData();
					    DataBaseOperation.InsertProData();
						break;
					case 2:                         //查看所有产品信息
						proManager.showAllProduct();
						DataBaseOperation.DeleteProData();
					    DataBaseOperation.InsertProData();
						break;
					case 3:                       //根据产品编号查看信息
						System.out.println("请输入产品编号");
						String id = scanner.next();
						proManager.getOneProById(id);
						break;
					case 4:                      //根据产品编号修改信息
						System.out.println("请输入产品编号");
						String id2 = scanner.next();
						System.out.println("请输入要修改的内容");
						String key = scanner.next();
						if(!("name".equals(key) || "specification".equals(key) || "stock".equals(key) || "singleprice".equals(key) || "purchaseprice".equals(key) || "currentsale".equals(key))){
							System.out.println("输入信息有误");
							break;
						}
						System.out.println("请输入修改后的内容");
						String value = scanner.next();
					    proManager.modifyPro(id2, key, value);
					    DataBaseOperation.DeleteProData();
					    DataBaseOperation.InsertProData();
						break;
					case 5:                          //根据客户编号删除信息
						System.out.println("请输入产品编号");
						String id3 = scanner.next();
						proManager.delProById(id3);
						DataBaseOperation.DeleteProData();
					    DataBaseOperation.InsertProData();
						break;
					default:
						System.out.println("请输入正确的操作编号");
						break;				
						}
					}while(b!=0);
				break;
			
			case 3:
				int c =1;
				do{
					System.out.println("销售记录管理模块");
					System.out.print("增加销售记录------------------1  ");
					System.out.println("查看所有销售记录-------------2");
					System.out.print("根据订单编号查看记录----------3  ");
					System.out.println("根据订单编号修改记录----------4");
					System.out.print("根据订单编号删除记录----------5  ");
					System.out.println("返回上一级-------------------0");
					int opType = scanner.nextInt();
					switch(opType){
					case 0:                                     //退出系统
						c = 0;
						break;
					case 1:                               //添加一个销售记录
						System.out.println("要加入的销售记录（以逗号隔开）：编号 交易方  商品  数量  单个售价  总售价  利润");
						String s = scanner.next();
						String[] info = s.split(",");
						if(info.length != 7){
							System.out.println("输入信息有误");
							break;
						}
						Trade trade = new Trade(info[0], info[1], info[2], Integer.parseInt(info[3]), 
								Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]));
						recordManager.addRecord(trade);
						DataBaseOperation.DeleteTradeData();
					    DataBaseOperation.InsertTradeData();
						break;
					case 2:                                    //查看所有销售订单信息
						recordManager.showAllRecord();
						DataBaseOperation.DeleteTradeData();
					    DataBaseOperation.InsertTradeData();
						break;
					case 3:                                     //根据订单编号查看信息
						System.out.println("请输入订单编号");
						String id = scanner.next();
						recordManager.getOneRecById(id);
						break;
					case 4:                                //根据订单编号修改信息
						System.out.println("请输入订单编号");
						String id2 = scanner.next();
						System.out.println("请输入要修改的内容");
						String key = scanner.next();
						if(!("name".equals(key) || "product".equals(key) || "num".equals(key) || "singleprice".equals(key) || "Totalprice".equals(key) || "Profit".equals(key))){
							System.out.println("输入信息有误");						
							break;
						}
						System.out.println("请输入修改后的内容");
						String value = scanner.next();
						recordManager.modifyRecord(id2, key, value);
						DataBaseOperation.DeleteTradeData();
					    DataBaseOperation.InsertTradeData();
						break;
					case 5:                                //根据订单编号删除信息
						System.out.println("请输入订单编号");
						String id3 = scanner.next();
						recordManager.delRecById(id3);
						DataBaseOperation.DeleteTradeData();
					    DataBaseOperation.InsertTradeData();
						break;
					default:
						System.out.println("请输入正确的操作编号");
						break;				
						}
					}while(c!=0);
				break;						
				}
			}
		}
	}