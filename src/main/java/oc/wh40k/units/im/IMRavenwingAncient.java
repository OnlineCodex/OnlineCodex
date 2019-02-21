package oc.wh40k.units.im;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

public class IMRavenwingAncient extends Eintrag {

	private final OptionsUpgradeGruppe o1;

    public IMRavenwingAncient() {
        name = "Ravenwing Ancient";
        grundkosten = getPts("Ravenwing Ancient") + getPts("Corvus hammer") + getPts("Bolt pistol (SM)") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 6;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plasma talon", getPts("Plasma talon")));
        ogE.addElement(new OptionsGruppeEintrag("Ravenwing grenade launcher", getPts("Ravenwing grenade launcher")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        addWarlordTraits("", true);
        
        complete();
    }

    @Override

    public void refreshen() {
    }

}

