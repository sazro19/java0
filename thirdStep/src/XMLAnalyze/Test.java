package XMLAnalyze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        XMLAnalyzer xmlAnalyzer = new XMLAnalyzer("""
                <root>
                  <item>
                    <key id = "1">Name</key>
                    <value>John</value>
                  </item>
                  <empty/>
                  <item>
                    <key>City</key>
                    <value>London</value>
                  </item>
                </root>""");
        Pattern pattern = Pattern.compile("<\\w+>([^>]+)</\\w+>");
        Matcher matcher = pattern.matcher("<ds>sd</ds>");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
        xmlAnalyzer.startAnalyze();
    }
}
