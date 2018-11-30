package oc.wh40k.units.im;

import oc.*;
import oc.wh40k.units.Warlordtraits;

public class IMPrimarisCaptain extends Eintrag {
    OptionsUpgradeGruppe o1;
    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter warlord;

    public IMPrimarisCaptain() {
        name = "Primaris Captain";
        grundkosten = getPts("Primaris Captain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Bolt pistol");

        ogE.addElement(new OptionsGruppeEintrag("MC Auto bolt rifle", getPts("Master crafted auto bolt rifle")));
        ogE.addElement(new OptionsGruppeEintrag("MC Stalker bolt rifle", getPts("Master crafted stalker bolt rifle")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power sword", getPts("Power sword (SM)")));

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
        power = 6;
        o1.alwaysSelected();
    }
}
