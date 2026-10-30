
package co.edu.uniquindio.edu.poo.javafx;

import co.edu.uniquindio.edu.poo.javafx.model.Cliente;
import co.edu.uniquindio.edu.poo.javafx.model.Empresa;
import co.edu.uniquindio.edu.poo.javafx.viewController.ClienteViewController;
import co.edu.uniquindio.edu.poo.javafx.viewController.PrimaryController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class App extends Application {

    private Stage primaryStage;

    public static Empresa empresa = new Empresa("UQ");

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.primaryStage = primaryStage;

        this.primaryStage.setTitle("Gestión de Clientes");

        inicializarData();

        openViewPrincipal();
    }

    // ABRIR VENTANA PRINCIPAL
    private void openViewPrincipal() {

        try {

            URL recurso = App.class.getResource(
                    "/co/edu/uniquindio/edu/poo/javafx/primary.fxml"
            );

            if (recurso == null) {
                throw new IllegalStateException(
                        "No se encontró el archivo primary.fxml en resources."
                );
            }

            FXMLLoader loader = new FXMLLoader(recurso);

            VBox rootLayout = loader.load();

            PrimaryController primaryController = loader.getController();

            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);

            primaryStage.setScene(scene);

            primaryStage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    // MÉTODO PRINCIPAL
    public static void main(String[] args) {

        launch(args);

    }

    // ABRIR VENTANA CRUD DE CLIENTES
    public void openCrudCliente() {

        try {

            URL recurso = App.class.getResource(
                    "/co/edu/uniquindio/edu/poo/javafx/crudCliente.fxml"
            );

            if (recurso == null) {
                throw new IllegalStateException(
                        "No se encontró crudCliente.fxml. "
                                + "Verifica su ubicación dentro de src/main/resources."
                );
            }

            FXMLLoader loader = new FXMLLoader(recurso);

            AnchorPane rootLayout = loader.load();

            ClienteViewController clienteViewController =
                    loader.getController();

            clienteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);

            primaryStage.setScene(scene);

            primaryStage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    // INICIALIZAR DATOS DE PRUEBA
    public void inicializarData() {

        Cliente cliente = new Cliente(
                "12233",
                "Juan",
                "Apellido"
        );

        empresa.agregarCliente(cliente);

    }
}

