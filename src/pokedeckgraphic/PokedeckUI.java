/**
 * @author Laureen Walther
 * @package pokedeckgraphic
 */
package pokedeckgraphic;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * class PokedeckUI : contains GUI, what the user sees, menus and questions available to the user
 * Scanner : used to read keyboard input
 * Player p : contains the current player 
 * int numCard : initializing card number to zero
 * String nameCard : initializing card name to blank
 * int numCardSearch : number of card searched
 * Sring nameCardSearch : name of card searched
 * user_choice : related to the user choice
 */
public class PokedeckUI {
	Pokedeck pokedeck = new Pokedeck();
	Scanner scanner = new Scanner(System.in);
	Player p;
	int numCard = 0;
	String nameCard = "";
	int numCardSearch;
	String nameCardSearch;
	
	//window
	JFrame window;
	//menu
	JMenuBar menuBar;
	JMenu actions;
	JMenuItem addCard, removeCard, modifyCard, seeCollection, searchCard, saveCollection, uploadCollection, stop;
	//content
	JPanel principalPanel;
	JPanel addCardPanel;
	JPanel removeCardPanel;
	JPanel modifyCardPanel;
	JPanel seeCollectionPanel;
	JPanel searchCardPanel;
	JPanel saveCollectionPanel;
	JPanel uploadCollectionPanel;
	BorderLayout login;
	//elements principal panel
	JTextField username_field;
	JLabel username_label;
	JLabel file;
	JButton loginbutton;
	JPanel button_panel;
	JPanel file_panel;
	//elements addCard panel
	JTextField cardname_field;
	JLabel cardname_label;
	JLabel card;
	JButton addCardbutton;
	JPanel button_addcardpanel;
	JPanel card_addcardpanel;
	//elements removeCard panel
	JTextField removecard_field;
	JLabel removecard_label;
	JLabel carddelete;
	JButton removeCardbutton;
	JPanel button_removecardpanel;
	JPanel card_removecardpanel;
	//elements modifyCard panel
	JTextField modifycard_field;
	JLabel modifycard_label;
	JLabel cardmodify;
	JTextField modifycardname_field;
	JLabel modifycardname_label;
	JButton modifyCardbutton;
	JPanel button_modifycardpanel;
	JPanel card_modifycardpanel;
	//elements searchCard panel
	JTextField searchnumcard_field;
	JLabel searchnumcard_label;
	JTextField searchnamecard_field;
	JLabel searchnamecard_label;
	JLabel cardsearch;
	JButton searchCardbutton;
	JPanel button_searchcardpanel;
	JPanel card_searchcardpanel;
	//elements saveCollection panel
	JLabel savecollection;
	//element uploadCollection panel
	JLabel uploadcollection;
	//elements seeCollection panel
	JLabel collection;

	/**
	 * request the player name
	 * initializing a new player with name
	 * send the player name to class Pokedeck
	 * while stop different to false, display menu
	 */
	public void start() {
		/*boolean stop = false;
		System.out.println("Enter your name : ");
		String playerName = scanner.next();
		p = new Player(playerName);
		pokedeck.setP(p);
		while (!stop) {
			UserChoice choice = user_menu_choice();
			stop = pick_choice(choice);
		}*/
		window = new JFrame();
		principalPanel = new JPanel();
		login = new BorderLayout();
		
		window.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		actions = new JMenu("Actions");
		addCard = new JMenuItem(""+UserChoice.AddCard);
		removeCard = new JMenuItem(""+UserChoice.RemoveCard);
		modifyCard = new JMenuItem(""+UserChoice.ModifyCard);
		seeCollection = new JMenuItem(""+UserChoice.SeeCollection);
		searchCard = new JMenuItem(""+UserChoice.SearchCard);
		saveCollection = new JMenuItem(""+UserChoice.SaveCollection);
		uploadCollection = new JMenuItem(""+UserChoice.UploadCollection);
		stop = new JMenuItem(""+UserChoice.Stop);
		actions.add(addCard);
		actions.add(removeCard);
		actions.add(modifyCard);
		actions.add(seeCollection);
		actions.add(searchCard);
		actions.add(saveCollection);
		actions.add(uploadCollection);
		actions.add(stop);
		menuBar.add(actions);
		window.setJMenuBar(menuBar);
		 					
		//principal panel
		username_label = new JLabel("Enter your name");
		username_field = new JTextField(10);
		file = new JLabel("Your file : ");
		loginbutton = new JButton("Send");
		loginbutton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String playerName = username_field.getText();
				p = new Player(playerName);
				pokedeck.setP(p);
				file.setText("Your file : " + (username_field.getText() == null ? "" : p.getName()+".txt"));    
			}
		});
		
		principalPanel.add(username_label);
		principalPanel.add(username_field);
		button_panel = new JPanel(new FlowLayout());
		file_panel = new JPanel(new FlowLayout());
		button_panel.add(loginbutton);
		file_panel.add(file);
				
		window.getContentPane().add(principalPanel, BorderLayout.PAGE_START);
		window.getContentPane().add(file_panel, BorderLayout.CENTER);
		window.getContentPane().add(button_panel, BorderLayout.PAGE_END);
		
		//addCard panel
		addCard.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					cardname_label = new JLabel("Card name");
					cardname_field = new JTextField(10);
					card = new JLabel("Your card : ");
					addCardbutton = new JButton("Add");
					addCardbutton.addActionListener(new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							nameCard = cardname_field.getText();
							if (pokedeck.getCollectCard().toString().contains(nameCard)) {
								card.setText("Your collection already contains the name card, please enter again");
							} else {
								pokedeck.setNameCard(nameCard);
								pokedeck.addCard();
								card.setText("Your card : " + (cardname_field.getText() == null ? "" : pokedeck.getMyCard()));
								pokedeck.writeCollectCardInFile();	
							}
						}
					});
														
				addCardPanel = new JPanel();
				addCardPanel.add(cardname_label);
				addCardPanel.add(cardname_field);
				button_addcardpanel = new JPanel(new FlowLayout());
				card_addcardpanel = new JPanel(new FlowLayout());
				button_addcardpanel.add(addCardbutton);
				card_addcardpanel.add(card);
				
				window.getContentPane().removeAll();
				window.getContentPane().add(addCardPanel, BorderLayout.PAGE_START);
				window.getContentPane().add(card_addcardpanel, BorderLayout.CENTER);
				window.getContentPane().add(button_addcardpanel, BorderLayout.PAGE_END);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();
				
			}
		});
		
		//removeCard panel
		removeCard.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					removecard_label = new JLabel("Enter card number you want to delete");
					removecard_field = new JTextField(10);
					carddelete = new JLabel("Your card : ");
					removeCardbutton = new JButton("Delete");
					removeCardbutton.addActionListener(new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							numCard = Integer.parseInt(removecard_field.getText());
							pokedeck.setNumCard(numCard);
							pokedeck.removeCard();
							carddelete.setText("Your card : " + (removecard_field.getText() == null ? "" : pokedeck.getCardDelete() + " has been removed"));
							pokedeck.writeCollectCardInFile();	
						}
					});
									
				removeCardPanel = new JPanel();
				removeCardPanel.add(removecard_label);
				removeCardPanel.add(removecard_field);
				button_removecardpanel = new JPanel(new FlowLayout());
				card_removecardpanel = new JPanel(new FlowLayout());
				button_removecardpanel.add(removeCardbutton);
				card_removecardpanel.add(carddelete);
				
				window.getContentPane().removeAll();
				window.getContentPane().add(removeCardPanel, BorderLayout.PAGE_START);
				window.getContentPane().add(card_removecardpanel, BorderLayout.CENTER);
				window.getContentPane().add(button_removecardpanel, BorderLayout.PAGE_END);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();
				
			}
		});
		
		//modifyCard panel
		modifyCard.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					modifycard_label = new JLabel("Enter card number you want to update");
					modifycard_field = new JTextField(10);
					modifycardname_label = new JLabel("New card name : ");
					modifycardname_field = new JTextField(10);
					cardmodify = new JLabel("Your card : ");
					modifyCardbutton = new JButton("Update");
					modifyCardbutton.addActionListener(new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							numCard = Integer.parseInt(modifycard_field.getText());
							pokedeck.setNumCard(numCard);
							nameCard = modifycardname_field.getText();
							pokedeck.setNameCard(nameCard);
							pokedeck.modifyCard();
							cardmodify.setText("Your card : " + (modifycard_field.getText() == null ? "" : pokedeck.getCardUpdate() + " has been updated in : "+numCard+" "+nameCard));
							pokedeck.writeCollectCardInFile();	
						}
					});
									
				modifyCardPanel = new JPanel();
				modifyCardPanel.add(modifycard_label);
				modifyCardPanel.add(modifycard_field);
				modifyCardPanel.add(modifycardname_label);
				modifyCardPanel.add(modifycardname_field);
				button_modifycardpanel = new JPanel(new FlowLayout());
				card_modifycardpanel = new JPanel(new FlowLayout());
				button_modifycardpanel.add(modifyCardbutton);
				card_modifycardpanel.add(cardmodify);
				
				window.getContentPane().removeAll();
				window.getContentPane().add(modifyCardPanel, BorderLayout.PAGE_START);
				window.getContentPane().add(card_modifycardpanel, BorderLayout.CENTER);
				window.getContentPane().add(button_modifycardpanel, BorderLayout.PAGE_END);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();
				
			}
		});
		
		//seeCollection panel
		seeCollection.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pokedeck.readCollectCardInFile();
				collection = new JLabel("Your collection : ");
				collection.setText("Your collection : " + pokedeck.getCollectCard());
				
														
				seeCollectionPanel = new JPanel();
				seeCollectionPanel.add(collection);
								
				window.getContentPane().removeAll();
				window.getContentPane().add(seeCollectionPanel, BorderLayout.PAGE_START);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();
						
			}
		});
		
		//searchCard panel
		searchCard.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
					searchnumcard_label = new JLabel("Enter card number you want to search");
					searchnumcard_field = new JTextField(10);
					searchnamecard_label = new JLabel("Enter card name you want to search");
					searchnamecard_field = new JTextField(10);
					cardsearch = new JLabel("Your card : ");
					searchCardbutton = new JButton("Search");
					searchCardbutton.addActionListener(new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							numCardSearch = Integer.parseInt(searchnumcard_field.getText());
							pokedeck.setNumCardSearch(numCardSearch);
							nameCardSearch = searchnamecard_field.getText();
							pokedeck.setNameCardSearch(nameCardSearch);
							if (pokedeck.searchCard() == true) {
								cardsearch.setText("Your card : "+ (searchnumcard_field.getText() == null && searchnamecard_field.getText() == null ? "" : new Card(nameCardSearch, numCardSearch).toString()));
							} else {
								cardsearch.setText("Your collection does not contain card : "+new Card(nameCardSearch, numCardSearch).toString());
							}	
						}
					});
									
				searchCardPanel = new JPanel();
				searchCardPanel.add(searchnumcard_label);
				searchCardPanel.add(searchnumcard_field);
				searchCardPanel.add(searchnamecard_label);
				searchCardPanel.add(searchnamecard_field);
				button_searchcardpanel = new JPanel(new FlowLayout());
				card_searchcardpanel = new JPanel(new FlowLayout());
				button_searchcardpanel.add(searchCardbutton);
				card_searchcardpanel.add(cardsearch);
				
				window.getContentPane().removeAll();
				window.getContentPane().add(searchCardPanel, BorderLayout.PAGE_START);
				window.getContentPane().add(card_searchcardpanel, BorderLayout.CENTER);
				window.getContentPane().add(button_searchcardpanel, BorderLayout.PAGE_END);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();
				
			}
		});
		
		//saveCollection panel
		saveCollection.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				savecollection = new JLabel("Backup file : ");
				savecollection.setText("Backup file : " +p.getName()+".txt");
				pokedeck.writeCollectCardInFile();
																		
				saveCollectionPanel = new JPanel();
				saveCollectionPanel.add(savecollection);
								
				window.getContentPane().removeAll();
				window.getContentPane().add(saveCollectionPanel, BorderLayout.PAGE_START);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();						
			}
		});
		
		//uploadCollection panel
		uploadCollection.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				uploadcollection = new JLabel("Loading file : ");
				uploadcollection.setText("Loading file : " +p.getName()+".txt");
				pokedeck.readCollectCardInFile();
																		
				uploadCollectionPanel = new JPanel();
				uploadCollectionPanel.add(uploadcollection);
								
				window.getContentPane().removeAll();
				window.getContentPane().add(uploadCollectionPanel, BorderLayout.PAGE_START);
				
				window.getRootPane().repaint();
				window.getRootPane().revalidate();
						
			}
		});

		//quit
		stop.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.dispose();
			}
		});
				
		window.pack();
	    window.setVisible(true);
	}

}