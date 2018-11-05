package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHPoxRidersOfNurgle extends Eintrag {

    AnzahlPanel Gnarlmaws;
    OptionsUpgradeGruppe o1, o2;

    public CHPoxRidersOfNurgle() {

        name = "Pox Riders of Nurgle";
        grundkosten = 0;
        power = 3;

        add(Gnarlmaws = new AnzahlPanel(ID, randAbstand, cnt, "Pox Riders of Nurgle", 3, 9, getPts("Plague Toads of Nurgle")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Instrument of Chaos", getPts("Instrument of Chaos")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        ogE.addElement(new OptionsGruppeEintrag("Daemonic Icon", getPts("Daemonic Icon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = 8 +
                ((Gnarlmaws.getModelle() <= 3) ? 0 : 0) +
                ((Gnarlmaws.getModelle() <= 6) ? 8 : 0) +
                ((Gnarlmaws.getModelle() <= 9) ? 6 : 0);
    }

}
