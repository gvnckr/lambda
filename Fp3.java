package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fp3 {
    public static void main(String[] args) {
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Amanda");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Benjamin");
        System.out.println(liste);
        buyukharfleyazdir(liste);
        System.out.println();
        uzunlugaGoreYazdir(liste);
        System.out.println();
        uzunluklaraGoreTersSirala(liste);
        System.out.println();
        sonkarekterlerineGoreSirala(liste);
        System.out.println();
        uzunlukVeilkKarektereGoreYazdir(liste);
        System.out.println();
       // uzunlugubestenBuyukOlanlariSil(liste);
       // baslangiciAyadaSonuNolanSil(liste);
        System.out.println("uzunlugu 12 den azMI :" +uzunluklariOnikidenAzMı(liste));
        System.out.println(" xilebaslamiyormu :" + xileBaslamiyorMu(liste));
        System.out.println(" rilebitenVarmi :" + rileBitenVerMı(liste));

    }
////1) Tüm elemanları büyük harf ile yazdıran bir method oluşturun. 1,yol
    public static void buyukharfleyazdir(List<String>list){
        list.stream().map(String::toUpperCase).forEach(Utils::ayniSatirdaBosluklaYazdir);


    }
//2.yol
  /*public static void buyukharfleyazdir2(List<String>list){
        list.replaceAll(String::toUpperCase);
    System.out.println(list);
    */
////2) Elemanları uzunluklarına göre sıralayıp yazdıran bir method oluşturun.
    public static void uzunlugaGoreYazdir(List<String>list){
        list.stream().sorted(Comparator.comparing(String::length)).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }                 //Siralama kosulunu belirtmek icin

////3) Elemanları uzunluklarına göre ters sıralayıp yazdıran bir method oluşturun.
    public static void uzunluklaraGoreTersSirala(List<String>list){
        list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils::ayniSatirdaBosluklaYazdir);
                             //karsilastir        //uzunluklara gore
    }
////4) Elemanları son karakterlerine göre sıralayıp tekrarsız yazdıran bir method oluşturun.
    public static void sonkarekterlerineGoreSirala(List<String>list){

        list.stream().distinct().sorted(Comparator.comparing(Utils::sonkarekteral)).forEach(Utils::ayniSatirdaBosluklaYazdir);

    }
////5) Elemanları önce uzunluklarına göre ve sonra ilk karakterine göre sıralayıp yazdıran bir method oluşturun.

    public static void uzunlukVeilkKarektereGoreYazdir(List<String>list){
        list.stream().sorted(Comparator.comparing(String::length).thenComparing(Utils::ilkkarekteral)).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

////6) Uzunluğu 5'ten büyük olan elemanları silen bir method oluşturun.
 /*   public static void uzunlugubestenBuyukOlanlariSil(List<String>list){
        list.removeIf(t->t.length()>5);
        System.out.println(list);
          ===>>>>> list mutable oldugu icin elemanlar islem sonrasi kalici oldugu icin yotuma alindi
    }*/
////7) ‘A’, ‘a’ ile başlayan yada ‘N’, ‘n’ ile biten elemanları silen bir method oluşturun.
  /*  public static void baslangiciAyadaSonuNolanSil(List<String>list){

      list.removeIf(t->t.startsWith("A")||t.startsWith("a")||t.endsWith("n")||t.endsWith("N"));
        System.out.println(list);
    }
*/
//8) Uzunluğu 8 ile 10 arası olan yada 'o' ile biten elemanları yazdıran bir method oluşturun.//   public static void uzunlugu8ile10arasiveOIleBiteniSil(List<String > list){
//
//        list.removeIf(t->(t.length()>7 && t.length()<11) || t.endsWith("o"));
//        System.out.println(list);

////9) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol eden bir method oluşturun.
    public static boolean uzunluklariOnikidenAzMı(List<String>list){

        return list.stream().allMatch(t->t.length()<12);
    }
//10) Hiçbir elemanın 'X' ile başlamadığını kontrol eden bir method oluşturun.

public static boolean xileBaslamiyorMu(List<String>list){


        return list.stream().noneMatch(t->t.startsWith("x"));
}

//11) Herhangi bir elemanın 'r' ile bitip bitmediğini kontrol eden bir method oluşturun.
    public static boolean rileBitenVerMı(List<String>list){

        return list.stream().anyMatch(t->t.endsWith("r"));
    }


}

