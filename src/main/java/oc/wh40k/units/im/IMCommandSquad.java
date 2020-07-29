package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMCommandSquad extends Eintrag {

	private final OptionsZaehlerGruppe o3;
	private final OptionsZaehlerGruppe o4;
	private final OptionsZaehlerGruppe o5;
	private final OptionsEinzelZaehler oe1;
	private final OptionsEinzelZaehler oe2;
	private final OptionsEinzelZaehler oe3;
	private final OptionsEinzelZaehler oe4;


    public IMCommandSquad() {
        name = "Command Squad";
        grundkosten = getPts("Command Squad") * 4;
        power = 3;

        add(oe1 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Medi-pack", 1, getPts("Medi-pack")));
        add(oe2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Regimental standard", 1, getPts("Regimental standard")));
        add(oe3 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vox-caster", 1, getPts("Vox-caster")));
        add(oe4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Heavy Flamer", 1, getPts("Heavy Flamer (AM INFANTRY)")));

        seperator();

        ogE = IMAstraMilitarumHeavyWeapons.createRK("", "", buildaVater);
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sniper Rifle", getPts("Sniper Rifle (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Grenade Launcher", getPts("Grenade Launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (AM 3+)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun (AM 3+)")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lasp. + Chainsw.", getPts("Laspistol") + getPts("Chainsword (AM)")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 4));

        complete();
    }

    @Override
    public void refreshen() {
        final int selectedVeterans = oe1.getAnzahl() + oe2.getAnzahl() + oe3.getAnzahl() + oe4.getAnzahl() + (o3.isSelected() ? 2 : 0);
        o4.setMaxAnzahl(4 - selectedVeterans);

        o3.setMaxAnzahl((oe1.getAnzahl() + oe2.getAnzahl() + oe3.getAnzahl() + oe4.getAnzahl() + o4.getAnzahl()) < 3 ? 1 : 0);
        o5.setMaxAnzahl(4 - oe4.getAnzahl() - o4.getAnzahl());

    }

}
