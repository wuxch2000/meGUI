package xml;

public class XmlElement {
	private String path;
	private String name;
	private XmlAttributes attributes;
	public XmlElement(String path) {
		super();
		this.path = path;
		String elementFullName = path.substring(path.lastIndexOf("/")+1);
		int attribteBegin = elementFullName.indexOf("[");
		if( attribteBegin == -1 )
		{
			this.name = elementFullName;
			this.attributes = new XmlAttributes();
		}
		else
		{
			this.name = elementFullName.substring(0,attribteBegin);
			this.attributes = new XmlAttributes(elementFullName.substring(attribteBegin));
		}
	}
	@Override
	public String toString() {
		String attributeStr = "";
		if( attributes != null)
			attributeStr = attributes.toString();
		return "XmlElement:" + name + attributeStr + " path:" + path;
	}
	public String getPath() {
		return path;
	}
	public String getName() {
		return name;
	}
	public XmlAttributes getAttributes() {
		return attributes;
	}
}
