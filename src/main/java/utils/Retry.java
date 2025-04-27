package utils;

import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Slf4j
public class Retry implements IRetryAnalyzer {

    private static final int MAX_RETRY = 2;
    private int attempt = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (attempt < MAX_RETRY) {
                attempt++;
                iTestResult.setStatus(ITestResult.FAILURE);
                log.warn("Test failed. Retrying the test");
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
                log.info("No more retrying attempts");
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
            log.info("Test succeed");
        }
        return false;
    }
}
