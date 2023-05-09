package com.test.test.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil {

    private static ExtentReports extent;

    public static void initializeExtentReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-report.html");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setDocumentTitle("Cucumber Selenium Example");
        sparkReporter.config().setReportName("Cucumber Selenium Test Report");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void addScenario(String scenarioName) {
        extent.createTest(scenarioName);
    }

    public static void addStep(String stepName) {
        extent.createTest(stepName);
    }

    public static void flushReport() {
        extent.flush();
    }
}


