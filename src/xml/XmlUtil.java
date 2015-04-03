package xml;

import log.*;
import org.w3c.dom.*;
import xml.domutil.*;

import javax.xml.namespace.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.xpath.*;
import java.io.*;
import java.util.*;

public class XmlUtil {
    static private Properties xmlXsltPropertiesInstance = null;
    static private Properties txtXsltPropertiesInstance = null;

    static private Properties xmlXsltProperties() {
        if (xmlXsltPropertiesInstance == null) {
            xmlXsltPropertiesInstance = new Properties();
            xmlXsltPropertiesInstance.setProperty(OutputKeys.METHOD, "xml");
            xmlXsltPropertiesInstance.setProperty(OutputKeys.VERSION, "1.0");
            xmlXsltPropertiesInstance.setProperty(OutputKeys.ENCODING, "UTF-8");
            xmlXsltPropertiesInstance.setProperty(OutputKeys.INDENT, "yes");
            xmlXsltPropertiesInstance.setProperty(OutputKeys.STANDALONE, "yes");
        }
        return xmlXsltPropertiesInstance;
    }

    static private Properties txtXsltProperties() {
        if (txtXsltPropertiesInstance == null) {
            txtXsltPropertiesInstance = new Properties();
            txtXsltPropertiesInstance.setProperty(OutputKeys.METHOD, "text");
            txtXsltPropertiesInstance.setProperty(OutputKeys.ENCODING, "ISO_8859-1");
        }
        return txtXsltPropertiesInstance;
    }

    static private Transformer nullTransformer = null;

    static private Transformer getTransformer() throws Exception {
        // construct the "do nothing" transformation
        if (nullTransformer == null) {
            nullTransformer = TransformerFactory.newInstance().newTransformer();
            nullTransformer.setOutputProperties(xmlXsltProperties());
            nullTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        }
        return nullTransformer;
    }

    static private Transformer getTransformer(String xslFile) throws Exception {
        return getTransformer(new File(xslFile));
    }

    static private Transformer getTransformer(File xslFile) throws Exception {
        Transformer t = TransformerFactory.newInstance().newTransformer(
                new StreamSource(xslFile));
        t.setOutputProperties(xmlXsltProperties());
        return t;
    }

    static public Document html2dom(InputStream inputStream) throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder();
        Document dom = builder.parse(inputStream);
        DomUtil.setDomProperties(dom);
        return dom;
    }

    static public void dom2xml(Document dom, File xmlFile) throws Exception {
        Transformer t = getTransformer();
        t.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(
                xmlFile)));
    }

    static public void dom2xml(Document dom, String xmlFile) throws Exception {
        Transformer t = getTransformer();
        t.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(
                xmlFile)));
    }

    static public String dom2Concole(Document dom) throws Exception {
        Transformer t = getTransformer();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        t.transform(new DOMSource(dom), new StreamResult(os));
        return os.toString("UTF-8");
    }

    static public Document xslt(Document sourceDom, String xslFile)
            throws Exception {
        Transformer t = getTransformer(xslFile);
        DOMSource domSource = new DOMSource(sourceDom);

        DOMResult domResult = new DOMResult();
        t.transform(domSource, domResult);
        Document destinDom = (Document) (domResult.getNode());
        DomUtil.setDomProperties(destinDom);
        return destinDom;
    }

    static public void xslt(String inputXml, String xslFile, String outputXml)
            throws Exception {
        xslt(new File(inputXml), new File(xslFile), new File(outputXml));
    }

    static public void xslt(File inputXml, File xslFile, File outputXml)
            throws Exception {

        Transformer t = getTransformer(xslFile);
        t.transform(new StreamSource(inputXml), new StreamResult(
                new FileOutputStream(outputXml)));
    }

    static public void xslt(String inputXml, String xslFile) throws Exception {
        Transformer t = getTransformer(xslFile);
        t.transform(new StreamSource(inputXml), new StreamResult(System.out));
    }

    static public Document xml2dom(String xmlFile, String xslFile)
            throws Exception {
        Transformer t = getTransformer(xslFile);
        DOMResult domResult = new DOMResult();
        t.transform(new StreamSource(xmlFile), domResult);
        Document dom = (Document) (domResult.getNode());
        DomUtil.setDomProperties(dom);
        return dom;
    }

    static public String xpath(String expression, Document dom)
            throws XPathExpressionException {
        XPath path = XPathFactory.newInstance().newXPath();
        return path.evaluate(expression, dom);
    }

    static private Object xpath(String expression, Document dom, QName qname)
            throws XPathExpressionException {
        XPath path = XPathFactory.newInstance().newXPath();
        return path.evaluate(expression, dom, qname);
    }

    static public Node getNode(String xpath, Document dom)
            throws XPathExpressionException {
        return (Node) xpath(xpath, dom, XPathConstants.NODE);
    }

    static public boolean updateElementValue(String value, String xpath,
                                             Document dom) throws Exception {
        Trace.debug("XmlUtil.updateElementValue():",
                "value:", value, " xpath:", xpath);
        if (value.equals(xpath(xpath, dom))) {
            return false;
        }
        Node node = newElement(xpath, dom);
        node.setTextContent(value);
        return true;
    }

    static public Node newElement(String xpath, Document dom) throws Exception {
        XmlPath path = new XmlPath(xpath);
        Iterator<XmlElement> iterElement = path.iterator();
        XmlElement ancestorElement = iterElement.next();
        Element node = null;
        while (iterElement.hasNext()) {
            XmlElement element = iterElement.next();

            node = (Element) getNode(element.getPath(), dom);
            if (node == null) {
                node = dom.createElement(element.getName());
                for (final Object o : element.getAttributes()) {
                    XmlAttribute attribute = (XmlAttribute) o;
                    node.setAttribute(attribute.getTag(), attribute.getValue());
                }

                Element ancestorNode = (Element) getNode(
                        ancestorElement.getPath(), dom);
                ancestorNode.appendChild(node);
            }
            ancestorElement = element;
        }

        return node;
    }
}
