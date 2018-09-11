package oc.wh40k.units.rh_ia13;

import oc.AnzahlPanel;
import oc.Eintrag;

public class RH_IA13RenegadeChaosSpawn extends Eintrag {

	AnzahlPanel squad;
	
	public RH_IA13RenegadeChaosSpawn() {
		name = "Renegade Chaos Spawn";
		grundkosten = 55;
		setCountToMinimum(false);
		addToInformationVector("ChaosSpawn", +1);
		complete();
	}

	@Override
	public void refreshen() {
		if(getCountFromInformationVector("RHMutantOverlord")==1 && getCountFromInformationVector("RHTzeentchCovenant")==0 && getCountFromInformationVector("ChaosSpawn")>1){
			setFehlermeldung("0-1 Auswahl");
		}else if(getCountFromInformationVector("RHTzeentchCovenant")==1 && getCountFromInformationVector("ChaosSpawn")>3){
			setFehlermeldung("0-3 Auswahl");
		}else if(getCountFromInformationVector("RHMutantOverlord")==1 && getCountFromInformationVector("MutantRabble")<2){
			setFehlermeldung("2+ Mutant Rabble");
		}else if(getCountFromInformationVector("RHMasterOfTheHorde")==1 && getCountFromInformationVector("InfPlatoon")<2){
			setFehlermeldung("2+ Inf. Platoons");
		}else{
			setFehlermeldung("");
		}
	}
	
	@Override
	public void deleteYourself() {
		addToInformationVector("ChaosSpawn", -1);
		super.deleteYourself();
	}

}
