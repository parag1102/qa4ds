package edu.cmu.lti.oaqa.qa4ds.util;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public final class StringReplacer {

  private Map<String, String> original2replacedStrings;

  private StringReplacer(Map<String, String> original2replacedStrings) {
    this.original2replacedStrings = original2replacedStrings;
  }

  public static StringReplacer on(Map<String, String> original2replacedStrings) {
    return new StringReplacer(original2replacedStrings);
  }

  public static StringReplacer on(List<String> originalStrings, List<String> replacedStrings) {
    Map<String, String> original2replacedStrings = Maps.newHashMap();
    for (int i = 0; i < originalStrings.size(); i++) {
      original2replacedStrings.put(originalStrings.get(i), replacedStrings.get(i));
    }
    return on(original2replacedStrings);
  }

  private List<Replacement> replacements = Lists.newArrayList();

  public String replace(String originalText) {
    // create index for replacement
    Map<Integer, String> pos2origianlString = Maps.newTreeMap();
    for (String originalString : original2replacedStrings.keySet()) {
      int pos = -1;
      while ((pos = originalText.indexOf(originalString, pos + 1)) >= 0) {
        pos2origianlString.put(pos, originalString);
      }
    }
    // build replaced string by concatenating texts that remain the same with replaced texts.
    int pos = 0;
    StringBuffer sb = new StringBuffer();
    replacements.clear();
    for (Map.Entry<Integer, String> entry : pos2origianlString.entrySet()) {
      int originalBegin = entry.getKey();
      String originalString = entry.getValue();
      // copy texts that don't change
      sb.append(originalText.substring(pos, originalBegin));
      pos = originalBegin + originalString.length();
      // copy replaced text
      String replacedString = original2replacedStrings.get(originalString);
      replacements.add(new Replacement(originalBegin, originalBegin + originalString.length(),
              originalString, sb.length(), sb.length() + replacedString.length(), replacedString));
      sb.append(replacedString);
    }
    sb.append(originalText.substring(pos));
    return sb.toString();
  }

  public List<Replacement> getReplacementDetails() {
    return replacements;
  }

  public static class Replacement {

    private int originalBegin = -1;

    private int originalEnd = -1;

    private String originalString = null;

    private int replacedBegin = -1;

    private int replacedEnd = -1;

    private String replacedString = null;

    private Replacement(int originalBegin, int originalEnd, String originalString,
            int replacedBegin, int replacedEnd, String replacedString) {
      this.originalBegin = originalBegin;
      this.originalEnd = originalEnd;
      this.originalString = originalString;
      this.replacedBegin = replacedBegin;
      this.replacedEnd = replacedEnd;
      this.replacedString = replacedString;
    }

    @Override
    public String toString() {
      return originalString + "[" + originalBegin + ":" + originalEnd + "] => " + replacedString
              + "[" + replacedBegin + ":" + replacedEnd + "]";
    }

    public int getOriginalBegin() {
      return originalBegin;
    }

    public int getOriginalEnd() {
      return originalEnd;
    }

    public String getOriginalString() {
      return originalString;
    }

    public int getReplacedBegin() {
      return replacedBegin;
    }

    public int getReplacedEnd() {
      return replacedEnd;
    }

    public String getReplacedString() {
      return replacedString;
    }

  }

  public static void main(String[] args) {
    List<String> originalStrings = Lists.newArrayList("GENE", "DISEASE");
    List<String> replacedStrings = Lists.newArrayList("gene 1", "disease 1");
    String text = "What is the function of GENE in DISEASE? and without GENE?";
    StringReplacer replacer = StringReplacer.on(originalStrings, replacedStrings);
    System.out.println(replacer.replace(text));
    for (Replacement replacement : replacer.getReplacementDetails()) {
      System.out.println(replacement);
    }
  }

}
