package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class QueryProcessor {

  public String process(String query) {

    System.out.println("Received query:" + query);

    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    }

    if (query.toLowerCase().contains("your name?")) {
      return "ece";
    }

    if (query.toLowerCase().contains("largest")) {
      Pattern integerPattern = Pattern.compile("-?\\d+");
      Matcher matcher = integerPattern.matcher(query);
      List<String> integerList = new ArrayList<>();

      while (matcher.find()) {
        integerList.add(matcher.group());
      }

      List<Integer> intList =  integerList.stream().map(Integer::parseInt).collect(Collectors.toList());
      String a = Integer.toString(Collections.max(intList));
      return a;
    }

    if (query.toLowerCase().contains("plus")) {
      Pattern integerPattern = Pattern.compile("-?\\d+");
      Matcher matcher = integerPattern.matcher(query);
      List<String> integerList = new ArrayList<>();

      while (matcher.find()) {
        integerList.add(matcher.group());
      }

      List<Integer> intList = integerList.stream().map(Integer::parseInt).collect(Collectors.toList());
      Integer sum = intList.stream()
              .mapToInt(Integer::intValue)
              .sum();
      String a = Integer.toString(sum);
      return a;
    }

    if (query.toLowerCase().contains("multiplied")) {
      Pattern integerPattern = Pattern.compile("-?\\d+");
      Matcher matcher = integerPattern.matcher(query);
      List<String> integerList = new ArrayList<>();

      while (matcher.find()) {
        integerList.add(matcher.group());
      }

      List<Integer> intList =  integerList.stream().map(Integer::parseInt).collect(Collectors.toList());
      Integer sum = intList.stream()
              .mapToInt(Integer::intValue)
              .reduce(1, Math::multiplyExact);
      String a = Integer.toString(sum);
      return a;
    }

    if (query.toLowerCase().contains("square and a cube")) {
      Pattern integerPattern = Pattern.compile("-?\\d+");
      Matcher matcher = integerPattern.matcher(query);
      List<String> integerList = new ArrayList<>();

      while (matcher.find()) {
        integerList.add(matcher.group());
      }

      List<Integer> intList =  integerList.stream().map(Integer::parseInt).collect(Collectors.toList());
      Integer b = null;
      for(Integer i : intList){
        if ((Math.sqrt(i) % 1) == 0){
          if((Math.cbrt(i) % 1) == 0){
            b = i;
          }
        }
      }
      String a = Integer.toString(b);
      return a;
    }

    return "";
  }
}
