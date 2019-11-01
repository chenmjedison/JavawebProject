package com.lanhai.utils;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class PageTag extends TagSupport {

	// 定义标签外部传入的参数
	private String url; // 请求Controller的路径

	private int currentPage; // 请求的页面

	private int totalPage; // 总页数

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	// 将你拼接的字符串，显示在页面
	@SuppressWarnings("static-access")
	@Override
	public int doEndTag() throws JspException {
		String str = createTageMethod();
		try {
			pageContext.getOut().print(str);
		} catch (IOException e) {
			e.printStackTrace();
		} // 将字符串显示在页面上
		return this.EVAL_PAGE;
	}

	/**
	 * 第一种分页方式，分页格式为“第1/5页 首页 上一页 1 2 3 4 5 6 7 8 9 10 下一页 尾页 ”
	 * 
	 * @return
	 */
	private String createTageMethod() {
		StringBuilder builder = new StringBuilder();
		builder.append("<label style='font-size:14px;color:#000;'>");
		builder.append("第" + currentPage + "/" + totalPage + "页&nbsp;&nbsp;&nbsp;&nbsp;");
		// 拼接首页
		if (url != null && url.contains("?")) {
			builder.append("<a href=" + url + "&currentPage=1>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		} else {
			builder.append("<a href=" + url + "?currentPage=1>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		

		// 拼接上一页
		if (currentPage <= 1) {
			builder.append("<span style='color: gray;'>上一页</span>&nbsp;&nbsp;");
		} else {
			if (url != null && url.contains("?")) {
				builder.append("<a href=" + url + "&currentPage=" + (currentPage - 1) + ">上一页</a>");
			} else {
				builder.append("<a href=" + url + "?currentPage=" + (currentPage - 1) + ">上一页</a>");
			}
		}
		// 拼接中间的数字页码

		// 当前页面左边的 当前页码的前面5个数字
		for (int i = 5; i >= 1; i--) {
			if ((currentPage - i) < 1) {
				continue;
			} else {
				if (url != null && url.contains("?")) {
					builder.append("<a href='" + url + "&currentPage=" + (currentPage - i) + "'>" + (currentPage - i)
							+ "</a>&nbsp;&nbsp;");

				} else {
					builder.append("<a href='" + url + "?currentPage=" + (currentPage - i) + "'>" + (currentPage - i)
							+ "</a>&nbsp;&nbsp;");
				}
			}
		}

		// 当前页
		builder.append("<font color='red'>" + currentPage + "</font>&nbsp;&nbsp;");

		// 当前页码的后面5个数字
		for (int i = 1; i <= 5; i++) {
			if ((currentPage + i) > totalPage) {
				break;
			} else {
				if (url != null && url.contains("?")) {
					builder.append("<a href='" + url + "&currentPage=" + (currentPage + i) + "'>" + (currentPage + i)
							+ "</a>&nbsp;&nbsp;");
				} else {
					builder.append("<a href='" + url + "?currentPage=" + (currentPage + i) + "'>" + (currentPage + i)
							+ "</a>&nbsp;&nbsp;");
				}
			}
		}

		// 拼接下一页
		if (currentPage >= totalPage) {
			builder.append("<span style='color: gray;'>下一页</span> &nbsp;&nbsp;&nbsp;&nbsp;");
		} else {
			if (url != null && url.contains("?")) {
				builder.append("<a href=" + url + "&currentPage=" + (currentPage + 1) + ">下一页</a>&nbsp;&nbsp;");
			} else {
				builder.append("<a href=" + url + "?currentPage=" + (currentPage + 1) + ">下一页</a>&nbsp;&nbsp;");
			}
		}

		// 拼接尾页
		if (url != null && url.contains("?")) {
			builder.append("<a href=" + url + "&currentPage=" + totalPage + ">尾页</a>&nbsp;&nbsp;");
		} else {
			builder.append("<a href=" + url + "?currentPage=" + totalPage + ">尾页</a>&nbsp;&nbsp;");
		}

		builder.append("</label>");
		return builder.toString();
	}

}
