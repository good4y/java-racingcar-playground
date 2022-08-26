package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  public static int splitAndSum(String text) {
    if(isValidText(text))
      return 0;

    int answer = 0;

    Matcher m = Pattern.compile(("//(.)\n(.*)")).matcher(text);

    if(m.find()){
      String customDelimiter = m.group(1);
      String[] tokens = m.group(2).split(customDelimiter);

      answer = getAnswer(answer, tokens);
      return answer;
    }

    String[] tokens = text.split("[,:]");

    answer = getAnswer(answer, tokens);

    return answer;

  }

  private static boolean isValidText(String text) {
    return text == null || text.isEmpty();
  }

  private static int getAnswer(int answer, String[] tokens) {
    for (String token : tokens) {
      if(Integer.parseInt(token) < 0){
        throw new RuntimeException();
      }
      answer += Integer.parseInt(token);
    }
    return answer;
  }
}
