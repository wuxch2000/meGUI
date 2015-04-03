package xml;

import java.util.ArrayList;
import java.util.Iterator;

public class XmlAttributes implements Iterable<XmlAttribute> {

	ArrayList<XmlAttribute> list;

	public XmlAttributes() {
		super();
		list = new ArrayList<XmlAttribute>();
	}

	public XmlAttributes(String str) {
		super();
		// 去除中括号
		list = new ArrayList<XmlAttribute>();
		String realStr = str.replaceAll("\\s*\\[\\s*", "").replaceAll(
				"\\s*\\]\\s*", "");

		String[] strList = realStr.split("\\s*,\\s*");
		XmlAttribute attr;
		for (String attrStr : strList) {
			attr = getPairFromString(attrStr);
			if (attr != null) {
				list.add(attr);
			}
		}
	}

	@Override
	public String toString() {
		String str = "[";
		for (XmlAttribute attr : list) {
			str = str + attr.toString() + ",";
		}
		str = str + "]";
		return str;
	}

	@Override
	public boolean equals(Object obj) {
		Iterator<XmlAttribute> otherIter = ((XmlAttributes) obj).iterator();
		for (Iterator<XmlAttribute> iter = list.iterator(); iter.hasNext();) {
			if (iter.next() != otherIter.next()) {
				return false;
			}
		}
		return true;
	}

	private XmlAttribute getPairFromString(String str) {
		String[] strList = str.split("\\s*=\\s*");
		if (strList.length == 2) {
			String tag = strList[0].substring(strList[0].indexOf("@") + 1);
			String value = strList[1].substring(strList[1].indexOf("'") + 1,
					strList[1].lastIndexOf("'"));
			return new XmlAttribute(tag, value);
		}
		return null;
	}

	@Override
	public Iterator<XmlAttribute> iterator() {
		return list.iterator();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
