package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class SMHonourGuard extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;
	RuestkammerStarter rkRaider;
	OptionsEinzelUpgrade banner;
	OptionsEinzelUpgrade empBanner;
	OptionsEinzelUpgrade khanBanner, macragge;
	boolean empBannerBool=false;
	boolean bannerBool=false;
	boolean khanBannerBool;

	boolean siegeForce;

	public SMHonourGuard() {
		name = "Honour Guard\n";
		grundkosten = 0;
		überschriftSetzen = true;

		addToInformationVector("Honour Guard", 1);

		siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);       

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Ehrengardisten", 3, 10, 25);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMEhrengarde.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ehrenklinge", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator(5);

		add(banner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ordensbanner", 25));
		add(empBanner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Standarte d. H. I.","Standarte des Himmelfahrenden Imperators", 60));
		add(khanBanner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "[WZK] The Banner of the Eagle","The Banner of the Eagle (WZ Kauyon - Sons of the Great Khan)", 30));
		add(macragge = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Macragge Standarte","Standarte des unbesiegbaren Macragge", 60));
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMOrdenschampion", "Upgrade zum Ordenschampion");
		rkBoss.initKammer(true, true, true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "SMLandRaiderKammer", "Land Raider");
		rkRaider.initKammer(false);
		rkRaider.setButtonText("Land Raider");
		add(rkRaider);
		
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SMTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		if(!siegeForce) {

			seperator();

			rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
			rkPod.initKammer(false);
			rkPod.setButtonText("Landungskapsel");
			rkPod.setSeperator(0);
			add(rkPod);

		}

		complete();
	}

	@Override
	public void refreshen() {

		if(((SMTransporterKammer)rkTransport.getKammer()).ultra != (getCountFromInformationVector("SMUltramarines")>0)){
			((SMTransporterKammer)rkTransport.getKammer()).ultra = (getCountFromInformationVector("SMUltramarines")>0);
			((SMLandRaiderKammer)rkRaider.getKammer()).ultra = (getCountFromInformationVector("SMUltramarines")>0);
			RefreshListener.fireRefresh();
		}

		banner.setAktiv(!empBanner.isSelected());
		empBanner.setAktiv(!banner.isSelected());

		if(!rkBoss.isSelected()) rkBoss.setSelected(true);

		o1.setMaxAnzahl(squad.getModelle());
		//o2.setMaxAnzahl(squad.getModelle());

		if(!siegeForce) {

			rkTransport.setAktiv(!rkPod.isSelected() && !rkRaider.isSelected());
			rkPod.setAktiv(!rkTransport.isSelected() && !rkRaider.isSelected());
			rkRaider.setAktiv(!rkPod.isSelected() && ! rkTransport.isSelected());
			((SMLandRaiderKammer)rkRaider.getKammer()).o1.setAktiv(1, false);
			((SMLandRaiderKammer)rkRaider.getKammer()).o1.setAktiv(2, false);
		}

		//Einzigartige Banner
		if(empBannerBool!=empBanner.isSelected()){
			empBannerBool=empBanner.isSelected();
			addToInformationVector("SMEMPBanner", (empBannerBool?1:-1));
			RefreshListener.fireRefresh();
		}
		empBanner.setLegal(!empBanner.isSelected() || getCountFromInformationVector("SMEMPBanner")<=1); 

		if(khanBannerBool!=khanBanner.isSelected()){
  			khanBannerBool=khanBanner.isSelected();
  			addToInformationVector("SMKhanBanner", (khanBannerBool?1:-1));
  			RefreshListener.fireRefresh();
  		}
  		khanBanner.setLegal(!khanBanner.isSelected() || getCountFromInformationVector("SMKhanBanner")<=1);
		
		if(bannerBool!=banner.isSelected()){
			bannerBool=banner.isSelected();
			addToInformationVector("SMBanner", (bannerBool?1:-1));
			RefreshListener.fireRefresh();
		}
		banner.setLegal(!banner.isSelected() || getCountFromInformationVector("SMBanner")<=1); 

		//Detachments
		boolean max1Error=false;
		if(getCountFromInformationVector("Strike Force Command")>0){
			if(getCountFromInformationVector("Honour Guard")>1){
				max1Error=true;
			}
		}

		//Errors
		if(max1Error){
			setFehlermeldung("0-1");
		}else if(((SMLandRaiderKammer)rkRaider.getKammer()).chronosError){
			setFehlermeldung("Max 1 Chronus");
		}else if(((SMTransporterKammer)rkTransport.getKammer()).chronosError){
			setFehlermeldung("Max 1 Chronus");
		}else{
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("Honour Guard", -1);
		if(empBannerBool){
			addToInformationVector("SMEMPBanner", -1);
		}
		if(bannerBool){
			addToInformationVector("SMBanner", -1);
		}
		if(khanBannerBool){
  			addToInformationVector("SMKhanBanner", -1);
  		}
		super.deleteYourself();
	}

}
