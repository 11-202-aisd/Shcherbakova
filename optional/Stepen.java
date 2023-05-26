package optional;

import java.util.Scanner;

public class Stepen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

    }

    public int rec(int x, int n){
        if(n == 0){
            return 1;
        }
        if ((n > 1) && (n % 2 == 0)){
            int rr = rec(x, n / 2);
            return rr * rr;
        }
        else{
            int r = rec(x, n/2);
            return r * r * x;
        }
    }

}
