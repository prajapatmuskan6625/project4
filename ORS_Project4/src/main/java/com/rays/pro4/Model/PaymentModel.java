package com.rays.pro4.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.pro4.Bean.PaymentBean;
import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Exception.DatabaseException;
import com.rays.pro4.Exception.DuplicateRecordException;
import com.rays.pro4.Util.JDBCDataSource;

public class PaymentModel {
	
public int nextPK() throws DatabaseException {

		

		String sql = "SELECT MAX(ID) FROM ST_PAYMENT";
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {

			throw new DatabaseException("Exception : Exception in getting PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1;

	}


	public long add(PaymentBean bean) throws Exception {
		
		String sql = "INSERT INTO ST_PAYMENT VALUES(?,?,?,?,?)";

		Connection conn = null;
		int pk = 0;

          conn = JDBCDataSource.getConnection();
			pk = nextPK();

			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getPaymentType());
			pstmt.setString(3, bean.getAmount());
			pstmt.setString(4, bean.getCustomerName());
			pstmt.setString(5, bean.getMessage());
			
			
			

			int a = pstmt.executeUpdate();
			System.out.println(a);
			conn.commit();
			pstmt.close();

	
		return pk;

	}

	public void delete(PaymentBean bean) throws Exception {
		
		String sql = "DELETE FROM ST_PAYMENT WHERE ID=?";
		Connection conn = null;
		
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
			
	}


	

	public PaymentBean findByPK(long pk) throws Exception {
		
		String sql = "SELECT * FROM ST_PAYMENT WHERE ID=?";
		PaymentBean bean = null;
		Connection conn = null;
		
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new PaymentBean();
				bean.setId(rs.getLong(1));
				bean.setPaymentType(rs.getString(2));
				bean.setAmount(rs.getString(3));
				bean.setCustomerName(rs.getString(4));
				bean.setMessage(rs.getString(5));
				
			}
			rs.close();
		
		return bean;
	}
	
	public void update(PaymentBean bean) throws ApplicationException, DuplicateRecordException, Exception {
		
		String sql = "UPDATE ST_PAYMENT SET PAYMENT_TYPE=?,AMOUNT=?,CUSTOMER_NAME=?,MESSAGE=? WHERE ID=?";
		Connection conn = null;
		
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getPaymentType());
			pstmt.setString(2, bean.getAmount());
			pstmt.setString(3, bean.getCustomerName());
			pstmt.setString(4, bean.getMessage());
			pstmt.setLong(5, bean.getId());
			
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		}
	public List list(int pageNo, int pageSize) throws ApplicationException {
		
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_PAYMENT");

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				PaymentBean bean = new PaymentBean();
				bean.setId(rs.getLong(1));
				bean.setPaymentType(rs.getString(2));
				bean.setAmount(rs.getString(3));
				bean.setCustomerName(rs.getString(4));
				bean.setMessage(rs.getString(5));
				
				
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
	
	public List search(PaymentBean bean) throws Exception {
		return search(bean, 0, 0);
	}

	public List search(PaymentBean bean, int pageNo, int pageSize) throws ApplicationException, Exception {
		
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_PAYMENT WHERE 1=1");
		
		if (bean != null) {
			if (bean.getPaymentType() != null && bean.getPaymentType().length() > 0) {
				sql.append(" AND PAYMENT_TYPE like '" + bean.getPaymentType() + "%'");
			}
			if (bean.getAmount() != null && bean.getAmount().length() > 0)  {
				sql.append(" AND AMOUNT like '" + bean.getAmount() + "%'");
			}
			
		
			/*
			 * if (bean.getDob() != null && bean.getDob().getTime() > 0) { Date d = new
			 * Date(bean.getDob().getTime()); sql.append("AND DOB = '" +
			 * DataUtility.getDateString(d) + "'"); }
			 */
		
		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * pageSize;

			sql.append(" Limit " + pageNo + ", " + pageSize);
			// sql.append(" limit " + pageNo + "," + pageSize);
		}

		System.out.println(sql);
		List list = new ArrayList();
		Connection conn = null;
		
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new PaymentBean();
				bean.setId(rs.getLong(1));
				bean.setPaymentType(rs.getString(2));
				bean.setAmount(rs.getString(3));
				bean.setCustomerName(rs.getString(4));
				bean.setMessage(rs.getString(5));
				
				
				list.add(bean);

			}
			rs.close();
			return list;
	}
		return null;
		
	
}
}

