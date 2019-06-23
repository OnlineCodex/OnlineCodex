package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TAAX3RazorsharkStrikeFighter extends Eintrag {

	private final OptionsUpgradeGruppe o2;

    public TAAX3RazorsharkStrikeFighter() {
        name = "AX3 Razorshark Strike Fighter";
        grundkosten = getPts("AX3 Razorshark Strike Fighter") + getPts("Quad ion turret") + getPts("Seeker missile") * 2;

        add(ico = new oc.Picture("oc/wh40k/images/TeufelsrochenGross.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Burst cannon", getPts("Burst cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Missile pod", getPts("Missile pod")));
        o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(o2);
        o2.setSelected(0, true);

        seperator();

        complete();
    }

    // @OVERRIDE
    @Override
	public void refreshen() {
    	o2.alwaysSelected();
        o2.setLegal(o2.isSelected());
        power = 8;
    }
}
