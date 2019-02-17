package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHKhorneLordofSkulls extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;

    public CHKhorneLordofSkulls() {
        name = "Khorne Lord of Skulls";
        grundkosten = getPts("Khorne Lord of Skulls");

        add(ico = new oc.Picture("oc/wh40k/images/Klauenmonstrum.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Gorestorm cannon", getPts("Gorestorm cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Ichor cannon", getPts("Ichor cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Daemongore cannon", getPts("Daemongore cannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hades gatling cannon", getPts("Hades gatling cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Skullhurler", getPts("Skullhurler")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o2.isSelected()) o2.setSelected(0, true);

        power = 39;
    }

}
