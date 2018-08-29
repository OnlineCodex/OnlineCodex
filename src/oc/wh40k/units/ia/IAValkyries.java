package oc.wh40k.units.ia;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IAValkyries extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o2x;
    OptionsEinzelZaehler oe1;

    public IAValkyries() {
        name = "Valkyries";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Valkyrie", "Valkyries", 1, 4, 125);
        squad.setGrundkosten(0);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/IGValkyrieAssaultCarrierSquadron.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multilaser", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Donnerkeilraketen", "Paar Donnerkeilraketen", 0));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("2 Salvenraketenwerfer", "Paar Salvenraketenwerfer", 10));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "2 Schwere Bolter", "Paar schwere Bolter", 3, 20));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());

        o2.setMaxAnzahl(squad.getModelle());
        o2x.setMaxAnzahl(squad.getModelle());
        o2x.setAnzahl(0, squad.getModelle() - o2.getAnzahl());

        oe1.setMaxAnzahl(squad.getModelle());
    }
    
}
