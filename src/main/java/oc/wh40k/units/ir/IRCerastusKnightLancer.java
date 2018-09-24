package oc.wh40k.units.ir;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IRCerastusKnightLancer extends Eintrag {

	OptionsUpgradeGruppe fk4;
	OptionsEinzelUpgrade baron;

	boolean bannerBool=false;
	boolean faustBool=false;
	boolean zerfleischerBool=false;
	boolean zufluchtBool=false;
	boolean helmBool=false;
	boolean zeichenBool=false;

	public IRCerastusKnightLancer() {
		name = "Cerastus Knight-Lancer";
		grundkosten = 400;

		seperator();

		add(baron = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lord Baron", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Banner des glorreichen Macharius", 10));
		ogE.addElement(new OptionsGruppeEintrag("Zuflucht", 15));
		ogE.addElement(new OptionsGruppeEintrag("Helm des namenlosen Kriegers", 30));
		ogE.addElement(new OptionsGruppeEintrag("Zeichen des Omnissiah", 30));
		add(fk4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	//@OVERRIDE
	public void refreshen() {

		baron.setAktiv(getCountFromInformationVector("Lord Baron")>0);

		boolean skyErr=false;

		if(getCountFromInformationVector("Skyreaper")>0){
			skyErr=true;
		}

		fk4.setAktiv(baron.isSelected());

		//Einzigartige Gegenstände
		if(fk4.isSelected("Banner des glorreichen Macharius")){
			if(bannerBool==false){
				bannerBool=true;
				BuildaHQ.addToInformationVectorGlobal("IR Banner des glorreichen Macharius", 1);
			}
		} else if(!fk4.isSelected("Banner des glorreichen Macharius")) {
			if(bannerBool==true){
				bannerBool=false;
				BuildaHQ.addToInformationVectorGlobal("IR Banner des glorreichen Macharius", -1);
			}
		}

		if(fk4.isSelected("Zuflucht")){
			if(zufluchtBool==false){
				zufluchtBool=true;
				BuildaHQ.addToInformationVectorGlobal("IR Zuflucht", 1);
			}
		} else if(!fk4.isSelected("Zuflucht")) {
			if(zufluchtBool==true){
				zufluchtBool=false;
				BuildaHQ.addToInformationVectorGlobal("IR Zuflucht", -1);
			}
		}

		if(fk4.isSelected("Helm des namenlosen Kriegers")){
			if(helmBool==false){
				helmBool=true;
				BuildaHQ.addToInformationVectorGlobal("IR Helm des namenlosen Kriegers", 1);
			}
		} else if(!fk4.isSelected("Helm des namenlosen Kriegers")) {
			if(helmBool==true){
				helmBool=false;
				BuildaHQ.addToInformationVectorGlobal("IR Helm des namenlosen Kriegers", -1);
			}
		}

		if(fk4.isSelected("Zeichen des Omnissiah")){
			if(zeichenBool==false){
				zeichenBool=true;
				BuildaHQ.addToInformationVectorGlobal("IR Zeichen des Omnissiah", 1);
			}
		} else if(!fk4.isSelected("Zeichen des Omnissiah")) {
			if(zeichenBool==true){
				zeichenBool=false;
				BuildaHQ.addToInformationVectorGlobal("IR Zeichen des Omnissiah", -1);
			}
		}

		int artefaktCnt = BuildaHQ.getCountFromInformationVectorGlobal("IR Banner des glorreichen Macharius")+
				BuildaHQ.getCountFromInformationVectorGlobal("IR Zuflucht")+
				BuildaHQ.getCountFromInformationVectorGlobal("IR Helm des namenlosen Kriegers")+
				BuildaHQ.getCountFromInformationVectorGlobal("IR Zeichen des Omnissiah");

		if(skyErr){
			setFehlermeldung("Kein Icarus");
		}else if(artefaktCnt > getCountFromInformationVector("Lord Baron")){
			setFehlermeldung("Zu viele Artefakte");
		}else if(BuildaHQ.getCountFromInformationVectorGlobal("IR Banner des glorreichen Macharius")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("IR Zuflucht")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("IR Helm des namenlosen Kriegers")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("IR Zeichen des Omnissiah")>1) {
			setFehlermeldung("Artefakt doppelt");
		}else{
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {

		if(bannerBool==true){
			bannerBool=false;
			BuildaHQ.addToInformationVectorGlobal("IR Banner des glorreichen Macharius", -1);
		}

		if(zufluchtBool==true){
			zufluchtBool=false;
			BuildaHQ.addToInformationVectorGlobal("IR Zuflucht", -1);
		}

		if(helmBool==true){
			helmBool=false;
			BuildaHQ.addToInformationVectorGlobal("IR Helm des namenlosen Kriegers", -1);
		}

		if(zeichenBool==true){
			zeichenBool=false;
			BuildaHQ.addToInformationVectorGlobal("IR Zeichen des Omnissiah", -1);
		}

		if(faustBool==true){
			faustBool=false;
			BuildaHQ.addToInformationVectorGlobal("IR Die Erste Faust", -1);
		}

		if(zerfleischerBool==true){
			zerfleischerBool=false;
			BuildaHQ.addToInformationVectorGlobal("IR Zerfleischer", -1);
		}

		super.deleteYourself();
	}

}
