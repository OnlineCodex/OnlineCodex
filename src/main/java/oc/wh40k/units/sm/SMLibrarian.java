package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class SMLibrarian extends Eintrag {

    boolean addedSpezialAuswahl = false; // spezialauswahl ist abhängig von "Space Marine bike"
    OptionsEinzelUpgrade termi;
    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter spezialAusruestung;

    public SMLibrarian() {
        name = "Librarian";
        grundkosten = 65;

        addToInformationVector("Librarian", 1);

        add(ico = new oc.Picture("oc/wh40k/images/SMSpaceMarineScriptor.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 2", 25));

        seperator();

        add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 25));

        seperator();

        termiWaffen = new RuestkammerStarter(ID, randAbstand, cnt, "SMTerminatorwaffen", "");
        termiWaffen.initKammer(false, false, true);
        termiWaffen.setButtonText(BuildaHQ.translate("Terminatorwaffen & Reliquien"));
        add(termiWaffen);

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "SMWaffenUndReliquien", "");
        // Kompaniemeister, Absolutionspriester, Ordenspriester, Skriptor, Techmarine
        waffenUndReliquien.initKammer(false, false, false, true, false, false);
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        seperator();

        spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "SMSpezialausruestung", "");
        spezialAusruestung.initKammer(false, true, false);
        spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
        add(spezialAusruestung);

        complete();
    }

    @Override
    public void refreshen() {

        if (termi.isSelected()) {
            waffenUndReliquien.setAktiv(false);
            termiWaffen.setAbwaehlbar(false);
            termiWaffen.setAktiv(true);
        } else {
            waffenUndReliquien.setAktiv(true);
            termiWaffen.setAbwaehlbar(false);
            termiWaffen.setAktiv(false);
        }

        termi.setAktiv(!((SMSpezialausruestung) spezialAusruestung.getKammer()).o1.isSelected("Sprungmodul"));

        spezialAusruestung.getKammer().switchEntry("Sprungmodul", termi.isSelected());

        // Biker freischalten
        ((SMSpezialausruestung) spezialAusruestung.getKammer()).isTermi = termi.isSelected();
        ((SMSpezialausruestung) spezialAusruestung.getKammer()).isWraith = ((SMWaffenUndReliquien) waffenUndReliquien.getKammer()).wraithOfTheHeavensBool;
        ((SMSpezialausruestung) spezialAusruestung.getKammer()).isRaven = ((SMWaffenUndReliquien) waffenUndReliquien.getKammer()).ravensFuryBool;

        if ((((SMSpezialausruestung) spezialAusruestung.getKammer()).o1.isSelected("Space-Marine-Bike") || ((SMWaffenUndReliquien) waffenUndReliquien.getKammer()).wraithOfTheHeavensBool) && !addedSpezialAuswahl) {
            addToInformationVector("SMEnableBikes", 1);
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
            BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Bike Squad");
            addedSpezialAuswahl = true;
        } else if (!((SMSpezialausruestung) spezialAusruestung.getKammer()).o1.isSelected("Space-Marine-Bike") && !((SMWaffenUndReliquien) waffenUndReliquien.getKammer()).wraithOfTheHeavensBool && addedSpezialAuswahl) {
            addToInformationVector("SMEnableBikes", -1);
            if (getCountFromInformationVector("SMEnableBikes") < 1) {
                BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Bike Squad");
                BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Bike Squad");
            }
            addedSpezialAuswahl = false;
        }

        //Detachments
        boolean max1Error = false;
        if (getCountFromInformationVector("Librarius Conclave") > 0) {
            int i = getCountFromInformationVector("Librarian");
            if (i > 5 || i < 3) {
                max1Error = true;
            }
        }

        //Sons of the Great Khan
        ((SMWaffenUndReliquien) waffenUndReliquien.getKammer()).SonsOfTheGreatKhan = getCountFromInformationVector("Sons of the Great Khan") > 0;

        //Clan Raukaan
        ((SMWaffenUndReliquien) waffenUndReliquien.getKammer()).ClanRaukaan = getCountFromInformationVector("Clan Raukaan") > 0;
        ((SMTerminatorwaffen) termiWaffen.getKammer()).ClanRaukaan = getCountFromInformationVector("Clan Raukaan") > 0;

        //Sentinels of Terra
        ((SMWaffenUndReliquien) waffenUndReliquien.getKammer()).SentinelsOfTerra = getCountFromInformationVector("Sentinels of Terra") > 0;
        ((SMTerminatorwaffen) termiWaffen.getKammer()).SentinelsOfTerra = getCountFromInformationVector("Sentinels of Terra") > 0;

        //Errors
        if (max1Error) {
            setFehlermeldung("3-5");
        } else if (((SMWaffenUndReliquien) waffenUndReliquien.getKammer()).uniqueError ||
                ((SMTerminatorwaffen) termiWaffen.getKammer()).uniqueError) {
            setFehlermeldung("Artefakt doppelt!");
        } else if (getCountFromInformationVector("SMBlackTemplars") == 1) {
            setFehlermeldung("Black Templars");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("Librarian", -1);
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
