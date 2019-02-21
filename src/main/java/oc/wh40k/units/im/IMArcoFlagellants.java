package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMArcoFlagellants extends Eintrag {

	private final AnzahlPanel squad;

	public IMArcoFlagellants() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, INFANTRY, ECCLESIARCHY_BATTLE_CONCLAVE, ARCO_FLAGELLANTS);
        name = "Arco-flagellants\n";
        grundkosten = 0;
        überschriftSetzen = true;
        power = 2;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Arco-flagellants", 3, 9, getPts("Arco-flagellants") + getPts("Arco-flails"));
        add(squad);
        
        seperator();
        
        addToInformationVector(ECCLESIARCHY_BATTLE_CONCLAVE_CNT, 1);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() <= 3)
            power = 2;
        else if (squad.getModelle() <= 6)
            power = 4;
        else if (squad.getModelle() <= 9)
            power = 6;
        
        setEintragsCNT(getCountFromInformationVector(MINISTORUM_PRIEST_CNT) > 0 ? 0 : 1);
        
        if(getCountFromInformationVector(MINISTORUM_PRIEST_CNT) < 1 && getCountFromInformationVector(ECCLESIARCHY_BATTLE_CONCLAVE_CNT) > 1) {
        	setFehlermeldung("MAX 1 CONCLAVE");
        } else {
        	setFehlermeldung("");
        }
    }
    
    @Override
    public void deleteYourself() {
        addToInformationVector(ECCLESIARCHY_BATTLE_CONCLAVE_CNT, -1);
    	super.deleteYourself();
    }
}
