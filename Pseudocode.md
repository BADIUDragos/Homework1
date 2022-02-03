## Question 1

### Input:

List of transactions

Idea is to store into hash table, but we have 3 indexes

Problem: 
    We need to do the calculation of the value before we insert into hash table.

Solution:
    Implement function in Transaction calculating the absolute value for the transaction.

Use the input list to populate absValueTransactions array (mostPupularTicker function)
    - Declare the hashtable. string, double
    - Create function in TransactionStatistics, taking the input list, inserting into hashtable ticker = string, abs value calculation into double.

From there make function parsing Hashtable and returning the most popular ticker.

