package oc.wh40k.units.or;

import oc.*;

import javax.xml.ws.Action;

public class ORFlashGitz extends Eintrag {

    private final AnzahlPanel Gargbosse;
    private final OptionsZaehlerGruppe GargbosseFK;

    public ORFlashGitz() {
        name = "Flash Gitz";

        grundkosten = 0;

        add(Gargbosse = new AnzahlPanel(ID, randAbstand, cnt, "Flash Gitz", 5, 10, getPts("Flash Gitz") + getPts("Snazzgun") + getPts("Stikkbombs")));
        add(ico = new oc.Picture("oc/wh40k/images/Gargbosse.gif"));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ammo Runt", getPts("Ammo Runt")));
        add(GargbosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        seperator();

        ORWaffenUndGeschenke kammer = new ORWaffenUndGeschenke("no weapon", "no weapon", false, false, false, false, false, false, false, false);
        kammer.setKaptin(true);
        RuestkammerStarter boss = new RuestkammerStarter(ID, randAbstand, cnt, kammer, "Kaptin");
        boss.setUeberschriftTrotzNullKostenAusgeben(true);
        boss.setGrundkosten(getPts("Kaptin"));
        boss.setAbwaehlbar(false);
        add(boss);

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
