package oc.wh40k.units.da;

import oc.*;

public class DADeathwingTerminatorSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsEinzelZaehler o1a;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;
    OptionsZaehlerGruppe o4;
    RuestkammerStarter ot;

    boolean added = false;

    public DADeathwingTerminatorSquad() {
        name = "Deathwing-Terminatortrupp";
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/DADeathwingTerminatorSquad.gif"));

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Deathwing-Terminatoren", 5, 10, 40);
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 0));
        ogE.addElement(new OptionsGruppeEintrag("Hammer & Schild", "Energiehammer & Sturmschild", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 5));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 15));
        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 20));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Cyclone-Raketenwerfer", 25));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Düsteres Relikt der alten Legion", "Düsteres Relikt", 15));

        seperator();

        ot = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
        ot.initKammer(false, false, false, true, true, false);
        ot.setButtonText("Transporter");
        add(ot);
    }

    @Override
    public void refreshen() {

        int count = squad.getModelle();
        int kettcount = ((count - o1.getAnzahl()) > (count)) ? (count) : (count - o1.getAnzahl());
        o3.setMaxAnzahl(kettcount);
        int max = 0;
        if (o2.getAnzahl() > o3.getAnzahl()) {
            max = o2.getAnzahl();
        } else {
            max = o3.getAnzahl();
        }
        o1.setMaxAnzahl(count - max);

        if (count < 10) {
            o2.setMaxAnzahl(1);
            o4.setMaxAnzahl(1);
        } else {
            o2.setMaxAnzahl(2);
            o4.setMaxAnzahl(2);
        }

        int freieBolter = squad.getModelle() - o1.getAnzahl();

        o2.setMaxAnzahl((o2.getMaxAnzahl() - o4.getAnzahl()) > freieBolter ? freieBolter : (o2.getMaxAnzahl() - o4.getAnzahl()));
        o4.setMaxAnzahl(o4.getMaxAnzahl() - o2.getAnzahl());
    }

    @Override
    public void deleteYourself() {

        super.deleteYourself();
    }

}
