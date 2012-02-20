package rasterbator.gui;

import rasterbator.Rasterbator;
import rasterbator.gui.assistant.AssistantPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

public class SourceFilePanel extends AssistantPage {

    private JTextField textBox1 = new JTextField();
    private FileDialog SelectRasterbationSourceDialog = new FileDialog((Dialog) null, "", FileDialog.LOAD);
    private JLabel SelectSourceImageLabel = new JLabel();
    private JButton BrowseButton1 = new JButton();

    public SourceFilePanel ()
    {
        setName(getClass().getName());
        //
        // SelectRasterbationSourceDialog
        //
//        this.SelectRasterbationSourceDialog.Filter = "Image files (*.jpg, *.png, *.gif, *.tif, *.bmp)|*.jpg;*.gif;*.png;*.tif;*.tiff;*." + "jpeg;*.bmp|All files (*.*)|*.*";
        this.SelectRasterbationSourceDialog.setTitle("Select Rasterbation source...");
//        this.SelectRasterbationSourceDialog.FileOk += new System.ComponentModel.CancelEventHandler (this.OpenFileDialog1FileOk);
        //
        // SelectSourceImageLabel
        //
//        this.SelectSourceImageLabel.Font = new System.Drawing.Font ("Tahoma", 16f, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.SelectSourceImageLabel.ForeColor = System.Drawing.SystemColors.ControlText;
//        this.SelectSourceImageLabel.Location = new System.Drawing.Point (80, 56);
        this.SelectSourceImageLabel.setName("SelectSourceImageLabel");
//        this.SelectSourceImageLabel.Size = new System.Drawing.Size (528, 24);
//        this.SelectSourceImageLabel.TabIndex = 8;
        this.SelectSourceImageLabel.setText("Select source image (1/5)");
        //
        // textBox1
        //
//        this.textBox1.Anchor = ((AnchorStyles)(((AnchorStyles.Top | AnchorStyles.Left) | AnchorStyles.Right)));
//        this.textBox1.Font = new System.Drawing.Font ("Tahoma", 16f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.textBox1.Location = new System.Drawing.Point (80, 88);
        this.textBox1.setName("textBox1");
//        this.textBox1.Size = new System.Drawing.Size (528, 27);
//        this.textBox1.TabIndex = 9;
        this.textBox1.setText("");
        this.textBox1.addPropertyChangeListener("text", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                TextBox1TextChanged();
            }
        });
//        this.textBox1.TextChanged += new System.EventHandler (this.TextBox1TextChanged);
        //
        // BrowseButton1
        //
//        this.BrowseButton1.Anchor = ((AnchorStyles)((AnchorStyles.Top | AnchorStyles.Right)));
//        this.BrowseButton1.Font = new System.Drawing.Font ("Tahoma", 15f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.BrowseButton1.Location = new System.Drawing.Point (480, 128);
        this.BrowseButton1.setName("BrowseButton1");
//        this.BrowseButton1.Size = new System.Drawing.Size (128, 28);
//        this.BrowseButton1.TabIndex = 10;
        this.BrowseButton1.setText("Browse...");
        this.BrowseButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BrowseSourceFileButtonClicked();
            }
        });
//        Click += new System.EventHandler (this.BrowseSourceFileButtonClicked);

        this.add(this.BrowseButton1);
        this.add(this.textBox1);
        this.add(this.SelectSourceImageLabel);
    }

    void TextBox1TextChanged ()
    {
        getParentControl().setContinueButtonEnabled(new File(textBox1.getText()).exists());
    }

    void BrowseSourceFileButtonClicked ()
    {
        SelectRasterbationSourceDialog.setVisible(true);
        OpenFileDialog1FileOk(); // insetad of event from dialog
    }

    void OpenFileDialog1FileOk ()
    {
        textBox1.setText(SelectRasterbationSourceDialog.getFile());
    }

    @Override
    public boolean isOkayToLeave ()
    {
        return (new File(textBox1.getText())).exists();
    }

    @Override
    public void beforeShowHandler ()
    {
        getParentControl().setContinueButtonEnabled(false);

        SelectRasterbationSourceDialog.setTitle(Rasterbator.labels.get("SelectSource").toString());
//        SelectRasterbationSourceDialog.Filter = Rasterbator.labels["SelectSourceFilter"].ToString ();
    }

    @Override
    public void afterLeaveHandler ()
    {
//        Rasterbator.currentJob.OriginalImage = Image.FromFile (textBox1.Text) as Bitmap;
//        Rasterbator.currentJob.OriginalFilename = textBox1.Text;
    }
}
