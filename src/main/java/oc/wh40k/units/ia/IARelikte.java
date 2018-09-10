package oc.wh40k.units.ia;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IARelikte extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
    boolean liberBool=false;
    boolean tomeBool=false;
    boolean grimoireBool=false;
    boolean uniqueError=false;
	
    boolean malleus = false;
    boolean hereticus = false;
    boolean xenos = false;
    
	public IARelikte() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		malleus = defaults[0];
		hereticus = defaults[1];
		xenos = defaults[2];
		
	    if(malleus) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Grimoire of True Names"), 5));
		if(hereticus) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Liber Heresius"), 15));
		if(xenos) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Tome of Vethric"), 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		setUeberschrift("Relikte");
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
	    //Einzigartige Gegenstände
		if(o1.isSelected("The Grimoire of True Names")){
			if(grimoireBool==false){
				grimoireBool=true;
				BuildaHQ.addToInformationVectorGlobal("INGrimoire", 1);
			}
		} else if(!o1.isSelected("The Grimoire of True Names")) {
			if(grimoireBool==true){
				grimoireBool=false;
				BuildaHQ.addToInformationVectorGlobal("INGrimoire", -1);
			}
		}
		
		if(o1.isSelected("The Tome of Vethric")){
			if(tomeBool==false){
				tomeBool=true;
				BuildaHQ.addToInformationVectorGlobal("INTome", 1);
			}
		} else if(!o1.isSelected("The Tome of Vethric")) {
			if(tomeBool==true){
				tomeBool=false;
				BuildaHQ.addToInformationVectorGlobal("INTome", -1);
			}
		}
		
		if(o1.isSelected("The Liber Heresius")){
			if(liberBool==false){
				liberBool=true;
				BuildaHQ.addToInformationVectorGlobal("INLiber", 1);
			}
		} else if(!o1.isSelected("The Liber Heresius")) {
			if(liberBool==true){
				liberBool=false;
				BuildaHQ.addToInformationVectorGlobal("INLiber", -1);
			}
		}
		
		
		if(BuildaHQ.getCountFromInformationVectorGlobal("INGrimoire")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("INTome")>1 ||
				BuildaHQ.getCountFromInformationVectorGlobal("INLiber")>1){
				uniqueError=true;
		}else{
			uniqueError=false;
		}
		
	}

	@Override
	public Object getSpecialValue() {
		return 0;
	}
	
	@Override
	public void deleteYourself() {
		
		if(grimoireBool==true){
			grimoireBool=false;
			BuildaHQ.addToInformationVectorGlobal("INGrimoire", -1);
		}
					
		if(tomeBool==true){
			tomeBool=false;
			BuildaHQ.addToInformationVectorGlobal("INTome", -1);
		}
					
		if(liberBool==true){
			liberBool=false;
			BuildaHQ.addToInformationVectorGlobal("INLiber", -1);
		}
				
		super.deleteYourself();
	}
	
}
