package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMScoutSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
	OptionsEinzelZaehler o2;
	OptionsUpgradeGruppe o3;
	RuestkammerStarter rkBoss;


	public IMScoutSquad() {
		name = "Scout Squad\n";
		überschriftSetzen = true;

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Scouts", 5, 10, getPts("Scout Squad")));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
		ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", getPts("Sniper rifle (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Astartes shotgun", getPts("Astartes shotgun")));
		ogE.addElement(new OptionsGruppeEintrag("Combat knife", getPts("Combat knife")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher (SM)")));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator(5);

		add(o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Camo cloak",5, getPts("Camo cloak")));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSergeant", "Sergeant");
		((IMSergeant)rkBoss.getKammer()).type = "Scout Squad";
		rkBoss.initKammer();
		rkBoss.setGrundkosten(getPts("Sergeant"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		rkBoss.setAbwaehlbar(false);
		rkBoss.setAktiv(true);
		if(!rkBoss.isSelected()) rkBoss.setSelected(true);
		o1x.setMaxAnzahl(squad.getModelle() - 1 -o1.getAnzahl()- o3.getAnzahl());
		o1x.setAnzahl(0,o1x.getMaxAnzahl());
		o1.setMaxAnzahl(squad.getModelle() - 1 - o3.getAnzahl()); // heavy weapon
		o2.setMaxAnzahl(squad.getModelle());
		
		if(squad.getModelle() > 5){
			power = 8;
		}else{
			power = 4;
		}
	}
}
