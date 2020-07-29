package oc.wh40k.units.im;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMLemanRussBattleTank extends RuestkammerVater {

	private OptionsUpgradeGruppe o1;
	private OptionsUpgradeGruppe o2;
	private OptionsEinzelUpgrade oe1;
	private OptionsEinzelUpgrade oe2;

	public IMLemanRussBattleTank() {
        grundkosten = getPts("Leman RussBattle Tanks");
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGLemanRuss.jpg"));


        ogE.addElement(new OptionsGruppeEintrag("Battle Cannon", getPts("Battle Cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Exterminator Autocannon", getPts("Exterminator Autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Vanquisher battle cannon", getPts("Vanquisher battle cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Eradicator nova cannon", getPts("Eradicator nova cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Demolisher cannon", getPts("Demolisher cannon (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Punisher gatling cannon", getPts("Punisher gatling cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Executioner plasma cannon", getPts("Executioner plasma cannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AM other)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (AM other)")));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon (AM other)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", getPts("Heavy bolter (AM other)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Heavy flamers", getPts("Heavy flamer (AM other)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Multi-meltas", getPts("Multi-melta (AM other)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Plasma cannons", getPts("Plasma cannon (AM other)") * 2));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (AM)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", getPts("Heavy stubber")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Augur array", getPts("Augur array")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", getPts("Dozer blade")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (AM)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Track guards", getPts("Track guards")));

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
