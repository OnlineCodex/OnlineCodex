package oc.wh40k.units.rh_ia13;

import oc.AnzahlPanel;
import oc.Eintrag;

public class RH_IA13PlagueZombieHorde extends Eintrag {


    public RH_IA13PlagueZombieHorde() {
        grundkosten = 0;

        add(new AnzahlPanel(ID, randAbstand, cnt, "Plague Zombies", 10, 50, 3));


        complete();
    }

    @Override
    public void refreshen() {
        if (getCountFromInformationVector("RHMutantOverlord") == 1 && getCountFromInformationVector("MutantRabble") < 2) {
            setFehlermeldung("2+ Mutant Rabble");
        } else if (getCountFromInformationVector("RHMasterOfTheHorde") == 1 && getCountFromInformationVector("InfPlatoon") < 2) {
            setFehlermeldung("2+ Inf. Platoons");
        } else {
            setFehlermeldung("");
        }
    }

}
