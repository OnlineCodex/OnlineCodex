package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMSanguinaryGuard extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o2;
	private final OptionsZaehlerGruppe o1def;
	private final OptionsZaehlerGruppe o2def;
	private final OptionsEinzelUpgrade masken;

    public IMSanguinaryGuard() {
        name = "Sanguinary Guard\n";
        grundkosten = 0;
        applyTitle = true;

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
