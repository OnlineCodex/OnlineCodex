package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class NETesseractArk extends Eintrag {

	public NETesseractArk() {
        name = "Tesseract Ark";
        grundkosten = getPts("Tesseract Ark") + getPts("Tesseract singularity chamber");
        power = 13;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 tesla cannons", 2 * getPts("Tesla cannon (FW)")));
        ogE.addElement(new OptionsGruppeEintrag("2 gauss cannons", 2 * getPts("Gauss cannon (Fahrzeug)")));
        ogE.addElement(new OptionsGruppeEintrag("2 particle beamers", 2 * getPts("Particle beamer (Tesseract Ark)")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        complete();
    }



    @Override

    public void refreshen() {

    }

}

