package xml.domutil.chooser;

import org.w3c.dom.Element;

public class ChooseElementAll implements ElementChooser {

	static private ChooseElementAll instance;

	public static ChooseElementAll build() {
		if (instance == null) {
			instance = new ChooseElementAll();
		}
		return instance;
	}

	private ChooseElementAll() {
		super();
	}

	@Override
	public boolean isOK(Element element) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChooseElementAll";
	}

}
