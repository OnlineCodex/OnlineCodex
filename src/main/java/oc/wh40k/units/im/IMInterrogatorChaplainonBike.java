package oc.wh40k.units.im;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;

public class IMInterrogatorChaplainonBike extends Eintrag {

	private final OptionsZaehlerGruppe o1;

    public IMInterrogatorChaplainonBike() {
        name = "Interrogator-Chaplain on Bike";
        grundkosten = getPts("Interrogator-Chaplain on Bike") + getPts("Crozius arcanum") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 7;

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
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}