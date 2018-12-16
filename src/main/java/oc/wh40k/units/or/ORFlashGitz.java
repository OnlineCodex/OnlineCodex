package oc.wh40k.units.or;

import oc.*;

import javax.xml.ws.Action;

public class ORFlashGitz extends Eintrag {

    AnzahlPanel Gargbosse;
    OptionsZaehlerGruppe GargbosseFK;
    OptionsEinzelUpgrade captain;
    RuestkammerStarter Boss;

    public ORFlashGitz() {

        grundkosten = 0;

        name = "Flash Gitz";

        add(Gargbosse = new AnzahlPanel(ID, randAbstand, cnt, "Flash Gitz", 5, 10, getPts("Flash Gitz") + getPts("Snazzgun") + getPts("Stikkbombs")));
        add(ico = new oc.Picture("oc/wh40k/images/Gargbosse.gif"));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ammo Runt", getPts("Ammo Runt")));
        add(GargbosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        seperator();

        Boss = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "Kaptin");
        ((ORWaffenUndGeschenke) Boss.getKammer()).setKaptin(true);
        ((ORWaffenUndGeschenke) Boss.getKammer()).setDefaultCloceCombat("no weapon");
        ((ORWaffenUndGeschenke) Boss.getKammer()).setDefaultRanged("no weapon");
        Boss.initKammer(false, false, false, false, false);
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        Boss.setGrundkosten(getPts("Kaptin"));
        add(Boss);
        Boss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        GargbosseFK.setMaxAnzahl(Gargbosse.getModelle() / 5);
        power = 7;
        if (Gargbosse.getModelle() > 5) {
            power = 14;
        }
    }
}
