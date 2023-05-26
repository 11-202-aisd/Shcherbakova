package optional;

import java.util.Scanner;

public class Eratosfen {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n - 1; i ++){
            arr[i] = i + 2;
        }
        for (int i = 0; i < n / 2; i++){
            if(arr[i] != -1){
                arr = arays(arr[i],n, arr );
            }
        }
        for( int i = 0; i < n - 1; i++){
            if(arr[i] != -1){
                System.out.print(arr[i] + " ");
            } else{
                System.out.print("x ");
            }
        }
    }
    public static int[] arays(int i, int n, int [] arr){
        for(int j = i - 2; j < n; j += i ){
            if (arr[j] != i){
                arr[j] = -1;
            }
        }
        return arr;
    }
}
