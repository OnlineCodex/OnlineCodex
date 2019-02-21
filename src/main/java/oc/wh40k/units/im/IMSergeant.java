package oc.wh40k.units.im;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class IMSergeant extends RuestkammerVater {

    public OptionsZaehlerGruppe o3;
    private OptionsZaehlerGruppe o1;
    private OptionsZaehlerGruppe o2;
    public String type = "";

    public IMSergeant() {
        grundkosten = 0;
        name = "Sergeant";
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();

        seperator();
        if (type == "Damned Legionnaires") {
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
        } else if (type == "Vanguard Veteran Squad") {
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
        } else if (type == "Assault Squad") {
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
            if (type != "Sternguard Veteran Squad") {
                ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (others)")));
            }
            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            if (type == "Tactical Squad" || type == "Scout Bike Squad" || type == "Sternguard Veteran Squad" || type == "Bike Squad" || type == "Crusader Squad"
                    || type == "Scout Squad") {
                o1.setAnzahl(0, 1);
            } else if (type == "Company Veterans") {
                o1.setAnzahl(0, 1);
                o1.setAnzahl(3, 1);
            }

            seperator();

            if (type == "Sternguard Veteran Squad") {
                ogE.addElement(new OptionsGruppeEintrag("Special issue boltgun", getPts("Special issue boltgun")));
            }
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));

            if (type == "Scout Squad") {
                ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", getPts("Sniper rifle (SM)")));
                ogE.addElement(new OptionsGruppeEintrag("Astartes shotgun", getPts("Astartes shotgun")));
                ogE.addElement(new OptionsGruppeEintrag("Combat knife", getPts("Combat knife")));
            }

            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            if (type == "Tactical Squad" || type == "Devastator Squad" || type == "Sternguard Veteran Squad" || type == "Crusader Squad" || type == "Scout Squad") {
                o2.setAnzahl(0, 1);
            }

            if (type == "Tactical Squad" || type == "Sternguard Veteran Squad" || type == "Company Veterans" || type == "Crusader Squad") {
                seperator();

                if (type == "Tactical Squad") {
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
        if (type == "Tactical Squad" || type == "Sternguard Veteran Squad" || type == "Company Veterans" || type == "Crusader Squad") {
            o1.setMaxAnzahl(2 - o2.getAnzahl() - o3.getAnzahl() * 2);
            o2.setMaxAnzahl(o3.isSelected() ? 0 : 1);

            o3.setMaxAnzahl(o1.isSelected() || o2.isSelected() ? 0 : 1);

            legal = o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() * 2 == 2;

            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);


        } else if (type == "Devastator Squad") {
            o1.setLegal((o1.getAnzahl() + o2.getAnzahl()) == 1);
            o2.setLegal((o1.getAnzahl() + o2.getAnzahl()) == 1);
        } else if (type == "Assault Squad") {
            legal = ((o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() * 2) == 2);

            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);

            o1.setAktiv(!o3.isSelected());
            o2.setAktiv(!o3.isSelected());
            o3.setAktiv(!o1.isSelected() && !o2.isSelected());

        } else if (type == "Scout Bike Squad" || type == "Bike Squad" || type == "Ravenwing Bike Squad") {
            legal = ((o1.getAnzahl() + o2.getAnzahl()) == 1);

            o1.setLegal(legal);
            o2.setLegal(legal);

            o1.setMaxAnzahl(1 - o2.getAnzahl());
            o2.setMaxAnzahl(1 - o1.getAnzahl());
        } else if (type == "Vanguard Veteran Squad") {
            legal = (o1.getAnzahl() + o2.getAnzahl() * 2) == 2;
            o1.setLegal(legal);
            o2.setLegal(legal);
            o1.setMaxAnzahl(o2.isSelected() ? 0 : 2);
            o2.setMaxAnzahl(o1.isSelected() ? 0 : 1);
        }

        if (type == "Damned Legionnaires") {
            o1.setLegal(o1.isSelected());
            o2.setLegal(o2.isSelected());
        }
    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    public void setKosten(int kosten) {
        grundkosten = kosten;
    }


}
