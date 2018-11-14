package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;

public class ORGretchin extends Eintrag {

    AnzahlPanel squad;

    public ORGretchin() {
        kategorie = 3;
        grundkosten = 0;
        
        addToInformationVector("Gretchin Infantry", 1);

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Gretchin", 10, 30, getPts("Gretchin")));
        add(ico = new oc.Picture("oc/wh40k/images/Grotz.gif"));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 20) {
            power = 4;
        } else if (squad.getModelle() > 10) {
            power = 2;
        } else {
            power = 1;
        }
    }
    
    @Override
    public void deleteYourself(){
        addToInformationVector("Gretchin Infantry", -1);
    }
}
