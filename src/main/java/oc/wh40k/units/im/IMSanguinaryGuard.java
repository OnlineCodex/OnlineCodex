package oc.wh40k.units.im;

import oc.*;

public class IMSanguinaryGuard extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe o2def;
    OptionsEinzelUpgrade masken;

    public IMSanguinaryGuard() {
        name = "Sanguinary Guard\n";
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Sanguinary Guard", 5, 10, getPts("Sanguinary Guard")));

        seperator();

        add(masken = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Death masks", getPts("Death mask")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Angelus Boltgun", getPts("Angelus Boltgun")));
        add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
        ogE.addElement(new OptionsGruppeEintrag("Inferno Pistol", getPts("Inferno Pistol (BA)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Encarmine sword", getPts("encarmine sword")));
        add(o2def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
        ogE.addElement(new OptionsGruppeEintrag("Encarmine axe", getPts("encarmine axe")));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        complete();
    }

    @Override
    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());
        o2.setMaxAnzahl(squad.getModelle());

        o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl());

        o2def.setMaxAnzahl(squad.getModelle() - o2.getAnzahl());
        o2def.setAnzahl(0, squad.getModelle() - o2.getAnzahl());

        masken.setPreis(squad.getModelle() * getPts("Death mask"));

        power = 10;
        if (squad.getModelle() > 4) {
            power = 22;
        }
    }

}
