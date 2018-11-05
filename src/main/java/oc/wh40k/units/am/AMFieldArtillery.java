package oc.wh40k.units.am;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AMFieldArtillery extends RuestkammerVater {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;

    public AMFieldArtillery() {
        grundkosten = 55;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGHellhound.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Heavy Quad Launcher", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Mortar", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o1.alwaysSelected();

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Crew", 3, 5, 7));
        squad.setGrundkosten(-21);
        squad.setNichtDieErsteOption(true);

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }

}
