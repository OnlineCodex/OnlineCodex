package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORTrukk extends Eintrag {

	public ORTrukk() {
        grundkosten = getPts("Trukk") + getPts("Big shoota");
        power = 3;
        name = "Trukk";
        add(ico = new oc.Picture("oc/wh40k/images/Pikk-Up.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Wreckin' ball", getPts("Wreckin' ball")));
        ogE.addElement(new OptionsGruppeEintrag("Grabbin' klaw", getPts("Grabbin' klaw")));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb Chukka", getPts("Stikkbomb chukka")));

        complete();
    }

    // @OVERRIDE
    @Override
	public void refreshen() {
    }

}
