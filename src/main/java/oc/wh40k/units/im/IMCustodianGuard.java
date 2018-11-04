package oc.wh40k.units.im;

import oc.*;

public class IMCustodianGuard extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1, o2;
    OptionsEinzelUpgrade o3;

    public IMCustodianGuard() {
        name = "Custodian Guard\n";
        grundkosten = 0;
        überschriftSetzen = true;


        squad = new AnzahlPanel(ID, randAbstand, cnt, "Custodian Guard", 3, 10, getPts("Custodian Guard"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Guardian Spear", getPts("Guardian spear (AC)")));
        ogE.addElement(new OptionsGruppeEintrag("Sentinel Blade & Storm Shield", getPts("Sentinel blade") + getPts("Storm shield (AC)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setAnzahl(0, squad.getModelle());

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Misericordia", getPts("Misericordia")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o2.setMaxAnzahl(squad.getModelle());

        o1.setLegal(squad.getModelle() == o1.getAnzahl());

        power = 8 + ((squad.getModelle() - 3) * 3);
    }
}
