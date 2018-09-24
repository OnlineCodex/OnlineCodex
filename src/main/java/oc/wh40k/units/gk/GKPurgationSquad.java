package oc.wh40k.units.gk;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class GKPurgationSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransport;

	public GKPurgationSquad() {
		name = "Purgatortrupp\n";
		grundkosten = 10;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Grey Knights", 5, 10, 20);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/GKPurgatortrupp.jpg"));
		

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
		ogE.addElement(new OptionsGruppeEintrag("Erlöser-Flamer", "Erlöser-Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Psipulser", 10));
		ogE.addElement(new OptionsGruppeEintrag("Psibolter", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "GKJusticar", "Upgrade zum Justicar");
		rkBoss.initKammer();
        rkBoss.setButtonText("Upgrade zum Justicar", false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "GKTransporterKammer", "Transporter");
		rkTransport.initKammer(true, false);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);

		int subtractor = o2.getAnzahl() + 1; // last one is the boss

		o1.setMaxAnzahl(squad.getModelle() - subtractor); // heavy weapon
		o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - subtractor);
		o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - subtractor);

        o2def.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss
        o2def.setAnzahl(0, squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss

		rkTransport.getPanel().setLocation(
			(int) rkTransport.getPanel().getLocation().getX(),
			(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
		);
	}

}
