class Solution {
    public static int maxArea(int[] height) {
        // 더 낮은 길이의 막대를 스킵해야 한다. 더 높은 막대는 maxArea의 가능성이 있기 때문에

        int i = 0;
        int j = height.length - 1;
        int max = 0;

        while (i < j) {
            int iHeight = height[i];
            int jHeight = height[j];

            int w = j - i;

            int h = Math.min(iHeight, jHeight);

            max = Math.max(max, h * w);

            if (iHeight <= jHeight) {
                i++;
            } else {
                j--;
            }
        }
        return max;

        // O(n^2)
        // int len = height.length;
        // int result[] = new int[len];
        // int max = 0;

        // for (int i = 0; i < len; i++) {
        //     // 기준
        //     int h = height[i];
        //     for (int j = i + 1; j < len; j ++) {
        //         // 최소 높이 * 해당 길이 
        //         int compareHeight = Math.min(h, height[j]);
        //         int compareWidth = j - i;
                
        //         if (max < compareHeight * compareWidth) {
        //             max = compareHeight * compareWidth;
        //         }
        //     }

        // }
        // return max;
    }
}



