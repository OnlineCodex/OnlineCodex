package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMBikeSquad extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTrike;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsZaehlerGruppe o2;

	public IMBikeSquad() {
		name = "Bike Squad\n";
		grundkosten = 0;
		überschriftSetzen = true;

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines Biker", 3, 8, getPts("Bike Squad") + getPts("Twin boltgun")));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt gun", getPts("Bolt gun (SM)")));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();


		ogE.addAll(IMSpaceMarinesSpecialWeapons.createRK("", "", buildaVater));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSergeant", "Sergeant");
		((IMSergeant)rkBoss.getKammer()).type = "Bike Squad";
		rkBoss.initKammer();
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTrike = new RuestkammerStarter(ID, randAbstand, cnt, "IMTrikeKammer", "Attack Bike");
		rkTrike.initKammer();
		add(rkTrike);
		
		complete();
	}

	@Override
	public void refreshen() {
		if(!rkBoss.isSelected()) rkBoss.setSelected(true);
		
		o1.setMaxAnzahl(squad.getModelle()-1-o2.getAnzahl());
		
		if((squad.getModelle()-1-o1.getAnzahl())>1){
			o2.setMaxAnzahl(2);
		}else if((squad.getModelle()-1-o1.getAnzahl())>0){
			o2.setMaxAnzahl(1);
		}else{
			o2.setMaxAnzahl(0);
		}
		
		o1x.setMaxAnzahl(squad.getModelle()-1-o1.getAnzahl()-o2.getAnzahl());
		o1x.setAnzahl(0, squad.getModelle()-1-o1.getAnzahl()-o2.getAnzahl());
		
		power = 6;
		if(squad.getModelle()>6){
			power = 14;
		} else if(squad.getModelle()>3){
			power = 11;
		}
		if(rkTrike.isSelected()){
			power +=3;
		}
		
	}

}

