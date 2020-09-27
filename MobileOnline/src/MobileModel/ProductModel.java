package MobileModel;

public class ProductModel {
 String pname,category,brand,ram,rom,processor,battery,descrptn;
 int pid,price;

public ProductModel() {
	super();
}

public ProductModel(int pid, String pname,String category, String brand, String ram, String rom, String processor, String battery,
		int price, String descrptn) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.category=category;
	this.brand = brand;
	this.ram = ram;
	this.rom = rom;
	this.processor = processor;
	this.battery = battery;
	this.price = price;
	this.descrptn = descrptn;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}

public String getCategory()
{
	return category;
}

public void setCategory(String category)
{
	this.category = category;
}
public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public String getRam() {
	return ram;
}

public void setRam(String ram) {
	this.ram = ram;
}

public String getRom() {
	return rom;
}

public void setRom(String rom) {
	this.rom = rom;
}

public String getProcessor() {
	return processor;
}

public void setProcessor(String processor) {
	this.processor = processor;
}

public String getBattery() {
	return battery;
}

public void setBattery(String battery) {
	this.battery = battery;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getDescrptn() {
	return descrptn;
}

public void setDescrptn(String descrptn) {
	this.descrptn = descrptn;
}
 
}
