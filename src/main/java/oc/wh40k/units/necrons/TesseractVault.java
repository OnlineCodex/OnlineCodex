package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.wh40k.units.AOPSlot.LordOfWar;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Titanic;
import oc.wh40k.units.UnitType.Vehicle;
import oc.wh40k.units.necrons.Necrons.CTanShards;

public class TesseractVault extends Eintrag<CTanShards, LordOfWar, Vehicle> implements Titanic, Fly {

    public TesseractVault() {
        name = "Tesseract Vault";
        grundkosten = getPts("Tesseract Vault") + getPts("Tesla sphere") * 4;
        power = 25;
    }
}