package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class IMSanguinaryGuardAncient extends Eintrag {
    OptionsUpgradeGruppe o1, o2;
    RuestkammerStarter warlord;

    public IMSanguinaryGuardAncient() {
        name = "Sanguinary Guard Ancient";
        grundkosten = getPts("Sanguinary Guard Ancient");
        power = 6;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Death mask", getPts("death mask")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Angelus boltgun", getPts("angelus boltgun")));
        ogE.addElement(new OptionsGruppeEintrag("Inferno pistol", getPts("Inferno pistol (BA)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("plasma pistol (SM)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Encarmine sword", getPts("encarmine sword")));
        ogE.addElement(new OptionsGruppeEintrag("Encarmine axe", getPts("encarmine axe")));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("power fist (SM)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
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
