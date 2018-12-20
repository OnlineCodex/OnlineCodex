package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.AnzahlPanel;

import oc.Eintrag;

public class IMCrusaders extends Eintrag {

    AnzahlPanel squad;

    public IMCrusaders() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ASTRA_MILITARUM, INFANTRY, ECCLESIARCHY_BATTLE_CONCLAVE, CRUSADERS);
        name = "Crusaders";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Crusaders", 2, 10, getPts("Crusaders") + getPts("Power sword (AMI)") + getPts("Storm shield (AMI)")));
        
        seperator();
        
        addToInformationVector("ECCLESIARCHY_BATTLE_CONCLAVE", 1);
        
        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 8) {
            power = 6;
        } else if (squad.getModelle() > 6) {
            power = 5;
        } else if (squad.getModelle() > 4) {
            power = 3;
        } else if (squad.getModelle() > 2) {
            power = 2;
        } else {
            power = 1;
        }
        
        setEintragsCNT(getCountFromInformationVector("MINISTORUM_PRIEST") > 0 ? 0 : 1);
        
        if(getCountFromInformationVector("MINISTORUM_PRIEST") < 1 && getCountFromInformationVector("ECCLESIARCHY_BATTLE_CONCLAVE") > 1) {
        	setFehlermeldung("MAX 1 CONCLAVE");
        } else {
        	setFehlermeldung("");
        }
    }
    
    @Override
    public void deleteYourself() {
        addToInformationVector("ECCLESIARCHY_BATTLE_CONCLAVE", -1);
    	super.deleteYourself();
    }
}