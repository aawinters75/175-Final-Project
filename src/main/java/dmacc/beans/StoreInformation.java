package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Apr 11, 2022
 */
@Data
@Entity
public class StoreInformation {
	@Id
	@GeneratedValue
	

	private long id;
	private String storeName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNum;
	

	
}
