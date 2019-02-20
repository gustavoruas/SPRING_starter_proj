package oracle.starterSPRING.hr.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity(name = "User")
@Table(name="USERS")

//Mapping JPA native query and using in repository
//Oracle DB must list all columns from table
//https://stackoverflow.com/questions/12861187/hibernate-native-query-invalid-column-name-error-sql-17006/18377446
//https://stackoverflow.com/questions/13012584/jpa-how-to-convert-a-native-query-result-set-to-pojo-class-collection
//https://howtodoinjava.com/jpa/jpa-native-query-example-select/
@NamedNativeQueries({
	@NamedNativeQuery(
			name = "queries.userReturnPassword",
			query = 
				"SELECT USER_ID, USER_NAME, utl_raw.cast_to_varchar2(PASSWORD) password, " +
				"DATA_UPDATED, LAST_DATE_LOGIN, CREATED_BY " +
				"FROM USERS " +
				"WHERE USER_NAME = ? ",
			resultClass = User.class
			)
})


public class User {
	
	@Id
	@Column(name="user_id")
	private String id;
   
	@Column(name="USER_NAME")
	private String username;
	
	@Column(name="password")
	private String password;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
