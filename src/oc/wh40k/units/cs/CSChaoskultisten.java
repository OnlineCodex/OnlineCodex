package oc.wh40k.units.cs;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CSChaoskultisten extends Eintrag {

	AnzahlPanel kultisten;
	OptionsUpgradeGruppe mal;
	RuestkammerStarter champion;
	OptionsEinzelUpgrade schrotflinte;
	OptionsZaehlerGruppe schwereWaffe;
	OptionsZaehlerGruppe autogewehre;

	public CSChaoskultisten() {
		//name = "Chaoskultisten\n";
		grundkosten = 0;
		
		kultisten = new AnzahlPanel(ID, randAbstand, cnt, "Chaoskultisten", 10, 35, 4);
		add(kultisten);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosKultisten.gif"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 2));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 1));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 2));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 1));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Sturmgewehr", "Sturmgewehr", 1));
		add(autogewehre = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Maschinengewehr", 5));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		schwereWaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
		add(schwereWaffe);
		
		seperator();

		champion = new RuestkammerStarter(ID, randAbstand, cnt, "CSKultistenChampion", "Champion");
		champion.initKammer();
        champion.setUeberschriftTrotzNullKostenAusgeben(true);
        champion.setGrundkosten(10);
		add(champion);
		champion.setAbwaehlbar(false);
		
		seperator(0);
		
		complete();

	}

	@Override
	public void refreshen() {
		int count = kultisten.getModelle();
		
		mal.setPreis("Mal des Khorne", 2 * count);
		mal.setPreis("Mal des Tzeentch", 1 * count);
		mal.setPreis("Mal des Nurgle", 2 * count);
		mal.setPreis("Mal des Slaanesh", 1 * count);
		
		schwereWaffe.setMaxAnzahl(kultisten.getModelle() / 10);
		
		int subtractor = schwereWaffe.getAnzahl() + 1; // last one is the boss
		
		autogewehre.setMaxAnzahl(kultisten.getModelle() - subtractor);
	}
}
