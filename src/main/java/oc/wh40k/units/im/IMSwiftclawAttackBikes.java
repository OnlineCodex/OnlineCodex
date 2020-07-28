package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMSwiftclawAttackBikes extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o1x;

    public IMSwiftclawAttackBikes() {
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Swiftclaw Attack Bike", "Swiftclaw Attack Bikes", 1, 3, getPts("Swiftclaw Attack Bike") + getPts("Twin boltgun")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy Bolter (SM other)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM other)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle());

        power = squad.getModelle() * 3;
    }

}
