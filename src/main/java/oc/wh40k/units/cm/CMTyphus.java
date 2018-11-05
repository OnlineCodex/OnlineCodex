package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMTyphus extends Eintrag {


    public CMTyphus() {
        name = "Typhus";
        grundkosten = 230;

        add(ico = new oc.Picture("oc/wh40k/images/Typhus.gif"));
        addToInformationVector("CMNurgleTroops", 1);
        buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Seuchenmarines");
        buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Seuchenmarines");

        buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Seuchenzombies");

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        if (getCountFromInformationVector("Main") > 0) {
            buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Seuchenmarines");
            buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Seuchenmarines");
            buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Seuchenzombies");
        } else {
            buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Seuchenmarines");
            buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Seuchenmarines");
            buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Seuchenzombies");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("CMNurgleTroops", -1);
        if (getCountFromInformationVector("CMNurgleTroops") < 1) {
            buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Seuchenmarines");
            buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Seuchenmarines");
        }
        buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Seuchenzombies");
        super.deleteYourself();
    }

}
