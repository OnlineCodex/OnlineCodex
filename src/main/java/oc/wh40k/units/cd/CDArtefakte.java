package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CDArtefakte extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	boolean uniqueError=false;
	//Khorne
	boolean argath=false;
	boolean todbringer=false;
	boolean krone=false;
	boolean schaedelraeuber=false;
	boolean khartoth=false;
	boolean verachtung=false;
	//Nurgle
	boolean grotti=false;
	boolean verderbnis=false;
	boolean epidemia=false;
	boolean glocke=false;
	boolean horn=false;
	boolean totenschaedel=false;
	//Slaneesh
	boolean seelenfresser=false;
	boolean juwel=false;
	boolean silbersplitter=false;
	boolean klaue=false;
	boolean mal=false;
	//Tzeentch
	boolean paradoxon=false;
	boolean orakelscheibe=false;
	boolean grimoire=false;
	boolean robe=false;
	boolean seelenfluch=false;
	boolean immerstab=false;

	public CDArtefakte() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		//Khorne
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("A'rgath König der Klingen"), 15)); //Khorne DP/Herold
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Todbringer"), 15)); //Khorne DP, Bloodthirster
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Karmesinrote Krone"), 40));//Khorne DP/Herold, Bloodthirster
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schädelräuber"), 30));//Khorne DP, Bloodthirster
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Khartoth der Blutdurst"), 25));//Khorne DP/Herold
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rüstung der Verachtung"), 30));//Khorne DP, Bloodthirster
		//Nurgle
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Grotti der Nurgling"), 40));//Great Unclean One, DP/Herold des Nurgle	
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Verderbnis"), 25));//Great Unclean One, DP/Herold des Nurgle
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Epidemia"), 20));//Great Unclean One
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Glocke des Untergangs"), 30));//Herold des Nurgle
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Horn der Fäulnis"), 35));//DP/Herold des Nurgle
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Herzog Olaks' Totenschädel"), 15));//Herold des Nurgle
		//Slaanesh
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seelenfresser"), 20));//Keeper of Secrets, DP
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Verbotene Juwel"), 15));//Herold
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Silbersplitter"), 30));//Keeper of Secrets, DP
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Träge Klaue"), 10));//Keeper of Secrets, Herold
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Mal des Exzesses"), 15));//Keeper of Secrets, DP, Herold
		//Tzeentch
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Paradoxon"), 25));//Lord of Change, Herold	
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Orakelscheibe"), 35));//Herold
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Endlose Grimoire"), 35));//Herold
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Die Unmögliche Robe"), 25));//Lord of Change, DP, Herold
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seelenfluch"), 15));//DP, Herold
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Immerstab"), 20));//Lord of Change, Herold
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		setUeberschrift("Waffen und Artefakte");
		disableEntries();
		sizeSetzen();

	}

	public void disableEntries(){
		for(int i=0;i<23;i++){
			o1.setAktiv(i, false);
		}
	}

	public void enableEntry(int i){
		o1.setAktiv(i,true);
	}

	@Override
	public void refreshen() {

		//Einzigartige Gegenstände
		if(o1.isSelected("Der Immerstab")){
			if(immerstab==false){
				immerstab=true;
				BuildaHQ.addToInformationVectorGlobal("CDimmerstab", 1);
			}
		} else{
			if(immerstab==true){
				immerstab=false;
				BuildaHQ.addToInformationVectorGlobal("CDimmerstab", -1);
			}
		}

		if(o1.isSelected("Seelenfluch")){
			if(seelenfluch==false){
				seelenfluch=true;
				BuildaHQ.addToInformationVectorGlobal("CDseelenfluch", 1);
			}
		} else{
			if(seelenfluch==true){
				seelenfluch=false;
				BuildaHQ.addToInformationVectorGlobal("CDseelenfluch", -1);
			}
		}

		if(o1.isSelected("Die Unmögliche Robe")){
			if(robe==false){
				robe=true;
				BuildaHQ.addToInformationVectorGlobal("CDrobe", 1);
			}
		} else{
			if(robe==true){
				robe=false;
				BuildaHQ.addToInformationVectorGlobal("CDrobe", -1);
			}
		}

		if(o1.isSelected("Das Endlose Grimoire")){
			if(grimoire==false){
				grimoire=true;
				BuildaHQ.addToInformationVectorGlobal("CDgrimoire", 1);
			}
		} else{
			if(grimoire==true){
				grimoire=false;
				BuildaHQ.addToInformationVectorGlobal("CDgrimoire", -1);
			}
		}

		if(o1.isSelected("Die Orakelscheibe")){
			if(orakelscheibe==false){
				orakelscheibe=true;
				BuildaHQ.addToInformationVectorGlobal("CDorakelscheibe", 1);
			}
		} else{
			if(orakelscheibe==true){
				orakelscheibe=false;
				BuildaHQ.addToInformationVectorGlobal("CDorakelscheibe", -1);
			}
		}

		if(o1.isSelected("Paradoxon")){
			if(paradoxon==false){
				paradoxon=true;
				BuildaHQ.addToInformationVectorGlobal("CDparadoxon", 1);
			}
		} else{
			if(paradoxon==true){
				paradoxon=false;
				BuildaHQ.addToInformationVectorGlobal("CDparadoxon", -1);
			}
		}

		if(o1.isSelected("Das Mal des Exzesses")){
			if(mal==false){
				mal=true;
				BuildaHQ.addToInformationVectorGlobal("CDmal", 1);
			}
		} else{
			if(mal==true){
				mal=false;
				BuildaHQ.addToInformationVectorGlobal("CDmal", -1);
			}
		}

		if(o1.isSelected("Die Träge Klaue")){
			if(klaue==false){
				klaue=true;
				BuildaHQ.addToInformationVectorGlobal("CDklaue", 1);
			}
		} else{
			if(klaue==true){
				klaue=false;
				BuildaHQ.addToInformationVectorGlobal("CDklaue", -1);
			}
		}

		if(o1.isSelected("Silbersplitter")){
			if(silbersplitter==false){
				silbersplitter=true;
				BuildaHQ.addToInformationVectorGlobal("CDsilbersplitter", 1);
			}
		} else{
			if(silbersplitter==true){
				silbersplitter=false;
				BuildaHQ.addToInformationVectorGlobal("CDsilbersplitter", -1);
			}
		}

		if(o1.isSelected("Das Verbotene Juwel")){
			if(juwel==false){
				juwel=true;
				BuildaHQ.addToInformationVectorGlobal("CDjuwel", 1);
			}
		} else{
			if(juwel==true){
				juwel=false;
				BuildaHQ.addToInformationVectorGlobal("CDjuwel", -1);
			}
		}

		if(o1.isSelected("Seelenfresser")){
			if(seelenfresser==false){
				seelenfresser=true;
				BuildaHQ.addToInformationVectorGlobal("CDseelenfresser", 1);
			}
		} else{
			if(seelenfresser==true){
				seelenfresser=false;
				BuildaHQ.addToInformationVectorGlobal("CDseelenfresser", -1);
			}
		}

		if(o1.isSelected("Herzog Olaks' Totenschädel")){
			if(totenschaedel==false){
				totenschaedel=true;
				BuildaHQ.addToInformationVectorGlobal("CDtotenschaedel", 1);
			}
		} else{
			if(totenschaedel==true){
				totenschaedel=false;
				BuildaHQ.addToInformationVectorGlobal("CDtotenschaedel", -1);
			}
		}

		if(o1.isSelected("Horn der Fäulnis")){
			if(horn==false){
				horn=true;
				BuildaHQ.addToInformationVectorGlobal("CDhorn", 1);
			}
		} else{
			if(horn==true){
				horn=false;
				BuildaHQ.addToInformationVectorGlobal("CDhorn", -1);
			}
		}

		if(o1.isSelected("Die Glocke des Untergangs")){
			if(glocke==false){
				glocke=true;
				BuildaHQ.addToInformationVectorGlobal("CDglocke", 1);
			}
		} else{
			if(glocke==true){
				glocke=false;
				BuildaHQ.addToInformationVectorGlobal("CDglocke", -1);
			}
		}

		if(o1.isSelected("Epidemia")){
			if(epidemia==false){
				epidemia=true;
				BuildaHQ.addToInformationVectorGlobal("CDepidemia", 1);
			}
		} else{
			if(epidemia==true){
				epidemia=false;
				BuildaHQ.addToInformationVectorGlobal("CDepidemia", -1);
			}
		}

		if(o1.isSelected("Verderbnis")){
			if(verderbnis==false){
				verderbnis=true;
				BuildaHQ.addToInformationVectorGlobal("CDverderbnis", 1);
			}
		} else{
			if(verderbnis==true){
				verderbnis=false;
				BuildaHQ.addToInformationVectorGlobal("CDverderbnis", -1);
			}
		}

		if(o1.isSelected("Grotti der Nurgling")){
			if(grotti==false){
				grotti=true;
				BuildaHQ.addToInformationVectorGlobal("CDgrotti", 1);
			}
		} else{
			if(grotti==true){
				grotti=false;
				BuildaHQ.addToInformationVectorGlobal("CDgrotti", -1);
			}
		}

		if(o1.isSelected("Rüstung der Verachtung")){
			if(verachtung==false){
				verachtung=true;
				BuildaHQ.addToInformationVectorGlobal("CDverachtung", 1);
			}
		} else{
			if(verachtung==true){
				verachtung=false;
				BuildaHQ.addToInformationVectorGlobal("CDverachtung", -1);
			}
		}

		if(o1.isSelected("Khartoth der Blutdurst")){
			if(khartoth==false){
				khartoth=true;
				BuildaHQ.addToInformationVectorGlobal("CDkhartoth", 1);
			}
		} else{
			if(khartoth==true){
				khartoth=false;
				BuildaHQ.addToInformationVectorGlobal("CDkhartoth", -1);
			}
		}

		if(o1.isSelected("Schädelräuber")){
			if(schaedelraeuber==false){
				schaedelraeuber=true;
				BuildaHQ.addToInformationVectorGlobal("CDschaedelraeuber", 1);
			}
		} else{
			if(schaedelraeuber==true){
				schaedelraeuber=false;
				BuildaHQ.addToInformationVectorGlobal("CDschaedelraeuber", -1);
			}
		}

		if(o1.isSelected("Die Karmesinrote Krone")){
			if(krone==false){
				krone=true;
				BuildaHQ.addToInformationVectorGlobal("CDkrone", 1);
			}
		} else{
			if(krone==true){
				krone=false;
				BuildaHQ.addToInformationVectorGlobal("CDkrone", -1);
			}
		}

		if(o1.isSelected("Todbringer")){
			if(todbringer==false){
				todbringer=true;
				BuildaHQ.addToInformationVectorGlobal("CDtodbringer", 1);
			}
		} else{
			if(todbringer==true){
				todbringer=false;
				BuildaHQ.addToInformationVectorGlobal("CDtodbringer", -1);
			}
		}

		if(o1.isSelected("A'rgath König der Klingen")){
			if(argath==false){
				argath=true;
				BuildaHQ.addToInformationVectorGlobal("CDargath", 1);
			}
		} else{
			if(argath==true){
				argath=false;
				BuildaHQ.addToInformationVectorGlobal("CDargath", -1);
			}
		}

		if(BuildaHQ.getCountFromInformationVectorGlobal("CDargath")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("CDtodbringer")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDkrone")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDschaedelraeuber")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDkhartoth")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDverachtung")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDgrotti")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDverderbnis")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDepidemia")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDglocke")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDhorn")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDtotenschaedel")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDseelenfresser")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDjuwel")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDsilbersplitter")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDklaue")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDmal")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDparadoxon")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDorakelscheibe")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDgrimoire")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDrobe")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDseelenfluch")>1||
				BuildaHQ.getCountFromInformationVectorGlobal("CDimmerstab")>1){
			uniqueError=true;
		}else{
			uniqueError=false;
		}

	}

	@Override
	public void deleteYourself() {

		if(immerstab==true){
			immerstab=false;
			BuildaHQ.addToInformationVectorGlobal("CDimmerstab", -1);
		}


		if(seelenfluch==true){
			seelenfluch=false;
			BuildaHQ.addToInformationVectorGlobal("CDseelenfluch", -1);
		}

		if(robe==true){
			robe=false;
			BuildaHQ.addToInformationVectorGlobal("CDrobe", -1);
		}

		if(grimoire==true){
			grimoire=false;
			BuildaHQ.addToInformationVectorGlobal("CDgrimoire", -1);
		}

		if(orakelscheibe==true){
			orakelscheibe=false;
			BuildaHQ.addToInformationVectorGlobal("CDorakelscheibe", -1);
		}

		if(paradoxon==true){
			paradoxon=false;
			BuildaHQ.addToInformationVectorGlobal("CDparadoxon", -1);
		}

		if(mal==true){
			mal=false;
			BuildaHQ.addToInformationVectorGlobal("CDmal", -1);
		}

		if(klaue==true){
			klaue=false;
			BuildaHQ.addToInformationVectorGlobal("CDklaue", -1);
		}

		if(silbersplitter==true){
			silbersplitter=false;
			BuildaHQ.addToInformationVectorGlobal("CDsilbersplitter", -1);
		}

		if(juwel==true){
			juwel=false;
			BuildaHQ.addToInformationVectorGlobal("CDjuwel", -1);
		}

		if(seelenfresser==true){
			seelenfresser=false;
			BuildaHQ.addToInformationVectorGlobal("CDseelenfresser", -1);
		}

		if(totenschaedel==true){
			totenschaedel=false;
			BuildaHQ.addToInformationVectorGlobal("CDtotenschaedel", -1);
		}

		if(horn==true){
			horn=false;
			BuildaHQ.addToInformationVectorGlobal("CDhorn", -1);
		}

		if(glocke==true){
			glocke=false;
			BuildaHQ.addToInformationVectorGlobal("CDglocke", -1);
		}

		if(epidemia==true){
			epidemia=false;
			BuildaHQ.addToInformationVectorGlobal("CDepidemia", -1);
		}

		if(verderbnis==true){
			verderbnis=false;
			BuildaHQ.addToInformationVectorGlobal("CDverderbnis", -1);
		}

		if(grotti==true){
			grotti=false;
			BuildaHQ.addToInformationVectorGlobal("CDgrotti", -1);
		}

		if(verachtung==true){
			verachtung=false;
			BuildaHQ.addToInformationVectorGlobal("CDverachtung", -1);
		}

		if(khartoth==true){
			khartoth=false;
			BuildaHQ.addToInformationVectorGlobal("CDkhartoth", -1);
		}

		if(schaedelraeuber==true){
			schaedelraeuber=false;
			BuildaHQ.addToInformationVectorGlobal("CDschaedelraeuber", -1);
		}

		if(krone==true){
			krone=false;
			BuildaHQ.addToInformationVectorGlobal("CDkrone", -1);
		}

		if(todbringer==true){
			todbringer=false;
			BuildaHQ.addToInformationVectorGlobal("CDtodbringer", -1);
		}

		if(argath==true){
			argath=false;
			BuildaHQ.addToInformationVectorGlobal("CDargath", -1);
		}

		super.deleteYourself();
	}

}
