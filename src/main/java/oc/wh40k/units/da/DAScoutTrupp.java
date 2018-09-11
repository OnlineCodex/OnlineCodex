package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DAScoutTrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1, o2;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkBoss;
    OptionsZaehlerGruppe waffen;
    OptionsZaehlerGruppe bolter;
    OptionsZaehlerGruppe flakk;
    OptionsUpgradeGruppe tarnmantel;

	public DAScoutTrupp() {
		//name = "Scout-Trupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/DAScoutSquad.gif"));

		seperator();

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Scouts", 5, 10, 12);
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Tarnmäntel", 10));
		add(tarnmantel = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Bolter", "Bolter", 0));
		add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()-1));
		ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", "Space-Marine-Schrotflinte", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kampfmesser", "Kampfmesser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Scharfschützengewehr", "Scharfschützengewehr", 0));
		add(waffen = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()-1));
		bolter.setAnzahl(0, squad.getModelle()-1);
		
		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 8));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		ogE.addElement(new OptionsGruppeEintrag("Flugabwehrraketen", "Flugabwehrraketen", 10));
		add(flakk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DASergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(true, false, false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        int count = squad.getModelle();
		tarnmantel.setPreis("Tarnmäntel", 2*squad.getModelle());
		tarnmantel.setMaxAnzahl(count);
		
		waffen.setMaxAnzahl(count - 1 - (o2.isSelected()?1:0));
		bolter.setMaxAnzahl(count - 1 - waffen.getAnzahl()- (o2.isSelected()?1:0));
		bolter.setAnzahl(0,bolter.getMaxAnzahl());
		
        flakk.setMaxAnzahl(o2.isSelected("Raketenwerfer")?1:0);
	}

}
