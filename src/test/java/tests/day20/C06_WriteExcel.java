package tests.day20;

import org.apache.logging.log4j.spi.LoggerRegistry;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C06_WriteExcel {

    @Test
    public void test01() throws IOException {

        // ulkeler excel'ine 5.sutun olarak NUFUS sutunu ekleyelim
        // 3.satirdaki ulkenin nufusunu 1000000 yapalim

        String path="src/test/java/resourses/ulkeler.xlsx";// 1-dosyaya ulastik
        FileInputStream fis=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fis); // 2-class'ta calismak icin dosyanin bir kopyasi olan workbook olusturalim
        //3- dosyada yapmak istedigimiz degisiklikleri
        // kopya workbook'da yapalim

        // ilk satirin 5.hucresine NUFUS basligini yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");

        // 3.satirdaki ulkenin nufusunu 1000000 yapalim
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1000000");

        // 4- kopyada yaptigimiz degisiklikleri ana dosyaya kaydedelim
        FileOutputStream fos=new FileOutputStream(path);
        workbook.write(fos);



    }


}
