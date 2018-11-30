package oc.wh40k.units.im;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;
public class IMShieldCaptain extends Eintrag {
	
    OptionsUpgradeGruppe o1;
    RuestkammerStarter warlord;

    public IMShieldCaptain() {
        name = "Shield Captain";
        grundkosten = getPts("Shield Captain");
        power = 7;

        ogE.addElement(new OptionsGruppeEintrag("Guardian spear", getPts("Guardian spear (AC)")));
        ogE.addElement(new OptionsGruppeEintrag("Sentinel blade", getPts("Sentinel blade")));
        ogE.addElement(new OptionsGruppeEintrag("Castellan axe", getPts("Castellan axe")));
        ogE.addElement(new OptionsGruppeEintrag("Sentinel blade & Storm shield", getPts("Sentinel blade") + getPts("Storm shield (AC Characters)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

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
    }

}

