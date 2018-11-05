package oc.wh40k.units.cs;

import oc.BuildaHQ;
import oc.Eintrag;

public class CSAhriman extends Eintrag {


    public CSAhriman() {
        name = "Ahriman";
        grundkosten = 230;

        add(ico = new oc.Picture("oc/wh40k/images/Ahriman.gif"));
        addToInformationVector("CMTzeentchTroops", 1);
        BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Thousand Sons");
        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Thousand Sons");

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("CMTzeentchTroops", -1);
        if (getCountFromInformationVector("CMTzeentchTroops") < 1) {
            BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Thousand Sons");
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Thousand Sons");
        }
        super.deleteYourself();
    }
}
