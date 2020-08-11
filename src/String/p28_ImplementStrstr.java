package String;

public class p28_ImplementStrstr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int res = strStr(haystack, needle);
        System.out.println("res = " + res);
    }

    public static int strStr(String haystack, String needle) {
        // 边界条件
        if (haystack != null && haystack.equals(needle)) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        // 获取字符串长度
        int H = haystack.length();
        int N = needle.length();
        // 遍历到H-N即可，后面超过长度没必要比较，减少比较次数
        for (int i = 0; i <= H - N; i++) {
            // 这里首先暴力匹配一下
            int j = 0;
            while (j < N && needle.charAt(j) == haystack.charAt(i + j)) {
                j++;
            }
            // 如果暴力匹配到，返回位置即可
            if (j == N) {
                return i;
            }
            // 如果暴力匹配失败，使用Sunday算法匹配
            else {
                // 获取needle的索引长度
                int k = N - 1;
                // 从后向前找，目的是增加移动步数，减少移动次数
                while (k >= 0 && i + N < H && needle.charAt(k) != haystack.charAt(i + N)) {
                    k--;
                }
                // 如果k<0说明当前这个元素未出现在待匹配字符串中，跳过即可之前的元素+这个不匹配的元素
                if (k < 0) {
                    i = i + N + 1;
                }
                // 如果k>0说明当前这个元素出现在待匹配字符串中，k就是当前这个元素在待匹配字符第一次出现的索引，直接对齐即可
                else {
                    i = i + N - 1 - k;
                }
            }
        }
        // 未匹配到，返回-1
        return -1;
    }

}
