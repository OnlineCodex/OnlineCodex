package oc.wh40k.units;

import oc.Eintrag;
import oc.OnlineCodex;

public class UncertainDarkEldarCorsairAllies extends Eintrag {

    public UncertainDarkEldarCorsairAllies() {
        if (OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            addToInformationVector("ECUncertainAllies", 1);
            addToInformationVector("ECDarkEldarAllies", 1);
        }
    }

    @Override
    public void refreshen() {
        if (OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            int corsairSquads = getCountFromInformationVector("ECCorsairSquad");
            int uncertainAllies = getCountFromInformationVector("ECUncertainAllies");
            if (uncertainAllies > corsairSquads) {
                setFehlermeldung("Corsair Squads < " + uncertainAllies + "!");
            } else {
                setFehlermeldung("");
            }
        }
    }

    @Override
    public void deleteYourself() {
        if (OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            addToInformationVector("ECUncertainAllies", -1);
            addToInformationVector("ECDarkEldarAllies", -1);
        }
    }

}
