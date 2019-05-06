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

public class TradeManager {
	private Document doc = null;
	public TradeManager() {
		SAXReader saxReader = new SAXReader();
		try {
			doc = saxReader.read("Trade.xml");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Element getElementById(String id){
		List list = doc.getRootElement().elements();
		for(int i = 0; i<list.size();i++){
			Element record = (Element) list.get(i);
			if (record.element("id").getText().equals(id)) {
				return record;
			}
		}
		return null;
	}
	
	public void getOneRecById(String id){
		Element record = getElementById(id);
		if(record == null){
			System.out.println("该记录不存在");
			return;
		}
		System.out.println("订单编号\t交易方\t商品\t年龄\t单个售价\t总售价\t利润");
		System.out.println(record.elementText("id")+"\t"+record.elementText("name")+"\t"+record.elementText("product")+"\t"
				+record.elementText("num")+"\t"+record.elementText("singleprice")+"\t"+record.elementText("Totalprice")+"\t"+
				record.elementText("Profit"));
	}
	
	public void modifyRecord(String id,String key,String value){
		Element record = getElementById(id);
		record.element(key).setText(value);
		updateXML();
	}
	
	
	public void delRecById(String id){
		Element record = getElementById(id);
		if(record == null){
			System.out.println("要删除的元素不存在!");
			return;
		}
		record.getParent().remove(record);
		updateXML();
	}
	
	private void updateXML(){
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("utf-8");
		try {
			XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(new File("Trade.xml")),"utf-8"), outputFormat);
			xmlWriter.write(doc);
			xmlWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addRecord(Trade record) {
		Element addRecord = DocumentHelper.createElement("record");
		
		Element record_id = DocumentHelper.createElement("id");
		record_id.setText(record.getId());
		
		Element record_name = DocumentHelper.createElement("name");
		record_name.setText(record.getName());
		
		Element record_product = DocumentHelper.createElement("product");
		record_product.setText(record.getPro());
		
		Element record_num = DocumentHelper.createElement("num");
		record_num.setText(record.getNum()+"");
		
		Element record_single = DocumentHelper.createElement("singleprice");
		record_single.setText(record.getSingle()+"");
		
		Element record_Total = DocumentHelper.createElement("Totalprice");
		record_Total.setText(record.getTotal()+"");
		
		Element record_profit = DocumentHelper.createElement("Profit");
		record_profit.setText(record.getProfit()+"");
		
		addRecord.add(record_id);
		addRecord.add(record_single);
		addRecord.add(record_Total);
		addRecord.add(record_profit);
		addRecord.add(record_name);
		addRecord.add(record_product);
		addRecord.add(record_num);
		
		doc.getRootElement().add(addRecord);
		updateXML();
		// TODO Auto-generated method stub
		
	}

	public void showAllRecord() {
		List recordList = doc.getRootElement().elements("record");
		if(recordList.size() == 0){
			System.out.println("没有销售记录");
			System.out.println("\n");
			return;
		}
		System.out.println("编号\t交易方\t产品\t数量\t单个售价\t总售价\t利润");
		for(int i = 0; i<recordList.size();i++){
			Element record = (Element) recordList.get(i);
			System.out.println(record.elementText("id")+"\t"+record.elementText("name")+"\t"+record.elementText("product")+"\t"
					+record.elementText("num")+"\t"+record.elementText("singleprice")+"\t"+record.elementText("Totalprice")+"\t"+
					record.elementText("Profit"));
		}
		// TODO Auto-generated method stub
		
	}
}
