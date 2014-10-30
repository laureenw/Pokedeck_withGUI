/**
 * @author Laureen Walther
 * @package pokedeckgraphic
 */
package pokedeckgraphic;

/**
 * Enum type : UserChoice
 * Data structure that encapsulates six objects
 * List of named constants :
 * AddCard : Add new card,
 * RemoveCard : Delete card,
 * ModifyCard : Update card,
 * SeeCollection : See collection,
 * SearchCard : Search card,
 * SaveCollection : Save collection,
 * UploadCollection : Upload collection,
 * Stop : Exit game
 */
public enum UserChoice {
	AddCard ("Add new card"),
	RemoveCard ("Delete card"),
	ModifyCard ("Update card"),
	SeeCollection ("See collection"),
	SearchCard ("Search card"),
	SaveCollection ("Save collection"),
	UploadCollection ("Upload collection"),
	Stop ("Exit");
	
	private String name = "";
	
	UserChoice(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
