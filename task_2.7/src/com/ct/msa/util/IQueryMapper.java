package com.ct.msa.util;

public interface IQueryMapper {

	public static final String RETRIEVAL_BY_ID="SELECT * FROM mobile WHERE mid=?";
	public static final String INSERT="INSERT INTO `Mobile` (`mid`, `name`, `description`, `price`) VALUES (?, ?, ?, ?)";
	public static final String DELETE_BY_ID="delete FROM mobile WHERE mid = ?";
	public static final String SELECT_ALL="SELECT * FROM mobile";
	
}
	

