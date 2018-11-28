package oc.wh40k.units.ch;


import oc.*;

public class CHChaosBikers extends Eintrag {

    AnzahlPanel squad;
    RuestkammerStarter rkBoss;
    OptionsUpgradeGruppe ikone;
    OptionsZaehlerGruppe bp, special, bike, combi;
    OptionsUpgradeGruppe mark;

    public CHChaosBikers() {
        //name = "Chaosbiker\n";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Bikers", 3, 9, getPts("Chaos Bikers"), "Chaos Bikers");
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosBikers.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Chaos icon", getPts("Icon of Vengeance")));
        add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
        add(bp = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        bp.setAnzahl(0, squad.getModelle() - 1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        add(special = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
        add(combi = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        combi.setAnzahl(0, squad.getModelle() - 1);

        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        add(bike = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Chaos Biker Champion", 1);
        ((CHWaffenkammer) rkBoss.getKammer()).setChampion(true);
        ((CHWaffenkammer) rkBoss.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer) rkBoss.getKammer()).setDefaultNK("no weapon");
        ((CHWaffenkammer) rkBoss.getKammer()).setBiker(true);
        rkBoss.initKammer(false, true, true, false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setGrundkosten(getPts("Chaos Biker Champion") + getPts("Combi-bolter"));
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        bp.setMaxAnzahl(squad.getModelle() - 1 - special.getAnzahl());
        special.setMaxAnzahl(2 - bike.getAnzahl());
        bike.setMaxAnzahl(2 - special.getAnzahl());
        combi.setMaxAnzahl(squad.getModelle() - 1 - bike.getAnzahl());
        combi.setAnzahl(0, squad.getModelle() - 1 - bike.getAnzahl());

        power = 7 +
                ((squad.getModelle() == 6) ? 5 : 0) +
                ((squad.getModelle() == 9) ? 10 : 0);
    }

}
