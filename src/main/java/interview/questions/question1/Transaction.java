/*
 * Copyright (c) 2006-2019 Henri Tremblay.
 */
package interview.questions.question1;

import java.util.Objects;
import java.lang.Math;

/**
 * Class representing a really simplistic transaction. DO NOT modify the existing code. However, you can
 * add fields and methods as you feel it.
 */
public class Transaction {

   public static Transaction transaction(String ticker, int quantity, double price) {
      return new Transaction(ticker, quantity, price);
   }

   /** Symbol identifying the financial instrument */
   private final String ticker;

   /** Number of financial instruments exchanged by the transaction. A positive value is a buy, a negative value is a sale */
   private final int quantity;

   /** Price paid / sold per financial instrument. Always positive */
   private final double price;

   private Transaction(String ticker, int quantity, double price) {
      this.ticker = Objects.requireNonNull(ticker);
      this.quantity = quantity;
      this.price = price;
   }

   public String getTicker() {
      return ticker;
   }

   public int getQuantity() {
      return quantity;
   }

   public double getPrice() {
      return price;
   }

   public double getAbsoluteValue() { return Math.abs(quantity*price); }

   public static class TransactionBuilder {

      private String ticker;
      private int quantity;
      private Double price;

      public TransactionBuilder setTicker(String ticker){
         this.ticker = ticker;
         return this;
      }

      public TransactionBuilder setQuantity(int quantity){
         this.quantity = quantity;
         return this;
      }

      public TransactionBuilder setPrice(Double price){
         this.price = price;
         return this;
      }

      public Transaction build()
      {
         return new Transaction(ticker, quantity, price);
      }
   }
}
