package oc.wh40k.units.im;

import oc.*;

public class IMVigilators extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsEinzelUpgrade superior;

    public IMVigilators() {
        name = "Vigilators\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Vigilators", 5, 10, getPts("Vigilators"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ASSororitastrupp.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Executioner greatblade", getPts("Executioner greatblade")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(superior = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sister Superior", getPts("Sister Superior")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o1.setAnzahl(0, squad.getModelle());
        superior.setSelected(true);
    }

}
