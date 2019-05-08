package oc.wh40k.units.ch;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CHHavocs extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o2;
	private final RuestkammerStarter rkBoss;
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
        ogE.addElement(new OptionsGruppeEintrag("Reaper Chaincannon", getPts("Reaper Chaincannon")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        o2.setAnzahl(0, 4);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Aspiring Champion", 1);
        ((CHWaffenkammer) rkBoss.getKammer()).setChampion(true);
        ((CHWaffenkammer) rkBoss.getKammer()).setHavoc(true);
        ((CHWaffenkammer) rkBoss.getKammer()).setDefaultCloceCombat("Chainsword");
        ((CHWaffenkammer) rkBoss.getKammer()).setDefaultRanged("Flamer");
        rkBoss.initKammer(true, true, true, true);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setGrundkosten(getPts("Aspiring Champion"));
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        power = 7;
    }

}
