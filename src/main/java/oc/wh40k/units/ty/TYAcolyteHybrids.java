package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TYAcolyteHybrids extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o2, o3, o4;
	RuestkammerStarter rkBoss;

	public TYAcolyteHybrids() {
		name = "Acolyte Hybrids";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Acolyte Hybrids", 5, 20, getPts("Acolyte Hybrids"));
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Cultist knife & Rending claw", getPts("Cultist knife") + getPts("Rending claws (GSC)")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy rock drill", getPts("Heavy rock drill")));
		ogE.addElement(new OptionsGruppeEintrag("Heavy rock cutter", getPts("Heavy rock cutter")));
		ogE.addElement(new OptionsGruppeEintrag("Heavy rock saw", getPts("Heavy rock saw")));
		ogE.addElement(new OptionsGruppeEintrag("Demolition charges", getPts("Demolition charges")));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
		ogE.addElement(new OptionsGruppeEintrag("Hand flamer", getPts("Hand flamer")));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cult icon", getPts("Cult icon")));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "TYLeader", "Acolyte Leader");
		((TYLeader)rkBoss.getKammer()).type = "Acolyte";
		rkBoss.initKammer();
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - 1);
		o2.setMaxAnzahl((squad.getModelle()/5)*2);
		o3.setMaxAnzahl(squad.getModelle() - 1);
		
		if(squad.getModelle() > 15)
			power = 20;
		else if(squad.getModelle() > 10)
			power = 15;
		else if(squad.getModelle() > 5)
			power = 10;
		else
			power = 5;
	}
}