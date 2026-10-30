module co.edu.uniquindio.edu.poo.javafx {
    requires javafx.controls;

    requires javafx.fxml;

    opens co.edu.uniquindio.edu.poo.javafx
            to javafx.fxml;

    exports co.edu.uniquindio.edu.poo.javafx;

    exports co.edu.uniquindio.edu.poo.javafx.viewController;

    opens co.edu.uniquindio.edu.poo.javafx.viewController
            to javafx.fxml;

}