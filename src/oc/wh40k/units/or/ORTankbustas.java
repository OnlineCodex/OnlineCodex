package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class ORTankbustas extends Eintrag {

	AnzahlPanel Panzaknakkaz;
	OptionsEinzelZaehler Sprengsquiks;
	OptionsEinzelZaehler Panzakloppa;
	OptionsEinzelZaehler Pistolen;
	RuestkammerStarter Boss;

	public ORTankbustas() {

		kategorie = 2;
		grundkosten = 0;
		add(Panzaknakkaz = new AnzahlPanel(ID, randAbstand, cnt, "Tankbustas", 5, 15, getPts("Tankbustas")+ getPts("Rokkit launcha")+ getPts("Stikkbombs")+ getPts("Tankbusta bombs")));
		add(ico = new oc.Picture("oc/wh40k/images/Panzaknakkaz.gif"));
		
		seperator();

		add(Sprengsquiks = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Bomb Squigs", 2, getPts("Bomb Squig")));
		add(Panzakloppa = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Tankhammer", 2, getPts("Tankhammer")- getPts("Rokkit launcha")));
		add(Pistolen = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Pair of rokkit pistols", 1, getPts("Pair of rokkit pistols")- getPts("Rokkit launcha")));

		seperator();

		Boss = new RuestkammerStarter(ID, randAbstand, cnt, "ORWaffenUndGeschenke", "Boss Nob");
		Boss.setGrundkosten(getPts("Boss Nob"));
		((ORWaffenUndGeschenke)Boss.getKammer()).setDefaultNK("no weapon");
		((ORWaffenUndGeschenke)Boss.getKammer()).setDefaultFK("Rokkit launcha");
		Boss.initKammer(false,false,false,false,true);
		Boss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(Boss);
		Boss.setAbwaehlbar(false);
		
		seperator();

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		Boss.setAbwaehlbar(true);
		Sprengsquiks.setMaxAnzahl(Panzaknakkaz.getModelle()/5*2);
		Pistolen.setMaxAnzahl(Panzaknakkaz.getModelle()/5);
		if(Boss.isSelected()){
			grundkosten = - getPts("Rokkit launcha");
		} else {
			grundkosten = 0;
		}
		power = 4 + (Panzaknakkaz.getModelle()-5)/5 * 3 + (Panzaknakkaz.getModelle()%5 > 0 ? 1 : 0) * 3;
	}
}
