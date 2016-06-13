package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Iguitar;
import model.Guitar;
import model.Guitars;
import util.DBUtil;


/**
 * 使用Sqlite数据库的实现类
 * 实现IGuitarDao
 * @author lzm
 *
 */
public class InstrumentImpl implements Iguitar{
	/**
	 * 增加一个新的Guitar
	 */
	public int addGuitar(String number, double price, Guitar guitar) {
		Connection Conn = DBUtil.open();
		String sql = "insert into guitar(number,builder,model,type,backWood,topWood,price) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, number);
			pstmt.setString(2, guitar.getBuilder());
			pstmt.setString(3, guitar.getModel());
			pstmt.setString(4, guitar.getType());
			pstmt.setString(5, guitar.getBackwood());
			pstmt.setString(6, guitar.getTopwood());
			pstmt.setDouble(7, price);
			int i = pstmt.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(Conn);
		}
		return 0;
	}
	/**
	 * 查询Guitar信息
	 * @return 一个List列表，存放数据库中的所有Guitar
	 */
	public java.awt.List searchGuitar(String number) {
		Connection Conn = DBUtil.open();
		String sql = "select * from Guitar where number=?";
		
		List<Guitars> guitarList = new ArrayList<Guitars>();
		
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, number);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Guitars guitar = new Guitars(rs.getString("number"), rs.getDouble("price"), 
						new Guitar(rs.getString("builder"),rs.getString("model"),
								rs.getString("type"),rs.getString("backWood"),
								rs.getString("topWood")));
				guitarList.add(guitar);
			}
			return (java.awt.List) guitarList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(Conn);
		}
		return null;
	}
	
	/**
	 * 删除数据库中对应的Guirtar，通过serialNunmber删除
	 * @param serialNumber 序列号
	 */
	public int delGuitar(String number) {
		Connection Conn = DBUtil.open();
		String sql = "delete from Guitar where number = ?";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, number);
			int i = pstmt.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(Conn);
		}
		return 0;
	}
}