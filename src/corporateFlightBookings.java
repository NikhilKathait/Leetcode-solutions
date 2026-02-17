public class corporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        int m = bookings.length;

        for (int i = 0; i < m; i++) {
            int si = bookings[i][0] - 1;
            int ei = bookings[i][1] - 1;
            int vi = bookings[i][2];

            answer[si] += vi;

            if (ei < n - 1) {
                answer[ei + 1] -= vi;
            }
        }

        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }

        return answer;
    }
}
