package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMScoutSentinels extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o1x;
	private final OptionsEinzelZaehler oe1;
	private final OptionsEinzelZaehler oe2;

    public IMScoutSentinels() {
        name = "Scout Sentinels";
        grundkosten = 0;
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Scout Sentinel", "Scout Sentinels", 1, 3, getPts("Scout Sentinels"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multi-laser", getPts("Multi-laser")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", getPts("Heavy flamer (AM other)")));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", getPts("Autocannon (AM non-infantry)")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher (AM other)")));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon (AM other)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sentinel chainsaw", 1, getPts("Sentinel chainsaw")));
        add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Hunter-killer missile", 1, getPts("Hunter-killer missile (AM)")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());

        oe1.setMaxAnzahl(squad.getModelle());
        oe2.setMaxAnzahl(squad.getModelle());

        power = 2 * squad.getModelle();
    }
}