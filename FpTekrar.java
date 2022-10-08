package lambda_functional_programming;

import java.util.ArrayList;
import java.util.List;

public class FpTekrar {
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

    }
///1) Ardışık list elemanlarını aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional ve method reference)
public static void    listElemanlariniYazdirFunctional(List<Integer>list){
        list.stream().forEach(Utils::ayniSatirdaBosluklaYazdir);

}
///2)Ardışık çift list elementlerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)
public static void ciftelementleriYazdir(List<Integer>list){
        list.stream().filter(Utils::ciftElemaniSec).forEach(Utils::ayniSatirdaBosluklaYazdir);

    }

///3) Ardışık tek list elemanlarının karelerini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)

    public static void tekEleamlarinKareleriniYazdir(List<Integer>list){
        list.stream().filter(Utils::tekElemaniSec).map(Utils::karesiniAl).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
////4) Ardışık tek list elemanlarının küplerini tekrarsız olarak aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.

    public  static void tekElemanlarinKupleriniTekrarsizYazdir(List<Integer>list){
        list.stream().filter(Utils::tekElemaniSec).map(Utils::küpleriniAl).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
////2)Kurs adlarından en az birinin verilen kelimeyi içerip içermediğini kontrol etmek için bir method oluşturun
public static boolean  kursAdlarindabiriniİceriyorMU(List<Courses>list,String kelime){

        return list.stream().anyMatch(t->t.getCourseName().contains(kelime));
}

}

