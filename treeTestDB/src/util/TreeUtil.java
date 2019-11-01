package util;
import java.util.List;
import java.util.Map;
import util.DBUtil;
public class TreeUtil {
	private DBUtil db;
	public TreeUtil(){
		db=new DBUtil();
		db.setUrl("jdbc:mysql://localhost:3306/test");
	}
	public String getTreeNodes(){
		StringBuffer buf=new StringBuffer();
		buf.append("<script type='text/javascript'>");
		buf.append("d=new dTree('d');");
		String sql="select * from dtree";
		System.out.println("AAAA");
		List l=db.getAllList(sql);
		for(Object o:l){
			Map m=(Map)o;
			buf.append("d.add(");
			buf.append(m.get("id")+",");
			buf.append(m.get("pid")+",'");
			buf.append(m.get("name")+"','");
			buf.append(m.get("url")+"','");
			buf.append(m.get("title")+"','");
			buf.append(m.get("target")+"','");
			buf.append("img/"+m.get("icon")+"','");
			buf.append("img/"+m.get("iconopen"));
			buf.append("');");
		}
		buf.append("document.write(d)");
		buf.append("</script>");
		return buf.toString();
	}
}
