package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp2 {
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        System.out.println(liste);
        listElemanlariniYazdirFunctional(liste);
        System.out.println();
        ciftelementleriYazdir(liste);
        System.out.println();
        tekEleamlarinKareleriniYazdir(liste);
        System.out.println();
        tekElemanlarinKupleriniTekrarsizYazdir(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKaresiToplami(liste);
        tekrarsizCiftElemanlarinKaresiToplami(liste);
        tekrarsizCiftElemanlarinKaresiToplami(liste);
        tekrarsizCiftElemanlarinKupcarpimi(liste);
        getMaxEleman(liste);
        tersSiralamBuyukElemanYarisiniAl(liste);
    }
/*
    t-> "Logic", (t,u)-> "logic"
    BU YAPİYA lAMBDA EXPESSİON" diyoruz

    2- Functional programing kapsaminda lambda expession kullanilabilir ama onerilmez bunu yerine
    "Method Refrence" tercih edilir.

    3- "Method Refrence" kullanimi "Class Name:: Method Name"
    Aynı zamanda kendi classlrinizi da kullanabilirsiniz.
    Ornegin; bir animal clasiniz var ve bu class "eat()" methoduna sahip ==> Animal :: eat"


 */

////1) Ardışık list elemanlarını aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional ve method reference)
 public static void    listElemanlariniYazdirFunctional(List<Integer>list){
     list.stream().forEach(Utils::ayniSatirdaBosluklaYazdir);


    }
////2)Ardışık çift list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
    public static void ciftelementleriYazdir(List<Integer>list){

     list.stream().filter(Utils::
             ciftElemaniSec).forEach(Utils::
             ayniSatirdaBosluklaYazdir);


        }
////3) Ardışık tek list elemanlarının karelerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)

public static void tekEleamlarinKareleriniYazdir(List<Integer>list){

     list.stream().filter(Utils::tekElemaniSec).
             map(Utils::karesiniAl).
             forEach(Utils::ayniSatirdaBosluklaYazdir);
}
////4) Ardışık tek list elemanlarının küplerini tekrarsız olarak aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.

    public  static void tekElemanlarinKupleriniTekrarsizYazdir(List<Integer>list){
     list.stream().distinct().filter(Utils::tekElemaniSec).map(Utils::küpleriniAl).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }

////5) Tekrarsız çift elemanların karelerinin toplamını hesaplayan bir method oluşturun.

    public  static void tekrarsizCiftElemanlarinKaresiToplami(List<Integer>list){

//1yol
  Integer toplam=   list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesiniAl).reduce(Math::addExact).get();
        System.out.println(toplam);
        //2.yol
        Integer toplam1=   list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesiniAl).reduce(0,Math::addExact);
        System.out.println(toplam1);
        //3.yol
        Integer toplam2=   list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesiniAl).reduce(0,Integer::sum);
        System.out.println(toplam2);
    }

////6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.

    public  static void tekrarsizCiftElemanlarinKupcarpimi(List<Integer>list){

   Integer carpim=  list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::küpleriniAl).reduce(1,Math::multiplyExact);

        System.out.println(carpim);

    }
////7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
    public static void getMaxEleman(List<Integer>list){
  Integer max=   list.stream().distinct().reduce(Math::max).get();
        System.out.println(max);

    }

////Ödev
//    //8)List elemanları arasından en küçük değeri bulan bir method oluşturun.(Method Reference)


///9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.

    public static void yedidenBuyukCiftMinimum(List<Integer>list){

   Integer minimum=  list.stream().distinct().filter(t->t>7).filter(Utils::ciftElemaniSec).reduce(Math::min).get();
        System.out.println("minimum = " + minimum);
    }
////10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.

    public static void tersSiralamBuyukElemanYarisiniAl(List<Integer>list){
    List<Double>sonuc= list.
            stream().//gerekli methodtlari kullanir
            distinct().//tekrarli olanlari almaz
            filter(t->t>5).//kosuşa gore siralar
            map(Utils::yarisiniAl).
            sorted(Comparator.//siralma
                    reverseOrder()).collect(Collectors.toList());//tekrar list yapti
        // ters siralma yapti
    System.out.println("sonuc = " + sonuc);
    }
}


