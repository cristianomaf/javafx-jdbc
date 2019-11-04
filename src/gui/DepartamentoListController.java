package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Departamento;
import model.services.DepartamentoService;

public class DepartamentoListController implements Initializable {

	private DepartamentoService service;

	// referencias para componentes da view
	@FXML
	private TableView<Departamento> tableViewDepartamento;

	@FXML
	private TableColumn<Departamento, Integer> tableColumnId;

	@FXML
	private TableColumn<Departamento, String> tableColumnNome;

	@FXML
	private Button btNovo;
	
	private ObservableList<Departamento> obsList;
	
	
	
	

	// tratamento de evento do botao

	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}
	
	
	public void setDepartamentoService(DepartamentoService service) {
		this.service = service;
		
	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// metodo auxiliar lidar com a tabela
		initializeNodes();

	}

	private void initializeNodes() {

		// inicia colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("name"));

		// table view acompanhar a autura da janela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());

	}
	
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Services esta vazio");
			
		}
		List<Departamento> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartamento.setItems(obsList);
		
		
	}

}
