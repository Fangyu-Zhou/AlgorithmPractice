public class MinSwapCouples {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] pos = new int[n];
        int res = 0;

        for (int i = 0; i < n; i ++) {
            pos[row[i]] = i;
        }

        for (int i = 0; i < n; i +=2) {
            int pair = row[i] % 2 == 0 ? row[i] + 1: row[i] - 1;

            if (row[i + 1] != pair) {
                row[pos[pair]] = row[i + 1];
                pos[row[i + 1]] = pos[pair];
                res ++;
            }

        }

        return res;
    }
}
