class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 0) {
                boolean isLeftEmpty = (i == 0) || (flowerbed[i-1] == 0);
                boolean isRightEmpty = (i == flowerbed.length - 1) || (flowerbed[i+1] == 0);

                if (isLeftEmpty && isRightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}