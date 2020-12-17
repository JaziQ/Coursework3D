package mainPackage;

import mainPackage.geometry.Model;
import mainPackage.window.mainFrame.MainFrame;
import mainPackage.window.optionsFrame.OptionFrame;

public class Main {
    private static Model model;
    private static MainFrame mainFrame;
    private static OptionFrame optionFrame;

    public static void main(String[] args) {
        mainFrame = new MainFrame("NOSKOVA <3");
        optionFrame = new OptionFrame(mainFrame);
    }

    public static Model getModel() {
        return model;
    }

    public static void setModel(int a, int b, int c, int dY, int dZ, int h, int r, int app) {
        model = new Model(a, b, c, dY, dZ, h, r, app);
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    public static OptionFrame getOptionFrame() {
        return optionFrame;
    }
}
