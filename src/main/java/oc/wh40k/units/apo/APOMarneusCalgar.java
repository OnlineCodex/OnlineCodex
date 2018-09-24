package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class APOMarneusCalgar extends Eintrag {

	public APOMarneusCalgar() {
		name = "Marneus Calgar";
		grundkosten = 275;

		addToInformationVector("Marneus Calgar", 1);
		addToInformationVector("SMChapterMaster", 1);

		add(ico = new oc.Picture("oc/wh40k/images/MarneusCalgar.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rüstung des Antilochus", 10));

		complete();
	}

	@Override
	public void refreshen() {
		setUnikat(true);

		//Detachment
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
		} else if(getCountFromInformationVector("SMUltramarines")!=1){
			setFehlermeldung("Keine Ultramarines");
		}else{
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("SMChapterMaster", -1);
		addToInformationVector("Marneus Calgar", -1);
		super.deleteYourself();
	}

}
