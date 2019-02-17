package oc.wh40k.units.ae;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

public class AEAutarchwithSwoopingHawkWings extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;

    public AEAutarchwithSwoopingHawkWings() {
        name = "Autarch with Swooping Hawk Wings";
        grundkosten = getPts("Autarch with Swooping Hawk Wings") + getPts("Plasma grenade") + getPts("Forceshield");
        power = 4;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Fusion pistol", getPts("Fusion pistol")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
