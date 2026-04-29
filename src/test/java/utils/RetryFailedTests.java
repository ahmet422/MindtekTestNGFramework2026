package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    int retry = 1;                  // retry counter
    int numberOfRetries = 3;        // max number of retries

    @Override                      // overriding retry method in IRetryAnalyzer
    public boolean retry(ITestResult iTestResult){
        if ( retry < numberOfRetries ){
            retry++;           // incrementing counter
            return true;       // continue to re-run
        }
        return false;          //stop re-run
    }
}
