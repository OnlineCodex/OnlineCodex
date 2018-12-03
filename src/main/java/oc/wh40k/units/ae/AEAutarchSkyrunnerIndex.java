package oc.wh40k.units.ae;

import oc.*;

public class AEAutarchSkyrunnerIndex extends Eintrag {
    OptionsEinzelUpgrade oe1;
    OptionsUpgradeGruppe o1, o2;
    OptionsZaehlerGruppe o3, o4, o5;

    public AEAutarchSkyrunnerIndex() {
        name = "Autarch Skyrunner";
        grundkosten = getPts("Autarch Skyrunner") + getPts("Twin shuriken catapult");
        power = 4;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Banshee mask", getPts("Banshee mask")));
        ogE.addElement(new OptionsGruppeEintrag("Mandiblasters", getPts("Mandiblaster")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Fusion pistol", getPts("Fusion pistol")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o2.setAktiv(0, true);

        seperator();

        ogE.addAll(AEAutarchWeaponsDouble.createRK("", "", buildaVater));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        
        seperator();

        ogE.addAll(AEAutarchWeaponsSingle.createRK("", "", buildaVater));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Laser lance", getPts("Laser lance")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        
        if (o4.isSelected() || o5.isSelected()) {
            o3.setMaxAnzahl(1);
        } else {
            o3.setMaxAnzahl(2);
        }

        boolean legal = (o3.getAnzahl() + o4.getAnzahl() + o5.getAnzahl()) <= 2;
        o3.setLegal(legal);
        o4.setLegal(legal);
        o5.setLegal(legal);
    }
}