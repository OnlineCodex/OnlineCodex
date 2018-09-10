package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;

public class DARavenwingKommandoschwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade standard;
	OptionsUpgradeGruppe specialStandards;
	OptionsEinzelZaehler championOption;

	public DARavenwingKommandoschwadron() {
		name = "Ravenwing-Kommandoschwadron\n";
		grundkosten = 0;
		this.setEintragsCNT(0);
		überschriftSetzen=true;

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Kompanieveteranen", 3, 5, 40));
		
		add(ico = new oc.Picture("oc/wh40k/images/DACommandSquad.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kompaniestandarte", "Ravenwing-Kompaniestandarte", 15));
		ogE.addElement(new OptionsGruppeEintrag("Verehrte Standarte", 25));
		ogE.addElement(new OptionsGruppeEintrag("Banner der Vergeltung", 45));
		ogE.addElement(new OptionsGruppeEintrag("Banner der Verwüstung", 65));
		ogE.addElement(new OptionsGruppeEintrag("Banner der Stärke", 85));
		add(specialStandards = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Granatwerfer", "Ravenwing-Granatwerfer", 1, 0));
		
		seperator();

		add(championOption=new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Ravenwing-Champion", "Upgrade zum Ravenwing-Champion", 1, 5));

		seperator();
		
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Ravenwing-Apothecarius", "Upgrade zum Ravenwing-Apothecarius", 1, 30));
		
		addToInformationVector("DABikeKommando", 1);
		
		complete();
	}

	@Override
	public void deleteYourself() { 
		addToInformationVector("DABikeKommando", -1);
		//Einzigartige Banner
				if(ordensbanner){
					addToInformationVector("DARavenwingStandarte", -1);
				}
				if(bdVergeltung){
					addToInformationVector("DABannerDerVergeltung", -1);
				}
				if(bdVerwuestung){
					addToInformationVector("DABannerDerVerwuestung", -1);
				}
				if(bdStaerke){
					addToInformationVector("DABannerDerStaerke", -1);
				}
				if(champion){
					addToInformationVector("DARavenChampion", -1);
				}
		super.deleteYourself();
	}

	
	boolean ordensbanner=false;
	boolean bdVergeltung=false;
	boolean bdVerwuestung=false;
	boolean bdStaerke=false;
	boolean champion=false;
	@Override
	public void refreshen() {
		
		//Einzigartige Banner
		if(ordensbanner!=specialStandards.isSelected("Ravenwing-Kompaniestandarte")){
			ordensbanner=specialStandards.isSelected("Ravenwing-Kompaniestandarte");
			addToInformationVector("DARavenwingStandarte", (ordensbanner?1:-1));
			RefreshListener.fireRefresh();
		}
		specialStandards.setLegal("Ravenwing-Kompaniestandarte", !specialStandards.isSelected("Ravenwing-Kompaniestandarte") || 
				getCountFromInformationVector("DARavenwingStandarte")<=1);
		
		if(bdVergeltung!=specialStandards.isSelected("Banner der Vergeltung")){
			bdVergeltung=specialStandards.isSelected("Banner der Vergeltung");
			addToInformationVector("DABannerDerVergeltung", (bdVergeltung?1:-1));
			RefreshListener.fireRefresh();
		}
		specialStandards.setLegal("Banner der Vergeltung", !specialStandards.isSelected("Banner der Vergeltung") || 
				getCountFromInformationVector("DABannerDerVergeltung")<=1);
		
		if(bdVerwuestung!=specialStandards.isSelected("Banner der Verwüstung")){
			bdVerwuestung=specialStandards.isSelected("Banner der Verwüstung");
			addToInformationVector("DABannerDerVerwuestung", (bdVerwuestung?1:-1));
			RefreshListener.fireRefresh();
		}
		specialStandards.setLegal("Banner der Verwüstung", !specialStandards.isSelected("Banner der Verwüstung") || 
				getCountFromInformationVector("DABannerDerVerwuestung")<=1);
		
		if(bdStaerke!=specialStandards.isSelected("Banner der Stärke")){
			bdStaerke=specialStandards.isSelected("Banner der Stärke");
			addToInformationVector("DABannerDerStaerke", (bdStaerke?1:-1));
			RefreshListener.fireRefresh();
		}
		specialStandards.setLegal("Banner der Stärke", !specialStandards.isSelected("Banner der Stärke") || 
				getCountFromInformationVector("DABannerDerStaerke")<=1);
		
		if(champion!=championOption.isSelected()){
			champion=championOption.isSelected();
			addToInformationVector("DARavenChampion", (champion?1:-1));
			RefreshListener.fireRefresh();
		}
		championOption.setLegal(!championOption.isSelected() || 
				getCountFromInformationVector("DARavenChampion")<=1);
		
		if(getCountFromInformationVector("DABikeHQ")<getCountFromInformationVector("DABikeKommando")){
			setFehlermeldung("0-"+getCountFromInformationVector("DABikeHQ")+" Ravenw.Kommandos");
		}else{
			setFehlermeldung("");
		}
	}

}