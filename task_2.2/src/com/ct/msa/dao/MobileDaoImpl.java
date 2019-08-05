package com.ct.msa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ct.msa.model.Mobile;

public class MobileDaoImpl implements IMobileDAO {
	


	@Override
	public Mobile addMobile(Mobile m) throws MobileException {
		// TODO Auto-generated method stub
		
		Mobile  mo = new Mobile(); 
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			String qry="INSERT INTO `Mobile` (`mid`, `name`, `description`, `price`) VALUES (?, ?, ?, ?);";
			
			PreparedStatement st=con.prepareStatement(qry);//qry is compiled
			//st.setInt(1,mo.setId(mid););
			//ResultSet rs=st.execute();
			st.setInt(1,m.getId());
			st.setString(2,m.getName());
			st.setString(3,m.getDescription());
			st.setFloat(4,m.getPrice());
			
			st.executeUpdate();
			
		 
		 } catch (SQLException s) 
		{
			throw new MobileException("invalid inputs " +s.getMessage());
		}  

		//DriverManager.getConnection(arg, arg1, arg2)
		// TODO Auto-generated method stub
		return m;

		
		
		
	}

	@Override
	public void deleteMobile(int mId) throws MobileException {
		// TODO Auto-generated method stub

		Mobile  m = new Mobile(); 
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			
			String qry="delete FROM mobile WHERE mid = ?";
			
			PreparedStatement st=con.prepareStatement(qry);//qry is compiled
			st.setInt(1,mId);
            st.executeUpdate();
		
		 
		 } catch (SQLException s) 
		{
			throw new MobileException("connection not established" +s.getMessage());
		}  

		
	}
	
	
	
	

	

	@Override
	public Mobile searchMobileById(int mId) throws MobileException {
		// TODO Auto-generated method stub
		
		
				Mobile  m = new Mobile(); 
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
					String qry="SELECT * FROM mobile WHERE mid=?";
					
					PreparedStatement st=con.prepareStatement(qry);//qry is compiled
					st.setInt(1,mId);
					
					ResultSet rs=st.executeQuery();
					
					if(rs.next())
					{
						m.setId(rs.getInt(1));
						m.setName(rs.getString(2));
						m.setDescription(rs.getString(3));
						m.setPrice(rs.getFloat(4));


					}
				
				 
				 } catch (SQLException s) 
				{
					throw new MobileException("connection not established" +s.getMessage());
				}  

				
				return m;
			}

	@Override
	public Collection display() throws MobileException {
		// TODO Auto-generated method stub
		  Map<Integer, Mobile > map1 = new HashMap<>();
		Mobile  m2 = new Mobile(); 
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
			String qry="SELECT * FROM mobile";
			
			PreparedStatement st=con.prepareStatement(qry);//qry is compiled
			
			System.out.println(qry);
			ResultSet rs=st.executeQuery();
			
			if(rs.next())
			{
				do
				{
				m2.setId(rs.getInt(1));
				m2.setName(rs.getString(2));
				m2.setDescription(rs.getString(3));
				m2.setPrice(rs.getFloat(4));
				map1.put(rs.getInt(1), m2);
				}
				while(rs.next());
			}
			else
			{
				throw new MobileException("no data available");
			}
			
		 
		 
		 } catch (SQLException s) 
		{
			throw new MobileException("connection not established" +s.getMessage());
		}  

		
		return map1.values();
		
		
		
		
		
		
	
	}



		
	}


