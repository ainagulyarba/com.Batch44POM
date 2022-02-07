package tests.day20;

import org.testng.annotations.Test;

public class C05_ExceliMapeYukleme {

    @Test
    public void test01(){

        // dosya yolu ve sayfa ismi verilen bir excel sheet'i Map olarak kaydeden
        // reusable bir () olusturalim

        String path="src/test/java/resourses/ulkeler.xlsx";
        String sayfaAdi="Sayfa1";
        System.out.println(ReusableMethods.mapOlustur(path, sayfaAdi));


    }








}
