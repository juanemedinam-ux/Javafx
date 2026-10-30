
package co.edu.uniquindio.edu.poo.javafx.viewController;

import co.edu.uniquindio.edu.poo.javafx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    private App app;

    @FXML
    private Button primaryButton;

    @FXML
    private void onOpenCrudCliente() {

        System.out.println("Botón Gestión de clientes presionado");

        if (app != null) {
            app.openCrudCliente();
        } else {
            System.out.println("Error: App no está inicializada");
        }
    }

    public void setApp(App app) {
        this.app = app;
    }
}
