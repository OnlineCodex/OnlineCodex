package oc.wh40k.units.ty;

import oc.*;

public class TYTermagants extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2x;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    boolean reached30 = false;

    public TYTermagants() {
        name = "Termagants";
        grundkosten = 0;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Termagants", 10, 30, getPts("Termagants")));


        add(ico = new oc.Picture("oc/wh40k/images/TYGanten.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Fleshborer", getPts("Fleshborer")));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Devourer", getPts("Devourer")));
        ogE.addElement(new OptionsGruppeEintrag("Spinefists", getPts("Spinefists (Termagant)")));
        ogE.addElement(new OptionsGruppeEintrag("Spike rifle", getPts("Spike rifle")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Strangleweb", getPts("Strangleweb")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (others)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Termagant)")));

        complete();
    }

    @Override
    public void refreshen() {

        o2x.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - o1.getAnzahl());
        o2x.setAnzahl(0, squad.getModelle() - o2.getAnzahl() - o1.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle() / 10);

        oe1.setPreis(squad.getModelle() * getPts("Adrenal glands (others)"));
        oe2.setPreis(squad.getModelle() * getPts("Toxin sacs (Hormagaunt)"));

        if (squad.getModelle() > 20) {
            power = 9;
        } else if (squad.getModelle() > 10) {
            power = 6;
        } else {
            power = 3;
        }
    }


}
