public class canSum {

    // Recursive version:
    public static boolean canSumRec(int value, int[] parts) {
        if (value == 0) {
            return true;
        } else if (value < 0) {
            return false;
        } else {
             for (int i = 0 ; i < parts.length ; i++) {
                 int remainder = value - parts[i];
                 if (canSumRec(remainder, parts)) {
                    return canSumRec(remainder, parts);
                 }
             }
             return false;
        }
    }

    public static boolean canSumMemod(int value, int[] parts, boolean[] memo) {

        if (memo[value]) {
            return memo[value];
        }

        if (value == 0) {
            return true;
        } else if (value < 0) {
            return false;
        } else {
             for (int i = 0 ; i < parts.length ; i++) {
                 int remainder = value - parts[i];
                 if (canSumMemod(remainder, parts, memo)) {
                    memo[value] = true;
                    return memo[value];
                 }
             }
             memo[value] = false;
            return memo[value];
        }
    }

    // Tests:
    public static void main(String[] args) {
        int[] t1 = {2, 3};
        System.out.println(canSumRec(7, t1));
        int[] t2 = {5, 3, 4, 7};
        System.out.println(canSumRec(7, t2));
        int[] t3 = {2, 4};
        System.out.println(canSumRec(7, t3));

       

    }
}
