package kfisherp.common;

import io.cucumber.spring.CucumberContextConfiguration;
import kfisherp.MasterApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { MasterApplication.class })
public class CucumberSpingConfiguration {}
