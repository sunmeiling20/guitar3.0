package dao;



public class dataAccess {
	private static String db = "sqlite";

	public static Iguitar createGuitarDao() {
		Iguitar result = null;
		switch (db) {
		case "sqlite":
			result = new sqliteDao.InstrumentImpl();
			break;
		case "mysql":
			result = new mysqlDao.InstrumentImpl();
			break;
		}
		return result;
	}
}