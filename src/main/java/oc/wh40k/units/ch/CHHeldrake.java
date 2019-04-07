package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHHeldrake extends Eintrag {

	private final OptionsEinzelUpgrade claws;
	private final OptionsUpgradeGruppe o2;
	public CHHeldrake() {
        name = "Heldrake";
        grundkosten = getPts("Heldrake");

        add(ico = new oc.Picture("oc/wh40k/images/Höllendrache.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hades autocannon", "Hades autocannon", getPts("Hades autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Baleflamer", getPts("Baleflamer")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        add(claws = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heldrake claws", getPts("Heldrake claws")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        if (!claws.isSelected()) claws.setSelected(true);

        power = 10;
    }

}
