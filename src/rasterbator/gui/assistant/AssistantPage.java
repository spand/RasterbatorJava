package rasterbator.gui.assistant;

import javax.swing.*;

public abstract class AssistantPage extends JPanel {

    public AssistantControl getParentControl() {
        return (AssistantControl) getParent().getParent();
    }

    public String getContinueButtonText ()
    {
        return "Continue >";
    }

    public boolean isOkayToLeave ()
    {
        return true;
    }

    public void afterLeaveHandler (){

    };

    public void beforeShowHandler(){

    };

}
