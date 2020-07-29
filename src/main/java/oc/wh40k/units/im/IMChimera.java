package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMChimera extends Eintrag {

	private final OptionsUpgradeGruppe o1;
	private final OptionsUpgradeGruppe o2;
	private final OptionsUpgradeGruppe o1x;
	private final OptionsUpgradeGruppe o2x;
	private final OptionsEinzelUpgrade oe1;
	private final OptionsEinzelUpgrade oe2;

    public IMChimera() {
    	name = "Chimera";
        grundkosten = getPts("Chimera") + getPts("Lasgun array") * 2;
        add(ico = new oc.Picture("oc/wh40k/images/IGChimaere.jpg"));
        power = 5;

        ogE.addElement(new OptionsGruppeEintrag("Multi-laser", getPts("Multi-laser")));
        add(o1x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AM other)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (AM other)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AM other)")));
        add(o2x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (AM other)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Augur array", getPts("Augur array")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", getPts("Dozer blade")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (AM)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Track guards", getPts("Track guards")));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (AM)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", getPts("Heavy stubber")));

        complete();
    }

    @Override
    public void refreshen() {
        oe1.setAktiv(!oe2.isSelected());
        oe2.setAktiv(!oe1.isSelected());

        o1x.setSelected(0, !o1.isSelected());
        o2x.setSelected(0, !o2.isSelected());
    }

}
