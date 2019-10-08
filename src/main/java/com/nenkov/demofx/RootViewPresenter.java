package com.nenkov.demofx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class RootViewPresenter implements Initializable {
    private final BookJpaRepository bookJpaRepository;
    private List<BookEntity> bookEntityList;

    @FXML
    private TableView<BookEntity> bookTableView;
    @FXML
    private TableColumn<BookEntity, String> idColumn;
    @FXML
    private TableColumn<BookEntity, String> titleColumn;
    @FXML
    private TableColumn<BookEntity, String> isbnColumn;
    @FXML
    private TableColumn<BookEntity, Timestamp> addedOnColumn;

    @FXML
    private TextField entriesPerPageTextField;
    @FXML
    private TextField pageNumberTextField;
    @FXML
    private Button refreshButton;

    @FXML
    private Button addNewButton;
    @FXML
    private TextField isbnTextField;
    @FXML
    private TextField titleTextField;

    @Autowired
    public RootViewPresenter(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupBookTableView();
        loadBookEntityList();
        refreshBookTableView();
        addNewButton.setOnAction((e) -> {
            bookJpaRepository.save(new BookEntity(titleTextField.getText(), isbnTextField.getText()));
            refreshBookTableView();
        });
        refreshButton.setOnAction(e -> refreshBookTableView());
    }

    private void setupBookTableView() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        addedOnColumn.setCellValueFactory(new PropertyValueFactory<>("addedOn"));
    }

    private void loadBookEntityList() {
        bookEntityList = bookJpaRepository.findAll(PageRequest.of(pageNumber(), entriesPerPage())).getContent();
    }

    private void refreshBookTableView() {
        loadBookEntityList();
        bookTableView.getItems().clear();
        bookTableView.getItems().addAll(bookEntityList);
    }

    private int pageNumber() {
        try {
            return Integer.parseInt(pageNumberTextField.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    private int entriesPerPage() {
        try {
            return Integer.parseInt(entriesPerPageTextField.getText());
        } catch (Exception e) {
            return 10;
        }
    }
}
