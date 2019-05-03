package javaFX2checkBox;

import javafx.beans.binding.ObjectBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class CheckBoxController {

	@FXML
	private CheckBox ckb;
	@FXML
	private TextField txf;

	@FXML
	private CheckBox ckbHBind;
	@FXML
	private TextField txfHBind;

	@FXML
	private CheckBox ckbLBind;
	@FXML
	private TextField txfLBind;

	private String on = "ON";
	private String off = "OFF";

	@FXML
	void initialize() {
		// Using Event Handler
		assert ckb != null : "fx:id=\"ckb\" was not injected: check your FXML file 'CheckBox.fxml'.";
		assert txf != null : "fx:id=\"txf\" was not injected: check your FXML file 'CheckBox.fxml'.";
		this.ckb.setSelected(true);
		this.txf.setText(on);

		// Using Bind (High-level API)
		assert ckbHBind != null : "fx:id=\"ckbHBind\" was not injected: check your FXML file 'CheckBox.fxml'.";
		assert txfHBind != null : "fx:id=\"txfHBind\" was not injected: check your FXML file 'CheckBox.fxml'.";
		this.ckbHBind.setSelected(true);
		this.txfHBind.textProperty().bind(this.ckbHBind.selectedProperty().asString());

		// Using Bind (Low-level API)
		assert ckbLBind != null : "fx:id=\"ckbLBind\" was not injected: check your FXML file 'CheckBox.fxml'.";
		assert txfLBind != null : "fx:id=\"txfLBind\" was not injected: check your FXML file 'CheckBox.fxml'.";
		this.ckbLBind.setSelected(true);
		this.txfLBind.textProperty().bind(this.observer(ckbLBind));
	}

	// Using Event Handler
	@FXML
	void ckbOnAction(ActionEvent event) {
		if (this.ckb.isSelected()) {
			this.txf.setText(on);
		}
		else {
			this.txf.setText(off);
		}
	}

	// Using Bind (High-level API)

	// Using Bind (Low-level API)
	private ObjectBinding<String> observer(CheckBox p) {
		final CheckBox ckb = p;
		ObjectBinding<String> sBinding = new ObjectBinding<String>() {
			{
				super.bind(ckb.selectedProperty());
			}

			@Override
			protected String computeValue() {
				String s;
				if (ckb.isSelected()) {
					s = on;
				}
				else {
					s = off;
				}
				return s;
			}
		};
		return sBinding;
	}
}
