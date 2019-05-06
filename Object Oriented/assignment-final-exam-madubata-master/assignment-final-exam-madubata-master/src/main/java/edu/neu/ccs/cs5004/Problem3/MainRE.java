package edu.neu.ccs.cs5004.Problem3;

import java.util.ArrayList; import java.util.List;
import java.util.regex.Matcher; import java.util.regex.Pattern;

/**
 *
 */
public class MainRE {

  /**
   * Give a string, if each part of the string matches our pattern, then the string is added to the list as
   * a sentence describing what was found, and where it was found.
   * @param stringToMatch the string we are trying to match with our pattern.
   * @return a list noting what strings we found that matched the pattern.
   */
  public static List findMatch(String stringToMatch) {
    List resultingList = new ArrayList();
    Pattern re = Pattern.compile("(NEU)*(CCIS)([a-z]*)(Sea)(ttle)*");
    Matcher matcher = re.matcher(stringToMatch); if (matcher.matches()) {
      for (int i = 1; i <= 3; i++) {
        resultingList.add(String.format("Found \"%s\" starting at %d, ending at %d", matcher.group(i) , matcher.start(i), matcher.end(i)));
      }
      return resultingList;
    }
    else return null;
  }
}
