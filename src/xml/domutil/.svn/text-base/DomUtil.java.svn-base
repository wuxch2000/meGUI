package xml.domutil;

import org.w3c.dom.*;
import xml.domutil.chooser.*;

import javax.xml.parsers.*;
import java.io.*;

public class DomUtil {

    static public void setDomProperties(Document dom) {
        dom.setXmlVersion("1.0");
        dom.setXmlStandalone(true);
    }

    public static Document build(File xmlFile) throws Exception {
        Document dom = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder().parse(xmlFile);
        setDomProperties(dom);
        return dom;
    }

    public static Document build() throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder();
        Document dom = builder.newDocument();
        DomUtil.setDomProperties(dom);
        return dom;
    }

    /**
     * 创建一个新的名称为tag的element，作为parent的子节点，并返回之。
     *
     * @param dom
     * @param parent
     * @param tag
     * @return 新的名称为tag的element
     */
    public static Element newElementWithAppend(Document dom, Element parent,
                                               String tag) {
        Element newElement = dom.createElement(tag);
        parent.appendChild(newElement);
        return newElement;
    }

    /**
     * 创建一个新的名称为tag的element，作为parent的子节点，并返回之。
     *
     * @param dom
     * @param parent
     * @param tag
     * @return 新的名称为tag的element
     */
    public static Element newElementWithInsert(Document dom, Element parent,
                                               String tag) {
        Element newElement = dom.createElement(tag);
        if (parent.getChildNodes().getLength() >= 1) {
            parent.insertBefore(newElement, parent.getChildNodes().item(0));
        } else {
            parent.appendChild(newElement);
        }
        return newElement;
    }

    public static Element newElement(Document dom, String tag) {
        Element newElement = dom.createElement(tag);
        return newElement;
    }

    /**
     * 创建一个新的名称为tag的root element，并返回之。
     *
     * @param dom
     * @param tag
     * @return 新的名称为tag的element
     */
    public static Element newRootElement(Document dom, String namespace,
                                         String tag) {
        Element newElement = dom.createElementNS(namespace, tag);
        dom.appendChild(newElement);
        return newElement;
    }

    /**
     * 创建一个新的名称为tag的root element，并返回之。
     *
     * @param dom
     * @param tag
     * @return 新的名称为tag的element
     */
    public static Element newRootElement(Document dom, String tag) {
        Element newElement = dom.createElement(tag);
        dom.appendChild(newElement);
        return newElement;
    }

    public static Element getRootElement(Document dom) {
        return dom.getDocumentElement();
    }

    /**
     * 返回名称为tag的下一个兄弟节点的
     *
     * @param element
     * @param tag
     * @return
     */
    public static Element getNextElementByTag(Element element, String tag) {
        Element nextElement = getNextElement(element);
        while (nextElement != null && !nextElement.getTagName().equals(tag)) {
            nextElement = getNextElement(nextElement);
        }
        return nextElement;
    }

    /**
     * 返回下一个兄弟节点的
     *
     * @param element
     * @return
     */
    public static Element getNextElement(Element element) {
        Node node = element.getNextSibling();
        while (node != null && (!isElement(node))) {
            node = node.getNextSibling();
        }
        return (Element) node;
    }

    public static boolean isElement(Node node) {
        return node.getNodeType() == Node.ELEMENT_NODE;
    }

    public static boolean isText(Node node) {
        return node.getNodeType() == Node.TEXT_NODE;
    }

    public static boolean isAttr(Node node) {
        return node.getNodeType() == Node.ATTRIBUTE_NODE;
    }

    /**
     * 根据名称，查找所有的子元素。注意：不支持嵌套
     *
     * @param element
     * @param tagName
     * @return
     */
    public static ElementArray getElementsByTagName(Element element,
                                                    String tagName) {
        return ElementArray.build(element.getElementsByTagName(tagName));
    }

    /**
     * 在某个element里面查找第一个名称符合的child element，考虑嵌套关系
     *
     * @param parent
     * @param chooser
     * @return
     * @throws Exception
     */
    public static Element getFistChildElement(Element parent,
                                              ElementChooser chooser) throws Exception {
        ElementArray childrenElement = ElementArray.build(parent
            .getChildNodes());
        for (Element element : childrenElement) {
            // Trace.debug("check element:", element.getTagName());
            if (chooser.isOK(element)) {
                return element;
            }
            Element subEle = getFistChildElement(element, chooser);
            if (subEle != null) {
                return subEle;
            }
        }
        return null;
    }

    public static Element importElementAsChild(Document dom, Element parent,
                                               Element importElement) {
        Node node = dom.importNode(importElement, true);
        parent.appendChild(node);
        return (Element) node;
    }

    public static Element importElementAsBrother(Document dom, Node parent,
                                                 Element refChildElement, Element importElement) {
        Node node = dom.importNode(importElement, true);
        parent.insertBefore(node, refChildElement);
        return (Element) node;
    }

    /**
     * 在某个element里面查找所有名称符合的子 element，考虑嵌套关系
     *
     * @param parent
     * @param chooser
     * @return
     * @throws Exception
     */
    public static ElementArray getAllChildElement(Element parent,
                                                  ElementChooser chooser) throws Exception {
        ElementArray elementArray = new ElementArray();
        ElementArray childrenElement = ElementArray.build(parent
            .getChildNodes());
        for (Element element : childrenElement) {
            // Trace.debug("check element:", element.getTagName());
            if (chooser.isOK(element)) {
                elementArray.add(element);
            }
            ElementArray subEle = getAllChildElement(element, chooser);
            elementArray.addAll(subEle);
        }
        return elementArray;
    }

    /**
     * 在某个element里面查找所有名称符合的子 element，不考虑嵌套关系
     *
     * @param parent
     * @param chooser
     * @return
     * @throws Exception
     */
    public static ElementArray getAllFirstLevelChildElement(Element parent,
                                                            ElementChooser chooser) throws Exception {
        ElementArray elementArray = new ElementArray();
        ElementArray childrenElement = ElementArray.build(parent
            .getChildNodes());
        for (Element element : childrenElement) {
            // Trace.debug("check element:", element.getTagName());
            if (chooser.isOK(element)) {
                elementArray.add(element);
            }
        }
        return elementArray;
    }

}
