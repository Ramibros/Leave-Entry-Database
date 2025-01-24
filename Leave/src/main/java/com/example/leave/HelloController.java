package com.example.leave;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private DatePicker todateDatePicker;

    @FXML
    private TableView<Student> tableTableView;

    @FXML
    private DatePicker dateDatePicker;

    @FXML
    private TableColumn<Student, String> idColo;

    @FXML
    private TableColumn<Student, String> searchCourseColo;

    @FXML
    private TableColumn<String , String> courseColo;

    @FXML
    private TableView<Student> searchtableTableView;

    @FXML
    private TextField nameTextField;

    @FXML
    private TableColumn<Student, String> searchReasonColo;

    @FXML
    private TextField studentIDTextField;

    @FXML
    private TextField sectionTextField;

    @FXML
    private DatePicker fromdateDatePicker;

    @FXML
    private TableColumn<Student, String> dateColo;

    @FXML
    private TableColumn<Student, String> sectionColo;

    @FXML
    private TableColumn<Student, String> searchSectionColo;

    @FXML
    private TableColumn<Student, String> searchNameColo;

    @FXML
    private TableColumn<Student, String> searchIdColo;

    @FXML
    private TableColumn<Student, String> nameColo;

    @FXML
    private TableColumn<Student, String> reasonColo;

    @FXML
    private TableColumn<Student, String> searchDateColo;

    @FXML
    private TextField reasonTextField;

    @FXML
    private TextField courseTextField;

    public void save(ActionEvent actionEvent) {
        String studentID = studentIDTextField.getText();
        String name = nameTextField.getText();
        String date = dateDatePicker.getValue().toString();
        String reason = reasonTextField.getText();
        String course = courseTextField.getText();
        String section = sectionTextField.getText();

        Student student = new Student(null, studentID, name, date, reason, course, section);

        String saveQuery = "INSERT INTO student (studentID, name, date, reason, course, section) VALUES " +
                "(" + student.getStudentID() + ", '" + student.getName() + "', '" + student.getDate() + "', '" + student.getReason() +
                "', '" + student.getCourse() + "', " + student.getSection() + ")";
        try {
            Statement statement = DBConnection.getStatement();
            statement.executeUpdate(saveQuery);
            tableTableView.setItems(getstudentlist());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private ObservableList <Student> getstudentlist (){
        ObservableList <Student> students = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM student";
        try {
            Statement statement = DBConnection.getStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String studentID = resultSet.getString("studentID");
                String name = resultSet.getString("name");
                String date = resultSet.getString("date");
                String reason = resultSet.getString("reason");
                String course = resultSet.getString("course");
                String section = resultSet.getString("section");

                Student student = new Student(id, studentID, name, date, reason, course, section);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public void delete(ActionEvent actionEvent) {
    Student student = tableTableView.getSelectionModel().getSelectedItem();
    String deleteQuery = "DELETE FROM student WHERE id = " + student.getId();
    try {
        Statement statement = DBConnection.getStatement();
        statement.executeUpdate(deleteQuery);
        tableTableView.setItems(getstudentlist());
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    }

    public void search(ActionEvent actionEvent) {
        String fromdate = fromdateDatePicker.getValue().toString();
        String todate = todateDatePicker.getValue().toString();
        String searchQuery = "SELECT * FROM student WHERE date BETWEEN '" + fromdate + "' AND '" + todate + "'";
        try {
            Statement statement = DBConnection.getStatement();
            ResultSet resultSet = statement.executeQuery(searchQuery);
            ObservableList <Student> students = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String studentID = resultSet.getString("studentID");
                String name = resultSet.getString("name");
                String date = resultSet.getString("date");
                String reason = resultSet.getString("reason");
                String course = resultSet.getString("course");
                String section = resultSet.getString("section");

                Student student = new Student(id, studentID, name, date, reason, course, section);
                students.add(student);
            }
            searchtableTableView.setItems(students);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColo.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        nameColo.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateColo.setCellValueFactory(new PropertyValueFactory<>("date"));
        reasonColo.setCellValueFactory(new PropertyValueFactory<>("reason"));
        courseColo.setCellValueFactory(new PropertyValueFactory<>("course"));
        sectionColo.setCellValueFactory(new PropertyValueFactory<>("section"));
        tableTableView.setItems(getstudentlist());

        searchIdColo.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        searchNameColo.setCellValueFactory(new PropertyValueFactory<>("name"));
        searchDateColo.setCellValueFactory(new PropertyValueFactory<>("date"));
        searchReasonColo.setCellValueFactory(new PropertyValueFactory<>("reason"));
        searchCourseColo.setCellValueFactory(new PropertyValueFactory<>("course"));
        searchSectionColo.setCellValueFactory(new PropertyValueFactory<>("section"));
        searchtableTableView.setItems(getstudentlist());
    }
}