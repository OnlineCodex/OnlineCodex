package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class SMTerminatorAssaultSquad extends Eintrag {

	AnzahlPanel squad;
	protected OptionsEinzelZaehler o1;
	RuestkammerStarter rkRaider;

	boolean raiderSelected = false;

	public SMTerminatorAssaultSquad() {
		name = "Terminator Assault Squad\n";
		grundkosten = 0;
		überschriftSetzen = true;

		addToInformationVector("Terminator Assault Squad", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sturm-Terminatoren", 5, 10, 35);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMTerminatorSturmtrupp.jpg"));

		seperator(12);

		add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "E-Hammer & Schild", "Energiehammer und Sturmschild", -88, 10));

		seperator();

		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "SMLandRaiderKammer", "Land Raider");
		rkRaider.initKammer(false);
		rkRaider.setButtonText("Land Raider");
		add(rkRaider);

		complete();
	}

	@Override
	public void refreshen() {

		if(((SMLandRaiderKammer)rkRaider.getKammer()).ultra != (getCountFromInformationVector("SMUltramarines")>0)){
			((SMLandRaiderKammer)rkRaider.getKammer()).ultra = (getCountFromInformationVector("SMUltramarines")>0);
			RefreshListener.fireRefresh();
		}

		o1.setMaxAnzahl(squad.getModelle());

		//Detachments
		boolean max1Error=false;
		boolean min1Error=false;
		if(getCountFromInformationVector("1st Company Task Force")>0){
			int i =getCountFromInformationVector("Sternguard Veteran Squad") + getCountFromInformationVector("Vanguard Veteran Squad") + getCountFromInformationVector("Terminator Squad")  + getCountFromInformationVector("Terminator Assault Squad");
			if(i>5){
				max1Error=true;
			}else if(i<3){
				min1Error=true;
			}
		}

		//Errors
		if(max1Error || min1Error){
			setFehlermeldung("3-5");
		}else if(((SMLandRaiderKammer)rkRaider.getKammer()).chronosError){
			setFehlermeldung("Max 1 Chronus");
		}else{
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("Terminator Assault Squad", -1);
		super.deleteYourself();
	}

}
