package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMCenturionDevastatorSquad extends Eintrag {

	private final  OptionsEinzelZaehler o1;
	private final  OptionsEinzelZaehler o1x;
	private final  OptionsZaehlerGruppe o2;
	private final  OptionsZaehlerGruppe o2x;
	private final AnzahlPanel squad;

    public IMCenturionDevastatorSquad() {
        name = "Centurion Devastator Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Centurions", 3, 6, getPts("Centurion Devastator Squad"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/SMTerminatorSturmtrupp.jpg"));

        seperator();

        add(o1x = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Hurricane bolter", -88, getPts("Hurricane bolter")));
        add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Centurion m. launcher", "Centurion missile launcher", -88, getPts("Centurion missile launcher")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 heavy bolters", getPts("heavy bolter (SM)") * 2));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("2 lascannons", getPts("Lascannon (SM)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Grav-cannon", "Grav-cannon and grav-amp", getPts("Grav-cannon and grav-amp")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        complete();
    }

    @Override
    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1x.setAnzahl(squad.getModelle() - o1.getAnzahl());

        o2.setMaxAnzahl(squad.getModelle());
        o2x.setMaxAnzahl(squad.getModelle() - o2.getAnzahl());
        o2x.setAnzahl(0, squad.getModelle() - o2.getAnzahl());

        power = 17;
        if (squad.getModelle() > 3) {
            power = 34;
        }

    }

}
