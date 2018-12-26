package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORSkalkBluetoof extends Eintrag {

    public ORSkalkBluetoof() {
        name = "Skalk Bluetoof";
        grundkosten = 95;

        add(ico = new oc.Picture("oc/wh40k/images/SkalkBluetoof.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bonemuncha", 600));

        BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(ORLootas.class);
        addToInformationVector("ORHQ", 1);
        complete();

    }

    @Override
    public void deleteYourself() {
        BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(ORLootas.class);
        addToInformationVector("ORHQ", -1);
        super.deleteYourself();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
