package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHMutalithVortexBeast extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe stave;
    OptionsUpgradeGruppe inferno;

    public CHMutalithVortexBeast() {

        name = "Mutalith Vortex Beast";
        grundkosten = getPts("Mutalith Vortex Beast");
        power = 8;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Betentacled maw", getPts("Betentacled maw")));
        add(stave = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Enormous claws", getPts("Enormous claws")));
        add(inferno = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        inferno.alwaysSelected();
        stave.alwaysSelected();
    }
}
