package oc;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;

public interface BuildaSTK { // konstanten die überall im oC geraucht werden

    int BILDSCHIRMHÖHE = Toolkit.getDefaultToolkit().getScreenSize().height;
    int BILDSCHIRMBREITE = Toolkit.getDefaultToolkit().getScreenSize().width;
    int buttonBreite = 230;
    int buttonHoehe = 18;
    int buttonAbstandY = 2;
    int DEFAULT_KAMMERSTARTER_Abstand_Y = 5;
    int CHOOSER_Y = 9000;
    int CHOOSERGRUPPEN_X_ABSTAND = 420;
    int CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND = 80;
    int KAMMER_HOEHE = 85;
    int MAXIMAL_OPTIONS_WIDTH = 260;
    int BUILDAVATER_TEXTAREA_MAXROWS = 37; // ab wievielen Zeilenumbrüchen die verticale Scrollleiste eingeblendet wird
    int auswahlBreite = 400;
    int randAbstand = 10;
    int einrueckAbstand = 15;
    int headlineAbstand = 30;
    String punkteAbstandHalter = "   ";
    String ZEILENUMBRUCH = "\n"; // ACHTUNG: Wird nicht nur in der Ameelistentextarea benutzt!   z.b. auch im BuildaMenu oda bei getLabel() bei einzelUpgrade / einzelZähler

    int DEFAULT_MAUSWHEELLSPEED = 40;
    int DEFAULT_PFEILTASTENSPEED = 50;

    String JPG = ".jpg";

    String SAVETEXT_DETACHMENTTRENNER = "_8T";
    String SAVETEXT_DETACHMENTTYPTRENNER1 = "_9T";
    String SAVETEXT_DETACHMENTTYPTRENNER2 = "_10T";
    String SAVETEXT_DETACHMENTTYPTRENNER3 = "_11T";
    String SAVETEXT_FARSIGHT = "_13T";
    String SAVETEXT_CADIANS = "_14T";
    String SAVETEXT_RAUKAAN = "_15T";
    String SAVETEXT_SOT = "_16T";
    String SAVETEXT_SUBDETACHMENTTRENNER = "_12T";
    String SAVETEXT_TRENNER1 = "_1T";
    String SAVETEXT_TRENNER1_5 = "_2T"; // Rüstkammercomponententrenner. Beim laden von Rüstkammern das hier übergeben
    String SAVETEXT_TRENNER1_6 = "_2U"; // Rüstkammercomponententrenner. Beim laden von Rüstkammern das hier übergeben
    String SAVETEXT_TRENNER2 = "_3T"; // Eintragcomponententrenner. Beim loaden für Einträge das hier übergeben
    String SAVETEXT_TRENNER3 = "_4T"; // trennt die chooser
    String SAVETEXT_TRENNER4 = "_5T"; // trennt Choosergruppen
    String SAVETEXT_TRENNER5 = "_6T"; // trennt Zusatzinfos vom Rest
    String SAVETEXT_TRENNER6 = "_7T"; // trennt Zusatzinfos vom Rest
    String SAVETEXT_UEBERSCHRIFTTRENNER1 = "_1H"; // trennt name des Eintrags vom Eintrag selbst
    String SAVETEXT_UEBERSCHRIFTTRENNER2 = "_2H"; // trennt name des Volkes von allem anderen!
    String SAVETEXT_SELECTEDTRENNER = "|"; // RuestkammerStarter
    String SAVETEXT_PANELSWITCHERTRENNER = "_1P"; // OptionsPanelSwitcher
    String SAVETEXT_CURRNETPANELTRENNER = "_2P"; // OptionsPanelSwitcher

    String PREFERENCES_SAVE_DIRECTORY = "saveDirectory";
    String PREFERENCES_LOAD_DIRECTORY = "loadDirectory";
    String PREFERENCES_SHOW_PICTURES = "showPictures";
    String PREFERENCES_ENABLE_APOCALYPSE = "enableApocalpyse";
    String PREFERENCES_SCROLL_VERTICAL = "scrollVertical";
    String PREFERENCES_MOUSE_WHEEL_SPEED = "mouseWheelSpeed";
    String PREFERENCES_ARROW_KEYS_SPEED = "arrowKeysSpeed";

    String ELEMENT_NAME_CATEGORY = "Category";
    String ELEMENT_NAME_SONSTIGESGRUPPE = "CategoryNecro";
    String ELEMENT_NAME_ONLINECODEX = "OnlineCodex";
    String ELEMENT_NAME_COUNTER = "Counter";

    Border blackBorder = BorderFactory.createLineBorder(Color.black);

    int[] kategorienMaxProzent = {
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

    int[] kategorienMinProzent = {
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

    String[] gerSg = {
            "Additional Info",
            "HQ",
            "Standard",
            "Elite",
            "Sturm",
            "Unterstützung",
            "Transporter",
            "Flieger",
            "Befestigung",
            "Lord of War",
    };
    String[] gerPl = {
            "Additional Info",
            "HQ",
            "Standard",
            "Elite",
            "Sturm",
            "Unterstützung",
            "Transporter",
            "Flieger",
            "Befestigungen",
            "Lords of War",
    };
    String[] engSg = {"", "HQ", "Troop", "Elite", "Fast Attack", "Heavy Support", "Transporter", "Flyer", "Fortification", "Lord of War", "Additional Information"};
    String[] engPl = {"", "HQ", "Troops", "Elites", "Fast Attack", "Heavy Supports", "Transporter", "Flyer", "Fortification", "Lords of War", "Additional Information"};
    String[] gerNullText = {
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
    String[] engNullText = {"", "no", "no", "no", "no", "no", "no", "no", "no", "no", "no"};

    int AI = 0;
    int HQ = 1;
    int TROOPS = 2;
    int ELITE = 3;
    int FAST_ATTACK = 4;
    int HEAVY_SUPPORT = 5;
    int DEDICATED_TRANSPORT = 6;
    int FLIER = 7;
    int FORTIFICATION = 8;
    int LORD_OF_WAR = 9;

    HashMap<String, String> volkMap = new HashMap<String, String>() {
        {
            put("CU", "VOLKCultMechanicus");
            put("IR", "VOLKImperialeRitter");
            put("SK", "VOLKSkitarii");
        }
    };
}
