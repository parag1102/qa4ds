package edu.cmu.lti.oaqa.qa4ds.test;

import java.util.UUID;

import org.junit.Test;

import edu.cmu.lti.oaqa.ecd.driver.ECDDriver;

public class Qa4dsTest {

  @Test
  public void testOneLayerDefaultPipeline() throws Exception {
    testPipeline("qa4ds.qa4ds-one-layer-default-test");
  }

  @Test
  public void testOneLayerComplexPipeline() throws Exception {
    testPipeline("qa4ds.qa4ds-one-layer-complex-test");
  }

  @Test
  public void testTwoLayersDefaultPipeline() throws Exception {
    testPipeline("qa4ds.qa4ds-two-layers-default-test");
  }

  @Test
  public void testTwoLayersComplexPipeline() throws Exception {
    testPipeline("qa4ds.qa4ds-two-layers-complex-test");
  }

  void testPipeline(String resource) throws Exception {
    String uuid = UUID.randomUUID().toString();
    System.out.println("Experiment UUID: " + uuid);
    ECDDriver driver = new ECDDriver(resource, uuid);
    driver.run();
  }

}
