public class MinCostStair {
    public int minCostClimbingStairs(int[] cost) {
        // cost[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i ++) {
            cost[i] = Math.min(cost[i - 2], cost[i - 1]) + cost[i];
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);

    }
}
