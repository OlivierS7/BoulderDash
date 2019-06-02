package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Map;

/**
 * @author Olivier
 *
 */
class DAOMap extends DAOEntity<Map> {

	/**
	 * @param connection
	 * @throws SQLException
	 */
	public DAOMap(final Connection connection) throws SQLException {
		super(connection);
	}

	public Map find(final String code) {
		Map map = new Map();
		try {
			final String sql = "{call levelById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, code);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				map = new Map(Integer.parseInt(code), resultSet.getString("content"));
			}
			return map;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
