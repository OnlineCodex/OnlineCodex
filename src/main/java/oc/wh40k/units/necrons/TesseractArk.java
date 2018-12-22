package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.wh40k.units.AOPSlot.HeavySupport;
import oc.wh40k.units.Fly;
import oc.wh40k.units.Source;
import oc.wh40k.units.UnitType.Vehicle;

import static oc.wh40k.units.Source.SourcePublication.ImperialArmourIndexXenos;

@Source(ImperialArmourIndexXenos)
public class TesseractArk extends Eintrag<Necrons, HeavySupport> implements Vehicle, Fly {

    public TesseractArk() {
        name = "Tesseract Ark";
        grundkosten = getPts("Tesseract Ark") + getPts("Tesseract singularity chamber");
        power = 13;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 tesla cannons", 2 * getPts("Tesla cannon")));
        ogE.addElement(new OptionsGruppeEintrag("2 gauss cannons", 2 * getPts("Gauss cannon")));
        ogE.addElement(new OptionsGruppeEintrag("2 particle beamers", 2 * getPts("Particle beamer")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }
}