class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // find the max candy in origin candies
        int max = 0;
        for (int candy : candies) {
            if (max < candy) {
                max = candy;
            }
        }
        
        // loop in candies 
        List<Boolean> results = new ArrayList();
        for (int candy : candies) {
            results.add(candy + extraCandies >= max);
        }
        return results;
        // plus extraCandies with i value > max -> mark as true

        // solution above is much more clear

        // candies arrays
        // loop from 0 ~ candies.len - 1
        // check if i + extraCandies is the greatest number of candies among candies
        // Boolean[] answers = new Boolean[candies.length];
        // for (int i = 0; i < candies.length; i++) {
        //     if (checkBiggest(candies, candies[i] + extraCandies)) {
        //         answers[i] = true;
        //         continue;
        //     }
        //     answers[i] = false;
        // }
        // return Arrays.stream(answers).collect(Collectors.toUnmodifiableList());
    }

    // private boolean checkBiggest(int[] arr, int value) {
    //     int max = value;
    //     for (int i = 0; i < arr.length; i++) {
    //         if (max < arr[i]) {
    //             max = arr[i];
    //         }
    //     }
    //     return value == max;
    // }
}