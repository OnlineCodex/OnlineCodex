package oc.wh40k.units.hhca;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsUpgradeGruppe;

public class HHCAHorustheWarmaster extends Eintrag {

    OptionsUpgradeGruppe o0;

    public HHCAHorustheWarmaster() {
        name = "Horus the Warmaster";
        grundkosten = 500;

        add(ico = new oc.Picture("oc/wh40k/images/xy.jpg"));

        addToInformationVector("HHCAPraetor", 1);

        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Legion Veteran Tactical Squad");
        BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Justaerin Terminator Squad");
        BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Legion Veteran Tactical Squad");
        BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Justaerin Terminator Squad");

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {

        addToInformationVector("HHCAPraetor", -1);
        buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Legion Veteran Tactical Squad");
        buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Justaerin Terminator Squad");
        buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Legion Veteran Tactical Squad");
        buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Justaerin Terminator Squad");
        super.deleteYourself();
    }

}
