package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMChapterChampion extends Eintrag {
    OptionsUpgradeGruppe o1, o2;

    public IMChapterChampion() {
        name = "Chapter Champion";
        grundkosten = getPts("Chapter Champion") +
                getPts("Frag grenade (SM)") +
                getPts("Krak grenade (SM)") +
                getPts("Bolt pistol (SM)");
        power = 4;
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Champion's blade", getPts("Champion's blade")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("power sword (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("power axe (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", getPts("power lance (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("power maul (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (Characters)")));
        ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("relic blade")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
