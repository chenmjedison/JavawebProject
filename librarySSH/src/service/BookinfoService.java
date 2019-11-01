package service;

import java.util.List;

import entity.Bookinfo;

public interface BookinfoService {
	public List getBooks() throws Exception;//获取所有图书信息
	public Bookinfo getBook(Integer id);//获取单个图书信息
	public void updateBook(Bookinfo book);//更新或添加图书信息
	public void deleteBook(Bookinfo book);//删除图书信息
}
