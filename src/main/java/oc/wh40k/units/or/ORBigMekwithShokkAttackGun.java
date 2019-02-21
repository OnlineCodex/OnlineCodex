package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORBigMekwithShokkAttackGun extends Eintrag {

	private final OptionsEinzelUpgrade grotoiler;
	private final RuestkammerStarter waffen;

	private final boolean megaBool = false;
	private final boolean gazzBool = false;

    public ORBigMekwithShokkAttackGun() {
        kategorie = 1;
        name = "Big Mek with Shokk attack gun";
        grundkosten = getPts("Big Mek") + getPts("Stikkbombs") + getPts("Shokk attack gun");
        power = 4;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));

        add(grotoiler = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultRanged("no weapon");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultCloceCombat("no weapon");
        waffen.initKammer(false, false, false, false, false, false, true, false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
