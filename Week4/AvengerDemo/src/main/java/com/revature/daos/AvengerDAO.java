package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Avenger;
import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class AvengerDAO implements IAvengerDAO {

	private IHomeDAO hDao = new HomeDAO();

	@Override
	public List<Avenger> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM avengers;";

			Statement statement = conn.createStatement();

			List<Avenger> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Avenger a = new Avenger(result.getInt("superhero_id"), result.getString("superhero_name"),
						result.getString("superhero_power"), result.getString("first_name"),
						result.getString("last_name"), result.getInt("power_level"), null);
				if (result.getString("home_base_fk") != null) {
					a.setHomeBase(hDao.findByName(result.getString("home_base_fk")));
				}
				list.add(a);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Avenger findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM avengers WHERE superhero_id =" + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				Avenger a = new Avenger(result.getInt("superhero_id"), result.getString("superhero_name"),
						result.getString("superhero_power"), result.getString("first_name"),
						result.getString("last_name"), result.getInt("power_level"), null);
				if (result.getString("home_base_fk") != null) {
					a.setHomeBase(hDao.findByName(result.getString("home_base_fk")));
				}
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAvenger(Avenger a) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, power_level, home_base_fk)"
					+ "VALUES (?, ?, ?, ?, ?, ?);";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, a.getSupName());
			statement.setString(++index, a.getSupPower());
			statement.setString(++index, a.getFirstName());
			statement.setString(++index, a.getLastName());
			statement.setInt(++index, a.getPowerLevel());
			if(a.getHomeBase()!=null) {
				Home h = a.getHomeBase();
				statement.setString(++index, h.getHomeBase());
			}else {
				statement.setString(++index, null);
			}

			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateAvenger(Avenger a) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE avengers SET superhero_name = ?, superhero_power = ?, first_name= ?, "
					+ "last_name = ?, power_level = ?, home_base_fk = ? WHERE superhero_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, a.getSupName());
			statement.setString(++index, a.getSupPower());
			statement.setString(++index, a.getFirstName());
			statement.setString(++index, a.getLastName());
			statement.setInt(++index, a.getPowerLevel());
			if(a.getHomeBase()!=null) {
				Home h = a.getHomeBase();
				statement.setString(++index, h.getHomeBase());
			}else {
				statement.setString(++index, null);
			}
			statement.setInt(++index, a.getSupId());
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteAvenger(int supId) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM avengers WHERE superhero_id =" + supId + ";";

			Statement statement = conn.createStatement();

			statement.execute(sql);
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addAvengerWithHome(Avenger a) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "BEGIN; "
					+ "INSERT INTO homes (home_base, hb_st_addr, hb_city, hb_state, hb_zip)"
					+ "VALUES (?, ?, ?, ?, ?);"
					+ "INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, power_level, home_base_fk)"
					+ "VALUES (?, ?, ?, ?, ?, ?);"
					+ "COMMIT;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			Home h = a.getHomeBase();
			
			int index = 0;
			statement.setString(++index, h.getHomeBase());
			statement.setString(++index, h.getStreetAddr());
			statement.setString(++index, h.getCity());
			statement.setString(++index, h.getState());
			statement.setString(++index, h.getZip());
			statement.setString(++index, a.getSupName());
			statement.setString(++index, a.getSupPower());
			statement.setString(++index, a.getFirstName());
			statement.setString(++index, a.getLastName());
			statement.setInt(++index, a.getPowerLevel());
			statement.setString(++index, h.getHomeBase());
			
			statement.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
