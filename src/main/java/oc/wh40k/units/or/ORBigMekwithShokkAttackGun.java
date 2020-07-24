package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORBigMekwithShokkAttackGun extends Eintrag {

	private final RuestkammerStarter waffen;

	public ORBigMekwithShokkAttackGun() {
        kategorie = 1;
        name = "Big Mek with Shokk Attack Gun";
        grundkosten = getPts("Big Mek with Shokk Attack Gun") + getPts("Stikkbombs");
        power = 4;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultRanged("Shokk attack gun");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultCloceCombat("no weapon");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setName(name);
        waffen.initKammer(false, false, false, false, false, false, true, false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }

}
