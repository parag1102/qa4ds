package edu.cmu.lti.oaqa.qa4ds.input;

public class ResourceUtil {

  static String getResourceLocation(String resource) {
    return "/" + resource.replace(".", "/") + ".yaml";
  }

}
