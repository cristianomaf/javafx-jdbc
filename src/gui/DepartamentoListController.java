package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Departamento;

public class DepartamentoListController implements Initializable {

	//referencias para componentes da view
	@FXML
	private TableView<Departamento> tableViewDepartamento;
	
	@FXML
	private TableColumn<Departamento,Integer> tableColumnId;
	
	@FXML
	private TableColumn<Departamento,String> tableColumnNome;
	
	@FXML
	private Button btNovo;
	
	//tratamento de evento do botao
	
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//metodo auxiliar lidar com a tabela
		initializeNodes();
	
		
	}



	private void initializeNodes() {
		
		//inicia colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id") );
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		//table view acompanhar a autura da janela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());
		
		
		
	}

}
