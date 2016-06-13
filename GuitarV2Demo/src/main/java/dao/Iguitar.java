package dao;

import java.awt.List;

import model.Guitar;
import model.Guitars;
import model.User;

public interface Iguitar {
	
	/**
	 * 匹配/查询吉他
	 * @param serialNumber 序列号
	 * @return 
	 */
	public List searchGuitar(String number);
	
	/**
	 * 删除数据库中对应的Guirtar，通过serialNunmber删除
	 * @param serialNumber 序列号
	 * @return 
	 */
	public int delGuitar(String number);

	public int addGuitar(String number, double price, Guitar guitar);
	
}
