package com.ct.msa.dao;

import com.ct.msa.util.DbUtil;
import com.ct.msa.util.IQueryMapper;

import java.sql.Connection;
import java.io.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;

import com.ct.msa.model.Mobile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileDaoImpl implements IMobileDAO {
	Connection connection = null;
	static Logger log = Logger.getLogger(MobileDaoImpl.class);

	@Override
	public Mobile addMobile(Mobile m) throws MobileException {

		Mobile mo = new Mobile();
		try {
			connection = DbUtil.getDBConnection();
			log.info("db is connected successfully " + connection);

			PreparedStatement st = connection.prepareStatement(IQueryMapper.INSERT);
			log.info("qry is compiled and ready for placing values");

			st.setInt(1, m.getId());
			st.setString(2, m.getName());
			st.setString(3, m.getDescription());
			st.setFloat(4, m.getPrice());
			log.info("placing values");

			st.executeUpdate();

		} catch (SQLException s) {
			log.fatal("db is not connected ");

			throw new MobileException("invalid inputs " + s.getMessage());
		} catch (InputMismatchException s) {
			log.fatal("error occured : there is some issues with the input ");

			throw new MobileException("invalid inputs " + s.getMessage());
		}

		return m;

	}

	@Override
	public void deleteMobile(int mId) throws MobileException {

		Mobile m = new Mobile();
		try {
			connection = DbUtil.getDBConnection();
			log.info("db is connected successfully " + connection);

			PreparedStatement st = connection.prepareStatement(IQueryMapper.DELETE_BY_ID);
			log.info("qry is compiled and ready for deleting values");

			st.setInt(1, mId);
			st.executeUpdate();

		} catch (SQLException s) {
			log.fatal("error occured : id doesnt exist in database ");

			throw new MobileException("cannot be deleted .Please contact database administrator" + s.getMessage());
		}

	}

	public Mobile searchMobileById(int mId) throws MobileException, SQLException {

		Mobile m = new Mobile();

		try {
			connection = DbUtil.getDBConnection();
			log.info("db is connected successfully " + connection);

			PreparedStatement st = connection.prepareStatement(IQueryMapper.RETRIEVAL_BY_ID);
			log.info("qry is compiled and ready for placing values");

			st.setInt(1, mId);
			System.out.println("" + mId);
			ResultSet rs = st.executeQuery();
			log.info("qry is executed and results has to be iterated");

			if (rs.next()) {
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setDescription(rs.getString(3));
				m.setPrice(rs.getFloat(4));

			} else {
				log.fatal("error occured : employee info not found with id :: " + mId);

				throw new MobileException("Entered mobile id is not valid");

			}

		} catch (SQLException s) {
			log.fatal("database not connected ");

		}

		return m;
	}

	@Override
	public Collection display() throws MobileException {
		// TODO Auto-generated method stub
		Map<Integer, Mobile> map1 = new HashMap<>();

		try {
			connection = DbUtil.getDBConnection();
			log.info("db is connected successfully " + connection);

			PreparedStatement st = connection.prepareStatement(IQueryMapper.SELECT_ALL);

			log.info("qry is executed and results has to be iterated");

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				do {
					Mobile m2 = new Mobile();
					m2.setId(rs.getInt(1));
					m2.setName(rs.getString(2));
					m2.setDescription(rs.getString(3));
					m2.setPrice(rs.getFloat(4));
					map1.put(rs.getInt(1), m2);
				} while (rs.next());
			} else {
				log.info("no data available ");

				throw new MobileException("no data available");
			}

		} catch (SQLException s) {
			log.fatal("database not connected ");

			throw new MobileException("Some error has occured .Please contact database administator" + s.getMessage());
		}

		return map1.values();

	}

	@Override
	public boolean check_user(String username, String password, int choice) {
		Properties p = new Properties();
		boolean result = false;
		if (choice == 1) {
			try {
				FileInputStream fis = new FileInputStream("admin.properties");
				log.info("admin file is being read");

				try {
					p.load(fis);
					log.info("file is being loaded");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.fatal("Some issue has occured while loading");

				}
				if (p.containsKey(username)) {
					log.debug("username and password is getting verified for admin");
					if (password.equals(p.get(username))) {
						result = true;
					} else {
						result = false;
					}

				}
			} catch (FileNotFoundException e) {

				log.fatal("file not found");

			}
		}

		else {

			try {
				FileInputStream fis = new FileInputStream("customer.properties");
				log.info("customer file is being read");

				try {
					p.load(fis);
				} catch (IOException e) {
					log.fatal("Some issue has occured while loading");

					e.getMessage();
				}
				if (p.containsKey(username)) {
					log.debug("username and password is getting verified for customer");

					if (password.equals(p.get(username))) {
						result = true;
					} else {
						result = false;
					}

				} else {
					result = false;

				}
			}

			catch (FileNotFoundException e) {
				log.fatal("file not found");

			}
		}

		return result;

	}

}
