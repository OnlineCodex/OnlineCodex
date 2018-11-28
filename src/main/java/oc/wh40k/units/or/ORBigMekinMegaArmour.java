package oc.wh40k.units.or;

import oc.*;

public class ORBigMekinMegaArmour extends Eintrag {

    OptionsEinzelUpgrade grotoiler;
    RuestkammerStarter waffen;
    RuestkammerStarter warlord;
    OptionsUpgradeGruppe tech = null;

    public ORBigMekinMegaArmour() {
        kategorie = 1;
        name = "Big Mek in Mega Armour";
        grundkosten = getPts("Big Mek in Mega Armour");
        power = 6;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));

        add(grotoiler = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot oiler", getPts("Grot oiler")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Tellyport blasta", getPts("Tellyport blasta")));
        ogE.addElement(new OptionsGruppeEintrag("Kustom Force field", getPts("Kustom Force field")));
        add(tech = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultFK("Kustom mega-blasta"); //TODO: Durch Killasäga oder Liste der Schießeisän
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultNK("Power klaw");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setKillsawFK(true);
        waffen.initKammer(false, true, false, false, false, false, true, false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        seperator();

        warlord = new RuestkammerStarter(ID, randAbstand, cnt, "Warlordtraits", "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        complete();
    }

    @Override
    public void refreshen() {
    	warlord.getPanel().setLocation(
                (int) warlord.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }

}
