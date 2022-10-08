package lambda_functional_programming;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Fp4 {
    public static void main(String[] args) {
        System.out.println(get7den100eToplam());
        System.out.println("2.yol " +get7den100eToplam2());
        System.out.println("2den 11 e carpim" +get2den11eToplam2());
        System.out.println(sayininFaktoriyeliniAl(5));
        System.out.println(verilenikisayiarasindakiciftsayilarToplami(11,5));
        System.out.println(ikisayiarasindakiTumsayilarirakamlartoplami(23,32));

    }
///1) 7'den 100'e kadar integer değerlerinin toplamını bulan bir method oluşturun.
            public static int get7den100eToplam(){
//1.yoll
              return   IntStream.range(7,101).reduce(Math::addExact).getAsInt();
                     //sayilari sirayla alir
            }
    public static int get7den100eToplam2(){
//2.yoll
        return   IntStream.rangeClosed(7,100).reduce(Math::addExact).getAsInt();
    }
////2) 2'den 11'e kadar integer değerlerinin çarpımını bulan bir method oluşturun.
public static int get2den11eToplam2(){

        return IntStream.rangeClosed(2,11).reduce(Math::multiplyExact).getAsInt();
                                                    //carpiyor
}
////3) Verilen bir sayının faktoriyelini hesaplayan bir method oluşturun. (5 factorial = 1*2*3*4*5  ==> 5! = 1*2*3*4*5)

public static int sayininFaktoriyeliniAl(int x){
    if (x == 0) {
        return 1;

}
    return IntStream.rangeClosed(1,x).reduce(Math::multiplyExact).getAsInt();
}
////4) Verilen iki sayı arasındaki çift sayıların toplamını bulan bir method oluşturun.

    public static int verilenikisayiarasindakiciftsayilarToplami(int x,int y){



            return IntStream.rangeClosed(y,x).filter(Utils::ciftElemaniSec).sum();

}
////5) Verilen iki sayı arasındaki tüm sayıların rakamlarının toplamını hesaplayan bir method oluşturun.
//    //  23 and 32 ==> 2+3  +  2+4  +  2+5  +  2+6  +  2+7  +   2+8  +   2+9  +   3+0  +   3+1  +   3+2 ==> 68
    public static int ikisayiarasindakiTumsayilarirakamlartoplami(int x,int y){
        int z = 0;
        if (x>y){
            z = x;
            x = y;
            y = z;
        }

        return IntStream.rangeClosed(x,y).map(Utils::rakamlarToplami).sum();
    }
}
