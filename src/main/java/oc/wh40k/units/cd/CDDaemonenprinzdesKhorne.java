package oc.wh40k.units.cd;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CDDaemonenprinzdesKhorne extends Eintrag {

	AnzahlPanel CDDaemonenprinzdesChaos;
	OptionsZaehlerGruppe belohnungen;
	OptionsZaehlerGruppe o1,o2,o3,o4;
	OptionsEinzelUpgrade mal;
	RuestkammerStarter artefakte;
	
	boolean nurgleBild;

	public CDDaemonenprinzdesKhorne() {
		name = "Dämonenprinz";
		grundkosten = 145;

		add(ico = new oc.Picture("oc/wh40k/images/CDDaemonenprinzdesChaos.gif"));

		add(mal = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dämon des Khorne", 15));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dämonischer Flug", 40));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Warpgeschmiedete Rüstung", "Warprüstung", 20));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnungen", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnungen", 20));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Erhabene Belohnungen", 30));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		//HöllengeschmiedeteArtefakte
		artefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CDArtefakte", "");
		artefakte.initKammer();
		artefakte.setButtonText(BuildaHQ.translate("Artefakte"));
		add(artefakte);

		((CDArtefakte)artefakte.getKammer()).enableEntry(0);
		((CDArtefakte)artefakte.getKammer()).enableEntry(1);
		((CDArtefakte)artefakte.getKammer()).enableEntry(2);
		((CDArtefakte)artefakte.getKammer()).enableEntry(3);
		((CDArtefakte)artefakte.getKammer()).enableEntry(4);
		((CDArtefakte)artefakte.getKammer()).enableEntry(5);
		
		complete();
	}

	@Override
	public void refreshen() {
		mal.setSelected(true);
		       
		int max = 50;
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
