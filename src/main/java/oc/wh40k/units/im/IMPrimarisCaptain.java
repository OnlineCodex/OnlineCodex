package oc.wh40k.units.im;

import oc.*;

public class IMPrimarisCaptain extends Eintrag {
    OptionsUpgradeGruppe o1;
    RuestkammerStarter waffenUndReliquien;

    public IMPrimarisCaptain() {
        name = "Primaris Captain";
        grundkosten = getPts("Primaris Captain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Bolt pistol");

        ogE.addElement(new OptionsGruppeEintrag("MC Auto bolt rifle", getPts("Master crafted auto bolt rifle")));
        ogE.addElement(new OptionsGruppeEintrag("MC Stalker bolt rifle", getPts("Master crafted stalker bolt rifle")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power sword", getPts("Power sword (SM)")));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        power = 6;
        o1.alwaysSelected();
    }
}
