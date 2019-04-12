package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHHellforgedDeredeoDreadnought extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;
	public CHHellforgedDeredeoDreadnought() {
        name = "Hellforged Deredeo Dreadnought";
        grundkosten = getPts("Hellforged Deredeo Dreadnought");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Butcher cannon array", getPts("Butcher cannon array")));
        ogE.addElement(new OptionsGruppeEintrag("Ectoplasma battery", getPts("Ectoplasma battery")));
        ogE.addElement(new OptionsGruppeEintrag("Dual Malignatas saker", getPts("Dual Malignatas saker")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Twin heavy flamers", getPts("Twin heavy flamer")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Greater havoc launcher", getPts("Greater havoc launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Hellfire veil", getPts("Hellfire veil")));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        power = 14;
    }

}
