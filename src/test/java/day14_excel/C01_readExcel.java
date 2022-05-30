package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_readExcel {
    @Test
    public void readExcelTest() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyolu = "src/resources/ulkeler.xlsx";


        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        //  WorkbookFactory.create(fileInputStream)

        //11. Sheet objesi olusturun //workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");
        //12. Row objesi olusturun //sheet.getRow(index)

        Row row =sheet.getRow(3);

        //13. Cell objesi olusturun //row.getCell(index)

        Cell cell = row.getCell(3);

        System.out.println(cell);

        // 3. satırın 3. indexindeki datanın Cezayir oldugunu test edin.

        String expectedData = "Cezeyir";
        String ectualData = cell.toString();

       Assert.assertEquals(expectedData,ectualData);
       //  Assert.assertEquals(expectedData, cell.getStringCellValue());

    }
}
