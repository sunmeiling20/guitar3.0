package mysqlDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.pept.transport.Connection;

import dao.IInstrument;
import dao.Iguitar;
import model.Guitar;
import model.Guitars;

import util.DBUtil;

public  class InstrumentImpl implements Iguitar {
	@Override
	public int addGuitar(String number, double price, Guitar guitar) {
		java.sql.Connection Conn = (java.sql.Connection) DBUtil.open();
		String sql = "insert into guitar(number,builder,model,type,price,topWood,backWood) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = ((java.sql.Connection) Conn).prepareStatement(sql);
			pstmt.setString(1, number);
			pstmt.setString(2, guitar.getBuilder());
			pstmt.setString(3, guitar.getModel());
			pstmt.setString(4, guitar.getType());
			pstmt.setString(5, guitar.getBackwood());
			pstmt.setString(6, guitar.getTopwood());
			pstmt.setDouble(7, price);
			return pstmt.executeUpdate();
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
	@Override
	public java.awt.List searchGuitar(String number) {
		java.sql.Connection Conn = (java.sql.Connection) DBUtil.open();
		String sql = "select * from guitar where number=?";
		
		List<Guitars> guitarList = new ArrayList<Guitars>();
		
		try {
			PreparedStatement pstmt = ((java.sql.Connection) Conn).prepareStatement(sql);
			pstmt.setString(1, number);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
	
			
				Guitars guitar = new Guitars(number, rs.getDouble("price"), 
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
	@Override
	public int delGuitar(String number) {
		Connection Conn = (Connection) DBUtil.open();
		String sql = "delete from guitar where number = ?";
		try {
			PreparedStatement pstmt = ((java.sql.Connection) Conn).prepareStatement(sql);
			pstmt.setString(1, number);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(Conn);
		}
		return 0;
	}

}
