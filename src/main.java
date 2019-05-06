import java.util.Scanner;

public class main {
	public static void main(String[] args) {	
		CliManager cliManager = new CliManager();
		TradeManager recordManager =new TradeManager();
		ProManager proManager =new ProManager();
		Scanner scanner = new Scanner(System.in);
	
		
		while(true) {
			System.out.println("             CRM           ");
			System.out.print("�ͻ�����ģ��--------------1  ");
			System.out.println("��Ʒ����ģ��------------2");
			System.out.print("���ۼ�¼����ģ��----------3  ");
			System.out.println("�˳�ϵͳ---------------0");
			int option =scanner.nextInt();
			switch(option) {
			case 0:                                  
				System.exit(0);
				break;
			case 1:
				int a = 1;       //Ϊ���˳�������׼��
				do{
					System.out.println("�ͻ�����ϵͳ");
					System.out.print("����һ���ͻ���Ϣ--------------1  ");
					System.out.println("�鿴���пͻ���Ϣ------------2");
					System.out.print("���ݿͻ���Ų鿴��Ϣ----------3  ");
					System.out.println("���ݿͻ�����޸���Ϣ----------4");
					System.out.print("���ݿͻ����ɾ���ͻ�----------5  ");
					System.out.println("������һ��-------------------0");
					int opType = scanner.nextInt();
					switch(opType){
					case 0:                       //�˳�ϵͳ
						a = 0;
						break;
					case 1:                      //���һ���ͻ�
						System.out.println("����Ҫ����Ŀͻ���Ϣ���Զ��Ÿ���������� ���� �Ա� ����  �����ۼ�  ���۶�  ����");
						String s = scanner.next();
						String[] info = s.split(",");
						if(info.length != 7){
							System.out.println("������Ϣ����");
							break;
						}
					
						Client cli = new Client(info[0], info[1], info[2], Integer.parseInt(info[3]), 
								Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]));
						cliManager.addCli(cli);
						DataBaseOperation.DeleteCliData();
						DataBaseOperation.InsertCliData();
						break;
					case 2:                     //�鿴���пͻ���Ϣ
						cliManager.showAllCli();
						DataBaseOperation.DeleteCliData();
						DataBaseOperation.InsertCliData();
						break;
					case 3:                      //���ݿͻ���Ų鿴��Ϣ
						System.out.println("������ͻ����");
						String id = scanner.next();
						cliManager.getOneCliById(id);
					break;
					case 4:                                //���ͻ�����޸���Ϣ
						System.out.println("������ͻ����");
						String id2 = scanner.next();
						System.out.println("��������Ҫ�޸ĵ�����");
						String key = scanner.next();
						if(!("name".equals(key) || "sex".equals(key) || "age".equals(key) || "singleprice".equals(key) || "sale".equals(key) || "profit".equals(key))){
							System.out.println("������Ϣ����");
							break;
						}
						System.out.println("�������޸ĺ������");
						String value = scanner.next();
						cliManager.modifyCli(id2, key, value);
						DataBaseOperation.DeleteCliData();
						DataBaseOperation.InsertCliData();
						break;
					case 5:                              //���ݿͻ����ɾ����Ϣ
						System.out.println("������ͻ����");
						String id3 = scanner.next();
						cliManager.delCliById(id3);
						DataBaseOperation.DeleteCliData();
						DataBaseOperation.InsertCliData();
						break;
					default:
						System.out.println("��������ȷ�Ŀͻ����");
						break;				
						}
					}while(a!=0);
				   break;
				
			case 2:
				int b = 1;           //��a��ͬ����
				do{
					System.out.println("��Ʒ����ģ��");
					System.out.print("����һ����Ʒ��Ϣ---------------1  ");
					System.out.println("�鿴���в�Ʒ��Ϣ-------------2");
					System.out.print("���ݲ�Ʒ��Ų鿴��Ϣ-----------3  ");
					System.out.println("���ݲ�Ʒ����޸���Ϣ----------4");
					System.out.print("���ݲ�Ʒ���ɾ����Ʒ-----------5  ");
					System.out.println("������һ��-------------------0");
					int opType = scanner.nextInt();
					switch(opType){
					case 0:               //�˳�ϵͳ
						b = 0;
						break;
					case 1:                 //���һ����Ʒ
						System.out.println("���������Ĳ�Ʒ��Ϣ�����Ÿ���������� ���� ��� ���  �����ۼ� ������ ���۶�");
						String s = scanner.next();
						String[] info = s.split(",");
						if(info.length != 7){
							System.out.println("������Ϣ����");
							break;
						}
						Product pro = new Product(info[0], info[1], info[2], Integer.parseInt(info[3]), 
								Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]));
						proManager.addProduct(pro);
						DataBaseOperation.DeleteProData();
					    DataBaseOperation.InsertProData();
						break;
					case 2:                         //�鿴���в�Ʒ��Ϣ
						proManager.showAllProduct();
						DataBaseOperation.DeleteProData();
					    DataBaseOperation.InsertProData();
						break;
					case 3:                       //���ݲ�Ʒ��Ų鿴��Ϣ
						System.out.println("�������Ʒ���");
						String id = scanner.next();
						proManager.getOneProById(id);
						break;
					case 4:                      //���ݲ�Ʒ����޸���Ϣ
						System.out.println("�������Ʒ���");
						String id2 = scanner.next();
						System.out.println("������Ҫ�޸ĵ�����");
						String key = scanner.next();
						if(!("name".equals(key) || "specification".equals(key) || "stock".equals(key) || "singleprice".equals(key) || "purchaseprice".equals(key) || "currentsale".equals(key))){
							System.out.println("������Ϣ����");
							break;
						}
						System.out.println("�������޸ĺ������");
						String value = scanner.next();
					    proManager.modifyPro(id2, key, value);
					    DataBaseOperation.DeleteProData();
					    DataBaseOperation.InsertProData();
						break;
					case 5:                          //���ݿͻ����ɾ����Ϣ
						System.out.println("�������Ʒ���");
						String id3 = scanner.next();
						proManager.delProById(id3);
						DataBaseOperation.DeleteProData();
					    DataBaseOperation.InsertProData();
						break;
					default:
						System.out.println("��������ȷ�Ĳ������");
						break;				
						}
					}while(b!=0);
				break;
			
			case 3:
				int c =1;
				do{
					System.out.println("���ۼ�¼����ģ��");
					System.out.print("�������ۼ�¼------------------1  ");
					System.out.println("�鿴�������ۼ�¼-------------2");
					System.out.print("���ݶ�����Ų鿴��¼----------3  ");
					System.out.println("���ݶ�������޸ļ�¼----------4");
					System.out.print("���ݶ������ɾ����¼----------5  ");
					System.out.println("������һ��-------------------0");
					int opType = scanner.nextInt();
					switch(opType){
					case 0:                                     //�˳�ϵͳ
						c = 0;
						break;
					case 1:                               //���һ�����ۼ�¼
						System.out.println("Ҫ��������ۼ�¼���Զ��Ÿ���������� ���׷�  ��Ʒ  ����  �����ۼ�  ���ۼ�  ����");
						String s = scanner.next();
						String[] info = s.split(",");
						if(info.length != 7){
							System.out.println("������Ϣ����");
							break;
						}
						Trade trade = new Trade(info[0], info[1], info[2], Integer.parseInt(info[3]), 
								Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]));
						recordManager.addRecord(trade);
						DataBaseOperation.DeleteTradeData();
					    DataBaseOperation.InsertTradeData();
						break;
					case 2:                                    //�鿴�������۶�����Ϣ
						recordManager.showAllRecord();
						DataBaseOperation.DeleteTradeData();
					    DataBaseOperation.InsertTradeData();
						break;
					case 3:                                     //���ݶ�����Ų鿴��Ϣ
						System.out.println("�����붩�����");
						String id = scanner.next();
						recordManager.getOneRecById(id);
						break;
					case 4:                                //���ݶ�������޸���Ϣ
						System.out.println("�����붩�����");
						String id2 = scanner.next();
						System.out.println("������Ҫ�޸ĵ�����");
						String key = scanner.next();
						if(!("name".equals(key) || "product".equals(key) || "num".equals(key) || "singleprice".equals(key) || "Totalprice".equals(key) || "Profit".equals(key))){
							System.out.println("������Ϣ����");						
							break;
						}
						System.out.println("�������޸ĺ������");
						String value = scanner.next();
						recordManager.modifyRecord(id2, key, value);
						DataBaseOperation.DeleteTradeData();
					    DataBaseOperation.InsertTradeData();
						break;
					case 5:                                //���ݶ������ɾ����Ϣ
						System.out.println("�����붩�����");
						String id3 = scanner.next();
						recordManager.delRecById(id3);
						DataBaseOperation.DeleteTradeData();
					    DataBaseOperation.InsertTradeData();
						break;
					default:
						System.out.println("��������ȷ�Ĳ������");
						break;				
						}
					}while(c!=0);
				break;						
				}
			}
		}
	}