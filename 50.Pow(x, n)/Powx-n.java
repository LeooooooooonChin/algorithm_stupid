// 解法一 暴力法 超时
public double myPow1(double x, int n) {
    if (n == 0) {
        return 1;
    }
    if (n == 1) {
        return x;
    }
    if (n < 0) {
        if (n == Integer.MIN_VALUE) {
            n = Integer.MAX_VALUE - 1;
        }
        n = -n;
        x = 1 / x;
    }
    double res = 1;
    while (n != 0) {
        res *= x;
        n -= 1;
    }
    return res;
}

// 解法二 分治法 21 ms
public static double myPow2(double x, int n) {
    if (n == 0) {
        return 1;
    }
    if (n == 1) {
        return x;
    }
    // n为负数
    if (n < 0) {
        if (n == Integer.MIN_VALUE) {
            n = Integer.MAX_VALUE - 1;
        }
        return 1 / myPow2(x, Math.abs(n));
    }
    // 偶数情况
    if (n % 2 == 0) {
        return myPow2(x * x, n / 2);
    }
    // 奇数情况 先计算myPow2，最后返回的时候多一个X就是奇数
    return x * myPow2(x * x, n / 2);
}