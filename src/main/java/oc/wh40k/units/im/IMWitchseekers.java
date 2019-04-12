package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMWitchseekers extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsEinzelUpgrade superior;

    public IMWitchseekers() {
        name = "Witchseekers\n";
        grundkosten = 0;
        applyTitle = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Witchseekers", 5, 10, getPts("Witchseekers"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ASSororitastrupp.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (AMI)")));
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
