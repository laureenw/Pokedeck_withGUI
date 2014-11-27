/**
 * @author Laureen Walther
 * @package pokedeckgraphic
 */
package pokedeckgraphic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JMenu;

/**
 * class Pokedeck : responsible for processing the data
 * private static : related to the class, visible only by the class
 * Random random : used for a random drawing
 * Player p : contains the current player
 * ArrayList<Card> : cards tab
 * int numCard : initializing card number to zero
 * String nameCard : initializing card name to blank
 * Card myCard : related to the card added
 * Object cardDelete : related to the card removed
 * Object cardUpdate : related to the card updated
 * int numCardSearch : related to the number of card sought
 * String nameCardSearch : related to the name of card sought
 */
public class Pokedeck {

	private static Random random = new Random();
	private static Player p;
	private static ArrayList<Card> collectCard = new ArrayList<Card>();
	private static int numCard = 0;
	private static String nameCard = "";
	private static Card myCard;
	private static Object cardDelete;
	private static Object cardUpdate;
	private static int numCardSearch;
	private static String nameCardSearch;
	private static String pokemon_type = "";
	private static String pokemon_type_search;
	private static String pokemon_image;

	public Pokedeck() {
		
	}
	
	public static void setP(Player p) {
		Pokedeck.p = p;
	}
	
	public static ArrayList<Card> getCollectCard() {
		return collectCard;
	}
	
	public static void setCollectCard(ArrayList<Card> collectCard) {
		Pokedeck.collectCard = collectCard;
	}
	
	public static void setNumCard(int numCard) {
		Pokedeck.numCard = numCard;
	}
	
	public static void setNameCard(String nameCard, String pokemon_type, String pokemon_image) {
		Pokedeck.nameCard = nameCard;
		Pokedeck.pokemon_type = pokemon_type;
		Pokedeck.pokemon_image = pokemon_image;
	}
	
	public static Card getMyCard() {
		return myCard;
	}
	
	public static Object getCardDelete() {
		return cardDelete;
	}
	
	public static Object getCardUpdate() {
		return cardUpdate;
	}
	
	public static void setNumCardSearch(int numCardSearch) {
		Pokedeck.numCardSearch = numCardSearch;
	}
	
	public static void setNameCardSearch(String nameCardSearch) {
		Pokedeck.nameCardSearch = nameCardSearch;
	}
	
	public void setPokemonTypeSearch(String pokemon_type_search) {
		Pokedeck.pokemon_type_search = pokemon_type_search;
	}
	
	/**
	 * FileOutputStream file : creates a file output stream to write
	 * ObjectOutputStream : open stream on file
	 * writeObject() : object serialization
	 * flush() : empty the writing buffers
	 * close() : close stream
	 */
	public static void writeCollectCardInFile() {
		try {
			FileOutputStream file = new FileOutputStream(p.getName()+".txt");
			ObjectOutputStream oos = new ObjectOutputStream(file);
			oos.writeObject(collectCard);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * FileInputSTream file : creates a file input stream to read
	 * ObjectInputStream : open stream on file
	 * readObject() : object deserialization
	 */
	public static void readCollectCardInFile() {
		try {
			FileInputStream file = new FileInputStream(p.getName()+".txt");
			ObjectInputStream ois = new ObjectInputStream(file);
			collectCard = (ArrayList<Card>) ois.readObject();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * AddCard() : add new card description
	 * test : as the collection contains card name selected by user, program asks card name
	 * generates a random number card
	 * Add new card on the collectCard
	 * display collectCard
	 */
	public static void addCard() {		
		numCard = 1 + random.nextInt(1000 - 0);
		collectCard.add(new Card(nameCard, numCard, pokemon_type, pokemon_image));
		for (int i = 0; i < collectCard.size(); i++) {
			myCard = collectCard.get(i);
		}
	}
	
	/**
	 * RemoveCard() : delete card
	 * request the number card to remove
	 * remove corresponding card on the collectCard
	 */
	public static void removeCard() {
		
		for (int i = 0; i < collectCard.size(); i++) {
			if (collectCard.get(i).toString().contains(Integer.toString(numCard))) {
				cardDelete = collectCard.remove(i);
			}			
		}
	}
	
	/**
	 * ModifyCard() : update card
	 * request the number card to update
	 * request the new name card
	 * replace corresponding card with new card name
	 */
	public static void modifyCard() {
		for (int i = 0; i < collectCard.size(); i++) {
			if (collectCard.get(i).toString().contains(Integer.toString(numCard))) {
				cardUpdate = collectCard.set(i, new Card(nameCard, numCard, pokemon_type, pokemon_image));
			}
		}
	}
	
	/**
	 * SearchCard() : search card
	 * request the number card to search
	 * request the name card to search
	 * if collectCard contains number card and name card : display corresponding card
	 * @return 
	 */
	public static boolean searchCard() {
		if (collectCard.toString().contains(new Card(nameCardSearch, numCardSearch, pokemon_type_search, pokemon_image).toString())) {
			return true;
		} else {
			return false;
		}
	}
}
