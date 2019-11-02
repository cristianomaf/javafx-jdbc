package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	//atributos dos menus
	@FXML
	private MenuItem menuItemVendedor;

	@FXML
	private MenuItem menuItemDepartamento;

	@FXML
	private MenuItem menuItemSobre;

//	eventos dos menus

	@FXML
	public void onMenuItemVendedorAction() {
		System.out.println("onMenuVendedorAction");
	}
	@FXML
	public void onMenuItemDepartamentoAction() {
		System.out.println("onMenuVendedorAction");
	}
	@FXML
	public void onMenuItemItemSobreAction() {
		System.out.println("onMenuItemSobreAction");
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}

}
