package oc.wh40k.units.im;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IMShieldCaptainonDawneagleJetbike extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;
    
    public IMShieldCaptainonDawneagleJetbike() {
        name = "Shield Captain on Dawneagle Jetbike";
        grundkosten = getPts("Shield-Captain on Dawneagle Jetbike");
        power = 9;

        ogE.addElement(new OptionsGruppeEintrag("Interceptor lance", getPts("Interceptor lance")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hurricane bolter", getPts("Hurrican bolter (AC)")));
        ogE.addElement(new OptionsGruppeEintrag("Salvo launcher", getPts("Salvo launcher")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Misericordia", getPts("Misericordia")));
        
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

