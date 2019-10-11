package com.example.hyfdemo;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * User : Blues
 * Date : 2019/10/9
 * Time : 18:18
 */

public class Test {

    public static void main(String[] args) {
        String path = "D:\\test\\test.htm";

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new File(path));
            Node resources = doc.getFirstChild();
            NodeList elements = resources.getChildNodes();

            for (int i = 0; i < elements.getLength(); i++) {
                Node element = elements.item(i);
                if (element.getNodeType() == Node.ELEMENT_NODE) {
                    String nodeName = element.getNodeName();
                    System.out.println(nodeName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
