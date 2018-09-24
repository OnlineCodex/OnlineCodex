package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMSwiftclaws extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o3;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkBoss2;

	public IMSwiftclaws() {
		checkBuildaVater();
		name = "Swiftclaws\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Swiftclaw", 3, 10, getPts("Swiftclaws") + getPts("Twin boltgun"));
		add(squad);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		o3.setAnzahl(0, 3);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
		ogE.addAll(IMSpaceWolvesSpecialWeapons.createRK("", "", buildaVater));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Swiftclaw Attack Bike (HB)", "Swiftclaw Attack Bike with heavy bolter", getPts("Swiftclaw Attack Bike") + getPts("Heavy Bolter (SM)") + getPts("Twin boltgun")));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Swiftclaw Attack Bike (MM)", "Swiftclaw Attack Bike with multi-melta", getPts("Swiftclaw Attack Bike") + getPts("Multi-melta (SM)") + getPts("Twin boltgun")));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Swiftclaw Pack Leader");
		((IMSpaceWolvesRuestkammer)rkBoss.getKammer()).setType("Swiftclaw Pack Leader");
		rkBoss.initKammer();
		rkBoss.setGrundkosten(getPts("Swiftclaw Pack Leader"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);
		
		seperator();

		rkBoss2 = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "Wolf Guard Bike Leader");
		((IMSpaceWolvesRuestkammer)rkBoss2.getKammer()).setType("Wolf Guard Bike Leader");
		rkBoss2.initKammer();
		rkBoss2.setGrundkosten(getPts("Swiftclaws") +  getPts("Twin boltgun"));
		rkBoss2.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss2);

		complete();
	}

	@Override
	public void refreshen() {
		oe2.setAktiv(!oe3.isSelected());
		oe3.setAktiv(!oe2.isSelected());
		
		int anzahl = squad.getModelle() - 1 - o1.getAnzahl() - ((IMSpaceWolvesRuestkammer)rkBoss.getKammer()).o2.getAnzahl();
		
		o1.setMaxAnzahl(1 - ((IMSpaceWolvesRuestkammer)rkBoss.getKammer()).o2.getAnzahl());
		
		o3.setMaxAnzahl(anzahl);
		o3.setLegal(o3.getAnzahl() == anzahl);
		
		rkBoss.setAbwaehlbar(false);
		
		power = 6;
		if(squad.getModelle() > 6){
			power +=11;
		} else if(squad.getModelle() > 3){
			power +=5;
		}
		if(oe2.isSelected() || oe3.isSelected()){
			power += 3;
		}
		if(rkBoss2.isSelected()){
			power += 3;
		}
	}

}
