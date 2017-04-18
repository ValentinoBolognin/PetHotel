

/**
 * Sample Skeleton for 'PetHotel' Controller Class
 */

package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PetHotelController {

	List<PetClient> clientList = new ArrayList<PetClient>();
	
	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="outputField"
	private TextArea outputField; // Value injected by FXMLLoader

	@FXML // fx:id="ownerTextField"
	private TextField ownerTextField; // Value injected by FXMLLoader

	@FXML // fx:id="petTextField"
	private TextField petTextField; // Value injected by FXMLLoader

	@FXML // fx:id="daysTextField"
	private TextField daysTextField; // Value injected by FXMLLoader

	@FXML
	void insertClient(MouseEvent event) {
		
		String owner = ownerTextField.getText();
		String pet = petTextField.getText();
		int days = Integer.parseInt(daysTextField.getText());

		outputField.appendText(owner + "\t" + pet + "\t" + "\t" + days + "\n");
		
		PetClient petClient = new PetClient(owner, pet, days);
		
		clientList.add(petClient);
		
	}

	@FXML
	void printClient(MouseEvent event) {
		
		outputField.clear();
		
		//Collections.sort(clientList);
		
//		Collections.sort(clientList, new Comparator<PetClient>() {
//
//			@Override
//			public int compare(PetClient o1, PetClient o2) {
//				if(o1.getDays() < o2.getDays())
//					return -1;
//				if(o1.getDays() > o2.getDays())
//					return 1;
//				return 0;
//			}
//
//		});
//		
//		Iterator<PetClient> it = clientList.iterator();
//				
//		while(it.hasNext()){
//			PetClient pt = it.next();
//			
//			if(pt.getDays() > 20)
//				it.remove();
//		}
		
		ListIterator<PetClient> lt = clientList.listIterator(clientList.size()-1);
		
		while(lt.hasPrevious()){
			PetClient pt = lt.previous();
			
			if(pt.getDays() > 20)
				lt.remove();
		}

		for(PetClient pt : clientList){
			outputField.appendText(pt.toString() + "\n");
		}
		
	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert outputField != null : "fx:id=\"outputField\" was not injected: check your FXML file 'Untitled'.";
		assert ownerTextField != null : "fx:id=\"ownerTextField\" was not injected: check your FXML file 'Untitled'.";
		assert petTextField != null : "fx:id=\"petTextField\" was not injected: check your FXML file 'Untitled'.";
		assert daysTextField != null : "fx:id=\"daysTextField\" was not injected: check your FXML file 'Untitled'.";

	}
}
