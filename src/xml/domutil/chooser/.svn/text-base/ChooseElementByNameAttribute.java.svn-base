package xml.domutil.chooser;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

public class ChooseElementByNameAttribute extends ChooseElementByName {
	public static ChooseElementByNameAttribute build(String tagName,
			String attributeName, String attributeValue) {
		return new ChooseElementByNameAttribute(tagName, attributeName,
				attributeValue);
	}

	final String attributeName;
	final String attributeValue;

	/**
	 * @param tagName
	 * @param attributeName
	 * @param attributeValue
	 *            如果入参attributeValue为null，表示任何取值皆可。
	 */
	private ChooseElementByNameAttribute(String tagName, String attributeName,
			String attributeValue) {
		super(tagName);
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
	}

	@Override
	public boolean isOK(Element element) {
		if (super.isOK(element) == false) {
			return false;
		}

		Attr attr = element.getAttributeNode(attributeName);
		if (attr == null) {
			return false;
		}
		if (attributeValue == null) {
			return true;
		}
		String value = attr.getValue();
		return value.equals(attributeValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChooseElementByNameAttribute [tagName=" + super.getTagName()
				+ ", attributeName=" + attributeName + ", attributeValue="
				+ attributeValue + "]";
	}
}
