

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


public class ProManager {
	private Document doc = null;
	
	public ProManager() {
		SAXReader saxReader = new SAXReader();
		try {
			doc = saxReader.read("product.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	
	//显示所有商品信息
	public void showAllProduct(){
		List proList = doc.getRootElement().elements("product");
		if(proList.size() == 0){
			System.out.println("没有产品信息");
			System.out.println("\n");
			return;
		}
		System.out.println("编号\t名称\t规格\t库存\t单个售价\t进货价\t销售额");
		for(int i = 0; i<proList.size();i++){
			Element pro = (Element) proList.get(i);
			System.out.println(pro.elementText("id")+"\t"+pro.elementText("name")+"\t"+pro.elementText("specification")+"\t"
					+pro.elementText("stock")+"\t"+pro.elementText("singleprice")+"\t"+pro.elementText("purchaseprice")+"\t"+
					pro.elementText("currentsale"));
		}
	}
	//由商品编号查询商品
	private Element getElementById(String id){
		List list = doc.getRootElement().elements();
		for(int i = 0; i<list.size();i++){
			Element pro = (Element) list.get(i);
			if (pro.element("id").getText().equals(id)) {
				return pro;
			}
		}
		return null;
	}
//得到相应商品编号内信息
	public void getOneProById(String id){
		Element pro = getElementById(id);
		if(pro == null){
			System.out.println("该产品不存在");
			return;
		}
		System.out.println("编号\t名称\t规格\t库存\t单个售价\t进货价\t销售额");
		System.out.println(pro.element("id")+"\t"+pro.elementText("name")+"\t"+pro.elementText("specification")+"\t"
				+pro.elementText("stock")+"\t"+pro.elementText("singleprice")+"\t"+pro.elementText("purchaseprice")+"\t"+
				pro.elementText("currentsale"));
	}
	
//删除相应编号的产品
	public void delProById(String id){
		Element pro = getElementById(id);
		if(pro == null){
			System.out.println("要删除的元素不存在!");
			return;
		}
		pro.getParent().remove(pro);
		updateXML();
	}
	private void updateXML(){
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setEncoding("utf-8");
		try {
			XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(new File("product.xml")),"utf-8"), outputFormat);
			xmlWriter.write(doc);
			xmlWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//增加商品
	public void addProduct(Product pro) {
		Element addProduct = DocumentHelper.createElement("product");
		Element Pro_id = DocumentHelper.createElement("id");
		Pro_id.setText(pro.getId());
		Element Pro_name = DocumentHelper.createElement("name");
		Pro_name.setText(pro.getName());
		Element Pro_spe = DocumentHelper.createElement("specification");
		Pro_spe.setText(pro.getSpe());
		Element Pro_stock = DocumentHelper.createElement("stock");
		Pro_stock.setText(pro.getStock()+"");

		Element Pro_single = DocumentHelper.createElement("singleprice");
		Pro_single.setText(pro.getSingle()+"");
		Element Pro_purchaseprice = DocumentHelper.createElement("purchaseprice");
		Pro_purchaseprice.setText(pro.getPurchase()+"");
		Element Pro_currentsale = DocumentHelper.createElement("currentsale");
		Pro_currentsale.setText(pro.getCurrent()+"");
		addProduct.add(Pro_id);
		addProduct.add(Pro_single);
		addProduct.add(Pro_purchaseprice);
		addProduct.add(Pro_currentsale);
		addProduct.add(Pro_name);
		addProduct.add(Pro_stock);
		addProduct.add(Pro_spe);

		doc.getRootElement().add(addProduct);
		updateXML();
		// TODO Auto-generated method stub
		
	}

//key 需要修改的元素     value 更改后的值
	public void modifyPro(String id2, String key, String value) {
		Element pro = getElementById(id2);
		pro.element(key).setText(value);
		updateXML();
		// TODO Auto-generated method stub
		
	}
}
