package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class SMTerminatorCaptain extends Eintrag {

	boolean addedSpezialAuswahl = false; // spezialauswahl ist abhängig von "Space Marine bike"
	OptionsEinzelUpgrade termi;
	RuestkammerStarter termiWaffen;
	RuestkammerStarter spezialAusruestung;

	public SMTerminatorCaptain() {
		name = "Terminator Captain";
		grundkosten = 120;

		addToInformationVector("Captain", 1);

		add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

		seperator();

		add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 0));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cataphractii Armour", 0));

		seperator();

		termiWaffen = new RuestkammerStarter(ID, randAbstand, cnt, "SMTerminatorwaffen", "");
		termiWaffen.initKammer(true, false, false);
		termiWaffen.setButtonText(BuildaHQ.translate("Terminatorwaffen & Reliquien"));
		add(termiWaffen);

		seperator();

		spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "SMSpezialausruestung", "");
		spezialAusruestung.initKammer(false, true, false);
		spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
		add(spezialAusruestung);
		spezialAusruestung.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void deleteYourself() {

		addToInformationVector("Captain", -1);

		if (addedSpezialAuswahl) {
			addToInformationVector("SMEnableBikes", -1);
			if(getCountFromInformationVector("SMEnableBikes")<1){
				BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Bike Squad");
				BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Bike Squad");
			}
		}
		super.deleteYourself();
	}

	@Override
	public void refreshen() {

		termi.setSelected(true);
		
		termiWaffen.setAktiv(termi.isSelected());

		//Detachments
		boolean max1Error=false;
		boolean maxMixError=false;
		if(getCountFromInformationVector("Firespear Strike Force (Start Collecting)")>0){
			termi.setSelected(true);
		}else if(getCountFromInformationVector("Battle Company")>0){
			int i1 =getCountFromInformationVector("Chaplain");
			int i2 =getCountFromInformationVector("Captain")+ getCountFromInformationVector("Captain Sicarius") + getCountFromInformationVector("Kor'sarro Khan") +
					getCountFromInformationVector("Vulkan He'stan") + getCountFromInformationVector("Shadow Captain Shrike") ;
			if(i1!=1 || i2!=1){
				maxMixError=true;
			}
		}else if(getCountFromInformationVector("Strike Force Ultra")>0){
			termi.setSelected(true);
			int i =getCountFromInformationVector("Captain Lysander") + getCountFromInformationVector("Captain");
			if(i>1){
				max1Error=true;
			}
		}else if(getCountFromInformationVector("Strike Force Command")>0){
			int i =getCountFromInformationVector("Captain Sicarius") + getCountFromInformationVector("Captain") + getCountFromInformationVector("Chaplain") + 
					getCountFromInformationVector("Chaplain Cassius") + getCountFromInformationVector("Chaplain Grimaldus") + getCountFromInformationVector("Kor'sarro Khan") +
					getCountFromInformationVector("Vulkan He'stan") + getCountFromInformationVector("Shadow Captain Shrike") + getCountFromInformationVector("Marneus Calgar") +
					getCountFromInformationVector("Pedro Kantor") + getCountFromInformationVector("High Marshal Helbrecht");
			if(i>1){
				max1Error=true;
			}
		}else if(getCountFromInformationVector("Hunting Force")>0){
			termi.setAktiv(false);
			((SMSpezialausruestung)spezialAusruestung.getKammer()).o1.setAktiv("Sprungmodul", false);
			if(!((SMSpezialausruestung)spezialAusruestung.getKammer()).o1.isSelected("Space-Marine-Bike")){
				((SMSpezialausruestung)spezialAusruestung.getKammer()).o1.setSelected("Space-Marine-Bike",true);
			}
		}else if(getCountFromInformationVector("Bladewing Assault Brotherhood")>0){
			termi.setAktiv(false);
			((SMSpezialausruestung)spezialAusruestung.getKammer()).o1.setAktiv("Space-Marine-Bike", false);
			((SMSpezialausruestung)spezialAusruestung.getKammer()).o1.setSelected("Sprungmodul",true);
		}
		

		// Biker freischalten
		((SMSpezialausruestung)spezialAusruestung.getKammer()).isTermi=termi.isSelected();

		if (((SMSpezialausruestung)spezialAusruestung.getKammer()).o1.isSelected("Space-Marine-Bike")) {
			addToInformationVector("SMEnableBikes", 1);
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Bike Squad");
			addedSpezialAuswahl = true;
		} else if (!((SMSpezialausruestung)spezialAusruestung.getKammer()).o1.isSelected("Space-Marine-Bike") && addedSpezialAuswahl) {
			addToInformationVector("SMEnableBikes", -1);
			if(getCountFromInformationVector("SMEnableBikes")<1){
				BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Bike Squad");
				BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Bike Squad");
			}
			addedSpezialAuswahl = false;
		}

		//Clan Raukaan
		((SMTerminatorwaffen)termiWaffen.getKammer()).ClanRaukaan=getCountFromInformationVector("Clan Raukaan")>0;
		
		//Sentinels of Terra
		((SMTerminatorwaffen)termiWaffen.getKammer()).SentinelsOfTerra=getCountFromInformationVector("Sentinels of Terra")>0;
		
		//Errors
		if(maxMixError){
			setFehlermeldung("1 Chapl. + 1 Capt.");
		}else if(max1Error){
			setFehlermeldung("Genau 1");
		}else if(((SMTerminatorwaffen)termiWaffen.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}

		spezialAusruestung.getPanel().setLocation(
				(int) spezialAusruestung.getPanel().getLocation().getX(),
				(int) termiWaffen.getPanel().getLocation().getY() + termiWaffen.getPanel().getSize().height + 5
				);


	}

}
