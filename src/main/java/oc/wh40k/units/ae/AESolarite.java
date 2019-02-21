package oc.wh40k.units.ae;



import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

import oc.RuestkammerVater;



public class AESolarite extends RuestkammerVater {



	private OptionsUpgradeGruppe o1;



    public AESolarite() {

    }



    @Override

    public void initButtons(boolean... defaults) {

        ogE.addElement(new OptionsGruppeEintrag("Shardcarbine", getPts("Shardcarbine")));

        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol", getPts("Splinter Pistol")));

        ogE.addElement(new OptionsGruppeEintrag("Blast pistol", getPts("Blast pistol")));

        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol & venom blade", getPts("Splinter pistol") + getPts("Venom blade")));

        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol & power lance", getPts("Splinter pistol") + getPts("Power lance")));

        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol & agoniser", getPts("Splinter pistol") + getPts("Agoniser")));

        ogE.addElement(new OptionsGruppeEintrag("Blast pistol & venom blade", getPts("Blast pistol") + getPts("Venom blade")));

        ogE.addElement(new OptionsGruppeEintrag("Blast pistol & power lance", getPts("Blast pistol") + getPts("Power lance")));

        ogE.addElement(new OptionsGruppeEintrag("Blast pistol & agoniser", getPts("Blast pistol") + getPts("Agoniser")));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        o1.setSelected(0, true);



        sizeSetzen();

    }



    @Override

    public void refreshen() {

        o1.setLegal(o1.isSelected());

    }



}

