package oc.wh40k.units;

import oc.Eintrag;
import oc.OnlineCodex;

public class UncertainEldarCorsairAllies extends Eintrag {

    public UncertainEldarCorsairAllies() {
        if (OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            addToInformationVector("ECUncertainAllies", 1);
            addToInformationVector("ECEldarAllies", 1);
        }
    }

    @Override
    public void refreshen() {
        if (OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            if (getCountFromInformationVector("ECEldarAllies") > 1) {
                setFehlermeldung("Eldar-Alliierte > 1!");
            } else {
                int corsairSquads = getCountFromInformationVector("ECCorsairSquad");
                int uncertainAllies = getCountFromInformationVector("ECUncertainAllies");
                if (uncertainAllies > corsairSquads) {
                    setFehlermeldung("Corsair Squads < " + uncertainAllies + "!");
                } else {
                    setFehlermeldung("");
                }
            }
        }
    }

    @Override
    public void deleteYourself() {
        if (OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            addToInformationVector("ECUncertainAllies", -1);
            addToInformationVector("ECEldarAllies", -1);
        }
    }

}
