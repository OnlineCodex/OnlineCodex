package oc.wh40k.units.ch;


import oc.*;

public class CHHavocs extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o2;
    RuestkammerStarter rkBoss;
    OptionsZaehlerGruppe nahkampfwaffe;
    OptionsUpgradeGruppe ikone;
    OptionsUpgradeGruppe mark;

    public CHHavocs() {
        name = "Havocs";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Havocs", 5, 10, getPts("Havocs"), "Havocs");
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosHavocs.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun")));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
        add(nahkampfwaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        nahkampfwaffe.setAnzahl(0, squad.getModelle() - 1);
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chaos icon", getPts("Icon of Vengeance")));
        add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Autocannon", getPts("Autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", getPts("Heavy Bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Aspiring Champion", 1);
        ((CHWaffenkammer) rkBoss.getKammer()).setChampion(true);
        rkBoss.initKammer(true, true, true, true);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setGrundkosten(getPts("Aspiring Champion"));
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {

        int subtractor = 1; // boss
        nahkampfwaffe.setMaxAnzahl(squad.getModelle() - subtractor);

        nahkampfwaffe.setMaxAnzahl(squad.getModelle() - 1 - o2.getAnzahl());

        power = 7 +
                ((squad.getModelle() == 10) ? 3 : 0);
    }

}
