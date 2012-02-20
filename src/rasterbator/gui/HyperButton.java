package rasterbator.gui;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * JButton version of Dav Mrazek's HyperLinkButton
 * @author Brian Cole
 */
public class HyperButton extends JButton {

    private Color rolloverColor;
    private Insets insets;

    public HyperButton(){
        this("");
    }

    public HyperButton(String linkName)
    {
        super(linkName);
        setRolloverEnabled(true);
        setBorderPainted(false);
        setInsets(0, 3, 1, 3);
        setFocusPainted(false);
//        setForeground(Color.WHITE); // default idle color
        setRolloverColor(Color.BLUE); // default hover color
        addMouseListener(new HyperLinkListener());
    }

    public HyperButton(String linkName, Color backgroundColor)
    {
        this(linkName);
        setBackground(backgroundColor);
    }

    public void setRolloverColor(Color c) {
        rolloverColor = c;
    }

    @Override
    public Color getForeground() {
        return getModel().isRollover() ? rolloverColor : super.getForeground();
    }

    public void setInsets(int top, int left, int bottom, int right) {
        insets = new Insets(top, left, bottom, right);
    }

    @Override
    public Insets getInsets() {
        return insets;
    }

    private class HyperLinkListener extends MouseInputAdapter {

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            setCursor(Cursor.getDefaultCursor());
        }

    }
}
