package optional;

import java.util.Scanner;

public class Evclid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        while((a != 0) && (b != 0)){
            if (a > b){
                a -= b;
            } else {
                b -= a;
            }
        }
        System.out.println(a + b);
    }
}
