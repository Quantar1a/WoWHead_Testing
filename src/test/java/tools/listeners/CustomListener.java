package tools.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import tools.anotations.UpdatePoint;

import java.util.Arrays;
import java.util.Date;

@UpdatePoint("21.10.2023")
public class CustomListener implements ITestListener
{
    Date startDate;
    Date endDate;
    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.print('\n' + "Test " + result.getName() + " is started");

        if (result.getParameters().length == 0){
            System.out.print(".");
        } else {
            System.out.print(" with parameter: " + Arrays.toString(result.getParameters()));
        }
        System.out.println();
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Test " + result.getName() + " is finished successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("Test " + result.getName() + " is failure.");
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("Test " + result.getName() + "is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        System.out.println("Test " + result.getName() + "failed, but with success percentage.");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result)
    {
        System.out.println("Test " + result.getName() + "failed with timeout.");
    }

    @Override
    public void onStart(ITestContext context)
    {
        startDate = context.getStartDate();
        ITestNGMethod[] listOfMethods = context.getAllTestMethods();
        System.out.println("TestSuite " + context.getName() + " is started with test methods: ");

        for (int i = 0; i < listOfMethods.length; i++) {
            if (listOfMethods.length == (i + 1)) {
                System.out.println((listOfMethods[i].getMethodName()) + ".");
            } else {
                System.out.print(listOfMethods[i].getMethodName() + ", ");
            }
        }

        System.out.println("Start time: " + startDate);
    }

    @Override
    public void onFinish(ITestContext context)
    {
        endDate = context.getEndDate();
        System.out.println("TestSuite " + context.getName() + " is finished.");
        System.out.println("Finish time: " + endDate);
        long spentTime = (endDate.getTime() - startDate.getTime())/1000;
        System.out.print("Spent time for TestSuite " + context.getName() + ": ");

        if (spentTime % 60 != 0) {
            long seconds = spentTime % 60;
            long minutes = (spentTime - seconds)/60;
            System.out.print(minutes + " minutes, " + seconds + " seconds.");
        } else {
            System.out.print(spentTime + " seconds.");
        }
    }
}
