package naga;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven1 {
	
@DataProvider
public Object[][] getData() throws IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\user\\Desktop\\Social.xlsx");
	XSSFWorkbook book=new XSSFWorkbook(fis);
	int scount = book.getNumberOfSheets();
	XSSFSheet sheet= book.getSheetAt(0);
	int rowcount = sheet.getLastRowNum()+1;
	Object[][] ob = new Object[rowcount][2];
	Iterator<Row> row = sheet.rowIterator();
	int i=0;
	while(row.hasNext())
	{
		Row r = row.next();
		for(int l=0;l<2;l++)
		{
			ob[i][l]=r.getCell(l).getStringCellValue();
		}
		i++;
	}
		
	return ob;
}

@Test(dataProvider="getData")
public void getDisplay(String uname, String pass)
{
	System.out.println(uname);
	System.out.println(pass);
}
}
