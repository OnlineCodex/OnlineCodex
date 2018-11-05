package oc.wh40k.units.ec;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ECCorsairBaron extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsEinzelUpgrade jetpack;
    OptionsEinzelUpgrade dancer;
    OptionsEinzelUpgrade drugs;
    OptionsEinzelUpgrade key;
    OptionsEinzelUpgrade master;
    OptionsEinzelUpgrade rage;
    OptionsEinzelUpgrade fnp;

    public ECCorsairBaron() {
        name = "Corsair Baron";
        grundkosten = 30;

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairPrince.jpg"));

        seperator();

        add(dancer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cloud Dancer", 15));
        ogE.addElement(new OptionsGruppeEintrag("TL Lasblaster", 0));
        ogE.addElement(new OptionsGruppeEintrag("TL Shuriken catapult", 0));
        ogE.addElement(new OptionsGruppeEintrag("TL Splinter rifles", 0));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wild Psyker", 15));

        seperator();

        add(jetpack = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair Jet Pack", 5));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Haywire Grenades", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tanglefield Grenades", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 15));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Venom blade", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blast pistol", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fusion pistol", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dissonance pistol", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Void sabre", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Balelight", 15));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Voidplate harness", 15));
        ogE.addElement(new OptionsGruppeEintrag("Ghostplate armour", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shimmershield", 15));
        ogE.addElement(new OptionsGruppeEintrag("Forceshield", 10));
        ogE.addElement(new OptionsGruppeEintrag("Shadowfield", 25));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(drugs = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combat drugs", 15));
        add(key = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multiph. key gen.", "Multiphase key generator", 15));
        add(master = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "master-crafted", 10));
        add(rage = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rage SR", 0));
        add(fnp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "FNP(5+) SR", 10));

        complete();
    }

    @Override
    public void refreshen() {
        o4.setAktiv(dancer.isSelected());

        if (!o4.isSelected()) {
            o4.setSelected(0, true);
        }

        dancer.setAktiv(!jetpack.isSelected());
        jetpack.setAktiv(!dancer.isSelected());
        drugs.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 0);
        key.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 1);
        master.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 2);
        rage.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 3);
        fnp.setAktiv(getCountFromInformationVector("ECPrinceTrait") == 5);
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}
