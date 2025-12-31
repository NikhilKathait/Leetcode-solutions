public class reverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0 ; i<32; i++) {
            // Left shift the result to make space for the next bit
            result <<= 1;

            // Check if the lowest bit of n is 1
            if ((n & 1) == 1) {

                // Set the corresponding bit in result
                result |= 1;
            }
            n >>= 1;    // Right shift n to process the next bit
        }

        return result;  // Return the reversed bits
    }
}
