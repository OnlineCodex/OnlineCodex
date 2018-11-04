package oc.wh40k.units.sm;

import oc.*;

public class SMTarantulaBatterie extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade tn;
    OptionsEinzelUpgrade st;

    public SMTarantulaBatterie() {
        name = "Tarantula-Batterie\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Tarantula", "Tarantulas", 1, 3, 15);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/SMTarantulaBatterie.jpg"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multimelter", "Multimelter mit Suchscheinwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hyperios-Raketenwerfer", 20));
        ogE.addElement(new OptionsGruppeEintrag("Hyperios-Kommandoplattform", 30));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(tn = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tarnnetze", 10));
        add(st = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schocktruppen", 10));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setAktiv(!o2.isSelected());
        o2.setAktiv(!o1.isSelected());

        o1.setLegal(o1.getAnzahl() == squad.getModelle());
        o2.setLegal(o2.getAnzahl() == squad.getModelle());

        tn.setPreis(squad.getModelle() * 10);
        st.setPreis(squad.getModelle() * 10);
    }

}
