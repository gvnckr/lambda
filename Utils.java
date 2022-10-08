package lambda_functional_programming;

public class Utils {

public static void ayniSatirdaBosluklaYazdir(Object obj){
    System.out.print(obj+ " ");

}

public static boolean ciftElemaniSec(int x){

    return x%2==0;
}
public static boolean tekElemaniSec(int x){
    return x%2!=0;
}
    public static int karesiniAl(int x){
    return x*x;
    }
    public static int küpleriniAl(int x){
        return x*x*x;
    }
public static double yarisiniAl(int x ){


    return x/2.0;
}
public static char sonkarekteral(String str){
    return str.charAt(str.length()-1);
}
    public static char ilkkarekteral(String str){
    return str.charAt(0);
    }
public static int rakamlarToplami(int x){
   int toplam=0;
    while (x>0){
        toplam+=x%10;
        x=x/10;
    }
return toplam;
}

}
