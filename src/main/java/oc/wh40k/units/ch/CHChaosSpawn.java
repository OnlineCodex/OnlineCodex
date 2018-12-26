package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHChaosSpawn extends Eintrag {

    AnzahlPanel marines;
    OptionsUpgradeGruppe mark;

    public CHChaosSpawn() {

        name = "Chaos Spawn";
        grundkosten = 0;
        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Spawn", 1, 5, getPts("Chaos Spawn")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }


    @Override
    public void refreshen() {

        power = 2 +
                ((marines.getModelle() == 2) ? 2 : 0) +
                ((marines.getModelle() == 3) ? 4 : 0) +
                ((marines.getModelle() == 4) ? 6 : 0) +
                ((marines.getModelle() == 5) ? 8 : 0);
    }
}
