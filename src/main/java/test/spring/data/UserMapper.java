package test.spring.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		User user = new User(rs.getInt("id"), 
							 rs.getString("username"), 
							 rs.getString("realname"), 
							 rs.getString("address"), 
							 rs.getBoolean("carlicensestatus"), 
							 rs.getBoolean("motorcyclelicensestatus"), 
							 rs.getString("employment"));
		return user;
	}

}
