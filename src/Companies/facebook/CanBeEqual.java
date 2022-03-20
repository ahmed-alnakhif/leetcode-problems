package Companies.facebook;

import java.util.Arrays;

/**
 * You are given two integer arrays of equal length target and arr. In one step,
 * you can select any non-empty sub-array of arr and reverse it. You are allowed
 * to make any number of steps.
 * 
 * Return true if you can make arr equal to target or false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: target = [1,2,3,4], arr = [2,4,1,3]
 * Output: true
 */

public class CanBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length)
            return false;

        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CanBeEqual c = new CanBeEqual();
        System.out.println(c.canBeEqual(new int[] { 1, 2, 3, 4 }, new int[] { 2, 4, 1, 3 }));
    }
}
