package gas_station;

class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int stationsNumber = gas.length;
        int sum = 0;
        for (int i = 0; i < stationsNumber; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            return -1;
        }
        int gasAmount = 0;
        int startStation = 0;
        for (int i = 0; i < stationsNumber; i++) {
            gasAmount += gas[i] - cost[i];
            if (gasAmount < 0) {
                gasAmount = 0;
                startStation = i + 1;
            }
        }
        return startStation;
    }

    private static void check(int[] gas, int[] cost, int expected) {
        int result = new Solution().canCompleteCircuit(gas, cost);
        System.out.println((result == expected) + " " + result);
    }

    public static void main(String[] args) {
        check(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3);
        check(new int[]{5, 8, 2, 8}, new int[]{6, 5, 6, 6}, 3);
    }
}


