package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.Eintrag;

public class CDKugathderSeuchenvater extends Eintrag {

    public CDKugathderSeuchenvater() {

        name = "Ku'gath, der Seuchenvater";
        grundkosten = 260;

        add(ico = new oc.Picture("oc/wh40k/images/CDKugathderSeuchenvater.gif"));

        addToInformationVector("CDDämonenprinz", 1);
        BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl("Dämonenprinz des Nurgle");
        BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Dämonenprinz des Nurgle");

        seperator();
        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("CDDämonenprinz", -1);
        if (getCountFromInformationVector("CDDämonenprinz") < 1) {
            BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Dämonenprinz des Nurgle");
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Dämonenprinz des Nurgle");
        }
        super.deleteYourself();
    }
}
