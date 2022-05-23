import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;


public class MainController {
    // Left side
    @FXML
    private TextField unitName;
    @FXML
    private TextField unitHealth;
    @FXML
    private TextField unitArmor;
    @FXML
    private TextField unitAmount;
    @FXML
    private CheckBox checkRanged;
    @FXML
    private CheckBox checkCommander;
    @FXML
    private CheckBox checkCavalry;
    @FXML
    private CheckBox checkInfantry;
    // Right side
    @FXML
    private TextField quickAmount;
    @FXML
    private CheckBox quickInfantry;
    @FXML
    private CheckBox quickCommander;
    @FXML
    private CheckBox quickRanged;
    @FXML
    private CheckBox quickCavalry;
    // Submit
    @FXML
    private Button addArmyOne;
    @FXML
    private Button addArmyTwo;


    private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
    private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();
    private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);
    private final int maxNumSelected = 1;

    public void initialize() {
        configureCheckBox(checkRanged);
        configureCheckBox(checkCavalry);
        configureCheckBox(checkCommander);
        configureCheckBox(checkInfantry);
        configureCheckBox(quickCommander);
        configureCheckBox(quickInfantry);
        configureCheckBox(quickRanged);
        configureCheckBox(quickCavalry);


        addArmyOne.setDisable(true);
        addArmyTwo.setDisable(true);

        numCheckBoxesSelected.addListener((obs, oldSelectedCount, newSelectedCount) -> {
            if (newSelectedCount.intValue() >= maxNumSelected) {
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(true));
                addArmyOne.setDisable(false);
                addArmyTwo.setDisable(false);
            } else {
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(false));
                addArmyOne.setDisable(false);
                addArmyTwo.setDisable(false);
            }
        });


    }

    private void configureCheckBox(CheckBox checkBox) {
        if (checkBox.isSelected()) {
            selectedCheckBoxes.add(checkBox);
        } else {
            unselectedCheckBoxes.add(checkBox);
        }
        checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                unselectedCheckBoxes.remove(checkBox);
                selectedCheckBoxes.add(checkBox);
            } else {
                selectedCheckBoxes.remove(checkBox);
                unselectedCheckBoxes.add(checkBox);
            }
        });
    }


    public void fight(ActionEvent e) {
        System.out.println("fighting");
    }

    public void resetFight(ActionEvent e) {
        System.out.println("Resetting fight");
    }

    public void newFight(ActionEvent e) {
        System.out.println("New fight inc");
    }

    public void addToArmy(ActionEvent e) {
        System.out.println("Added to army");
    }
}
