package oc.wh40k.units.sm;

import oc.Eintrag;

public class SMShadowCaptainShrike extends Eintrag {

	public SMShadowCaptainShrike() {
		name = "Shadow Captain Shrike";
		grundkosten = 185;

		addToInformationVector("Shadow Captain Shrike", 1);

		add(ico = new oc.Picture("oc/wh40k/images/SMSchattenCaptainKayvaanShrike.jpg"));

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		setUnikat(true);

		//Detachment
		boolean max1Error=false;
		boolean maxMixError=false;
		if(getCountFromInformationVector("Battle Company")>0){
			int i1 =getCountFromInformationVector("Chaplain");
			int i2 =getCountFromInformationVector("Captain")+ getCountFromInformationVector("Captain Sicarius") + getCountFromInformationVector("Kor'sarro Khan") +
					getCountFromInformationVector("Vulkan He'stan") + getCountFromInformationVector("Shadow Captain Shrike") ;
			if(i1!=1 || i2!=1){
				maxMixError=true;
			}
		}else if(getCountFromInformationVector("Strike Force Command")>0){
			int i =getCountFromInformationVector("Captain Sicarius") + getCountFromInformationVector("Captain") + getCountFromInformationVector("Chaplain") + 
					getCountFromInformationVector("Chaplain Cassius") + getCountFromInformationVector("Chaplain Grimaldus") + getCountFromInformationVector("Kor'sarro Khan") +
					getCountFromInformationVector("Vulkan He'stan") + getCountFromInformationVector("Shadow Captain Shrike") + getCountFromInformationVector("Marneus Calgar") +
					getCountFromInformationVector("Pedro Kantor") + getCountFromInformationVector("High Marshal Helbrecht");
			if(i>1){
				max1Error=true;
			}
		}

		//Errors
		if(maxMixError){
			setFehlermeldung("1 Chapl. + 1 Capt.");
		}else if(max1Error){
			setFehlermeldung("Genau 1");
		}else if(getCountFromInformationVector("SMRavenGuard")!=1){
			setFehlermeldung("Keine Raven Guard");
		}else{
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("Shadow Captain Shrike", -1);
		super.deleteYourself();
	}

}
