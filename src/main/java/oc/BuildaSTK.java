package oc;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;

public interface BuildaSTK { // konstanten die überall im oC geraucht werden

    final static int BILDSCHIRMHÖHE = Toolkit.getDefaultToolkit().getScreenSize().height;
    final static int BILDSCHIRMBREITE = Toolkit.getDefaultToolkit().getScreenSize().width;
    final static int buttonBreite = 230;
    final static int buttonHoehe = 18;
    final static int buttonAbstandY = 2;
    final static int DEFAULT_KAMMERSTARTER_Abstand_Y = 5;
    final static int CHOOSER_Y = 9000;
    final static int CHOOSERGRUPPEN_X_ABSTAND = 420;
    final static int CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND = 80;
    final static int KAMMER_HOEHE = 85;
    final static int MAXIMAL_OPTIONS_WIDTH = 260;
    final static int BUILDAVATER_TEXTAREA_MAXROWS = 37; // ab wievielen Zeilenumbrüchen die verticale Scrollleiste eingeblendet wird
    final static int auswahlBreite = 400;
    final static int randAbstand = 10;
    final static int einrueckAbstand = 15;
    final static int headlineAbstand = 30;
    final static String punkteAbstandHalter = "   ";
    final static String ZEILENUMBRUCH = "\n"; // ACHTUNG: Wird nicht nur in der Ameelistentextarea benutzt!   z.b. auch im BuildaMenu oda bei getLabel() bei einzelUpgrade / einzelZähler

    final static int DEFAULT_MAUSWHEELLSPEED = 40;
    final static int DEFAULT_PFEILTASTENSPEED = 50;

    public static String JPG = ".jpg";

    final static String SAVETEXT_DETACHMENTTRENNER = "_8T";
    final static String SAVETEXT_DETACHMENTTYPTRENNER1 = "_9T";
    final static String SAVETEXT_DETACHMENTTYPTRENNER2 = "_10T";
    final static String SAVETEXT_DETACHMENTTYPTRENNER3 = "_11T";
    final static String SAVETEXT_FARSIGHT = "_13T";
    final static String SAVETEXT_CADIANS = "_14T";
    final static String SAVETEXT_RAUKAAN = "_15T";
    final static String SAVETEXT_SOT = "_16T";
    final static String SAVETEXT_SUBDETACHMENTTRENNER = "_12T";
    final static String SAVETEXT_TRENNER1 = "_1T";
    final static String SAVETEXT_TRENNER1_5 = "_2T"; // Rüstkammercomponententrenner. Beim laden von Rüstkammern das hier übergeben
    final static String SAVETEXT_TRENNER1_6 = "_2U"; // Rüstkammercomponententrenner. Beim laden von Rüstkammern das hier übergeben
    final static String SAVETEXT_TRENNER2 = "_3T"; // Eintragcomponententrenner. Beim loaden für Einträge das hier übergeben
    final static String SAVETEXT_TRENNER3 = "_4T"; // trennt die chooser
    final static String SAVETEXT_TRENNER4 = "_5T"; // trennt Choosergruppen
    final static String SAVETEXT_TRENNER5 = "_6T"; // trennt Zusatzinfos vom Rest
    final static String SAVETEXT_TRENNER6 = "_7T"; // trennt Zusatzinfos vom Rest
    final static String SAVETEXT_UEBERSCHRIFTTRENNER1 = "_1H"; // trennt name des Eintrags vom Eintrag selbst
    final static String SAVETEXT_UEBERSCHRIFTTRENNER2 = "_2H"; // trennt name des Volkes von allem anderen!
    final static String SAVETEXT_SELECTEDTRENNER = "|"; // RuestkammerStarter
    final static String SAVETEXT_PANELSWITCHERTRENNER = "_1P"; // OptionsPanelSwitcher
    final static String SAVETEXT_CURRNETPANELTRENNER = "_2P"; // OptionsPanelSwitcher

    final static String PREFERENCES_SAVE_DIRECTORY = "saveDirectory";
    final static String PREFERENCES_LOAD_DIRECTORY = "loadDirectory";
    final static String PREFERENCES_SHOW_PICTURES = "showPictures";
    final static String PREFERENCES_ENABLE_APOCALYPSE = "enableApocalpyse";
    final static String PREFERENCES_SCROLL_VERTICAL = "scrollVertical";
    final static String PREFERENCES_MOUSE_WHEEL_SPEED = "mouseWheelSpeed";
    final static String PREFERENCES_ARROW_KEYS_SPEED = "arrowKeysSpeed";

    final static String ELEMENT_NAME_CATEGORY = "Category";
    final static String ELEMENT_NAME_SONSTIGESGRUPPE = "CategoryNecro";
    final static String ELEMENT_NAME_ONLINECODEX = "OnlineCodex";
    final static String ELEMENT_NAME_COUNTER = "Counter";

    final static Border redBorder = BorderFactory.createLineBorder(Color.red);
    final static Border blackBorder = BorderFactory.createLineBorder(Color.black);
    final static int[] kategorienMaxAnzahl = {
            OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 2 : 1,
            OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 3 : 2,
            OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 6 : 99,
            OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 3 : 99,
            OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 3 : 99,
            OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 99 : OnlineCodex.getGame() == OnlineCodex.WH40K || OnlineCodex.getGame() == OnlineCodex.WH40K_LEGACY || OnlineCodex.getGame() == OnlineCodex.WH40K_FANDEX ? 1 : 99,
            99,
            99,
            99
    };
    final static int[] kategorienMinAnzahl = {
            OnlineCodex.getGame() == OnlineCodex.WHFB || OnlineCodex.getGame() == OnlineCodex.WHFB_LEGACY ? 0 : 1,
            0,
            OnlineCodex.getGame() == OnlineCodex.NECROMUNDA ? 0 : 2,
            0,
            0,
            0,
            0,
            0,
            0
    };

    final static int[] kategorienMaxProzent = {
            25,
            25,
            100,
            50,
            25,
            0,
            0,
            0,
            0
    };

    final static int[] kategorienMinProzent = {
            0,
            0,
            25,
            0,
            0,
            0,
            0,
            0,
            0
    };

    String[] spalte1Sg = {"Additional Info"};
    String[] spalte2Sg = {"HQ", "Kommandant", "Gangboss", "HQ", "Kommandant", "HQ"};
    String[] spalte3Sg = {"Standard", "Held", "Spezialist", "Elite", "Held", "Elite"};
    String[] spalte4Sg = {"Elite", "Kerneinheit", "Ganger", "Standard", "Kerneinheit", "Standard"};
    String[] spalte5Sg = {"Sturm", "Eliteeinheit", "Kid", "Sturm", "Eliteeinheit", "Sturm"};
    String[] spalte6Sg = {"Unterstützung", "Seltene Einheit", "Söldner", "Unterstützung", "Seltene Einheit", "Unterstützung"};
    String[] spalte7Sg = {"Transporter", "Befestigung", "Befestigung", "Befestigung", "Befestigung", "Befestigung"};
    String[] spalte8Sg = {"Flieger", "Lord of War", "Lord of War", "Lord of War", "Lord of War", "Lord of War"};
    String[] spalte9Sg = {"Befestigung", "Formation", "Formation", "Formation", "Formation", "Formation"};
    String[] spalte10Sg = {"Lord of War", "Formation", "Formation", "Formation", "Formation", "Formation"};

    String[] spalte1Pl = {"Additional Info"};
    String[] spalte2Pl = {"HQ", "Kommandanten", "Gangbosse", "HQ", "Kommandanten", "HQ"};
    String[] spalte3Pl = {"Standard", "Helden", "Spezialisten", "Elite", "Helden", "Elite"};
    String[] spalte4Pl = {"Elite", "Kerneinheiten", "Ganger", "Standard", "Kerneinheiten", "Standard"};
    String[] spalte5Pl = {"Sturm", "Eliteeinheiten", "Kids", "Sturm", "Eliteeinheiten", "Sturm"};
    String[] spalte6Pl = {"Unterstützung", "Seltene Einheiten", "Söldner", "Unterstützung", "Seltene Einheiten", "Unterstützung"};
    String[] spalte7Pl = {"Transporter", "Befestigungen", "Befestigungen", "Befestigungen", "Befestigungen", "Befestigungen"};
    String[] spalte8Pl = {"Flieger", "Lords of War", "Lords of War", "Lords of War", "Lords of War", "Lords of War"};
    String[] spalte9Pl = {"Befestigungen", "Formationen", "Formationen", "Formationen", "Formationen", "Formationen"};
    String[] spalte10Pl = {"Lords of War", "Formationen", "Formationen", "Formationen", "Formationen", "Formationen"};

    final static String[] gerSg = {
            spalte1Sg[OnlineCodex.getGame()],
            spalte2Sg[OnlineCodex.getGame()],
            spalte3Sg[OnlineCodex.getGame()],
            spalte4Sg[OnlineCodex.getGame()],
            spalte5Sg[OnlineCodex.getGame()],
            spalte6Sg[OnlineCodex.getGame()],
            spalte7Sg[OnlineCodex.getGame()],
            spalte8Sg[OnlineCodex.getGame()],
            spalte9Sg[OnlineCodex.getGame()],
            spalte10Sg[OnlineCodex.getGame()]
    };
    final static String[] gerPl = {
            spalte1Pl[OnlineCodex.getGame()],
            spalte2Pl[OnlineCodex.getGame()],
            spalte3Pl[OnlineCodex.getGame()],
            spalte4Pl[OnlineCodex.getGame()],
            spalte5Pl[OnlineCodex.getGame()],
            spalte6Pl[OnlineCodex.getGame()],
            spalte7Pl[OnlineCodex.getGame()],
            spalte8Pl[OnlineCodex.getGame()],
            spalte9Pl[OnlineCodex.getGame()],
            spalte10Pl[OnlineCodex.getGame()]
    };
    final static String[] engSg = {"", "HQ", "Troop", "Elite", "Fast Attack", "Heavy Support", "Transporter", "Flyer", "Fortification", "Lord of War", "Additional Information"};
    final static String[] engPl = {"", "HQ", "Troops", "Elites", "Fast Attack", "Heavy Supports", "Transporter", "Flyer", "Fortification", "Lords of War", "Additional Information"};
    final static String[] gerNullText = {
            "",
            "keine",
            "kein",
            "kein",
            "keine",
            "kein",
            "keine",
            "keine",
            "keine",
            "keine",
            "kein"
    };
    final static String[] engNullText = {"", "no", "no", "no", "no", "no", "no", "no", "no", "no", "no"};

    final static int AI = 0;
    final static int HQ = 1;
    final static int TR = 2;
    final static int EL = 3;
    final static int FA = 4;
    final static int HS = 5;
    final static int DT = 6;
    final static int FL = 7;
    final static int FORT = 8;
    final static int LOW = 9;

    final static HashMap<String, String> volkMap = new HashMap<String, String>() {
        {
            put("CU", "VOLKCultMechanicus");
            put("IR", "VOLKImperialeRitter");
            put("SK", "VOLKSkitarii");
        }
    };
}
