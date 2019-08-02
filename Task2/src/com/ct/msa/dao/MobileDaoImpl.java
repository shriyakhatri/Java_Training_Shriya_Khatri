package com.ct.msa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.ct.msa.model.Mobile;

public class MobileDaoImpl implements IMobileDAO {
	
	@Override
	public Map<Integer, Mobile> display() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMobile(Mobile m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMobile(int mId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMobileDetails(int mId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mobile searchMobileById(int mId) throws MobileException {
		// TODO Auto-generated method stub
		
		
				Mobile  m = new Mobile(); 
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
					String qry="SELECT * FROM Mobile WHERE mid=?";
					//System.out.println(qry);
					//Statement st= con.createStatement();
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
					//System.out.println(rs.getString(3));
				 
				 
				 } catch (SQLException s) 
				{
					throw new MobileException("connection not established" +s.getMessage());
				}  

				//DriverManager.getConnection(arg, arg1, arg2)
				// TODO Auto-generated method stub
				return m;
			}



		
	}


