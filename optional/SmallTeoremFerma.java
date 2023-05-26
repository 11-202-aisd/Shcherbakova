package optional;

import java.util.Scanner;

public class SmallTeoremFerma {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int maxg = sc.nextInt();
        int ming = sc.nextInt();
        int d = 15;
        for(int i = 0; i < d; i++){
            int ch = (int) Math.random() * (maxg - ming) + ming;
            int rez = (ch * ch) % maxg;
            for(int j = 0; j < maxg - 3; j++){
                rez *= ch;
                rez = rez % maxg;
            }
            System.out.println(ch);
            if(rez == 1){
                System.out.println("true");
            } else{
                System.out.println("false");
            }

        }
    }

}
