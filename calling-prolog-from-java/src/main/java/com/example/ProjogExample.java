package com.example;

import java.io.File;

import org.projog.api.Projog;
import org.projog.api.QueryResult;
import org.projog.api.QueryStatement;
import org.projog.core.term.Atom;

public class ProjogExample {
   public static void main(String[] args) {
      // Create a new Projog instance
      // Using the empty constructor causes Projog to operate with the default configuration.
      // The default configuration is to operate in "compiled" mode which causes user-defined predicates to be compiled to Java at runtime.
      Projog p = new Projog();

      // Read Prolog facts and rules from a file to populate the "Projog" instance created in step 1.
      p.consultFile(new File("src/main/resources/test.pl"));

      // Create a query that will use the facts read in step 2.
      QueryStatement s1 = p.query("test(X,Y).");

      // Execute the query created in step 3.
      QueryResult r1 = s1.getResult();
      while (r1.next()) {
         System.out.println("X = " + r1.getTerm("X") + " Y = " + r1.getTerm("Y"));
      }

      // Execute the query created in step 3, after specifying a term for one of the variables contained in the query.
      QueryResult r2 = s1.getResult();
      r2.setTerm("X", new Atom("d"));
      while (r2.next()) {
         System.out.println("Y = " + r2.getTerm("Y"));
      }

      // Create and execute a new query that will use the rule read in step 2.
      QueryStatement s2 = p.query("testRule(X).");
      QueryResult r3 = s2.getResult();
      while (r3.next()) {
         System.out.println("X = " + r3.getTerm("X"));
      }

      // Create and execute a new query that uses a conjunction. See: http://www.projog.org/Conjunction.html
      QueryStatement s3 = p.query("test(X, Y), Y<3.");
      QueryResult r4 = s3.getResult();
      while (r4.next()) {
         System.out.println("X = " + r4.getTerm("X") + " Y = " + r4.getTerm("Y"));
      }
   }
}
