package utils;

public class BookDemoCall {
	public static void main(String[] args) {
		String pp=System.getProperty("user.dir");
		Bookingutils x=new Bookingutils(pp+"\\Excel\\bookingtest.xlsx","Sheet2");
		x.getColCount();
		x.getRowCount();
		x.getCellDataString(0, 0);
		x.getCellDataNumber(1, 1);
		
	}
}
