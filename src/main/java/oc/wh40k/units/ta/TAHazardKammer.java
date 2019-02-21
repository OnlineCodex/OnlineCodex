package oc.wh40k.units.ta;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

//[IA3 2nd Ed]

public class TAHazardKammer extends RuestkammerVater {

	private OptionsZaehlerGruppe o1;
	private OptionsZaehlerGruppe o1def;
	private OptionsUpgradeGruppe o2;
	private OptionsZaehlerGruppe o3;

    public TAHazardKammer() {
        grundkosten = 75;
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("TL Burst cannon", "Twin-linked burst cannon", 0));
        add(o1def = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Phased Ion Gun", 10));
        ogE.addElement(new OptionsGruppeEintrag("Fusion Cascade", 15));
        ogE.addElement(new OptionsGruppeEintrag("Pulse Sub-Rifle", "Pulse Subminitions Rifle", 20));
        add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Drone controller", 8));
        ogE.addElement(new OptionsGruppeEintrag("Target lock", 5));
        ogE.addElement(new OptionsGruppeEintrag("Shield generator", 25));
        ogE.addElement(new OptionsGruppeEintrag("Advanced targetting system", 3));
        ogE.addElement(new OptionsGruppeEintrag("Counterfire defence system", 5));
        ogE.addElement(new OptionsGruppeEintrag("Early warning override", 5));
        ogE.addElement(new OptionsGruppeEintrag("Positional relay", 5));
        ogE.addElement(new OptionsGruppeEintrag("Stimulant injector", 25));
        ogE.addElement(new OptionsGruppeEintrag("Velocity tracker", 20));
        add(o2 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohne", 12));
        ogE.addElement(new OptionsGruppeEintrag("Schilddrohne", 12));
        ogE.addElement(new OptionsGruppeEintrag("Markerdrohne", 12));
        add(o3 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1def.setMaxAnzahl(2 - o1.getAnzahl());
        o1def.setAnzahl(0, 2 - o1.getAnzahl());

        o3.setMaxAnzahl(o2.isSelected("Drone controller") ? 2 : 0);
    }

}
