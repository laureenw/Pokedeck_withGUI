/**
 * @author Laureen Walther
 * @package pokedeckgraphic
 */
package pokedeckgraphic;

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
	
	public Card(String name, int num) {
		this.num = num;
		this.name = name;
	}
	
	/** 
	 * display card
	 */
	public void Show() {
		System.out.print("Nom de la carte : "+this.name);
	}
	
	public String toString(){
    	String S = this.num+" "+this.name;
    	return S;
    }
}
