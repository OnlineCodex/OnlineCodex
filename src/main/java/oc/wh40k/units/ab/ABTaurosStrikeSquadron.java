package oc.wh40k.units.ab;


import oc.*;

public class ABTaurosStrikeSquadron extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe oe1;
    OptionsZaehlerGruppe oe1x;
    OptionsEinzelZaehler oe2;
    OptionsEinzelZaehler oe3;
    OptionsEinzelZaehler oe4;
    OptionsEinzelZaehler o1;
    OptionsEinzelZaehler o2;

    public ABTaurosStrikeSquadron() {
        name = "Tauros Strike Squadron";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Tauros", 1, 3, 40);
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", "Tauros w/ heavy flamer", 0));
        add(oe1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("Tauros grenade launcher", "Tauros w/ grenade launcher", 5));
        ogE.addElement(new OptionsGruppeEintrag("TL multi-laser", "Tauros Venator w/ twin-linked multi-laser", 20));
        ogE.addElement(new OptionsGruppeEintrag("TL lascannon", "Tauros Venator w/ twin-linked lascannon", 35));
        add(oe1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator(5);

        add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Hunter-killer missile", 3, 10));
        add(oe4 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Extra armour", 3, 15));

        seperator();

        add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Smoke launchers", 3, 5));
        add(o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Camo netting", 3, 10));

        seperator();


        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        oe1x.setMaxAnzahl(squad.getModelle() - oe1.getAnzahl());
        oe1x.setAnzahl(0, oe1x.getMaxAnzahl());

        oe1.setMaxAnzahl(squad.getModelle());

        oe2.setMaxAnzahl(squad.getModelle());
        oe4.setMaxAnzahl(squad.getModelle());
        o1.setMaxAnzahl(squad.getModelle());
        o2.setMaxAnzahl(squad.getModelle());


    }

}
