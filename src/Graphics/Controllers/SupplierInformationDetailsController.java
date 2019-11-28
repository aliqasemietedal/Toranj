package Graphics.Controllers;

import Graphics.Other.Start;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SupplierInformationDetailsController implements Initializable {

    @FXML
    private MenuButton UserPanelMenu;

    @FXML
    private Label UserLabel;

    @FXML
    private Label VersionLabel;

    @FXML
    private Label FirstNameData;

    @FXML
    private Label LastNameData;

    @FXML
    private Label MobileNumberData;

    @FXML
    private Label FaxData;

    @FXML
    private Label GenderData;

    @FXML
    private Label EmailData;

    @FXML
    private Label AddressData;

    @FXML
    private Label CommentData;

    @FXML
    private Button DeleteButton;

    @FXML
    private MenuItem PersonnelItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserLabel.setText(LoginController.Username);
        VersionLabel.setText("1.0.3");
        if (LoginController.user.getLevel() == 1) {
            PersonnelItem.setVisible(false);
        }
        FirstNameData.setText(SuppliersTableController.selectionSupplier.getName());
        LastNameData.setText(SuppliersTableController.selectionSupplier.getLastName());
        MobileNumberData.setText(SuppliersTableController.selectionSupplier.getMobilePhoneNumber());
        FaxData.setText(SuppliersTableController.selectionSupplier.getFax());
        if (SuppliersTableController.selectionSupplier.getSex().equals("male")) {
            GenderData.setText("مرد");
        } else {
            GenderData.setText("زن");
        }
        EmailData.setText(SuppliersTableController.selectionSupplier.geteMail());
        AddressData.setText(SuppliersTableController.selectionSupplier.getAddress());
        CommentData.setText(SuppliersTableController.selectionSupplier.getDescription());
    }

    @FXML
    void ChangePasswordItemAction() throws IOException {
        GoToPage("ChangePassword", 600, 382);
    }

    @FXML
    void ReturnButtonAction() throws IOException {
        GoToPage("SuppliersTable", 600, 434);
    }

    @FXML
    void DeleteButtonAction() throws IOException {
        LoginController.user.deleteSupplier(SuppliersTableController.selectionSupplier.getName(), SuppliersTableController.selectionSupplier.getLastName(), Start.database);
        GoToPage("SuppliersTable", 600, 434);
    }

    @FXML
    void CreateProductItemAction() throws IOException {
        GoToPage("AddProduct", 600, 366);
    }

    @FXML
    void CreatePurchaseItemAction() throws IOException {
        GoToPage("AddPurchase", 600, 447);
    }

    @FXML
    void CreateSaleItemAction() throws IOException {
        GoToPage("AddSale", 600, 409);
    }

    @FXML
    void CustomersItemAction() throws IOException {
        GoToPage("CustomersTable", 600, 434);
    }

    @FXML
    void PersonnelItemAction() throws IOException {
        GoToPage("PersonnelTable", 600, 434);
    }

    @FXML
    void ProductsTableItemAction() throws IOException {
        GoToPage("ProductsTable", 600, 434);
    }

    @FXML
    void PurchasesTableItemAction() throws IOException {
        GoToPage("PurchasesTable", 600, 434);
    }

    @FXML
    void SaleTableItemAction() throws IOException {
        GoToPage("SaleTable", 600, 434);
    }

    @FXML
    void SuppliersItemAction() throws IOException {
        GoToPage("SuppliersTable", 600, 434);
    }

    @FXML
    void homeLinkAction() throws IOException {
        GoToPage("MainPage", 600, 400);
    }

    private void GoToPage(String page, int width, int height) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Graphics/FXMLS/" + page + ".fxml"));
        Stage NextPage = new Stage();
        NextPage.setResizable(false);
        NextPage.setScene(new Scene(root, width, height));
        Stage ThisPage = (Stage) UserPanelMenu.getScene().getWindow();
        NextPage.setResizable(false);
        NextPage.show();
        ThisPage.close();
    }

}
