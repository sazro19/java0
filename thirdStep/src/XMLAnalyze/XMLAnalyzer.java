package XMLAnalyze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLAnalyzer {

    private String xml = "";

    public static List<String> nodes = new ArrayList<>();

    private XmlNode root;

    public XMLAnalyzer(String xml) {
        this.xml = xml;
        Pattern pattern = Pattern.compile("\n *| <");
        nodes = Arrays.asList(pattern.split(xml));
        System.out.println(nodes.toString());
    }

    public void startAnalyze() {
        Pattern withText = Pattern.compile("(<\\w+( \\w+ = \"\\w+\")?>)(\\w+)(</\\w+>)");
        for (String node : nodes) {
            if (Pattern.matches("(<\\w+( \\w+ = \"\\w+\")?>)(\\w+)(</\\w+>)", node)) {
                Matcher matcher = withText.matcher(node);
                while (matcher.find()) {
                    System.out.println(matcher.group(1) + " - открывающий тег");
                    System.out.println(matcher.group(3) + " - содержимое");
                    System.out.println(matcher.group(4) + " - закрывающий тег");
                }
            } else if (Pattern.matches("<\\w+( \\w+ = \"\\w+\")?>", node)) {
                System.out.println(node + " - " + "открывающией тег");
            } else if (Pattern.matches("</\\w+>", node)) {
                System.out.println(node + " - закрывающий тег");
            }
            if (Pattern.matches("<\\w+/>", node)) {
                System.out.println(node + " - тег без тела");
            }
        }
    }

    private void underNodes(String tag) {
        Pattern start = Pattern.compile(tag);
        Matcher startMatcher = start.matcher(xml);

        StringBuilder temp = new StringBuilder(tag);
        temp.insert(1, "/");
        String endTag = temp.toString();
        Pattern end = Pattern.compile(endTag);
        Matcher endMatcher = end.matcher(xml);

        Pattern nextNode = Pattern.compile("<\\w+( \\w+ = \"\\w+\")?>");
    }
}

class XmlNode {

    private List<XmlNode> children = new ArrayList<>();

    private String nodeName;

    XmlNode(String node) {
        nodeName = node;

    }

    void findChildren(XmlNode node) {
        int index = XMLAnalyzer.nodes.indexOf(node.nodeName);
        StringBuilder end = new StringBuilder(node.nodeName);
        end.insert(1, "/");
        for (int i = index + 1; !XMLAnalyzer.nodes.get(i).equals(end.toString()); i++) {
            XmlNode newNode = new XmlNode(XMLAnalyzer.nodes.get(i));
            children.add(newNode);
            if (!Pattern.matches("<\\w+( \\w+ = \"\\w+\")?>\\w+</\\w+>", XMLAnalyzer.nodes.get(i))) {
                newNode.findChildren(newNode);

            }
        }
        for (XmlNode xmlNode : children) {
            System.out.println(xmlNode.nodeName);
        }
    }
}

