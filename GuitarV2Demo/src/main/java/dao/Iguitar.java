package dao;

import java.awt.List;

import model.Guitar;
import model.Guitars;
import model.User;

public interface Iguitar {
	
	/**
	 * ƥ��/��ѯ����
	 * @param serialNumber ���к�
	 * @return 
	 */
	public List searchGuitar(String number);
	
	/**
	 * ɾ�����ݿ��ж�Ӧ��Guirtar��ͨ��serialNunmberɾ��
	 * @param serialNumber ���к�
	 * @return 
	 */
	public int delGuitar(String number);

	public int addGuitar(String number, double price, Guitar guitar);
	
}
