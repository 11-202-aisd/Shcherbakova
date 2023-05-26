package optional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Glub {
    public static int [] array = new int [0];

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scInt = new Scanner(System.in);
        int [] arr = new int [scInt.nextInt()] ;
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        int v1, v2;
        Scanner scFile = new Scanner(new File("C:/Users/Huawei/Desktop/newDoc.txt"));
        while(scFile.hasNext()){
            v1 = scFile.nextInt();
            v2 = scFile.nextInt();
            while(arr[v2] != v2){
                v2 = arr[v2];
            }
            arr[v1] = v2;
        }
        array = arr;
        System.out.println(toString(array));
    }

    public static String toString(int [] array) {
       String rez = new String("");
       for(int i = 0; i < array.length; i ++){
           rez +=  String.valueOf(array[i]);
       }
       return rez;
    }
}
