package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORBlastaBommer extends Eintrag {

    public ORBlastaBommer() {
        name = "Blasta Bommer";
        grundkosten = 410;


        add(ico = new oc.Picture("oc/wh40k/images/BlastaBommer.gif"));


        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "6 Bomms", 40));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("6 Bomms", 60));
        ogE.addElement(new OptionsGruppeEintrag("4 Bomms, 2 Grotbomms", 60));
        ogE.addElement(new OptionsGruppeEintrag("6 Supa-Rokkits", 60));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


        complete();

    }

    @Override
	public void refreshen() {
    }
}
