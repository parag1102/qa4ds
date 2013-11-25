package edu.cmu.lti.oaqa.qa4ds.input;

import java.util.Map;

public class InputPair {

  private String key;

  private Map<String, String> value;

  public InputPair(String key, Map<String, String> value) {
    super();
    this.key = key;
    this.value = value;
  }

  @Override
  public String toString() {
    return key + value.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    InputPair other = (InputPair) obj;
    if (key == null) {
      if (other.key != null)
        return false;
    } else if (!key.equals(other.key))
      return false;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }

  public String getKey() {
    return key;
  }

  public Map<String, String> getValue() {
    return value;
  }

}