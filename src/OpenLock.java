import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> set  = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for (String s : deadends) {
            set.add(s);
        }

        int step = 0;
        Queue<String> q = new LinkedList<>();

        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int size = q.size();

            while (size -- > 0) {
                String cur = q.poll();
                if (set.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                for (int i = 0; i < 4; i ++) {
                    String next1 = new StringBuilder(cur.substring(0,i)).append(cur.charAt(i) == '0' ? '9' : (char) (cur.charAt(i) - 1)).append(cur.substring(i + 1, 4)).toString();
                    String next2 = new StringBuilder(cur.substring(0,i)).append(cur.charAt(i) == '9' ? '0' : (char) (cur.charAt(i) + 1)).append(cur.substring(i + 1, 4)).toString();
                    if (!visited.contains(next1) && !set.contains(next1)) {
                        q.offer(next1);
                        visited.add(next1);
                    }
                    if (!visited.contains(next2) && !set.contains(next2)) {
                        q.offer(next2);
                        visited.add(next2);
                    }
                }

            }
            step++;

        }
        return -1;
    }
}
