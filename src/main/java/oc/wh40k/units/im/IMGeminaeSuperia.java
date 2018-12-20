package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class IMGeminaeSuperia extends Eintrag {
    private final RuestkammerStarter gs2;

    public IMGeminaeSuperia() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, CHARACTER, INFANTRY, JUMP_PACK, FLY, GEMINAE_SUPERIA);
        name = "Geminae Superia";
        grundkosten = 0;
        überschriftSetzen = true;

        RuestkammerStarter gs1 = createTroopChampion(IMAdeptaSororitasRuestkammer.class, true, "Geminae Superia", "Geminae Superia");
        add(gs1);
        gs1.setGrundkosten(getPts("Geminae Superia") + getPts("bolt pistol (AMI)") + getPts("power sword (AMI)"));
        
        seperator();
        
        add(gs2 = createTroopChampion(IMAdeptaSororitasRuestkammer.class, false, "Geminae Superia", "Geminae Superia"));
        gs2.setGrundkosten(getPts("Geminae Superia") + getPts("bolt pistol (AMI)") + getPts("power sword (AMI)"));
        
        seperator();
        
        addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void refreshen() {
    	power = 1 + (gs2.isSelected() ? 1 : 0);
    }
    
}
