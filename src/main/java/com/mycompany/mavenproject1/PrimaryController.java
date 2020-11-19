package com.mycompany.mavenproject1;

import docx2pdf.Converter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

public class PrimaryController {

    @FXML
    private Button bDocx;
    @FXML
    private Button bPdf;
    @FXML
    private Button bFonts;
    @FXML
    private Button bGenerate;
    @FXML
    private TextField tfDocx;
    @FXML
    private TextField tfPdf;
    @FXML
    private TextField tfFonts;

    @FXML
    private void openDialogDocx() {
        Window window = bDocx.getScene().getWindow();
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters()
                .addAll(new ExtensionFilter("Docx Files", "*.docx"));

        File f = chooser.showOpenDialog(window);
        setPath(tfDocx, f);

    }

    @FXML
    private void openDialogPdf() {
        Window window = bPdf.getScene().getWindow();
        DirectoryChooser chooser = new DirectoryChooser();

        File f = chooser.showDialog(window);
        setPath(tfPdf, f);
    }

    @FXML
    private void openDialogFonts() {
        Window window = bFonts.getScene().getWindow();
        DirectoryChooser chooser = new DirectoryChooser();

        File f = chooser.showDialog(window);
        setPath(tfFonts, f);
    }

    @FXML
    private void generate() {
        String pathDocx = tfDocx.getText();
        String pathPdf = tfPdf.getText();
        String pathFonts = tfFonts.getText();

        try {
            Converter c = new Converter(pathDocx, pathPdf + "/out.pdf", pathFonts);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("PDF generated successfully");
        alert.setHeaderText("Success!");
        alert.setContentText("Your PDF has been created successfully!");

        alert.show();
    }

    /*  Helper */
    private void setPath(TextField tf, File f) {
        if (f != null) {
            tf.setText(f.getAbsolutePath());
        }
    }
}
