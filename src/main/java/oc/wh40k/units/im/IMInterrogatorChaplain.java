package oc.wh40k.units.im;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;

public class IMInterrogatorChaplain extends Eintrag {

    OptionsZaehlerGruppe o1;
    OptionsEinzelUpgrade jp;

    public IMInterrogatorChaplain() {
        name = "Interrogator-Chaplain";
        grundkosten = getPts("Interrogator-Chaplain") + getPts("Crozius arcanum") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
        ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
        ogE.addAll(IMSpaceMarinesCombiWeapons.createRK("", "", buildaVater));
        ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power fist", getPts("Power fist (SM)")));

        seperator();

        add(jp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump pack", getPts("Interrogator-Chaplain with Jump Pack") - getPts("Interrogator-Chaplain")));
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        if (jp.isSelected()) power = 6;
        else power = 5;
    }

}