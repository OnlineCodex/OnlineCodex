package oc.wh40k.units.im;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class IMSergeant extends RuestkammerVater {

    public OptionsZaehlerGruppe o3;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    private final String type;

    public IMSergeant(String type) {
        this.type = type;
        name = "Sergeant";
        checkBuildaVater();

        seperator();
        if ("Damned Legionnaires".equals(this.type)) {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setAnzahl(0, 1);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setAnzahl(0, 1);
        } else if ("Vanguard Veteran Squad".equals(this.type)) {
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
            ogE.addElement(new OptionsGruppeEintrag("Relic blade", getPts("Relic blade")));
            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
            o1.setAnzahl(0, 1);
            o1.setAnzahl(3, 1);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        } else if ("Assault Squad".equals(this.type)) {
            ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o1.setAnzahl(0, 1);

            seperator();

            ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setAnzahl(0, 1);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Eviscerator", getPts("Eviscerator")));
            ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
            add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combat shield", getPts("Combat shield")));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", getPts("Melta bombs")));

        } else {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Grav-pistol", getPts("Grav-pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            if (buildaVater.getFormationType().equals("Blood Angels"))
                ogE.addElement(new OptionsGruppeEintrag("Hand flamer", getPts("Hand flamer (BA)")));
            if (!"Sternguard Veteran Squad".equals(this.type)) {
                ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (others)")));
            }
            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            if ("Tactical Squad".equals(this.type) ||
                    "Scout Bike Squad".equals(this.type) ||
                    "Sternguard Veteran Squad".equals(this.type) ||
                    "Bike Squad".equals(this.type) ||
                    "Crusader Squad".equals(this.type) ||
                    "Scout Squad".equals(this.type)) {
                o1.setAnzahl(0, 1);
            } else if ("Company Veterans".equals(this.type)) {
                o1.setAnzahl(0, 1);
                o1.setAnzahl(3, 1);
            }

            seperator();

            if ("Sternguard Veteran Squad".equals(this.type)) {
                ogE.addElement(new OptionsGruppeEintrag("Special issue boltgun", getPts("Special issue boltgun")));
            }
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));

            if ("Scout Squad".equals(this.type)) {
                ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", getPts("Sniper rifle (SM)")));
                ogE.addElement(new OptionsGruppeEintrag("Astartes shotgun", getPts("Astartes shotgun")));
                ogE.addElement(new OptionsGruppeEintrag("Combat knife", getPts("Combat knife")));
            }

            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            if ("Tactical Squad".equals(this.type) ||
                    "Devastator Squad".equals(this.type) ||
                    "Sternguard Veteran Squad".equals(this.type) ||
                    "Crusader Squad".equals(this.type) ||
                    "Scout Squad".equals(this.type)) {
                o2.setAnzahl(0, 1);
            }

            if ("Tactical Squad".equals(this.type) ||
                    "Sternguard Veteran Squad".equals(this.type) ||
                    "Company Veterans".equals(this.type) ||
                    "Crusader Squad".equals(this.type)) {
                seperator();

                if ("Tactical Squad".equals(this.type)) {
                    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", getPts("Melta bombs")));
                }

                ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
                add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
            }

        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if ("Tactical Squad".equals(type) ||
                "Sternguard Veteran Squad".equals(type) ||
                "Company Veterans".equals(type) ||
                "Crusader Squad".equals(type)) {
            o1.setMaxAnzahl(2 - o2.getAnzahl() - o3.getAnzahl() * 2);
            o2.setMaxAnzahl(o3.isSelected() ? 0 : 1);

            o3.setMaxAnzahl(o1.isSelected() || o2.isSelected() ? 0 : 1);

            legal = o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() * 2 == 2;

            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);


        } else if ("Devastator Squad".equals(type)) {
            o1.setLegal((o1.getAnzahl() + o2.getAnzahl()) == 1);
            o2.setLegal((o1.getAnzahl() + o2.getAnzahl()) == 1);
        } else if ("Assault Squad".equals(type)) {
            legal = ((o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() * 2) == 2);

            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);

            o1.setAktiv(!o3.isSelected());
            o2.setAktiv(!o3.isSelected());
            o3.setAktiv(!o1.isSelected() && !o2.isSelected());

        } else if ("Scout Bike Squad".equals(type) ||
                "Bike Squad".equals(type) ||
                "Ravenwing Bike Squad".equals(type)) {
            legal = ((o1.getAnzahl() + o2.getAnzahl()) == 1);

            o1.setLegal(legal);
            o2.setLegal(legal);

            o1.setMaxAnzahl(1 - o2.getAnzahl());
            o2.setMaxAnzahl(1 - o1.getAnzahl());
        } else if ("Vanguard Veteran Squad".equals(type)) {
            legal = (o1.getAnzahl() + o2.getAnzahl() * 2) == 2;
            o1.setLegal(legal);
            o2.setLegal(legal);
            o1.setMaxAnzahl(o2.isSelected() ? 0 : 2);
            o2.setMaxAnzahl(o1.isSelected() ? 0 : 1);
        }

        if ("Damned Legionnaires".equals(type)) {
            o1.setLegal(o1.isSelected());
            o2.setLegal(o2.isSelected());
        }
    }

    public void setKosten(int kosten) {
        grundkosten = kosten;
    }
}