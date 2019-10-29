package com.example.leetcodetest;

import java.util.Arrays;

/**
 * User : Blues
 * Date : 2019/9/4
 * Time : 09:45
 */

public class Solution {

    public static void main(String[] args) {

    }

    //
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    System.out.print("i: " + i + " j: " + j);
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 如果 haystack 中包含 needle字符串，则计算出haystack中出现的needle第一个的位置
     *
     * @param haystack
     * @param needle
     */
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        } else {
            if (haystack.contains(needle)) {
                return haystack.indexOf(needle);
            } else {
                return -1;
            }
        }
    }

    //回文整数判断 比如说 121 true  111 true 100 false -100 false

    /**
     * 分析一下，首先呢，负数肯定为false，个位数肯定为true
     *
     * @param x
     * @return
     */
    private static boolean isPalindrome(int x) {
        System.out.println(String.valueOf(x));

        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else {
            String sb = new StringBuilder(String.valueOf(x)).reverse().toString();
            System.out.println("反转后的数：" + sb);
            return sb.equals(String.valueOf(x));
        }
    }

    /**
     * 给定整型数组，指定数字，假若数组中存在于指定数字相等的，移除掉相等的数组返回新的数组
     *
     * @param nums
     * @param val
     */
    private static int removeElement(int[] nums, int val) {
        int default_len = nums.length;
        int default_size = 0;
        for (int num : nums) {
            if (num == val) {
                default_size += 1;
            }
        }
        return default_len - default_size;
    }

    /**
     * 正数反转
     *
     * @param x
     */
    public static int reverse(int x) {
        if (x >= 0) {
            String sb = new StringBuilder(String.valueOf(x)).reverse().toString();
            if (Long.parseLong(sb) > Integer.MAX_VALUE) {
                return 0;
            } else {
                return Integer.parseInt(sb);
            }
        } else {
            String sb = new StringBuilder(String.valueOf(x).substring(1)).reverse().toString();
            if (Long.parseLong(sb) > Integer.MAX_VALUE) {
                return 0;
            } else {
                return -Integer.parseInt(sb);
            }
        }
    }


    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     *
     * @param nums
     */
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        int temp = 0;

        if (len == 0) {
            return 1;
        }

        if (len == 1) {
            if (nums[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                temp = i;
                break;
            }
        }

        if (nums[temp] == 1) {
            for (int i = temp; i < len; i++) {
                if (i + 1 < len) {
                    if (nums[i + 1] - nums[i] > 1) {
                        return nums[i] + 1;
                    }
                } else {
                    return nums[len - 1] + 1;
                }
            }
        } else {
            return 1;
        }
        return 1;
    }

//    public static int[] plusOne(int[] digits) {
//
//    }

    /**
     * 给定数组和目标数，找出索引，如果没有，则返回插入时对应的下标
     *
     * @param nums
     * @param target
     */
    public static int searchInsert(int[] nums, int target) {

        int len = nums.length;
        int start = 0;
        int end = nums.length - 1;

        if (len != 0) {
            while (start <= end) {

                int mid = (start + end) >>> 1;
                int midValue = nums[mid];

                if (midValue < target) {
                    start = mid + 1;
                } else if (midValue > target) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
        } else {
            return 0;
        }
        return start;
    }

    /**
     * 找出 最大能拼成 balloon的个数
     * 思路：字母个数
     *
     * @param text 指定的字符串
     */
    public static int maxNumberOfBalloons(String text) {

        int bNum = 0;
        int aNum = 0;
        int lNum = 0;
        int oNum = 0;
        int nNum = 0;

        char[] array = text.toCharArray();

        for (char c : array) {
            switch (String.valueOf(c)) {
                case "b":
                    bNum++;
                    break;
                case "a":
                    aNum++;
                    break;
                case "l":
                    lNum++;
                    break;
                case "o":
                    oNum++;
                    break;
                case "n":
                    nNum++;
                    break;
                default:
                    break;
            }
        }

        System.out.println("b: " + bNum + " a: " + aNum + " l: " + lNum + " o: " + oNum + " n: " + nNum);

        int single = Math.min(Math.min(bNum, aNum), nNum);
        int doub = Math.min(lNum, oNum);

        if (single < 1 || doub < 2) {
            return 0;
        }

        if (2 * single > doub) {
            return doub >>> 1;
        } else {
            return single;
        }
    }
}
