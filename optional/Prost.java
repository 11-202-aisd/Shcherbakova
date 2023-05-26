package optional;

import java.util.Scanner;

public class Prost {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int j = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (!(one(arr[i]))) {
                if (delit(arr[i])) {
                    j++;
                    if (j == k) {
                        System.out.println(arr[i]);
                        break;
                    }
                }
            }
        }
    }

    public static boolean delit(int arr) {
        int kor = (int) Math.sqrt(arr);
        for (int j = 0; j < kor + 1; j++) {
            if (arr % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean one(int arr) {
        if (arr == 1) {
            return true;
        }
        return false;
    }
}