package oc.wh40k.units.da;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class DAKommandotrupp extends Eintrag {
	
	OptionsEinzelZaehler championOption;
	OptionsEinzelZaehler apoOption;
	OptionsEinzelUpgrade standard;
	OptionsUpgradeGruppe specialStandards;
	RuestkammerStarter ot;
	OptionsEinzelZaehler o1, bomben, sturmschild, kettenschwert, boltpistole;
	OptionsZaehlerGruppe waffen;

	public DAKommandotrupp() {
		name = "Kommandotrupp";
		grundkosten = 100;
		this.setEintragsCNT(0);

		add(ico = new oc.Picture("oc/wh40k/images/DACommandSquad.gif"));

		seperator();

		add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Plasmapistole", 2, 15));

		add(bomben = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Melterbomben", 5, 5));
		add(sturmschild = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sturmschild", 5, 15));

		seperator(8);
		add(boltpistole = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Boltpistole", 5, 0));
		boltpistole.setAnzahl(5);
		add(kettenschwert = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Kettenschwert", 5, 0));
		kettenschwert.setAnzahl(5);
		
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", "Kombiflammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombiplasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 35));
		add(waffen = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 10));
		
		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Kompaniestandarte", 15));
		ogE.addElement(new OptionsGruppeEintrag("Verehrte Standarte", 25));
		ogE.addElement(new OptionsGruppeEintrag("Ordensbanner", "Ordensbanner der Dark Angels", 45));
		ogE.addElement(new OptionsGruppeEintrag("Banner der Vergeltung", 45));
		ogE.addElement(new OptionsGruppeEintrag("Banner der Verwüstung", 65));
		ogE.addElement(new OptionsGruppeEintrag("Banner der Stärke", 85));
		add(specialStandards = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(championOption = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Kompaniechampion", "Upgrade zum Kompaniechampion", 1, 15));

		seperator();
		
		add(apoOption = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Apothecarius", "Upgrade zum Apothecarius", 1, 15));

		seperator();

		ot = new RuestkammerStarter(ID, randAbstand, cnt, "DATransporterKammer", "Transporter");
		ot.initKammer(true, true, true, false, false,false);
		ot.setButtonText("Transporter");
		add(ot);
		
		addToInformationVector("DAKommando", 1);

		complete();
	}
	
	boolean ordensbanner=false;
	boolean bdVergeltung=false;
	boolean bdVerwuestung=false;
	boolean bdStaerke=false;
	
	@Override
	public void deleteYourself() {
		addToInformationVector("DAKommando", -1);
		//Einzigartige Banner
				if(ordensbanner){
					addToInformationVector("DAOrdensbanner", -1);
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
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		int subs = championOption.getAnzahl()+apoOption.getAnzahl();
		
		
		bomben.setMaxAnzahl(5-subs);
		sturmschild.setMaxAnzahl(5-subs);
		boltpistole.setMaxAnzahl(5-subs);
		kettenschwert.setMaxAnzahl(5-subs);
		
		waffen.setMaxAnzahl(10-(subs*2)-kettenschwert.getAnzahl()-boltpistole.getAnzahl()-o1.getAnzahl());
		
		int freierpool = (5-subs)*2 - boltpistole.getAnzahl() - kettenschwert.getAnzahl() - waffen.getAnzahl();
		if(freierpool> (5-subs-boltpistole.getAnzahl())){
			freierpool=5-subs-boltpistole.getAnzahl();
		}
		if(freierpool<0){
			freierpool=0;
		}
		o1.setMaxAnzahl(freierpool);
		
		//Einzigartige Banner
		if(ordensbanner!=specialStandards.isSelected("Ordensbanner der Dark Angels")){
			ordensbanner=specialStandards.isSelected("Ordensbanner der Dark Angels");
			addToInformationVector("DAOrdensbanner", (ordensbanner?1:-1));
			RefreshListener.fireRefresh();
		}
		specialStandards.setLegal("Ordensbanner der Dark Angels", !specialStandards.isSelected("Ordensbanner der Dark Angels") || 
				getCountFromInformationVector("DAOrdensbanner")<=1);
		
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
		
		
		if(getCountFromInformationVector("DAHQ")<getCountFromInformationVector("DAKommando")){
			setFehlermeldung("0-"+getCountFromInformationVector("DAHQ")+" Kommandos");
		}else{
			setFehlermeldung("");
		}
	}

}
