package oc;


public class LeererEintrag extends Eintrag {


    public LeererEintrag(int breite, int höhe) {

        panel.setSize(1, 1);  // um das alte zeug zu übermalen

        panel.setBorder(null);

        panel.remove(0);

        this.setEintragsCNT(0);

    }


    //@OVERRIDE

    @Override
	public void refreshen() {
    }

}