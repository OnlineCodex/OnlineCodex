package oc.wh40k.units.ir;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IRQuestorisKnightMagaera extends Eintrag {

	OptionsUpgradeGruppe fk1;
	OptionsUpgradeGruppe fk4;
	
	OptionsEinzelUpgrade baron;

	boolean bannerBool=false;
	boolean faustBool=false;
	boolean zerfleischerBool=false;
	boolean zufluchtBool=false;
	boolean helmBool=false;
	boolean zeichenBool=false;

	public IRQuestorisKnightMagaera() {
		name = "Questoris Knight Magaera";
		grundkosten = 395;
		
		seperator();

		add(baron = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lord Baron", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Reaper Chainsword", 0));
		ogE.addElement(new OptionsGruppeEintrag("Hekaton + Rad cleanser","Hekaton siege claw with twin-linked rad cleanser", 25));
		ogE.addElement(new OptionsGruppeEintrag("Die Erste Faust", 15));
		ogE.addElement(new OptionsGruppeEintrag("Zerfleischer", 25));
		add(fk1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
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
			fk1.alwaysSelected();

			baron.setAktiv(getCountFromInformationVector("Lord Baron")>0);

			boolean skyErr = false;
			
			if(getCountFromInformationVector("Skyreaper")>0){
				skyErr = true;
			}

			fk4.setAktiv(baron.isSelected() && !fk1.isSelected("Die Erste Faust") && !fk1.isSelected("Zerfleischer"));
			fk1.setAktiv("Die Erste Faust", baron.isSelected() && !fk4.isSelected());
			fk1.setAktiv("Zerfleischer", baron.isSelected() && !fk4.isSelected());

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

			if(fk1.isSelected("Die Erste Faust")){
				if(faustBool==false){
					faustBool=true;
					BuildaHQ.addToInformationVectorGlobal("IR Die Erste Faust", 1);
				}
			} else if(!fk1.isSelected("Die Erste Faust")) {
				if(faustBool==true){
					faustBool=false;
					BuildaHQ.addToInformationVectorGlobal("IR Die Erste Faust", -1);
				}
			}

			if(fk4.isSelected("Zerfleischer")){
				if(zerfleischerBool==false){
					zerfleischerBool=true;
					BuildaHQ.addToInformationVectorGlobal("IR Zerfleischer", 1);
				}
			} else if(!fk4.isSelected("Zerfleischer")) {
				if(zerfleischerBool==true){
					zerfleischerBool=false;
					BuildaHQ.addToInformationVectorGlobal("IR Zerfleischer", -1);
				}
			}

			int artefaktCnt = BuildaHQ.getCountFromInformationVectorGlobal("IR Banner des glorreichen Macharius")+
					BuildaHQ.getCountFromInformationVectorGlobal("IR Zuflucht")+
					BuildaHQ.getCountFromInformationVectorGlobal("IR Helm des namenlosen Kriegers")+
					BuildaHQ.getCountFromInformationVectorGlobal("IR Zeichen des Omnissiah")+
					BuildaHQ.getCountFromInformationVectorGlobal("IR Die Erste Faust")+
					BuildaHQ.getCountFromInformationVectorGlobal("IR Zerfleischer");

			if(skyErr){
				setFehlermeldung("Kein Icarus");
			}else if(artefaktCnt > getCountFromInformationVector("Lord Baron")){
				setFehlermeldung("Zu viele Artefakte");
			}else if(BuildaHQ.getCountFromInformationVectorGlobal("IR Banner des glorreichen Macharius")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("IR Zuflucht")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("IR Helm des namenlosen Kriegers")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("IR Zeichen des Omnissiah")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("IR Die Erste Faust")>1 ||
					BuildaHQ.getCountFromInformationVectorGlobal("IR Zerfleischer")>1) {
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
