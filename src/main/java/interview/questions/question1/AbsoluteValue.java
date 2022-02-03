package interview.questions.question1;

import java.util.List;

public class AbsoluteValue implements Runnable{

   public (List<Transaction> t, String ticker){

      for (int i = 0; i < t.size(); i++){
         if(t.get(i).getTicker() == ticker){
            t.get(i).getAbsoluteValue()
         }
      }

   }

   @Override
   public void run() {

   }
}
