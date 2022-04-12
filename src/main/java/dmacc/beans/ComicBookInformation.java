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
public class ComicBookInformation {
	@Id
	@GeneratedValue
	private long id;
	private String publisher;
	private String seriesTitle;
	private int issueNum;
	private String author;
	private String illustrator;
	private int yearPub;
	
	@Autowired
	private ComicList comicList;
	

	
	/**
	 * @return the comicInformation
	 */
	public ComicList getComicList() {
		return comicList;
	}

	/**
	 * @param comicInformation the comicInformation to set
	 */
	public void setComicList(ComicList comicList) {
		this.comicList = comicList;
	}

}
