package xml.domutil;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("serial")
public class ElementArray extends ArrayList<Element> {

	static public ElementArray build(NodeList nodeList) {
		ElementArray array = new ElementArray();
		int length = nodeList.getLength();
		for (int i = 0; i < length; i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				array.add((Element) node);
			}
		}
		return array;
	}
}
