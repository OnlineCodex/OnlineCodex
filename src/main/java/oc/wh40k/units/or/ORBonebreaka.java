package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORBonebreaka extends Eintrag {

	private final OptionsEinzelUpgrade deffrolla;

    public ORBonebreaka() {

        name = "Bonebreaka";
        grundkosten = getPts("Bonebreaka");
        power = 9;

        add(ico = new oc.Picture("oc/wh40k/images/Kampfpanza.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Kannon", getPts("Kannon")));
        ogE.addElement(new OptionsGruppeEintrag("Killkannon", getPts("Killkannon")));
        ogE.addElement(new OptionsGruppeEintrag("Zzap gun", getPts("Zzap gun")));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        add(deffrolla = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deff rolla", getPts("Deff rolla")));
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
    @Override
	public void refreshen() {
        deffrolla.setSelected(true);
    }
}
