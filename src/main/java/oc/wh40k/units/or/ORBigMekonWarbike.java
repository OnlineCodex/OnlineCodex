package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ORBigMekonWarbike extends Eintrag {

	private final RuestkammerStarter waffen;

	public ORBigMekonWarbike() {
        kategorie = 1;
        name = "Big Mek on Warbike";
        grundkosten = getPts("Big Mek on Warbike") + getPts("Stikkbombs");
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));
        
        ogE.addElement(new OptionsGruppeEintrag("Kustom Force field", getPts("Kustom Force field")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setKillsawNK(true);
        ((ORWaffenUndGeschenke) waffen.getKammer()).setName(name);
        waffen.initKammer(true, false, true, true, true, true, true, false);
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
