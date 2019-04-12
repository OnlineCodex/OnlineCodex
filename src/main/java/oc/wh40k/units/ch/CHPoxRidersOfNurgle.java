package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHPoxRidersOfNurgle extends Eintrag {

    public static final String POX_RIDERS_OF_NURGLE = "Pox Riders of Nurgle";

    private final AnzahlPanel Gnarlmaws;

    public CHPoxRidersOfNurgle() {
        name = POX_RIDERS_OF_NURGLE;
        power = 3;

        add(Gnarlmaws = new AnzahlPanel(ID, randAbstand, cnt, POX_RIDERS_OF_NURGLE, 3, 9, getPts(POX_RIDERS_OF_NURGLE)));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        ogE.addElement(new OptionsGruppeEintrag("Daemonic Icon", getPts("Daemonic Icon")));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        power = 8 +
                ((Gnarlmaws.getModelle() <= 3) ? 0 : 0) +
                ((Gnarlmaws.getModelle() <= 6) ? 8 : 0) +
                ((Gnarlmaws.getModelle() <= 9) ? 6 : 0);
    }
}
