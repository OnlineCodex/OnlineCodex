package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TATY7Devilfish extends Eintrag {

	private final OptionsUpgradeGruppe o3;

    public TATY7Devilfish() {

        name = "TY7 Devilfish";
        grundkosten = getPts("TY7 Devilfish") + getPts("Burst cannon");

        add(ico = new oc.Picture("oc/wh40k/images/TeufelsrochenGross.gif"));

        ogE.addElement(new OptionsGruppeEintrag("2 MV1 Gun Drones", getPts("MV1 Gun Drone") * 2 + getPts("Pulse carbine") * 4));
        ogE.addElement(new OptionsGruppeEintrag("2 Smart missile systems", getPts("Smart missile system") * 2));
        o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(o3);
        o3.setSelected(0, true);

        seperator();

        add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Seeker missile", 2, getPts("Seeker missile")));

        seperator();

        complete();
    }

    // @OVERRIDE
    public void refreshen() {
        o3.setLegal(o3.isSelected());
        power = 6;
    }
}
