package edu.cmu.lti.oaqa.qa4ds.util;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class EcdUtil {

  // replace ecd descriptor embedded in other yaml resource, non-recursive
  public static <V> void resolveInherit(Map<String, V> data) {
    if (data.containsKey("inherit")) {
      Map<String, V> inherit = loadResource((String) data.get("inherit"));
      data.remove("inherit");
      data.putAll(inherit);
    }
  }

  private static Yaml yaml = new Yaml();

  @SuppressWarnings("unchecked")
  public static <V> Map<String, V> loadResource(String path) {
    String parsedResourcePath = getResourceLocation(path);
    InputStream is = EcdUtil.class.getResourceAsStream(parsedResourcePath);
    return (Map<String, V>) yaml.load(is);
  }

  public static String getResourceLocation(String resource) {
    return "/" + resource.replace(".", "/") + ".yaml";
  }

}
