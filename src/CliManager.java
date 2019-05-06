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

	public void addCli(Client cli){    //增加客户
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
	
//显示所有客户信息
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
	
	//由客户编号得到客户信息
	public void getOneCliById(String id){
		Element cli = getElementById(id);
		if(cli == null){
			System.out.println("该客户不存在");
			return;
		}
		System.out.println("编号\t姓名\t性别\t年龄\t单个售价\t总售额\t利润");
		System.out.println(cli.elementText("id")+"\t"+cli.elementText("name")+"\t"+cli.elementText("sex")+"\t"
				+cli.elementText("age")+"\t"+cli.elementText("singleprice")+"\t"+cli.elementText("sale")+"\t"+
				cli.elementText("profit"));
	}
	
	//修改相关的客户信息 id 是编号   key是需要修改的内容   value是修改后的值
	public void modifyCli(String id,String key,String value){
		Element cli = getElementById(id);
		cli.element(key).setText(value);
		updateXML();
	}
	//根据客户编号删除相应信息
	public void delCliById(String id){
		Element cli = getElementById(id);
		if(cli == null){
			System.out.println("要删除的元素不存在!");
			return;
		}
		cli.getParent().remove(cli);
		updateXML();
	}
	
	//对XML文档进行刷新
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
			System.out.println("没有客户信息");
			System.out.println("\n");
			return;
		}
		System.out.println("编号\t姓名\t性别\t年龄\t单个售价\t总售额\t利润");
		for(int i = 0; i<cliList.size();i++){
			Element cli = (Element) cliList.get(i);
			System.out.println(cli.elementText("id")+"\t"+cli.elementText("name")+"\t"+cli.elementText("sex")+"\t"
					+cli.elementText("age")+"\t"+cli.elementText("singleprice")+"\t"+cli.elementText("sale")+"\t"+
					cli.elementText("profit"));
		}
		
	}
}
