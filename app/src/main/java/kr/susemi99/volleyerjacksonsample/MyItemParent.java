package kr.susemi99.volleyerjacksonsample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyItemParent
{
  @JsonProperty("result")
  public MyItem item;
}
