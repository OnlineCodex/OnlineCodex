package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SMTechmarine extends Eintrag {

	boolean addedSpezialAuswahl = false; // spezialauswahl ist abhängig von "Space Marine bike"
	RuestkammerStarter waffenUndReliquien;
	RuestkammerStarter spezialAusruestung;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe serv1;
	OptionsZaehlerGruppe serv2;

	public SMTechmarine() {
		name = "Techmarine";
		grundkosten = 65;

		addToInformationVector("SMTechmarineOderMeister", 1);
		addToInformationVector("SMTechmarine", 1);

		add(ico = new oc.Picture("oc/wh40k/images/Techmarine.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servoarm", 0));
		ogE.addElement(new OptionsGruppeEintrag("Conversion Beamer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Servo-Harnisch", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "SMWaffenUndReliquien", "");
		// Kompaniemeister, Absolutionspriester, Ordenspriester, Skriptor, Techmarine
		waffenUndReliquien.initKammer(false, false, false, false, true, false);
		waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
		add(waffenUndReliquien);
		waffenUndReliquien.setAbwaehlbar(false);

		seperator();

		spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "SMSpezialausruestung", "");
		spezialAusruestung.initKammer(false, true, false);
		spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
		add(spezialAusruestung);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Servitor (Servoarm)", 10));
		add(serv1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		ogE.addElement(new OptionsGruppeEintrag("Servitor (Schwerer Bolter)", 20));
		ogE.addElement(new OptionsGruppeEintrag("Servitor (Multimelter)", 20));
		ogE.addElement(new OptionsGruppeEintrag("Servitor (Plasmakanone)", 30));
		add(serv2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		complete();
	}

	@Override
	public void refreshen() {

		o1.alwaysSelected();

		boolean techerror = false;
		int hqs = 0;
		if(getCountFromInformationVector("Clan Raukaan")>0){
			this.setEintragsCNT(0);
			hqs = (int)buildaVater.myChooserGruppen.get(0).getAnzahl();
			techerror = (getCountFromInformationVector("SMTechmarine")>hqs*2);
		}else{
			this.setEintragsCNT(1);
			techerror=false;
		}
		
		// Biker freischalten
		((SMSpezialausruestung)spezialAusruestung.getKammer()).isWraith=((SMWaffenUndReliquien)waffenUndReliquien.getKammer()).wraithOfTheHeavensBool;
		((SMSpezialausruestung)spezialAusruestung.getKammer()).isRaven=((SMWaffenUndReliquien)waffenUndReliquien.getKammer()).ravensFuryBool;
		
		if ((((SMSpezialausruestung)spezialAusruestung.getKammer()).o1.isSelected("Space-Marine-Bike") || ((SMWaffenUndReliquien)waffenUndReliquien.getKammer()).wraithOfTheHeavensBool) && !addedSpezialAuswahl) {
			addToInformationVector("SMEnableBikes", 1);
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bike Squad");
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Bike Squad");
			addedSpezialAuswahl = true;
		} else if (!((SMSpezialausruestung)spezialAusruestung.getKammer()).o1.isSelected("Space-Marine-Bike") && !((SMWaffenUndReliquien)waffenUndReliquien.getKammer()).wraithOfTheHeavensBool && addedSpezialAuswahl) {
			addToInformationVector("SMEnableBikes", -1);
			if(getCountFromInformationVector("SMEnableBikes")<1){
				BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Bike Squad");
				BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Bike Squad");
			}
			addedSpezialAuswahl = false;
		}

		serv1.setMaxAnzahl(5-serv2.getAnzahl());
		serv2.setMaxAnzahl((serv1.getAnzahl()<4)?2:(5-serv1.getAnzahl()));
		
		//Detachments
		boolean max1Error=false;
		if(getCountFromInformationVector("Armoured Task Force")>0){
			int i =getCountFromInformationVector("SMTechmarine");
			if(i>1){
				max1Error=true;
			}
		}

		//Sons of the Great Khan
		((SMWaffenUndReliquien)waffenUndReliquien.getKammer()).SonsOfTheGreatKhan=getCountFromInformationVector("Sons of the Great Khan")>0;
		
		//Clan Raukaan
		((SMWaffenUndReliquien)waffenUndReliquien.getKammer()).ClanRaukaan=getCountFromInformationVector("Clan Raukaan")>0;
				
		//Sentinels of Terra
		((SMWaffenUndReliquien)waffenUndReliquien.getKammer()).SentinelsOfTerra=getCountFromInformationVector("Sentinels of Terra")>0;
		
		//Errors
		if(max1Error){
			setFehlermeldung("Genau 1");
		}else if(((SMWaffenUndReliquien)waffenUndReliquien.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		}else if(techerror){
			setFehlermeldung("Max."+hqs*2);
		}else{
			setFehlermeldung("");
		}
		
		//Graphische Positionen
		spezialAusruestung.getPanel().setLocation(
				(int) spezialAusruestung.getPanel().getLocation().getX(),
				(int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
				);
		
		serv1.getPanel().setLocation(
				(int) serv1.getPanel().getLocation().getX(),
				(int) spezialAusruestung.getPanel().getLocation().getY() + spezialAusruestung.getPanel().getSize().height + 5
				);
		
		serv2.getPanel().setLocation(
				(int) serv2.getPanel().getLocation().getX(),
				(int) serv1.getPanel().getLocation().getY() + serv1.getPanel().getSize().height + 5
				);
	}

	@Override
	public void deleteYourself() {
		if (addedSpezialAuswahl) {
			addToInformationVector("SMEnableBikes", -1);
			if(getCountFromInformationVector("SMEnableBikes")<1){
				BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Bike Squad");
				BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("Bike Squad");
			}
		}
		addToInformationVector("SMTechmarineOderMeister", -1);
		addToInformationVector("SMTechmarine", -1);
		super.deleteYourself();
	}

}
