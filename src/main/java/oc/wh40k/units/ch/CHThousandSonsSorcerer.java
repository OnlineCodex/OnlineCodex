package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHThousandSonsSorcerer extends Eintrag {

    OptionsUpgradeGruppe inferno, stave;

    public CHThousandSonsSorcerer() {

        name = "Thousand Sons Sorcerer";
        grundkosten = getPts("Sorcerer (TS)");
        power = 7;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Inferno bolt pistol", getPts("Inferno bolt pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Warpflame pistol", getPts("Warpflame pistol")));
        add(inferno = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
        ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
        add(stave = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


        complete();

    }

    @Override
    public void refreshen() {
        inferno.alwaysSelected();
        stave.alwaysSelected();
    }
}
