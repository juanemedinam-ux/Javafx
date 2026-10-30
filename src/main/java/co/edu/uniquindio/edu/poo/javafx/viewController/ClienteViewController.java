package co.edu.uniquindio.edu.poo.javafx.viewController;


import java.util.Collection;

import co.edu.uniquindio.edu.poo.javafx.App;
import co.edu.uniquindio.edu.poo.javafx.controller.ClienteController;
import co.edu.uniquindio.edu.poo.javafx.model.Cliente;

import co.edu.uniquindio.edu.poo.javafx.App;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClienteViewController {

    // Controlador
    ClienteController clienteController;

    // Lista observable
    ObservableList<Cliente> listClientes =
            FXCollections.observableArrayList();

    // Cliente seleccionado
    Cliente selectedCliente;

    // Componentes de la interfaz

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Cliente> tblListCliente;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private TableColumn<Cliente, String> tbcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TableColumn<Cliente, String> tbcApellido;

    @FXML
    private Button btbAgregarCliente;

    @FXML
    private TableColumn<Cliente, String> tbcCedula;

    @FXML
    private TextField txtCedula;

    private App app;


    // EVENTOS DE LOS BOTONES

    @FXML
    void onAgregarCliente() {

        agregarCliente();

    }

    @FXML
    void onActualizarCliente() {

        actualizarCliente();

    }

    @FXML
    void onLimpiar() {

        limpiarSeleccion();

    }

    @FXML
    void onEliminar() {

        eliminarCliente();

    }


    // INICIALIZACIÓN

    @FXML
    void initialize() {

        // La aplicación todavía no se ha asignado.
        // La inicialización se realiza en setApp().

    }


    // CONFIGURAR LA VISTA

    private void initView() {

        // Conectar columnas con atributos
        initDataBinding();

        // Obtener clientes
        obtenerClientes();

        // Limpiar tabla
        tblListCliente.getItems().clear();

        // Asignar lista a tabla
        tblListCliente.setItems(listClientes);

        // Escuchar selección de clientes
        listenerSelection();

    }


    // CONECTAR DATOS CON COLUMNAS

    private void initDataBinding() {

        tbcCedula.setCellValueFactory(cellData ->
                new SimpleStringProperty(
                        cellData.getValue().getCedula()
                ));

        tbcNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(
                        cellData.getValue().getNombre()
                ));

        tbcApellido.setCellValueFactory(cellData ->
                new SimpleStringProperty(
                        cellData.getValue().getApellido()
                ));

    }


    // OBTENER CLIENTES

    private void obtenerClientes() {

        listClientes.clear();

        Collection<Cliente> clientes =
                clienteController.obtenerListaClientes();

        listClientes.addAll(clientes);

    }


    // ESCUCHAR SELECCIÓN DE LA TABLA

    private void listenerSelection() {

        tblListCliente.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldSelection, newSelection) -> {

                    selectedCliente = newSelection;

                    mostrarInformacionCliente(selectedCliente);

                });

    }


    // MOSTRAR INFORMACIÓN DEL CLIENTE

    private void mostrarInformacionCliente(Cliente cliente) {

        if (cliente != null) {

            txtCedula.setText(cliente.getCedula());

            txtNombre.setText(cliente.getNombre());

            txtApellido.setText(cliente.getApellido());

        }

    }


    // AGREGAR CLIENTE

    private void agregarCliente() {

        Cliente cliente = buildCliente();

        if (clienteController.crearCliente(cliente)) {

            listClientes.add(cliente);

            limpiarCamposCliente();

        }

    }


    // CONSTRUIR OBJETO CLIENTE

    private Cliente buildCliente() {

        Cliente cliente = new Cliente(
                txtCedula.getText(),
                txtNombre.getText(),
                txtApellido.getText()
        );

        return cliente;

    }


    // ELIMINAR CLIENTE

    private void eliminarCliente() {

        if (selectedCliente != null &&
                clienteController.eliminarCliente(
                        selectedCliente.getCedula())) {

            listClientes.remove(selectedCliente);

            limpiarCamposCliente();

            limpiarSeleccion();

        }

    }


    // ACTUALIZAR CLIENTE

    private void actualizarCliente() {

        if (selectedCliente != null &&
                clienteController.actualizarCliente(
                        selectedCliente.getCedula(),
                        buildCliente())) {

            int index = listClientes.indexOf(selectedCliente);

            if (index >= 0) {

                listClientes.set(index, buildCliente());

            }

            tblListCliente.refresh();

            limpiarSeleccion();

            limpiarCamposCliente();

        }

    }


    // LIMPIAR SELECCIÓN

    private void limpiarSeleccion() {

        tblListCliente.getSelectionModel().clearSelection();

        limpiarCamposCliente();

    }


    // LIMPIAR CAMPOS

    private void limpiarCamposCliente() {

        txtCedula.clear();

        txtNombre.clear();

        txtApellido.clear();

    }


    // RECIBIR APLICACIÓN PRINCIPAL

    public void setApp(App app) {

        this.app = app;

        clienteController =
                new ClienteController(app.empresa);

        initView();

    }


}
