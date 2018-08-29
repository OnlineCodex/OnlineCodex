package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMWolfGuardinTerminatorArmour extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o1x;
	OptionsZaehlerGruppe o2, o2x;
	OptionsZaehlerGruppe o3, o4;
	OptionsZaehlerGruppe wolfsklauen;
	RuestkammerStarter rkBoss3;
	


	public IMWolfGuardinTerminatorArmour() {
		name = "Wolf Guard in Terminator Armour\n";
		grundkosten = 0;
		überschriftSetzen = true;

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Wolf Guard in Terminator Armour", 5, 10, getPts("Wolf Guard in Terminator Armour")));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		ogE.addAll(IMSpaceWolvesTerminatorMeleeWeapons.createRK("", "", buildaVater));
		ogE.remove("Power fist");
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
		add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
		ogE.addAll(IMSpaceWolvesTerminatorMeleeWeapons.createRK("", "", buildaVater));
		ogE.addAll(IMSpaceWolvesCombiWeapons.createRK("", "", buildaVater));
		ogE.remove("Storm bolter");
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
		ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
		add(wolfsklauen = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Cyclone missile launcher", getPts("Cyclone missile launcher")));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

		ogE.addAll(IMSpaceMarinesTerminatorHeavyWeapons.createRK("", "", buildaVater));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		
		seperator();
		
		rkBoss3 = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Guard Pack Leader in TA");
		((IMSpaceWolvesRuestkammer)rkBoss3.getKammer()).setType("Wolf Guard in Terminator Armour");
		rkBoss3.initKammer();
		rkBoss3.setGrundkosten(0); //Schon in Squadkosten enthalten
		rkBoss3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss3);
		rkBoss3.setAbwaehlbar(false);
		
		complete();
	}
     

	@Override
	public void refreshen() {
		rkBoss3.setAbwaehlbar(false);
		o1x.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl() - wolfsklauen.getAnzahl());
		o1x.setAnzahl(0,squad.getModelle() - 1 - o1.getAnzahl() - wolfsklauen.getAnzahl());
		o1.setMaxAnzahl(squad.getModelle() - 1 - wolfsklauen.getAnzahl());

		o2x.setMaxAnzahl(squad.getModelle() - 1 - o2.getAnzahl() - wolfsklauen.getAnzahl() - o4.getAnzahl());
		o2x.setAnzahl(0,squad.getModelle() - 1 - o2.getAnzahl() - wolfsklauen.getAnzahl() - o4.getAnzahl());
		o2.setMaxAnzahl(squad.getModelle() - 1 - wolfsklauen.getAnzahl() - o4.getAnzahl());
		
		int fkfree = squad.getModelle() - 1 - o2.getAnzahl() + wolfsklauen.getAnzahl();
		
		o3.setMaxAnzahl((squad.getModelle()/5 - o4.getAnzahl()));
		o4.setMaxAnzahl((squad.getModelle()/5 - o3.getAnzahl())<fkfree?(squad.getModelle()/5 - o3.getAnzahl()):fkfree);
		
		wolfsklauen.setMaxAnzahl(squad.getModelle() - 1 - (o1.getAnzahl()>(o2.getAnzahl()+o4.getAnzahl())?o1.getAnzahl():(o2.getAnzahl()+o4.getAnzahl())));
		
		power = 15;
		if(squad.getModelle()>5){
			power+=15;
		}
	}
}
