package oc.wh40k.units.im;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMLemanRusDemolisher extends RuestkammerVater {

	private OptionsUpgradeGruppe o1;
	private OptionsUpgradeGruppe o2;
	private OptionsEinzelUpgrade oe1;
	private OptionsEinzelUpgrade oe2;

	public IMLemanRusDemolisher() {
        grundkosten = getPts("Leman RussBattle Tanks");
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGLemanRuss.jpg"));


        ogE.addElement(new OptionsGruppeEintrag("Battle Cannon", getPts("Battle Cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Exterminator Autocannon", getPts("Exterminator Autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Vanquisher battle cannon", getPts("Vanquisher battle cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Eradicator nova cannon", getPts("Eradicator nova cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Leman Russ Conqueror [IA1 2nd Ed]", 150));
        ogE.addElement(new OptionsGruppeEintrag("Leman Russ Annihilator [IA1 2nd Ed]", 130));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon (AM)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", getPts("Heavy bolter (AM)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Heavy flamers", getPts("Heavy flamer (AM)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Multi-meltas", getPts("Multi-melta (AM)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Plasma cannons", getPts("Plasma cannon (AM)") * 2));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (AM)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", getPts("Heavy stubber")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (AM)")));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o2.isSelected()) o2.setSelected(0, true);

        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());
    }

}
