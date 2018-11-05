package oc.wh40k.units.am;

import oc.*;

public class AMVendettaSquadron extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe oe1;
    OptionsEinzelZaehler oe2;
    OptionsEinzelZaehler oe3;

    public AMVendettaSquadron() {
        name = "Vendetta Squadron";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Vendetta", "Vendettas", 1, 3, 170);
        squad.setGrundkosten(0);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/IGVendettaGunshipSquadron.jpg"));

        seperator();


        ogE.addElement(new OptionsGruppeEintrag("2 sync. Laser", "Paar Laserkanonen", 0));
        ogE.addElement(new OptionsGruppeEintrag("2 Höllenfeuerraketen", "Paar Höllenfeuerraketen", 10));
        add(oe1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "2 Schwere Bolter", "Paar schwere Bolter", 3, 20));

        seperator();

        add(oe3 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Fliegerass", 3, 50));

        complete();
    }

    @Override
    public void refreshen() {
        oe1.setMaxAnzahl(squad.getModelle());
        oe2.setMaxAnzahl(squad.getModelle());
        oe3.setMaxAnzahl(squad.getModelle());
    }

}
