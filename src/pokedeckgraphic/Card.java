/**
 * @author Laureen Walther
 * @package pokedeckgraphic
 */
package pokedeckgraphic;

import java.awt.Image;
import java.io.File;
import java.io.Serializable;
/**
 * Serialization of the object to convert byte array to write on text file
 * Contains constructor to create card
 * Attributes : num (int), name (String)
 * Methods :
 * Show() : to display card
 * toString() : returns a string used to describe the object
 */
public class Card implements Serializable{

	private int num;
	private String name;
	private String pokemon_type;
	private String pokemon_image;
	
	public Card(String name, int num, String pokemon_type, String pokemon_image) {
		this.num = num;
		this.name = name;
		this.pokemon_type = pokemon_type;
		this.pokemon_image = pokemon_image;
	}
	
	/** 
	 * display card
	 */
	public void Show() {
		System.out.print("Nom de la carte : "+this.name);
	}
	
	public String toString(){
    	String S = this.num+" "+this.name+" "+this.pokemon_type+" "+this.pokemon_image;
    	return S;
    }
}
