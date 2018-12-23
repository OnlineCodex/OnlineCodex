package oc.wh40k.units.im;

import oc.*;

public class IMAstraMilitarumRuestkammer extends RuestkammerVater {

    private final String type;

    private OptionsUpgradeGruppe o1;
    private OptionsUpgradeGruppe o2;
    private OptionsZaehlerGruppe o5;

    public IMAstraMilitarumRuestkammer(String type) {
        this.type = type;

        checkBuildaVater();

        if ("Company Commander".equals(this.type) ||
                "Platoon Commander".equals(this.type)) {
            ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMAstraMilitarumRangedWeapons.createRK("Laspistol", "Laspistol", buildaVater);
            ogE.addElement(new OptionsGruppeEintrag("Shotgun", getPts("Shotgun")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if ("Lord Commissar".equals(this.type) ||
                "Commissar".equals(this.type)) {
            ogE = IMAstraMilitarumMeleeWeapons.createRK("Power sword", "Power sword (AM)", buildaVater);
            add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
            if ("Lord Commissar".equals(this.type)) {
                o5.setAnzahl(0, 1);
            }
            seperator();

            ogE = IMAstraMilitarumRangedWeapons.createRK("Bolt pistol", "Bolt pistol (AM)", buildaVater);
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if ("Sergeant".equals(this.type)) {

            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (AM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe [INDEX]", getPts("Power axe (AM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul [INDEX]", getPts("Power maul (AM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (AM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMAstraMilitarumRangedWeapons.createRK("Laspistol", "Laspistol", buildaVater);
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if ("Veteran Sergeant".equals(this.type)) {
            ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMAstraMilitarumRangedWeapons.createRK("Laspistol", "Laspistol", buildaVater);
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if ("Temperstor Prime".equals(this.type)) {
            ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Hot-shot laspistol", getPts("Hot-shot laspistol")));
            ogE.addElement(new OptionsGruppeEintrag("Tempestus command rod", getPts("Tempestus command rod")));
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (AM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (AM)")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if ("Tempestor".equals(this.type)) {
            ogE = IMAstraMilitarumMeleeWeapons.createRK("Chainsword", "Chainsword (AM)", buildaVater);
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Hot-shot laspistol", getPts("Hot-shot laspistol")));
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (AM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (AM)")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {

        if ("Company Commander".equals(type) ||
                "Platoon Commander".equals(type) ||
                "Sergeant".equals(type) ||
                "Veteran Sergeant".equals(type) ||
                "Tempestor".equals(type)) {

            o1.alwaysSelected();
            o2.alwaysSelected();
        } else if ("Lord Commissar".equals(type) || "Commissar".equals(type)) {
            if ("Lord Commissar".equals(type)) {
                o5.setLegal(o5.getAnzahl() > 0);
            }
            o2.alwaysSelected();
        } else if ("Temperstor Prime".equals(type)) {
            o2.alwaysSelected();
        }

    }
}