package oc.wh40k.units.im;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMShieldCaptaininAllarusTerminatorArmour extends Eintrag {
	
    OptionsUpgradeGruppe o1, o2;
    RuestkammerStarter warlord;

    public IMShieldCaptaininAllarusTerminatorArmour() {
        name = "Shield Captain in Allarus Terminator Armour";
        grundkosten = getPts("Shield-Captain in Allarus Terminator Armour");
        power = 8;

        ogE.addElement(new OptionsGruppeEintrag("Guardian spear", getPts("Guardian spear (AC)")));
        ogE.addElement(new OptionsGruppeEintrag("Castellan axe", getPts("Castellan axe")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);
        
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Balistus grenade launcher", getPts("Balistus grenade launcher")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Misericordia", getPts("Misericordia")));
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        complete();

    }

    @Override

    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }

}

