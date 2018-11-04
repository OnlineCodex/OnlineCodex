package oc.wh40k.units.im;

import oc.*;

public class IMCrusaderSquad extends Eintrag {

    AnzahlPanel Initiates;
    AnzahlPanel Neophytes;
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsZaehlerGruppe o3;
    OptionsZaehlerGruppe o3x;
    OptionsZaehlerGruppe o4;
    OptionsZaehlerGruppe o4x;
    RuestkammerStarter rkBoss;

    public IMCrusaderSquad() {
        name = "Crusader Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        Initiates = new AnzahlPanel(ID, randAbstand, cnt, "Initiates", 5, 10, getPts("Crusader Squad"));
        add(Initiates);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun + Bolt pistol", getPts("Boltgun (SM)") + getPts("Bolt pistol (SM)")));
        add(o3x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword + BP", "Chainsword + Bolt pistol", getPts("Chainsword (SM)") + getPts("Bolt pistol (SM)")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addAll(IMSpaceMarinesSpecialWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addAll(IMSpaceMarinesHeavyWeapons.createRK("", "", buildaVater));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        Neophytes = new AnzahlPanel(ID, randAbstand, cnt, "Neophyt", "Neophytes", 0, 10, getPts("Crusader Squad - Neophyte"));
        Neophytes.setNichtDieErsteOption(true);
        add(Neophytes);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun + Bolt pistol", getPts("Boltgun (SM)") + getPts("Bolt pistol (SM)")));
        add(o4x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun + BP", "Astartes shotgun + Bolt pistol", getPts("Astartes Shotgun") + getPts("Bolt pistol (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Combat knife + BP", "Combat knife + Bolt pistol", getPts("Combat knife") + getPts("Bolt pistol (SM)")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IMSergeant", "Sword Brother");
        ((IMSergeant) rkBoss.getKammer()).type = "Crusader Squad";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Sword Brother"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {

        o3.setMaxAnzahl(Initiates.getModelle() - (rkBoss.isSelected() ? 1 : 0) - (o1.isSelected() ? 1 : 0) - (o2.isSelected() ? 1 : 0));
        o2.setMaxAnzahl((Initiates.getModelle() - (rkBoss.isSelected() ? 1 : 0) - o3.getAnzahl() - (o1.isSelected() ? 1 : 0)) > 0 ? 1 : 0);
        o1.setMaxAnzahl((Initiates.getModelle() - (rkBoss.isSelected() ? 1 : 0) - o3.getAnzahl() - (o2.isSelected() ? 1 : 0)) > 0 ? 1 : 0);

        o3x.setMaxAnzahl(Initiates.getModelle() - (rkBoss.isSelected() ? 1 : 0) - o3.getAnzahl() - (o1.isSelected() ? 1 : 0) - (o2.isSelected() ? 1 : 0));
        o3x.setAnzahl(0, Initiates.getModelle() - (rkBoss.isSelected() ? 1 : 0) - o3.getAnzahl() - (o1.isSelected() ? 1 : 0) - (o2.isSelected() ? 1 : 0));

        o4x.setMaxAnzahl(Neophytes.getModelle() - o4.getAnzahl());
        o4x.setAnzahl(0, Neophytes.getModelle() - o4.getAnzahl());
        o4.setMaxAnzahl(Neophytes.getModelle());

        power = 5;
        if (Initiates.getModelle() > 5) {
            power += 4;
        }
        if (Neophytes.getModelle() > 0) {
            power += 3;
        }

        if (Neophytes.getModelle() > 5) {
            power += 3;
        }
    }

}
