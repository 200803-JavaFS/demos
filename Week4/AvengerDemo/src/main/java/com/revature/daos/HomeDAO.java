package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class HomeDAO implements IHomeDAO {

	@Override
	public List<Home> findAll() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM homes;";
			
			Statement statement = conn.createStatement();
			
			List<Home> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Home h = new Home();
				h.setStreetAddr(result.getString("hb_st_addr"));
				h.setHomeBase(result.getString("home_base"));
				h.setCity(result.getString("hb_city"));
				h.setState(result.getString("hb_state"));
				h.setZip(result.getString("hb_zip"));
				list.add(h); 
			}
			
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Home findByName(String name) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM homes WHERE home_base = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				Home h = new Home();
				h.setHomeBase(result.getString("home_base"));
				h.setStreetAddr(result.getString("hb_st_addr"));
				h.setCity(result.getString("hb_city"));
				h.setState(result.getString("hb_state"));
				h.setZip(result.getString("hb_zip"));
				return h;
			} else {
				//good place to log a failed query.
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addHome(Home h) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO homes (home_base, hb_st_addr, hb_city, hb_state, hb_zip)"
					+ "VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, h.getHomeBase());
			statement.setString(++index, h.getStreetAddr());
			statement.setString(++index, h.getCity());
			statement.setString(++index, h.getState());
			statement.setString(++index, h.getZip());
			
			statement.execute();
			return true; 
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
