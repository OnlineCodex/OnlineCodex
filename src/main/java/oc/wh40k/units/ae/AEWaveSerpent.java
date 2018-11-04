package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AEWaveSerpent extends Eintrag {

    OptionsUpgradeGruppe o1, o2;

    public AEWaveSerpent() {
        name = "Wave Serpent";
        grundkosten = getPts("Wave Serpent");
        power = 9;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin shuriken cannon", getPts("Twin shuriken cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Twin bright lance", getPts("Twin bright lance")));
        ogE.addElement(new OptionsGruppeEintrag("Twin scatter laser", getPts("Twin scatter laser")));
        ogE.addElement(new OptionsGruppeEintrag("Twin starcannon", getPts("Twin starcannon")));
        ogE.addElement(new OptionsGruppeEintrag("Twin Aeldari missile launcher", getPts("Twin Aeldari missile launcher")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin shuriken catapult", getPts("Twin shuriken catapult")));
        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", getPts("Shuriken cannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Crystal targeting matrix", getPts("Crystal targeting matrix")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Spirit stones", getPts("Spirit stones")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Star engines", getPts("Star engines")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vectored engines", getPts("Vectored engines")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
