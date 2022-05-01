package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Apr 16, 2022
 */
@Data
@Entity
public class UserInformation {
	
	@Id
	@GeneratedValue
	

	private long id;
	private String userName;
	private String fName;
	private String lName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNum;
	

}
