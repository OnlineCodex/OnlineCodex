package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class NECatacombCommandBarge extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;

    public NECatacombCommandBarge() {
        name = "Catacomb Command Barge";
        grundkosten = getPts("Catacomb Command Barge");

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Staff of light", getPts("Staff of light")));
        ogE.addElement(new OptionsGruppeEintrag("Hyperphase sword", getPts("Hyperphase sword")));
        ogE.addElement(new OptionsGruppeEintrag("Voidblade", getPts("Voidblade")));
        ogE.addElement(new OptionsGruppeEintrag("Warscythe", getPts("Warscythe")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Resurrection orb", getPts("Resurrection orb")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Gauss cannon", getPts("Gauss cannon (Fahrzeug)")));
        ogE.addElement(new OptionsGruppeEintrag("Tesla cannon", getPts("Tesla cannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o2.isSelected()) o2.setSelected(0, true);

        power = 9;
    }
}
