import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
//        int[] start = new int[26];
//        Arrays.fill(start, S.length());

        int[] end = new int[26];
        List<Integer> res = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c ++) {
//            start[c - 'a'] = S.indexOf(c);
            end[c - 'a'] = S.lastIndexOf(c);
        }

//        Arrays.sort(start);
//        Arrays.sort(end);
        int last = 0;
        int start = 0;

        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, end[S.charAt(i) - 'a']);

            if (last == i) {
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        return res;
    }
}
