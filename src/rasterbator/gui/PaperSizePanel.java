package rasterbator.gui;

import rasterbator.Rasterbator;
import rasterbator.gui.assistant.AssistantPage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PaperSizePanel extends AssistantPage {

    private JLabel PortraitSymbol = new JLabel();
    private JLabel LandscapeSymbol = new JLabel();
    private JComboBox PaperAlignCombo = new JComboBox();
    private JComboBox PaperSizeCombo = new JComboBox();
    private JLabel PaperSizeLabel = new JLabel();
    private JSpinner numericUpDown1 = new JSpinner();
    private JSpinner numericUpDown2 = new JSpinner();
    private JLabel label7 = new JLabel();
    private JLabel label8 = new JLabel();
    private JRadioButton StandardPaperRadio = new JRadioButton();
    private JRadioButton CustomPaperRadio = new JRadioButton();
    private JLabel WidthLabel = new JLabel();
    private JLabel HeightLabel = new JLabel();

    public PaperSizePanel ()
    {
//        ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).BeginInit ();
//        ((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).BeginInit ();

        BufferedImage PORTRAIT;
        BufferedImage LANDSCAPE;
        try {
            PORTRAIT = ImageIO.read(getClass().getResourceAsStream("ProtraitSymbol.Image"));
            LANDSCAPE = ImageIO.read(getClass().getResourceAsStream("LandscapeSymbol.Image"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //
        // PortraitSymbol
        //
        this.PortraitSymbol.setIcon(new ImageIcon(PORTRAIT));
//        this.PortraitSymbol.Location = new Point (504, 128);
        this.PortraitSymbol.setName("PortraitSymbol");
//        this.PortraitSymbol.Size = new Size (42, 42);
//        this.PortraitSymbol.TabIndex = 23;
//        this.PortraitSymbol.TabStop = false;
        //
        // LandscapeSymbol
        //
        this.LandscapeSymbol.setIcon(new ImageIcon(LANDSCAPE));
//        this.LandscapeSymbol.Location = new Point (504, 128);
        this.LandscapeSymbol.setName("LandscapeSymbol");
//        this.LandscapeSymbol.Size = new Size (42, 42);
//        this.LandscapeSymbol.TabIndex = 22;
//        this.LandscapeSymbol.TabStop = false;
        //
        // PaperSizeLabel
        //
//        this.PaperSizeLabel.Font = new System.Drawing.Font ("Tahoma", 16f, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.PaperSizeLabel.ForeColor = System.Drawing.SystemColors.ControlText;
//        this.PaperSizeLabel.Location = new System.Drawing.Point (80, 56);
        this.PaperSizeLabel.setName("PaperSizeLabel");
//        this.PaperSizeLabel.Size = new System.Drawing.Size (536, 24);
//        this.PaperSizeLabel.TabIndex = 8;
        this.PaperSizeLabel.setText("Select paper size (2/5)");
        //
        // PaperAlignCombo
        //
//        this.PaperAlignCombo.DropDownStyle = ComboBoxStyle.DropDownList;
//        this.PaperAlignCombo.Font = new System.Drawing.Font ("Tahoma", 15f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
        this.PaperAlignCombo.setModel(new DefaultComboBoxModel(new Object[]{"Portrait", "Landscape"}));
//        this.PaperAlignCombo.Items.AddRange (new object[] { "Portrait", "Landscape" });
//        this.PaperAlignCombo.Location = new System.Drawing.Point (368, 136);
        this.PaperAlignCombo.setName("PaperAlignCombo");
//        this.PaperAlignCombo.Size = new System.Drawing.Size (120, 26);
//        this.PaperAlignCombo.TabIndex = 20;
        this.PaperAlignCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                ComboBox2SelectedIndexChanged();
            }
        });
//        this.PaperAlignCombo.SelectedIndexChanged += new System.EventHandler (this.ComboBox2SelectedIndexChanged);
        //
        // PaperSizeCombo
        //
//        this.PaperSizeCombo.DropDownStyle = ComboBoxStyle.DropDownList;
//        this.PaperSizeCombo.Font = new System.Drawing.Font ("Tahoma", 15f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
        this.PaperSizeCombo.setModel(new DefaultComboBoxModel(new Object[] { "A4 (210x297 mm)", "A3 (297x420 mm)", "US Letter (216x279 mm)", "US Legal (216x356 mm)" }));
//        this.PaperSizeCombo.Items.AddRange (new object[] { "A4 (210x297 mm)", "A3 (297x420 mm)", "US Letter (216x279 mm)", "US Legal (216x356 mm)" });
//        this.PaperSizeCombo.Location = new System.Drawing.Point (128, 136);
        this.PaperSizeCombo.setName("PaperSizeCombo");
//        this.PaperSizeCombo.Size = new System.Drawing.Size (224, 26);
//        this.PaperSizeCombo.TabIndex = 19;
        //
        // HeightLabel
        //
//        this.HeightLabel.Font = new System.Drawing.Font ("Tahoma", 16f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.HeightLabel.ForeColor = System.Drawing.SystemColors.ControlText;
//        this.HeightLabel.Location = new System.Drawing.Point (136, 264);
        this.HeightLabel.setName("HeightLabel");
//        this.HeightLabel.Size = new System.Drawing.Size (80, 24);
//        this.HeightLabel.TabIndex = 15;
        this.HeightLabel.setText("Height");
        //
        // WidthLabel
        //
//        this.WidthLabel.Font = new System.Drawing.Font ("Tahoma", 16f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.WidthLabel.ForeColor = System.Drawing.SystemColors.ControlText;
//        this.WidthLabel.Location = new System.Drawing.Point (136, 232);
        this.WidthLabel.setName("WidthLabel");
//        this.WidthLabel.Size = new System.Drawing.Size (64, 24);
//        this.WidthLabel.TabIndex = 13;
        this.WidthLabel.setText("Width");
        //
        // numericUpDown1
        //
        this.numericUpDown1.setEnabled(false);
//        this.numericUpDown1.Font = new System.Drawing.Font ("Tahoma", 16f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.numericUpDown1.Location = new System.Drawing.Point (216, 232);
//        this.numericUpDown1.Maximum = new System.Decimal (new int[] { 10000, 0, 0, 0 });
//        this.numericUpDown1.Minimum = new System.Decimal (new int[] { 50, 0, 0, 0 });
        this.numericUpDown1.setName("numericUpDown1");
//        this.numericUpDown1.Size = new System.Drawing.Size (80, 27);
//        this.numericUpDown1.TabIndex = 14;
//        this.numericUpDown1.Value = new System.Decimal (new int[] { 200, 0, 0, 0 });
        this.numericUpDown1.setValue(200);
        //
        // numericUpDown2
        //
        this.numericUpDown2.setEnabled(false);
//        this.numericUpDown2.Font = new System.Drawing.Font ("Tahoma", 16f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.numericUpDown2.Location = new System.Drawing.Point (216, 264);
//        this.numericUpDown2.Maximum = new System.Decimal (new int[] { 10000, 0, 0, 0 });
//        this.numericUpDown2.Minimum = new System.Decimal (new int[] { 50, 0, 0, 0 });
        this.numericUpDown2.setName("numericUpDown2");
//        this.numericUpDown2.Size = new System.Drawing.Size (80, 27);
//        this.numericUpDown2.TabIndex = 16;
//        this.numericUpDown2.Value = new System.Decimal (new int[] { 200, 0, 0, 0 });
        this.numericUpDown2.setValue(200);
        //
        // CustomPaperRadio
        //
//        this.CustomPaperRadio.Font = new System.Drawing.Font ("Tahoma", 16f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.CustomPaperRadio.Location = new System.Drawing.Point (88, 200);
        this.CustomPaperRadio.setName("CustomPaperRadio");
//        this.CustomPaperRadio.Size = new System.Drawing.Size (488, 24);
//        this.CustomPaperRadio.TabIndex = 12;
        this.CustomPaperRadio.setText("Use custom paper size");
        this.CustomPaperRadio.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                RadioButton2CheckedChanged();
            }
        });
//        this.CustomPaperRadio.CheckedChanged += new System.EventHandler (this.RadioButton2CheckedChanged);
        //
        // StandardPaperRadio
        //
        this.StandardPaperRadio.setSelected(true);
//        this.StandardPaperRadio.Font = new System.Drawing.Font ("Tahoma", 16f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.StandardPaperRadio.Location = new System.Drawing.Point (88, 112);
        this.StandardPaperRadio.setName("StandardPaperRadio");
//        this.StandardPaperRadio.Size = new System.Drawing.Size (480, 24);
//        this.StandardPaperRadio.TabIndex = 11;
//        this.StandardPaperRadio.TabStop = true;
        this.StandardPaperRadio.setText("Use standard paper size");
        this.StandardPaperRadio.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                RadioButton2CheckedChanged();
            }
        });
//        this.StandardPaperRadio.CheckedChanged += new System.EventHandler (this.RadioButton2CheckedChanged);
        //
        // label7
        //
//        this.label7.Font = new System.Drawing.Font ("Tahoma", 16f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.label7.ForeColor = System.Drawing.SystemColors.ControlText;
//        this.label7.Location = new System.Drawing.Point (304, 264);
        this.label7.setName("label7");
//        this.label7.Size = new System.Drawing.Size (48, 24);
//        this.label7.TabIndex = 18;
        this.label7.setText("mm");
        //
        // label8
        //
//        this.label8.Font = new System.Drawing.Font ("Tahoma", 16f, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.World, ((System.Byte)(0)));
//        this.label8.ForeColor = System.Drawing.SystemColors.ControlText;
//        this.label8.Location = new System.Drawing.Point (304, 232);
        this.label8.setName("label8");
//        this.label8.Size = new System.Drawing.Size (48, 24);
//        this.label8.TabIndex = 17;
        this.label8.setText("mm");

//        ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).EndInit ();
//        ((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).EndInit ();

        this.add(this.PortraitSymbol);
        this.add(this.LandscapeSymbol);
        this.add(this.PaperAlignCombo);
        this.add(this.PaperSizeCombo);
        this.add(this.label7);
        this.add(this.label8);
        this.add(this.numericUpDown1);
        this.add(this.numericUpDown2);
        this.add(this.HeightLabel);
        this.add(this.WidthLabel);
        this.add(this.CustomPaperRadio);
        this.add(this.StandardPaperRadio);
        this.add(this.PaperSizeLabel);
    }

    void ComboBox2SelectedIndexChanged ()
    {
        PortraitSymbol.setVisible(PaperAlignCombo.getSelectedIndex() == 0);
        LandscapeSymbol.setVisible(PaperAlignCombo.getSelectedIndex() == 1);
    }

    void RadioButton2CheckedChanged ()
    {
        PaperSizeCombo.setEnabled(StandardPaperRadio.isSelected());
        PaperAlignCombo.setEnabled(StandardPaperRadio.isSelected());
        numericUpDown1.setEnabled(CustomPaperRadio.isSelected());
        numericUpDown2.setEnabled(CustomPaperRadio.isSelected());
    }

    @Override
    public void beforeShowHandler ()
    {
        if (PaperSizeCombo.getSelectedIndex() < 0)
            PaperSizeCombo.setSelectedIndex(0);
        if (PaperAlignCombo.getSelectedIndex() < 0)
            PaperAlignCombo.setSelectedIndex(0);
    }

    @Override
    public void afterLeaveHandler ()
    {
        if (StandardPaperRadio.isSelected()) {
            int s1 = 0, s2 = 0;
            switch (PaperSizeCombo.getSelectedIndex()) {
                case 0:
                    s1 = 210;
                    s2 = 297;
                    break;
                case 1:
                    s1 = 297;
                    s2 = 420;
                    break;
                case 2:
                    s1 = 216;
                    s2 = 279;
                    break;
                case 3:
                    s1 = 216;
                    s2 = 356;
                    break;
            }

            if (PaperAlignCombo.getSelectedIndex() == 0) {
                Rasterbator.currentJob.PaperWidthDecimal = s1;
                Rasterbator.currentJob.PaperHeightDecimal = s2;
            } else {
                Rasterbator.currentJob.PaperWidthDecimal = s2;
                Rasterbator.currentJob.PaperHeightDecimal = s1;
            }

        } else {
            Rasterbator.currentJob.PaperWidthDecimal = (Integer) numericUpDown1.getValue();
            Rasterbator.currentJob.PaperHeightDecimal = (Integer) numericUpDown2.getValue();
        }
    }

}
