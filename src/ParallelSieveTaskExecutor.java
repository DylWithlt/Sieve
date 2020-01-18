import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelSieveTaskExecutor {
    public static void main(String[] args) {

        /*
        Init: 147483647
        Init * 10: 1474836470
        Init * 30: 4424509410L
       */
        final long primeArraySize = 1474836470;

        long largestPrime = 1;
        boolean[] thePrimes;
        int segmentSize = (int) (primeArraySize%(Integer.MAX_VALUE-5));

        ExecutorService executorService = Executors.newCachedThreadPool();

        long sTime = System.nanoTime();
        for (long i = 0; i < (primeArraySize/segmentSize); i++) {
            thePrimes = new boolean[segmentSize];
            System.out.printf("Starting [%d, %d]\n", i*segmentSize, i*segmentSize+segmentSize);

            Arrays.fill(thePrimes, true);

            for (long j = ((i == 0)? 2:(segmentSize*i)); j < Math.sqrt(segmentSize); j++) {
                if (thePrimes[(int) (j - segmentSize*i)]) {
                    SieveTask s1 = new SieveTask(thePrimes, (int) (j-segmentSize*i));
                    executorService.execute(s1);
                }
            }

            for (int j = segmentSize-1; j >= 0; j--) {
                if(thePrimes[j]) {
                    largestPrime = j + (segmentSize * i);
                    break;
                }
            }
        }
        executorService.shutdown();

        long eTime = System.nanoTime();

        System.out.println("Largest Prime: " + largestPrime + " Time elapsed: " + (eTime-sTime));
    }
}
