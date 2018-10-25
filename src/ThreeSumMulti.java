import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumMulti {
    final static int MOD = 1000000007;
    public int threeSumMulti(int[] A, int target) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i ++) {
            int curTar = target - A[i];
            int j = i + map.get(A[i]);
            int k = A.length - 1;

            while (j < k) {
                if (A[j] + A[k] == curTar) {
                    res = (res + (((map.get(A[i]) * map.get(A[j])) % MOD) * map.get(A[k])) % MOD) % MOD;
                    j += map.get(A[j]);
                    k -= map.get(A[k]);
                } else if (A[j] + A[k] > curTar) {
                    k -= map.get(A[k]);
                } else {
                    j += map.get(A[j]);
                }
            }

            i += map.get(A[i]);
        }

        return res;
    }
}
