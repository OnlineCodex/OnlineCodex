package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMStormravenGunship extends Eintrag {

    OptionsUpgradeGruppe o1, o2;

    public IMStormravenGunship() {
        name = "Stormraven Gunship";
        grundkosten = getPts("Stormraven Gunship") + getPts("Stormstrike missile launcher") * 2;
        power = 15;

        ogE.addElement(new OptionsGruppeEintrag("Twin assault cannon", getPts("Twin assault cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Twin Lascannon", getPts("Twin Lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("Twin plasma cannon", "Twin heavy plasma cannon", getPts("Twin heavy plasma cannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin Heavy bolter", getPts("Twin Heavy bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Twin multi-melta", getPts("Twin multi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Typhoon missile launcher", getPts("Typhoon missile launcher")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "2 Hurricane bolters", getPts("Hurricane bolter") * 2));

        complete();

    }

    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
