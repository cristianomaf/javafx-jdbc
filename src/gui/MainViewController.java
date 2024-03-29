package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartamentoService;

public class MainViewController implements Initializable {
	// atributos dos menus
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
	//acao carregar tela Departamentos
		loadView2("/gui/DepartamentoList.fxml");
	}

	@FXML
	public void onMenuItemItemSobreAction() {
		loadView("/gui/Sobre.fxml");
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}

	// funcao abrir nova tela
	private synchronized void loadView(String absoluteName) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVbox = loader.load();

			// referencia para Scene
			Scene mainScene = Main.getMainScene();
			// referencia vbox janela principal
			VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVbox.getChildren().get(0);

			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVbox.getChildren());

		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro carregando view", e.getMessage(), AlertType.ERROR);
		}
	}
//provisorio load view 2
	private synchronized void loadView2(String absoluteName) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVbox = loader.load();

			// referencia para Scene
			Scene mainScene = Main.getMainScene();
			// referencia vbox janela principal
			VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVbox.getChildren().get(0);

			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVbox.getChildren());
			
			DepartamentoListController controller = loader.getController();
			controller.setDepartamentoService(new DepartamentoService());
			controller.updateTableView();

		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro carregando view", e.getMessage(), AlertType.ERROR);
		}
	}
	
}
