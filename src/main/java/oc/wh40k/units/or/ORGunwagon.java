package oc.wh40k.units.or;

import oc.*;

public class ORGunwagon extends Eintrag {

	private final OptionsUpgradeGruppe fk;
	private final OptionsZaehlerGruppe fk2;

    public ORGunwagon() {

        name = "Gunwagon";
        grundkosten = getPts("Gunwagon");
        power = 9;

        add(ico = new oc.Picture("oc/wh40k/images/Kampfpanza.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kannon", getPts("Kannon")));
        ogE.addElement(new OptionsGruppeEintrag("Killkannon", getPts("Killkannon")));
        ogE.addElement(new OptionsGruppeEintrag("Zzap gun", getPts("Zzap gun")));
        add(fk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
        add(fk2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deff rolla", getPts("Deff rolla")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "'Ard Case", getPts("'Ard Case")));
        
        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grabbin' klaw", getPts("Grabbin' klaw")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot rigger", getPts("Grot rigger")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lobba", getPts("Lobba")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb chukka", getPts("Stikkbomb chukka")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin' ball", getPts("Wreckin' ball")));

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        fk.alwaysSelected();
    }
}
