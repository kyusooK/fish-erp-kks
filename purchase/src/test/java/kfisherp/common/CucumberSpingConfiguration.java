package kfisherp.common;

import io.cucumber.spring.CucumberContextConfiguration;
import kfisherp.PurchaseApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { PurchaseApplication.class })
public class CucumberSpingConfiguration {}
