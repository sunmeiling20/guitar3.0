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
 * ʹ��Sqlite���ݿ��ʵ����
 * ʵ��IGuitarDao
 * @author lzm
 *
 */
public class InstrumentImpl implements Iguitar{
	/**
	 * ����һ���µ�Guitar
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
	 * ��ѯGuitar��Ϣ
	 * @return һ��List�б�������ݿ��е�����Guitar
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
	 * ɾ�����ݿ��ж�Ӧ��Guirtar��ͨ��serialNunmberɾ��
	 * @param serialNumber ���к�
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