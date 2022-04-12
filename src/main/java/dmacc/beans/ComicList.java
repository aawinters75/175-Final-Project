package dmacc.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Apr 11, 2022
 */
@Data
@Embeddable
public class ComicList {
	
	@OneToMany (cascade=CascadeType.PERSIST)
	private List <ComicBookInformation> listOfComics;
	
	
	


}
