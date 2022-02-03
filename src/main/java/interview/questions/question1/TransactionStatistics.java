/*
 * Copyright (c) 2006-2019 Henri Tremblay.
 */
package interview.questions.question1;

import java.util.*;

/**
 * Please implement the {@link #mostPopularTicker(List)} method. With a sequential and a parallel algorithm.
 * DO NOT modify the existing code.
 */
public final class TransactionStatistics {

   /**
    * Return the most popular ticker in terms of transaction total absolute value (i.e. abs(price * quantity)). For example,
    * let's say we have these transactions:
    * <ul>
    *     <li>transaction("a", -10, 2.0)</li>
    *     <li>transaction("a", 20, 1.0)</li>
    *     <li>transaction("b", 5, 1.0)</li>
    *     <li>transaction("b", 10, 1.0)</li>
    *     <li>transaction("b", 10, 1.0)</li>
    * </ul>
    * The most popular one ticker is "a" with a traded value of 40 compared to b that only has 25.
    *
    * @param list List containing all transactions we want to look at
    * @return the most popular ticker
    */

   /** Absolute value transactions Hashtable */
   public static Hashtable<String, Double> absValueTransactions = new Hashtable<>();

   /** Single threaded */
   public static String mostPopularTicker(List<Transaction> transactions) {

      /** Using HashTable with key = ticker and value = total absolute value. */
      for (int i = 0; i < transactions.size(); i++){

         /** Just so we can read easily */
         String localTicker = transactions.get(i).getTicker();
         Double localAbsValue = transactions.get(i).getAbsoluteValue();

         /** If key already in, add value to current value, else put key with new value */
         if (absValueTransactions.containsKey(localTicker)){
            absValueTransactions.replace(localTicker, absValueTransactions.get(localTicker) + localAbsValue);
         }
         else absValueTransactions.put(localTicker, localAbsValue);
      }

      String maxValueKey = "";
      double maxValueInTable = (Collections.max(absValueTransactions.values()));

      /** Checking which ticker has the biggest value, this does not support multiple tickers with same value since question doesn't ask for it */
      Enumeration<String> tickers = absValueTransactions.keys();
      while(tickers.hasMoreElements()){
         String ticker = tickers.nextElement();
         if((absValueTransactions.get(ticker)).equals(maxValueInTable))
            maxValueKey = ticker;
      }

      return maxValueKey;
   }

   public static Hashtable<String, Double> absValueTransactionsMulti = new Hashtable<>();

   /** Multi-threaded */
   public static String mostPopularTickerThreaded(List<Transaction> transactions){

      /** Get all the tickers in a list in order to create a thread managing each ticker's calculation */
      List<String> tickers = new ArrayList<>();
      for (int i = 0; i < transactions.size(); i++){
         if (!tickers.contains(transactions.get(i).getTicker())){
            tickers.add(transactions.get(i).getTicker());
         }
      }

      /** Now that we know all the tickers we know how many threads we are going to need */




      /** Using HashTable with key = ticker and value = total absolute value. */
      for (int i = 0; i < transactions.size(); i++){

         /** Just so we can read easily */
         String localTicker = transactions.get(i).getTicker();
         Double localAbsValue = transactions.get(i).getAbsoluteValue();  /** Move this calculation inside this function* most probably inside the thread/

         /** Do something like this but with one thread per ticker, i.e. 1 thread for ticker a, one for b etc... */
         if (absValueTransactionsMulti.containsKey(localTicker)){
            absValueTransactionsMulti.replace(localTicker, absValueTransactionsMulti.get(localTicker) + localAbsValue);
         }
         else absValueTransactionsMulti.put(localTicker, localAbsValue);
      }

      String maxValueKey = "";
      double maxValueInTable = (Collections.max(absValueTransactionsMulti.values()));

      /** Checking which ticker has the biggest value, this does not support multiple tickers with same value since question doesn't ask for it */
      Enumeration<String> tickers = absValueTransactionsMulti.keys();
      while(tickers.hasMoreElements()){
         String ticker = tickers.nextElement();
         if((absValueTransactionsMulti.get(ticker)).equals(maxValueInTable))
            maxValueKey = ticker;
      }

      return maxValueKey;
   }

   private TransactionStatistics()  {}
}
