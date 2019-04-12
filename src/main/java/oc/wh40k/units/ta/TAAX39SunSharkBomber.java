package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TAAX39SunSharkBomber extends Eintrag {

    private final OptionsUpgradeGruppe o2;

    public TAAX39SunSharkBomber() {
        name = "AX39 Sun Shark Bomber";
        grundkosten = getPts("AX39 Sun Shark Bomber") + getPts("Markerlight") + getPts("Seeker missile") * 2 + getPts("MV17 Interceptor Drone") * 2;

        add(ico = new oc.Picture("oc/wh40k/images/TeufelsrochenGross.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Missile pod", getPts("Missile pod")));
        ogE.addElement(new OptionsGruppeEintrag("2 Missile pods", getPts("Missile pod") * 2));
        o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE);
        add(o2);
        o2.setSelected(0, true);

        complete();
    }

    // @OVERRIDE
    @Override
	public void refreshen() {
        o2.setLegal(o2.isSelected());
        power = 9;
    }
}
