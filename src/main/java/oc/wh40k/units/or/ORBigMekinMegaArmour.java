package oc.wh40k.units.or;

import oc.*;

public class ORBigMekinMegaArmour extends Eintrag {

    private final RuestkammerStarter waffen;

    public ORBigMekinMegaArmour() {
        name = "Big Mek in Mega Armour";
        grundkosten = getPts("Big Mek in Mega Armour");
        power = 6;
        kategorie = 1;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Tellyport blasta", getPts("Tellyport blasta")));
        ogE.addElement(new OptionsGruppeEintrag("Kustom Force field", getPts("Kustom Force field")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ORWaffenUndGeschenke kammer = new ORWaffenUndGeschenke("Kustom mega-blasta", "Power klaw", false, true, false, false, false, false, true, false);
        kammer.setKillsawNK(true);
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, kammer);
        waffen.setButtonText("Waffen und Geschenke");
        waffen.setAbwaehlbar(false);
        add(waffen);

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