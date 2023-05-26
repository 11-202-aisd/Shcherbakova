package optional;

import java.util.Scanner;

import static java.lang.Math.max;

public class Rykzak {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int summ = sc.nextInt();
        int t_sum = 0;
        Tree myTree = new Tree();
        for(int i = 0; i < n; i++){
            myTree.add(sc.nextInt());
        }
        int rez = recurs(myTree.root,summ, t_sum, 0 );
    }
    public static int  recurs(Node node, int sum, int t_sum, int maxsum){
        if(t_sum + node.value < sum){
            return recurs(node.rightChild, sum,t_sum+ node.value, max(maxsum,t_sum + node.value ));
        } else if (t_sum + node.value == sum){
            return t_sum + node.value;
        } else {
            return recurs(node.leftChild, sum, node.value, maxsum);
        }
    }
}
