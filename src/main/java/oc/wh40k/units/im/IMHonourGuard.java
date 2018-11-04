package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMHonourGuard extends Eintrag {

    OptionsZaehlerGruppe o1, o1x;

    public IMHonourGuard() {
        name = "Honour Guard";
        grundkosten = getPts("Honour Guard") * 2 +
                getPts("Frag grenade (SM)") * 2 +
                getPts("Krak grenade (SM)") * 2 +
                getPts("Chainsword (SM)") * 2 +
                getPts("Bolt pistol (SM)") * 2 +
                getPts("Bolt gun (SM)") * 2;
        power = 2;

        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", getPts("Power lance (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("Relic blade")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        complete();
    }

    @Override
    public void refreshen() {
        o1x.setMaxAnzahl(2 - o1.getAnzahl());
        o1x.setAnzahl(0, 2 - o1.getAnzahl());
        o1.setMaxAnzahl(2);
    }
}
