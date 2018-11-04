package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class AEAutarchwithWarpJumpGenerator extends Eintrag {

    OptionsEinzelUpgrade oe1;
    OptionsZaehlerGruppe o1, o2, o3;

    public AEAutarchwithWarpJumpGenerator() {
        name = "Autarch with Warp Jump Generator";
        grundkosten = getPts("Autarch with Warp Jump Generator") + getPts("Sunburst grenade") + getPts("Forceshield");
        power = 4;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Banshee mask", getPts("Banshee mask")));
        ogE.addElement(new OptionsGruppeEintrag("Mandiblasters", getPts("Mandiblaster")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Fusion pistol", getPts("Fusion pistol")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o2.setAktiv(0, true);

        seperator();

        ogE.addAll(AEAutarchWeapons.createRK("", "", buildaVater));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
    }
}
