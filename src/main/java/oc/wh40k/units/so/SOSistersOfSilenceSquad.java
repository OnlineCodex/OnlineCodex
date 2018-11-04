package oc.wh40k.units.so;

import oc.*;

public class SOSistersOfSilenceSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;

    public SOSistersOfSilenceSquad() {
        name = "Sororitastrupp\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Sisters", 5, 10, 15);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ASSororitastrupp.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 2));
        ogE.addElement(new OptionsGruppeEintrag("Greatsword", "Executioner Greatsword", 0));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setAnzahl(0, squad.getModelle());

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sister Superior", 10));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
    }

}
