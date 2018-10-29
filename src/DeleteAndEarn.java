public class DeleteAndEarn {
    public int solution(int[] nums) {
        int[] buckets = new int[10001];

        for (int num : nums) {
            buckets[num] += num;
        }

        int skip = 0;
        int keep = 0;

        for (int i = 0; i < 10001; i ++) {
            int skipCur = Math.max(skip, keep);
            int keepCur = skip + buckets[i];

            skip = skipCur;
            keep = keepCur;

        }

        return Math.max(skip, keep);
    }
}
