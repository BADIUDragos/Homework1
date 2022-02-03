package interview.questions.question1;

import java.util.ArrayList;
import java.util.List;

public class Question1 {

   public static void main(String[] args)
   {

      List<Transaction> transactions = new ArrayList<>();

      transactions.add(new Transaction.TransactionBuilder().setTicker("a").setQuantity(-10).setPrice(2.0).build());
      transactions.add(new Transaction.TransactionBuilder().setTicker("a").setQuantity(20).setPrice(1.0).build());
      transactions.add(new Transaction.TransactionBuilder().setTicker("b").setQuantity(5).setPrice(1.0).build());
      transactions.add(new Transaction.TransactionBuilder().setTicker("b").setQuantity(10).setPrice(1.0).build());
      transactions.add(new Transaction.TransactionBuilder().setTicker("b").setQuantity(10).setPrice(1.0).build());

      String mostPopularTicker = TransactionStatistics.mostPopularTicker(transactions);
      System.out.println(mostPopularTicker);

   }
}
