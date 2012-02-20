package rasterbator;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import rasterbator.gui.HyperButton;
import rasterbator.gui.SourceFilePanel;
import rasterbator.gui.WelcomePanel;
import rasterbator.gui.assistant.AssistantControl;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Locale;

public class Rasterbator extends JFrame {

//    public static RasterLogic logic;

    public static HashMap<String, String> labels = new HashMap<String, String>();

    //public static System.Resources    .ResourceManager resources = new System.Resources.ResourceManager("Rasterbator.src.Rasterbator", Assembly.GetExecutingAssembly());

//    public static RasterJob currentJob = new RasterJob();

//    private HeaderPanel headerPanel = new HeaderPanel();
    private AssistantControl tabControl1 = new AssistantControl();

    private WelcomePanel panel1_Welcome = new WelcomePanel();
    private SourceFilePanel panel2_SourceImage = new SourceFilePanel();
//    private PaperSizePanel panel3_PaperSize = new PaperSizePanel();
//    private OutputSizePanel panel4_OutputSize = new OutputSizePanel();
//    private OptionsPanel panel5_Options = new OptionsPanel();
//    private OutputFilePanel panel6_OutputFilename = new OutputFilePanel();
//    private RasterbatingPanel panel7_Rasterbating = new RasterbatingPanel();
//    private CompletedPanel panel8_Completed = new CompletedPanel();

//    private Size _standardPanelSize = new Size(702, 413);

//    String[] LanguageFileNames = null;
//    String ApplicationDirectory = "";
//    String ResourceDirectory = "";

    public static void main(String[] args) {
        // TODO console version
        if (args.length > 0)
            System.out.println("Command line mode not yet supported.");

        JFrame main = new Rasterbator();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);

//        Application.EnableVisualStyles();
//        Application.Run(new Rasterbator());
    }

    public Rasterbator() {
//        this.panel1_Welcome.SuspendLayout();
//        this.panel2_SourceImage.SuspendLayout();
//        this.panel3_PaperSize.SuspendLayout();
//        this.panel4_OutputSize.SuspendLayout();
//        this.panel5_Options.SuspendLayout();
//        this.panel6_OutputFilename.SuspendLayout();
//        this.panel7_Rasterbating.SuspendLayout();
//        this.panel8_Completed.SuspendLayout();
//        this.SuspendLayout();
        //
        // Panel1_Welcome
//        //
//        this.panel1_Welcome.Anchor = ((AnchorStyles) ((((AnchorStyles.Top | AnchorStyles.Bottom) | AnchorStyles.Left) | AnchorStyles.Right)));
//        this.panel1_Welcome.Size = _standardPanelSize;
//        this.panel1_Welcome.LanguageListBox.SelectedIndexChanged += new System.EventHandler(this.LanguageListBoxSelectedIndexChanged);
        this.panel1_Welcome.LanguageListBox.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                LanguageListBoxSelectedIndexChanged();
            }
        });
//        //
//        // Panel2_SourceImage
//        //
//        this.panel2_SourceImage.Anchor = ((AnchorStyles) ((((AnchorStyles.Top | AnchorStyles.Bottom) | AnchorStyles.Left) | AnchorStyles.Right)));
//        this.panel2_SourceImage.Size = _standardPanelSize;
//        //
//        // Panel3_PaperSize
//        //
//        this.panel3_PaperSize.Anchor = ((AnchorStyles) ((((AnchorStyles.Top | AnchorStyles.Bottom) | AnchorStyles.Left) | AnchorStyles.Right)));
//        this.panel3_PaperSize.Size = _standardPanelSize;
//        //
//        // Panel4_OutputSize
//        //
//        this.panel4_OutputSize.Anchor = ((AnchorStyles) ((((AnchorStyles.Top | AnchorStyles.Bottom) | AnchorStyles.Left) | AnchorStyles.Right)));
//        this.panel4_OutputSize.Size = _standardPanelSize;
//        //
//        // Panel5_Options
//        //
//        this.panel5_Options.Anchor = ((AnchorStyles) ((((AnchorStyles.Top | AnchorStyles.Bottom) | AnchorStyles.Left) | AnchorStyles.Right)));
//        this.panel5_Options.Size = _standardPanelSize;
//        //
//        // Panel6_OutputFilename
//        //
//        this.panel6_OutputFilename.Anchor = ((AnchorStyles) ((((AnchorStyles.Top | AnchorStyles.Bottom) | AnchorStyles.Left) | AnchorStyles.Right)));
//        this.panel6_OutputFilename.Size = _standardPanelSize;
//        //
//        // Panel7_Rasterbating
//        //
//        this.panel7_Rasterbating.Anchor = ((AnchorStyles) ((((AnchorStyles.Top | AnchorStyles.Bottom) | AnchorStyles.Left) | AnchorStyles.Right)));
//        this.panel7_Rasterbating.Size = _standardPanelSize;
//        //
//        // Panel8_Completed
//        //
//        this.panel8_Completed.Anchor = ((AnchorStyles) ((((AnchorStyles.Top | AnchorStyles.Bottom) | AnchorStyles.Left) | AnchorStyles.Right)));
//        this.panel8_Completed.Size = _standardPanelSize;

        //
        // MainForm
        //
        //this.AutoScaleBaseSize = new Size (5, 13);// see http://www.mono-project.com/FAQ:_Winforms#My_forms_are_sized_improperly
        //this.ClientSize = new Size (692, 523);
        //this.Resize += new System.EventHandler (this.MainFormResize);

//        headerPanel.Size = new Size(696, 128);
//        tabControl1.Location = new Point(-6, 107);
//        tabControl1.Size = _standardPanelSize;
        tabControl1.AddPage(panel1_Welcome);
        tabControl1.AddPage(panel2_SourceImage);
//        tabControl1.AddPage(panel3_PaperSize);
//        tabControl1.AddPage(panel4_OutputSize);
//        tabControl1.AddPage(panel5_Options);
//        tabControl1.AddPage(panel6_OutputFilename);
//        tabControl1.AddPage(panel7_Rasterbating);
//        tabControl1.AddPage(panel8_Completed);

//        this.Controls.Add(headerPanel);
        this.add(tabControl1);

//        this.Icon = ((Icon) (resources.GetObject("$this.Icon")));
//        this.Size = new Size(700, 550);
        this.setTitle("The Rasterbator");
//        this.Load += new System.EventHandler(this.MainFormLoad);
//        this.FormBorderStyle = FormBorderStyle.FixedSingle;
//        this.MaximizeBox = false;

//        this.panel8_Completed.ResumeLayout(false);
//        this.panel7_Rasterbating.ResumeLayout(false);
//        this.panel6_OutputFilename.ResumeLayout(false);
//        this.panel5_Options.ResumeLayout(false);
//        this.panel4_OutputSize.ResumeLayout(false);
//        this.panel3_PaperSize.ResumeLayout(false);
//        this.panel2_SourceImage.ResumeLayout(false);
//        this.panel1_Welcome.ResumeLayout(false);
//        this.ResumeLayout(false);
        MainFormLoad();
    }

    boolean CheckFile(String dir, String filename) {
        if (new File(dir + filename).exists())
            return true;
        JOptionPane.showMessageDialog(null, "Cannot find file " + filename + " - make sure it is in the installation directory (" + dir + "). Cannot continue, sorry.");
//        MessageBox.Show("Cannot find file " + filename + " - make sure it is in the installation directory (" + dir + "). Cannot continue, sorry.");
        return false;
    }

//    Control FindControl(Control Source, String s) {
//        foreach(Control C in Source.Controls) {
//            if (C.Name == s)
//                return C;
//            Control c = FindControl(C, s);
//            if (c != null)
//                return c;
//        }
//        return null;
//    }

    Component FindControl(Container source, String name){
        for (Component c : source.getComponents()) {
            if (name.equals(c.getName()))
                return c;
            if (c instanceof Container){
                Component found = FindControl((Container) c, name);
                if (found != null){
                    return found;
                }
            }
        }
        return null;
    }

    void LanguageListBoxSelectedIndexChanged() {
        try {
            labels.clear();

            String chosenFileName = LanguageFileNames[panel1_Welcome.LanguageListBox.getSelectedIndex()];
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(getClass().getResourceAsStream("languages/"+chosenFileName));
            doc.getDocumentElement().normalize();
            NodeList itemList = doc.getElementsByTagName("item");

            for (int i = 0; i < itemList.getLength(); i++){
                Node item = itemList.item(i);

                String n = getAttrValue(item, "name");
                String s = item.getTextContent();

                labels.put(n, s);

                Component c = FindControl(this, n);

                if (c instanceof JLabel)
                    ((JLabel) c).setText(s);
                else if (c instanceof AbstractButton)
                    ((AbstractButton) c).setText(s);
                else if (c instanceof JComboBox) {
                    JComboBox cb = (JComboBox) c;
                    DefaultListModel model = (DefaultListModel) cb.getModel();
                    String[] p = s.split("\\|");
                    for (int j = 0; j < p.length; j++)
                        model.set(j, p[j]);
                } else if (c instanceof HyperButton){
                    HyperButton hb = (HyperButton) c;
                    if (!s.toLowerCase().startsWith("http://"))
                        s = "";
                    try {
                        new URI(s);
                        // check
                        hb.setText(s);
                        hb.setVisible(true);
                    } catch (URISyntaxException e){
                        hb.setVisible(false);
                        hb.setText("");
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    private static final String[] LanguageFileNames = {
            "croatian.xml",
            "german.xml",
            "czech.xml",
            "italian.xml",
            "danish.xml",
            "norwegian.xml",
            "dutch.xml",
            "romanian.xml",
            "english.xml",
            "spanish.xml",
            "finnish.xml",
            "swedish.xml",
            "french.xml",
            "turkish.xml"
    };
    
    void MainFormLoad() {
        ((DefaultListModel) panel1_Welcome.LanguageListBox.getModel()).clear();
        for (String s : LanguageFileNames) {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(getClass().getResourceAsStream("languages/"+s));
                doc.getDocumentElement().normalize();
                Node root = doc.getElementsByTagName("language").item(0);

                if (root.getNodeName().equals("language")) {
                    String lt = getAttrValue(root, "nativename");

                    if (getAttrValue(root, "englishname") != null)
                        lt = getAttrValue(root, "englishname") + " (" + lt + ")";

                    ((DefaultListModel) panel1_Welcome.LanguageListBox.getModel()).addElement(lt);
                    String ISOLanguageName = getAttrValue(root, "TwoLetterISOLanguageName");
                    if (lt.toLowerCase().equals("english") & (panel1_Welcome.LanguageListBox.getSelectedIndex() == -1)) {
                        panel1_Welcome.LanguageListBox.setSelectedIndex(panel1_Welcome.LanguageListBox.getModel().getSize() - 1);
                    }
//                    if (ISOLanguageName == System.Globalization.CultureInfo.CurrentCulture.TwoLetterISOLanguageName) {
                    if (ISOLanguageName.equals(Locale.getDefault().getLanguage())) {
                        panel1_Welcome.LanguageListBox.setSelectedIndex(panel1_Welcome.LanguageListBox.getModel().getSize() - 1);
                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error in language data file " + s + " - " + e.getMessage());
            }
        }

        if (panel1_Welcome.LanguageListBox.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "Could not find any language files. Please extract the language directory from the archive file.");
            System.exit(1);
        }
    }
    
    private static String getAttrValue(Node n, String attr){
        NamedNodeMap map = n.getAttributes();
        Node attrNode = map.getNamedItem(attr);
        if (attrNode != null){
            return attrNode.getNodeValue();
        }
        return null;
    }
}



