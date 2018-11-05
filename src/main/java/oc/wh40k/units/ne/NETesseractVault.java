package oc.wh40k.units.ne;

import oc.Eintrag;

public class NETesseractVault extends Eintrag {

    public NETesseractVault() {
        name = "Tesseract Vault";
        grundkosten = getPts("Tesseract Vault") + getPts("Tesla sphere") * 4;
    }

    @Override
    public void refreshen() {
        power = 25;
    }
}
