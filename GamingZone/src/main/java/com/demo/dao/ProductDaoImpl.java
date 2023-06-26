package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	private static Connection conn;
	private static PreparedStatement psgetProds;
	static {
		conn=DBUtil.getMyConnection();
		try {
			psgetProds= conn.prepareStatement("select * from Product1");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public List<Product> getAllProducts() {
		List<Product> plist=new ArrayList<>();
		try {
			
			ResultSet rs=psgetProds.executeQuery();
			while(rs.next()) {
				//(int pid,int catId, String pname,. String shortDisc, String imgurl, int qty, float price) {
				plist.add(new Product(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getFloat(7)));
				
			}
			return plist;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
