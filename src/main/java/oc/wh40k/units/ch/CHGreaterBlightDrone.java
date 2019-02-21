package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHGreaterBlightDrone extends Eintrag {
	private final OptionsUpgradeGruppe o1;
	private final OptionsUpgradeGruppe o2;
	private final OptionsUpgradeGruppe o3;

    public CHGreaterBlightDrone() {
        name = "Greater Blight Drone";
        grundkosten = getPts("Greater Blight Drone");

        ogE.addElement(new OptionsGruppeEintrag("Bile maw", getPts("Bile maw")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Blightreaper cannon", getPts("Blightreaper cannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plague probe", getPts("Plague probe")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
    }
}
