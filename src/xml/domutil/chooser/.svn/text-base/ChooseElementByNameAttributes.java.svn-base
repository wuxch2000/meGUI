package xml.domutil.chooser;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import xml.StringUtil;

public class ChooseElementByNameAttributes extends ChooseElementByName {
	public static ChooseElementByNameAttributes build(String tagName,
			String attributeName, String[] attributeValues) {
		return new ChooseElementByNameAttributes(tagName, attributeName,
				attributeValues);
	}

	final String attributeName;
	final String[] attributeValues;

	/**
	 * @param tagName
	 * @param attributeName
	 * @param attributeValue
	 *            如果入参attributeValue为null，表示任何取值皆可。
	 */
	private ChooseElementByNameAttributes(String tagName, String attributeName,
			String[] attributeValues) {
		super(tagName);
		this.attributeName = attributeName;
		this.attributeValues = attributeValues;
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
		if (attributeValues == null) {
			return true;
		}
		String value = attr.getValue();
		for (String attributeValue : attributeValues) {
			if (value.equals(attributeValue)) {
				return true;
			}
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChooseElementByNameAttribute [tagName=" + super.getTagName()
				+ ", attributeName=" + attributeName + ", attributeValues="
				+ StringUtil.concat(attributeValues) + "]";
	}
}
