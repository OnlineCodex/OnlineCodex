package oc.wh40k.units.cm;

import oc.Eintrag;

public class CMLuciusderEwige extends Eintrag {

    public CMLuciusderEwige() {
        name = "Lucius der Ewige";
        grundkosten = 165;

        add(ico = new oc.Picture("oc/wh40k/images/LuciustheEternal.gif"));

        addToInformationVector("CMSlaanesTroops", 1);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        if (getCountFromInformationVector("Main") > 0) {
            buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Noisemarines");
            buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Noisemarines");
        } else {
            buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Noisemarines");
            buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Noisemarines");
        }
    }

    @Override
    public void deleteYourself() {

        addToInformationVector("CMSlaanesTroops", -1);
        if (getCountFromInformationVector("CMSlaanesTroops") < 1) {
            buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Noisemarines");
            buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Noisemarines");
        }
        super.deleteYourself();
    }
}
