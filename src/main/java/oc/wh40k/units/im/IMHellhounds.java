package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMHellhounds extends Eintrag {

	private final OptionsZaehlerGruppe o1;
    private final OptionsZaehlerGruppe o2;
    private final OptionsZaehlerGruppe o3;
    private final OptionsZaehlerGruppe o2x;
    private final OptionsEinzelZaehler oe1, oe2, oe3, oe4;

    public IMHellhounds() {
        name = "Hellhounds";

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hellhound", getPts("Hellhounds") + getPts("Inferno Cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Devil Dog", getPts("Hellhounds") + getPts("Melta Cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Bane Wolf", getPts("Hellhounds") + getPts("Chem Cannon")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AM)")));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy Flamer (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (AM)")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Augur array", 1, getPts("Augur array")));
        add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Dozer blade", 1, getPts("Dozer blade")));
        add(oe3 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Hunter-killer missile", 1, getPts("Hunter-killer missile (AM)")));
        add(oe4 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Track guards", 1, getPts("Track guards")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (AM)")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", getPts("Heavy stubber")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));


        complete();
    }

    @Override
    public void refreshen() {
        o2.setMaxAnzahl(o1.getAnzahl());
        o2x.setMaxAnzahl(o1.getAnzahl());
        o2x.setAnzahl(0, o1.getAnzahl() - o2.getAnzahl());

        if (!o1.isSelected()) {
            o1.setAnzahl(0, 1);
        }

        oe1.setMaxAnzahl(o1.getAnzahl());
        oe2.setMaxAnzahl(o1.getAnzahl());
        oe3.setMaxAnzahl(o1.getAnzahl());
        oe4.setMaxAnzahl(o1.getAnzahl());

        o3.setMaxAnzahl(o1.getAnzahl());

        power = o1.getAnzahl() * 6;
    }

}
