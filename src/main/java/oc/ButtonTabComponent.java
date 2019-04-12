package oc;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;

/**
 * Component to be used as tabComponent;
 * Contains a JLabel to show the text and
 * a JButton to close the tab it belongs to
 */
public class ButtonTabComponent extends JPanel {

    private static final long serialVersionUID = 1L;
    private final static MouseListener buttonMouseListener = new MouseAdapter() {
        @Override
		public void mouseEntered(MouseEvent e) {
            final Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                final AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(true);
            }
        }

        @Override
		public void mouseExited(MouseEvent e) {
            final Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                final AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(false);
            }
        }
    };

    private final JTabbedPane pane;
    OnlineCodex oc;

    ButtonTabComponent(final JTabbedPane pane, final OnlineCodex oc) {
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        if (pane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.oc = oc;
        this.pane = pane;
        init();
    }

    private void init() {
        setOpaque(false);
        //make JLabel read titles from JTabbedPane
        final JLabel label = new JLabel() {
            @Override
			public String getText() {
                final int i = pane.indexOfTabComponent(ButtonTabComponent.this);
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }
        };

        add(label);
        //add more space between the label and the button
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        //tab button
        add(new TabButton());
        //add more space to the top of the component
        setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
    }

    private class TabButton extends JButton implements ActionListener {

        TabButton() {
            final int size = 17;
            setPreferredSize(new Dimension(size, size));
            setToolTipText("close this tab");
            //Make the button looks the same for all Laf's
            setUI(new BasicButtonUI());
            //Make it transparent
            setContentAreaFilled(false);
            //No need to be focusable
            setFocusable(false);
            setBorder(BorderFactory.createEtchedBorder());
            setBorderPainted(false);
            //Making nice rollover effect
            //we use the same listener for all buttons
            addMouseListener(buttonMouseListener);
            setRolloverEnabled(true);
            //Close the proper tab by clicking the button
            addActionListener(this);
        }

        @Override
		public void actionPerformed(ActionEvent e) {
            final int i = pane.indexOfTabComponent(ButtonTabComponent.this);
            if (i != -1) {
                if (oc != null) {
                    oc.removeBuilda(i - 1);
                    pane.remove(i);
                }
            }
        }

        //paint the cross
        @Override
		protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            final Graphics2D g2 = (Graphics2D) g.create();
            //shift the image for pressed buttons
            if (getModel().isPressed()) {
                g2.translate(1, 1);
            }
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);
            if (getModel().isRollover()) {
                g2.setColor(Color.MAGENTA);
            }
            final int delta = 6;
            g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
            g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
            g2.dispose();
        }
    }
}
