package oc.wh40k.units.dk;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKHeavyArtilleryCarriage extends RuestkammerVater {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;

    public DKHeavyArtilleryCarriage() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGOrdnanceTank.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Earthshaker cannon", 75));
        ogE.addElement(new OptionsGruppeEintrag("Medusa siege gun", 100));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Crew", 4, 8, 6));
        squad.setGrundkosten(-24);
        squad.setNichtDieErsteOption(true);


        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }

}
