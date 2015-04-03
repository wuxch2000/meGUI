package xml.domutil.chooser;

import org.w3c.dom.Element;

public class ChooseElementByName implements ElementChooser {
	public static ChooseElementByName build(String tagName) {
		return new ChooseElementByName(tagName);
	}

	final private String tagName;

	protected ChooseElementByName(String tagName) {
		super();
		this.tagName = tagName;
	}

	@Override
	public boolean isOK(Element element) {
		return element.getTagName().equals(tagName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChooseElementByName [tagName=" + tagName + "]";
	}

	/**
	 * @return the tagName
	 */
	protected String getTagName() {
		return tagName;
	}

}
