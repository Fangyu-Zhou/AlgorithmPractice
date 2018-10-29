import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
//        int[] cost = new int[N + 1];
//        Arrays.fill(cost, Integer.MAX_VALUE);
//        Queue<Integer> q = new LinkedList<>();
//        Set<Integer> arrivals = new HashSet<>();
//        q.offer(K);
//        arrivals.add(K);
//        cost[K] = 0;
//        int res = 0;
//
//        while (!q.isEmpty()) {
//            int cur = q.poll();
//
//            for (int[] pair: times) {
//                if (pair[0] == cur && cost[cur] + pair[2] < cost[pair[1]]) {
//                    arrivals.add(pair[1]);
//                    cost[pair[1]] = cost[cur] + pair[2];
//                    q.offer(pair[1]);
//                }
//            }
//        }
//
//        if (arrivals.size() < N) {
//            return -1;
//        }
//
//        for (int i = 1; i <= N; i ++) {
//            res += cost[i];
//        }
//        return res;
        int r = times.length, max = Integer.MAX_VALUE;

        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<r;i++){
            int[] nums = times[i];
            int u = nums[0];
            int v = nums[1];
            List<Integer> list = map.getOrDefault(u,new ArrayList<>());

            list.add(i);

            map.put(u,list);
        }
        if(map.get(K) == null){
            return -1;// no immediate neighbor of node K, so return -1
        }
        int[] dist = new int[N+1];//dist[i] is the time taken to reach node i from node k
        Arrays.fill(dist,max);

        dist[K] = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(K);

        while(!queue.isEmpty()){
            int u = queue.poll();
            int t = dist[u];
            List<Integer> list = map.get(u);// get the indices of all the neighbors of node u
            if(list == null)
                continue;

            for(int n:list){
                int v = times[n][1];
                int time = times[n][2];// time taken to reach from u to v
                if(dist[v] > t + time){// if time taken to reach v from k is greater than time taken to reach from k to u + time taken to reach from u to v, then update dist[v]
                    dist[v] = t + time;
                    queue.add(v);// as we have found shorter distance to node v, explore all neighbors of v
                }
            }
        }

        int res = -1;

        for(int i=1;i<=N;i++){
            int d = dist[i];
            if(d == max){// if d is max, it means node i can not be reached from K, so return -1
                return -1;
            }
            res = d > res ? d : res;
        }

        return res;

    }
}
