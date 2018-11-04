package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMVexilusPraetor extends Eintrag {

    OptionsUpgradeGruppe o1, o2;
    OptionsEinzelUpgrade misericordia;

    public IMVexilusPraetor() {
        name = "Vexilus Praetor";
        grundkosten = getPts("Vexilus Praetor");

        ogE.addElement(new OptionsGruppeEintrag("Vexilla Defensor", getPts("Vexilla Defensor")));
        ogE.addElement(new OptionsGruppeEintrag("Vexilla Imperius", getPts("Vexilla Imperius")));
        ogE.addElement(new OptionsGruppeEintrag("Vexilla Magnifica", getPts("Vexilla Magnifica")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Guardian Spear", getPts("Guardian spear (AC)")));
        ogE.addElement(new OptionsGruppeEintrag("Castellan Axe", getPts("Castellan axe")));
        ogE.addElement(new OptionsGruppeEintrag("Storm Shield & Misericordia", getPts("Storm shield (AC Characters)") + getPts("Misericordia")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        add(misericordia = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Misericordia", getPts("Misericordia")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        misericordia.setAktiv(!o2.isSelected(2));

        power = 6;
    }
}
