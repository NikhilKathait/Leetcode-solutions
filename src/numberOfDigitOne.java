public class numberOfDigitOne {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;

        long p = 1;     // current digit position: 1, 10, 100...
        long count = 0;

        while (p <= n) {
            long left = n / (p*10);
            long digit = (n/p) % 10;
            long right = n%p;

            if (digit == 0) {
                count += left * p;
            } else if (digit == 1) {
                count += left * p + (right + 1);
            } else {    // digit > 1
                count += (left + 1) * p;
            }

            p *= 10;
        }

        return (int) count;
    }
}
