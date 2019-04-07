package oc.wh40k.units.ty;



import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;



public class TYCultChimera extends Eintrag {



    private final OptionsUpgradeGruppe o1;

    private final OptionsUpgradeGruppe o2;

    private final OptionsUpgradeGruppe o1x;

    private final OptionsUpgradeGruppe o2x;

    private final OptionsEinzelUpgrade oe1;

    private final OptionsEinzelUpgrade oe2;



    public TYCultChimera() {

        grundkosten = getPts("Cult Chimera") + getPts("Lasgun array") * 2;

        power = 5;



        ogE.addElement(new OptionsGruppeEintrag("Multi-laser", getPts("Multi-laser")));

        add(o1x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter")));

        add(o2x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy Flamer")));

        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));



        seperator();



        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile")));



        seperator();



        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter")));

        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy stubber", getPts("Heavy stubber")));



        complete();

    }



    @Override

    public void refreshen() {

        oe1.setAktiv(!oe2.isSelected());

        oe2.setAktiv(!oe1.isSelected());



        o1x.setSelected(0, !o1.isSelected());

        o2x.setSelected(0, !o2.isSelected());

    }



}

