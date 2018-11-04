package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AECrimsonHunterExarch extends Eintrag {

    boolean exarch = false;
    boolean uniqueError = false;
    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade boss;

    public AECrimsonHunterExarch() {

        name = "Crimson Hunter Exarch";

        grundkosten = getPts("Crimson Hunter Exarch") + getPts("Pulse laser");
        power = 11;

        ogE.addElement(new OptionsGruppeEintrag("2 bright lances", 2 * getPts("Bright lance")));
        ogE.addElement(new OptionsGruppeEintrag("2 Starcannons", 2 * getPts("Starcannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        o1.alwaysSelected();
    }
}
