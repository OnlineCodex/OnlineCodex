package oc.wh40k.units.gk;

import oc.*;

public class GKGreyknightThunderhawkGunship extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o1a;
    OptionsZaehlerGruppe o1b;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;

    public GKGreyknightThunderhawkGunship() {
        name = "Thunderhawk Gunship";
        grundkosten = 750;

        add(ico = new oc.Picture("oc/wh40k/images/Thunderhawk.gif"));

        ogE.addElement(new OptionsGruppeEintrag("6 Heavy bombs", "6 heavy bombs", 60));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o1.setSelected(0, true);

        ogE.addElement(new OptionsGruppeEintrag("Hellstrike missiles", 0));
        add(o1a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 6));
        ogE.addElement(new OptionsGruppeEintrag("Mindstrike missiles", 0));
        add(o1b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 6));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Thunderhawk cannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Turbo-laser destructor", 90));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL heavy bolters", 0));
        ogE.addElement(new OptionsGruppeEintrag("TL psycannons", 40));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psybolt ammunition", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flare/chaff launcher", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured cockpit", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Illum flares", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Paint scheme", "Distinctive paint scheme or markings", 10));

        complete();

    }

    public void refreshen() {
        if (!o2.isSelected()) o2.setSelected(0, true);
        if (!o3.isSelected()) o3.setSelected(0, true);

        o1a.setAktiv(!o1.isSelected());
        o1b.setAktiv(!o1.isSelected());

        o1a.setMaxAnzahl(6 - o1b.getAnzahl());
        o1a.setAnzahl(0, 6 - o1b.getAnzahl());
    }
}
