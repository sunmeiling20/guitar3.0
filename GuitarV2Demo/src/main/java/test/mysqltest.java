package test;

import java.util.List;

import dao.Iguitar;
import model.Guitar;
import model.Guitars;
import mysqlDao.InstrumentImpl;
public class mysqltest {
	public static void main(String[] args) {
		Guitar guitar = new Guitar("builder","model","type","backWood","topkWood");
		InstrumentImpl inventory=new InstrumentImpl();
		System.out.println("请添加吉他的型号和价格");
		 inventory.addGuitar("02", 100.00, guitar);
		 List<Guitars> list = (List<Guitars>) inventory.searchGuitar("02");
		for (Guitars guitars : list) {
			System.out.println(guitars.getNumber()+"    "+guitars.getPrice());
		}
		inventory.delGuitar("01");
		System.out.println("删除成功");
		
		
	}
}
