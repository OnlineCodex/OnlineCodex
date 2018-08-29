package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMHighMarshalHelbrecht extends Eintrag {

	public SMHighMarshalHelbrecht() {
		name = "High Marshal Helbrecht";
		grundkosten = 180;   
		addToInformationVector("SMChapterMaster", 1);
		addToInformationVector("High Marshal Helbrecht", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BTGrossmarschallHelbrecht.jpg"));
		complete();
	}

	@Override
	public void refreshen() {
		setUnikat(true);

		//Detachments
		boolean max1Error=false;
		if(getCountFromInformationVector("Strike Force Command")>0){
			int i =getCountFromInformationVector("Captain Sicarius") + getCountFromInformationVector("Captain") + getCountFromInformationVector("Chaplain") + 
					getCountFromInformationVector("Chaplain Cassius") + getCountFromInformationVector("Chaplain Grimaldus") + getCountFromInformationVector("Kor'sarro Khan") +
					getCountFromInformationVector("Vulkan He'stan") + getCountFromInformationVector("Shadow Captain Shrike") + getCountFromInformationVector("Marneus Calgar") +
					getCountFromInformationVector("Pedro Kantor") + getCountFromInformationVector("High Marshal Helbrecht");
			if(i>1){
				max1Error=true;
			}
		}

		//Errors
		if(max1Error){
			setFehlermeldung("Genau 1");
		}else if(getCountFromInformationVector("SMChapterMaster") > 1 && getCountFromInformationVector("SMOnlyOneChapterMaster") > 0) {
			setFehlermeldung("nur ein Ordensmeister");
		} else if(getCountFromInformationVector("SMBlackTemplars")!=1){
			setFehlermeldung("Keine Black Templars");
		}else{
			setFehlermeldung("");
		}

	}

	@Override
	public void deleteYourself() {     
		addToInformationVector("SMChapterMaster", -1);
		addToInformationVector("High Marshal Helbrecht", -1);
		super.deleteYourself();
	}

}
