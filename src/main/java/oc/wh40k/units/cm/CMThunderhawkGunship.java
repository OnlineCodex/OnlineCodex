package oc.wh40k.units.cm;



import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;



public class CMThunderhawkGunship extends Eintrag {



    OptionsUpgradeGruppe o1;

    OptionsUpgradeGruppe o2;

    OptionsEinzelUpgrade o3;



    public CMThunderhawkGunship() {

        name = "Chaos Space Marine Thunderhawk Gunship";

        grundkosten = 685;



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Thunderhawk Cannon", 0));

        ogE.addElement(new OptionsGruppeEintrag("Turbolaser", "Turbolaser-Destructor", 90));

        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();



        ogE.addElement(new OptionsGruppeEintrag("6 Hellstrike Missiles", 0));

        ogE.addElement(new OptionsGruppeEintrag("6 Cluster bombs", "6 Thunderhawk Cluster bombs", 60));

        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Transport", 50));





        complete();



    }



    public void refreshen() {

        o1.setSelected(0, true);

        o2.setSelected(0, true);



    }

}

