package oc.wh40k.units.rh_ia13;

import oc.*;

public class RH_IA13RenegadeSentinelSquadron extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsEinzelZaehler oe2;
    OptionsEinzelUpgrade mt;

    public RH_IA13RenegadeSentinelSquadron() {
        name = "Renegade Sentinel Squadron\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Scout Sentinel", "Scout Sentinels", 3, 6, 20);
        squad.setGrundkosten(0);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/RHScoutSentinelSquadron.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multi-laser", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", 5));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 5));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Multiple rocket pod", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Hunter-killer missile", 3, 10));

        seperator();

        add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Militia Training", 40));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Smoke launchers", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 50));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Heavy Armour", 80));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());

        oe2.setMaxAnzahl(squad.getModelle());

        if (getCountFromInformationVector("RHBloodyHandedReaver") == 1) {
            mt.setSelected(true);
        }
    }

}
