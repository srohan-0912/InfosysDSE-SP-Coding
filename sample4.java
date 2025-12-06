import java.util.HashMap;

public class sample4 {
    static int maxLength(int[] arr){
     int preSum = 0;                // Running prefix sum
        int maxLen = 0;                // Maximum length found
        HashMap<Integer, Integer> map = new HashMap<>(); // Store (prefixSum → firstIndex)

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            if (preSum == 0) {
                // Subarray from start (0) to current index has sum 0
                maxLen = i + 1;
            }

            if (map.containsKey(preSum)) {
                // Subarray between previous index + 1 and current index has sum 0
                maxLen = Math.max(maxLen, i - map.get(preSum));
            } else {
                // Store first occurrence of this prefix sum
                map.put(preSum, i);
            }
        }

        return maxLen;
   
    }
    // Example usage
    public static void main(String[] args) {
        int[] arr = {-42, 12, 20, 15, 31, -4, 0, 15};
        System.out.println("Length of largest subarray with sum 0: " + maxLength(arr)); // Output: 1
    } 
}

