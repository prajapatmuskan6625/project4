package com.rays.pro4.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.pro4.Bean.WishBean;
import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Util.DataUtility;
import com.rays.pro4.Util.JDBCDataSource;


public class WishModel {

	public int nextPK() throws Exception {

		
		Connection conn = null;
		int pk = 0;

		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_WISH");
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		rs.close();
		return pk + 1;
	}

	public long add(WishBean bean) throws Exception {

		String sql = ("INSERT INTO ST_WISH VALUES(?,?,?,?,?)");

		Connection conn = null;
		int pk = 0;

		conn = JDBCDataSource.getConnection();
		pk = nextPK();

		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setLong(1, pk);
		pstmt.setString(2, bean.getProduct());
		pstmt.setDate(3, new Date(bean.getDate().getTime()));
		pstmt.setString(4, bean.getUserName());
		pstmt.setString(5, bean.getRemark());


		int a = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();

		return pk;

	}

	public void delete(WishBean bean) throws ApplicationException {
		String sql = ("DELETE FROM ST_WISH WHERE ID=?");
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				throw new ApplicationException("Exception: Delete rollback Exception" + e2.getMessage());
			}
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public WishBean findByPK(long pk) throws Exception {
		WishBean bean = null;

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ST_WISH WHERE ID=?");
		pstmt.setLong(1, pk);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new WishBean();

			bean.setId(rs.getLong(1));
			bean.setProduct(rs.getString(2));

			bean.setDate(rs.getDate(3));
			bean.setUserName(rs.getString(4));
			bean.setRemark(rs.getString(5));

		}

		return bean;

	}

	public void update(WishBean bean) throws Exception {
		String sql = ("UPDATE ST_WISH SET PRODUCT =?, DATE =?, USER_NAME =?, REMARK =?  WHERE ID =?");
		Connection conn = null;

		conn = JDBCDataSource.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bean.getProduct());
		pstmt.setDate(2, new Date(bean.getDate().getTime()));
		pstmt.setString(3, bean.getUserName());
		pstmt.setString(4, bean.getRemark());

		pstmt.setLong(5, bean.getId());

		pstmt.executeUpdate();
		conn.commit();
		pstmt.close();

		conn.rollback();

	}
	

	public List search(WishBean bean, int pageNo, int pageSize) throws ApplicationException {
		
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_WISH WHERE 1=1");
		
		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" AND ID  = '" + bean.getId());
			}
			if (bean.getProduct() != null && bean.getProduct().length() > 0) {
				sql.append(" AND PRODUCT like '" + bean.getProduct() + "%'");
			}
			if (bean.getDate() != null && bean.getDate().getTime() > 0) {
				Date d = new java.sql.Date(bean.getDate().getTime());
				sql.append(" AND DATE like '"+d+"%'");
			}
			
			if (bean.getUserName() != null && bean.getUserName().length() > 0) {
				sql.append(" AND USER_NAME like '" + bean.getUserName() + "%'");
			}
			if (bean.getRemark() != null && bean.getRemark().length() > 0) {
				sql.append(" AND REMARK like '" + bean.getRemark() + "%'");
			}
			

		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;

			sql.append(" Limit " + pageNo + " , " + pageSize);
		}
		List list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new WishBean();
				bean.setId(rs.getLong(1));
				bean.setProduct(rs.getString(2));
				bean.setDate(rs.getDate(3));
				bean.setUserName(rs.getString(4));
				bean.setRemark(rs.getString(5));

				list.add(bean);

			}
			rs.close();
		} catch (Exception e) {
			throw new ApplicationException("Exception: Exception in Search User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;

	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from ST_WISH");

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}
System.out.println(sql);
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				WishBean bean = new WishBean();
				bean.setId(rs.getLong(1));
				bean.setProduct(rs.getString(2));
				bean.setDate(rs.getDate(3));
				bean.setUserName(rs.getString(4));
				bean.setRemark(rs.getString(5));

				list.add(bean);

			}
			rs.close();
		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in getting list of users");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return list;
	}

}
