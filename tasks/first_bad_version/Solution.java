package first_bad_version;


public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long x = 1;
        long y = n;
        while (y - x > 1) {
            int mid = (int)((x + y) / 2);
            if (isBadVersion(mid)) {
                y = mid;
            } else {
                x = mid;
            }
        }
        return isBadVersion((int)x) ? (int)x : (int)y;
    }


    public int firstBadVersion(int n, int badVersion) {
        this.badVersion = badVersion;
        int res =  firstBadVersion(n);
        System.out.println("n = " + n + ", badVersion = " + badVersion + ", res = " + res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(1, 1) == 1);
        System.out.println(new Solution().firstBadVersion(2, 1) == 1);
        System.out.println(new Solution().firstBadVersion(3, 2) == 2);
        System.out.println(new Solution().firstBadVersion(10, 5) == 5);
        System.out.println(new Solution().firstBadVersion(5, 4) == 4);
        System.out.println(new Solution().firstBadVersion(10, 7) == 7);
        System.out.println(new Solution().firstBadVersion(10000, 312) == 312);
        System.out.println(new Solution().firstBadVersion(2126753390, 1702766719) == 1702766719);
    }
}