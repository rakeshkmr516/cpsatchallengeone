package org.cpsat;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JunitTestRunner {
	
	 public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(ChallengeTestSuiteFive.class);

	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }

}
