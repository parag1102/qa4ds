package edu.cmu.lti.oaqa.ecd.phase;

import java.util.List;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;

import com.google.common.collect.Lists;

public class BasePhaseLoaderUtil {

  public static AnalysisEngineDescription[] loadOptions(List<Map<String, Object>> yaml) {
    BasePhaseLoader loader = new BasePhaseLoader();
    List<AnalysisEngineDescription> aes = Lists.newArrayList();
    for (Map<String, Object> option : yaml) {
      loader.loadOption(option, aes);
    }
    return aes.toArray(new AnalysisEngineDescription[0]);
  }
}
