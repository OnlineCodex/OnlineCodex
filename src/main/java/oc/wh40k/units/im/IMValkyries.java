package oc.wh40k.units.im;

import oc.*;

public class IMValkyries extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o1x;
	private final OptionsZaehlerGruppe o2;
	private final OptionsZaehlerGruppe o2x;
	private final OptionsEinzelZaehler oe1;

    public IMValkyries() {
        add(ico = new oc.Picture("oc/wh40k/images/IGChimaere.jpg"));
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Valkyrie", "Valkyries", 1, 3, getPts("Valkyries"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multi-laser", getPts("Multi-laser")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon (AM)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hellstrike missiles", getPts("Hellstrike missiles")));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("2 Multiple rockt pods", getPts("Multiple rocket pod") * 2));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));


        seperator();

        add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "2 Heavy bolters", 1, getPts("Heavy bolter (AM)") * 2));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());

        o2.setMaxAnzahl(squad.getModelle());
        o2x.setMaxAnzahl(squad.getModelle() - o2.getAnzahl());
        o2x.setAnzahl(0, squad.getModelle() - o2.getAnzahl());

        oe1.setMaxAnzahl(squad.getModelle());
    }

}
