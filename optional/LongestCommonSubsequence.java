public class LongestCommonSubsequence {
    public static int findLCS(int[] x, int[] y) {
        int m = x.length;
        int n = y.length;

        // Создаем таблицу для хранения результатов подзадач
        int[][] dp = new int[m + 1][n + 1];

        // Заполняем таблицу с помощью динамического программирования
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5};
        int[] y = {3, 4, 5, 6, 7};

        int lcsLength = findLCS(x, y);
        System.out.println("Max Length of Common Subsequence: " + lcsLength);
    }
}
