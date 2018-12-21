package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMMilitarumTempestusCommandSquad extends Eintrag {

    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o1, o2, o4;
    OptionsEinzelZaehler oe2;


    public IMMilitarumTempestusCommandSquad() {
        name = "Militarum Tempestus Command Squad";
        grundkosten = getPts("Militarum Tempestus Command Squad") * 4;
        power = 3;


        ogE.addElement(new OptionsGruppeEintrag("Hot-shot lasgun", getPts("Hot-shot lasgun")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Vox-caster + Hot-shot laspistol", getPts("Vox-caster") + getPts("Hot-shot laspistol")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Medi-pack + Hot-shot laspistol", getPts("Medi-pack") + getPts("Hot-shot laspistol")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sniper Rifle", getPts("Sniper Rifle (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Grenade Launcher", getPts("Grenade Launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (AM 3+)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun (AM 3+)")));
        ogE.addElement(new OptionsGruppeEintrag("Hot-shot volleygun", getPts("Hot-shot volleygun")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        add(oe2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Platoon standard", 1, getPts("Platoon standard")));

        complete();
    }

    @Override
    public void refreshen() {
        o1x.setMaxAnzahl(4 - o1.getAnzahl() - o2.getAnzahl() - o4.getAnzahl());
        o1x.setAnzahl(0, 4 - o1.getAnzahl() - o2.getAnzahl() - o4.getAnzahl());

        o1.setMaxAnzahl((o2.getAnzahl() + o4.getAnzahl() + oe2.getAnzahl()) < 4 ? 1 : 0);
        o2.setMaxAnzahl((o1.getAnzahl() + o4.getAnzahl() + oe2.getAnzahl()) < 4 ? 1 : 0);
        oe2.setMaxAnzahl((o1.getAnzahl() + o4.getAnzahl() + o2.getAnzahl()) < 4 ? 1 : 0);
        o4.setMaxAnzahl(4 - o2.getAnzahl() - o1.getAnzahl() - oe2.getAnzahl());

    }

}
