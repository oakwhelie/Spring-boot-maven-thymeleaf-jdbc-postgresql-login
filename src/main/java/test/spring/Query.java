package test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import test.spring.data.User;
import test.spring.data.UserMapper;

@Repository
public class Query 
{
	@Autowired
    private JdbcTemplate jdbcTemplate;

	//user
	public User getUser(String username, String password)//login (read/select)
	{
		String sql = "SELECT id, username, realname, address, carlicensestatus, motorcyclelicensestatus, employment "
				+ "FROM public.user WHERE username = '%s' AND password = crypt('%s', password)";
		String query = String.format(sql, username, password);
        return jdbcTemplate.queryForObject(query, new UserMapper());
	}
	public void newUser(String username, String password)//register (create)
	{
		String sql = "INSERT INTO public.user(username, password) VALUES('%s', crypt('%s', gen_salt('bf')))";
		String query = String.format(sql, username, password);
		 int rows = jdbcTemplate.update(query);
	        if (rows > 0) {
	            System.out.println("A new row has been inserted.");
	        }
	}
	public void deleteUser(String username)
	{
		String sql = "DELETE FROM public.user WHERE username = '%s'";
		String query = String.format(sql, username);
		 int rows = jdbcTemplate.update(query);
	        if (rows > 0) {
	            System.out.println("A new row has been inserted.");
	        }
	}
	
	public void updateUserData(	String realname,
								String address,
								boolean carlicensestatus,
								boolean motorcyclelicensestatus,
								String employment,
								String username)
	{
		String sql = "UPDATE public.user SET realname='%s',"
										+ "address='%s',"
										+ "carlicensestatus='%s',"
										+ "motorcyclelicensestatus='%s',"
										+ "employment='%s' WHERE username='%s';";
		String query = String.format(sql, realname, address, carlicensestatus, motorcyclelicensestatus,employment,username);
		int rows = jdbcTemplate.update(query);
		if (rows > 0) 
		{
			System.out.println("A new row has been inserted.");
		}
	}
}