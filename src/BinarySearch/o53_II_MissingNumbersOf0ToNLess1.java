package BinarySearch;

public class o53_II_MissingNumbersOf0ToNLess1 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        int res = missingNumber(nums);
        System.out.println("res = " + res);
    }

    public static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            // 如果中间索引和中间值相等，说明nums[0,mid]是不缺少值的，因为数组有序，如果缺少值这个区间的索引就错位了，所以向右边查找
            if (nums[mid] == mid) {
                left = mid + 1;
            }
            // 如果中间索引和中间值不相等，说明nums[0,mid]是缺少值的，因为数组有序，如果缺少值这个区间的索引就错位了，所以向左边查找，并且说明当前位置有可能就是缺失值，同时作为while循环结束的终止条件
            else {
                right = mid - 1;
            }
        }
        // 因为最后right是错位的mid-1，说明right是缺失值之前的那一个元素，而left是没错位的mid+1，也就保证了left就是缺失值，返回即可
        return left;
    }

}
