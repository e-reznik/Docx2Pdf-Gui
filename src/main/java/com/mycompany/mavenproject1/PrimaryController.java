package com.mycompany.mavenproject1;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

public class PrimaryController {

    @FXML
    private Button b_docx;
    @FXML
    private Button b_pdf;
    @FXML
    private Button b_fonts;
    @FXML
    private TextField tf_docx;
    @FXML
    private TextField tf_pdf;
    @FXML
    private TextField tf_fonts;

    @FXML
    private void openDialogDocx() {
        Window window = b_docx.getScene().getWindow();
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters()
                .addAll(new ExtensionFilter("Docx Files", "*.docx"));

        File f = chooser.showOpenDialog(window);
        setPath(tf_docx, f);

    }

    @FXML
    private void openDialogPdf() {
        Window window = b_pdf.getScene().getWindow();
        DirectoryChooser chooser = new DirectoryChooser();

        File f = chooser.showDialog(window);
        setPath(tf_pdf, f);
    }

    @FXML
    private void openDialogFonts() {
        Window window = b_fonts.getScene().getWindow();
        DirectoryChooser chooser = new DirectoryChooser();

        File f = chooser.showDialog(window);
        setPath(tf_fonts, f);
    }

    /*  Helper */
    private void setPath(TextField tf, File f) {
        if (f != null) {
            tf.setText(f.getAbsolutePath());
        }
    }
}
