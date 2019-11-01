package helloTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class helloTag implements Tag{
	private PageContext pageContext;
	private Tag parent;
	@Override
	public void setPageContext(PageContext pageContext){
		this.pageContext=pageContext;
	}
	@Override
	public void setParent(Tag parent){
		this.parent=parent;
	}
	@Override
	public int doStartTag() throws JspException{
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException{
		JspWriter out=pageContext.getOut();
		try{
			out.println("Hello World");
		}catch(IOException e){
			throw new JspException("IO Error"+e.getMessage());
		}
		return EVAL_PAGE;
	}
	@Override
	public void release(){
		
	}
	@Override
	public Tag getParent(){
		return null;
	}
}
