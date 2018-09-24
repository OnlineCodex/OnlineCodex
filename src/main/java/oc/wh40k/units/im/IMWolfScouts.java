package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMWolfScouts extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o1x, o1y, o1z;
	OptionsZaehlerGruppe o2;
	OptionsEinzelZaehler camo;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkBoss2;

	public IMWolfScouts() {
		name = "Wolf Scouts\n";
		grundkosten = 0;
		überschriftSetzen = true;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Wolf Scouts", 5, 10, getPts("Wolf Scouts"));
		add(squad);

		seperator();
		
		add(camo = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Camo cloaks", 4, getPts("Camo cloak")));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("bolt pistol (SM)")));
		add(o1z = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
		add(o1y = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("boltgun (SM)")));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Combat knife", getPts("combat knife")));
		ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", getPts("sniper rifle (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Astartes shotgun", getPts("Astartes shotgun")));
		ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		ogE.addAll(IMSpaceWolvesMeleeWeapons.createRK("", "", buildaVater));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Scout Pack Leader");
		((IMSpaceWolvesRuestkammer)rkBoss.getKammer()).setType("Wolf Scout Pack Leader");
		rkBoss.initKammer();
		rkBoss.setGrundkosten(getPts("Wolf Scout Pack Leader"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);
		
		seperator();

		rkBoss2 = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Guard Pack Leader");
		((IMSpaceWolvesRuestkammer)rkBoss2.getKammer()).setType("Wolf Guard Pack Leader");
		rkBoss2.initKammer();
		rkBoss2.setGrundkosten(getPts("Blood Claws"));
		rkBoss2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss2);	
	
		complete();
	}

	@Override
	public void refreshen() {
		camo.setMaxAnzahl(squad.getModelle() - 1);
		
		o1z.setMaxAnzahl(squad.getModelle() - 1 - o1y.getAnzahl());
		o1z.setAnzahl(0, squad.getModelle() - 1 - o1y.getAnzahl());
		
		o1x.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl() - o2.getAnzahl());
		o1x.setAnzahl(0,squad.getModelle() - 1 - o1.getAnzahl() - o2.getAnzahl());
		o1.setMaxAnzahl(squad.getModelle()==10?2:1);
		
		o2.setMaxAnzahl(1-o1y.getAnzahl());
		o1y.setMaxAnzahl(1-o2.getAnzahl());
		
		rkBoss.setAbwaehlbar(false);
		
		power = 4;
		
		if(squad.getModelle()>5){
			power+=4;
		}
		if(rkBoss2.isSelected()){
			power +=2;
		}
	}

}
