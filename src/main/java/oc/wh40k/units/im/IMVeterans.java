package oc.wh40k.units.im;

import oc.*;

public class IMVeterans extends Eintrag {

	private final OptionsEinzelUpgrade oe4;
	private final OptionsEinzelZaehler oe5;
	private final OptionsZaehlerGruppe o3;
	private final OptionsZaehlerGruppe o4;
	private final OptionsZaehlerGruppe o5;
	private final RuestkammerStarter kammer;

	private boolean harkerSelected = false;

    public IMVeterans() {
        name = "Veterans";
        grundkosten = (getPts("Veterans") + getPts("Frag grenade (AM)")) * 10;
        power = 5;

        add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vox-caster", getPts("Vox-caster")));

        seperator();

        ogE = IMAstraMilitarumHeavyWeapons.createRK("", "", buildaVater);
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sniper Rifle", getPts("Sniper Rifle (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Grenade Launcher", getPts("Grenade Launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (AM 3+)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun (AM 3+)")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        add(oe5 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Veteran + Schw. Flamer", "Veteran mit schwerem Flammenwerfer", 1, 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lasgun", getPts("Lasgun")));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun", getPts("Shotgun")));
        ogE.addElement(new OptionsGruppeEintrag("Autogun", getPts("Autogun")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, IMAstraMilitarumRuestkammer.class, "Veteran Sergeant");
        ((IMAstraMilitarumRuestkammer) kammer.getKammer()).setType("Veteran Sergeant");
        kammer.initKammer();
        add(kammer);
        kammer.setUeberschriftTrotzNullKostenAusgeben(true);
        kammer.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        o5.setMaxAnzahl(9 - (oe5.isSelected() ? 1 : 0) - o4.getAnzahl());
    }
}
