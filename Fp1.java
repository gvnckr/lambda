package lambda_functional_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp1 {
    public static void main(String[] args) {
/*
1- Lambda (function programing) java 8 le kullanilmaya baslamistir

2-(function programing) de  ne yapilacak (what to do) ne yapilacak uzerine yogunlasilir.structured programing nasil yapilacak
uzerine yogunlasir.(How to do)

3-function programing arreys ve collection ile kullanilir

4- entryset () methodu ile map sete donusturulerek function programing de kullanilir

 */
        ////1) Ardışık liste elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Structured)

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

            listElemanlariniYazdirStructured(liste);
            System.out.println();
            istElemanlariniYazdirFunctional(liste);
            System.out.println();
            ciftElemanlariYazdirStructured(liste);

           System.out.print("\nfunctional :");
           ciftElemanlariYazdirFunctional(liste);
           System.out.println();
           tekElemanlarinKareleriniYazdir(liste);
        System.out.println();
        tekElemanlarinKupleriniTekrarsizYazdir(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami(liste);
        tekrasizCiftElemanlarinKupCarpimi(liste);
        enbuyukDegeriBul1(liste);
        enbuyukDegeriBul2(liste);
        getyedidenBuyukMin(liste);
        getyedidenBuyukMu(liste);
        getyedidenBuyukMi3(liste);
        gettersSiralamaTekrarsizElemanlarinYarisi(liste);
        System.out.println("odev sonuc ");
        enkucukDegeriBul1(liste);

    }
    public  static void listElemanlariniYazdirStructured(List<Integer>list){

        for (Integer w:list){

            System.out.print(w +" ");
    }

    }

////1)Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
public static void istElemanlariniYazdirFunctional(List<Integer>list){

list.stream().forEach(t-> System.out.print(t +" ")); //t variable
//stream methodu collectiondan elementleri akisa dahil etmek icin ve methotlara ulasmak icin kullanilir
    }

    ////2) çift sayi olan  list elemanlarini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Structured)
public static void ciftElemanlariYazdirStructured(List<Integer>list){

        for (Integer w:list){
            if(w%2==0){
                System.out.print(w +" ");
            }
        }

}
//çift sayi olan  list elemanlarini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.
  public static void   ciftElemanlariYazdirFunctional(List<Integer>list){
        list.stream().filter(t->t%2==0).forEach(t-> System.out.print(t +" "));
 list.stream().filter(t->t%2==0).forEach(t-> System.out.println(t +" "));

  }
////3) Ardışık tek list elemanlarinin  karelerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
 public static void tekElemanlarinKareleriniYazdir(List<Integer>list){

        list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t +" "));
                //elemanlarin degerini degistirmek icin map kullanildi
        list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.println(t +" "));
    }
////4) Ardışık tek list elementlerinin küplerini tekrarsız olarak aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.

public static void tekElemanlarinKupleriniTekrarsizYazdir(List<Integer>list){

        list.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.println(t +" "));
        list.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.println(t +" "));
                //distinc tekrarsiz alir
}

//  ///5) Tekrarsız çift elementlerin karelerinin toplamını hesaplayan bir method oluşturun.

    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer>list){

       int toplam= list.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);
        System.out.println(toplam );                                   //azaltma    //baslagıc noktasi

    }

//6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.

    public static void  tekrasizCiftElemanlarinKupCarpimi(List<Integer>list){

      Integer carpim=  list.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(t,u)->t*u);
        System.out.println(carpim);
    }

//7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
    public static void enbuyukDegeriBul1(List<Integer>list){

//1.yoll
        Integer max=list.stream().distinct().reduce(Integer.MIN_VALUE,(t,u)->t>u ?t:u);
        System.out.println(max);
    }
 //2.yol
 public static void enbuyukDegeriBul2(List<Integer>list){
 Integer max=  list.stream().distinct().sorted().reduce(Integer.MIN_VALUE,(t,u)->u);
                                   //kucukten baslar


     System.out.println("max = " + max);

 }
//Ödev
    //8)List elemanları arasından en küçük değeri bulan bir method oluşturun.(2 Yol ile)
    public static void enkucukDegeriBul1(List<Integer>list){
 Integer min=   list.stream().distinct().reduce(Integer.MAX_VALUE,(t,u)->u);
        System.out.println(min);
    }

//9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.


    public static void getyedidenBuyukMin(List<Integer>list){
 //1.yoll
     Integer min=   list.stream().distinct().filter(t->t%2==0).filter(t->t>7).reduce(Integer.MAX_VALUE,(t,u)->t<u ? t:u);
        System.out.println("min = " + min);
    }

    //2.yol:
    public static void getyedidenBuyukMu(List<Integer>list){
        Integer min= list.stream().
                distinct().
                filter(t->t%2==0).
                filter(t->t>7).
                sorted(Comparator.reverseOrder()).
                reduce(Integer.MAX_VALUE,(t,u)->u);
        System.out.println("min = " + min);                                           //tersten
    }

  //3.yol
  public static void getyedidenBuyukMi3(List<Integer>list){
      Integer min=  list.stream().
              filter(t->t%2==0).
              filter(t->t>7).
              sorted().
              findFirst().get();
      System.out.println("min = " + min);
  }
////10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.
    public static void gettersSiralamaTekrarsizElemanlarinYarisi(List<Integer>list){

    List<Double>sonuc =    list.stream().
            distinct().
            filter(t->t>5).
            map(t->t/2.0).sorted(Comparator.
                    reverseOrder()).collect(Collectors.toList()); //topla listin icine koy
        System.out.println("sonuc = " + sonuc);
    }
}

