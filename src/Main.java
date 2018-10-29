import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
//        AtMostNGivenDigitSet c = new AtMostNGivenDigitSet();
//        String{} D = {"1", "4", "9"};
//        int N = 10000;
//        System.out.println(c.solution(D, N));

//        SnakesAndLadders s = new SnakesAndLadders();
//        int[][] board = {{-1,-1},{-1, 3}};
//        s.snakesAndLadders(board);
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.offer(1);
//        pq.remove(0);

//        int[] couples = {3,1,4,2,7,5,6,0};
//        MinSwapCouples m = new MinSwapCouples();
//        System.out.println(m.minSwapsCouples(couples));

//        String str = "ababcbacadefegdehijhklij";
//        PartitionLabels p = new PartitionLabels();
//        p.partitionLabels(str);

//        String[] deadLock = {"0201","0101","0102","1212","2002"};
//        String target = "0202";
//
//        OpenLock openLock = new OpenLock();
//        System.out.println(openLock.openLock(deadLock, target));
//        int[] arr = {0,1,1,0};
//        MinCostStair m = new MinCostStair();
//        System.out.println(m.minCostClimbingStairs(arr));

//        String s = "abc";
//        String b = new StringBuilder(s).reverse().toString();
        int[][] times = {{2,1,1}, {2,3,1},{3,4,1}};
        int N = 4;
        int K = 2;

        NetworkDelayTime m = new NetworkDelayTime();
        m.networkDelayTime(times, N, K);
    }
}
