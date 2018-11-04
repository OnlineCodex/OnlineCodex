package oc.wh40k.units.ec;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ECCorsairVampireRaider extends Eintrag {
    OptionsUpgradeGruppe o1;

    public ECCorsairVampireRaider() {

        name = "Corsair Vampire Raider";
        grundkosten = 730;

        add(ico = new oc.Picture("oc/wh40k/images/ELVampireRaider.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Pulse Lasers", "Two twin-linked Pulse Lasers", 0));
        ogE.addElement(new OptionsGruppeEintrag("Missile Launcher", "Two twin-linked Phoenix Missile Launchers", 0));
        ogE.addElement(new OptionsGruppeEintrag("Pulsar", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
    }
}
