package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMDeathCultAssassins extends Eintrag {

    AnzahlPanel squad;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransport;

    public IMDeathCultAssassins() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, INFANTRY, ECCLESIARCHY_BATTLE_CONCLAVE, DEATH_CULT_ASSASSINS);
        name = "Death Cult Assassins\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Death Cult Assassin", 2, 10, getPts("Death Cult Assassins") + getPts("Death Cult power blades"));
        add(squad);
        
        seperator();

        addToInformationVector(ECCLESIARCHY_BATTLE_CONCLAVE_CNT, 1);
        
        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() <= 2)
            power = 1;
        else if (squad.getModelle() <= 4)
            power = 3;
        else if (squad.getModelle() <= 6)
            power = 5;
        else if (squad.getModelle() <= 8)
            power = 6;
        else if (squad.getModelle() <= 10)
            power = 8;
        
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
