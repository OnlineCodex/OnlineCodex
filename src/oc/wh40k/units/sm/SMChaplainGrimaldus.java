package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;


public class SMChaplainGrimaldus extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsEinzelZaehler o1x;

	public SMChaplainGrimaldus() {
		name = "Chaplain Grimaldus";
		grundkosten = 150;

		addToInformationVector("Chaplain", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BTOrdenspriesterGrimaldusHeldvonAskalon.jpg"));

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cenobiten-Servitoren", 0));
		add(o1x = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Cenobiten-Servitoren", 5,15));

		complete();
	}

	@Override
	public void refreshen() {
		setUnikat(true);

		//Detachments
		boolean max1Error=false;
		boolean maxMixError=false;
		if(getCountFromInformationVector("Battle Company")>0){
			int i1 =getCountFromInformationVector("Chaplain");
			int i2 =getCountFromInformationVector("Captain")+ getCountFromInformationVector("Captain Sicarius") + getCountFromInformationVector("Kor'sarro Khan") +
					getCountFromInformationVector("Vulkan He'stan") + getCountFromInformationVector("Shadow Captain Shrike") ;
			if(i1!=1 || i2!=1){
				maxMixError=true;
			}
		}else if(getCountFromInformationVector("Reclusiam Command Squad")>0){
			int i =getCountFromInformationVector("Chaplain");
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
		}

		//Errors
		if(maxMixError){
			setFehlermeldung("1 Chapl. + 1 Capt.");
		}else if(max1Error){
			setFehlermeldung("Genau 1");
		}else if(getCountFromInformationVector("SMBlackTemplars")!=1){
			setFehlermeldung("Keine Black Templars");
		}else{
			setFehlermeldung("");
		}

		o1x.setAktiv(o1.isSelected());
//		if(o1x.getAnzahl()<3){
//			o1x.setAnzahl(3);
//		}
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("Chaplain", -1);
		super.deleteYourself();
	}

}
