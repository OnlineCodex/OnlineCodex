package oc.wh40k.units.ch;


import oc.*;

public class CHHavocs extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o2;
	private final RuestkammerStarter rkBoss;
	private final OptionsUpgradeGruppe mark;

    public CHHavocs() {
        name = "Havocs";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Havocs", 5, 5, getPts("Havocs"), "Havocs");
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ChaosHavocs.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", getPts("Heavy Bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", getPts("Autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        ogE.addElement(new OptionsGruppeEintrag("Reaper Chaincannon", getPts("Reaper Chaincannon")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        o2.setAnzahl(0, 4);
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Aspiring Champion", 1);
        ((CHWaffenkammer) rkBoss.getKammer()).setChampion(true);
        ((CHWaffenkammer) rkBoss.getKammer()).setHavoc(true);
        rkBoss.initKammer(true, true, true, true);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setGrundkosten(getPts("Aspiring Champion"));
        ((CHWaffenkammer) rkBoss.getKammer()).setDefaultCloceCombat("Chainsword");
        ((CHWaffenkammer) rkBoss.getKammer()).setDefaultRanged("Flamer");
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        power = 7;
    }

}
