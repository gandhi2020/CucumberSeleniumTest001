package com.test.test.runnerclass;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features001",
        glue = "com.test.test",
        monochrome = false,
        tags = "@Test1"
)
public class RunnerTestNg001 extends AbstractTestNGCucumberTests {

    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeClass
    public static void setUp() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-report.html");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setDocumentTitle("Cucumber Selenium Example");
        sparkReporter.config().setReportName("Cucumber Selenium Test Report");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        test = extent.createTest("Login Feature");
    }

    @AfterClass
    public static void tearDown() {

        extent.flush();
    }

    public static void logStep(String message) {

        test.info(message);
    }

    public static void logPass(String message) {

        test.pass(message);
    }

    public static void logFail(String message) {

        test.fail(message);
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        return super.scenarios();
    }
}