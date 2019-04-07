package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ORBigMekinMegaArmour extends Eintrag {

	private final RuestkammerStarter waffen;
	public ORBigMekinMegaArmour() {
        kategorie = 1;
        name = "Big Mek in Mega Armour";
        grundkosten = getPts("Big Mek in Mega Armour");
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Tellyport blasta", getPts("Tellyport blasta")));
        ogE.addElement(new OptionsGruppeEintrag("Kustom Force field", getPts("Kustom Force field")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultRanged("Kustom mega-blasta"); //TODO: Durch Killasäga oder Liste der Schießeisän
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultCloceCombat("Power klaw");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setKillsawFK(true);
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
