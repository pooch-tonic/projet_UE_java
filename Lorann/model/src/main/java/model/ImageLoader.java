package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;

import javax.imageio.ImageIO;

import enums.TypeEnum;
import model.dao.QueryDAO;

public class ImageLoader {
	private BufferedImage image;
	private QueryDAO query;
	private TypeEnum type;
	
	public ResultSet getImageBypath(TypeEnum type) {
		this.type = type;
		
		try {
			this.image = ImageIO.read(new File(query.getSpritePath(type)));
		} catch (Exception e) {
			
		}
		
		return null;
	}

	
	
	
	


	/**
	 * Gets the query
	 * 
	 * @return the query
	 */
	public QueryDAO getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(QueryDAO query) {
		this.query = query;
	}









	/**
	 * Gets the image
	 * 
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}







	/**
	 * @param image the image to set
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}







	/**
	 * Gets the type
	 * 
	 * @return the type
	 */
	public TypeEnum getType() {
		return type;
	}







	/**
	 * @param type the type to set
	 */
	public void setType(TypeEnum type) {
		this.type = type;
	}
	
}
