import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaterfallAgileGUI extends JFrame{

    private JPanel rootPane;
    private JCheckBox experienceCheckBox;
    private JCheckBox integrateCheckBox;
    private JCheckBox qualityCheckBox;
    private JCheckBox deadlineCheckBox;
    private JCheckBox modelCheckBox;
    private JCheckBox programCheckBox;
    private JTextField projectName;
    private JButton resultButton;
    private JButton quitButton;
    private JLabel resultsHere;

    protected WaterfallAgileGUI() {
        setContentPane(rootPane);
        pack();
        setSize(new Dimension(775, 350));
        setTitle("Waterfall or Agile ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String project = projectName.getText();
                String result = waterfallAgileResult();
                resultsHere.setText(project + ", " + " you are recommended to use: " + result);
            }
        });


        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(WaterfallAgileGUI.this,
                        "Are you sure you want to quit?",
                        "Quit", JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

        public String waterfallAgileResult(){

            int sum = 0;
            String result = "";

            if (programCheckBox.isSelected()){
                sum += 1;
            }
            if(deadlineCheckBox.isSelected()){
                sum += 1;
            }
            if (qualityCheckBox.isSelected()){
                sum += 1;
            }
            if(experienceCheckBox.isSelected()){
                sum += 1;
            }
            if (integrateCheckBox.isSelected()){
                sum += 1;
            }
            if(modelCheckBox.isSelected()){
                sum += 1;
            }

            if (sum < 3){
                result = "Agile";
            }
            if (sum > 3){
                result = "Waterfall";
            }
            if (sum == 3){
                result = "Either";
            }
            return result;
    }
}
