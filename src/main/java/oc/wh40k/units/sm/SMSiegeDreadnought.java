package oc.wh40k.units.sm;

import oc.*;

public class SMSiegeDreadnought extends Eintrag {

    OptionsEinzelUpgrade rkLuciusPod;
    OptionsUpgradeGruppe o1;
    OptionsEinzelZaehler oe1;

    public SMSiegeDreadnought() {
        name = "Siege Dreadnought";
        grundkosten = 120;

        add(ico = new oc.Picture("oc/wh40k/images/SMSiegeDreadnought.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamestorm cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Hunter-killer missiles", 2, 10));

        seperator();

        add(rkLuciusPod = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "[Apocalypse] Lucius-Pod", "Lucius Pattern Drop Pod [Apocalypse-Regeln]", 65));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) {
            o1.setSelected(0, true);
        }
    }

}
