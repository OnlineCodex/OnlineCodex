package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.AnzahlPanel;
import oc.Eintrag;

public class IMPenitentEngines extends Eintrag {

    AnzahlPanel squad;

    public IMPenitentEngines() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, VEHICLE, PENITENT_ENGINES);
        name = "Penitent Engines";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Penitent Engines", 1, 3, getPts("Penitent Engines") + getPts("Penitent buzz-blades") + getPts("Heavy flamer (AMI)") * 2);
        add(squad);

        complete();
    }

    @Override
    public void refreshen() {
        power = squad.getModelle() * 5;
    }

}
