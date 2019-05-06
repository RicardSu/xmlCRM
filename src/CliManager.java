import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class CliManager {
	private Document doc = null;
	
	public CliManager() {
		SAXReader saxReader = new SAXReader();
		try {
			doc = saxReader.read("client.xml");
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
	}

	public void addCli(Client cli){    //���ӿͻ�
		Element addCli = DocumentHelper.createElement("client");
		
		Element cli_id = DocumentHelper.createElement("id");
		cli_id.setText(cli.getId());
		Element cli_name = DocumentHelper.createElement("name");
		cli_name.setText(cli.getName());
		Element cli_sex = DocumentHelper.createElement("sex");
		cli_sex.setText(cli.getSex());
		Element cli_age = DocumentHelper.createElement("age");
		cli_age.setText(cli.getAge()+"");
		Element cli_single = DocumentHelper.createElement("singleprice");
		cli_single.setText(cli.getPrice()+"");
		Element cli_sale = DocumentHelper.createElement("sale");
		cli_sale.setText(cli.getSale()+"");
		Element cli_profit = DocumentHelper.createElement("profit");
		cli_profit.setText(cli.getProfit()+"");
		addCli.add(cli_id);
		addCli.add(cli_single);
		addCli.add(cli_sale);
		addCli.add(cli_profit);
		addCli.add(cli_name);
		addCli.add(cli_sex);
		addCli.add(cli_age);
		doc.getRootElement().add(addCli);
		updateXML();
	}
	
//��ʾ���пͻ���Ϣ
	private Element getElementById(String id){
		List list = doc.getRootElement().elements();
		for(int i = 0; i<list.size();i++){
			Element cli = (Element) list.get(i);
			if (cli.element("id").getText().equals(id)) {
				return cli;
			}
		}
		return null;
	}
	
	//�ɿͻ���ŵõ��ͻ���Ϣ
	public void getOneCliById(String id){
		Element cli = getElementById(id);
		if(cli == null){
			System.out.println("�ÿͻ�������");
			return;
		}
		System.out.println("���\t����\t�Ա�\t����\t�����ۼ�\t���۶�\t����");
		System.out.println(cli.elementText("id")+"\t"+cli.elementText("name")+"\t"+cli.elementText("sex")+"\t"
				+cli.elementText("age")+"\t"+cli.elementText("singleprice")+"\t"+cli.elementText("sale")+"\t"+
				cli.elementText("profit"));
	}
	
	//�޸���صĿͻ���Ϣ id �Ǳ��   key����Ҫ�޸ĵ�����   value���޸ĺ��ֵ
	public void modifyCli(String id,String key,String value){
		Element cli = getElementById(id);
		cli.element(key).setText(value);
		updateXML();
	}
	//���ݿͻ����ɾ����Ӧ��Ϣ
	public void delCliById(String id){
		Element cli = getElementById(id);
		if(cli == null){
			System.out.println("Ҫɾ����Ԫ�ز�����!");
			return;
		}
		cli.getParent().remove(cli);
		updateXML();
	}
	
	//��XML�ĵ�����ˢ��
	private void updateXML(){
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("utf-8");
		try {
			XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(new File("client.xml")),"utf-8"), outputFormat);
			xmlWriter.write(doc);
			xmlWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showAllCli() {
		List cliList = doc.getRootElement().elements("client");
		if(cliList.size() == 0){
			System.out.println("û�пͻ���Ϣ");
			System.out.println("\n");
			return;
		}
		System.out.println("���\t����\t�Ա�\t����\t�����ۼ�\t���۶�\t����");
		for(int i = 0; i<cliList.size();i++){
			Element cli = (Element) cliList.get(i);
			System.out.println(cli.elementText("id")+"\t"+cli.elementText("name")+"\t"+cli.elementText("sex")+"\t"
					+cli.elementText("age")+"\t"+cli.elementText("singleprice")+"\t"+cli.elementText("sale")+"\t"+
					cli.elementText("profit"));
		}
		
	}
}
