package utils;

public class Calldemo {
public static void main(String[] args) {
	String pp=System.getProperty("user.dir");
	Excelutils xcel=new Excelutils(pp+"\\Excel\\test_input.xlsx","Sheet1");
	
	xcel.getRowcount();
	xcel.getColcount();
	xcel.getCelldataString(0, 0);
	xcel.getCelldataNumber(1, 1);
	
	
}
}
