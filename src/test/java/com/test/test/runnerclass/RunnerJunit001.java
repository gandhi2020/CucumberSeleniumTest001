package com.test.test.runnerclass;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features001",
        glue = "com.test.test",
        monochrome = false,
        tags = "@Test1"
        )
public class RunnerJunit001 {

}

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "classpath:features",
//        glue = "stepDefinitions")
//public class RunnerJunit001 {
//
//}
