package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CDHerolddesSlaanesh extends CDHerold {
	
	OptionsZaehlerGruppe o1,o2,o3;
	OptionsUpgradeGruppe praesenz, mount;
	RuestkammerStarter artefakte;
	
	public CDHerolddesSlaanesh() {

		name = "Herold des Slaanesh";

		grundkosten = 45;

		this.setEintragsCNT(0.5);

		add(ico = new oc.Picture("oc/wh40k/images/CDHerolddesSlaanesh.gif"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnungen", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnungen", 20));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Erhabene Belohnungen", 30));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 1", 25));
		ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 2", 50));
		add(praesenz = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Präsenz der Anmut", "Geringe Präsenz der Anmut", 10));
		ogE.addElement(new OptionsGruppeEintrag("Präsenz des Flinkheit", "Mächtige Präsenz der Flinkheit", 20));
		ogE.addElement(new OptionsGruppeEintrag("Präsenz der Betörung", "Erhabene Präsenz der Betörung", 30));
		add(praesenz = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Slaaneshpferd", 15));
		ogE.addElement(new OptionsGruppeEintrag("Jagdstreitwagen", "Jagdstreitwagen", 30));
		ogE.addElement(new OptionsGruppeEintrag("Erh. Jagdstreitwagen", "Erhabender Jagdstreitwagen", 80));
		add(mount = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		//HöllengeschmiedeteArtefakte
		artefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CDArtefakte", "");
		artefakte.initKammer();
		artefakte.setButtonText(BuildaHQ.translate("Artefakte"));
		add(artefakte);

		((CDArtefakte)artefakte.getKammer()).enableEntry(13);
		((CDArtefakte)artefakte.getKammer()).enableEntry(15);
		((CDArtefakte)artefakte.getKammer()).enableEntry(16);
		
		complete();
	}

	@Override
	public void refreshen() {
        super.refreshen();
		int max = 30;
		int geringeBelohnung = 10;
		int mächtigeBelohnung = 20;
		int erhabeneBelohnung = 30;
		
		int freePoints = max - o1.getAnzahl()*geringeBelohnung - o2.getAnzahl()*mächtigeBelohnung - o3.getAnzahl()*erhabeneBelohnung;
		if(freePoints < erhabeneBelohnung){
			o3.setMaxAnzahl(o3.getAnzahl());
		} else {
			o3.setMaxAnzahl(freePoints/erhabeneBelohnung);
		}
		if(freePoints < mächtigeBelohnung){
			o2.setMaxAnzahl(o2.getAnzahl());
		} else {
			o2.setMaxAnzahl(o2.getAnzahl() + freePoints/mächtigeBelohnung);
		}
		if(freePoints < geringeBelohnung){
			o1.setMaxAnzahl(o1.getAnzahl());
		} else {
			o1.setMaxAnzahl(o1.getAnzahl() + freePoints/geringeBelohnung);
		}
		
		if(((CDArtefakte)artefakte.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
	}
}
