package oc.wh40k.units.or;

import oc.*;

public class ORBigMekStompa extends Eintrag {

	private final OptionsUpgradeGruppe main;

    public ORBigMekStompa() {
        name = "Big Mek Stompa";
        grundkosten = 830;

        add(ico = new oc.Picture("oc/wh40k/images/BigMeksStampfa.gif"));

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Supa Rokkit", 3, 20));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mega-klaw", 0));
        ogE.addElement(new OptionsGruppeEintrag("Deff kannon", 50));
        add(main = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Belly mounted deff kannon", 100));

        addToInformationVector("ORBigMekStompa", 1);

        complete();

    }

    public void refreshen() {
        if (main.isSelected()) {
            main.setSelected(0, true);
        }

        if (getCountFromInformationVector("Stompa Mob") == 1) {
            if (getCountFromInformationVector("ORBigMekStompa") > 1) {
                setFehlermeldung("0-1");
            } else {
                setFehlermeldung("");
            }
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("ORBigMekStompa", -1);
        super.deleteYourself();
    }
}
