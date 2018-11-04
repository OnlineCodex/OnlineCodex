package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMKorsarroKhan extends Eintrag {

    boolean addedSpezialAuswahl = false; // spezialauswahl ist abhängig von "Space Marine bike"
    OptionsEinzelUpgrade o1;

    public SMKorsarroKhan() {
        name = "Kor'sarro Khan";
        grundkosten = 125;

        addToInformationVector("Kor'sarro Khan", 1);

        add(ico = new oc.Picture("oc/wh40k/images/SMKorsarroKhan.gif"));

        seperator();

        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Monddrache", 25));

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);

        if (o1.isSelected() && !addedSpezialAuswahl) {
            addToInformationVector("SMEnableBikes", 1);
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Bike Squad");
            addedSpezialAuswahl = true;
        } else if (!o1.isSelected() && addedSpezialAuswahl) {
            addToInformationVector("SMEnableBikes", -1);
            if (getCountFromInformationVector("SMEnableBikes") < 1) {
                BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Bike Squad");
                BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Bike Squad");
            }
            addedSpezialAuswahl = false;
        }

        //Detachment
        boolean max1Error = false;
        boolean maxMixError = false;
        if (getCountFromInformationVector("Battle Company") > 0) {
            int i1 = getCountFromInformationVector("Chaplain");
            int i2 = getCountFromInformationVector("Captain") + getCountFromInformationVector("Captain Sicarius") + getCountFromInformationVector("Kor'sarro Khan") +
                    getCountFromInformationVector("Vulkan He'stan") + getCountFromInformationVector("Shadow Captain Shrike");
            if (i1 != 1 || i2 != 1) {
                maxMixError = true;
            }
        } else if (getCountFromInformationVector("Strike Force Command") > 0) {
            int i = getCountFromInformationVector("Captain Sicarius") + getCountFromInformationVector("Captain") + getCountFromInformationVector("Chaplain") +
                    getCountFromInformationVector("Chaplain Cassius") + getCountFromInformationVector("Chaplain Grimaldus") + getCountFromInformationVector("Kor'sarro Khan") +
                    getCountFromInformationVector("Vulkan He'stan") + getCountFromInformationVector("Shadow Captain Shrike") + getCountFromInformationVector("Marneus Calgar") +
                    getCountFromInformationVector("Pedro Kantor") + getCountFromInformationVector("High Marshal Helbrecht");
            if (i > 1) {
                max1Error = true;
            }
        }
        //Errors
        if (maxMixError) {
            setFehlermeldung("1 Chapl. + 1 Capt.");
        } else if (max1Error) {
            setFehlermeldung("Genau 1");
        } else if (getCountFromInformationVector("SMWhiteScars") != 1) {
            setFehlermeldung("Keine White Scars");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("Kor'sarro Khan", -1);
        if (addedSpezialAuswahl) {
            addToInformationVector("SMEnableBikes", -1);
            if (getCountFromInformationVector("SMEnableBikes") < 1) {
                BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Bike Squad");
                BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Bike Squad");
            }
        }
        super.deleteYourself();
    }

}
