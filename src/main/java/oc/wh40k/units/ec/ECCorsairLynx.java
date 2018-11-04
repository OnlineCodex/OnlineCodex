package oc.wh40k.units.ec;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ECCorsairLynx extends Eintrag {
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    public ECCorsairLynx() {

        name = "Lynx";
        grundkosten = 225;

        add(ico = new oc.Picture("oc/wh40k/images/ELCobra.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Pulsar", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sonic Lance", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Scatter laser", 0));
        ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Dark Lance", 5));
        ogE.addElement(new OptionsGruppeEintrag("Starcannon", 5));
        ogE.addElement(new OptionsGruppeEintrag("Bright Lance", 5));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Star Engines", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair kinetic shrouds", 15));


        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

    }
}
