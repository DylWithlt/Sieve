// PrintTask class sleeps for a random time from 0 to 5 seconds

public class SieveTask implements Runnable {

   private final boolean[] primesBoolean; // random sleep time for thread
   private final int startIndex; 
    
   // constructor
   public SieveTask(boolean[] thePrimes, int theIndex) {
      primesBoolean = thePrimes;
      startIndex = theIndex;
        
      // pick random sleep time between 0 and 5 seconds
      //sleepTime = generator.nextInt(5000); // milliseconds
   } 

   // method run contains the code that a thread will execute
   @Override
   public void run() {
      //try { // put thread to sleep for sleepTime amount of time 
         setNonPrimesFalse(); // put thread to sleep
      //}       
      //catch (Exception exception) {
      //   exception.printStackTrace();
      //   Thread.currentThread().interrupt(); // re-interrupt the thread
      //} 
        
      // print task name
      //System.out.printf("%s done sleeping%n", taskName); 
   } 
   
   public void setNonPrimesFalse() {
       int arrLength = primesBoolean.length;
       
       int k = startIndex+startIndex;
       if (k > arrLength) return;
       
       for (k = startIndex+startIndex; k < arrLength; k += startIndex)
        primesBoolean[k] = false;
   
   
    }
} 



/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/