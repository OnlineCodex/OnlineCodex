package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ORBigMekwithKustomForceField extends Eintrag {

	private final RuestkammerStarter waffen;
	public ORBigMekwithKustomForceField() {
        kategorie = 1;
        name = "Big Mek with Kustom Force Field";
        grundkosten = getPts("Big Mek with Kustom Force Field");
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultRanged(""); 
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultCloceCombat("");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setKillsawFK(true);
        ((ORWaffenUndGeschenke) waffen.getKammer()).setName(name);
        waffen.initKammer(false, true, false, false, false, false, true, false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);

        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    	warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }

}
