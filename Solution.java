class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            // If k == 0, replace all elements with 0
            return new int[n];
        }

        // Handle both positive and negative k
        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                // Sum the next k numbers
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n]; // Circular indexing for next k elements
                }
            } else {
                // Sum the previous |k| numbers
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n]; // Circular indexing for previous k elements
                }
            }
            result[i] = sum;
        }

        return result;
    }
    public static void main(String[] args) {
        // Input example
        int[] code = {2, 4, 9, 3};
        int k = -2;

        // Call the decrypt method and get the result
        Solution solution = new Solution();
        int[] decryptedCode = solution.decrypt(code, k);

        // Display the output
        System.out.print("Decrypted code: ");
        for (int num : decryptedCode) {
            System.out.print(num + " ");
        }
    }
}
