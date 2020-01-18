import java.util.Arrays;

public class NonParallelSieveTaskExecutor {
    public static void main(String[] args) {

        /*
        Init: 147483647
        Init * 10: 1474836470
        Init * 30: 4424509410L
       */
        final long primeArraySize = 147483647;

        long largestPrime = 1;
        boolean[] thePrimes;
        // Make segments equal parts at least smaller than Integer.MAX_VALUE-5
        int segmentSize = (int) (primeArraySize%(Integer.MAX_VALUE-5));

        long sTime = System.nanoTime();
        // Split up primeArraySize into segments if it's too big >2billion
        for (long i = 0; i < (primeArraySize/segmentSize); i++) {
            // Overwrite segment to save memory all we needed was the largest prime in the segment.
            thePrimes = new boolean[segmentSize];
            // Let us know which segment is being tested
            System.out.printf("Starting [%d, %d]\n", i*segmentSize, i*segmentSize+segmentSize);

            // Fill the segment array with true
            Arrays.fill(thePrimes, true);

            // Do the sieve
            for (long j = ((i == 0)? 2:(segmentSize*i)); j < Math.sqrt(segmentSize); j++) {
                if (thePrimes[(int) (j - segmentSize*i)]) {
                    for(long k = j*j; k < segmentSize; k+=j) {
                        thePrimes[(int) (k - segmentSize*i)] = false;
                    }
                }
            }

            // Find the highest prime in the segment
            for (int j = segmentSize-1; j >= 0; j--) {
                if(thePrimes[j]) {
                    largestPrime = j + (segmentSize * i);
                    break;
                }
            }
        }
        long eTime = System.nanoTime();

        // RESULTS!
        System.out.println("Largest Prime: " + largestPrime + " Time elapsed: " + (eTime-sTime));
     }
}
