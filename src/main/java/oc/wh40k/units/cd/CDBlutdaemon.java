package oc.wh40k.units.cd;


import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CDBlutdaemon extends Eintrag {

    OptionsZaehlerGruppe o1, o2, o3;

    public CDBlutdaemon() {

        name = "Blutdämon";

        grundkosten = 250;

        add(ico = new oc.Picture("oc/wh40k/images/CDBlutdaemon.gif"));

        addToInformationVector("CDDämonenprinz", 1);
        BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Dämonenprinz des Khorne");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Dämonenprinz des Khorne");

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnungen", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
        ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnungen", 20));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Erhabene Belohnungen", 30));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();

    }

    @Override
    public void refreshen() {
        int max = 50;
        int geringeBelohnung = 10;
        int mächtigeBelohnung = 20;
        int erhabeneBelohnung = 30;

        int freePoints = max - o1.getAnzahl() * geringeBelohnung - o2.getAnzahl() * mächtigeBelohnung - o3.getAnzahl() * erhabeneBelohnung;
        if (freePoints < erhabeneBelohnung) {
            o3.setMaxAnzahl(o3.getAnzahl());
        } else {
            o3.setMaxAnzahl(freePoints / erhabeneBelohnung);
        }
        if (freePoints < mächtigeBelohnung) {
            o2.setMaxAnzahl(o2.getAnzahl());
        } else {
            o2.setMaxAnzahl(o2.getAnzahl() + freePoints / mächtigeBelohnung);
        }
        if (freePoints < geringeBelohnung) {
            o1.setMaxAnzahl(o1.getAnzahl());
        } else {
            o1.setMaxAnzahl(o1.getAnzahl() + freePoints / geringeBelohnung);
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("CDDämonenprinz", -1);
        if (getCountFromInformationVector("CDDämonenprinz") < 1) {
            BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Dämonenprinz des Khorne");
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Dämonenprinz des Khorne");
        }
        super.deleteYourself();
    }
}
