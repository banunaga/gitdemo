package naga;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	XSSFSheet sheet1;
	static int cellindex = 0;
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\user\\Desktop\\test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetcount = workbook.getNumberOfSheets();
		for(int i=0;i<sheetcount;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet1 = workbook.getSheetAt(i);
				Iterator<Row> row =sheet1.rowIterator();// collection of rows is sheet
				//Row firstrow = row.next();
				//Iterator<Cell> ce = firstrow.cellIterator(); collection of cells is row
				while(row.hasNext())
				{
					Row r = row.next();
					if(r.getCell(cellindex).getStringCellValue().equalsIgnoreCase("purchase"))
					{
						Iterator<Cell> ce = r.cellIterator();
						while(ce.hasNext())
						{
							Cell c = ce.next();
							if(c.getCellType()==CellType.STRING)
							{
							a.add(c.getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				
				}
			}
			
			}
		for(String b:a)
		{
			System.out.println(b);
		}
		
	}
		
	}
	

