package oc.wh40k.units.im;


import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMVexilusPraetorinAllarusTerminatorArmour extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;

    public IMVexilusPraetorinAllarusTerminatorArmour() {
        name = "Vexilus Praetor in Allarus Terminator Armour";
        grundkosten = getPts("Vexilus Praetor in Allarus Terminator Armour");
        power = 7;

        ogE.addElement(new OptionsGruppeEintrag("Vexilla Defensor", getPts("Vexilla Defensor")));
        ogE.addElement(new OptionsGruppeEintrag("Vexilla Imperius", getPts("Vexilla Imperius")));
        ogE.addElement(new OptionsGruppeEintrag("Vexilla Magnifica", getPts("Vexilla Magnifica")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Balistus grenade launcher", getPts("Balistus grenade launcher")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Misericordia", getPts("Misericordia")));

        seperator();

		addWarlordTraits("", true);

        complete();
    }



    @Override

    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}

