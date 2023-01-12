package util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {
    private int retryCount = 1;
    private static final int maxRetryCount = 5;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetryCount) {
            if(retryCount==maxRetryCount-4){
                Namess.name="Vasiliy";
            }
            retryCount++;
            return true;
        }

        return false;
    }
}
