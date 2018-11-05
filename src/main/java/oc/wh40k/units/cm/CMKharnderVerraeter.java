package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMKharnderVerraeter extends Eintrag {

    public CMKharnderVerraeter() {
        name = "Kharn der Verräter";
        grundkosten = 160;

        add(ico = new oc.Picture("oc/wh40k/images/KharntheBetrayer.gif"));

        addToInformationVector("CMKhorneTroops", 1);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        if (getCountFromInformationVector("Main") > 0) {
            buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Khorne-Berserker");
            buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Khorne-Berserker");
        } else {
            buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Khorne-Berserker");
            buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Khorne-Berserker");
        }
    }


    @Override
    public void deleteYourself() {

        addToInformationVector("CMKhorneTroops", -1);
        if (getCountFromInformationVector("CMKhorneTroops") < 1) {
            buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Khorne-Berserker");
            buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Khorne-Berserker");
        }
        super.deleteYourself();
    }
}
