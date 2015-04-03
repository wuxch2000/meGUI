package xml;

import java.util.Iterator;
import java.util.LinkedList;

public class XmlPath implements Iterable<XmlElement>
{
	private LinkedList<XmlElement> path;

	public LinkedList<XmlElement> getPath() {
		return path;
	}

	public XmlPath(String pathStr) {
		super();
//		this.pathStr = pathStr;  
		path = new LinkedList<XmlElement>();

		//如果第一个字符是/，则去除。
		String pathStr4parser;
		if( pathStr.charAt(0) == '/' )
		{
			pathStr4parser = pathStr.substring(1);
		}
		else
		{
			pathStr4parser = pathStr;
		}
		
		String[] pathList = pathStr4parser.split("/");
		String baseStr = "";
		
		for( String str : pathList)
		{
			baseStr = baseStr + "/" + str;
			path.add(new XmlElement(baseStr));
		}
	}

	@Override
	public String toString() {
		String str = "";
		for( XmlElement element : path)
		{
			str = str + element.toString() + "\n";
		}
		
		return str;
	}

	@Override
	public Iterator<XmlElement> iterator() {
		return path.iterator();
	}
	
}
