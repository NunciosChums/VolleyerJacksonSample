package kr.susemi99.volleyerjacksonsample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyItems
{
  @JsonProperty("result")
  public ArrayList<MyItem> items;
}
