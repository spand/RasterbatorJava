package rasterbator.gui.assistant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class AssistantControl extends JPanel {

    private JPanel tabControl = new JPanel();
    private JButton ContinueButton = new JButton();
    private JButton BackButton = new JButton();

    public AssistantControl() {
        tabControl.setLayout(new CardLayout());

        BackButton.setText("< Back");
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BackButtonClicked();
            }
        });
        BackButton.setVisible(false);

        ContinueButton.setText("Continue >");
        ContinueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NextButtonClicked();
            }
        });

//        this.BackButton.Font 		= new Font ("Tahoma", 15f, FontStyle.Regular, GraphicsUnit.World, ((System.Byte)(0)));
//        this.BackButton.Location 	= new Point (80, 357);
//        this.BackButton.Size 		= new Size (96, 32);
//        this.BackButton.Text 		= "< Back";
//        this.BackButton.Click 		+= new EventHandler (this.BackButtonClicked);
//        this.BackButton.Visible 		= false;
//
//        this.ContinueButton.Font 	= new Font ("Tahoma", 15f, FontStyle.Regular, GraphicsUnit.World, ((System.Byte)(0)));
//        this.ContinueButton.Location = new Point (472, 357);
//        this.ContinueButton.Size 	= new Size (136, 32);
//        this.ContinueButton.Text		= "Continue >";
//        this.ContinueButton.Click 	+= new EventHandler (this.NextButtonClicked);

//        tabControl.Size 		= new Size (702, 343);

        this.add(BackButton);
        this.add(ContinueButton);
        this.add(tabControl);
    }

    public boolean isContinueButtonEnabled(){
        return ContinueButton.isEnabled();
    }

    public void setContinueButtonEnabled(boolean enabled){
        ContinueButton.setEnabled(enabled);
    }

//    public boolean ContinueButtonEnabled {
//        get { return (ContinueButton.Enabled); }
//        set { ContinueButton.Enabled = value; }
//    }

    public String getContinueButtonText(){
        return ContinueButton.getText();
    }
    
    public void setContinueButtonText(String text){
        ContinueButton.setText(text);
    }
    
//    public String ContinueButtonText {
//        get { return (ContinueButton.Text); }
//        set { ContinueButton.Text = value; }
//    }

    public int getSelectedIndex(){
        return selectedIndex;
    }

//    public int SelectedIndex {
//        get { return (tabControl.SelectedIndex); }
//        set { tabControl.SelectedIndex = value; }
//    }

    List<AssistantPage> pages = new LinkedList<AssistantPage>();
    int selectedIndex;

    public void AddPage(AssistantPage a) {
        tabControl.add(a, a.getName());
        pages.add(a);
    }

    void BackButtonClicked ()
    {
        selectedIndex--;
        ((CardLayout)(tabControl.getLayout())).show(tabControl, pages.get(selectedIndex).getName());

        updateButtons();
    }

//    void BackButtonClicked (object sender, System.EventArgs e)
//    {
//        tabControl.SelectedIndex--;
//
//        updateButtons();
//    }

    void NextButtonClicked ()
    {
        AssistantPage selectedTab = pages.get(selectedIndex);
        if (!(selectedTab).isOkayToLeave()){
            return;
        }

        selectedTab.afterLeaveHandler();

        if (selectedIndex < pages.size()-1){
            selectedIndex++;
            ((CardLayout)(tabControl.getLayout())).show(tabControl, pages.get(selectedIndex).getName());

            pages.get(selectedIndex).beforeShowHandler();

            updateButtons();
        } else {
            Window window = SwingUtilities.getWindowAncestor(this);
            window.setVisible(false);
            window.dispose();
//            (this.Parent as Form).Close();
        }
    }

    void updateButtons()
    {
        AssistantPage selectedTab = pages.get(selectedIndex);
        if (selectedIndex==pages.size()-1)
            setContinueButtonText("Close");
//            this.ContinueButton.Text = "Close";
        else
            setContinueButtonText(selectedTab.getContinueButtonText());
//            this.ContinueButton.Text = (tabControl.SelectedTab as AssistantPage).getContinueButtonText();

        setContinueButtonEnabled(selectedTab.isOkayToLeave());
//        this.ContinueButton.Enabled = (tabControl.SelectedTab as AssistantPage).isOkayToLeave();
        BackButton.setVisible(selectedIndex>0);
//        this.BackButton.Visible = (tabControl.SelectedIndex>0);
    }


}
