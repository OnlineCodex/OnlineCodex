package oc.wh40k.units.gk;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class GKTerminatorSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkRaider;

    boolean thawnSelected = false;

    public GKTerminatorSquad() {
        name = "TerminatorSquad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Terminatoren", 5, 10, 33);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/GKTerminatortrupp.jpg"));
        
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
        add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 2));
        ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 4));
        ogE.addElement(new OptionsGruppeEintrag("Wehrstab", "Nemesis-Wehrstab", 5));
        ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        add(o2def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Erlöser-Flamer", "Erlöser-Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Psipulser", 15));
        ogE.addElement(new OptionsGruppeEintrag("Psibolter", 20));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "GKJusticar", "Upgrade zum Justicar");
        rkBoss.initKammer();
        rkBoss.setButtonText("Upgrade zum Justicar", false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);
        
        seperator();
        
		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "GKLandRaiderKammer", "Land Raider");
		rkRaider.initKammer();
		rkRaider.setButtonText("Land Raider");
		add(rkRaider);

        complete();
    }

    @Override
    public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);

        int subtractor = 1; // last one is the boss

        o1.setMaxAnzahl(squad.getModelle() - subtractor); // heavy weapon
        o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - subtractor);
        o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - subtractor);

        o2.setMaxAnzahl((int) Math.floor(squad.getModelle() / 5));
        o2def.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss
        o2def.setAnzahl(0, squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss
        
		rkRaider.getPanel().setLocation(
				(int) rkRaider.getPanel().getLocation().getX(),
				(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
			);
    }

}
