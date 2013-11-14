package edu.cmu.lti.oaqa.qa4ds.test;

import java.util.UUID;

import org.junit.Test;

import edu.cmu.lti.oaqa.ecd.driver.ECDDriver;

public class Qa4dsTest {

  @Test
  public void testOneLayerPipeline() throws Exception {
    testPipeline("qa4ds.qa4ds-one-layer-test");
  }

  void testPipeline(String resource) throws Exception {
    String uuid = UUID.randomUUID().toString();
    System.out.println("Experiment UUID: " + uuid);
    ECDDriver driver = new ECDDriver(resource, uuid);
    driver.run();
  }

}
