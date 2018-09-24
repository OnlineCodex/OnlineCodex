package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMLongFangs extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o1x;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkBoss2;
	RuestkammerStarter rkBoss3;

	public IMLongFangs() {
		name = "Long Fangs\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Long Fangs", 5, 6, getPts("Long Fangs"));
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addAll(IMSpaceWolvesHeavyWeapons.createRK("", "", buildaVater));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Long Fang Pack Leader");
		((IMSpaceWolvesRuestkammer)rkBoss.getKammer()).setType("Long Fang Pack Leader");
		rkBoss.initKammer();
		rkBoss.setGrundkosten(getPts("Long Fang Pack Leader"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);
		
		seperator();

		rkBoss2 = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Guard Pack Leader");
		((IMSpaceWolvesRuestkammer)rkBoss2.getKammer()).setType("Wolf Guard Pack Leader");
		rkBoss2.initKammer();
		rkBoss2.setGrundkosten(getPts("Long Fangs"));
		rkBoss2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss2);	
		
		seperator();

		rkBoss3 = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Guard Pack Leader in TA");
		((IMSpaceWolvesRuestkammer)rkBoss3.getKammer()).setType("Wolf Guard Pack Leader in Terminator Armour");
		rkBoss3.initKammer();
		rkBoss3.setGrundkosten(getPts("Wolf Guard Pack Leader in Terminator Armour"));
		rkBoss3.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss3);


		complete();
	}

	@Override
	public void refreshen() {
		o1x.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl());
		o1x.setAnzahl(0,squad.getModelle() - 1 - o1.getAnzahl());
		o1.setMaxAnzahl(squad.getModelle() - 1);
		rkBoss.setAbwaehlbar(false);
		
		rkBoss2.setAktiv(!rkBoss3.isSelected());
		rkBoss3.setAktiv(!rkBoss2.isSelected());
		
		power = 7;
		if(squad.getModelle()>5){
			power+=1;
		}
		if(rkBoss2.isSelected()){
			power +=2;
		}
		if(rkBoss3.isSelected()){
			power +=3;
		}
	}

}
